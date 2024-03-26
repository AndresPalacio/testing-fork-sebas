package com.serenity.template.web.kotlin.utils

import com.serenity.template.web.kotlin.utils.constants.GenericConstants
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object DriverManager {

    private val LOGGER: Logger = LoggerFactory.getLogger(DriverManager::class.java)
    private var driver: WebDriver? = null

    fun start(url: String): WebDriver {
        return when (ReadFiles.getConfig(GenericConstants.BROWSER)) {
            GenericConstants.CHROME -> {
                driver = getChromeDriver()
                driver?.get(url)
                driver?.manage()?.window()?.maximize()

                driver as WebDriver
            }

            else -> throw IllegalArgumentException("Browser not supported!")
        }
    }

    fun stop() {
        if (driver != null) {
            driver?.quit()
            LOGGER.info("Driver closed!")
        }
    }

    fun getWebDriver(): WebDriver {
        return driver as WebDriver
    }

    private fun getChromeDriver(): WebDriver {

        val chromeOptions = ChromeOptions()

        chromeOptions.addArguments(
            "--incognito",
            "--disable-infobars",
            "enable-automation",
            "--disable-browser-side-navigation"
        )

        return WebDriverManager.chromedriver().capabilities(chromeOptions).create()
    }

}