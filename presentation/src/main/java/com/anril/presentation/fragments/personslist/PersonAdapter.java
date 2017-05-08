package com.anril.presentation.fragments.personslist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anril.presentation.R;
import com.anril.presentation.models.Person;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anril on 07.05.2017.
 */

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<Person> persons;
    private PersonsListContract.Presenter presenter;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_firstname)
        TextView nameTextView;
        @BindView(R.id.tv_age)
        TextView ageTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    PersonAdapter(List<Person> persons, PersonsListContract.Presenter presenter) {
        this.persons = persons;
        this.presenter = presenter;
    }

    public void ReplaceDataSet(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tmpView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);
        return new ViewHolder(tmpView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String fullName = persons.get(position).getFirstName() + " "
                + persons.get(position).getFirstName();
        holder.nameTextView.setText(fullName);
        holder.ageTextView.setText(String.valueOf(persons.get(position).getAge()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPersonItemClick(persons.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
