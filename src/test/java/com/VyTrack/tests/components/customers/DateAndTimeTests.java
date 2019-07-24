package com.VyTrack.tests.components.customers;

import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateAndTimeTests extends TestBase {




       @Test
       public void EndDateAutoAdjust(){



           pages.login().logIn(ConfigurationReader.getProperty("truckdriver"),ConfigurationReader.getProperty("password"));
           BrowserUtils.wait(4);
           actions=new Actions(driver);
           actions.moveToElement(pages.activitiesPage().Activities).click().moveToElement(pages.activitiesPage().CalendarEvents).click().perform();
           BrowserUtils.wait(2);
           actions.moveToElement(pages.activitiesPage().createCalendarEvent).click().perform();
           BrowserUtils.wait(2);
           pages.activitiesPage().startDate.click();
           BrowserUtils.hover(pages.activitiesPage().selectYear);
           Select year=new Select(pages.activitiesPage().selectYear);
           year.selectByVisibleText("2022");
           Select month=new Select((pages.activitiesPage().selectMonth));
           month.selectByVisibleText("Jan");
           pages.activitiesPage().selectDay.click();
           BrowserUtils.wait(2);
           Assert.assertEquals(pages.activitiesPage().startDate.getAttribute("value"),pages.activitiesPage().endDate.getAttribute("value"));
           BrowserUtils.wait(2);
           pages.activitiesPage().startDate.click();
           pages.activitiesPage().Today.click();
           BrowserUtils.wait(2);
           Assert.assertEquals(pages.activitiesPage().startDate.getAttribute("value"),pages.activitiesPage().endDate.getAttribute("value"));


           BrowserUtils.wait(2);
           pages.activitiesPage().startDateHour.click();
           pages.activitiesPage().twelveAM.click();
           pages.activitiesPage().startDate.click();
           BrowserUtils.hover(pages.activitiesPage().selectYear);
           year.selectByVisibleText("2020");
           month.selectByVisibleText("Jan");
           pages.activitiesPage().selectDay.click();
           BrowserUtils.wait(1);
           String expectedEndDateHour="1:00 AM";
           Assert.assertEquals(pages.activitiesPage().endDateHour.getAttribute("value"),expectedEndDateHour);


           BrowserUtils.wait(2);
           pages.activitiesPage().startDateHour.click();
           pages.activitiesPage().hour1130.click();
           pages.activitiesPage().startDate.click();
           BrowserUtils.hover(pages.activitiesPage().selectYear);
           year.selectByVisibleText("2020");
           month.selectByVisibleText("Jan");
           pages.activitiesPage().selectDay.click();
           String expectedEndDay="Jan 5, 2020";
           String expectedEndHour="12:30 AM";
           Assert.assertEquals(pages.activitiesPage().endDate.getAttribute("value"),expectedEndDay);
           Assert.assertEquals(pages.activitiesPage().endDateHour.getAttribute("value"),expectedEndHour);


       }

}
