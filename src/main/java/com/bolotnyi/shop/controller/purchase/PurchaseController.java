package com.bolotnyi.shop.controller.purchase;
import com.bolotnyi.shop.model.basket.dto.BasketShowDto;
import com.bolotnyi.shop.model.book.dto.BookFilterDto;
import com.bolotnyi.shop.model.book.dto.BookShowDto;
import com.bolotnyi.shop.model.purshase.dto.PurchaseHistoryDto;
import com.bolotnyi.shop.service.book.BookService;
import com.bolotnyi.shop.service.purchase.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
@Tag(name = "Покупка")
public class PurchaseController {
    private final BookService bookService;
    private final PurchaseService purchaseService;

    @PostMapping("/create-purchase")
    @Operation(summary = "Совершить покупку")
    public void createPurchase() {
        purchaseService.createNewPurchase();
    }

    @PostMapping("/purchase-history")
    @Operation(summary = "История заказов")
    public List<PurchaseHistoryDto> getPurchaseHistory() {
        return purchaseService.getPurchaseHistory();
    }

    @GetMapping("/catalog")
    @Operation(summary = "Получение каталога книг")
    public List<BookShowDto> catalog(@ParameterObject BookFilterDto filterDto) {
        return bookService.getCatalog(filterDto);
    }

    @PutMapping("/add-to-basket")
    @Operation(description = "Добавить товар в корзину")
    public void addBookToBasket(Long id) {
        bookService.addBookToBasket(id);
    }

    @GetMapping("/basket")
    @Operation(summary = "Корзина")
    public BasketShowDto getBasket() {
        return bookService.getBasketShowDto();
    }

    @DeleteMapping("/remove-from-basket")
    @Operation(summary = "Удалить товар из корзины")
    public void removeBookFromBasket(Long bookId) {
        bookService.removeBookFromBasket(bookId);
    }

    @DeleteMapping("/clear-basket")
    @Operation(summary = "Очистить корзину")
    public void clearBasket(Long bookId) {
        bookService.clearBasket();
    }
}
