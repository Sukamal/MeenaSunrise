package suku.com.meenasunrise.feature.contactdetails;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import javax.inject.Inject;

import suku.com.meenasunrise.model.ContactDetailsModel;
import suku.com.meenasunrise.storage.database.MyDatabase;

public class ContactDetailsPresenter implements ContactDetailsContract.presenter {

    @Inject
    MyDatabase myDatabase;

    private ContactDetailsContract.view view;

    @Inject
    public ContactDetailsPresenter(ContactDetailsContract.view view) {
        this.view = view;
    }

    private Handler mHandler;

    @Override
    public void loadData(String userId) {
        getContactDetails(userId);
    }


    private void getContactDetails(final String userId) {

        mHandler = new Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message msg) {

                switch (msg.what) {

                    case 1:
                        ContactDetailsModel detailsModel = (ContactDetailsModel) msg.obj;
                        displayOnUi(detailsModel);
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
                ContactDetailsModel detailsModel = myDatabase.userDetailsDao().getContactDetails(userId);
                Message message = mHandler.obtainMessage(1, detailsModel);
                message.sendToTarget();

            }
        }).start();
    }

    private void displayOnUi(final ContactDetailsModel detailsModel) {
        view.displayContactDetails(detailsModel);
    }

}
