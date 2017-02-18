package com.sdacademy.otto.joachim.shop.model;

/**
 * Created by RENT on 2017-02-18.
 */

public class Product {
    private int mId;
    private String mName;
    private int mprice;
    private int mImageResId;

    public Product(int mId, String mName, int mprice, int mImageResId) {
        this.mId = mId;
        this.mName = mName;
        this.mprice = mprice;
        this.mImageResId = mImageResId;
    }

    public int getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    public int getMprice() {
        return mprice;
    }

    public int getmImageResId() {
        return mImageResId;
    }
}
