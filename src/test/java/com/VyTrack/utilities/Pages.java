package com.VyTrack.utilities;

import com.VyTrack.pages.ActivitiesPage;
import com.VyTrack.pages.CustomersPage;
import com.VyTrack.pages.HomePage;
import com.VyTrack.pages.LoginPage;
import cucumber.api.java.bs.A;

public class Pages {

    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    CustomersPage customersPage=new CustomersPage();
    ActivitiesPage activitiesPage=new ActivitiesPage();

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
}
