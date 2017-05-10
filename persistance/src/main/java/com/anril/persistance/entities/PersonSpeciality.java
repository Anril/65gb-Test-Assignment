package com.anril.persistance.entities;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Anril on 09.05.2017.
 */

public class PersonSpeciality {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true)
    private Person person;

    @DatabaseField(foreign = true)
    private Speciality speciality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
