package com.avaldigitallabs.facilpass.stepdefinitions;

import com.avaldigitallabs.facilpass.backend.RequestMethodBO;
import com.avaldigitallabs.facilpass.backend.model.DeleteVehicle;
import com.avaldigitallabs.facilpass.navigation.Navigate;
import com.avaldigitallabs.facilpass.task.vehicle.CreateVehicle;
import com.avaldigitallabs.facilpass.ui.VehicleForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile.getValueByKey;

public class VehicleStepDefinition {
    @And("{actor} is on the vehicles component")
    public void heIsOnTheVehiclesComponent(Actor actor) {
        actor.attemptsTo(
                Navigate.toVehicleComponent()
        );
    }

    @Then("{actor} should see the vehicle component")
    public void heShouldSeeTheVehicleComponent(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(VehicleForm.CREATE_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(40).seconds()
        );
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("{actor} create a vehicle")
    public void heCreateAVehicle(Actor actor) {
        actor.attemptsTo(
                CreateVehicle.asBackOfficeUser()
        );
    }

    @Then("{actor} should see an successful creation message")
    public void heShouldSeeAnSuccessfulCreationMessage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(VehicleForm.CREATE_SUCCESS_MESSAGE.waitingForNoMoreThan(Duration.ofSeconds(40)))
                        .isDisplayed()
        );
    }

    @Then("{actor} delete vehicle created")
    public void heDeleteVehicleCreated(Actor actor) {
        DeleteVehicle deleteVehicle = new DeleteVehicle(CreateVehicle.accountClient,
                CreateVehicle.licensePlate,CreateVehicle.licensePlate,
                getValueByKey("vehicle","personId"));
        RequestMethodBO.postRequest(LoginStepDefinition.accessTokenBO,deleteVehicle);
    }
}
