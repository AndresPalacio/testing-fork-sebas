package com.serenity.template.web.stepdefinitions.hooks;

import com.serenity.template.web.utils.DriverManager;
import com.serenity.template.web.utils.SerenitySession;
import com.serenity.template.web.utils.constants.Defaults;
import com.serenity.template.web.utils.constants.GenericConstants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.az.Ohalda;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Stage;
import org.junit.Before;

public class StageHook {

    @BeforeAll
    public static void setUp() {
        SerenitySession.createActor(Defaults.ACTOR_NAME);
    }

    @BeforeAll
    public static void startSession() {
        SerenitySession.createActorForWeb(GenericConstants.URL, Defaults.ACTOR_NAME);
    }

    @AfterAll(order = 0)
    public static void stopSession() {
        DriverManager.stop();
    }


}
