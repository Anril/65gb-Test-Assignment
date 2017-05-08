package com.anril.presentation.fragments.persondetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anril.presentation.R;
import com.anril.presentation.models.Person;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anril on 08.05.2017.
 */

public class PersonDetailFragment extends Fragment implements PersonDetailContract.View{

    @BindView(R.id.tv_firstname)
    TextView firstNameTextView;
    @BindView(R.id.tv_lastname)
    TextView lastNameTextView;
    @BindView(R.id.tv_birthday)
    TextView birthdayTextView;
    @BindView(R.id.tv_specialties)
    TextView specialitiesTextView;

    private PersonDetailContract.Presenter presenter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_person_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new PersonDetailPresenter(this);
        presenter.onCreate();
    }

    @Override
    public void showPerson(Person person) {

        firstNameTextView.setText(person.getFirstName());
        lastNameTextView.setText(person.getLastName());

        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = new Date(person.getBirthday());
        birthdayTextView.setText(dateFormat.format(date));


//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
//        Date date = new Date(image.getDate());
//        imageDateTextView.setText(dateFormat.format(date));
    }

    @Override
    public Person getPersonFromIntent() {
        Intent intent = getActivity().getIntent();
        Person tmpPerson = (Person) intent.getParcelableExtra("person");
        return tmpPerson;
    }
}
