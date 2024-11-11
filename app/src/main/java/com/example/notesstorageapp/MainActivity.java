package com.example.notesstorageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button for Add Note
        Button btnAddNote = findViewById(R.id.btn_add_note);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNoteIntent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(addNoteIntent);
            }
        });

        // Button for View Notes
        Button btnViewNotes = findViewById(R.id.btn_view_notes);
        btnViewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewNotesIntent = new Intent(MainActivity.this, ViewNotesActivity.class);
                startActivity(viewNotesIntent);
            }
        });

        // Button for Delete Note
        Button btnDeleteNote = findViewById(R.id.btn_delete_note);
        btnDeleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteNoteIntent = new Intent(MainActivity.this, DeleteNoteActivity.class);
                startActivity(deleteNoteIntent);
            }
        });
    }
}
