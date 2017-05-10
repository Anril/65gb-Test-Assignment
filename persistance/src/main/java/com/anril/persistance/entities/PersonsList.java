package com.anril.persistance.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Anril on 09.05.2017.
 */

public class PersonsList {
    @SerializedName("response")
    @Expose
    private List<Person> persons = null;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
