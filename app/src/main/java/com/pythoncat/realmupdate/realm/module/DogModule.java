package com.pythoncat.realmupdate.realm.module;

import com.pythoncat.realmupdate.pojo.Dog;
import com.pythoncat.realmupdate.pojo.Person;

import io.realm.annotations.RealmModule;

/**
 * Created by pythonCat on 2016/9/28 0028.
 * @apiNote a module of realm db
 */
@RealmModule(classes = { Person.class, Dog.class })
public class DogModule {
}
