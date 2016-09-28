package com.pythoncat.realmupdate.realm.migration;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by pythonCat on 2016/9/28 0028.
 *
 * @see <b><a href="http://www.jianshu.com/p/8cb639a78975">realm 数据库 迁移 @简书</a></b>
 *
 * @apiNote realm Migration
 */

public class PersonMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if (oldVersion == 0) {
            schema.get("Person")
                    .addField("read", boolean.class);
//            oldVersion++;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PersonMigration;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
