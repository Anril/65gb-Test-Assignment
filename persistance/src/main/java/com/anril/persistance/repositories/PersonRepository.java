package com.anril.persistance.repositories;

import com.anril.domain.models.Person;
import com.anril.domain.models.Speciality;
import com.anril.domain.sources.PersonDataSource;

import com.anril.persistance.shered.DbOpenHelper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anril on 06.05.2017.
 */

public class PersonRepository implements PersonDataSource {

    private DbOpenHelper dbOpenHelper;

    public PersonRepository(DbOpenHelper dbOpenHelper) {
        this.dbOpenHelper = dbOpenHelper;
    }

    @Override
    public void getById(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Person> getBySpecialityId(int specialityId) {
        List<Person> persons = null;

        RuntimeExceptionDao<com.anril.persistance.entities.Person, Integer> personDao =
                dbOpenHelper.getPersonRuntimeDao();

        GenericRawResults<Person> rawResults = personDao.queryRaw("SELECT person.id, " +
                "person.firstName, " +
                "person.lastName, " +
                "person.birthday, " +
                "person.avatarUrl FROM speciality " +
                "INNER JOIN personspeciality on speciality.id=personspeciality.speciality_id " +
                "INNER JOIN person on person.id=personspeciality.person_id " +
                "WHERE speciality.id=" + specialityId + ";", new RawRowMapper<Person>() {
            @Override
            public Person mapRow(String[] columnNames, String[] resultColumns) throws SQLException {
                Person person = new Person();
                person.setId(Integer.parseInt(resultColumns[0]));
                person.setFirstName(resultColumns[1]);
                person.setLastName(resultColumns[2]);
                person.setBirthday(resultColumns[3]);
                person.setAvatarUrl(resultColumns[4]);
                return person;
            }
        });
        try {
            persons = rawResults.getResults();
            RuntimeExceptionDao<com.anril.persistance.entities.Speciality, Integer> specialityDao
                    = dbOpenHelper.getSpecialityRuntimeDao();
            for (int i = 0; i < persons.size(); i++) {
                GenericRawResults<Speciality>  rawSpeciality= specialityDao.queryRaw("SELECT speciality.id, " +
                        "speciality.name " +
                        "FROM person " +
                        "INNER JOIN personspeciality  on person.id=personspeciality.person_id " +
                        "INNER JOIN speciality on personspeciality.speciality_id=speciality.id " +
                        "WHERE person.id=" + persons.get(i).getId() + " ;", new RawRowMapper<Speciality>() {
                    @Override
                    public Speciality mapRow(String[] columnNames, String[] resultColumns) throws SQLException {
                        Speciality speciality = new Speciality();
                        speciality.setId(Integer.parseInt(resultColumns[0]));
                        speciality.setName(resultColumns[1]);
                        return speciality;
                    }
                });
                persons.get(i).setSpecialties(rawSpeciality.getResults());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
