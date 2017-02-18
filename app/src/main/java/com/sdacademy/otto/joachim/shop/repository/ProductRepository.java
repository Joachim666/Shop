package com.sdacademy.otto.joachim.shop.repository;

import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdacademy.otto.joachim.shop.R;
import com.sdacademy.otto.joachim.shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by RENT on 2017-02-18.
 */

public class ProductRepository implements ProductRepositoryInterface {



    private static ProductRepository mInstance = new ProductRepository();

    private Map<Integer,Product>mProducts = new HashMap<>();

    private ProductRepository(){
        Product product1 = new Product(1,"gun 1",1299, R.drawable.images);
        Product product2 = new Product(2,"gun 2",1799, R.drawable.images2);
        Product product3 = new Product(3,"gun 3",1100, R.drawable.images3);
        Product product4 = new Product(4,"gun 4",1999, R.drawable.pobrane);

        mProducts.put(1,product1);
        mProducts.put(2,product2);
        mProducts.put(3,product3);
        mProducts.put(4,product4);

    }

    public static ProductRepositoryInterface getInstance (){
        return mInstance;
    }


    @Override
    public List<Product> getProduckts() {
        return new ArrayList<>(mProducts.values());
    }
}
