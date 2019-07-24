package com.VyTrack.pages;

import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "//h1[.='Quick Launchpad']")
    public WebElement Header;

    @FindBy(linkText = "Fleet")
    public WebElement Fleet;


    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement Vehicles;

    @FindBy(xpath = "//span[.='Vehicle Odometer']")
    public WebElement VehicleOdometer;

    @FindBy(xpath = "//span[.='Vehicle Costs']")
    public WebElement VehicleCosts;

    @FindBy(xpath = "//span[.='Vehicle Contracts']")
    public WebElement VehicleContracts;

    @FindBy(xpath = "//span[.='Vehicles Fuel Logs']")
    public WebElement VehiclesFuelLogs;

    @FindBy(xpath = "//span[.='Vehicle Services Logs']")
    public WebElement VehicleServicesLogs;

    @FindBy(xpath = "//span[.='Vehicles Model']")
    public WebElement VehiclesModel;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement JettDach;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement Logout;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement userFullName;

    @FindBy(xpath = "//i[@class='fa-caret-down']")
    public WebElement logoutDiamond;

    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement noPermission;

    @FindBy(xpath = "//h1[.='Cars']")
    public WebElement VehiclesHeader;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement SubTitle;















}
