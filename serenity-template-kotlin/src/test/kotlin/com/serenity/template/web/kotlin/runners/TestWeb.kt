package com.serenity.template.web.kotlin.runners

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    glue = ["com.serenity.template.web.kotlin.stepdefinitions"],
    features = ["src/test/resources/features/test_web.feature"],
    snippets = CucumberOptions.SnippetType.CAMELCASE)
class TestWeb