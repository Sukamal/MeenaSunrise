package suku.com.meenasunrise.feature.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.feature.common.BaseActivity;
import suku.com.meenasunrise.feature.common.OnFragmentInteractionListener;
import suku.com.meenasunrise.feature.contactlist.ContactListFragment;
import suku.com.meenasunrise.feature.directory.DirectoryFragment;
import suku.com.meenasunrise.feature.login.LoginActivity;
import suku.com.meenasunrise.feature.profile.ProfileFragment;
import suku.com.meenasunrise.util.AppConstant;
import suku.com.meenasunrise.util.AppDialog;

public class HomeActivity extends BaseActivity implements HomeContract.view,
        NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener{

    @Inject
    HomePresenter presenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initComponents() {

        HomeDiComponent component = DaggerHomeDiComponent
                .builder()
                .applicationComponent(MeenaSunriseApplication.getApplication(this).getApplicationComponent())
                .homeDiModule(new HomeDiModule(this))
                .build();
        component.inject(this);


        initToolBar();
        initDrawer();
        initListner();
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

    private void initToolBar(){
        setSupportActionBar(toolbar);
    }

    private void initDrawer(){
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setItemIconTintList(null); // To displlay navigation Menu Item color
    }



    private void initListner(){
        navigationView.setNavigationItemSelectedListener(this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        navigationView.setCheckedItem(R.id.nav_profile);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_profile));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            addFragment(ProfileFragment.newInstance(),null,false);
            setToolbarTitle("Profile");
        } else if (id == R.id.nav_directory) {
            addFragment(DirectoryFragment.newInstance(),null,false);
            setToolbarTitle("Directory");
        } else if (id == R.id.nav_notice) {

        } else if (id == R.id.nav_service) {

        } else if (id == R.id.nav_complaint) {

        } else if (id == R.id.nav_financial) {

        } else if (id == R.id.nav_visitor) {

        }else if (id == R.id.nav_logout) {
            displyLogoutDialog();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setToolbarTitle(String title){
        toolbar.setTitle(title);
    }

    @Override
    public void onFragmentInteraction(String fragmentName,String value) {

        try {
            Fragment fragment1 =    (Fragment) (Class.forName(fragmentName).newInstance());
            Bundle bundle = null;
            if(value != null){
                bundle = new Bundle();
                bundle.putString(AppConstant.ExtraTag.TAG_VALUE_1.name(),value);
            }
            addFragment(fragment1,bundle,true);
            setToolbarTitle("Flat Owner");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void displyLogoutDialog() {
        AppDialog appDialog = new AppDialog();
        appDialog.showErrorDialog(this, "Log Out", "Do you want to log out?", new AppDialog.DialogListener() {
            @Override
            public void OnPositivePress(Object val) {
                presenter.doLogout();
            }

            @Override
            public void OnNegativePress() {

            }
        });
    }

    @Override
    public void displyLoginScreen() {
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        finish();
    }
}
