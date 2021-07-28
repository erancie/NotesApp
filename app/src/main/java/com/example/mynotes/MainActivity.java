package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mynotes.data.DatabaseHelper;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newNoteButton = findViewById(R.id.newNoteButton);
        Button allNotesButton = findViewById(R.id.allNotesButton);

        db = new DatabaseHelper(this);

        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newNoteIntent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(newNoteIntent);
            }
        });
        allNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allNotesIntent = new Intent(MainActivity.this, AllNotesActivity.class);
                startActivity(allNotesIntent);
            }
        });
    }
}