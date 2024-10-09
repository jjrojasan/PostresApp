package com.postresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inicio extends AppCompatActivity {

    // Declarar las variables de Firebase y de la interfaz
    FirebaseAuth auth;
    Button btnVolverHome;
    Button btnIniciarSesion;
    EditText inputCorreoInicio;
    EditText inputContrasenaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Vincular los elementos de la interfaz con el código
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
                String email = inputCorreoInicio.getText().toString().trim();
                String password = inputContrasenaInicio.getText().toString().trim();

                if (email.isEmpty()) {
                    inputCorreoInicio.setError("El correo es obligatorio");
                    return;
                }
                if (password.isEmpty()) {
                    inputContrasenaInicio.setError("La contraseña es obligatoria");
                    return;
                }

                iniciarSesionConEmail(email, password);
            }
        });
    }

    // Método para iniciar sesión con correo y contraseña
    public void iniciarSesionConEmail(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Inicio.this, "Inicio Exitoso", Toast.LENGTH_SHORT).show();
                            Log.d("InicioSesion", "Inicio de sesión exitoso con: " + email);
                            irDashboard();
                        } else {
                            Log.w("InicioSesion", "Error de inicio de sesión", task.getException());
                            Toast.makeText(Inicio.this, "Valide sus credenciales", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Método para redirigir al usuario al Dashboard después de un inicio exitoso
    public void irDashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
