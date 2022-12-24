package TestPackage;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.python.modules._json._json;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest_APIS {
    SHAFT.API api;
    String baseurl=System.getProperty("restfullBookerBaseUrl");
    @BeforeClass
    public void Setup(){
        api = new SHAFT.API(baseurl);


    }
    @Test
    public void testApi_createToken() {

        String Body = """
                {
                 "username" : "admin",
                    "password" : "password123"
                
                }
                """;
        api.post("auth").setContentType(ContentType.JSON).setRequestBody(Body).perform();
        api.assertThatResponse().body().contains("token").perform();
    }
    @Test
          public void testApi_getbookinghId(){
        api.get("booking").perform();

    }
    @Test
    public void testApi_getbookinhg(){
        api.get("booking/5").perform();
        api.assertThatResponse().extractedJsonValue("firstname").isEqualTo("Mark").perform();
    }
    @Test
    public void testApi_createbooking(){
        String firstname = "Esraa";
        String lastname = "Motaoe";

        JSONObject body =new JSONObject();
        body.put("firstname",firstname);
        body.put("lastname",lastname);
        body.put("totalprice",2468);
        body.put("depositpaid",true);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2022-01-01");
        bookingDates.put("checkout","2023-01-01");
        body.put("bookingdates",bookingDates);
        body.put("additionalneeds","IceCream");




       api.post("booking")
               .setContentType(ContentType.JSON)
           //    .setRequestBodyFromFile("src/main/resources/responsejsons/createbooking.json")
               .setRequestBody(body)
               .perform();
       api.assertThatResponse().body().contains("bookingid").perform();

    }


}
