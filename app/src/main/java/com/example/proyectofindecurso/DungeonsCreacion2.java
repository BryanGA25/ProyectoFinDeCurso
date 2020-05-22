package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DungeonsCreacion2 extends AppCompatActivity {

    private TextView fuerza;
    private TextView destreza;
    private TextView carisma;
    private TextView inteligencia;
    private TextView constitucion;
    private TextView sabiduria;
    private Bundle extras;
    private BaseDeDatos db;
    private SQLiteDatabase database;
    private Boolean modificacion;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion2);
        fuerza = (TextView) findViewById(R.id.fue);
        destreza = (TextView) findViewById(R.id.des);
        carisma = (TextView) findViewById(R.id.caris);
        inteligencia = (TextView) findViewById(R.id.intelect);
        constitucion = (TextView) findViewById(R.id.cons);
        sabiduria = (TextView) findViewById(R.id.sab);
        extras = getIntent().getExtras();
        db = new BaseDeDatos(this);
        database=db.getReadableDatabase();
        modificacion = extras.getBoolean("modificacion");


        if (modificacion) {
            modificarPersonaje();
        }

    }

    private void modificarPersonaje() {
        id = extras.getInt("id");
        Cursor c = database.rawQuery("select * from DungeonsAndDragons where _id=" + id, null);
        c.moveToFirst();
        fuerza.setText(Integer.toString(c.getInt(c.getColumnIndex("fuerza"))));
        destreza.setText(Integer.toString(c.getInt(c.getColumnIndex("destreza"))));
        sabiduria.setText(Integer.toString(c.getInt(c.getColumnIndex("sabiduria"))));
        carisma.setText(Integer.toString(c.getInt(c.getColumnIndex("carisma"))));
        inteligencia.setText(Integer.toString(c.getInt(c.getColumnIndex("inteligencia"))));
        constitucion.setText(Integer.toString(c.getInt(c.getColumnIndex("constitucion"))));
    }


    public void guardar(View view) {



        db.insertarDAD(extras.getInt("nivel"), extras.getString("raza")
                , extras.getString("clase"), extras.getString("nombre"), extras.getString("alineamiento")
                , extras.getString("transfondo"), Integer.parseInt(fuerza.getText().toString())
                , Integer.parseInt(destreza.getText().toString()), Integer.parseInt(constitucion.getText().toString())
                , Integer.parseInt(inteligencia.getText().toString()), Integer.parseInt(sabiduria.getText().toString())
                , Integer.parseInt(carisma.getText().toString()));

        Intent menu = new Intent(this, Seleccion.class);
        startActivity(menu);
    }
}
