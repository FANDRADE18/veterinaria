package com.fandrade.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class inicio extends AppCompatActivity {
    Button banio,corte;
    TextView usuario;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        banio = (Button)findViewById(R.id.btnbanio);
        corte = (Button)findViewById(R.id.btncorte);
        usuario=(TextView)findViewById(R.id.textusuariobanio);
        leercredenciales();

        banio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),banio.class);
               // GuardarCredenciales(user.getText().toString());
                startActivity(i);
            }
        });
        corte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),corte.class);
                // GuardarCredenciales(user.getText().toString());
                startActivity(i);
            }
        });

    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("user",""));
    }

}