package com.VyTrack.tests.smoke_tests;

import com.VyTrack.utilities.ApplicationConstants;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import com.github.javafaker.App;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuOptionsTest extends TestBase {



    @Test
    public void driverMenuOption()throws InterruptedException{

        driver.manage().window().fullscreen();
        pages.login().logIn(ConfigurationReader.getProperty("truckdriver"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        actions=new Actions(driver);
        actions.moveToElement( pages.login().Fleet).click().moveToElement(pages.login().Vehicles).click().perform();
        BrowserUtils.wait(4);
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.VEHICLES_TITLE);
        Assert.assertEquals(pages.login().VehiclesHeader.getText(),ApplicationConstants.VEHICLE_HEADER);

        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement(pages.login().Customers).click().moveToElement(pages.login().Accounts).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.ACCOUNTS_TITLE);
        Assert.assertEquals(pages.login().AccountsHeader.getText(),ApplicationConstants.ACCOUNTS_HEADER);

        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement( pages.login().Customers).click().moveToElement(pages.login().Contacts).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CONTACTS_TITLE);
        Assert.assertEquals(pages.login().ContactsHeader.getText(),ApplicationConstants.CONTACTS_HEADER);


        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement(pages.login().Activities).click().moveToElement(pages.login().CalendarEvents).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CALENDAR_EVENTS_TITLE);
        Assert.assertEquals(pages.login().CalendarEventsHeader.getText(),ApplicationConstants.CALENDAR_EVENTS_HEADER);




    }


    @Test
    public void storeManagerMenuOption()throws InterruptedException {

        driver.manage().window().fullscreen();
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        actions=new Actions(driver);
        actions.moveToElement( pages.login().Fleet).click().moveToElement(pages.login().Vehicles).click().perform();
        BrowserUtils.wait(3);
        Assert.assertEquals(driver.getTitle(),"All - Car - Entities - System - Car - Entities - System");
        Assert.assertEquals(pages.login().SubTitle.getText(),"All Cars");

        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement( pages.login().Customers).click().moveToElement(pages.login().Accounts).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(),"All - Accounts - Customers");
        Assert.assertEquals(pages.login().SubTitle.getText(),"All Accounts");

        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement( pages.login().Customers).click().moveToElement(pages.login().Contacts).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(),"All - Contacts - Customers");
        Assert.assertEquals(pages.login().SubTitle.getText(),"All Contacts");


        driver.navigate().back();
        BrowserUtils.wait(2);
        actions.moveToElement( pages.login().Activities).click().moveToElement(pages.login().CalendarEvents).click().perform();
        BrowserUtils.wait(2);
        Assert.assertEquals(driver.getTitle(),"All - Calendar Events - Activities");
        Assert.assertEquals(pages.login().SubTitle.getText(),"All Calendar Events");



    }


}
