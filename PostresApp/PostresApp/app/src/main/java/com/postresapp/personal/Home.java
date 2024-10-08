package com.postresapp.personal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnRegistro;
    Button btnInicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicializar los botones
        btnRegistro = findViewById(R.id.btn_ir_registro);
        btnInicioSesion = findViewById(R.id.btn_ir_inicio_sesion);

        // Acción del botón para ir al registro
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
            }
        });

        // Acción del botón para ir al inicio de sesión
        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInicioSesion();
            }
        });
    }

    // Método para navegar a la pantalla de registro
    public void irRegistro() {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    // Método para navegar a la pantalla de inicio de sesión
    public void irInicioSesion() {
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }
}
