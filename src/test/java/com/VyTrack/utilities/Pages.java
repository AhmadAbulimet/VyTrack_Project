package com.VyTrack.utilities;

import com.VyTrack.pages.LoginPage;

public class Pages {

    LoginPage loginPage=new LoginPage();

    public LoginPage login(){

        if(loginPage==null){
            loginPage=new LoginPage();
        }

        return loginPage;
    }
}
