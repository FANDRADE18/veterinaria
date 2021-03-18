package com.fandrade.veterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class solicitudbanio extends AppCompatActivity {
    TextView usuario,solicitud;
    SharedPreferences preferences;
    Button regresar,cerrarsesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudbanio);
        usuario = (TextView) findViewById(R.id.textusuariobanio);
        solicitud=(TextView)findViewById(R.id.textversolicitud);
        regresar = (Button) findViewById(R.id.btnregresar);
        cerrarsesion = (Button) findViewById(R.id.btncerarsesion);

        leercredenciales();

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),banio.class);
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

    private void leercredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("user", ""));
        solicitud.setText("Estimado "+preferences.getString("user","")
                +" se ha confirmado la solicitud para tu mascota "+preferences.getString("nombremascota","")
                +" de la raza "+preferences.getString("razamascota","")
                +" y de edad "+preferences.getString("edadmascota","")+" años a la cual le realizaremos un baño ");
    }
}