package suku.com.meenasunrise.feature.splash;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.UserDetails;
import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

public class SplashPresenter implements SplashContract.presenter {

    private SplashContract.view view;

    @Inject
    AppPreference mAppPreference;
    @Inject
    MyDatabase myDatabase;

    @Inject
    public SplashPresenter(SplashContract.view view){
        this.view = view;
    }

    @Override
    public void insertStaticData() {
        if(!mAppPreference.getBooleanPref(AppConstant.Preferences.IS_LOADED.name())){
            insertFlatDetails();
            insertOwnerDetails();
            mAppPreference.saveBooleanPref(AppConstant.Preferences.IS_LOADED.name(),true);
        }

    }

    @Override
    public void receiveRoutingData(String code) {
        if(code.equalsIgnoreCase("login")){
            view.openLoginScreen();
        }else if (code.equalsIgnoreCase("home")){
            view.openHomeScreen();
        }else{
            view.openLoginScreen();
        }
    }

    private  void insertFlatDetails() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<FlatDetails> flatlist = new ArrayList<>();
                FlatDetails flatDetails;
                //--------------------A------------------------------
                flatDetails = new FlatDetails("AA1", "A","1","A","203","Unsold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AA2", "A","2","A","211","Unsold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AA3", "A","3","A","216","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AA4", "A","4","A","214","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AA5", "A","5","A","223","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("AB1", "A","1","B","205","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AB2", "A","2","B","213","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AB3", "A","3","B","217","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AB4", "A","4","B","215","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AB5", "A","5","B","221","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("AC1", "A","1","C","207","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AC2", "A","2","C","212","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AC3", "A","3","C","209","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AC4", "A","4","C","218","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AC5", "A","5","C","222","Sold");
                flatlist.add(flatDetails);
//--
                flatDetails = new FlatDetails("AD1", "A","1","D","206","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AD2", "A","2","D","210","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AD3", "A","3","D","208","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AD4", "A","4","D","220","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("AD5", "A","5","D","219","Sold");
                flatlist.add(flatDetails);

                //-------------------B---------------------------

                flatDetails = new FlatDetails("BA1", "B","1","A","238","UnSold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BA2", "B","2","A","233","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BA3", "B","3","A","237","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BA4", "B","4","A","239","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BA5", "B","5","A","244","Sold");
                flatlist.add(flatDetails);
//--
                flatDetails = new FlatDetails("BB1", "B","1","B","232","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BB2", "B","2","B","226","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BB3", "B","3","B","230","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BB4", "B","4","B","242","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BB5", "B","5","B","243","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("BC1", "B","1","C","241","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BC2", "B","2","C","231","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BC3", "B","3","C","227","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BC4", "B","4","C","246","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BC5", "B","5","C","240","Sold");
                flatlist.add(flatDetails);
//--
                flatDetails = new FlatDetails("BD1", "B","1","D","235","UnSold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BD2", "B","2","D","229","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BD3", "B","3","D","245","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BD4", "B","4","D","228","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("BD5", "B","5","D","236","Sold");
                flatlist.add(flatDetails);

                //--------------------------C--------------------------

                flatDetails = new FlatDetails("CA1", "C","1","A","267","UnSold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CA2", "C","2","A","269","UnSold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CA3", "C","3","A","261","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CA4", "C","4","A","263","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CA5", "C","5","A","270","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("CB1", "C","1","B","256","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CB2", "C","2","B","250","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CB3", "C","3","B","255","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CB4", "C","4","B","257","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CB5", "C","5","B","265","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("CC1", "C","1","C","268","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CC2", "C","2","C","253","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CC3", "C","3","C","254","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CC4", "C","4","C","251","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CC5", "C","5","C","262","Sold");
                flatlist.add(flatDetails);

//--
                flatDetails = new FlatDetails("CD1", "C","1","D","248","Sold");
                flatlist.add(flatDetails);
                flatDetails = new FlatDetails("CD2", "C","2","D","266","Sold");
                flatlist.add(flatDetails);

                flatDetails = new FlatDetails("CD3", "C","3","D","249","Sold");
                flatlist.add(flatDetails);

                flatDetails = new FlatDetails("CD4", "C","4","D","260","Sold");
                flatlist.add(flatDetails);

                flatDetails = new FlatDetails("CD5", "C","5","D","268","Sold");
                flatlist.add(flatDetails);


                myDatabase.flatDetailsDao().insertAll(flatlist);

            }
        }).start();
    }

    private void insertOwnerDetails() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                ArrayList<UserDetails> userDetailList = new ArrayList<>();
                UserDetails userDetails;

                //------------------------A-------------------------
                userDetails = new UserDetails("Dipanjan Bhattacharjee","9830269867","dipanjanbhattacharjee06@gmail.com","","AA3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Anindita Sarkar","9830086861","aniwip@gmail.com","","AA3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Koushik Biswas","0012645845116","koushikbsws6@gmail.com","","AA4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Neelesh Bhattacharjee","9883685881","neelesh1503@gmail.com","","AA5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sreyashi Chatterjee ","9830086861","daughterofdestiny1992@gmail.com","","AB1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sibakrishna Pari","9674041985","shib.pari@yahoo.in","","AB2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Subhro Muhuri","8697505560","subhromuhuri@gmail.com","","AB3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Aritri Chanda","8335806429","aritri2707@gmail.com","","AB3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Abhishek Bose","8697745577","abhisek.bose@sbi.co.in","","AB4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Neha Bose","9831472657","neha.it.tester@sbi.co.in","","AB4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sougata Roy","9434776424","roy.sougata1@gmail.com","","AB5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Arunav Bhuyan","9955800629","devanjana18@gmail.com","","AC1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Debarati Banerjee Roy","9093436201","debaratibanerjee2005@gmail.com","","AC2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Amalesh Kumar Mondal","9051122584","amaleshmondal@gmail.com","","AC3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Indraneel Aich","8697068847","indraneel.aich@cognizant.com","","AC4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Gouranga Sen","9836393232","sen_gouranga@rediffmail.com","","AC5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Jhuma Sen","","","","AC5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sukamal Das","9007322929","sukamal84@gmail.com","","AD1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Priyanka Das","9007298216","priyanka.das1@sbi.co.in","","AD1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Monish Bhattacharya","8145501538","monishsb@gmail.com","","AD2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Payel Bhattacharya","9038173747","","","AD2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Prasanta Pramanik","9969223053","pramanik.prasanta@gmail.com","","AD3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Atanu Bandopadhay","9735182751","atanuban1981@gmail.com","","AD4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Abhigyan Mukherjee","9830771624","abhigyan.mukherjee@yahoo.com","","AD5","1234");
                userDetailList.add(userDetails);

                //--------------------B-------------------------

                userDetails = new UserDetails("Rajdeep Paul","9742689960","rajdeeppaul07@gmail.com","","BA2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sudipta Biswas","","","","BA2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Rakesh kumar Churasia","8145226123","rakeshchaurasia44@gmail.com","","BA3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Gautam Dutta","9434004230","mithunkundu306@gmail.com","","BA4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Mrinmoy Sarkar","9609016224","","","BA5","1234");
                userDetailList.add(userDetails);

                userDetails = new UserDetails("Naba Kumar Dutta","8777735343","nkd.ccl@gmail.com","","BB1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Mitu Dutta","","","","BB1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Binay Agarwal","9007976069","itsmebinay@yahoo.com","","BB2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Binita Agarwal","8297292200","binita.agarwal@sbi.co.in","","BB2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Tapati Adhikari","9434194202","halder.mridul@gmail.com","","BB3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Soumit Jana","9433847556","soumit_jana@yahoo.co.in","","BB4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Prafulla Kumar Behera","9433255444","pkbehera2002@yahoo.co.in","","BB5","1234");
                userDetailList.add(userDetails);

                userDetails = new UserDetails("Mahendra Pratap Singh","8013808225","mahendra.pailan@gmail.com","","BC1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Debashish Mihir Das","8436517464","debashish_das78@yahoo.com","","BC2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Pratirupa Ghosh Das","","","","BC2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Anish Boral","9831170513","digitalpiku@gmail.com","","BC3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Joykrishna Dey","9434944454","jkdey43@yahoo.com","","BC4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sujan Sarkar","8101246361","ssarkar094@gmail.com","","BC5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Manisha Bagchi","9932961806","imss4104@gmail.com","","BC5","1234");
                userDetailList.add(userDetails);

                userDetails = new UserDetails("Pratik Dutta","8449687769","pratik.hiflier@gmail.com","","BD2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Bornali Pal Choudhury","9836788296","bornali8891@gmail.com","","BD3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sulagna Chaudhuri","9903063960","itpriyesh88@gmail.com","","BD4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Priyesh Prasad","","","","BD4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Raj Kumar Choudhury","9331037142","trplraju@gmail.com","","BD5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Alka Choudhury","7439253342","","","BD5","1234");
                userDetailList.add(userDetails);


                //---------------------C---------------------------

                userDetails = new UserDetails("Susanta Chakraborty","9836721653","susanta1009@gmail.com","","CA3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Abhishek Bose","8420000503","boseabhishek007@gmail.com","","CA4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Minerva Bose","","","","CA4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Subhasis Maity","9432175238","subhasis.maity@tcs.com","","CA5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Subrata Karmakar","9830725880","subratakarmakar.sk@gmail.com","","CB1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Binita Biswas","9438332609","debajitbsws@gmail.com","","CB2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Debajit Biswas","","","","CB2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sukumar Poddar","9835058586","","","CB3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Abhijit Mukherjee","9475941660","abhijit.mukherjee552@gmail.com","","CB4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sourav Saha","9830514102","sourav.saha23504799@gmail.com","","CB5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Kuntal Banerjee","8013165406","banerjee89k@gmail.com","","CC1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sumana Ghosh","","","","CC1","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Bishnu Chetlangia","9851025401","bishnuchetlangia@gmail.com","","CC2","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Subhadeep Mukherjee    ","9903641347","subhadeep.mukherjee81@gmail.com","","CC3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Amar Goswami","9420555235","amargoswami@hotmail.com","","CC4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Madan Mohan Mundhra","971552011400","madan.bbg@gmail.com","","CC5","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Jalprit Saha","9830857757","akshyan7@gmail.com","","CD3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Mithun saha","8017536773","","","CD3","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Sourav Ghosh","8961279107","","","CD4","1234");
                userDetailList.add(userDetails);
                userDetails = new UserDetails("Prashant Sajan","9430768683","prashant.sajan@gmail.com","","CD5","1234");
                userDetailList.add(userDetails);

                myDatabase.userDetailsDao().insertAll(userDetailList);

            }
        }).start();
    }
}
