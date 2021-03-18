package com.fandrade.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
 EditText user;
 Button iniciarsesion;
 SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarsesion = (Button)findViewById(R.id.btniniciarsesion);
        user= (EditText)findViewById(R.id.edituser);

        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),inicio.class);
                GuardarCredenciales(user.getText().toString());
                startActivity(i);
            }
        });
    }

    private void GuardarCredenciales(String nombre) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nombre);
        editor.commit();


}
}