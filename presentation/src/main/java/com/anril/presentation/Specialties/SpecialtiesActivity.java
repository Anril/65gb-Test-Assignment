package com.anril.presentation.specialties;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anril.presentation.R;
import com.anril.presentation.models.Specialty;
import com.anril.presentation.persons.PersonsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialtiesActivity extends AppCompatActivity implements
        SpecialtiesContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    private SpecialtiesContract.Presenter presenter;

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
        presenter = new SpecialtiesPresenter(this);

        refreshLayout.setOnRefreshListener(this);

        List<Specialty> specialties = new ArrayList<>();
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
    public void showSpecialties(List<Specialty> specialties) {
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
        Intent intent = new Intent(this, PersonsActivity.class);
        startActivity(intent);
    }
}
