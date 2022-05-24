package com.dias_family.maketlist.model;

import com.dias_family.maketlist.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item implements Serializable {


    public static ArrayList<Item> listItem = new ArrayList<>();

    private String itemName;
    private int utilisation;

    //Constructor
    private Item(String itemname) {
        this.itemName = itemname;
        this.utilisation = 0;

        listItem.add(this);
    }

    // Fonction qui ajoute l'item a la liste de course, si il n'existe pas encore il le créer.
    public static Item getItem(String itemName) {

        for(Item item : listItem){
            if(itemName.equals(item.getItemName())){
                return item;
            }
        }
        return (new Item(itemName));
    }


    //Getter et setteur
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUtilisation() {
        return utilisation;
    }

    public void addUsation() {
        this.utilisation++;
    }
}
