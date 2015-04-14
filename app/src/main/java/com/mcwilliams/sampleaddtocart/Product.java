package com.mcwilliams.sampleaddtocart;

/**
 * Created by joshuamcwilliams on 4/13/15.
 */
public class Product {
    private String productName;
    private String productImage;
    private String productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
