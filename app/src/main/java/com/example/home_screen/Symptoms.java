package com.example.home_screen;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class Symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        NavUtils.navigateUpFromSameTask(this);
        return super.onOptionsItemSelected(item);

    }

}
