package com.avaldigitallabs.facilpass.task.vehicle;

import com.avaldigitallabs.facilpass.helper.randomData.RandomData;
import com.avaldigitallabs.facilpass.ui.VehicleForm;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile.getValueByKey;

public class CreateVehicle {

    //idType, id, account, licensePlate, kindOfVehicle
    public static String licensePlate = RandomData.generateRandomLicensePlate();
    public static String idClient;
    public static String accountClient;

    public static Performable asBackOfficeUser() {
        idClient = getValueByKey("vehicle","id");
        accountClient=getValueByKey("vehicle","account");
        return Task.where(
                "{0} create a vehicle",
                Click.on(VehicleForm.CREATE_BUTTON).afterWaitingUntilPresent(),
                WaitUntil.the(VehicleForm.ID_TYPE_INPUT, WebElementStateMatchers.isPresent()).forNoMoreThan(10).seconds(),
                Click.on(VehicleForm.ID_TYPE_INPUT),
                Click.on(VehicleForm.ID_TYPE_OPTIONS_INPUT.of(getValueByKey("vehicle","idType"))),
                Enter.theValue(idClient).into(VehicleForm.ID_INPUT),
                Enter.theValue(accountClient).into(VehicleForm.ACCOUNT_INPUT),
                Enter.theValue(licensePlate).into(VehicleForm.LICENSE_PLATE_INPUT),
                Click.on(VehicleForm.KIND_OF_VEHICLE_RADIO_BUTTON),
                Click.on(VehicleForm.CREATE_VEHICLE_BUTTON)
        );
    }
}
