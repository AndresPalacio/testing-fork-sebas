package com.serenity.template.web.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;

public class TestWebStepDefinitions {

    @Given("test")
    public void test() {
        OnStage.theActorInTheSpotlight().wasAbleTo();
    }

    @Given("test2")
    public void test2() {
        OnStage.withCurrentActor();
    }

    @Given("test3")
    public void test3() {
        OnStage.theActorInTheSpotlight().should();
    }
}
