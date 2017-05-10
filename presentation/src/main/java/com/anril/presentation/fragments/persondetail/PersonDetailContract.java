package com.anril.presentation.fragments.persondetail;

import com.anril.presentation.models.Person;

/**
 * Created by Anril on 08.05.2017.
 */

public interface PersonDetailContract {

    interface View {
        void showPerson(Person person);
        Person getPersonFromIntent();
    }

    interface Presenter {
        void onCreate();
    }
}
