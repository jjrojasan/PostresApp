package com.postresapp.personal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Inicio = findViewById(R.id.btn_Inicio);

        // Corregir el método de click del botón
        btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });
    }

    public void irHome() {
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }
}
