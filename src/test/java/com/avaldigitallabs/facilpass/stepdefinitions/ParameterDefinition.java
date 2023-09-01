package com.avaldigitallabs.facilpass.stepdefinitions;

import com.avaldigitallabs.facilpass.helper.dynamo.DynamoConnection;
import com.avaldigitallabs.facilpass.lambdatest.LambdaTestScenario;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.steps.StepEventBus;
//import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import static com.avaldigitallabs.facilpass.stepdefinitions.LoginStepDefinition.idDynamo;

public class ParameterDefinition {

    DynamoConnection dynamoConnection = new DynamoConnection();

    @ParameterType(".*")
    public Actor actor(String actorName){
        return OnStage.theActorCalled(actorName);
    }
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @AfterScenario
    public void afterScenario(){
        new LambdaTestScenario().apply(
                SystemEnvironmentVariables.createEnvironmentVariables(),
                StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome(),
                ThucydidesWebDriverSupport.getWebdriverManager().getCurrentDriver());
        if ((!idDynamo.isEmpty()) ){
            dynamoConnection.updateBooleanElement("fap-logins","id", idDynamo,"sessionActive",Boolean.FALSE);
            System.out.println("Session out successfully");
        }
    }

}
