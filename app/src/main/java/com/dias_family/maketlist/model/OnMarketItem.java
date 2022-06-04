package com.dias_family.maketlist.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "onMarketItem")
public class OnMarketItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Embedded(prefix = "item_")
    private Item item;

    private boolean isOnPanner;

    public OnMarketItem(int id, Item item, boolean isOnPanner) {
        this.id = id;
        this.item = item;
        this.isOnPanner = isOnPanner;
    }

    @Ignore
    public OnMarketItem(Item item) {
        this.item = item;
        this.isOnPanner = false;
    }

    public Item getItem() {
        return item;
    }

    public boolean isOnPanner() {
        return isOnPanner;
    }

    public void setOnPanner(boolean onPanner) {
        isOnPanner = onPanner;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
