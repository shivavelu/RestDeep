package com.fwc.specbuilder;

import com.fwc.Utils.PropertyUtils;
import com.fwc.enums.ConfigEnum;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

//as this is going to be the utiltity class not recomend to inherient, always utilty method access directly
// meaning object creation should be restricated hence making this final and private constructor respectively
public final class ApiBuilder {

    private ApiBuilder(){
    }

    public static RequestSpecification reqSpecBuilderGet(){
        return given()
                .baseUri(PropertyUtils.getMapValue(ConfigEnum.BASEURI))
                .log().all();
    }

    public static RequestSpecification reqSpecBuilderPost(){
        return reqSpecBuilderGet().contentType(ContentType.JSON);
    }
}
