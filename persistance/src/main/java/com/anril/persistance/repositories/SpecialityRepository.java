package com.anril.persistance.repositories;

import com.anril.domain.models.Speciality;
import com.anril.domain.sources.SpecialityDataSource;
import com.anril.persistance.mappers.ModelDataMapper;
import com.anril.persistance.shered.DbOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Anril on 06.05.2017.
 */

public class SpecialityRepository implements SpecialityDataSource {

    private DbOpenHelper dbOpenHelper;

    public SpecialityRepository(DbOpenHelper dbOpenHelper) {
        this.dbOpenHelper = dbOpenHelper;
    }

    @Override
    public Single<List<Speciality>> getAll() {
        return Single.create(new SingleOnSubscribe<List<Speciality>>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<List<Speciality>> e) throws Exception {
                RuntimeExceptionDao<com.anril.persistance.entities.Speciality, Integer> specialityDao =
                        dbOpenHelper.getSpecialityRuntimeDao();
                List<com.anril.persistance.entities.Speciality> entities = specialityDao.queryForAll();

                List<Speciality> specialities = new ArrayList<>();
                for (int i = 0; i < entities.size(); i++) {
                    specialities.add(ModelDataMapper.specialityMapper(entities.get(i)));
                }

                e.onSuccess(specialities);
            }
        });
    }
}
