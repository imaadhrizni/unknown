package com.imaadhrizni.unknown;

import android.app.Application;

import com.imaadhrizni.unknown.Dagger.AppComponent;
import com.imaadhrizni.unknown.Dagger.AppModule;
import com.imaadhrizni.unknown.Dagger.DaggerAppComponent;

/**
 * Created by Imaadh Rizni on 11/27/2016.
 */

public class ShoppingApplication extends Application {

        private static ShoppingApplication instance = new ShoppingApplication();
        private static AppComponent appComponent;

        public static ShoppingApplication getInstance() {
            return instance;
        }

        @Override
        public void onCreate() {
            super.onCreate();
            getAppComponent();
        }

        public AppComponent getAppComponent() {
            if (appComponent == null){
                appComponent = DaggerAppComponent.builder()
                        .appModule(new AppModule(this))
                        .build();
            }
            return appComponent;
        }
}
