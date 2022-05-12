package com.dias_family.maketlist.model;

import com.dias_family.maketlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {


    public static HashMap<String, Item> listItem = new HashMap<>();

    private String itemName;
    private int utilisation;

    //Constructor
    private Item(String itemname) {
        this.itemName = itemname;
        this.utilisation = 0;

        listItem.put(itemname, this);
    }

    // Fonction qui ajoute l'item a la liste de course, si il n'existe pas encore il le créer.
    public Item putItemOnCourse(String itemName) {

        if (!listItem.containsKey(itemName)) {
            return (new Item(itemName));
        } else {
            return (listItem.get(itemName));
        }
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
