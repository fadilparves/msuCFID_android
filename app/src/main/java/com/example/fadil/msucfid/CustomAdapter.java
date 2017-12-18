package com.example.fadil.msucfid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by fadil on 10/12/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private final Context context;
    private List<ContentList> data;

    public CustomAdapter(Context context, List<ContentList> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ContentList content_list = data.get(position);

        holder.title.setText(content_list.getTitle());
        holder.chapter_number.setText("Chapter Number :" + String.valueOf(content_list.getChapterNumber()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer id = content_list.getId();
                Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show();

                final Intent intent;
                intent = new Intent(context, InterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID", id.toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
            return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, chapter_number;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            chapter_number = itemView.findViewById(R.id.chapter_number);
        }

    }

}
