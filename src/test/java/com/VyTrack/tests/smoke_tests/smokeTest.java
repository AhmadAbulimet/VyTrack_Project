package com.VyTrack.tests.smoke_tests;

import com.VyTrack.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class smokeTest extends TestBase{

    @Test(groups= {"smoke"})
    public void verifyDashboards() {

        extentLogger = report.createTest("Verify Dashboards module");
        String username = ConfigurationReader.getProperty("storemanager");
        String password = ConfigurationReader.getProperty("password");
        pages.login().logIn(username,password);

        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.HOME_PAGE_TITLE);
        extentLogger.pass("Verified that Dashboard page opens");

    }

    @Test(groups= {"smoke"})
    public void verifyFleet() {
        extentLogger = report.createTest("Verify Fleet module");
        String username = ConfigurationReader.getProperty("storemanager");
        String password = ConfigurationReader.getProperty("password");
        pages.login().logIn(username,password);

        pages.dashboardPage().navigateToModule("Fleet","Vehicles");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Cars");
        extentLogger.pass("Verified that Vehicles page opens");

        pages.dashboardPage().navigateToModule("Fleet", "Vehicle Costs");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Vehicle Costs");
        extentLogger.pass("Verified that Vehicle Costs page opens");

        pages.dashboardPage().navigateToModule("Fleet", "Vehicle Contracts");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Vehicle Contract");
        extentLogger.pass("Verified that Vehicle Contracts page opens");


    }


    @Test(groups= {"smoke"})
    public void verifySales() {
        extentLogger = report.createTest("Verify Sales module");
        String username = ConfigurationReader.getProperty("storemanager");
        String password = ConfigurationReader.getProperty("password");
        pages.login().logIn(username,password);

        pages.dashboardPage().navigateToModule("Sales", "Opportunities");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Open Opportunities");
        extentLogger.pass("Verified that Opportunities page opens");


    }

    @Test(groups= {"smoke"})
    public void verifySystem() {
        extentLogger = report.createTest("Verify System module");
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        pages.dashboardPage().navigateToModule("System", "Jobs");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Jobs List");
        extentLogger.pass("Verified that Jobs page opens");
    }

    @Test(groups= {"smoke"})
    public void verifyMarketing() {
        extentLogger = report.createTest("Verify Marketing module");
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        pages.dashboardPage().navigateToModule("Marketing", "Campaigns");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Campaigns");
        extentLogger.pass("Verified that Campaigns page opens");
    }

    @Test(groups= {"smoke"})
    public void verifyCustomers() {
        extentLogger = report.createTest("Verify Customers module");
        pages.login().logIn(ConfigurationReader.getProperty("storemanager"),ConfigurationReader.getProperty("password"));
        pages.dashboardPage().navigateToModule("Customers", "Accounts");
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "All Accounts");
        extentLogger.pass("Verified that Accounts page opens");
    }

}
