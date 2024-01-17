package com.fwc.Utils;


import com.github.javafaker.Faker;

import static com.fwc.Utils.FakerUtils.*;


public final class RandomUtils {

    // business layer --> all the business level changes

    private RandomUtils(){

    }

    public static int getNumber(){
        return FakerUtils.getRandomNumber(1,500);
    }
    public static String getFirstname(){
        return FakerUtils.getFirstName().toLowerCase();
    }
    public static String getLastname(){
        return FakerUtils.getLastName().toLowerCase();
    }
}
