package com.VyTrack.tests.components.login_navigation;

import com.VyTrack.utilities.ApplicationConstants;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageAccessTest extends TestBase {

    @Test
    public void storeManagerVehicleContractsTest(){


        driver.manage().window().fullscreen();
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(5);
        actions=new Actions(driver);
        actions.moveToElement( pages.login().Fleet).click().moveToElement(pages.login().VehicleContracts).click().perform();
        BrowserUtils.wait(3);
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.VEHICLE_CONTRACT_TITLE);

    }

    @Test
    public void salesManagerVehicleContractsTest(){


        pages.login().logIn(ConfigurationReader.getProperty("salesmanager"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        actions=new Actions(driver);
        actions.moveToElement( pages.login().Fleet).click().moveToElement(pages.login().VehicleContracts).click().perform();
        BrowserUtils.wait(3);
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.VEHICLE_CONTRACT_TITLE);


    }


    @Test
    public void driverVehicleContractsTest(){

        pages.login().logIn(ConfigurationReader.getProperty("truckdriver"),ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        actions=new Actions(driver);
        actions.moveToElement( pages.login().Fleet).click().moveToElement(pages.login().VehicleContracts).click().perform();
        BrowserUtils.wait(3);
        Assert.assertEquals(pages.login().noPermission.getText(),ApplicationConstants.VEHICLE_CONTRACT_WARNING_MESSAGE);

    }
}
