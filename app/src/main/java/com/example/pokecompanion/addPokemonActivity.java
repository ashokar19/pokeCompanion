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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pokecompanion.models.pokeManager;
import com.example.pokecompanion.models.pokemonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class addPokemonActivity extends AppCompatActivity {
//used in the reader functions
    private static String pokemonPick;
    private static String fileName;
    private static String[] pokeInfo;
    private static pokemonObject pokemon;
    static List<String> pokemonList = new ArrayList<>();
//when adding a pokemon
    pokemonObject pokemonToAdd;
    int count = 3;
//manager to add pokemon to your list
    pokeManager manager;

    public static Intent makeIntent(Context context) {
        return new Intent(context, addPokemonActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pokemon_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setTitle("Add a Pokemon!");


        manager = pokeManager.getInstance();

        Button randomize = (Button) findViewById(R.id.randomizerBtn);
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 0) {
                    pokemonToAdd = readData();
                    TextView view = (TextView) findViewById(R.id.addedPokeNameLine);
                    view.setText(pokemonToAdd.getName());
                    String s = "You have " + count + " tries rolls remaining";
                    Toast.makeText(addPokemonActivity.this, s, Toast.LENGTH_SHORT).show();
                    count--;
                } else {
                    Toast.makeText(addPokemonActivity.this, "You have 0 rolls, this pokemon has been added to your partners!", Toast.LENGTH_SHORT).show();
                    manager.addPokemon(pokemonToAdd);
                    finish();

                }
            }
        });

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
                manager.addPokemon(pokemonToAdd);
                String name = pokemonToAdd.getName();
                Toast.makeText(addPokemonActivity.this, "You've chosen to add is " + name + "!!!", Toast.LENGTH_SHORT).show();
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

    public pokemonObject readData(){

        InputStream stream = getResources().openRawResource(R.raw.test_dex);
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
        StringBuilder all = new StringBuilder();
        String fileLine;

        //readline reads the individual lines of the file using the buffered reader
        try {
            while ((fileLine = br.readLine()) != null) {
                pokemonList.add(fileLine);
            }
        } catch(IOException e) {
            Toast.makeText(addPokemonActivity.this, "Error reading data", Toast.LENGTH_SHORT).show();
        }
        all.toString();
        Random rand = new Random();
        int randomPick = rand.nextInt(pokemonList.size());
        String selectedPick = pokemonList.get(randomPick);

        pokemonPick = selectedPick;

        pokeInfo = pokemonPick.split(" ");
        int pokeID = Integer.parseInt(pokeInfo[0]);
        String pokeName = pokeInfo[1];
        String pokeType = pokeInfo[2];
        if (pokeInfo.length > 3) {
            pokeType += " " + pokeInfo[3];
        }

        pokemon = new pokemonObject(pokeName, pokeType, pokeID);
        System.out.print(pokemon.getName() + pokemon.getType());
        return pokemon;
    }

}

