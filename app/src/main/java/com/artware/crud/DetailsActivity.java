package com.artware.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    EditText nom, classe;
    Button edit, delete;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nom = findViewById(R.id.editTextNomDetail);
        classe = findViewById(R.id.editTextClasseDetail);

        edit = findViewById(R.id.buttonEdit);
        delete = findViewById(R.id.buttonDelete);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            position = extras.getInt("position");
        }

        HashMap<String, String> m = Params.etudiants.get(position);
        nom.setText(m.get("nom"));
        classe.setText(m.get("classe"));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.put("nom", nom.getText().toString());
                m.put("classe", classe.getText().toString());

                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(i);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Params.etudiants.remove(position);
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}