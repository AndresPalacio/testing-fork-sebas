package com.serenity.template.web.kotlin.utils

import com.serenity.template.web.kotlin.utils.constants.Defaults
import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actors.Cast
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.Stage

object SerenitySession {

    fun createActor(actorName: String? = null) {
        OnStage.setTheStage(Stage(Cast.ofStandardActors()))
        OnStage.theActor(actorName ?: Defaults.ACTOR_NAME)
    }
    

    fun createActorForWeb(url: String, actorName: String? = null) {
        OnStage.setTheStage(
            Cast.whereEveryoneCan(
                BrowseTheWeb.with(
                    DriverManager.start(url)
                )
            )
        )
        OnStage.theActor(actorName ?: Defaults.ACTOR_NAME)
    }

    fun <T> get(key: String): T {
        return Serenity.sessionVariableCalled(key)
    }

    fun <T> set(key: String, value: T) {
        Serenity.setSessionVariable(key).to(value)
    }
}