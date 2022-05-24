package com.dias_family.maketlist.controle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.model.Item;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter implements Filterable{

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Item> itemList,staticList;
    private AdapterFiltre valueFilter;

    public ItemListAdapter(Context mContext) {
        this.mContext = mContext;
        this.staticList = Item.listItem;
        this.itemList = Item.listItem;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
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

    @Override
    public Filter getFilter() {
        if(valueFilter == null){
            valueFilter = new AdapterFiltre();
        }
        return valueFilter;
    }

    private static class ViewHolder{
        TextView itemNameView;
    }

    private class AdapterFiltre extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length()>0){
                ArrayList<Item> filterList = new ArrayList<Item>();
                for(Item item : staticList){
                    if(item.getItemName().toUpperCase().contains(constraint.toString().toUpperCase())){
                        filterList.add(item);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }else{
                results.count = staticList.size();
                results.values = staticList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            itemList = (ArrayList<Item>) results.values;
            notifyDataSetChanged();

        }
    }

}
