package com.anril.persistance.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Anril on 06.05.2017.
 */

public class Speciality {

    @DatabaseField(id = true)
    @SerializedName("specialty_id")
    @Expose
    private int id;

    @DatabaseField
    @SerializedName("name")
    @Expose
    private String name;

    public Speciality() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Speciality)) return false;

        return  ((Speciality)obj).id == id;
    }

}
