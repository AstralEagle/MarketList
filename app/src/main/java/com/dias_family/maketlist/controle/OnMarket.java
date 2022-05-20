package com.dias_family.maketlist.controle;

import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.OnMarketItem;

import java.util.ArrayList;
import java.util.HashMap;

public class OnMarket {

    private static ArrayList<OnMarketItem> listOnMarket;

    public static void initList(ArrayList<Item> listItem){
        listOnMarket = new ArrayList<OnMarketItem>();
        for(Item item : listItem){
            listOnMarket.add(new OnMarketItem(item));
        }
    }

    public static ArrayList<OnMarketItem> getListOnMarket() {
        return listOnMarket;
    }

    public static void onLeaveMarket(){
        for(OnMarketItem item : listOnMarket){
            if(item.isOnPanner()){
                item.getItem().addUsation();
            }
        }

    }
}
