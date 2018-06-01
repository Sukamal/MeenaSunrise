package suku.com.meenasunrise.model;

public class DirectoryCategoryModel {

    private int categoryId;
    private String categoryName;
    private String categoryImage;
    private String categoryDesc;

    public DirectoryCategoryModel(){

    }

    public DirectoryCategoryModel(int categoryId,String categoryName,String categoryImage,String categoryDesc){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryDesc = categoryDesc;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
