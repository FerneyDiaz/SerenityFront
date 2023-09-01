package com.avaldigitallabs.facilpass.backend.model;

public class DeleteVehicle {

    private String accountId;
    private String plate;
    private String licensePlate;
    private String personId;
    private String tagId;

    public DeleteVehicle(String accountId, String plate, String licensePlate, String personId) {
        this.accountId = accountId;
        this.plate = plate;
        this.licensePlate = licensePlate;
        this.personId = personId;
    }

    public DeleteVehicle(String accountId, String plate, String licensePlate, String personId, String tagId) {
        this.accountId = accountId;
        this.plate = plate;
        this.licensePlate = licensePlate;
        this.personId = personId;
        this.tagId = tagId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "{"
                + "\"accountId\":\"" + accountId + "\""
                + ", \"plate\":\"" + plate + "\""
                + ", \"licensePlate\":\"" + licensePlate + "\""
                + ", \"personId\":\"" + personId + "\""
                + "}";
    }
}
