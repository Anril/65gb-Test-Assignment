package com.anril.domain.sources;

import com.anril.domain.models.Speciality;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Anril on 06.05.2017.
 */

public interface SpecialityDataSource {

    Single<List<Speciality>> getAll();
}
