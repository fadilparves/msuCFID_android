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
 * Created by fadil on 17/12/2017.
 */

public class CustomVideoAdapter extends RecyclerView.Adapter<CustomVideoAdapter.ViewHolder> {
    private final Context context;
    private List<VideoData> data;

    public CustomVideoAdapter(Context context, List<VideoData> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public CustomVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.video_list_inside, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VideoData video_data = data.get(position);

        holder.file_path.setText(video_data.getFile_path());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String file = video_data.getFile_path();
                //Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show();

                final Intent intent;
                intent = new Intent(context, VideoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("File", file);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView file_path;

        public ViewHolder(View itemView) {
            super(itemView);
            file_path = itemView.findViewById(R.id.file_path);
        }
    }
}
