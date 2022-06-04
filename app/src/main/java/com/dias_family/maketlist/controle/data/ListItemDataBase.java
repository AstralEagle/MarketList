package com.dias_family.maketlist.controle.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.ItemList;

@Database(entities = {Item.class,ItemList.class}, version = 1, exportSchema = false)
public abstract class ListItemDataBase extends RoomDatabase {

    private static ListItemDataBase INSTANCE;
    public abstract ItemDao itemDao();
    public abstract  ListDao listDao();

    public static ListItemDataBase getDataBase(Context context){
        if(INSTANCE == null){
            synchronized (ListItemDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ListItemDataBase.class,"product.db").build();
                }
            }
        }
        return INSTANCE;
    }
    //java.lang.IllegalStateException: A migration from 1 to 2 was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.

}
