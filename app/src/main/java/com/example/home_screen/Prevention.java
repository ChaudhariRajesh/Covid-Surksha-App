package com.example.home_screen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class Prevention extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        NavUtils.navigateUpFromSameTask(this);
        return super.onOptionsItemSelected(item);

    }

}
