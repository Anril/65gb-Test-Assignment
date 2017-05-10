package com.anril.domain.sources;

import com.anril.domain.models.Speciality;

import java.util.List;

/**
 * Created by Anril on 06.05.2017.
 */

public interface SpecialityDataSource {

    List<Speciality> getAll();
}
