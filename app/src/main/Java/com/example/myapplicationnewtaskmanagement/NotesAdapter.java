package com.example.myapplicationnewtaskmanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public final class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private final NoteDataBaseHelper db;
    private List<Note> notes;

    public NotesAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.db = new NoteDataBaseHelper(context);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoteViewHolder holder, int position) {
        final Note note = notes.get(position);
        holder.titleTextView.setText(note.getTitle());
        holder.contentTextView.setText(note.getContent());

        holder.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), UpdateNoteActivity.class);
                intent.putExtra("note_id", note.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteNote(note.getId());
                refreshData(db.getAllNotes());
                Toast.makeText(holder.itemView.getContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void refreshData(List<Note> newNotes) {
        this.notes = newNotes;
        notifyDataSetChanged();
    }

    public static final class NoteViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView contentTextView;
        private final ImageView updateButton;
        private final ImageView deleteButton;

        public NoteViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            updateButton = itemView.findViewById(R.id.updateButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
