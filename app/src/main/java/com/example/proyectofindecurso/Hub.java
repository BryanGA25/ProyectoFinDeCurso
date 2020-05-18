package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hub extends AppCompatActivity {

    String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        Bundle extras=getIntent().getExtras();
        seleccion=extras.getString("seleccion");
    }

    public void creacion(View view){
        Intent creacion= new Intent(this, DungeonsCreacion1.class);
        startActivity(creacion);
    }

    public void informacion(View view){
                Intent informacion= new Intent(this, Informacion.class);
                informacion.putExtra("seleccion",seleccion);
                startActivity(informacion);
    }

    public void lanzar(View view){
        Intent lanzar=new Intent(this,LanzadorDados.class);
        startActivity(lanzar);
    }
}
