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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
        log.info("Драйвер успешно создан");
        return driver;
    }

}