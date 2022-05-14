package com.dias_family.maketlist.controle;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.model.Item;

import java.util.ArrayList;

public class ListCourse {

    private static ArrayList<Item> listCourse = new ArrayList<>();

    public static void setList(ArrayList list){
        listCourse = list;
    }

    public static ArrayList<Item> getList(){
        return listCourse;
    }

    //Function qui permet d'ajouter un item dans la list retourne false si l'item y est deja
    public static boolean addItem(String nameItem){
        Item item = Item.getItem(nameItem);
        if(!listCourse.contains(item)) {
            listCourse.add(item);
            return true;
        }else {
            return false;
        }
    }
    public static void removeItem(Item item){
        listCourse.remove(item);
    }
}
