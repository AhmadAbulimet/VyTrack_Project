package com.VyTrack.pages;

import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivitiesPage {

    public ActivitiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(linkText = "Activities")
    public WebElement Activities;

    @FindBy(xpath = "//span[.='Calendar Events']")
    public WebElement CalendarEvents;

    @FindBy(xpath = "//h1[.='Calendar Events']")
    public WebElement CalendarEventsHeader;

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//input[@class='input-small datepicker-input start hasDatepicker']")
    public WebElement startDate;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public  WebElement selectYear;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public  WebElement selectMonth;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[ 1]/td[7]")
    public WebElement selectDay;

    @FindBy(xpath = "//input[@class='input-small datepicker-input end hasDatepicker']")
    public WebElement endDate;

    @FindBy(xpath = "//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
    public WebElement Today;

    @FindBy(xpath = "//input[@class='input-small timepicker-input start ui-timepicker-input']")
    public WebElement startDateHour;

    @FindBy(xpath = "//li[.='12:00 AM']")
    public WebElement twelveAM;

    @FindBy(xpath = "//li[.='11:30 PM']")
    public WebElement hour1130;

    @FindBy(xpath = "//input[@class='input-small timepicker-input end ui-timepicker-input']")
    public WebElement endDateHour;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> Checkbox;

    @FindBy(xpath = "//select[@class='recurrence-repeats__select']")
    public WebElement Repeats;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> repeatEveryCheckBox;

    @FindBy(xpath = "//input[@type='text']")
    public List<WebElement> repeatEveryDay;

    @FindBy(xpath = "//span[.='Daily every 1 day']")
    public WebElement SummaryMessage1;

    @FindBy(xpath ="//span[.='Daily, every weekday']" )
    public WebElement SummaryWeekDay;

    @FindBy(xpath = "//span[.='The value have not to be less than 1.']")
    public WebElement errorMessageSmaller;

    @FindBy(xpath = "//span[.='The value have not to be more than 99.']")
    public WebElement errorMessageLarger;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/label/input[3]")
    public WebElement dayValue;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div[2]/div[2]/div[2]/div[7]/div[2]/div")
    public WebElement summaryy;

    @FindBy(xpath = "//span[@class='validation-failed']")
    public WebElement blankFieldMessage;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div[2]/div[2]/div[2]/div[6]/div/div[2]/div[2]/label/input[2]")
    public WebElement afterOccurances;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div[2]/div[2]/div[2]/div[6]/div/div[2]/div[2]/span/span/span")
    public WebElement afterOccuranceErrorMessage;

    @FindBy(xpath = "//div[@class='controls']")
    public List<WebElement> afterWarningMessage;



}
