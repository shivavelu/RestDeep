package com.fwc.Utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    // Service layer --> all service level implementations

    private FakerUtils(){

    }
   private static final Faker faker= new Faker();

    public static int getRandomNumber(int start, int end){
        return faker.number().numberBetween(start,end);
    }

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }
}
