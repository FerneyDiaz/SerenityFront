package com.avaldigitallabs.facilpass.task.session;

import com.avaldigitallabs.facilpass.ui.LoginForm;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile.getValueByKey;
import static com.avaldigitallabs.facilpass.stepdefinitions.LoginStepDefinition.idType;
import static com.avaldigitallabs.facilpass.stepdefinitions.LoginStepDefinition.id;

public class Session {
    public static Performable loginAs(String rol) {
        if (idType.equalsIgnoreCase("CE")){
            return Task.where( "Login as {0} and fill out login form",
                    Click.on(LoginForm.CE_RADIO_BUTTON).afterWaitingUntilPresent(),
                    Enter.theValue(id).into(LoginForm.ID_FIELD),
                    Enter.theValue(getValueByKey(rol,"password")).into(LoginForm.PASSWORD_FIELD),
                    Click.on(LoginForm.LOGIN_BUTTON)
            );
        }else {
            return Task.where( "Login as {0} and fill out login form",
                    Click.on(LoginForm.CC_RADIO_BUTTON).afterWaitingUntilPresent(),
                    Enter.theValue(id).into(LoginForm.ID_FIELD),
                    Enter.theValue(getValueByKey(rol,"password")).into(LoginForm.PASSWORD_FIELD),
                    Click.on(LoginForm.LOGIN_BUTTON)
            );
        }

    }

    public static Performable logout() {
        return Task.where(
                Click.on(LoginForm.USER_IN_SESSION).afterWaitingUntilPresent(),
                Click.on(LoginForm.LOGOUT_BUTTON).afterWaitingUntilPresent()
        );
    }

    public static Performable loginFormIsVisible() {
        return Task.where(
                WaitUntil.the(LoginForm.LOGIN_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable errorMessage() {
        return Task.where(
                Ensure.that(LoginForm.ERROR_MESSAGE_BY_NON_EXISTING_USER.waitingForNoMoreThan(
                        Duration.ofSeconds(30))).isDisplayed()
        );
    }
}
