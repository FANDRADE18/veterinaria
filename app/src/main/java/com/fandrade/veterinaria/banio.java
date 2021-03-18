package com.fandrade.veterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class banio extends AppCompatActivity {
    TextView usuario;
    Button enviarsolicitud,regresar,cerrarsesion;

    EditText nombremascota,edadmascota,razamascota;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banio);
        usuario = (TextView) findViewById(R.id.textusuariobanio);
        enviarsolicitud = (Button) findViewById(R.id.btnenviarsolicitudbanio);
        regresar = (Button) findViewById(R.id.btnregresar);
        cerrarsesion = (Button) findViewById(R.id.btncerarsesion);
        nombremascota = (EditText) findViewById(R.id.editnommascotabanio);
        edadmascota = (EditText) findViewById(R.id.editedadmascotabanio);
        razamascota = (EditText) findViewById(R.id.editrazamascotabanio);


        leercredenciales();

        enviarsolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),solicitudbanio.class);
                GuardarCredenciales(razamascota.getText().toString(), nombremascota.getText().toString(), edadmascota.getText().toString());
                startActivity(i);
            }

        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),inicio.class);
                startActivity(i);
            }

        });
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

        });

    }

    private void GuardarCredenciales(String raza,String nombre, String edad) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("razamascota",raza);
        editor.putString("nombremascota",nombre);
        editor.putString("edadmascota",edad);
        editor.commit();
    }

    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("user",""));
    }
}