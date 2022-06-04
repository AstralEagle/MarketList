package com.dias_family.maketlist.model;



import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "items")
public class Item {

    private static List<Item> listItem = new ArrayList<>();

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String itemName;
    private int utilisation;

    //Constructor


    public Item(int id, String itemName, int utilisation) {
        this.id = id;
        this.itemName = itemName;
        this.utilisation = utilisation;
    }

    @Ignore
    public Item(String itemName) {
        this.itemName = itemName;
        this.utilisation = 0;
        listItem.add(this);
    }

    public static Item getItem(String itemName){
        for(Item item : listItem){
            if(itemName.equals(item.getItemName())){
                return item;
            }
        }
        return (new Item(itemName));
    }


    // Fonction qui retourne un item grâce à son ID
    public static Item getItemById(int id){
        for(Item item : listItem){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    // Fonction qui retroune un item grâce à son Nom
    public static Item getItemByName(String itemName){
        for(Item item : listItem){
            if(itemName.equals(item.getItemName())){
                return item;
            }
        }
        return null;
    }


    //Getter et setteur

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUtilisation() {
        return utilisation;
    }

    public void setUtilisation(int utilisation) {
        this.utilisation = utilisation;
    }

    public void addUsation(){
        this.utilisation ++;
    }

    public static List<Item> getAllItems(){
        return listItem;
    }

    // Init list Item
    public static void initListItem(List list){
        listItem = list;
    }
}
