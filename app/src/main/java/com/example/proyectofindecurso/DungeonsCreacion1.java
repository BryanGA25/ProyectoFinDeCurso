package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class DungeonsCreacion1 extends AppCompatActivity {

    Spinner raza;
    Spinner transfondo;
    Spinner alineamiento;
    TextView nombre;
    TextView nivel;
    TextView clase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion1);
        raza=(Spinner)findViewById(R.id.raza);
        transfondo=(Spinner)findViewById(R.id.transfondo);
        alineamiento=(Spinner)findViewById(R.id.aliniamiento);
        nivel=(TextView) findViewById(R.id.nivel);
        nombre=(TextView) findViewById(R.id.nombre);
        clase=(TextView)findViewById(R.id.clase);

        ArrayAdapter<CharSequence> razas=ArrayAdapter.createFromResource(this,R.array.raza,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> transfondos=ArrayAdapter.createFromResource(this,R.array.transfondo,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> alineamientos=ArrayAdapter.createFromResource(this,R.array.alineamiento,android.R.layout.simple_spinner_item);

        raza.setAdapter(razas);
        transfondo.setAdapter(alineamientos);
        alineamiento.setAdapter(transfondos);

    }

    public void siguiente(View view){

        Intent actividad = new Intent(this,DungeonsCreacion2.class);
        actividad.putExtra("nombre",nombre.getText().toString());
        actividad.putExtra("raza",raza.getSelectedItem().toString());
        actividad.putExtra("transfondo",transfondo.getSelectedItem().toString());
        actividad.putExtra("alineamiento",alineamiento.getSelectedItem().toString());
        actividad.putExtra("nivel",Integer.parseInt(nivel.getText().toString()));
        actividad.putExtra("clase",clase.getText().toString());
        startActivity(actividad);
    }

}
