package com.anril.presentation.activities.specialties;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anril.domain.sources.PersonDataSource;
import com.anril.domain.sources.SpecialityDataSource;
import com.anril.persistance.repositories.PersonRepository;
import com.anril.persistance.repositories.SpecialityRepository;
import com.anril.persistance.services.App65Service;
import com.anril.presentation.App;
import com.anril.presentation.R;
import com.anril.presentation.models.Speciality;
import com.anril.presentation.activities.personslist.PersonsListActivity;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialtiesActivity extends MvpAppCompatActivity implements
        SpecialtiesContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    SpecialtiesPresenter presenter;

    @BindView(R.id.srl_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rv_specialties)
    RecyclerView specialtiesRecyclerView;

    private SpecialtyAdapter specialtyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_specialties);

        ButterKnife.bind(this);

        refreshLayout.setOnRefreshListener(this);

        List<Speciality> specialties = new ArrayList<>();
        specialtyAdapter = new SpecialtyAdapter(specialties, presenter);
        specialtiesRecyclerView.setAdapter(specialtyAdapter);
        specialtiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.onCreate();
    }

    @Override
    public void onRefresh() {
        presenter.onRefresh();
    }

    @Override
    public void showSpecialties(List<Speciality> specialties) {
        specialtyAdapter.replaceDataSet(specialties);
    }

    @Override
    public void showLoadingIndicator() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoadingIndicator() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void navigateToPersons(int specialtyId) {
        Intent intent = new Intent(this, PersonsListActivity.class);
        intent.putExtra("speciality id", specialtyId);
        startActivity(intent);
    }
}
