package com.example.mynotes.model;

public class Note {
    private int note_id;
    private String note;

    public Note (String note){
        this.note = note;
    }

    public Note(){}

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
