package com.imaadhrizni.unknown.ShoppingCart;

import com.imaadhrizni.unknown.Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

public class ProductRepository implements ProductListContract.Repository {
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        for(int i=0; i<10; i++){
            Product p = new Product();
            p.setId(i);
            p.setDescription("DESCRIPTION: " + i);
            p.setProductName("Product: " + i);
            p.setSalePrice(25.0);

            products.add(p);
        }
        return products;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }
}
