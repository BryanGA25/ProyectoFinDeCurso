package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DungeonsCreacion1 extends AppCompatActivity {

    Spinner raza;
    Spinner transfondo;
    Spinner alineamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion1);
        raza=(Spinner)findViewById(R.id.raza);
        transfondo=(Spinner)findViewById(R.id.transfondo);
        alineamiento=(Spinner)findViewById(R.id.aliniamiento);

        ArrayAdapter<CharSequence> razas=ArrayAdapter.createFromResource(this,R.array.raza,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> transfondos=ArrayAdapter.createFromResource(this,R.array.transfondo,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> alineamientos=ArrayAdapter.createFromResource(this,R.array.alineamiento,android.R.layout.simple_spinner_item);

        raza.setAdapter(razas);
        transfondo.setAdapter(alineamientos);
        alineamiento.setAdapter(transfondos);

    }

    public void siguiente(View view){

        Intent actividad = new Intent(this,DungeonsCreacion2.class);
        startActivity(actividad);
    }

}
