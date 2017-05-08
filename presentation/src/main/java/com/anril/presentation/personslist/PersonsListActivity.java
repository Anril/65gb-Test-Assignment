package com.anril.presentation.personslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.anril.presentation.R;
import com.anril.presentation.fragments.persondetail.PersonDetailFragment;
import com.anril.presentation.models.Person;
import com.anril.presentation.persondetail.PersonDetailActivity;

import java.util.List;

/**
 * Created by Anril on 07.05.2017.
 */
public class PersonsListActivity extends AppCompatActivity implements PersonsListContract.View {

    private PersonsListContract.Presenter presenter;

    private boolean twoPane;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_persons);

        presenter = new PersonsListPresenter(this);

        if (findViewById(R.id.extra_container) != null) {
            twoPane = true;
        }
    }

    public void onPersonItemClick(Person person) {
        presenter.onPersonItemClick(person);
    }


    @Override
    public void updatePersonDetailFragment(Person person) {
        PersonDetailFragment personDetailFragment = (PersonDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.extra_container);
        personDetailFragment.showPerson(person);
    }

    @Override
    public void navigateToPersonDetailActivity(Person person) {
        Intent intent = new Intent(this, PersonDetailActivity.class);
        intent.putExtra("person", person);
        startActivity(intent);
    }

    @Override
    public boolean isTwoPane() {
        return twoPane;
    }
}
