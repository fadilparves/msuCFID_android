package com.example.fadil.msucfid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by fadil
 */

public class NewPersonalNote extends AppCompatActivity {
    Button btn_save;
    EditText title, body;
    public String content_id;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_personal_note);

        Intent intent = getIntent();
        content_id = intent.getStringExtra("ContentID");

        db = new DatabaseHandler(this);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        btn_save = findViewById(R.id.save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NewPersonalNote.this, content_id, Toast.LENGTH_SHORT).show();
                db.addPersonalNote(new PersonalNote(title.getText().toString(), body.getText().toString(),
                        content_id ));
                Toast.makeText(NewPersonalNote.this, "Note saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewPersonalNote.this, PersonalNotesListActivity.class);
                intent.putExtra("ContentID", content_id);
                startActivity(intent);
            }
        });
    }
}
