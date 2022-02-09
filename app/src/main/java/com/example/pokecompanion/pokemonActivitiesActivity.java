package com.example.pokecompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class pokemonActivitiesActivity extends AppCompatActivity {
    public static Intent makeIntent(Context context) {
        return new Intent(context, pokemonActivitiesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_screen);
    }
}
