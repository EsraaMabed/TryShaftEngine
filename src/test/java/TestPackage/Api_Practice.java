package TestPackage;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class Api_Practice {
    String baseurl=System.getProperty("AutomationExercise");
    String password =("0123456789");
    String email=("esraa@go.com");

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Test

    public void testApi_creatAccount(){
        SHAFT.API api=new SHAFT.API(baseurl);

        List <List<Object>> parameters= Arrays.asList(
                Arrays.asList("name","Esraa"),
                Arrays.asList("email","esraa@go.com"),
                Arrays.asList("password","0123456789"),
                Arrays.asList("title","Mrs"),
                Arrays.asList("birth_date","01"),
                Arrays.asList("birth_month","01"),
                Arrays.asList("birth_year","1996"),
                Arrays.asList("firstname","Esraa"),
                Arrays.asList("lastname","mabed"),
                Arrays.asList("company","VOIS"),
                Arrays.asList("address1","cairo"),
                Arrays.asList("address2","future"),
                Arrays.asList("country","Canada"),
                Arrays.asList("zipcode","20100"),
                Arrays.asList("state","cairo"),
                Arrays.asList("city","future"),
                Arrays.asList("mobile_number","01007100339"));
        api.post("/createAccount")
                .setParameters(parameters, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)

                .perform();















}}
