package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

                //Cast position to Note object
                Note selectedNote = (Note) userList.get(position);

                //create a new intent from activity and to activity
                Intent intent = new Intent(AllNotesActivity.this, UpdateNoteActivity.class);

                //Pass in note obj id and text to intent
                intent.putExtra("noteItemID", selectedNote.getNote_id());
                intent.putExtra("noteItemText", selectedNote.getNote());
                //Start note item activity
                startActivity(intent);

            }
        });

    }
}