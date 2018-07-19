package suku.com.meenasunrise.feature.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.feature.common.BaseActivity;
import suku.com.meenasunrise.feature.home.HomeActivity;
import suku.com.meenasunrise.feature.login.LoginActivity;
import suku.com.meenasunrise.util.AppConstant;
import suku.com.meenasunrise.util.AppDialog;
import suku.com.testlib1.ActivityOne;

public class SplashActivity extends BaseActivity implements SplashContract.view {

    private static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    @BindView(R.id.llSunrise)
    LinearLayout llSunrise;
    @BindView(R.id.ivSplash)
    ImageView ivSplash;

    @Inject
    SplashPresenter splashPresenter;

    @Override
    public int getContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initComponents() {
        SplashDiComponent component = DaggerSplashDiComponent
                .builder()
                .splashDiModule(new SplashDiModule(this))
                .applicationComponent(MeenaSunriseApplication.getApplication(this).getApplicationComponent())
                .build();
        component.inject(this);
        checkDevicePermission();

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

    @Override
    public void openLoginScreen() {
//        Intent intent = new Intent(SplashActivity.this, ActivityOne.class);
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void openHomeScreen() {
//        Intent intent = new Intent(SplashActivity.this, ActivityOne.class);
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
    }



    private void doAnimateImage(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
        ivSplash.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_moveup);
        llSunrise.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(null != splashPresenter.mAppPreference.getStringPref(AppConstant.Preferences.LOOGED_IN_USER_ID.name()) ){
                    splashPresenter.receiveRoutingData("home");
                }else{
                    splashPresenter.receiveRoutingData("login");
                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initializeSplash(){
        splashPresenter.insertStaticData();
        doAnimateImage();

    }

    private void checkDevicePermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            executeUserPermissionTree();
        }else{
            initializeSplash();
        }
    }

    private void executeUserPermissionTree(){
        AppDialog appDialog = new AppDialog();
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, android.Manifest.permission.READ_PHONE_STATE))
            permissionsNeeded.add("Read Phone State");
        if (!addPermission(permissionsList, Manifest.permission.CALL_PHONE))
            permissionsNeeded.add("Call Phone");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);

                appDialog.showErrorDialog(SplashActivity.this, "Permission", message, new AppDialog.DialogListener() {
                    @Override
                    public void OnPositivePress(Object val) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                        }
                    }

                    @Override
                    public void OnNegativePress() {
                        finish();
                    }
                });

                return;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
            return;
        }else{
            initializeSplash();
        }


    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
                // Check for Rationale Option
                if (!shouldShowRequestPermissionRationale(permission))
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS:
            {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(android.Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.CALL_PHONE, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION
                if (perms.get(android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted
                    initializeSplash();

                } else {
                    // Permission Denied
                    Toast.makeText(this, "Some Permission is Denied", Toast.LENGTH_SHORT)
                            .show();
                    finish();

                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}
