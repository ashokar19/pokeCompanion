package com.example.pokecompanion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokecompanion.models.pokeManager;
import com.example.pokecompanion.models.pokemonObject;

public class pokemonMenuActivity extends AppCompatActivity {

    private static final String POKEMON_INDEX_KEY = "pokemonIndexKey";
    pokeManager manager;

    public static Intent makeIntent(Context context) {
        return new Intent(context, pokemonMenuActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_menu_screen);

//        ActionBar ab = getSupportActionBar();
//        getSupportActionBar().setTitle("Pick a Pokemon!");

        manager = pokeManager.getInstance();

        registerClickOnList();
        populateListView();
        System.out.println(manager.returnPokemonList().size());
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
        checkEmpty();
    }

    public void checkEmpty(){
        if(manager.returnPokemonList() == null) {
            Toast.makeText(this, "NO POKEMON HERE BRUH!", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateUI() {
        populateListView();
    }

    private void populateListView() {
        ArrayAdapter<pokemonObject> adapter = new MyListAdapter();
        ListView pokeList = (ListView) findViewById(R.id.listViewPokemonMenu);
        pokeList.deferNotifyDataSetChanged();
        pokeList.setAdapter(adapter);
    }

    private void registerClickOnList() {
        ListView pokeList = (ListView) findViewById(R.id.listViewPokemonMenu);
        pokeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent editIntent = new Intent(pokemonMenuActivity.this, editPokemonActivity.class);
                Bundle editBundle = new Bundle();
                editBundle.putInt(POKEMON_INDEX_KEY, position);
                editIntent.putExtras(editBundle);
                startActivity(editIntent);
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<pokemonObject> {
        public MyListAdapter() {
            super(pokemonMenuActivity.this, R.layout.pokemon_list_item, manager.returnPokemonList());
        }
        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.pokemon_list_item, parent, false);

            }
            pokemonObject pokemonIndex = manager.returnPokemonList().get(position);

//            @SuppressLint("ResourceType")ImageView kidMiniImage = (ImageView) itemView.findViewById(R.id.pokeMiniImage);
//            kidMiniImage.setImageBitmap(currentKid.getImage());
            @SuppressLint("ResourceType") TextView pokemonNameDisplay = (TextView) itemView.findViewById(R.id.pokeNameGoes);
            pokemonNameDisplay.setText(pokemonIndex.getName());
            @SuppressLint("ResourceType") TextView pokemonDateDisplay = (TextView) itemView.findViewById(R.id.pokeDateMet);
            pokemonDateDisplay.setText("Met on " + pokemonIndex.getDate());
            @SuppressLint("ResourceType") TextView pokemonTypeDisplay = (TextView) itemView.findViewById(R.id.pokeType);
            pokemonTypeDisplay.setText(pokemonIndex.getType());
            @SuppressLint("ResourceType") TextView pokemonHappinessDisplay = (TextView) itemView.findViewById(R.id.pokeHappiness);
            pokemonHappinessDisplay.setText(pokemonIndex.getHappiness());
            return itemView;
        }

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Thanks, bye bye now!", Toast.LENGTH_SHORT).show();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
