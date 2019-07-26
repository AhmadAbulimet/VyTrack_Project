package com.VyTrack.tests.components.customers;

import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Test
    public void RepeatEveryDaysErrorMessages(){

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
        pages.activitiesPage().dayValue.clear();
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys("100").build().perform();
        String expectedErrorMessagLarger="The value have not to be more than 99.";
        Assert.assertEquals(pages.activitiesPage().errorMessageLarger.getText(),expectedErrorMessagLarger);
        BrowserUtils.wait(1);

        pages.activitiesPage().dayValue.clear();
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys("0.1").build().perform();
        BrowserUtils.wait(1);
        String expectedErrorMessageSmaller="The value have not to be less than 1.";
        Assert.assertEquals(pages.activitiesPage().errorMessageSmaller.getText(),expectedErrorMessageSmaller);


        BrowserUtils.wait(1);
        pages.activitiesPage().dayValue.clear();
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys("1").build().perform();
        BrowserUtils.wait(1);
        Assert.assertTrue(pages.activitiesPage().SummaryMessage1.isDisplayed());








    }



    @Test
    public void RepeatEveryDaysFunctionality(){

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
        pages.activitiesPage().dayValue.clear();
        Random random=new Random();
        int dayNum=random.nextInt(100) + 1;
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys(String.valueOf(dayNum)).build().perform();
        actions.click(pages.activitiesPage().summaryy).build().perform();
        BrowserUtils.wait(3);
        String summaryMessage=pages.activitiesPage().summaryy.getText();
        String expectedSummaryMessage="Daily every "+String.valueOf(dayNum)+" days";
        Assert.assertEquals(summaryMessage,expectedSummaryMessage);

        BrowserUtils.wait(2);
        pages.activitiesPage().dayValue.clear();
        int newDayNum=random.nextInt(100) + 1;
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys(String.valueOf(newDayNum)).build().perform();
        actions.click(pages.activitiesPage().summaryy).build().perform();
        BrowserUtils.wait(3);
        expectedSummaryMessage="Daily every "+String.valueOf(dayNum)+" days";
        String newSummaryMessage=pages.activitiesPage().summaryy.getText();
        String newExpectedSummaryMessage="Daily every "+String.valueOf(newDayNum)+" days";
        Assert.assertEquals(newSummaryMessage,newExpectedSummaryMessage);
        Assert.assertNotEquals(newSummaryMessage,expectedSummaryMessage);





    }


    @Test
    public void blankFields(){

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
        pages.activitiesPage().dayValue.clear();
        BrowserUtils.wait(1);
        Assert.assertTrue(pages.activitiesPage().blankFieldMessage.isDisplayed());
        actions.doubleClick(pages.activitiesPage().dayValue).sendKeys("1").build().perform();
        Assert.assertFalse(pages.activitiesPage().blankFieldMessage.isDisplayed());


        List<WebElement> repeatEvery = pages.activitiesPage().repeatEveryCheckBox;
        for (int i = 0; i < repeatEvery.size(); i++) {

            WebElement repeat = repeatEvery.get(i);

            if (i == 3) {
                repeat.click();
                pages.activitiesPage().afterOccurances.sendKeys("1");
                pages.activitiesPage().afterOccurances.clear();
                BrowserUtils.wait(2);
                Assert.assertTrue(pages.activitiesPage().afterOccuranceErrorMessage.isDisplayed());
                BrowserUtils.wait(1);
                pages.activitiesPage().afterOccurances.sendKeys("1");


                break;

            }

        }



    }


    @Test
    public void EndsErrorMessages(){

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

        BrowserUtils.wait(2);

        List<WebElement> repeatEvery = pages.activitiesPage().repeatEveryCheckBox;
        for (int i = 0; i < repeatEvery.size(); i++) {

            WebElement repeat = repeatEvery.get(i);

            if (i == 3) {
                repeat.click();
                pages.activitiesPage().afterOccurances.sendKeys("1");
                pages.activitiesPage().afterOccurances.clear();
                pages.activitiesPage().afterOccurances.sendKeys("0.1");
                Assert.assertTrue(pages.activitiesPage().errorMessageSmaller.isDisplayed());
                BrowserUtils.wait(2);
                pages.activitiesPage().afterOccurances.clear();
                pages.activitiesPage().afterOccurances.sendKeys("101");
                Assert.assertTrue(pages.activitiesPage().errorMessageLarger.isDisplayed());

                break;

            }

        }

    }

    @Test
    public void EndsFunctionality(){

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

        BrowserUtils.wait(2);

        List<WebElement> afterOccuranceSummerayMessage=pages.activitiesPage().afterWarningMessage;
        String AfterOccurancesSummaryMessage=afterOccuranceSummerayMessage.get(17).getText();

        List<WebElement> repeatEvery = pages.activitiesPage().repeatEveryCheckBox;
        for (int i = 0; i < repeatEvery.size(); i++) {

            WebElement repeat = repeatEvery.get(i);

            if (i == 3) {
                repeat.click();

                Random random=new Random();
                int afterOccurancesNum=random.nextInt(100) + 1;
                actions.doubleClick(pages.activitiesPage().afterOccurances).sendKeys(String.valueOf(afterOccurancesNum)).build().perform();
                actions.click(pages.activitiesPage().summaryy).build().perform();
                BrowserUtils.wait(3);
                String summaryMessage=pages.activitiesPage().summaryy.getText();
                String expectedSummaryMessage="Daily every 1 day, end after "+String.valueOf(afterOccurancesNum)+" occurrences";
                Assert.assertEquals(summaryMessage,expectedSummaryMessage);

                BrowserUtils.wait(2);
                pages.activitiesPage().afterOccurances.clear();
                int newAfterOccurancesNum=random.nextInt(100) + 1;
                actions.doubleClick(pages.activitiesPage().afterOccurances).sendKeys(String.valueOf(newAfterOccurancesNum)).build().perform();
                actions.click(pages.activitiesPage().summaryy).build().perform();
                BrowserUtils.wait(3);
                expectedSummaryMessage="Daily every 1 day, end after "+String.valueOf(afterOccurancesNum)+" occurrences";
                String newSummaryMessage=pages.activitiesPage().summaryy.getText();
                String newExpectedSummaryMessage="Daily every 1 day, end after "+String.valueOf(newAfterOccurancesNum)+" occurrences";
                Assert.assertEquals(newSummaryMessage,newExpectedSummaryMessage);
                Assert.assertNotEquals(newSummaryMessage,expectedSummaryMessage);


                break;

            }

        }



    }

}
