package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mynotes.data.DatabaseHelper;
import com.example.mynotes.model.Note;

import java.util.ArrayList;
import java.util.List;

public class AllNotesActivity extends AppCompatActivity {

    ListView allNotesListView;
    ArrayList<String> noteArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);

        allNotesListView = findViewById(R.id.allNotesListView);
        noteArrayList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(AllNotesActivity.this);

        List<Note> userList = db.fetchAllNotes();
        for (Note note :userList)
        {
            noteArrayList.add(note.getNote());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteArrayList);

        allNotesListView.setAdapter(adapter);

        //TODO: USE CURSOR POS TO SET ONCLICK TO EACH NOTE (edit/del) ACTIVITY?

        allNotesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //create a new intent from activity and to activity
                Intent intent = new Intent(AllNotesActivity.this, UpdateNoteActivity.class);
                //Add a name for the intent and pass in the position  ///***position for intent to note item?
                intent.putExtra("noteItem", allNotesListView.getItemAtPosition(position).toString());
                //START NEW ACTIVITY use for result to maintain activity lifecycle
                startActivity(intent);
//                startActivityForResult(intent, RESULT_FIRST_USER);
            }
        });

    }
}