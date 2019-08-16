package com.VyTrack.pages;

import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage{

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement passWord;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement warningMessage;

    @FindBy(linkText = "Alex Jones")
    public WebElement AlexJones;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOut;


    public void logIn(String userName, String passWord){
        LoginPage loginPage=new LoginPage();


        loginPage.userName.sendKeys(userName);
        loginPage.passWord.sendKeys(passWord);
        loginPage.loginButton.click();
    }


}
