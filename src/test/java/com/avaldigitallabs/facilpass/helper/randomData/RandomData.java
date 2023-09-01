package com.avaldigitallabs.facilpass.helper.randomData;

import java.util.Random;

public class RandomData {

    public static String generateRandomLicensePlate(){
        String licensePlate = generateRandomData(false,4)+
                generateRandomData(true,4);
        return licensePlate;
    }

    public static String generateRandomData(Boolean generateNumbers, int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String stringToConvert;
        if(generateNumbers){stringToConvert = numbers;}
        else {stringToConvert = alphabet;}
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < length){
            int index = (int) (random.nextFloat() * stringToConvert.length());
            stringBuilder.append(stringToConvert.charAt(index));
        }
        String randomString = stringBuilder.toString();
        return randomString;
    }
    public static int generateRandomNumber(int min, int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
