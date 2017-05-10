package com.anril.persistance.services;

import com.anril.domain.sources.App65DataSource;
import com.anril.persistance.entities.Person;
import com.anril.persistance.entities.PersonSpeciality;
import com.anril.persistance.entities.Speciality;
import com.anril.persistance.shered.DbOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anril on 08.05.2017.
 */

public class App65Service implements App65DataSource {

    private Apps65Api service;
    private DbOpenHelper dbOpenHelper;

    public App65Service(Apps65Api service, DbOpenHelper dbOpenHelper) {
        this.service = service;
        this.dbOpenHelper = dbOpenHelper;
    }

    @Override
    public void fetchData() {
        try {
            List<Person> persons = service.fetchAllData().execute().body().getPersons();
            saveData(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData(List<Person> persons) {
        RuntimeExceptionDao<Person, Integer> personDao = dbOpenHelper.getPersonRuntimeDao();
        RuntimeExceptionDao<Speciality, Integer> specialityDao =
                dbOpenHelper.getSpecialityRuntimeDao();

        RuntimeExceptionDao<PersonSpeciality, Integer> personSpecialityDao =
                dbOpenHelper.getPersonSpecialityRuntimeDao();

        List<Speciality> specialities = new ArrayList<>();
        List<PersonSpeciality> personSpecialities = new ArrayList<>();

        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).setId(i);
            persons.get(i).setFirstName(normalizeString(persons.get(i).getFirstName()));
            persons.get(i).setLastName(normalizeString(persons.get(i).getLastName()));

            for (int j = 0; j < persons.get(i).getSpecialties().size(); j++) {
                if (!specialities.contains(persons.get(i).getSpecialties().get(j))) {
                    specialities.add(persons.get(i).getSpecialties().get(j));
                }
                PersonSpeciality tmpPersonSpeciality = new PersonSpeciality();
                tmpPersonSpeciality.setPerson(persons.get(i));
                tmpPersonSpeciality.setSpeciality(persons.get(i).getSpecialties().get(j));
                personSpecialities.add(tmpPersonSpeciality);
            }
        }
        dbOpenHelper.clearTables();
        personDao.create(persons);
        specialityDao.create(specialities);
        personSpecialityDao.create(personSpecialities);
    }

    private String normalizeString(String str) {
        StringBuilder strBuilder = new StringBuilder(str.toLowerCase());
        strBuilder = strBuilder.replace(0, 1, strBuilder.substring(0, 1).toUpperCase());
        return strBuilder.toString();
    }
}
