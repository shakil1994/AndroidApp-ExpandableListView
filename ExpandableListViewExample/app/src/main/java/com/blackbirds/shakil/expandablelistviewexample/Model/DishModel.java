package com.blackbirds.shakil.expandablelistviewexample.Model;

public class DishModel {
    String str_name;
    String str_description;
    String str_image;

    public DishModel(String str_name, String str_description, String str_image) {
        this.str_name = str_name;
        this.str_description = str_description;
        this.str_image = str_image;
    }

    public String getStr_name() {
        return str_name;
    }

    public void setStr_name(String str_name) {
        this.str_name = str_name;
    }

    public String getStr_description() {
        return str_description;
    }

    public void setStr_description(String str_description) {
        this.str_description = str_description;
    }

    public String getStr_image() {
        return str_image;
    }

    public void setStr_image(String str_image) {
        this.str_image = str_image;
    }
}
