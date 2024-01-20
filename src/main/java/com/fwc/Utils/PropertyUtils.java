package com.fwc.Utils;

import com.fwc.enums.ConfigEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    // read the content from property file and store it in Map--> approach is read once and store to collection and reuse Map

    private static Properties properties= new Properties();
    private static Map<String,String> map= new LinkedHashMap<>();

    static{

        try( FileInputStream fs= new FileInputStream("")) {
            properties.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.entrySet().stream().forEach(e -> map.put((String)e.getKey(),(String)e.getValue()));

    }

    public static String getMapValue(ConfigEnum key){
        return map.get(key);
    }

}
