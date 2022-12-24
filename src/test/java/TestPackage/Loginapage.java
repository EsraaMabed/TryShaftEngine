package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginapage {

WebDriver driver;
    By Validemail = By.xpath("//input[@data-qa='login-email']");
    By Validpassword = By.xpath("//input[@data-qa='login-password']");
    By Loginbutton = By.xpath("//button[@data-qa='login-button']");
    By LoginTitle = By.xpath("//div[@class='login-form']//h2");


    public Loginapage(WebDriver driver) {
        this.driver = driver;
    }

    public void SetEmailandPassword(String email, String password){
        driver.findElement(Validemail).sendKeys(email);
        driver.findElement(Validpassword).sendKeys(password);
        driver.findElement(Loginbutton).click();
    }
    public String setLoginTitle(){

        return driver.findElement(LoginTitle).getText();
    }

}
