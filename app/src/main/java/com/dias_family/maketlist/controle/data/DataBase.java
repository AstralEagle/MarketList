package com.dias_family.maketlist.controle.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.ItemList;

@Database(entities = {Item.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase INSTANCE;
    public abstract ItemDao itemDao();

    public static DataBase getDataBase(Context context){
        if(INSTANCE == null){
            synchronized (DataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DataBase.class,"itemList").build();
                }
            }
        }
        return INSTANCE;
    }

}
