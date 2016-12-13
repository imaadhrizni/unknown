package com.imaadhrizni.unknown.Dagger;

import android.content.Context;

import com.imaadhrizni.unknown.Model.Product;
import com.imaadhrizni.unknown.ShoppingCart.ProductListContract;
import com.imaadhrizni.unknown.ShoppingCart.ProductRepository;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

@Module
public class PersistenceModule {
    @Provides
    public ProductListContract.Repository providesProductRepository(Context context) {
        return new ProductRepository();
    }
}

