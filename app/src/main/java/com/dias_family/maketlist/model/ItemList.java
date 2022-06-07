package com.dias_family.maketlist.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "listProduct")
public class ItemList {

    private static List<ItemList> listItem = new ArrayList<ItemList>();

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Embedded(prefix = "item_")
    private Item item;

    public ItemList(Item item){
        this.item = item;
        listItem.add(this);
    }

    public ItemList(){
        listItem.add(this);
    }

    //Setter Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    //
    public static void initList(List<ItemList> list){
       listItem = list;
    }

    public static List<ItemList> getList() {
        return listItem;
    }

    public static ItemList getItemListByItem(Item item){
        for(ItemList list : listItem){
            if(list.getItem() == item){
                return list;
            }
        }
        return null;
    }

}
