package com.dias_family.maketlist.controle.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dias_family.maketlist.model.ItemList;

import java.util.List;

@Dao
public interface ListDao {

    @Insert
    public void addItem(ItemList item);

    @Delete
    public void removeItem(ItemList item);

    @Query("DELETE FROM listProduct")
    public void removeAllItem();

    @Query("SELECT * FROM listProduct")
    public List<ItemList> initList();



}
