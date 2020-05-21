package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DungeonsCreacion1 extends AppCompatActivity {

    Spinner raza;
    Spinner transfondo;
    Spinner alineamiento;
    TextView nombre;
    TextView nivel;
    TextView clase;
    Boolean modificacion;
    int id;
    BaseDeDatos db;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion1);
        raza=(Spinner)findViewById(R.id.raza);
        transfondo=(Spinner)findViewById(R.id.transfondo);
        alineamiento=(Spinner)findViewById(R.id.aliniamiento);
        nivel=(TextView) findViewById(R.id.niv);
        nombre=(TextView) findViewById(R.id.nombre);
        clase=(TextView)findViewById(R.id.clase);
        db=new BaseDeDatos(this);
        database=db.getReadableDatabase();


        ArrayAdapter<CharSequence> razas=ArrayAdapter.createFromResource(this,R.array.raza,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> transfondos=ArrayAdapter.createFromResource(this,R.array.transfondo,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> alineamientos=ArrayAdapter.createFromResource(this,R.array.alineamiento,android.R.layout.simple_spinner_item);

        raza.setAdapter(razas);
        transfondo.setAdapter(alineamientos);
        alineamiento.setAdapter(transfondos);
        Bundle extras=getIntent().getExtras();
        modificacion=extras.getBoolean("modificacion");


        if(modificacion){
            id=extras.getInt("id");
            Cursor c=database.rawQuery("select * from DungeonsAndDragons where _id="+id , null);
            c.moveToFirst();
            nombre.setText(c.getString(c.getColumnIndex("nombre")));
            clase.setText(c.getString(c.getColumnIndex("clase")));
            nivel.setText(Integer.toString(c.getInt(c.getColumnIndex("nivel"))));

        }
    }

    public void siguiente(View view){

        Intent actividad = new Intent(this,DungeonsCreacion2.class);
        actividad.putExtra("nombre",nombre.getText().toString());
        actividad.putExtra("raza",raza.getSelectedItem().toString());
        actividad.putExtra("transfondo",transfondo.getSelectedItem().toString());
        actividad.putExtra("alineamiento",alineamiento.getSelectedItem().toString());
        actividad.putExtra("nivel",Integer.parseInt(nivel.getText().toString()));
        actividad.putExtra("clase",clase.getText().toString());
        if(modificacion){
            actividad.putExtra("id",id);
        }
        startActivity(actividad);
    }

}
