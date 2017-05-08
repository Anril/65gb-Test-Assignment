package com.anril.presentation.fragments.personslist;

import com.anril.presentation.models.Person;

import java.util.List;

/**
 * Created by Anril on 08.05.2017.
 */

public interface PersonsListContract {

    interface View {
        void showPersons(List<Person> persons);
        void showRefreshIndicator();
        void hideRefreshIndicator();
        void onPersonItemCick(Person person);
    }

    interface Presenter {
        void onCreate();
        void onRefresh();
        void onPersonItemClick(Person person);
    }
}
