package com.dias_family.maketlist.controle.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;


import com.dias_family.maketlist.R;
import com.dias_family.maketlist.model.OnMarketItem;

import java.util.ArrayList;

public class OnMarketAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<OnMarketItem> itemList,staticList;
    private AdapterFiltre valueFilter;

    private boolean isTakin;

    public OnMarketAdapter(Context mContext, ArrayList<OnMarketItem> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.staticList = itemList;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.isTakin = false;
    }

    public void setTakingFiltre(boolean isTakin){
        this.isTakin = isTakin;
    }

    public ArrayList getStaticList(){
        return staticList;
    }

    public ArrayList getIsTakinItem(){
        ArrayList<OnMarketItem> list = new ArrayList<>();
        for(OnMarketItem item : staticList){
            if(item.isOnPanner())
                list.add(item);
        }
        return list;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public OnMarketItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void onCheckItem(View view,int position){
        staticList.get(staticList.indexOf(itemList.get(position))).setOnPanner(true);
        itemList.get(position).setOnPanner(true);
        this.notifyDataSetChanged();
    }
    public void unCheckItem(View view, int position){
        staticList.get(staticList.indexOf(itemList.get(position))).setOnPanner(false);
        itemList.get(position).setOnPanner(false);
        this.notifyDataSetChanged();
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

        OnMarketItem item = this.itemList.get(position);
        holder.itemNameView.setText(item.getItem().getItemName());
        if(item.isOnPanner()){
            convertView.setBackground(mContext.getDrawable(R.drawable.item_on_panner));
        }else{
            convertView.setBackground(null);
        }

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
            if(isTakin){
                if(constraint != null && constraint.length()>0){
                    ArrayList<OnMarketItem> filterList = new ArrayList<OnMarketItem>();
                    for(OnMarketItem item : staticList){
                        if(item.getItem().getItemName().toUpperCase().contains(constraint.toString().toUpperCase()) && !item.isOnPanner()){
                            filterList.add(item);
                        }
                    }
                    results.count = filterList.size();
                    results.values = filterList;
                }else{
                    ArrayList<OnMarketItem> filterList = new ArrayList<OnMarketItem>();
                    for(OnMarketItem item : staticList){
                        if(!item.isOnPanner()){
                            filterList.add(item);
                        }
                    }
                    results.count = filterList.size();
                    results.values = filterList;
                }
            }else{
            if(constraint != null && constraint.length()>0){
                ArrayList<OnMarketItem> filterList = new ArrayList<OnMarketItem>();
                for(OnMarketItem item : staticList){
                    if(item.getItem().getItemName().toUpperCase().contains(constraint.toString().toUpperCase())){

                        filterList.add(item);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }else{
                results.count = staticList.size();
                results.values = staticList;
            }}
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            itemList = (ArrayList<OnMarketItem>) results.values;
            notifyDataSetChanged();

        }
    }

}