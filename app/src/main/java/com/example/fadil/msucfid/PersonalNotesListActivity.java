package com.example.fadil.msucfid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by fadil on 17/12/2017.
 */

public class PersonalNotesListActivity extends AppCompatActivity {

    public String content_id;
    DatabaseHandler db;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_notes_list);

        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        content_id = intent.getStringExtra("ContentID");

        List<PersonalNote> personalNoteList = db.getAllPersonalNotes(content_id);

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new PersonalNotesAdapter(getApplicationContext(), personalNoteList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }
}
