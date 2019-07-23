package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageAccessTest extends TestBase {

    @Test
    public void storeManagerVehicleContractsTest()throws InterruptedException{


        driver.navigate().to("http://qa2.vytrack.com/user/login");
       driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager223");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);


        Thread.sleep(4000);

        Actions actions=new Actions(driver);
        actions.moveToElement( driver.findElement(By.linkText("Fleet"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Vehicle Contracts']"))).click().perform();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(),"All - Vehicle Contract - Entities - System - Car - Entities - System");

    }

    @Test
    public void salesManagerVehicleContractsTest()throws InterruptedException{


        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager287");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(3000);

        Actions actions=new Actions(driver);
        actions.moveToElement( driver.findElement(By.linkText("Fleet"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Vehicle Contracts']"))).click().perform();

        Thread.sleep(6000);
        Assert.assertEquals(driver.getTitle(),"All - Vehicle Contract - Entities - System - Car - Entities - System");

    }


    @Test
    public void driverVehicleContractsTest()throws InterruptedException{


        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("user187");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(3000);

        Actions actions=new Actions(driver);
        actions.moveToElement( driver.findElement(By.linkText("Fleet"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Vehicle Contracts']"))).click().perform();

        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText(),"You do not have permission to perform this action.");

    }
}
