package com.artware.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    ListView list;
    String nom, classe;
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = findViewById(R.id.list);

        Bundle extras = getIntent().getExtras();

        if (extras!=null){
            nom = extras.getString("nom");
            classe = extras.getString("classe");
            map = new HashMap<String, String>();

            map.put("nom", nom);
            map.put("classe", classe);

            Params.etudiants.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(ListActivity.this, Params.etudiants, R.layout.item, new String[]{"nom", "classe"}, new int[]{R.id.textViewNom, R.id.textViewClasse});

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
                finish();
            }
        });
    }
}