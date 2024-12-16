package com.example.myapplicationnewtaskmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myapplicationnewtaskmanagement.databinding.ActivityMainBinding;

public final class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NoteDataBaseHelper db;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new NoteDataBaseHelper(this);
        notesAdapter = new NotesAdapter(db.getAllNotes(), this);

        binding.noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.noteRecyclerView.setAdapter(notesAdapter);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        notesAdapter.refreshData(db.getAllNotes());
    }
}
