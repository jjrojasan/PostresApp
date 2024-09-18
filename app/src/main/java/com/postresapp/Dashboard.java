package com.postresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button btnSalir;  // Definir el botón de salir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inicializar el botón de salir
        btnSalir = findViewById(R.id.btn_salir);

        // Acción para el botón de salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método que regresa a la página principal (MainActivity)
                irMainActivity();
            }
        });
    }

    // Método para navegar a la pantalla de MainActivity
    public void irMainActivity() {
        Intent intent = new Intent(Dashboard.this, MainActivity.class);
        startActivity(intent);
        finish();  // Cierra el Dashboard para que no se pueda regresar con el botón atrás
    }
}