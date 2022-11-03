package com.falconj.javacalory;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.List;

public class DataModel {

    private List<String> nestedList;
    private String itemText;
    private Integer mealImage;
    private boolean isExpandable;

    public DataModel(List<String> nestedList, String itemText, Integer mealImage) {
        this.nestedList = nestedList;
        this.itemText = itemText;
        this.mealImage = mealImage;
        isExpandable = false;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public Integer getMealImage() {
        return mealImage;
    }

    public boolean isExpandable() {
        return isExpandable;
    }
}
