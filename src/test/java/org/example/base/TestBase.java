package org.example.base;

import lombok.extern.slf4j.Slf4j;
import org.example.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class TestBase {
    protected WebDriver driver;
    private final TestConfig config = new TestConfig();

    private String homeUrl;

    @BeforeMethod
    public void setUp() {
        driver = config.createDriver();
        homeUrl = config.getHomeUrl();
        driver.get(homeUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Драйвер успешно закрыт");
        }
    }
}