package com.anril.domain.usecases;

import com.anril.domain.models.Person;
import com.anril.domain.sources.PersonDataSource;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Anril on 06.05.2017.
 */

public class GetPersonsBySpecialityId {

    private PersonDataSource personDataSource;

    public GetPersonsBySpecialityId(PersonDataSource personDataSource) {
        this.personDataSource = personDataSource;
    }

    public Single<List<Person>> execute(int id) {
        return personDataSource.getBySpecialityId(id);
    }

}
