package com.vytrack.pages;

import com.vytrack.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{


    public LoginPage(){PageFactory.initElements(driver,this);}

  @FindBy(id = "prependedInput")
    public WebElement username;

  @FindBy(id="prependedInput2")
    public WebElement password;

  @FindBy(id="_submit")
    public WebElement loginButton;


    public void logInDriver(String username, String password){
        LoginPage loginPage=new LoginPage();

        driver.get("http://qa2.vytrack.com");
        driver.manage().window().fullscreen();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    public void storeManagerLogin(String username, String password){
        LoginPage loginPage=new LoginPage();

        driver.get("http://qa2.vytrack.com");
        loginPage.username.sendKeys("storemanager223");
        loginPage.password.sendKeys("UserUser123");
        loginPage.loginButton.click();

    }


}
