package com.example.pokecompanion.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class activityManager {
    public List<pokemonActivity> activities = new ArrayList<>();

    private static activityManager managerInstance = null;

    private activityManager() {}

    public static activityManager getInstance(){
        if(managerInstance == null) {
            managerInstance = new activityManager();
        }
        return managerInstance;
    }

    public Iterator<pokemonActivity> iterator() {
        return activities.iterator();
    }

}
