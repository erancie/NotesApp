package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateNoteActivity extends AppCompatActivity {

    EditText noteItem;
    Button editNoteButton, deleteNoteButton;
    String noteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        noteText = getIntent().getStringExtra("noteItem");

        noteItem.setText(noteText);

    }
}