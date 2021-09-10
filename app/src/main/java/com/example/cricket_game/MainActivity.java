package com.example.cricket_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    public Button start;
    RadioGroup radioGroup;
    EditText name1,name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Cricket");

        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        start = (Button) findViewById(R.id.started);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
    }
    public void play() {
        String nam1 = name1.getText().toString();
        String nam2 = name2.getText().toString();
        Intent intent = new Intent(this, play.class);
        intent.putExtra("keyname1",nam1);
        intent.putExtra("keyname2",nam2);
        if(nam1.length()==0 || nam2.length()==0){
            Toast.makeText(this,"Enter Team Name",Toast.LENGTH_LONG).show();
        }
        else {
            startActivity(intent);
        }
    }


}