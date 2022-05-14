package com.dias_family.maketlist.controle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.dias_family.maketlist.R;
import com.dias_family.maketlist.model.Item;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public CourseAdapter(Context mContext, ArrayList<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_list_course,null);
            holder = new ViewHolder();
            holder.itemNameView = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = this.itemList.get(position);
        holder.itemNameView.setText(item.getItemName());

        return convertView;

    }

    static class ViewHolder{
        TextView itemNameView;
    }
}