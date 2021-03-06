package com.anril.domain.sources;

import com.anril.domain.models.Person;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Anril on 06.05.2017.
 */

public interface PersonDataSource {

    void getById(int id);

    Single<List<Person>> getBySpecialityId(int specialityId);
}
