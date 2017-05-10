package com.anril.presentation.activities.specialties;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anril.presentation.R;
import com.anril.presentation.models.Speciality;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anril on 07.05.2017.
 */

class SpecialtyAdapter extends RecyclerView.Adapter<SpecialtyAdapter.ViewHolder> {

    private List<Speciality> specialties;
    private SpecialtiesContract.Presenter presenter;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_specialty)
        TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    SpecialtyAdapter(List<Speciality> specialties, SpecialtiesContract.Presenter presenter) {
        this.specialties = specialties;
        this.presenter = presenter;
    }

    public void replaceDataSet(List<Speciality> specialties) {
        this.specialties = specialties;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View currentView = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_specialty, parent, false);

        return new ViewHolder(currentView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.nameTextView.setText(specialties.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSpecialtyItemClick(specialties.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return specialties.size();
    }
}
