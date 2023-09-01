package com.avaldigitallabs.facilpass.stepdefinitions;

import com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile;
import com.avaldigitallabs.facilpass.navigation.Navigate;
import com.avaldigitallabs.facilpass.task.session.Session;
import com.avaldigitallabs.facilpass.ui.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.time.Duration;

import static com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile.getValueByKey;


public class LoginStepDefinition {
    public PropertiesFile propertiesFile = new PropertiesFile();
    public static String accessTokenBO;
    public static String idType;
    public static String id;
    public static String idDynamo;
    @Given("{actor} is an {}")
    public void nimbusIsAnUserListAvailable(Actor actor, String testDataKey) {
        propertiesFile.getPropertyFile(testDataKey.replaceAll(" ","_").toLowerCase());
    }

    @And("{actor} is on the login page")
    public void nimbusIsOnTheLoginPage(Actor actor) {
        actor.attemptsTo(
                Navigate.toLoginPage()
        );
    }

    @When("{actor} logs in with {} and valid credentials")
    public void heLogsInWithRolAndValidCredentials(Actor actor, String actorRol) {
        idType = getValueByKey(actorRol,"idType");
        id = getValueByKey(actorRol,"id");
        idDynamo = getValueByKey(actorRol,"idDynamo");
        actor.attemptsTo(
                //Login.as(rol),
                Session.loginAs(actorRol)
        );
    }

    @Then("{actor} should see the dashboard")
    public void heShouldSeeTheDashboard(Actor actor) {
        actor.attemptsTo(
                Ensure.that(DashboardPage.DASHBOARD_LINK_NAV.waitingForNoMoreThan
                        (Duration.ofSeconds(30))).isEnabled()
        );
        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        accessTokenBO = (String) jse.executeScript(String.
                format("return window.localStorage.getItem('%s');","token"));
//        accessTokenBO = (String) actor.asksFor(Evaluate.javascript("window.localStorage.getItem('token')").result().asString());
    }

    @When("{actor} logs out")
    public void heLogsOut(Actor actor) {
        actor.attemptsTo(
                Session.logout()
        );
    }

    @Then("{actor} should see the login page")
    public void heShouldSeeTheLoginPage(Actor actor) {
        actor.attemptsTo(
                Session.loginFormIsVisible()
        );
    }

    @Then("{actor} should see an error message for non existing user")
    public void heShouldSeeAnErrorMessageForNonExistingUser(Actor actor) {
        actor.attemptsTo(
            Session.errorMessage()
        );
    }
}
