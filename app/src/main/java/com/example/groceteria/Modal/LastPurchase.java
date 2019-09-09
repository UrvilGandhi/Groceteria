package com.example.groceteria.Modal;

public class LastPurchase {
    private int drawable;
    private int discount;
    private boolean isLiked;
    private String name;
    private String quantity;
    private int previousRate;
    private int currentPrice;

    public LastPurchase(int drawable, int discount, boolean isLiked, String name, String quantity, int previousRate, int currentPrice) {
        this.drawable = drawable;
        this.discount = discount;
        this.isLiked = isLiked;
        this.name = name;
        this.quantity = quantity;
        this.previousRate = previousRate;
        this.currentPrice = currentPrice;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPreviousRate() {
        return previousRate;
    }

    public void setPreviousRate(int previousRate) {
        this.previousRate = previousRate;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
