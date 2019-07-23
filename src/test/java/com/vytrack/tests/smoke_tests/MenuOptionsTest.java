package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest extends TestBase{



    @Test
    public void driverMenuOption()throws InterruptedException{

        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user187");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);


        Thread.sleep(4000);

        Actions actions=new Actions(driver);
        actions.moveToElement( driver.findElement(By.linkText("Fleet"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Vehicles']"))).click().perform();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Car - Entities - System - Car - Entities - System");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[.='Cars']")).getText(),"Cars");

        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Customers"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Accounts']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Accounts - Customers");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[.='Accounts']")).getText(),"Accounts");

        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Customers"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Contacts']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Contacts - Customers");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[.='Contacts']")).getText(),"Contacts");


        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Activities"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Calendar Events']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Calendar Events - Activities");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[.='Calendar Events']")).getText(),"Calendar Events");




    }


    @Test
    public void storeManagerMenuOption()throws InterruptedException {

        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager223");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);


        Thread.sleep(5000);

        Actions actions=new Actions(driver);
        actions.moveToElement( driver.findElement(By.linkText("Fleet"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Vehicles']"))).click().perform();

        Thread.sleep(4000);
        Assert.assertEquals(driver.getTitle(),"All - Car - Entities - System - Car - Entities - System");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText(),"All Cars");

        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Customers"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Accounts']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"All - Accounts - Customers");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText(),"All Accounts");

        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Customers"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Contacts']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"All - Contacts - Customers");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText(),"All Contacts");


        driver.navigate().back();

        Thread.sleep(2000);

        actions.moveToElement( driver.findElement(By.linkText("Activities"))).click().moveToElement(driver.findElement(By.xpath("//span[.='Calendar Events']"))).click().perform();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"All - Calendar Events - Activities");

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText(),"All Calendar Events");



    }


}
