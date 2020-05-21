package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class Hub extends AppCompatActivity {

    String seleccion;
    BaseDeDatos db;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        db=new BaseDeDatos(this);

        Bundle extras=getIntent().getExtras();
        seleccion=extras.getString("seleccion");
    }

    public void creacion(View view){
        Intent creacion= new Intent(this, DungeonsCreacion1.class);
        creacion.putExtra("modificacion",false);
        startActivity(creacion);
    }

    public void verPersonajes(View view){

        Intent verPersonajes= new Intent(this, SeleccionadorFichaDAD.class);
        startActivity(verPersonajes);

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
