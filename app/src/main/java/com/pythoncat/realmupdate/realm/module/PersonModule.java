package com.pythoncat.realmupdate.realm.module;

import com.pythoncat.realmupdate.pojo.Person;

import io.realm.annotations.RealmModule;

/**
 * Created by pythonCat on 2016/9/28 0028.
 *
 * @apiNote a module of realm db pojo
 */
@RealmModule(classes = {Person.class})
public class PersonModule {
}
