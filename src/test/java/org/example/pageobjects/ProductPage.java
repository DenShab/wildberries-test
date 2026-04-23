package org.example.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import org.testng.Assert;

@Slf4j
public class ProductPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@data-testid='264220770']//button[@aria-label='Добавить в корзину']")
    private WebElement addToCartButton;


    @FindBy(xpath = "//a[@data-testid='basket-header']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//a[@data-testid='basket-header']//span[@class='navbar-pc__notify']")
    private WebElement notify;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Добавить продукт в корзину")
    public ProductPage addToCart() {
        addToCartButton.click();
        log.info("Клик по кнопке 'Добавить в корзину'");
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        goToCartButton.click();
        log.info("Клик по кнопке 'Корзина'");
        return new CartPage(driver);
    }

    @Step("Проверить наличие продукта в корзине")
    public boolean isProductInCart() {
        return notify.isDisplayed();
    }
}