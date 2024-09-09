package com.aop.carfactsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.GridView;

public class ListGridFragment extends Fragment {

    public ListGridFragment() {
        super(R.layout.fragment_list_grid);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView itemListGrid = view.findViewById(R.id.menugrid);

        Model[] dataset = MainActivity.database.modelDao().getAllModels();
        // Ensure context is passed
        itemListGrid.setAdapter(new ModelListAdapter(requireContext(), dataset));
    }
}
