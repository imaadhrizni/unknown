package com.imaadhrizni.unknown.Dagger;

import android.content.Context;

import com.imaadhrizni.unknown.ShoppingApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

@Module
public class AppModule {

    private final ShoppingApplication app;

    public AppModule(ShoppingApplication app) {
        this.app = app;
    }


    @Provides @Singleton
    public Context provideContext() {
        return app;
    }
}

