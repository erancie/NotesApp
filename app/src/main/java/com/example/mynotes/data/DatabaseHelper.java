package com.example.mynotes.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mynotes.model.Note;
import com.example.mynotes.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_NOTE_TABLE = "CREATE TABLE " + Util.TABLE_NAME
                + "(" + Util.NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Util.NOTE + " TEXT)";

        sqLiteDatabase.execSQL(CREATE_NOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String DROP_NOTE_TABLE = "DROP TABLE IF EXISTS";

        sqLiteDatabase.execSQL(DROP_NOTE_TABLE, new String[]{Util.TABLE_NAME} );

        onCreate(sqLiteDatabase);
    }

    public long insertNote (Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.NOTE, note.getNote());
        //insert values and save callback as rowID
        long newRowId = db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public boolean fetchNote (Note note){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.NOTE_ID},
                Util.NOTE + "=?", new String[] {String.valueOf(note)}, null, null, null);
        int numberOfRows = cursor.getCount();
        db.close();

        if (numberOfRows >0){
            return true;
        }else{
            return false;
        }
    }

    public List<Note> fetchAllNotes (){
        List<Note> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = " SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNote_id(cursor.getInt(0));
                note.setNote(cursor.getString(1));

                userList.add(note);

            } while (cursor.moveToNext());

        }

        return userList;
    }

    public int updateNote(Integer noteId, String noteText)
    {
        Log.i("NOTE", "updateNote: " + noteId);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.NOTE, noteText);

        return db.update(Util.TABLE_NAME, contentValues,
                Util.NOTE_ID + "=?",
                new String[]{String.valueOf(noteId)});
    }

    public boolean deleteNote(Integer noteId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Util.TABLE_NAME, Util.NOTE_ID + "=?",
                new String[]{String.valueOf(noteId)}) > 0;
    }
}
