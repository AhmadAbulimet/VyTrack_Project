package com.VyTrack.tests.components.login_navigation;

import com.VyTrack.utilities.ApplicationConstants;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import cucumber.api.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void PositiveLoginTest(){


        driver.manage().window().fullscreen();
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        Assert.assertTrue(pages.login().userFullName.isDisplayed());
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.HOME_PAGE_TITLE);
        BrowserUtils.wait(3);
        actions=new Actions(driver);
        actions.moveToElement(pages.login().logoutDiamond).click().moveToElement(pages.login().Logout).click().perform();


        BrowserUtils.wait(2);
        pages.login().logIn(ConfigurationReader.getProperty("salesmanager"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.HOME_PAGE_TITLE);
        Assert.assertNotEquals(pages.login().userFullName.getText(),"Lucile Muller");
        BrowserUtils.wait(2);
        actions.moveToElement(pages.login().logoutDiamond).click().moveToElement(pages.login().Logout).click().perform();



        BrowserUtils.wait(2);
        pages.login().logIn(ConfigurationReader.getProperty("truckdriver"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.HOME_PAGE_TITLE);
        Assert.assertNotEquals(pages.login().userFullName.getText(),"Ross Stroman");

    }


    @Test
    public void NegativeLoginTest(){



        driver.manage().window().fullscreen();
        pages.login().logIn(ConfigurationReader.getProperty("randomUsername"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);

        Assert.assertTrue(pages.login().warningMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.LOGIN_PAGE_TITLE);
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.getProperty("loginUrl"));


    }


}
