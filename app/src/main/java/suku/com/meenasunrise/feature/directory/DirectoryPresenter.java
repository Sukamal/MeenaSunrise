package suku.com.meenasunrise.feature.directory;

import java.util.ArrayList;

import javax.inject.Inject;

import suku.com.meenasunrise.feature.directory.DirectoryContract.presenter;
import suku.com.meenasunrise.model.DirectoryCategoryModel;

public class DirectoryPresenter implements presenter{

    private DirectoryContract.view view;

    @Inject
    public DirectoryPresenter(DirectoryContract.view view){
        this.view = view;
    }

    @Override
    public void loadData() {
        view.displayCategory(populateCategory());
    }

    @Override
    public void receiveRoutingData(int code) {

        if(code == 1){
            view.openFlatOwnerContactScreen();
        }else if(code == 2){
            view.openCommityMemberContactScreen();
        }else if(code == 3){
            view.openCommunityContactScreen();
        }else if(code == 4){
            view.openFecilityContactScreen();
        }
    }

    private ArrayList<DirectoryCategoryModel> populateCategory(){

        ArrayList<DirectoryCategoryModel> categoryModels = new ArrayList<>();
        DirectoryCategoryModel categoryModel;
        categoryModel = new DirectoryCategoryModel(1,"Flat Owner",null,"All flat owners contact details");
        categoryModels.add(categoryModel);
        categoryModel = new DirectoryCategoryModel(2,"Committee Members",null,"Committee members detail");
        categoryModels.add(categoryModel);
        categoryModel = new DirectoryCategoryModel(3,"Community",null,"Community contact details");
        categoryModels.add(categoryModel);
        categoryModel = new DirectoryCategoryModel(4,"Facilities",null,"Other facility service contact details ");
        categoryModels.add(categoryModel);

        return categoryModels;

    }
}
