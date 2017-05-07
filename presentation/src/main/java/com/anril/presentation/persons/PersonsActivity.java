package com.anril.presentation.persons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.anril.presentation.R;

/**
 * Created by Anril on 07.05.2017.
 */
public class PersonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_persons);
    }
}
