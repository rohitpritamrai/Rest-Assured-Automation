package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExample {

    @Test
    public void testGet(){
         baseURI = "https://reqres.in/api";

         given().
                 get("/users?page=2").
                 then().
                 statusCode(200).
                 body("data[4].first_name", equalTo("George")).
                 body("data.first_name", hasItems("George","Rachel"));
    }

    @Test
    public void testPost(){
        baseURI = "https://reqres.in";

        JSONObject request = new JSONObject();
        request.put("name","John");
        request.put("job","Lawyer");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/api/users").
                then().
                statusCode(201).
                log().all();
    }
}
