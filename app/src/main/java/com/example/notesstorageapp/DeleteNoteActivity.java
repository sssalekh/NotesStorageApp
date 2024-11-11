package com.example.notesstorageapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        ListView listView = findViewById(R.id.list_view_delete_notes);

        // Example list of notes. Replace with actual stored notes.
        ArrayList<String> notes = new ArrayList<>();
        notes.add("Note 1");
        notes.add("Note 2");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);

        // Add click listener for deletion
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedNote = notes.get(position);
            notes.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(DeleteNoteActivity.this, selectedNote + " deleted", Toast.LENGTH_SHORT).show();
        });
    }
}
