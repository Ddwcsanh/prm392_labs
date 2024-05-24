package com.example.customlistview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.customlistview.R;
import com.example.customlistview.models.Fruits;

import java.util.ArrayList;

public class FruitAdapter extends BaseAdapter {

    final ArrayList<Fruits> listFruits;

    public FruitAdapter(ArrayList<Fruits> listFruits) {
        this.listFruits = listFruits;
    }

    @Override
    public int getCount() {
        return listFruits.size();
    }

    @Override
    public Object getItem(int position) {
        return listFruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listFruits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewList;
        if (convertView == null) {
            viewList = View.inflate(parent.getContext(), R.layout.item_custom_list_view, null);
        } else viewList = convertView;

        final Fruits fruits = listFruits.get(position);

        ((TextView) viewList.findViewById(R.id.tvTitle)).setText(fruits.getName());
        ((TextView) viewList.findViewById(R.id.tvSubTitle)).setText(String.format("%s%s", fruits.getName(), fruits.getDescription()));
        ((ImageView) viewList.findViewById(R.id.imageFruit)).setImageResource(fruits.getImageUrl());

        return viewList;
    }
}
