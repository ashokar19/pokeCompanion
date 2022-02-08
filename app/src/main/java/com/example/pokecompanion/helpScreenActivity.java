package com.example.pokecompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class helpScreenActivity extends AppCompatActivity{

    public static Intent makeIntent(Context context) {
        return new Intent(context, helpScreenActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_screen);
    }

}
