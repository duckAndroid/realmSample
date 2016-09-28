package com.pythoncat.realmupdate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.realmupdate.pojo.Dog;
import com.pythoncat.realmupdate.pojo.Person;
import com.pythoncat.realmupdate.realm.db.DogDb;
import com.pythoncat.realmupdate.realm.db.PersonDb;
import com.pythoncat.realmupdate.utils.ToastHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initPerson();
        initDog();
    }

    private void initDog() {
        findViewById(R.id.btn_add_dog).setOnClickListener(v -> {
            Observable.defer(() -> Observable.just(DogDb.insertOrUpdate(getDogList())))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(list -> {
                                LogUtils.w("添加 dog 6 完成");
                                LogUtils.e(list.hashCode());
                                LogUtils.e(list);
                            }, Throwable::printStackTrace,
                            () -> ToastHelper.showShort("添加 dog 6 完成"));
        });
        findViewById(R.id.btn_remove_dog).setOnClickListener(v -> {

        });
        findViewById(R.id.btn_query_dog).setOnClickListener(v -> {
            Observable.defer(() -> Observable.just(DogDb.queryAll()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(list -> {
                                LogUtils.e("\"查询 dog 6 完成\"");
                                LogUtils.e(list.hashCode());
                                LogUtils.e(list);

                            }, Throwable::printStackTrace
                            , () -> ToastHelper.showShort("查询 dog 6 完成"));
        });

    }

    private void initPerson() {
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            Observable.defer(() -> Observable.just(PersonDb.insertOrUpdate(getPersonList())))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(data -> {
                                LogUtils.w("添加 person 6 完成！");
                                LogUtils.e(data.hashCode());
                                LogUtils.e(data);
                            }, Throwable::printStackTrace,
                            () -> ToastHelper.showShort("添加 person 6 完成！"));

        });
        findViewById(R.id.btn_remove).setOnClickListener(v -> {


        });

        findViewById(R.id.btn_query).setOnClickListener(v -> {

            Observable.defer(() -> Observable.just(PersonDb.queryAll()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(data -> {
                                LogUtils.e("查询 person 6 完成！");
                                LogUtils.e(data.hashCode());
                                LogUtils.e(data);
                            }, Throwable::printStackTrace,
                            () -> ToastHelper.showShort("查询 person 6 完成！"));
        });
    }


    private List<Person> getPersonList() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Person p = new Person();
            p.id = UUID.randomUUID().toString();
            p.age = new Random().nextInt(100);
            p.name = "name " + p.age;
            p.sex = new Random().nextBoolean();
            p.read = new Random().nextBoolean();
            personArrayList.add(p);
        }
        return personArrayList;
    }

    private List<Dog> getDogList() {
        ArrayList<Dog> personArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Dog p = new Dog();
            p.id = UUID.randomUUID().toString();
            p.age = new Random().nextInt(100);
            p.category = "name " + p.age;
            personArrayList.add(p);
        }
        return personArrayList;
    }
}
