package com.serenity.template.web.utils;

import com.serenity.template.web.utils.constants.GenericConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);
    private static WebDriver driver = null;

    public static WebDriver start(String url) {
        switch (ReadFiles.getConfig(GenericConstants.BROWSER)) {
            case GenericConstants.CHROME:
                driver = getChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                return driver;

            default:
                throw new IllegalArgumentException("Browser not supported!");
        }
    }

    public static void stop() {
        if (driver != null) {
            driver.quit();
            LOGGER.info("Driver closed!");
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "--incognito",
                "--disable-infobars",
                "enable-automation",
                "--disable-browser-side-navigation"
        );

        return WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }
}
