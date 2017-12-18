package com.example.fadil.msucfid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by fadil on 17/12/2017.
 */

public class InterActivity extends AppCompatActivity {

    ImageButton btn_video, btn_pn, btn_notes;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        Intent intent = getIntent();

        id = intent.getStringExtra("ID");

        btn_notes = findViewById(R.id.notes_btn);
        btn_video = findViewById(R.id.vid_btn);
        btn_pn = findViewById(R.id.pn_btn);

        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(InterActivity.this, "Notes" + id, Toast.LENGTH_SHORT).show();
                Intent intNotes = new Intent(InterActivity.this, ContentDisplay.class);
                intNotes.putExtra("ID", id);
                startActivity(intNotes);
            }
        });

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(InterActivity.this, "Video", Toast.LENGTH_SHORT).show();
                Intent intNotes = new Intent(InterActivity.this, VideoListActivity.class);
                intNotes.putExtra("ID", id);
                startActivity(intNotes);
            }
        });

        btn_pn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(InterActivity.this, "Personal Notes", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InterActivity.this, PersonalNotesListActivity.class);
                intent.putExtra("ContentID", id);
                startActivity(intent);
            }
        });
    }
}
