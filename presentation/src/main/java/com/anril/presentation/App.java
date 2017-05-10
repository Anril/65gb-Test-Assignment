package com.anril.presentation;

import android.app.Application;

import com.anril.persistance.entities.Person;
import com.anril.persistance.services.Apps65Api;
import com.anril.persistance.shered.DbOpenHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anril on 09.05.2017.
 */

public class App extends Application {

    private static Apps65Api apps65Service;
    private static DbOpenHelper dbOpenHelper;

    public static Apps65Api getApps65Service() {
        return apps65Service;
    }

    public static DbOpenHelper getDbOpenHelper() {
        return dbOpenHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://178.62.196.215")
                .build();

        apps65Service = retrofit.create(Apps65Api.class);
        dbOpenHelper = new DbOpenHelper(getApplicationContext());
    }
}
