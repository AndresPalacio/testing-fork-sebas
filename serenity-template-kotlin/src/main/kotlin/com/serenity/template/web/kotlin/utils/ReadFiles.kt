package com.serenity.template.web.kotlin.utils


import java.io.FileInputStream
import java.util.Properties
import org.slf4j.LoggerFactory
import net.thucydides.model.environment.SystemEnvironmentVariables

object ReadFiles {

    private const val PROPERTIES_EXTENSION = ".properties"
    private val LOGGER = LoggerFactory.getLogger(ReadFiles::class.java)
    private val CONF = SystemEnvironmentVariables.createEnvironmentVariables()

    @JvmStatic
    fun getRootPropertiesFile(fileName: String): Properties {

        val properties = Properties()

        try {
            FileInputStream("$fileName$PROPERTIES_EXTENSION").use { fileInputStream ->
                properties.load(fileInputStream)
            }

        } catch (e: Exception) {
            LOGGER.error("Failure reading properties file $fileName$PROPERTIES_EXTENSION")
        }

        return properties
    }

    @JvmStatic
    fun getPropertiesFile(fileName: String): Properties {

        val properties = Properties()

        try {
            properties.load(ReadFiles::class.java.getResourceAsStream("/properties/$fileName$PROPERTIES_EXTENSION"))
        } catch (e: Exception) {
            LOGGER.error("Failure reading properties file $fileName$PROPERTIES_EXTENSION")
        }

        return properties
    }

    @JvmStatic
    fun getConfig(key: String): String? {
        val config = CONF.getProperty(key)

        if (config != null) {
            LOGGER.info("Config found! '$key': $config")
        } else {
            LOGGER.error("Config not found! '$key'")
        }

        return config
    }

}