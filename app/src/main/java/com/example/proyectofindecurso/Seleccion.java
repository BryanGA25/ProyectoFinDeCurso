package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Seleccion extends AppCompatActivity {

    Spinner fichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        fichas=(Spinner) findViewById(R.id.fichas);

        ArrayAdapter<CharSequence> fichasArray=ArrayAdapter.createFromResource(this,R.array.fichas,R.layout.spinner_item);
        fichasArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        fichas.setAdapter(fichasArray);

    }

    public void continuar(View view){

        System.out.println(fichas.getSelectedItem().toString());
        Intent actividad2 = new Intent(this,Hub.class);
        actividad2.putExtra("seleccion",fichas.getSelectedItem().toString());
        startActivity(actividad2);

    }
}
