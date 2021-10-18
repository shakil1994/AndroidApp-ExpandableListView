package com.blackbirds.shakil.expandablelistviewexample.Model;

import java.util.ArrayList;

public class CountryModel {
    String str_country;
    ArrayList<DishModel> al_state;

    public CountryModel() {
    }

    public CountryModel(String str_country, ArrayList<DishModel> al_state) {
        this.str_country = str_country;
        this.al_state = al_state;
    }

    public String getStr_country() {
        return str_country;
    }

    public void setStr_country(String str_country) {
        this.str_country = str_country;
    }

    public ArrayList<DishModel> getAl_state() {
        return al_state;
    }

    public void setAl_state(ArrayList<DishModel> al_state) {
        this.al_state = al_state;
    }
}
