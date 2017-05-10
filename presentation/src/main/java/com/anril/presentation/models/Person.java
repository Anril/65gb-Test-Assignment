package com.anril.presentation.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Anril on 07.05.2017.
 */

public class Person implements Parcelable{

    private int id;
    private String firstName;
    private String lastName;
    private long birthday;

    private String[] specialties;

    private String avatarUrl;

    public Person() { }


    protected Person(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        birthday = in.readLong();
        specialties = in.createStringArray();
        avatarUrl = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

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

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String[] getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String[] specialties) {
        this.specialties = specialties;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getAge() {
        if (birthday ==0 )
            return 0;
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now - birthday);
        return calendar.get(Calendar.YEAR) - 1970;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeLong(birthday);
        dest.writeStringArray(specialties);
        dest.writeString(avatarUrl);
    }
}


