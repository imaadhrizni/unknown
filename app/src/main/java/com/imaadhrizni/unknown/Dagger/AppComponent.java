package com.imaadhrizni.unknown.Dagger;

import com.imaadhrizni.unknown.Fragments.Category1Fragment;
import com.imaadhrizni.unknown.MainActivity;
import com.imaadhrizni.unknown.ShoppingCart.ProductListContract;
import com.imaadhrizni.unknown.ShoppingCart.ProductPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class,
                PersistenceModule.class
        }
)
public interface AppComponent {
    void inject(ProductPresenter presenter);
    void inject(MainActivity activity);
    void inject(Category1Fragment category1Fragment);
    void inject(ProductListContract presenter);
}
