package com.bolotnyi.shop.service.book;

import com.bolotnyi.shop.model.author.Author;
import com.bolotnyi.shop.model.basket.dto.BasketPositionShowDto;
import com.bolotnyi.shop.model.basket.dto.BasketShowDto;
import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book.dto.BookCreateDto;
import com.bolotnyi.shop.model.book.dto.BookFilterDto;
import com.bolotnyi.shop.model.book.dto.BookShowDto;
import com.bolotnyi.shop.model.book.dto.BookUpdateDto;
import com.bolotnyi.shop.model.exception.BusinessException;
import com.bolotnyi.shop.model.genre.Genre;
import com.bolotnyi.shop.model.user.ShopUser;
import com.bolotnyi.shop.repository.author.AuthorRepository;
import com.bolotnyi.shop.repository.book.BookCustomRepository;
import com.bolotnyi.shop.repository.book.BookRepository;
import com.bolotnyi.shop.repository.genre.GenreRepository;
import com.bolotnyi.shop.repository.user.UserRepository;
import com.bolotnyi.shop.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import com.bolotnyi.shop.service.auth.CustomUserDetailsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookCustomRepository bookCustomRepository;
    private final GenreRepository genreRepository;
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;


    @Override
    public void addNewBook(BookCreateDto createDto) {
        checkExist(createDto.getTitle());
        Book book = new Book();
        book.setTitle(createDto.getTitle());
        book.setPublishDate(getPublishDate(createDto.getPublishDate()));
        book.setAuthor(getAuthor(createDto.getAuthorId()));
        book.setAmount(Optional.ofNullable(createDto.getAmount()).orElse(0L));
        book.setPrice(createDto.getPrice());
        book.insertGenre(genreRepository.getGenresById(createDto.getGenresList()));
        bookRepository.save(book);
    }

    private void checkExist(String title) {
        if (bookRepository.findByTitle(title.toUpperCase()).isPresent()) {
            throw new BusinessException("Книга с таким наименованием уже существует");
        }
    }

    @Override
    public void updateExist(BookUpdateDto updateDto) {
        Book book = bookRepository.findById(updateDto.getId())
                .orElseThrow(() -> new BusinessException("Не обнаружена книга с id " + updateDto.getId()));
        book.setAmount(book.getAmount() + updateDto.getAmount());
        bookRepository.save(book);
    }

    @Override
    public List<BookShowDto> getCatalog(BookFilterDto filterDto) {
        return bookCustomRepository.getListByFilter(filterDto).stream()
                .map(this::mapToShowDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addBookToBasket(Long id) {
        ShopUser user = userDetailsService.getCurrentUser();
        user.insertBookIntoBasket(getBookById(id));
        userRepository.save(user);
    }

    @Override
    public BasketShowDto getBasketShowDto() {
        BasketShowDto result = new BasketShowDto();
        List<BasketPositionShowDto> basketPositionShowDtoList = getBasketPositionShowDtoList();
        BigDecimal totalPrice = getTotalPrice(basketPositionShowDtoList);
        result.setShowDto(basketPositionShowDtoList);
        result.setTotalPrice(totalPrice);
        return result;
    }

    private BigDecimal getTotalPrice(List<BasketPositionShowDto> basketPositionShowDtoList) {
        return basketPositionShowDtoList.stream()
                .map(i -> i.getShowDto().getPrice().multiply(new BigDecimal(i.getAmount().toString())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<BasketPositionShowDto> getBasketPositionShowDtoList() {
        return userDetailsService.getCurrentUser().getBasket().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(i -> new BasketPositionShowDto(i.getValue(), mapToShowDto(i.getKey())))
                .collect(Collectors.toList());
    }

    @Override
    public void removeBookFromBasket(Long bookId) {
        ShopUser user = userDetailsService.getCurrentUser();
        user.removeBookFromBasket(getBookById(bookId));
        userRepository.save(user);
    }

    @Override
    public void incrementBooksAmount(BasketShowDto basketShowDto, List<Book> basket) {
        bookRepository.saveAll(getUpdatedBookList(basketShowDto, basket));
    }

    private List<Book> getUpdatedBookList(BasketShowDto basketShowDto, List<Book> basket) {
        return basket
                .stream()
                .peek(i -> i.setAmount(i.getAmount() - getFreshAmount(i.getId(), basketShowDto)))
                .collect(Collectors.toList());
    }

    private Long getFreshAmount(Long id, BasketShowDto basketShowDto) {
        return basketShowDto.getShowDto().stream()
                .filter(i -> i.getShowDto().getId().equals(id))
                .map(BasketPositionShowDto::getAmount)
                .findAny()
                .orElse(0L);
    }

    @Override
    public void clearBasket() {
        ShopUser user = userDetailsService.getCurrentUser();
        user.clearBasket();
        userRepository.save(user);
    }

    private Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Выбранная книга отсутствует в каталоге"));
    }

    private BookShowDto mapToShowDto(Book book) {
        BookShowDto showDto = new BookShowDto();
        showDto.setId(book.getId());
        showDto.setTitle(book.getTitle());
        showDto.setAuthorName(book.getAuthor().getNmFull());
        showDto.setGenresList(book.getGenreList().stream().map(Genre::getName).collect(Collectors.toList()));
        showDto.setAmount(book.getAmount());
        showDto.setPrice(book.getPrice());
        return showDto;
    }

    private Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new BusinessException("Автор с айди " + authorId + " не найден"));
    }

    private Date getPublishDate(String title) {
        return DateUtils.getDateByString(title);
    }
}
