package com.VyTrack.pages;

import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    public CustomersPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Customers")
    public WebElement Customers;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement Accounts;

    @FindBy(xpath = "//h1[.='Accounts']")
    public WebElement AccountsHeader;

    @FindBy(xpath = "//span[.='Contacts']")
    public  WebElement Contacts;

    @FindBy(xpath = "//h1[.='Contacts']")
    public WebElement ContactsHeader;


}
