package com.anril.presentation.activities.specialties;

import com.anril.domain.usecases.GetSpecialities;
import com.anril.persistance.repositories.SpecialityRepository;
import com.anril.presentation.App;
import com.anril.presentation.mappers.ViewDataMapper;
import com.anril.presentation.models.Speciality;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        GetSpecialities getSpecialitiesUseCase = new GetSpecialities(new SpecialityRepository
                (App.getDbOpenHelper()));

        getSpecialitiesUseCase.execute()
                .map(ViewDataMapper::specialitiesMapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showSpecialties);

        view.hideLoadingIndicator();
    }

    @Override
    public void onSpecialtyItemClick(int specialtyId) {
        view.navigateToPersons(specialtyId);
    }


}
