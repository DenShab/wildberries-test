package org.example.tests;

import io.qameta.allure.*;
import org.example.base.TestBase;
import org.example.pageobjects.CartPage;
import org.example.pageobjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class ProductCartTest extends TestBase {

    @Test(testName = "Добавление товара в корзину")
    @Description("Добавление товара в корзину")
    @Severity(CRITICAL)
    @Owner("Бойчук Денис")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
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