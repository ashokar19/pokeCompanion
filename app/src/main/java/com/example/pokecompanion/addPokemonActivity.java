package com.example.pokecompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pokecompanion.models.pokemonObject;
import com.example.pokecompanion.reader.readingDex;

import java.io.IOException;

public class addPokemonActivity extends AppCompatActivity {

    readingDex randomReader;
    pokemonObject pokemonToAdd;


    public static Intent makeIntent(Context context) {
        return new Intent(context, addPokemonActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pokemon_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button randomize = (Button) findViewById(R.id.randomizerBtn);
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   pokemonToAdd = readingDex.reader();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                TextView view = (TextView) findViewById(R.id.addedPokeNameLine);
                try {
                    view.setText(readingDex.reader().getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();

                Log.i("MyApp", "Task has been completed");
            }
        });


//        Button checkTaskComplete = (Button) findViewById(R.id.taskCompleteCheck);
//        checkTaskComplete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                editedTask.nextAssignee();
//                Log.i("MyApp", "Task has been completed");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_pokemon_tool,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_save_poke:

                finish();
                return true;

            case android.R.id.home:
                Toast.makeText(this, "Make sure you saved your pokemon choice!", Toast.LENGTH_SHORT).show();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

