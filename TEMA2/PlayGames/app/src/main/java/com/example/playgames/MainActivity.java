package com.example.playgames;

import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newPlayerButton = findViewById(R.id.newPlayerButton);
        Button preferencesButton = findViewById(R.id.PreferecesButton);
        Button playButton = findViewById(R.id.PlayButton);

        newPlayerButton.setOnClickListener(v -> {
            Intent i = new Intent(this, NewPlayer.class);
            startActivity(i);
        });

        preferencesButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Preferences.class);
            startActivity(i);
        });

        playButton.setOnClickListener(v -> {
            Intent i = new Intent(this, games.class);
            startActivity(i);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}