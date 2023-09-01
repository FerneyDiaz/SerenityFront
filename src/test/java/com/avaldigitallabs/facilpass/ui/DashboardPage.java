package com.avaldigitallabs.facilpass.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage {
    public static Target DASHBOARD_LINK_NAV = Target.the("Dashboard option in vertical nav")
            .locatedBy("[title='Dashboard']");
    public static Target LOGOUT_LINK = Target.the("Logout option")
            .locatedBy("//span[contains(text(),'Cerrar sesión')]");
    public static Target USER_IN_SESSION_CONTAINER = Target.the("Container of user in session")
            .locatedBy("[class=user-container]");
}
