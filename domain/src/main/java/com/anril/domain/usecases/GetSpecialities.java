package com.anril.domain.usecases;

import com.anril.domain.models.Speciality;
import com.anril.domain.sources.SpecialityDataSource;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Anril on 06.05.2017.
 */

public class GetSpecialities {

    private SpecialityDataSource specialityDataSource;

    public GetSpecialities(SpecialityDataSource specialityDataSource) {
        this.specialityDataSource = specialityDataSource;
    }

    public Single<List<Speciality>> execute() {
        return specialityDataSource.getAll();
    }
}
