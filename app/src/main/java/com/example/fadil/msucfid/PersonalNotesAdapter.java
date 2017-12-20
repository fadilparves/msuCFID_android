package com.example.fadil.msucfid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fadil
 */

public class PersonalNotesAdapter extends RecyclerView.Adapter<PersonalNotesAdapter.ViewHolder> {
    private final Context context;
    private List<PersonalNote> data;

    public PersonalNotesAdapter(Context context, List<PersonalNote> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public PersonalNotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.personal_notes_list_inside, parent, false);

        return new PersonalNotesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonalNotesAdapter.ViewHolder holder, int position) {
        final PersonalNote personal_note = data.get(position);

        holder.title.setText(personal_note.getTitle());
        holder.body.setText("Personal Note : " + personal_note.getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show();
                Integer id = personal_note.getId();
                String ided = id.toString();
                //Toast.makeText(context, ided, Toast.LENGTH_SHORT).show();
                final Intent intent;
                intent = new Intent(context, ShowPersonalNote.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID", ided);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, body;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
