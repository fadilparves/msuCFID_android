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
 * Created by fadil on 20/12/2017.
 */

public class ChooseChapterAdapter extends RecyclerView.Adapter<ChooseChapterAdapter.ViewHolder> {

    private final Context context;
    private List<ChapterData> data;

    public ChooseChapterAdapter(Context context, List<ChapterData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.chapter_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChooseChapterAdapter.ViewHolder holder, int position) {
        final ChapterData chapter_data = data.get(position);

        holder.title.setText(chapter_data.getTitle());
        holder.sub_number.setText(chapter_data.getSub_num());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = chapter_data.getId();
                //Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show();

                final Intent intent;
                intent = new Intent(context, ContentDisplay.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID", id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, sub_number;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            sub_number = itemView.findViewById(R.id.sub_num);
        }
    }
}
