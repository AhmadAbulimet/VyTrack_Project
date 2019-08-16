package com.VyTrack.pages;

import com.VyTrack.utilities.BasePage;
import com.VyTrack.utilities.Driver;
import com.VyTrack.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
