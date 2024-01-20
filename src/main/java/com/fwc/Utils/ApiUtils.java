package com.fwc.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fwc.constants.FCSingleton;
import com.fwc.constants.FrameworkConstants;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public final class ApiUtils {

    private ApiUtils(){

    }
    @SneakyThrows
    public static String readJsonToString(String filePath){
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @SneakyThrows
    public static String modifyFilePayloadNode(String fileName, String fieldName, String newValue){
        ObjectMapper objectMapper= new ObjectMapper();
        // getpath using FrameworkConstatns
        File file= new File(FrameworkConstants.getREQ_INPUT_PATH()+fileName);
        JsonNode jsonNode = objectMapper.readTree(file);
        ((ObjectNode)jsonNode).put(fieldName, newValue);
       return objectMapper.writeValueAsString(jsonNode);
    }
    @SneakyThrows
    public static String modifyFilePayloadNode(String fileName, Map<String, Object> modification){
        ObjectMapper objectMapper= new ObjectMapper();
        // getpath from Frameworksingleton
        File file= new File(FCSingleton.getSInstance().getRequestInputPath() +fileName);
        for(Map.Entry<String,Object> entry: modification.entrySet()){
            String fieldName=entry.getKey();
            Object newValue=entry.getValue();
            String castStr=null;
            Integer castIng=null;
            if(newValue instanceof String){
                castStr= (String)newValue;
            }
            JsonNode jsonNode = objectMapper.readTree(file);
            ((ObjectNode)jsonNode).put(fieldName, castStr);
            return objectMapper.writeValueAsString(jsonNode);
        }
        return null;

    }


}
