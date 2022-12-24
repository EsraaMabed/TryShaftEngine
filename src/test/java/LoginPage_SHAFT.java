import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage_SHAFT {
    SHAFT.GUI.WebDriver driver;

        By USERNAME = By.xpath("//*[@id=\"user-name\"]");
        By PASSWORD =  By.xpath("//input[@id=\"password\"]");
        By SUBMITBTN =By.xpath("//input[@id=\"login-button\"]");

        By Errormsg =  By.xpath("//*[@data-test=\"error\"]");

        public LoginPage_SHAFT(SHAFT.GUI.WebDriver driver) {

            this.driver=driver;
        }

        public void logindata(String username, String password){

            driver.element().type(USERNAME,username);
            driver.element().type(PASSWORD,password);
            driver.element().click(SUBMITBTN);
        }
        public String getErrormsg(){
            return driver.element().getText(Errormsg);
        }

}
