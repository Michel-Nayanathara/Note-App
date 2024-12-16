package com.example.myapplicationnewtaskmanagement;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplicationnewtaskmanagement.databinding.ActivityAddNoteBinding;
import org.jetbrains.annotations.Nullable;


public final class AddNoteActivity extends AppCompatActivity {
    private ActivityAddNoteBinding binding;
    private NoteDataBaseHelper db;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNoteBinding var10001 = ActivityAddNoteBinding.inflate(this.getLayoutInflater());

        this.binding = var10001;
        var10001 = this.binding;
        if (var10001 == null) {

        }

        this.setContentView((View)var10001.getRoot());
        this.db = new NoteDataBaseHelper((Context)this);
        ActivityAddNoteBinding var10000 = this.binding;
        if (var10000 == null) {

        }

        var10000.saveButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                EditText var10000 = AddNoteActivity.access$getBinding$p(AddNoteActivity.this).titleEditText;
                String title = var10000.getText().toString();
                var10000 = AddNoteActivity.access$getBinding$p(AddNoteActivity.this).contentEditText;
                String content = var10000.getText().toString();
                Note note = new Note(0, title, content);
                AddNoteActivity.access$getDb$p(AddNoteActivity.this).insertNote(note);
                AddNoteActivity.this.finish();
                Toast.makeText((Context)AddNoteActivity.this, (CharSequence)"Note saved", 0).show();
            }
        }));
    }

    // $FF: synthetic method
    public static final ActivityAddNoteBinding access$getBinding$p(AddNoteActivity $this) {
        ActivityAddNoteBinding var10000 = $this.binding;
        if (var10000 == null) {


        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setBinding$p(AddNoteActivity $this, ActivityAddNoteBinding var1) {
        $this.binding = var1;
    }

    // $FF: synthetic method
    public static final NoteDataBaseHelper access$getDb$p(AddNoteActivity $this) {
        NoteDataBaseHelper var10000 = $this.db;
        if (var10000 == null) {

        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setDb$p(AddNoteActivity $this, NoteDataBaseHelper var1) {
        $this.db = var1;
    }
}
