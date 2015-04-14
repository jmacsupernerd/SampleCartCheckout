package com.mcwilliams.sampleaddtocart;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by m439047 on 10/30/13.
 */
public class ProductItemArrayAdapter extends ArrayAdapter<Product> {
    private static final String TAG = ProductItemArrayAdapter.class.getSimpleName();
    private final Activity context;
    private List<Product> productItemList;
    private int resource;

    public ProductItemArrayAdapter(Activity context, int resource, List<Product> productItemList) {
        super(context, resource, productItemList);
        this.context = context;
        this.productItemList = productItemList;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewContainer;
        View rowView = view;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(resource, null, true);
            //---create a view container object---
            viewContainer = new ViewHolder();
            //---get the references to all the views in the row---
            viewContainer.productName = (TextView) rowView.findViewById(R.id.tvProductNameProductLists);
            viewContainer.productPrice = (TextView) rowView.findViewById(R.id.tvProductListPriceProductList);
            viewContainer.productImage = (ImageView) rowView.findViewById(R.id.ivProductSmallListImage);
            //viewContainer.progressBar = (ProgressBar) rowView.findViewById(R.id.pbProductImage);
            //---assign the view container to the rowView---
            rowView.setTag(viewContainer);
        } else {
            //---view was previously created; can recycle---
            viewContainer = (ViewHolder) rowView.getTag();
        }
        //---customize the content of each row based on position---
        //viewContainer.progressBar.setVisibility(View.VISIBLE);
        Product product = productItemList.get(position);

        Picasso.with(getContext()).load(product.getProductImage()).into(viewContainer
                .productImage, null);
        viewContainer.productName.setText(product.getProductName());
        viewContainer.productPrice.setText(product.getProductPrice());
        //
        return rowView;
    }


    static class ViewHolder {
        TextView productName;
        TextView productPrice;
        ImageView productImage;
        ProgressBar progressBar;
    }
}

