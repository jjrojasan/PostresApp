package com.postresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    // Inicializar la instancia de la base de datos Firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Usuario");

    // Inicializar la instancia de autenticación Firebase
    FirebaseAuth auth = FirebaseAuth.getInstance();

    // Declarar las variables de los elementos de la interfaz
    Button btnVolver;
    Button btnRegistrar;
    EditText inputId, inputUserName, inputLastName, inputPhone, inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Vincular los elementos de la interfaz con el código
        btnVolver = findViewById(R.id.volver_home);
        btnRegistrar = findViewById(R.id.btn_registrar);
        inputId = findViewById(R.id.input_user_id);
        inputUserName = findViewById(R.id.input_user_name);
        inputLastName = findViewById(R.id.input_user_lastname);
        inputPhone = findViewById(R.id.input_user_phone);
        inputEmail = findViewById(R.id.input_user_email);
        inputPassword = findViewById(R.id.input_contrasena);

        // Configurar los listeners para los botones
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    // Método para volver a la pantalla de inicio
    public void irHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    // Método para crear el usuario en la base de datos y registrar en Firebase Auth
    public void createUser() {
        String userId = inputId.getText().toString();

        // Crear la referencia para el nuevo usuario
        DatabaseReference newUserRef = reference.child(userId);

        // Obtener y almacenar los datos del usuario
        String name = inputUserName.getText().toString();
        newUserRef.child("Nombre").setValue(name);

        String lastName = inputLastName.getText().toString();
        newUserRef.child("Apellido").setValue(lastName);

        String phone = inputPhone.getText().toString();
        newUserRef.child("Teléfono").setValue(phone);

        String email = inputEmail.getText().toString();
        newUserRef.child("Correo").setValue(email);

        String password = inputPassword.getText().toString();
        newUserRef.child("Contraseña").setValue(password);

        // Registrar el usuario en Firebase Authentication
        registrarUsuario(email, password);

        // Mostrar mensaje de éxito
        Toast.makeText(getApplicationContext(), "Usuario registrado exitosamente", Toast.LENGTH_LONG).show();
    }

    // Método para registrar el usuario en Firebase Auth
    public void registrarUsuario(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registro en Auth exitoso
                            Toast.makeText(Registro.this, "Registro en Auth, correcto", Toast.LENGTH_SHORT).show();
                        } else {
                            // Mostrar mensaje en caso de fallo
                            Toast.makeText(Registro.this, "Intente otra vez", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

