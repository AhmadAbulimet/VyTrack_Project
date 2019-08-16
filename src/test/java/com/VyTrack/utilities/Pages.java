package com.VyTrack.utilities;

import com.VyTrack.pages.*;
import com.VyTrack.pages.activities.CalendarEventsPage;
import cucumber.api.java.bs.A;

public class Pages {

   private LoginPage loginPage=new LoginPage();
   private HomePage homePage=new HomePage();
   private CustomersPage customersPage=new CustomersPage();
   private ActivitiesPage activitiesPage=new ActivitiesPage();
   private DashboardPage dashboardPage=new DashboardPage();
   private   CalendarEventsPage calendarEventsPage=new CalendarEventsPage();





    public LoginPage login(){

        if(loginPage==null){
            loginPage=new LoginPage();
        }

        return loginPage;
    }



    public HomePage homePage(){

        if(homePage==null){
            homePage=new HomePage();
        }

        return homePage;
    }


    public CustomersPage customersPage(){

        if(customersPage==null){
            customersPage=new CustomersPage();
        }

        return customersPage;
    }

    public ActivitiesPage activitiesPage(){

        if (activitiesPage==null){
            activitiesPage=new ActivitiesPage();
        }

        return activitiesPage;
    }

    public DashboardPage dashboardPage(){

        if(dashboardPage==null){
            dashboardPage=new DashboardPage();
        }

        return dashboardPage;
    }

    public CalendarEventsPage calendarEventsPage(){

        if(calendarEventsPage==null){
            calendarEventsPage=new CalendarEventsPage();
        }

        return calendarEventsPage;
    }



}
