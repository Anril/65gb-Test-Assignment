package com.anril.presentation.fragments.personslist;

import com.anril.domain.usecases.GetPersonsBySpecialityId;
import com.anril.persistance.repositories.PersonRepository;
import com.anril.presentation.App;
import com.anril.presentation.mappers.ViewDataMapper;
import com.anril.presentation.models.Person;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        GetPersonsBySpecialityId getPersonsBySpecialityIdUseCase = new GetPersonsBySpecialityId(
                new PersonRepository(App.getDbOpenHelper()));
        int id = view.getSpecialityId();

        getPersonsBySpecialityIdUseCase
                .execute(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ViewDataMapper::personsMapper)
                .subscribe(view::showPersons);

        view.hideRefreshIndicator();
    }

    public void onRefresh() {
        view.showRefreshIndicator();



        //view.showPersons(list);
        view.hideRefreshIndicator();
    }

    @Override
    public void onPersonItemClick(Person person) {
        view.onPersonItemCick(person);
    }
}
