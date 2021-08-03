package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LocalAPITest {

    @Test
    public void getRequest(){
        baseURI="http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();
    }
    @Test
    public void createUser(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Henry");
        request.put("lastName","Rodriguez");
        request.put("subjectId","1");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }
    @Test
    public void updateUser(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","John");
        request.put("lastName","Cena");
        request.put("subjectId",2);

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/4").
                then().
                statusCode(200).
                log().all();
    }
    @Test
    public void updateUserPatch(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("lastName","Mathew");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();
    }
    @Test
    public void deleteUser(){
        baseURI="http://localhost:3000";
        when().delete("/users/4").then().statusCode(200);
    }
}
