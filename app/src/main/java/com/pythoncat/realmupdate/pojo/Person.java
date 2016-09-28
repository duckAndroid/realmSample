package com.pythoncat.realmupdate.pojo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by pythonCat on 2016/9/28 0028.
 *
 * @apiNote pojo
 */

public class Person  extends RealmObject{

    @PrimaryKey
    public String id;
    public String name;
    public int age;
    public boolean sex;
    public boolean read;
}
