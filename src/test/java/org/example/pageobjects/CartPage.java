package org.example.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import org.testng.Assert;

@Slf4j
public class CartPage {


    @FindBy(xpath = "//div[@data-testid='basket-page']//div[@class='list-item__wrap']")
    private WebElement cartItem;


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @Step("Проверить наличие продукта в корзине")
    public boolean isProductInCart() {
        return cartItem.isDisplayed();
    }
}