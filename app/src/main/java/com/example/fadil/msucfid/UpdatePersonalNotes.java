package com.example.fadil.msucfid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by fadil on 18/12/2017.
 */

public class UpdatePersonalNotes extends AppCompatActivity {

    Button updatebtn;
    EditText title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_personal_notes_activity);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);

        


    }
}
