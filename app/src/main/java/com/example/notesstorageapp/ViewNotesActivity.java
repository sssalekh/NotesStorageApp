package com.example.notesstorageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Set;

public class ViewNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        ListView listView = findViewById(R.id.list_view_notes);

        // Load notes from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("NotesStorageApp", Context.MODE_PRIVATE);
        Set<String> notesSet = sharedPreferences.getStringSet("notes", null);

        ArrayList<String> notes = new ArrayList<>();
        if (notesSet != null) {
            notes.addAll(notesSet);
        }

        // Display notes in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);
    }
}
