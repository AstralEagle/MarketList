package com.dias_family.maketlist.controle.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dias_family.maketlist.model.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    public void insetItem(Item item);

    @Update
    public void updateItem(Item item);

    @Delete
    public void deleteItem(Item item);

    @Query("SELECT * FROM items")
    public List<Item> getAllItems();

    @Query("SELECT * FROM items WHERE itemName = :itemName")
    public List<Item> getItemByName(String itemName);

    @Query("SELECT * FROM items WHERE id = :id")
    public Item getItemById(int id);
}
