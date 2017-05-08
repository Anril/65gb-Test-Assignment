package com.anril.presentation.fragments.personslist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anril.presentation.R;
import com.anril.presentation.models.Person;
import com.anril.presentation.personslist.PersonsListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anril on 08.05.2017.
 */

public class PersonsListFragment extends Fragment implements PersonsListContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_persons)
    RecyclerView personsRecyclerView;
    @BindView(R.id.srl_refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private PersonsListContract.Presenter presenter;

    private PersonAdapter personAdapter;
    private PersonsListActivity parentView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PersonsListActivity) {
            parentView = (PersonsListActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_persons_list, container, false);
        if (view!= null) {
            ButterKnife.bind(this, view);
        }

        refreshLayout.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new PersonsListPresenter(this);

        personAdapter = new PersonAdapter(new ArrayList<Person>(), presenter);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        personsRecyclerView.setAdapter(personAdapter);

        presenter.onCreate();
    }

    @Override
    public void showPersons(List<Person> persons) {
        personAdapter.ReplaceDataSet(persons);
    }

    @Override
    public void showRefreshIndicator() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshIndicator() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onPersonItemCick(Person person) {
        parentView.onPersonItemClick(person);
    }

    @Override
    public void onRefresh() {
        presenter.onRefresh();
    }
}
