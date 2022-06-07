package com.dias_family.maketlist.controle;

import android.content.Context;

import com.dias_family.maketlist.controle.data.ItemDao;
import com.dias_family.maketlist.controle.data.ListDao;
import com.dias_family.maketlist.controle.data.ListItemDataBase;
import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class ListCourse {

    //Variable
    private static ArrayList<Item> listCourse = new ArrayList<>();

    //
    //Fonction
    //


    public static void resetList(ArrayList<Item> listCourse) {
        ListCourse.listCourse = listCourse;
    }

    public static ArrayList<Item> getList(){
        return listCourse;
    }

    //Function qui permet d'ajouter un item dans la list retourne false si l'item y est deja
    public static boolean addItem(String nameItem, Context context){
        Item item = getItemByName(nameItem,context);
            if(!listCourse.contains(item)) {
                listCourse.add(item);
                new Thread(
                        ()->{
                            ListItemDataBase dataBase = ListItemDataBase.getDataBase(context);
                            ListDao dao = dataBase.listDao();
                            dao.addItem(new ItemList(item));

                        }
                ).start();
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
                    ListItemDataBase data = ListItemDataBase.getDataBase(context);
                    ItemDao itemDao = data.itemDao();
                    itemDao.insetItem(item);
                }
        ).start();
        return item;
    }

    //Fonction qui permet de supprimer un item de la list de course
    public static void removeItem(Item item, Context context){
        listCourse.remove(item);
        new Thread(
                ()->{
                    ListItemDataBase dataBase = ListItemDataBase.getDataBase(context);
                    ListDao listDao = dataBase.listDao();
                    listDao.removeItem(ItemList.getItemListByItem(item));
                }
        ).start();
    }

    //Fonction qui permet d'initialiser la liste de course grace a une list d'ItemList
    public static void initList(List<ItemList> list){
        for(ItemList itemList : list){
            listCourse.add(itemList.getItem());
        }
    }
}


