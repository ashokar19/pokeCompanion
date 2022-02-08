package com.example.pokecompanion.models;


import java.util.Random;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class pokemonObject {
    String name;
    String type;
    int id;
    String color;

    public pokemonObject(String setName, String setType, int setID, String setColor) {
        name = setName;
        type = setType;
        id = setID;
        color = setColor;
    }

    public String getName() {
        return name;

    }

    public String getType() {
        return type;

    }

    public String getColor() {
        return color;

    }

    public int getID() {
        return id;
    }

}