package com.blackbirds.shakil.expandablelistviewexample.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbirds.shakil.expandablelistviewexample.R;

public class HomeFragment extends Fragment {

    View view;

    TextView tv_dishName, txt_description;
    ImageView iv_image;
    String strName, strDishName, strDes, strImageName;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        return root;
    }

    private void init() {
        strName = getArguments().getString("name");
        strDishName = getArguments().getString("dish");
        strDes = getArguments().getString("des");
        strImageName = getArguments().getString("image");
        tv_dishName = view.findViewById(R.id.tv_dishname);
        txt_description = view.findViewById(R.id.tv_description);
        iv_image = view.findViewById(R.id.img_image);

        tv_dishName.setText(strDishName);
        txt_description.setText(strDes);

        int resourceImage = getActivity().getResources().getIdentifier(strImageName, "drawable", getActivity().getPackageName());
        iv_image.setImageResource(resourceImage);
    }
}