package com.aop.carfactsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ModelListAdapter extends BaseAdapter {
    private Context mContext;
    private Model[] mDataset;

    public ModelListAdapter(Context context, Model[] dataset) {
        this.mContext = context; // Initialize context
        this.mDataset = dataset;
    }

    @Override
    public int getCount() {
        return mDataset.length;
    }

    @Override
    public Object getItem(int position) {
        return mDataset[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Ensure context is properly used to inflate layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.carPic);
            holder.textView = convertView.findViewById(R.id.carName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(mDataset[position].name);
        holder.imageView.setImageResource(mDataset[position].imageId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("modelName", mDataset[position].name);
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.carDetailFragment, bundle);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
