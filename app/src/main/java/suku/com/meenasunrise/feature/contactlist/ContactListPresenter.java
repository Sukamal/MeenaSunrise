package suku.com.meenasunrise.feature.contactlist;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;

import java.util.List;

import javax.inject.Inject;

import suku.com.meenasunrise.model.UserProfileModel;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.UserDetails;
import suku.com.meenasunrise.util.AppConstant;

public class ContactListPresenter implements ContactListContract.presenter {

    @Inject
    MyDatabase myDatabase;

    private ContactListContract.view view;

    @Inject
    public ContactListPresenter(ContactListContract.view view) {
        this.view = view;
    }

    private Handler mHandler;

    @Override
    public void loadData() {
        getLoginUserDetails();
    }

    @Override
    public void receiveRoutingData(int code) {
        view.displayContactDetails(String.valueOf(code));
    }

    private void getLoginUserDetails() {

        mHandler = new Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message msg) {

                switch (msg.what) {

                    case 1:
                        List<UserDetails> userList = (List<UserDetails>) msg.obj;
                        displayOnUi(userList);
                        break;
                    default:
                        super.handleMessage(msg);
                        break;
                }

            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                List<UserDetails> userList = myDatabase.userDetailsDao().getAll();
                Message message = mHandler.obtainMessage(1, userList);
                message.sendToTarget();

            }
        }).start();
    }

    private void displayOnUi(final List<UserDetails> userList) {
        view.displayContacts(userList);
    }

}
