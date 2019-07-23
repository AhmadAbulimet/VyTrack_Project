package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;
    protected Pages pages;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://qa2.vytrack.com");
    }




    @AfterMethod
    public void tearDown()throws InterruptedException{

        Thread.sleep(3000);
        driver.quit();


    }


}
