package com.example.proyectofindecurso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofindecurso.tablas.WarcraftTabla;

import java.util.ArrayList;

public class WarcraftCreacion2 extends AppCompatActivity {

    private TextView fuerza;
    private TextView agilidad;
    private TextView carisma;
    private TextView inteligencia;
    private TextView energia;
    private TextView espiritu;
    private Bundle extras;
    private BaseDeDatos db;
    private SQLiteDatabase database;
    private Boolean modificacion;
    private Spinner tiradas;
    private int id;
    private ArrayList<String> resultados;
    private ArrayList<Integer> ids;
    private TextView info;

    public void onResume() {
        super.onResume();
        cargarTiradas();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warcraft_creacion2);
        fuerza = (TextView) findViewById(R.id.fue);
        agilidad = (TextView) findViewById(R.id.agi);
        carisma = (TextView) findViewById(R.id.caris);
        inteligencia = (TextView) findViewById(R.id.intelect);
        energia = (TextView) findViewById(R.id.ener);
        espiritu = (TextView) findViewById(R.id.esp);
        extras = getIntent().getExtras();
        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();
        modificacion = extras.getBoolean("modificacion");
        tiradas = findViewById(R.id.tiradas);
        resultados = new ArrayList<>();
        info = (TextView) findViewById(R.id.texto);
        ids = new ArrayList<>();

        if (modificacion) {
            modificarPersonaje();
            tiradas.setVisibility(View.GONE);
            info.setVisibility(View.GONE);
            findViewById(R.id.dados).setVisibility(View.GONE);
        } else {
            cargarTiradas();

        }

    }





    public void guardar(View view) {
        if (fuerza.getText().toString().equalsIgnoreCase("") || agilidad.getText().toString().equalsIgnoreCase("")
                || energia.getText().toString().equalsIgnoreCase("") || inteligencia.getText().toString().equalsIgnoreCase("")
                || espiritu.getText().toString().equalsIgnoreCase("") || carisma.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Faltan campos sin rellenar", Toast.LENGTH_SHORT).show();
        } else {
            WarcraftTabla wt = new WarcraftTabla(0, extras.getInt("nivel"), extras.getString("raza")
                    , extras.getString("clase"), extras.getString("nombre"), extras.getString("faccion")
                    , extras.getString("alineamiento")
                    , extras.getString("transfondo"), Integer.parseInt(fuerza.getText().toString())
                    , Integer.parseInt(energia.getText().toString()), Integer.parseInt(espiritu.getText().toString())
                    , Integer.parseInt(inteligencia.getText().toString()), Integer.parseInt(agilidad.getText().toString())
                    , Integer.parseInt(carisma.getText().toString()));
            if (modificacion) {
                wt.setId(id);
                db.actualizarWarcraft(wt);
            } else {
                db.insertarWarcraft(wt);
            }
            Intent menu = new Intent(this, Seleccion.class);
            startActivity(menu);
        }
    }

    public void dados(View view) {

        Intent dados = new Intent(this, LanzadorDados.class);
        startActivity(dados);
    }

    public void cargarTiradas() {
        Cursor c = database.rawQuery("select _id,resultado from Tiradas", null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                resultados.add(Integer.toString(c.getInt(c.getColumnIndex("resultado"))));
                ids.add(c.getInt(c.getColumnIndex("_id")));
            } while (c.moveToNext());
            ArrayAdapter<CharSequence> nombresAdpater =
                    new ArrayAdapter(this, android.R.layout.simple_spinner_item, resultados);
            tiradas.setAdapter(nombresAdpater);

        }
        tiradas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                db.borrarTirada(ids.get(tiradas.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }

    private void modificarPersonaje() {
        id = extras.getInt("id");
        Cursor c = database.rawQuery("select * from WorldOfWarcraft where _id=" + id, null);
        c.moveToFirst();
        fuerza.setText(Integer.toString(c.getInt(c.getColumnIndex("fuerza"))));
        agilidad.setText(Integer.toString(c.getInt(c.getColumnIndex("agilidad"))));
        espiritu.setText(Integer.toString(c.getInt(c.getColumnIndex("espiritu"))));
        carisma.setText(Integer.toString(c.getInt(c.getColumnIndex("carisma"))));
        inteligencia.setText(Integer.toString(c.getInt(c.getColumnIndex("inteligencia"))));
        energia.setText(Integer.toString(c.getInt(c.getColumnIndex("energia"))));
    }
}
