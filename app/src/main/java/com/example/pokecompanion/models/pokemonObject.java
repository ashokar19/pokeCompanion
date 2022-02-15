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
    LocalDateTime date;

    //for type, check the size of the array of the string split of the type and if <2, access type.split() array at [0] and [1]
//    public pokemonObject(String setName, String setType, int setID) {
//        name = setName;
////        type = setType;
//        id = setID;
//        date = LocalDateTime.now();
//    }

    public pokemonObject(String setName, String setType, int setID) {
        name = setName;
        type = setType;
        id = setID;
        date = LocalDateTime.now();
    }

    public String getName() {
        return name;

    }

    public String getType() {
        return type;
    }

    public int getID() {
        return id;
    }

    public String getDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(format);
        return formattedDate;
    }

}