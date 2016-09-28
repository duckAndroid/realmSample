package com.pythoncat.realmupdate.realm.db;

import com.pythoncat.realmupdate.pojo.Dog;
import com.pythoncat.realmupdate.realm.RealmClient;
import com.pythoncat.realmupdate.realm.module.DogModule;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pythonCat on 2016/9/28 0028.
 * @apiNote a db of realm op dog
 */

public class DogDb {

    private static Realm getRealm(){
        return RealmClient.getRealm(new DogModule());
    }

    public static Dog insertOrUpdate(Dog p) {
        Realm realm = getRealm();
        realm.beginTransaction();
        Dog person = realm.copyToRealm(p);
        Dog po = realm.copyFromRealm(person);
        realm.commitTransaction();
        return po;
    }

    public static List<Dog> insertOrUpdate(List<Dog> p) {
        Realm realm = getRealm();
        realm.beginTransaction();
        List<Dog> Dogs = realm.copyToRealm(p);
        List<Dog> DogList = realm.copyFromRealm(Dogs);
        realm.commitTransaction();
        return DogList;
    }

    public static List<Dog> queryAll() {
        Realm realm = getRealm();
        RealmResults<Dog> all = realm.where(Dog.class).findAll();
        return realm.copyFromRealm(all);
    }
}
