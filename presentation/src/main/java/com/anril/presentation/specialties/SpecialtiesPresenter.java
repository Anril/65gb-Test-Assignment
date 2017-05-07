package com.anril.presentation.specialties;

import com.anril.presentation.models.Specialty;

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
        List<Specialty> specialties = new ArrayList<>();

        Specialty tmpSpecialty = new Specialty();
        tmpSpecialty.setName("Экономист");
        specialties.add(tmpSpecialty);
        tmpSpecialty = new Specialty();
        tmpSpecialty.setName("Accountant");
        specialties.add(tmpSpecialty);

        view.showSpecialties(specialties);
        view.hideLoadingIndicator();
    }

    @Override
    public void onSpecialtyItemClick(int specialtyId) {
        view.navigateToPersons(specialtyId);
    }

}
