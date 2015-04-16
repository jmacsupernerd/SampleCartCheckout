package com.mcwilliams.sampleaddtocart;

import android.animation.Animator;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dk.animation.circle.CircleAnimationUtil;

import java.util.ArrayList;
import java.util.List;

import at.markushi.ui.CircleButton;


public class ProductList extends ActionBarActivity {

    private ListView products;
    private List<Product> productList;
    private ImageView cart;
    private ImageView cartIcon;
    private CircleButton circleCartIcon;
    private TextView count;
    private int cartCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        products = (ListView) findViewById(R.id.lvProducts);
        cart = (ImageView) findViewById(R.id.ivCart);
        circleCartIcon = (CircleButton) findViewById(R.id.circle_cart_icon);
        count = (TextView) findViewById(R.id.tvCount);

        createListObjects();

        final ProductItemArrayAdapter arrayAdapter = new ProductItemArrayAdapter(this, R.layout.lv_row_product_list, productList);

        products.setAdapter(arrayAdapter);

        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                CircleAnimationUtil util = new CircleAnimationUtil().attachActivity(ProductList.this).setTargetView(view).setDestView(circleCartIcon).setBorderColor(getResources().getColor(R.color.HEBred));
                util.setAnimationListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d("", String.valueOf(position));
                        circleCartIcon.setPressed(true);
                        circleCartIcon.setPressed(false);
                        count.setText(String.valueOf(++cartCount));
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                util.startAnimation();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_list, menu);

        cartIcon = (ImageView) menu.findItem(R.id.cart).getActionView();


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cart) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void createListObjects() {

        productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductName("Green Beans");
        product1.setProductPrice("$0.88");
        product1.setProductImage("http://www.shopsmart.biz/thumbnail.asp?file=assets/images/s102.jpg&maxx=300&maxy=0");

        productList.add(product1);

        Product product2 = new Product();
        product2.setProductName("Canned Corn");
        product2.setProductPrice("$0.88");
        product2.setProductImage("http://img1.wikia.nocookie.net/__cb20140310050002/tlaststand/images/e/ea/Cannedcorn!.jpg");

        productList.add(product2);

        Product product3 = new Product();
        product3.setProductName("Canned Black Beans");
        product3.setProductPrice("$0.88");
        product3.setProductImage("http://www.shopsmart.biz/thumbnail.asp?file=assets/images/s81.jpg&maxx=300&maxy=0");

        productList.add(product3);


    }
}
