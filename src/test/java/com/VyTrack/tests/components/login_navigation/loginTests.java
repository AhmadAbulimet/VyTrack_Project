package com.VyTrack.tests.components.login_navigation;

import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class loginTests extends TestBase {


    @Test
    public void loginTest1() {
        extentLogger = report.createTest("Login as store manager");

        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        String username = ConfigurationReader.getProperty("storemanager");
        String password = ConfigurationReader.getProperty("password");
        pages.login().logIn(username,password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest1() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.login().logIn("wrongusername", "wrongpassword");
        Assert.assertEquals(pages.login().warningMessage.getText(), "Invalid user name or password.");
        extentLogger.pass("Verified that Message present: " + pages.login().warningMessage.getText());
    }


    @Test
    @Parameters({ "username", "password" }) // get data from data testng.xml
    public void loginWithParameters(String username, String password) {
        extentLogger = report.createTest("Login as store manager");

        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        pages.login().logIn(username,password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

    @Test(dataProvider = "credentials_info") // get data from data provider
    public void loginWithDataProvider(String username, String password) {
        extentLogger = report.createTest("Login as store manager");
        System.out.println(username+"  ::  "+password);
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        pages.login().logIn(username,password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

    @DataProvider(name = "credentials_info")
    public static Object[][] credentials() {
        return new Object[][] { { "storemanager85", "UserUser123" },
                { "salesmanager110", "UserUser123" }};

    }


    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest2() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.login().logIn("wrongusername", "wrongpassword");
        softAssert.assertEquals(pages.login().warningMessage.getText(), "Invalid user name or password.");
        extentLogger.pass("Verified that Message present: " + pages.login().warningMessage.getText());
    }
}
