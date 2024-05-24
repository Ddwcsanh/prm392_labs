package com.example.basiclistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    final ArrayList<List> list;

    public ListAdapter(ArrayList<List> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewList;
        if(convertView == null) {
            viewList = View.inflate(parent.getContext(), R.layout.list_item, null);
        } else viewList = convertView;
        List list = (List) getItem(position);
        ((TextView) viewList.findViewById(R.id.tvList)).setText(String.format("%s", list.name));
        return viewList;
    }
}
