package com.example.proyectofindecurso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Hub extends AppCompatActivity {

    private String seleccion;
    private BaseDeDatos db;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();

        Bundle extras = getIntent().getExtras();
        seleccion = extras.getString("seleccion");
    }

    public void creacion(View view) {
        Intent creacion;
        switch (seleccion) {

            case "Dungeons And Dragons":
                creacion = new Intent(this, DungeonsCreacion1.class);
                creacion.putExtra("modificacion", false);
                startActivity(creacion);
                break;
            case "World of Warcraft":
                creacion = new Intent(this, WarcraftCreacion1.class);
                creacion.putExtra("modificacion", false);
                startActivity(creacion);
                break;
            case "Pathfinder":
                creacion = new Intent(this, PathfinderCreacion1.class);
                creacion.putExtra("modificacion", false);
                startActivity(creacion);
                break;
        }
    }


    public void verPersonajes(View view) {

        Intent verPersonajes = new Intent(this, SeleccionadorFichaDAD.class);
        verPersonajes.putExtra("seleccion", seleccion);


        Cursor c = null;
        switch (seleccion) {

            case "Dungeons And Dragons":
                c = database.rawQuery("select * from DungeonsAndDragons", null);
                break;
            case "World of Warcraft":
                c = database.rawQuery("select * from WorldOfWarcraft", null);
                break;
            case "Pathfinder":
                c = database.rawQuery("select * from Pathfinder", null);
                break;
        }
        if (c != null && c.getCount() > 0) {
            startActivity(verPersonajes);
        } else {
            Toast.makeText(this, "No hay personajes creados en " + seleccion, Toast.LENGTH_SHORT).show();
        }

    }

    public void informacion(View view) {
        Intent informacion = new Intent(this, Informacion.class);
        informacion.putExtra("seleccion", seleccion);
        startActivity(informacion);
    }

    public void lanzar(View view) {
        Intent lanzar = new Intent(this, LanzadorDados.class);
        startActivity(lanzar);
    }
}
