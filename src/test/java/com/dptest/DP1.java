package com.dptest;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class DP1 {

/*
Object[][] is not always the return type
In case of a for loop, able to run one iteration when assertion fails- 1/10, where as Data provide run
All the iterations completely 10/10 times.
 */
    @Test
    public void run(){
        for(int i=0; i<10;i++) {
            System.out.println("HI");
            Assertions.assertThat(true).isEqualTo(false);
        }
    }

    @Test(dataProvider = "getData1")
    public void logindummy1(String users){
        System.out.println(users);

    }

    @DataProvider
    public Object[] getData1(){

        //3*1
        return new Object[]{
                "user1", "user2","user3"
        };


    }
    @Test(dataProvider = "getData2")
    public void logindummy2(String user,String password,String admin){
        System.out.println(user+":"+password+":"+admin);

    }
    @DataProvider
    public Object[][] getData2(){
         //3*3
        return new Object[][]{
                {"user1","password1","admin"},{"use2","password2","admin"},{"user3","password3","admin"}

        };
    }
    /*
    If the number of input increase it would be challenge to manage and maintain arugements to test method,
    hence we should look for the aleternative approach, here you go with Map, each input set store in a Map
    and store all of them into the List (list of Map) pass this List object as data provider, by which we can
    overcome the issue in manage more no. of arguments, passing one argument would be sufficient.
     */
    @Test(dataProvider = "getData3")
    public void logindummy3(Map<String,String> data){

        System.out.println(data.get("username")+":"+data.get("password")+":"+data.get("role"));

    }
    // Data provide return either Object[], object[][] or Iterator
    @DataProvider
    public Iterator<Map<String, String>> getData3(){
       Map<String,String> dataMap1= new HashMap<>();
       dataMap1.put("username","username1");
       dataMap1.put("password","password1");
       dataMap1.put("role","admin");

       Map<String,String> dataMap2= new HashMap<>();
        dataMap2.put("username","username2");
        dataMap2.put("password","password2");
        dataMap2.put("role","Superadmin");

        Map<String,String> dataMap3= new HashMap<>();
        dataMap3.put("username","username3");
        dataMap3.put("password","password3");
        dataMap3.put("role","User1");

        return Arrays.asList(dataMap1, dataMap2, dataMap3).iterator();

    }
}
