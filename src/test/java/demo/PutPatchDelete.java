package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {

    @Test
    public void testPut(){
        baseURI = "https://reqres.in";
        JSONObject request = new JSONObject();
        request.put("name","John");
        request.put("job","Doctor");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch(){
        baseURI = "https://reqres.in";

        JSONObject request = new JSONObject();
        request.put("name","Rohit");
        request.put("job","Student");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in";

        when().
                delete("/api/users/2").
                then().
                statusCode(204);
    }
}
