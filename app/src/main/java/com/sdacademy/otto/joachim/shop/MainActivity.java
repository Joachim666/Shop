package com.sdacademy.otto.joachim.shop;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdacademy.otto.joachim.shop.View.widget.ProductCardView;
import com.sdacademy.otto.joachim.shop.View.widget.ProductDetailActivity;
import com.sdacademy.otto.joachim.shop.model.Product;
import com.sdacademy.otto.joachim.shop.repository.ProductRepository;
import com.sdacademy.otto.joachim.shop.repository.ProductRepositoryInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ProductCardView.ProductCardViewInterface {

    @BindView(R.id.my_toolbar)
    Toolbar mtoolbar;
    @BindViews({R.id.product_1,R.id.product_2,R.id.product_3,R.id.product_4})
    List<ProductCardView> mProductCardView;

    private ProductRepositoryInterface mProductRepositroy = ProductRepository.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cus);
        ButterKnife.bind(this);

        setupToolbar();
        displayData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private  void setupToolbar(){
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitle("GUN SHOP");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }


    private void displayData() {
        List<Product> products = mProductRepositroy.getProduckts();
        for (int i = 0; i <products.size() ; i++) {
            Product product = products.get(i);
            mProductCardView.get(i).bindTo(product, this);

        }


    }

    @Override
    public void onProductClicked(Product product) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        startActivity(intent);
        intent.putExtra(ProductDetailActivity.INTENT_PRODUCT_ID,product.getmId());


        Log.i("Shop","clicked"+ product.getmName());

    }
}
