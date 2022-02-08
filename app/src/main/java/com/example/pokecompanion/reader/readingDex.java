package com.example.pokecompanion.reader;

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
    static List<String> pokemonList = new ArrayList<>();

    public static void reader() throws IOException {
        fileName = "kantoDex";

        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        StringBuilder all = new StringBuilder();
        String fileLine;

        //readline reads the individual lines of the file using the buffered reader

        while ((fileLine = br.readLine()) != null) {
            pokemonList.add(fileLine);
            br.close();
        }

        fileLine = all.toString();
        Random rand = new Random();
        int randomPick = rand.nextInt(pokemonList.size());
        String selectedPick = pokemonList.get(randomPick);
        pokemonPick = selectedPick;
        //make random pick here

    }

}
