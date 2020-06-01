package com.example.proyectofindecurso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PathfinderCreacion1 extends AppCompatActivity {


    private Spinner raza;
    private Spinner transfondo;
    private Spinner alineamiento;
    private TextView nombre;
    private TextView nivel;
    private TextView clase;
    private Boolean modificacion;
    private int id;
    private BaseDeDatos db;
    private SQLiteDatabase database;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathfinder_creacion1);
        raza = (Spinner) findViewById(R.id.raza);
        transfondo = (Spinner) findViewById(R.id.transfondo);
        alineamiento = (Spinner) findViewById(R.id.aliniamiento);
        nivel = (TextView) findViewById(R.id.niv);
        nombre = (TextView) findViewById(R.id.nombre);
        clase = (TextView) findViewById(R.id.clase);
        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();


        ArrayAdapter<CharSequence> razas = ArrayAdapter.createFromResource(this, R.array.razaPathfinder, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> transfondos = ArrayAdapter.createFromResource(this, R.array.transfondo, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> alineamientos = ArrayAdapter.createFromResource(this, R.array.alineamiento, android.R.layout.simple_spinner_item);

        raza.setAdapter(razas);
        transfondo.setAdapter(alineamientos);
        alineamiento.setAdapter(transfondos);
        extras = getIntent().getExtras();
        modificacion = extras.getBoolean("modificacion");


        if (modificacion) {
            cargarPersonaje();
        }
    }

    public void siguiente(View view) {
        if (nombre.getText().toString().equalsIgnoreCase("")
                || clase.getText().toString().equalsIgnoreCase("")
                || nivel.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();
        } else {
            Intent actividad = new Intent(this, PathfinderCreacion2.class);
            actividad.putExtra("nombre", nombre.getText().toString());
            actividad.putExtra("raza", raza.getSelectedItem().toString());
            actividad.putExtra("transfondo", transfondo.getSelectedItem().toString());
            actividad.putExtra("alineamiento", alineamiento.getSelectedItem().toString());
            actividad.putExtra("nivel", Integer.parseInt(nivel.getText().toString()));
            actividad.putExtra("clase", clase.getText().toString());
            if (modificacion) {
                actividad.putExtra("id", id);
                actividad.putExtra("modificacion", true);
            }
            startActivity(actividad);
        }

    }

    private void cargarPersonaje() {
        id = extras.getInt("id");
        Cursor c = database.rawQuery("select * from Pathfinder where _id=" + id, null);
        c.moveToFirst();
        nombre.setText(c.getString(c.getColumnIndex("nombre")));
        clase.setText(c.getString(c.getColumnIndex("clase")));
        nivel.setText(Integer.toString(c.getInt(c.getColumnIndex("nivel"))));
        for (int i = 0; i < raza.getBaseline(); i++) {
            String razaC = raza.getItemAtPosition(i).toString();
            if (razaC.equalsIgnoreCase(c.getString(c.getColumnIndex("raza")))) {
                raza.setSelection(i);
                break;
            }
        }
        for (int i = 0; i < alineamiento.getBaseline(); i++) {
            String alineamientoC = alineamiento.getItemAtPosition(i).toString();
            if (alineamientoC.equalsIgnoreCase(c.getString(c.getColumnIndex("alineamiento")))) {
                alineamiento.setSelection(i);
                break;
            }
        }
        for (int i = 0; i < transfondo.getBaseline(); i++) {
            String transfondoC = transfondo.getItemAtPosition(i).toString();
            if (transfondoC.equalsIgnoreCase(c.getString(c.getColumnIndex("transfondo")))) {
                transfondo.setSelection(i);
                break;
            }
        }
    }
}
