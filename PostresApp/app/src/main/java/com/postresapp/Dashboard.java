package com.postresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button btnSalir;  // Definir el botón de salir
    Button btnIrUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inicializar el botón de salir
        btnSalir = findViewById(R.id.btn_salir);
        btnIrUserData = findViewById(R.id.btn_actualizar_informacion);

        // Acción para el botón de salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método que regresa a la página principal (MainActivity)
                irMainActivity();
            }
        });

        btnIrUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUserData();
            }
        });

    }

    public void irUserData() {
        Intent intent = new Intent(this, UseData.class);
        startActivity(intent);
    }

    // Método para navegar a la pantalla de MainActivity
    public void irMainActivity() {
        Intent intent = new Intent(Dashboard.this, MainActivity.class);
        startActivity(intent);
        finish();  // Cierra el Dashboard para que no se pueda regresar con el botón atrás
    }
}