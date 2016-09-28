package com.pythoncat.realmupdate.realm.db;

import com.pythoncat.realmupdate.pojo.Person;
import com.pythoncat.realmupdate.realm.RealmClient;
import com.pythoncat.realmupdate.realm.module.PersonModule;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pythonCat on 2016/9/28 0028.
 *
 * @apiNote a realm db of person
 */

public class PersonDb {


    private static Realm getRealm(){
        return RealmClient.getRealm(new PersonModule());
    }

    public static Person insertOrUpdate(Person p) {
        Realm realm = getRealm();
        realm.beginTransaction();
        Person person = realm.copyToRealm(p);
        Person po = realm.copyFromRealm(person);
        realm.commitTransaction();
        return po;
    }

    public static List<Person> insertOrUpdate(List<Person> p) {
        Realm realm = getRealm();
        realm.beginTransaction();
        List<Person> persons = realm.copyToRealm(p);
        List<Person> personList = realm.copyFromRealm(persons);
        realm.commitTransaction();
        return personList;
    }

    public static List<Person> queryAll() {
        Realm realm = getRealm();
        RealmResults<Person> all = realm.where(Person.class).findAll();
        return realm.copyFromRealm(all);
    }
}
