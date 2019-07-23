package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void PositiveLoginTest()throws InterruptedException{

        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager223");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).isDisplayed());

        Assert.assertEquals(driver.getTitle(),"Dashboard");

        Thread.sleep(3000);

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='fa-caret-down']"))).click().moveToElement(driver.findElement(By.xpath("//a[.='Logout']"))).click().perform();

        Thread.sleep(3000);



        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager287");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(5000);

        Assert.assertEquals(driver.getTitle(),"Dashboard");


        Assert.assertNotEquals(driver.findElement(By.xpath("//i[@class='fa-caret-down']")).getText(),"Lucile Muller");

      Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='fa-caret-down']"))).click().moveToElement(driver.findElement(By.xpath("//a[.='Logout']"))).click().perform();

        Thread.sleep(3000);



        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("user187");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(5000);

        Assert.assertEquals(driver.getTitle(),"Dashboard");


        Assert.assertNotEquals(driver.findElement(By.xpath("//i[@class='fa-caret-down']")).getText(),"Ross Stroman");



    }

    @Test
    public void NegativeLoginTest()throws InterruptedException{

        driver.navigate().to("http://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("prependedInput")).sendKeys("user187");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser1234" + Keys.ENTER);

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[.='Invalid user name or password.']")).isDisplayed());

        Assert.assertEquals(driver.getTitle(),"Login");
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa2.vytrack.com/user/login");


    }


}
