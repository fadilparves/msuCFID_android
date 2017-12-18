package com.example.fadil.msucfid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fadil
 */

public class ShowPersonalNote extends AppCompatActivity{

    TextView title, body;
    DatabaseHandler db;
    Integer ids;
    String titled, bodyd;
    FloatingActionButton edit, delete;
    PersonalNote pn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_personal_note_activity);

        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        ids = Integer.parseInt(id);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        edit = findViewById(R.id.editbtn);
        delete = findViewById(R.id.deletebtn);

        pn = db.getPersonalNote(ids);

        titled = pn.getTitle();
        bodyd = pn.getBody();

        title.setText(titled);
        body.setText(bodyd);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ShowPersonalNote.this, "Delete", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ShowPersonalNote.this);
                alertDialogBuilder.setTitle("Are You Sure?");
                alertDialogBuilder
                        .setMessage("Click yes to delete")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                db.deletePersonalNote(pn);
                                Intent intent = new Intent(ShowPersonalNote.this, InterActivity.class);
                                intent.putExtra("ID", pn.getContent_id());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog ad = alertDialogBuilder.create();

                ad.show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ShowPersonalNote.this, "Edit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowPersonalNote.this, UpdatePersonalNotes.class);
                intent.putExtra("ID", ids.toString());
                intent.putExtra("Title", pn.getTitle());
                intent.putExtra("Body", pn.getBody());
                intent.putExtra("ContentID", pn.getContent_id());
                startActivity(intent);
            }
        });
    }
}
