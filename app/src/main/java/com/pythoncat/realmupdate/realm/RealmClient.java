package com.pythoncat.realmupdate.realm;

import com.pythoncat.realmupdate.realm.migration.PersonMigration;
import com.pythoncat.realmupdate.realm.module.PersonModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by pythonCat on 2016/9/28 0028.
 *
 * @apiNote a client of produce realm object
 */

public class RealmClient {

    public static Realm getRealm() {
        RealmConfiguration myConfig = new RealmConfiguration.Builder()
                .name("p.realm")
                .modules(new PersonModule())
                .build();
        return Realm.getInstance(myConfig);
    }

    public static Realm getRealm(Object module) {

        RealmConfiguration myConfig = new RealmConfiguration.Builder()
                .name(module.getClass().getName())
                .schemaVersion(1) // Must be bumped when the schema changes
                .migration(new PersonMigration()) // Migration to run instead of throwing an exception
                .modules(module)
                .build();
        return Realm.getInstance(myConfig);
    }
}
