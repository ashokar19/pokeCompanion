package com.example.pokecompanion.reader;

import com.example.pokecompanion.models.pokemonObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class readingDex {
    private static String pokemonPick;
    private static String fileName;
    private static String[] pokeInfo;
    private pokemonObject pokemon;
    static List<String> pokemonList = new ArrayList<>();




    public static void reader() throws IOException {
        fileName = "testDex";

        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        StringBuilder all = new StringBuilder();
        String fileLine;

        //readline reads the individual lines of the file using the buffered reader

        while ((fileLine = br.readLine()) != null) {
            pokemonList.add(fileLine);
            br.close();
        }

        all.toString();
        Random rand = new Random();
        int randomPick = rand.nextInt(pokemonList.size());
        String selectedPick = pokemonList.get(randomPick);
        pokemonPick = selectedPick;
        System.out.println(pokemonPick);
        pokeInfo = pokemonPick.split(" ");
        int pokeID = Integer.parseInt(pokeInfo[0]);
        String pokemonName = pokeInfo[1];

        //make random pick here

    }

}
