package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void toTheMagicians(View view) {
        Intent intent = new Intent(this, TheMagicians.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent1 = new Intent(this, Profile.class);
        startActivity(intent1);
    }
}