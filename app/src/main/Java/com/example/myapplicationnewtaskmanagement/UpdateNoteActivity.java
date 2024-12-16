package com.example.myapplicationnewtaskmanagement;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationnewtaskmanagement.databinding.ActivityUpdateNoteBinding;

public final class UpdateNoteActivity extends AppCompatActivity {
    private ActivityUpdateNoteBinding binding;
    private NoteDataBaseHelper db;
    private int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new NoteDataBaseHelper(this);
        noteId = getIntent().getIntExtra("note_id", -1);

        if (noteId == -1) {
            finish();
        } else {
            Note note = db.getNoteByID(noteId);
            if (note != null) {
                binding.updateTitleEditText.setText(note.getTitle());
                binding.updateContentEditText.setText(note.getContent());
            }

            binding.updatesaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newTitle = binding.updateTitleEditText.getText().toString();
                    String newContent = binding.updateContentEditText.getText().toString();
                    Note updateNote = new Note(noteId, newTitle, newContent);
                    db.updateNote(updateNote);
                    finish();
                    Toast.makeText(UpdateNoteActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // Synthetic methods for Kotlin compatibility
    public static final ActivityUpdateNoteBinding access$getBinding$p(UpdateNoteActivity instance) {
        return instance.binding;
    }

    public static final void access$setBinding$p(UpdateNoteActivity instance, ActivityUpdateNoteBinding binding) {
        instance.binding = binding;
    }

    public static final void access$setNoteId$p(UpdateNoteActivity instance, int noteId) {
        instance.noteId = noteId;
    }

    public static final NoteDataBaseHelper access$getDb$p(UpdateNoteActivity instance) {
        return instance.db;
    }

    public static final void access$setDb$p(UpdateNoteActivity instance, NoteDataBaseHelper db) {
        instance.db = db;
    }
}
