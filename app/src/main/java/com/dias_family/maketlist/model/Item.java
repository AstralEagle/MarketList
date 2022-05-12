package com.dias_family.maketlist.model;

import com.dias_family.maketlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {

    public static List<Item> listCourse = new ArrayList<>();

    public static HashMap<String, Item> listItem = new HashMap<>();

    private String itemName;
    private int utilisation;

    private Item(String itemname) {
        this.itemName = itemname;
        this.utilisation = 0;

        listItem.put(itemname, this);
    }

    // Fonction qui ajoute l'item a la liste de course, si il n'existe pas encore il le créer.
    public void putItemOnCourse(String itemName) {

        if (!listItem.containsKey(itemName)) {

            listCourse.add(new Item(itemName));

        } else {
            listCourse.add(listItem.get(itemName));
            System.out.println(R.string.item_existant);
        }
    }

}
