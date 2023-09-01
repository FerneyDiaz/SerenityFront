package com.avaldigitallabs.facilpass.helper.dynamo.fapLogins;


import com.avaldigitallabs.facilpass.helper.dynamo.DynamoConnection;

public class FapLogin {
    DynamoConnection dynamoConnection = new DynamoConnection();

    private String id;
    private Boolean sessionActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(Boolean sessionActive) {
        this.sessionActive = sessionActive;
    }

    @Override
    public String toString() {
        return "FapLogin{" +
                "id='" + id + '\'' +
                ", sessionActive=" + sessionActive +
                '}';
    }
}
