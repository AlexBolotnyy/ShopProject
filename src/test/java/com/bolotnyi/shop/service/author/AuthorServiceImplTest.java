package com.bolotnyi.shop.service.author;

import com.bolotnyi.shop.repository.purchase.PurchaseRepository;
import com.bolotnyi.shop.service.purchase.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
class PurchaseServiceTest {
    @Autowired
    private PurchaseService authorService;
    @Autowired
    private PurchaseRepository authorRepository;

    @Test
    void testThrowsExceptionAndRollback() {

    }
}