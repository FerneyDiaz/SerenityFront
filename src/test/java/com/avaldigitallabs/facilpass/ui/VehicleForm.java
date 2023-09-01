package com.avaldigitallabs.facilpass.ui;

import com.avaldigitallabs.facilpass.helper.randomData.RandomData;
import net.serenitybdd.screenplay.targets.Target;


import static com.avaldigitallabs.facilpass.helper.propertiesFile.PropertiesFile.getValueByKey;
import static com.avaldigitallabs.facilpass.task.vehicle.CreateVehicle.licensePlate;

public class VehicleForm {
    public static Target COMPONENT_VEHICLE_TITLE = Target.the("title component vehicle").
            locatedBy("//nb-card-body/fp-table[1]/p-table[1]/div[1]/div[1]//div[contains(text(),'Lista de Veh')]");
    public static Target CREATE_BUTTON = Target.the("button create vehicle").
            locatedBy("//nb-card-body//button[@label='Crear']");
    public static Target ID_TYPE_INPUT = Target.the("id type input").
            locatedBy("/html[1]/body[1]/div[3]/div[1]/div[2]/fp-create-vehicle[1]/div[1]/form[1]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]//span[contains(text(),'Seleccione')]");
    public static Target ID_TYPE_OPTIONS_INPUT = Target.the("options from id type input (CC,CE and NIT)").
            locatedBy("/html[1]/body[1]/div[4]/div[1]/ul[1]/cdk-virtual-scroll-viewport[1]/div[1]/p-dropdownitem//span[contains(text(),'{0}.')]");
    public static Target ID_INPUT = Target.the("id input").
            locatedBy("//body/div[3]//input[@idinput='documentNumber']");
    public static Target ACCOUNT_INPUT = Target.the("account input").
            locatedBy("//body/div[3]//input[@formcontrolname='accountFP']");
    public static Target LICENSE_PLATE_INPUT = Target.the("license plate input").
            locatedBy("//body/div[3]//input[@idinput='licensePlate']");
    public static Target KIND_OF_VEHICLE_RADIO_BUTTON = Target.the("kind of vehicle radio button").
            locatedBy("//body/div[3]//button[@id='type"+ RandomData.generateRandomNumber(1,9)+"']");
    public static Target CREATE_VEHICLE_BUTTON = Target.the("create vehicle button inside form").
            locatedBy("//body/div[3]//button[@id='buttonContinue']");
    public static Target CREATE_SUCCESS_MESSAGE = Target.the("create vehicle successfully message").
            locatedBy("//div[contains(text(),'El Vehiculo con placa "+licensePlate+" se ha creado exito')]");


}
