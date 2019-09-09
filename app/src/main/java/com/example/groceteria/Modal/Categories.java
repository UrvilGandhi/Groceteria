package com.example.groceteria.Modal;

public class Categories {
    private int drawable;
    private String prodName;

    public Categories(int drawable, String prodName) {
        this.drawable = drawable;
        this.prodName = prodName;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
