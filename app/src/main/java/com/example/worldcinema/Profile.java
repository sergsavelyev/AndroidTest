package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void toMenu(View view) {

            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);

    }

    public void exit(View view) {
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);

    }
}