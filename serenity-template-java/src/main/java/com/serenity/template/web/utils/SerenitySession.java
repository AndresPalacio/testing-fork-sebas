package com.serenity.template.web.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.Stage;

public class SerenitySession {
    public static void createActor(String actorName) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(actorName);
    }

    public static void createActorForWeb(String url, String actorName) {
        OnStage.setTheStage(
                Cast.whereEveryoneCan(
                        BrowseTheWeb.with(DriverManager.start(url))
                )
        );
        OnStage.theActor(actorName);
    }

    public static <T> T get(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static <T> void set(String key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }
}
