package com.anril.persistance.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

import java.util.List;

/**
 * Created by Anril on 09.05.2017.
 */

public class Person {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    @SerializedName("f_name")
    @Expose
    private String firstName;

    @DatabaseField
    @SerializedName("l_name")
    @Expose
    private String lastName;

    @DatabaseField
    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("specialty")
    @Expose
    private List<Speciality> specialties;

    @DatabaseField
    @SerializedName("avatr_url")
    @Expose
    private String avatarUrl;

    public Person() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Speciality> specialties) {
        this.specialties = specialties;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
