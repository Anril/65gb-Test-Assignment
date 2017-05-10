package com.anril.presentation.fragments.persondetail;

import com.anril.presentation.models.Person;

/**
 * Created by Anril on 08.05.2017.
 */

public class PersonDetailPresenter implements PersonDetailContract.Presenter {

    private PersonDetailContract.View view;

    public PersonDetailPresenter(PersonDetailContract.View view) {
        this.view = view;
    }

    public void onCreate() {
        Person person = view.getPersonFromIntent();
        if (person !=null) {
            view.showPerson(person);
        }
    }
}
