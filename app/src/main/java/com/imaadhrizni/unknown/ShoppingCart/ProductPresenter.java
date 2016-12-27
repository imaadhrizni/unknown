package com.imaadhrizni.unknown.ShoppingCart;

import com.imaadhrizni.unknown.Model.LineItem;
import com.imaadhrizni.unknown.Model.Product;
import com.imaadhrizni.unknown.ShoppingApplication;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

public class ProductPresenter implements ProductListContract.Actions {
    private final ProductListContract.View mView;
    @Inject
    ProductListContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;


    public ProductPresenter(ProductListContract.View mView) {
        this.mView = mView;
        ShoppingApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void loadProducts() {
        List<Product> availableProducts = mRepository.getAllProducts();
        if (availableProducts != null && availableProducts.size() > 0) {
            //mView.hideEmptyText();
            mView.showProducts(availableProducts);

        } else {
            mView.showEmptyText();
        }

    }

    @Override
    public void onAddProductButtonClicked() {
        mView.showAddProductForm();
    }

    @Override
    public void onAddToCartButtonClicked(Product product) {
        //perform add to checkout button here
        LineItem item = new LineItem(product, 1);
        mCart.addItemToCart(item);
    }

    @Override
    public Product getProduct(long id) {
        return mRepository.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        mRepository.addProduct(product);
    }

    @Override
    public void onDeleteProductButtonClicked(Product product) {
        mView.showDeleteProductPrompt(product);
    }

    @Override
    public void deleteProduct(Product product) {
        mRepository.deleteProduct(product);
        loadProducts();
    }

    @Override
    public void onEditProductButtonClicked(Product product) {
        //mView.showEditProductForm(product);
        mView.showEditProductForm(product);
    }

    @Override
    public void updateProduct(Product product) {
        mRepository.updateProduct(product);
    }

}
