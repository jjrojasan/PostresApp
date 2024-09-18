package com.postresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro extends AppCompatActivity {


    Button btnVolver;

    Button btnregistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnVolver = findViewById(R.id.volver_home);

        btnVolver.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });

        btnregistrar = findViewById(R.id.btn_registrar);

        btnregistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ irHome(); }
        });


    }
    public void irHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

}