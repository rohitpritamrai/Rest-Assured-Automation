package demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidateJsonSchemaOfRestAPI {

    @Test
    public void testGet(){

        baseURI="https://reqres.in/api";
        String JsonPath = "schema.json";

        given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath(JsonPath)).statusCode(200);
    }
}
