package com.avaldigitallabs.facilpass.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {

    public static Target CC_RADIO_BUTTON = Target.the("CC radio button").locatedBy("#type1");
    public static Target CE_RADIO_BUTTON = Target.the("CE radio button").locatedBy("#type2");

    public static Target ID_FIELD = Target.the("Field ID").locatedBy("#identificacion");
    public static Target PASSWORD_FIELD = Target.the("Field password").locatedBy("#password");

    public static Target LOGIN_BUTTON = Target.the("Login button").locatedBy("#buttonContinue");

    public static Target ERROR_MESSAGE_BY_NON_EXISTING_USER = Target.the("Error message for non existing user")
            .locatedBy("//div[contains(text(),'No fue posible continuar con el proceso')]");

    public static Target LOGOUT_BUTTON = Target.the("log out button")
            .locatedBy("//body/app-root/app-pages/app-layout/nb-layout//span[contains(text(),'Cerrar sesi')]");

    public static Target USER_IN_SESSION = Target.the("user in session container")
            .locatedBy("//div[@class='user-container']");
}
