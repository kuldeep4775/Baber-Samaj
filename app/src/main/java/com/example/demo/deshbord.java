package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class deshbord extends AppCompatActivity {


    CardView c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshbord);
        //hide ActionBar
        getSupportActionBar().hide();

        c1 = findViewById(R.id.search);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click and second page jump
                Intent intent  = new Intent(deshbord.this,searchpage.class);
                startActivity(intent);
            }
        });
    }
}