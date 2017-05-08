package com.anril.presentation.fragments.personslist;

import com.anril.presentation.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anril on 08.05.2017.
 */

public class PersonsListPresenter implements PersonsListContract.Presenter {

    private PersonsListContract.View view;

    public PersonsListPresenter(PersonsListContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.showRefreshIndicator();

        Person tmpPerson = new Person();
        tmpPerson.setFirstName("Alexander");
        List<Person> list = new ArrayList<>();
        list.add(tmpPerson);

        tmpPerson = new Person();
        tmpPerson.setFirstName("Konstantin");
        list.add(tmpPerson);

        view.showPersons(list);
        view.hideRefreshIndicator();
    }

    public void onRefresh() {
        view.showRefreshIndicator();

        Person tmpPerson = new Person();
        tmpPerson.setFirstName("Alexander");
        List<Person> list = new ArrayList<>();
        list.add(tmpPerson);

        tmpPerson = new Person();
        tmpPerson.setFirstName("Konstantin");
        list.add(tmpPerson);

        view.showPersons(list);
        view.hideRefreshIndicator();
    }

    @Override
    public void onPersonItemClick(Person person) {
        view.onPersonItemCick(person);
    }
}
