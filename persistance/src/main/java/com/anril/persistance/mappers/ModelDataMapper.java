package com.anril.persistance.mappers;

import com.anril.domain.models.Speciality;

/**
 * Created by Anril on 10.05.2017.
 */

public class ModelDataMapper {

    public static Speciality specialityMapper(com.anril.persistance.entities.Speciality entity) {
        Speciality model = new Speciality();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }
}
