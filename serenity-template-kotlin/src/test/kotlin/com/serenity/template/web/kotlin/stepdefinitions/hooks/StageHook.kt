package com.serenity.template.web.kotlin.stepdefinitions.hooks

import com.serenity.template.web.kotlin.utils.DriverManager
import com.serenity.template.web.kotlin.utils.SerenitySession
import com.serenity.template.web.kotlin.utils.constants.GenericConstants
import io.cucumber.java.AfterAll
import io.cucumber.java.BeforeAll

object StageHook {

    @BeforeAll
    fun setUp() {
        SerenitySession.createActor()
    }

    @BeforeAll()
    fun startSession() {
        SerenitySession.createActorForWeb(GenericConstants.URL)
    }

    @AfterAll(order = 0)
    fun stopSession() {
        DriverManager.stop()
    }
}