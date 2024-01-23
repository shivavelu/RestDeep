package com.api.builderlambok;

import static com.fwc.Utils.ApiUtils.*;
import com.fwc.constants.FrameworkConstants;
import com.fwc.specbuilder.ApiBuilder;
import lombok.SneakyThrows;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        Employee ss = jsonStringToObject(jsonFileToString("userreq.json"), Employee.class);
        System.out.println(ss);
    }
}
