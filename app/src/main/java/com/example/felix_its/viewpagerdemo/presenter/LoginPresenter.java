package com.example.felix_its.viewpagerdemo.presenter;

import com.example.felix_its.viewpagerdemo.LoginInteractor;
import com.example.felix_its.viewpagerdemo.view.ILoginView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Felix-ITS on 06-12-2016.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(ILoginView iLoginView) {
        this.loginView =iLoginView;
        loginInteractor = new LoginInteractor(this);

    }

    @Override
    public void setValidation(String userName, String password) {

        if(userName.length()==0){
            loginView.setValidationError();
        }else{

            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("USERNAME",userName);
                jsonObject.put("PASSWORD",password);

                loginInteractor.loginCredentitials(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

    @Override
    public void loginSuccessfull() {

        loginView.hideProgress();
    }
}
