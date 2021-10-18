package com.blackbirds.shakil.expandablelistviewexample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.blackbirds.shakil.expandablelistviewexample.MainActivity;
import com.blackbirds.shakil.expandablelistviewexample.Model.CountryModel;
import com.blackbirds.shakil.expandablelistviewexample.R;

import java.util.ArrayList;

public class CountryAdapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<CountryModel> al_country;

    public CountryAdapter(Context context, ArrayList<CountryModel> al_country) {
        this.context = context;
        this.al_country = al_country;
    }

    @Override
    public int getGroupCount() {
        return al_country.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return al_country.get(i).getAl_state().size();
    }

    @Override
    public Object getGroup(int i) {
        return al_country.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return al_country.get(i).getAl_state().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.adapter_header, null);
        }

        TextView tv_state = view.findViewById(R.id.txt_name);
        tv_state.setText(al_country.get(i).getStr_country());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.adapter_childview, null);
        }

        TextView tv_state = view.findViewById(R.id.txt_name);
        tv_state.setText(al_country.get(i).getAl_state().get(i1).getStr_name());
        tv_state.setOnClickListener(view1 -> {
            //((MainActivity)context).fn_selectedPosition(i, i1);
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
