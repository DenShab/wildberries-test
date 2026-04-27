package org.example.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public ProductPage addToCart() {
        addToCartButton.click();
        log.info("Клик по кнопке 'Добавить в корзину'");
        return this;
    }

    public CartPage goToCart() {
        goToCartButton.click();
        log.info("Клик по кнопке 'Корзина'");
        return new CartPage(driver);
    }

    public boolean isProductInCart() {
        return notify.isDisplayed();
    }
}