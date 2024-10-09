package com.postresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UseData extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Usuario");

    Button btnVolverDashBoard1;
    Button btnBuscarUsuario;

    EditText inputIdUsuario;

    TextView mostrarIdUsuario;

    TextView mostrarNombreUsuario;

    TextView mostrarApellidoUsuario;

    TextView mostrarTelefonoUsuario;
    TextView mostrarCorreoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_data);

        btnVolverDashBoard1 = findViewById(R.id.btn_volver_dashboard1);
        btnBuscarUsuario = findViewById(R.id.btnBuscarUsuario);
        inputIdUsuario = findViewById(R.id.input_buscar_id);
        mostrarIdUsuario = findViewById(R.id.txt_data_id);
        mostrarNombreUsuario = findViewById(R.id.txt_data_nombre);
        mostrarApellidoUsuario = findViewById(R.id.txt_data_apellido);
        mostrarCorreoUsuario = findViewById(R.id.txt_data_correo);
        mostrarTelefonoUsuario = findViewById(R.id.txt_data_telefono);

        btnBuscarUsuario.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarDatosUsuario();
            }
        }));

        btnVolverDashBoard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });

    }

    public void recuperarDatosUsuario() {
        String identificacion = inputIdUsuario.getText().toString();

        DatabaseReference usuarioReferencia = reference.child(identificacion);

        usuarioReferencia.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {



                    String nombre = snapshot.child("Nombre").getValue(String.class);
                    mostrarNombreUsuario.setText("Nombre: " + nombre);

                    String apellido = snapshot.child("Apellido").getValue(String.class);
                    mostrarApellidoUsuario.setText("Apellido: " + apellido);

                    String correo = snapshot.child("Correo").getValue(String.class);
                    mostrarCorreoUsuario.setText("Correo: " + correo);

                    String telefono = snapshot.child("Teléfono").getValue(String.class);
                    mostrarTelefonoUsuario.setText("Teléfono: " + telefono);

                } else {
                    Toast.makeText(UseData.this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
    public void irHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


};