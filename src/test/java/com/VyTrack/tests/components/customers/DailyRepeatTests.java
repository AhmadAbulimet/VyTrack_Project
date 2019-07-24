package com.VyTrack.tests.components.customers;

import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DailyRepeatTests extends TestBase {

    @Test
    public void RepeatEverySummary() {


        pages.login().logIn(ConfigurationReader.getProperty("truckdriver"), ConfigurationReader.getProperty("password"));
        BrowserUtils.wait(4);
        actions = new Actions(driver);
        actions.moveToElement(pages.activitiesPage().Activities).click().moveToElement(pages.activitiesPage().CalendarEvents).click().perform();
        BrowserUtils.wait(3);
        actions.moveToElement(pages.activitiesPage().createCalendarEvent).click().perform();
        BrowserUtils.wait(2);

        List<WebElement> checkbox = pages.activitiesPage().Checkbox;
        for (int i = 0; i < checkbox.size(); i++) {

            WebElement repeat = checkbox.get(i);

            if (i == 1) {
                repeat.click();
                break;
            }
        }
        BrowserUtils.wait(3);
        List<String> expectedRepeats = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        Select repeats = new Select(pages.activitiesPage().Repeats);
        Assert.assertEquals(repeats.getFirstSelectedOption().getText(), expectedRepeats.get(0));


        List<WebElement> repeatEvery = pages.activitiesPage().repeatEveryCheckBox;
        for (int i = 0; i < repeatEvery.size(); i++) {

            WebElement repeat = repeatEvery.get(i);

            if (i == 0) {
                repeat.click();
                Assert.assertTrue(repeat.isSelected());
                break;

            }

        }

        BrowserUtils.wait(2);

        List<WebElement> everyDayValue = pages.activitiesPage().repeatEveryDay;

        for (int i = 0; i < everyDayValue.size(); i++) {

            WebElement dayValue = everyDayValue.get(i);

            if (i == 10) {

                String expectedDayValue = "1";
                Assert.assertEquals(dayValue.getAttribute("value"), expectedDayValue);
                break;
            }
        }

        String expectedSummaryMessage1="Daily every 1 day";
        Assert.assertEquals(pages.activitiesPage().SummaryMessage1.getText(),expectedSummaryMessage1);







            WebElement WeekDay = repeatEvery.get(1);
            WeekDay.click();
            WebElement EveryDay=repeatEvery.get(0);
            Assert.assertFalse(EveryDay.isSelected());

            String expectedSummaryEveryDayMessage="Daily, every weekday";

            Assert.assertEquals(pages.activitiesPage().SummaryWeekDay.getText(),expectedSummaryEveryDayMessage);






    }


}
