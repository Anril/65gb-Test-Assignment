package com.anril.presentation.activities.specialties;

import com.anril.presentation.models.Speciality;

import java.util.List;

/**
 * Created by Anril on 07.05.2017.
 */

interface SpecialtiesContract {

    interface View {
        void showSpecialties(List<Speciality> specialties);

        void showLoadingIndicator();
        void hideLoadingIndicator();

        void navigateToPersons(int specialtyId);
    }

    interface Presenter{
        void onCreate();
        void onRefresh();
        void onSpecialtyItemClick(int specialtyId);
    }

}
