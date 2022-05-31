package com.dias_family.maketlist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "listProduct")
public class ItemList {

    private static List<ItemList> listItem;

    @PrimaryKey
    private int idProduct;

    public ItemList(int idProduct) {
        this.idProduct = idProduct;
    }

    public void initList(List<ItemList> list){
       listItem = list;
    }

    public static List<ItemList> getList() {
        return listItem;
    }

    public int getIdProduct() {
        return idProduct;
    }
}
