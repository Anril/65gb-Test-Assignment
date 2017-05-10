package com.anril.presentation.activities.personslist;

import com.anril.presentation.models.Person;

/**
 * Created by Anril on 07.05.2017.
 */

public interface PersonsListContract {

    interface View {
        void updatePersonDetailFragment(Person person);
        void navigateToPersonDetailActivity(Person person);
        boolean isTwoPane();
    }

    interface Presenter {
        void onPersonItemClick(Person person);
    }

}
