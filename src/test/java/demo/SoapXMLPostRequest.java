package demo;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class SoapXMLPostRequest {

    @Test
    public void validateSoapXML() throws IOException {
        File file = new File("./SoapRequest/Add.xml");
        FileInputStream fileInputStream;
        String requestBody = null;
        try {
            fileInputStream = new FileInputStream(file);
            requestBody = IOUtils.toString(fileInputStream,"UTF-8");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        baseURI = "http://www.dneonline.com";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().
                statusCode(200).and().body("//AddResult.text()",equalTo("5"));
    }
}
