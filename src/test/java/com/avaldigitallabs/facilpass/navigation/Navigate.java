package com.avaldigitallabs.facilpass.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    public static Performable toLoginPage() {
        return Task.where(
                Open.browserOn().the(LoginPage.class)
        );
    }

    public static Performable toVehicleComponent() {
        return Open.url("https://fap-commons-stg.avaldigitallabs.com/#/pages/management/vehicles");
    }
}
