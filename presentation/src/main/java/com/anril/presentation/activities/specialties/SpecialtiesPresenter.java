package com.anril.presentation.activities.specialties;

import com.anril.presentation.models.Speciality;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anril on 07.05.2017.
 */

public class SpecialtiesPresenter implements SpecialtiesContract.Presenter {

    private SpecialtiesContract.View view;

    public SpecialtiesPresenter(SpecialtiesContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        onRefresh();
    }

    @Override
    public void onRefresh() {
        view.showLoadingIndicator();
        List<Speciality> specialties = new ArrayList<>();

        Speciality tmpSpeciality = new Speciality();
        tmpSpeciality.setName("Экономист");
        specialties.add(tmpSpeciality);
        tmpSpeciality = new Speciality();
        tmpSpeciality.setName("Accountant");
        specialties.add(tmpSpeciality);

        view.showSpecialties(specialties);
        view.hideLoadingIndicator();
    }

    @Override
    public void onSpecialtyItemClick(int specialtyId) {
        view.navigateToPersons(specialtyId);
    }

}
