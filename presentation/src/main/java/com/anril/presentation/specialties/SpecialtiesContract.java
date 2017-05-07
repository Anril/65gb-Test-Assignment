package com.anril.presentation.specialties;

import com.anril.presentation.models.Specialty;

import java.util.List;

/**
 * Created by Anril on 07.05.2017.
 */

interface SpecialtiesContract {

    interface View {
        void showSpecialties(List<Specialty> specialties);

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
