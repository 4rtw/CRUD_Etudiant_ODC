package com.artware.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nom, classe;
    Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.editTextNom);
        classe = findViewById(R.id.editTextClasse);
        ajouter = findViewById(R.id.buttonAjouter);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                i.putExtra("nom", nom.getText().toString());
                i.putExtra("classe", classe.getText().toString());
                startActivity(i);
                nom.setText("");
                classe.setText("");
            }
        });
    }
}