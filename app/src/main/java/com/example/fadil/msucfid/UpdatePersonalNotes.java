package com.example.fadil.msucfid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by fadil on 18/12/2017.
 */

public class UpdatePersonalNotes extends AppCompatActivity {

    Button updatebtn;
    EditText title, body;
    String t, b, i, id, tit, bod;
    Integer ids;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_personal_notes_activity);

        db = new DatabaseHandler(this);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        updatebtn = findViewById(R.id.update);

        Intent intent = getIntent();
        t = intent.getStringExtra("Title");
        b = intent.getStringExtra("Body");
        i = intent.getStringExtra("ContentID");
        id = intent.getStringExtra("ID");

        ids = Integer.parseInt(id);

        title.setText(t);
        body.setText(b);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tit = title.getText().toString();
                bod = body.getText().toString();
                PersonalNote pn = new PersonalNote();
                pn.setId(ids);
                pn.setTitle(tit);
                pn.setBody(bod);
                pn.setContent_id(i);
                db.updatePersonalNote(pn);
                Toast.makeText(UpdatePersonalNotes.this, ids.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdatePersonalNotes.this, ShowPersonalNote.class);
                intent.putExtra("ID", ids.toString());
                startActivity(intent);
            }
        });


    }
}
