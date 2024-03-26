import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Versions {
    const val SERENITY = "4.0.30"
    const val APPIUM = "9.0.0"
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

plugins {
    id("java-library")
    id("idea")
    id("maven-publish")
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.30"
    kotlin("jvm") version "1.9.10"
}

group = "serenity.kotlin.template"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    api("io.appium:java-client:${Versions.APPIUM}")
    api("net.serenity-bdd:serenity-screenplay:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-core:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-junit:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-cucumber:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-rest-assured:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-ensure:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-screenplay-rest:${Versions.SERENITY}")
    api("com.googlecode.json-simple:json-simple:1.1.1")
    api("org.apache.poi:poi-ooxml:5.2.4")
    api("com.jayway.jsonpath:json-path:2.9.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    api("de.vandermeer:asciitable:0.3.2")
    api("io.github.bonigarcia:webdrivermanager:5.6.2")
    api("org.slf4j:slf4j-simple:2.0.9")
}

serenity {
    testRoot = "serenity-template-kotlin"
    requirementsBaseDir = "src/test/resources/features"
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks{
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}