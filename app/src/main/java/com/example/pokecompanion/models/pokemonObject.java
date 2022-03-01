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
    String nickName;
    int happyFactor;
    String emotionDisplay;

    public pokemonObject(String setName, String setType, int setID) {
        name = setName;
        type = setType;
        id = setID;
        date = LocalDateTime.now();
    }

    public void setHappyFactor() {
        Random rand = new Random();
        int randomHappiness = rand.nextInt(101);
        happyFactor = randomHappiness;
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
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(format);
        return formattedDate;
    }

    public String getHappiness() {
        emotionDisplay = setEmotionDisplay(happyFactor);
        return emotionDisplay + " " + happyFactor;
    }

    public void setNickName(String newNickName) {
        nickName = newNickName;
    }


    public String setEmotionDisplay(int determineHappy) {
        if(determineHappy < 25) {
            return ">:(";
        }
        else if(determineHappy > 25 && determineHappy < 50) {
            return ":(";
        }
        else if(determineHappy >= 50 && determineHappy <= 75) {
            return ":)";
        }
        else if(determineHappy > 75 && determineHappy <= 100) {
            return ":D";
        }

        return ":l";
    }

}