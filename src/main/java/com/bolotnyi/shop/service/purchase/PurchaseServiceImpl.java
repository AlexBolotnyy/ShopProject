package com.bolotnyi.shop.service.purchase;

import com.bolotnyi.shop.model.basket.dto.BasketShowDto;
import com.bolotnyi.shop.model.purshase.Purchase;
import com.bolotnyi.shop.model.purshase.dto.PurchaseHistoryDto;
import com.bolotnyi.shop.model.user.ShopUser;
import com.bolotnyi.shop.repository.user.UserRepository;
import com.bolotnyi.shop.service.auth.CustomUserDetailsService;
import com.bolotnyi.shop.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final BookService bookService;
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createNewPurchase() {
        ShopUser user = userDetailsService.getCurrentUser();
        BasketShowDto showDto = bookService.getBasketShowDto();
        user.insertPurchase(getPurchase(user, showDto));
        bookService.incrementBooksAmount(showDto, user.getBasket());
        userRepository.save(user);
        bookService.clearBasket();
    }

    @Override
    public List<PurchaseHistoryDto> getPurchaseHistory() {
        return null;
    }

    private Purchase getPurchase(ShopUser user, BasketShowDto showDto) {
        Purchase purchase = new Purchase();
        purchase.setBookList(user.getBasket());
        purchase.setTotalPrice(showDto.getTotalPrice());
        purchase.setDate(new Date());
        purchase.setUser(user);
        return purchase;
    }


}
