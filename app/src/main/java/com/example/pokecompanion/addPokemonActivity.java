package com.example.pokecompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class addPokemonActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        return new Intent(context, addPokemonActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pokemon_screen);
    }

}

