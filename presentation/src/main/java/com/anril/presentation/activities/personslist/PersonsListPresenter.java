package com.anril.presentation.activities.personslist;

import com.anril.presentation.models.Person;

/**
 * Created by Anril on 07.05.2017.
 */

public class PersonsListPresenter implements PersonsListContract.Presenter {

    private PersonsListContract.View view;

    public PersonsListPresenter(PersonsListContract.View view) {
        this.view = view;
    }

    @Override
    public void onPersonItemClick(Person person) {
        if (view.isTwoPane()) {
            view.updatePersonDetailFragment(person);
        } else {
            view.navigateToPersonDetailActivity(person);
        }

    }
}
