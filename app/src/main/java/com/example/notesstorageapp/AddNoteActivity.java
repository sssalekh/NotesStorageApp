package com.example.notesstorageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editNoteName;
    private EditText editNoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editNoteName = findViewById(R.id.edit_note_name);
        editNoteContent = findViewById(R.id.edit_note_content);
        Button btnSaveNote = findViewById(R.id.btn_save_note);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String noteName = editNoteName.getText().toString().trim();
        String noteContent = editNoteContent.getText().toString().trim();

        if (noteName.isEmpty() || noteContent.isEmpty()) {
            Toast.makeText(this, "Note name and content cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("NotesStorageApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Retrieve existing notes and add the new note
        Set<String> notes = sharedPreferences.getStringSet("notes", new HashSet<>());
        notes.add(noteName + ": " + noteContent);
        editor.putStringSet("notes", notes);
        editor.apply();

        Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show();
        finish();  // Close AddNoteActivity and go back to MainActivity
    }
}
