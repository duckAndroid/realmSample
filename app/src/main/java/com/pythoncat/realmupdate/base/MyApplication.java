package com.pythoncat.realmupdate.base;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by pythonCat on 2016/9/22 0022.
 *
 * @apiNote application
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        App.set(this);
        init();
    }

    private void init() {
        Realm.init(this);

    }
}
