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




}
