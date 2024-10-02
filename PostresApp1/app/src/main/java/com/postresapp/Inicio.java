package com.postresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {

    Button btnVolverHome;
    Button btnIniciarSesion;
    EditText inputCorreoInicio;
    EditText inputContrasenaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        inputCorreoInicio = findViewById(R.id.input_correo_inicio);
        inputContrasenaInicio = findViewById(R.id.input_password_inicio);
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        btnVolverHome = findViewById(R.id.btn_volver_home);


        // Acción para el botón de volver (Home.java)
        btnVolverHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, Home.class);
                startActivity(intent);
            }
        });

        // Acción para el botón de iniciar sesión (Dashboard.java)
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí se pueden validar los campos de usuario y contraseña si es necesario
                Intent intent = new Intent(Inicio.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}