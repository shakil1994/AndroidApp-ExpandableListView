package com.blackbirds.shakil.expandablelistviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackbirds.shakil.expandablelistviewexample.Adapter.CountryAdapter;
import com.blackbirds.shakil.expandablelistviewexample.Fragment.HomeFragment;
import com.blackbirds.shakil.expandablelistviewexample.Model.CountryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> al_main = new ArrayList();
    ExpandableListView ev_list;
    CountryAdapter objAdapter;
    DrawerLayout drawerLayout;
    HomeFragment homeFragment;
    TextView tv_name;
    RelativeLayout rl_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fn_data();

        init();
    }

    private void init() {
        getSupportActionBar().hide();
        ev_list = findViewById(R.id.ev_menu);
        tv_name = findViewById(R.id.txt_name);
        rl_menu = findViewById(R.id.relative_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        objAdapter = new CountryAdapter(this, al_main);
        ev_list.setAdapter(objAdapter);
        ev_list.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            setListViewHeight(parent, groupPosition);
            return false;
        });

        setExpandableListViewHeightBaseOnChild(ev_list);
        homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", al_main.get(0).getStr_country());
        bundle.putString("des", al_main.get(0).getAl_state().get(0).getStr_description());
        bundle.putString("dish", al_main.get(0).getAl_state().get(0).getStr_name());
        bundle.putString("image", al_main.get(0).getAl_state().get(0).getStr_image());
        tv_name.setText(al_main.get(0).getStr_country());

        homeFragment.setArguments(bundle);


    }

    private void fn_data() {

    }
}