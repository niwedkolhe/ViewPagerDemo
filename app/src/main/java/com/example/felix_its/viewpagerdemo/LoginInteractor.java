package com.example.felix_its.viewpagerdemo;

import com.example.felix_its.viewpagerdemo.interactor.ILoginInteractor;
import com.example.felix_its.viewpagerdemo.presenter.LoginPresenter;

import org.json.JSONObject;

/**
 * Created by Felix-ITS on 06-12-2016.
 */

public class LoginInteractor implements ILoginInteractor {

    private LoginPresenter loginPresenter;

    public LoginInteractor(LoginPresenter loginPresenter) {

        this.loginPresenter = loginPresenter;

    }


    @Override
    public void loginCredentitials(JSONObject jsonObject) {

        if(true) {
            this.loginPresenter.loginSuccessfull();

        }

    }

}
