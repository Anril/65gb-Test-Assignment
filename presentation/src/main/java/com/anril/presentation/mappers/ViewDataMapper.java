package com.anril.presentation.mappers;

import com.anril.presentation.models.Person;
import com.anril.domain.models.Speciality;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anril on 10.05.2017.
 */

public class ViewDataMapper {

    private static final String[] dateFormats = {"yyyy-MM-dd", "dd-MM-yyyy"};

    public static com.anril.presentation.models.Speciality specialityMapper(com.anril.domain.models.Speciality model) {
        com.anril.presentation.models.Speciality viewModel = new com.anril.presentation.models.Speciality();
        viewModel.setId(model.getId());
        viewModel.setName(model.getName());
        return viewModel;
    }

    public static List<com.anril.presentation.models.Speciality> specialitiesMapper(List<com.anril.domain.models.Speciality> models) {
        List<com.anril.presentation.models.Speciality> viewModels = new ArrayList<>();
        for (int i = 0; i < models.size(); i++) {
            viewModels.add(specialityMapper(models.get(i)));
        }
        return viewModels;
    }

    public static Person personMapper(com.anril.domain.models.Person model) {
        Person viewModel = new Person();
        viewModel.setId(model.getId());
        viewModel.setFirstName(model.getFirstName());
        viewModel.setLastName(model.getLastName());

        if (model.getBirthday() != null && model.getBirthday().length()> 0) {
            viewModel.setBirthday(tryParse(model.getBirthday()).getTime());
        } else {
            viewModel.setBirthday(0);
        }


        viewModel.setAvatarUrl(model.getAvatarUrl());
        List<String> specialities = new ArrayList<>();
        for (Speciality spec : model.getSpecialties()) {
            specialities.add(spec.getName());
        }
        viewModel.setSpecialties(specialities.toArray(new String[specialities.size()]));
        return viewModel;
    }

    public static List<Person> personsMapper(List<com.anril.domain.models.Person> models) {
        List<Person> viewModels = new ArrayList<>();
        for (int i = 0; i < models.size(); i++) {
            viewModels.add(personMapper(models.get(i)));
        }
        return viewModels;
    }

    private static Date tryParse(String dateString) {
        for (String formatString : dateFormats) {
            try {
                SimpleDateFormat format = new SimpleDateFormat(formatString);
                format.setLenient(false);
                return format.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Date(0);
    }
}
