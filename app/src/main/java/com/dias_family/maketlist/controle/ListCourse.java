package com.dias_family.maketlist.controle;

import android.content.Context;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.data.DataBase;
import com.dias_family.maketlist.controle.data.ItemDao;
import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.ItemList;

import java.util.ArrayList;
import java.util.List;

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

    public static boolean addItem(String nameItem, Context context){
        Item item = getItemByName(nameItem,context);
            if(!listCourse.contains(item)) {
                listCourse.add(item);
                return true;
            }else {
                return false;
            }
    }

    private static Item getItemByName(String nameItem, Context context){
        for(Item item : Item.getAllItems()){
            if(nameItem.equals(item.getItemName())){
                return item;
            }
        }
        Item item = new Item(nameItem);
        new Thread(
                ()->{
                    DataBase data = DataBase.getDataBase(context);
                    ItemDao itemDao = data.itemDao();
                    itemDao.insetItem(item);
                }
        ).start();
        return item;
    }

    public static void initList(List<ItemList> list){
        for(ItemList itemList : list){
            listCourse.add(Item.getItemById(itemList.getIdProduct()));
        }
    }
}

