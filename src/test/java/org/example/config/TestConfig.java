package org.example.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Getter
@Slf4j
public class TestConfig {
    private final String homeUrl = "https://www.wildberries.by/catalog/264220770/detail.aspx";

    public WebDriver createDriver() {
        // Проблема с дравером была в этом, но драйвер я прикладывал.
        // Убрал System.setProperty("webdriver.chrome.driver"... пусть Selenium Manager работает
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
        log.info("Драйвер успешно создан");
        return driver;
    }

}