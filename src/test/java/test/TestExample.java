package test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample {

    @Test
    public void fetchKeyValue(){

        baseURI = "https://www.boredapi.com/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/activity");

        JsonPath jsonPathEvaluator = response.jsonPath();

        String keyValue = jsonPathEvaluator.get("key");
        System.out.println("Value of key is " +keyValue);

    }

    @Test
    public void checkAttributesValues(){

        baseURI = "https://www.boredapi.com/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/activity");
        JsonPath jsonPathEvaluator = response.jsonPath();

        String activity = jsonPathEvaluator.get("activity");
        Assert.assertEquals(activity, jsonPathEvaluator.get("activity"));

        String type = jsonPathEvaluator.get("type");
        Assert.assertEquals(type, jsonPathEvaluator.get("type"));

        String participants = jsonPathEvaluator.get("participants").toString();
        Assert.assertEquals(participants, jsonPathEvaluator.get("participants").toString());

        String link = jsonPathEvaluator.get("link");
        Assert.assertEquals(link,jsonPathEvaluator.get("link"));

        String key = jsonPathEvaluator.get("key");
        Assert.assertEquals(key, jsonPathEvaluator.get("key"));

        String accessibility = jsonPathEvaluator.get("accessibility").toString();
        Assert.assertEquals(accessibility, jsonPathEvaluator.get("accessibility").toString());
    }
}
