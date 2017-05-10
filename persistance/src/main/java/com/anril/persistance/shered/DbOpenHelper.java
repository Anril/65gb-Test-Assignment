package com.anril.persistance.shered;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.anril.persistance.entities.Person;
import com.anril.persistance.entities.PersonSpeciality;
import com.anril.persistance.entities.Speciality;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Anril on 09.05.2017.
 */

public class DbOpenHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "App65.db";
    private static final int DATABASE_VERSION = 3;


    private RuntimeExceptionDao<Person, Integer> personRuntimeDao;
    private RuntimeExceptionDao<Speciality, Integer> SpecialityRuntimeDao;
    private RuntimeExceptionDao<PersonSpeciality, Integer> personSpecialitiesRuntimeDao;

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Person.class);
            TableUtils.createTable(connectionSource, PersonSpeciality.class);
            TableUtils.createTable(connectionSource, Speciality.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Person.class, true);
            TableUtils.dropTable(connectionSource, PersonSpeciality.class, true);
            TableUtils.dropTable(connectionSource, Speciality.class, true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearTables() {
        try {
            TableUtils.clearTable(getConnectionSource(), Person.class);
            TableUtils.clearTable(getConnectionSource(), Speciality.class);
            TableUtils.clearTable(getConnectionSource(), PersonSpeciality.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RuntimeExceptionDao<Person, Integer> getPersonRuntimeDao() {
        if (personRuntimeDao == null) {
            personRuntimeDao = getRuntimeExceptionDao(Person.class);
        }
        return personRuntimeDao;
    }

    public RuntimeExceptionDao<Speciality, Integer> getSpecialityRuntimeDao() {
        if (SpecialityRuntimeDao == null) {
            SpecialityRuntimeDao = getRuntimeExceptionDao(Speciality.class);
        }
        return SpecialityRuntimeDao;
    }

    public RuntimeExceptionDao<PersonSpeciality, Integer> getPersonSpecialityRuntimeDao() {
        if (personSpecialitiesRuntimeDao == null) {
            personSpecialitiesRuntimeDao = getRuntimeExceptionDao(PersonSpeciality.class);
        }
        return personSpecialitiesRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        personRuntimeDao = null;
        SpecialityRuntimeDao = null;
    }

}
