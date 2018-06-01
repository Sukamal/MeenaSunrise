package suku.com.meenasunrise.feature.login;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.database.entity.Product;
import suku.com.meenasunrise.feature.common.BaseActivity;
import suku.com.meenasunrise.feature.home.HomeActivity;
import suku.com.meenasunrise.storage.database.entity.UserDetails;
import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

public class LoginActivity extends BaseActivity implements LoginContract.view{


    @BindView(R.id.etUserId)
    EditText etUserId;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;


    @Inject
    LoginContract.presenter presenter;

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponents() {
        DaggerLoginDiComponent.builder().loginDiModule(new LoginDiModule(this)).build().inject(this);

//        presenter = new LoginPresenter(this);
    }

    @Override
    public void openHomeScreen() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void displayError(int field, String error) {
        if(field == 1){
            etUserId.setError(error);
            etUserId.requestFocus();
        }else if(field == 2){
            etPassword.setError(error);
            etPassword.requestFocus();
        }else{
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @OnClick(R.id.btnLogin)
    public void onLoginButtonClick(){
        doLogin(etUserId.getText().toString().trim(),etPassword.getText().toString().trim());

//        presenter.logIn(etUserId.getText().toString().trim(),etPassword.getText().toString().trim());
    }

    private MyDatabase myDatabase;
    private Handler mHandler = new Handler();
    AppPreference mAppPreference;


    private void doLogin(final String userId, final String pwd){
        mAppPreference = new AppPreference(this);
        myDatabase =   Room.databaseBuilder(getApplicationContext(),MyDatabase.class, AppConstant.DATABASE_NAME).build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                final UserDetails userDetails = myDatabase.userDetailsDao().findById(userId);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(userDetails != null){
                            if(userDetails.isIs_active() && userDetails.getPassword().equals(pwd)){
                                mAppPreference.saveStringPref(AppConstant.Preferences.LOOGED_IN_USER_ID.name(),userDetails.getUserPhNo());
                                presenter.logIn(etUserId.getText().toString().trim(),etPassword.getText().toString().trim());

                            }else{
                                Toast.makeText(LoginActivity.this, "Invalid Credentials ", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Sorry you are not registered.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        }).start();


    }


}
