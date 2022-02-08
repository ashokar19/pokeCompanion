package com.example.pokecompanion.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pokeManager {
    public List<pokemonObject> pokemon = new ArrayList<>();

    public void addPokemon(pokemonObject newPokemon) {
        pokemon.add(newPokemon);
    }

    public void removePokemon(int i) {
        pokemon.remove(i);
    }

    public List<pokemonObject> returnPokemonList() {
        return pokemon;
    }

    private static pokeManager managerInstance = null;

    private pokeManager() {}

    public static pokeManager getInstance(){
        if(managerInstance == null) {
            managerInstance = new pokeManager();
        }
        return managerInstance;
    }

    public Iterator<pokemonObject> iterator() {
        return pokemon.iterator();
    }

}
