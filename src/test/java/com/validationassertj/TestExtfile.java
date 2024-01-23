package com.validationassertj;

import com.fwc.Utils.ApiUtils;
import com.fwc.Utils.FakerUtils;
import com.fwc.Utils.RandomUtils;
import com.fwc.constants.FCSingleton;
import com.fwc.specbuilder.ApiBuilder;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestExtfile {

    @Test
    public void postRequestUsingExternalFile(){
        String ss = ApiUtils.modifyFilePayloadNode("userreq.json", "id", "503");

        Response resp= ApiBuilder
                       .reqSpecBuilderPost()
                       .body(ss)
                       .post("/posts");
        resp.prettyPrint();

        Assertions.assertThat(resp.statusCode()).isEqualTo(200);

    }

    @Test
    public void postRequestExtProp(){

        String ss = ApiUtils.readJsonToString(FCSingleton.getInstance().getRequestInputPath() + "userreq.json");
        Response resp= ApiBuilder
                       .reqSpecBuilderPost()
                       .body(ss)
                               .post("/posts");
        resp.prettyPrint();
        Assertions.assertThat(resp.getStatusCode()).isEqualTo(201);
    }
}
