package com.vytrack.utilities;

import com.vytrack.pages.LoginPage;

public class Pages {

    LoginPage loginPage=new LoginPage();

    public LoginPage login(){

        if(loginPage==null){
            loginPage=new LoginPage();
        }

        return loginPage;
    }
}
