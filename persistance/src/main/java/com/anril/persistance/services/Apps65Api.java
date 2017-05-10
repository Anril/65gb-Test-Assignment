package com.anril.persistance.services;

import com.anril.persistance.entities.PersonsList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anril on 06.05.2017.
 */

public interface Apps65Api {
    @GET("/images/testTask.json")
    Call<PersonsList> fetchAllData();
}
