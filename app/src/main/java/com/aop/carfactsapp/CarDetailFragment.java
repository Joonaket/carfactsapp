package com.aop.carfactsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CarDetailFragment extends Fragment {


    public CarDetailFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_car_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        ImageView carPic = view.findViewById(R.id.carPic);
        TextView carName = view.findViewById(R.id.carName);
        TextView carDescSpecs = view.findViewById(R.id.carDescSpecs);
        TextView carDescStory = view.findViewById(R.id.carDescStory);


        String ModelName = getArguments().getString("modelName");

        Model m = MainActivity.database.modelDao().findByName(ModelName);

        if(m != null){
            carPic.setImageResource(m.imageId);
            carName.setText(m.name);
            carDescSpecs.setText(m.specSheet);
            carDescStory.setText(m.story);
        }

    }
}