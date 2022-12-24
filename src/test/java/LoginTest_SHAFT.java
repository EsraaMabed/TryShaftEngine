import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest_SHAFT {
    LoginPage_SHAFT loginpage;
    SHAFT.GUI.WebDriver driver;
    String Url="\"https://www.saucedemo.com\"";



    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(Url);
        loginpage=new LoginPage_SHAFT(driver);
    }

    @Test
    public void usevaliddata() {
        loginpage.logindata("standard_user","secret_sauce");

    }

    @Test
    public void locked_out() {
        loginpage.logindata("locked_out_user","secret_sauce");


    }

    @Test
    public void Emptyassword() {
        loginpage.logindata("standard_user","");
        SHAFT.Validations.assertThat().object(loginpage.getErrormsg()).contains("Epic sadface: Password is required");

    }

    @Test
    public void Emptyusername() {
        loginpage.logindata("","secret_sauce");

        SHAFT.Validations.assertThat().object(loginpage.getErrormsg().contains("Epic sadface: Username is required"));
    }

    @Test
    public void Wrongpassword() {
        loginpage.logindata("standard_user","esraa");

        SHAFT.Validations.assertThat().object(loginpage.getErrormsg().contains("Epic sadface: Username and password do not match any user in this service"));
    }
    public void teardown(){

        driver.quit();

    }


}




