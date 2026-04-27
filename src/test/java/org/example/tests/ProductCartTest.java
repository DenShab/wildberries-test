package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.CartPage;
import org.example.pageobjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductCartTest extends TestBase {

    // аннотации были для отчетов Allure и тмс
    // пронимаю что требований таких не было, это скорее дело привычки и задел на будущее
    // убрал чтоб не смущали
    //
    @Test(testName = "Добавление товара в корзину")
    public void testProductAddToCart() {
        final ProductPage productPage = new ProductPage(driver);
        productPage
                .addToCart();
        Assert.assertTrue(productPage.isProductInCart(), "Оповещение корзины не появилось");
        final CartPage cartPage = productPage
                .goToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Товар отсутствует");

    }
}