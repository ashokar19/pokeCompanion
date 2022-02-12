package com.example.pokecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startScreenActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        return new Intent(context, startScreenActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        MediaPlayer music = MediaPlayer.create(startScreenActivity.this, R.raw.pokemon_center_music);
        music.start();
        setupAllButtons();
    }

    public void setupAllButtons(){
        Button addPokemonButton = findViewById(R.id.addPoke);
        addPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = addPokemonActivity.makeIntent(startScreenActivity.this);
                startActivity(intent);
            }
        });

        Button editPokemonButton = findViewById(R.id.editPokes);
        editPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = editPokemonActivity.makeIntent(startScreenActivity.this);
                startActivity(intent);
            }
        });

        Button activitiesButton = findViewById(R.id.activitiesPoke);
        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = pokemonActivitiesActivity.makeIntent(startScreenActivity.this);
                startActivity(intent);
            }
        });

        Button helpButton = findViewById(R.id.help);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = helpScreenActivity.makeIntent(startScreenActivity.this);
                startActivity(intent);
            }
        });

    }

}