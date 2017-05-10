package com.anril.persistance.repositories;

import com.anril.domain.models.Speciality;
import com.anril.domain.sources.SpecialityDataSource;
import com.anril.persistance.mappers.ModelDataMapper;
import com.anril.persistance.shered.DbOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anril on 06.05.2017.
 */

public class SpecialityRepository implements SpecialityDataSource {

    private DbOpenHelper dbOpenHelper;

    public SpecialityRepository(DbOpenHelper dbOpenHelper) {
        this.dbOpenHelper = dbOpenHelper;
    }

    @Override
    public List<Speciality> getAll() {
        RuntimeExceptionDao<com.anril.persistance.entities.Speciality, Integer> specialityDao =
                dbOpenHelper.getSpecialityRuntimeDao();
        List<com.anril.persistance.entities.Speciality> entities = specialityDao.queryForAll();

        List<Speciality> specialities = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            specialities.add(ModelDataMapper.specialityMapper(entities.get(i)));
        }

        return specialities;
    }
}
