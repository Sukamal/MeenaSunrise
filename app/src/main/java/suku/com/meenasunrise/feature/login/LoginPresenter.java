package suku.com.meenasunrise.feature.login;

import javax.inject.Inject;

import suku.com.meenasunrise.storage.database.MyDatabase;

public class LoginPresenter implements LoginContract.presenter {

    private LoginContract.view view;

    @Inject
    public LoginPresenter(LoginContract.view view){
        this.view = view;
    }

    @Override
    public void logIn(String userId, String password) {
        if(validateEmpty(userId)){
            view.displayError(1,"Enter User Id");
        }else if(validateEmpty(password)){
            view.displayError(2,"Enter Password");
        }else {
            CheckCredentials(userId,password);
        }
    }

    private boolean validateEmpty(String val){
        if(val != null && !val.isEmpty()){
            return false;
        }else{
            return true;
        }

    }

    private void CheckCredentials(String userId, String password){
//        if(userId.equalsIgnoreCase(password)){
//            view.openHomeScreen();
//        }else{
//            view.displayError(3,"Sorry Invalid Credential");
//        }

        view.openHomeScreen();
    }


}
