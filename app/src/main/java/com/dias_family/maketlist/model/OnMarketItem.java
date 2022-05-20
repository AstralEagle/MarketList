package com.dias_family.maketlist.model;

public class OnMarketItem {

    private Item item;
    private boolean isOnPanner;

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
}
