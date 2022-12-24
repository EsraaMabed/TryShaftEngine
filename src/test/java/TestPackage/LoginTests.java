package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;
    Api_Practice api;

    Loginapage loginpage ;
    String URL=("https://automationexercise.com/login");

    @BeforeClass
    public void Setup(){
        driver = new ChromeDriver();
      loginpage  = new Loginapage(driver);
      api = new Api_Practice();
        driver.get(URL);

    }
    @Test
    public void LoginSuccessfully() {
        loginpage.SetEmailandPassword(api.getEmail(), api.getPassword());

    }
}
