package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotes.data.DatabaseHelper;
import com.example.mynotes.model.Note;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        DatabaseHelper db = new DatabaseHelper(this);

        //grab note text field & button
        EditText newNoteText = findViewById(R.id.newNoteText);
        Button saveNewNoteButton = findViewById(R.id.saveNewNoteButton);

        //add onclick listener from add button
        saveNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get editText and make string
                String newNote = newNoteText.getText().toString();

                //insertNote into db
                long result = db.insertNote(new Note(newNote));

                if (result > 0)
                {
                    Toast.makeText(NewNoteActivity.this, "Note created.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(NewNoteActivity.this, "Error creating Note.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}