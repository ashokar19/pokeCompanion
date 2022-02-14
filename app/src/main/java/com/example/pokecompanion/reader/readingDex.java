package com.example.pokecompanion.reader;

import com.example.pokecompanion.R;
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
    private static pokemonObject pokemon;
    static List<String> pokemonList = new ArrayList<>();


    public static pokemonObject reader() throws IOException {
        fileName = "test_dex";

        FileInputStream fstream = new FileInputStream(String.valueOf(R.raw.test_dex));
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        StringBuilder all = new StringBuilder();
        String fileLine;

        //readline reads the individual lines of the file using the buffered reader

        while ((fileLine = br.readLine()) != null) {
            System.out.print(fileLine);
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
        String pokeName = pokeInfo[1];
        String pokeType = pokeInfo[2];
        if (pokeInfo.length > 3) {
            pokeType += " " + pokeInfo[3];
        }

        pokemon = new pokemonObject(pokeName, pokeType, pokeID);

        return pokemon;

    }

}
