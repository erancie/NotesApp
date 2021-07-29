package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateNoteActivity extends AppCompatActivity {

    EditText noteItem;
    Button editNoteButton, deleteNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        //bind vars to layout id's
        noteItem = findViewById(R.id.noteItem);

        //get note selected from listview intent
        String noteText = getIntent().getStringExtra("noteItem");

        //set EditText field with Note item String
        noteItem.setText(noteText);



    }
}