package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//imports
import com.example.mynotes.data.DatabaseHelper;
import com.example.mynotes.model.Note;

public class UpdateNoteActivity extends AppCompatActivity {

    //declarations
    EditText noteItem;
    Button editNoteButton, deleteNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        //bind layout id's
        noteItem = findViewById(R.id.noteItem);
        editNoteButton = findViewById((R.id.editNoteButton));
        deleteNoteButton = findViewById((R.id.deleteNoteButton));
        //declare db
        DatabaseHelper db = new DatabaseHelper(this);
        //get note selected from listview intent
        String noteText = getIntent().getStringExtra("noteItem");
        //set EditText field with Note item String
        noteItem.setText(noteText);

        //create Note obj using fetchNote method???

        //TODO
        //click listener for edit button

            //get edited text

            //call db update method

        /////////////////////////////////////////TODO
        editNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String note = sUsernameEditText2.getText().toString();
//                String password = sPasswordEditText2.getText().toString();
//                String confirmPassword = confirmPasswordEditText2.getText().toString();

//                if (password.equals(confirmPassword))
//                {
                    int updateRow  = db.updateNote(new Note(noteItem.toString()));
                    if (updateRow > 0)
                    {
                        Toast.makeText(UpdateNoteActivity.this, "Note Updated.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(UpdateNoteActivity.this, "No row found!", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(UpdateNoteActivity.this, AllNotesActivity.class);
                    startActivity(intent);
//                }
//                else
//                {
//                    Toast.makeText(ChangePasswordActivity.this, "Two passwords do not match!", Toast.LENGTH_SHORT).show();
//                }
            }
        });

//        //click listener for delete button //TODO
//        deleteNoteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int deleteRow  = db.deleteNote(new Note(noteItem.toString()));
//                if (deleteRow > 0)
//                {
//                    Toast.makeText(UpdateNoteActivity.this, "Note Deleted.", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(UpdateNoteActivity.this, "No row found!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            //create a new intent from activity and to activity
//            Intent intent = new Intent(UpdateNoteActivity.this, AllNotesActivity.class);
//            //Add a name for the intent and pass in the position
////                intent.putExtra("noteItem", allNotesListView.getItemAtPosition(position).toString());
//            //Start note item activity
//            startActivity(intent);
//        });
            //get note for deletion** --> NOTE_ID?
            //call db delete method
    }
}