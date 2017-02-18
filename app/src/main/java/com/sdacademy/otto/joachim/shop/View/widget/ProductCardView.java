package com.sdacademy.otto.joachim.shop.View.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdacademy.otto.joachim.shop.MainActivity;
import com.sdacademy.otto.joachim.shop.R;
import com.sdacademy.otto.joachim.shop.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RENT on 2017-02-18.
 */

public class ProductCardView extends CardView {

public interface ProductCardViewInterface{
    void onProductClicked (Product product);
}

    @BindView(R.id.imageView)
    ImageView mpoductimage;
    @BindView(R.id.productname)
    TextView mproductname;
    @BindView(R.id.productprice)
    TextView mproductprice;



    public ProductCardView(Context context) {
        super(context);
        init();
    }

    public ProductCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProductCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_product_card_view,this);
        ButterKnife.bind(this);



    }

    public void bindTo(final Product product, final ProductCardViewInterface productCardVIewInterface) {
        mproductname.setText(product.getmName());
        mproductprice.setText(String.valueOf(product.getMprice()));
        mpoductimage.setImageResource(product.getmImageResId());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                productCardVIewInterface.onProductClicked(product);
            }
        });

    }
}
