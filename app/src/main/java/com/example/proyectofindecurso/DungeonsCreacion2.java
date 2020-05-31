package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofindecurso.tablas.DungeonsTabla;

import java.util.ArrayList;

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
    private Spinner tiradas;
    private int id;
    private ArrayList<String> resultados;
    private ArrayList<Integer> ids;
    private TextView info;

    public void onResume(){
        super.onResume();
        cargarTiradas();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion2);
        fuerza = (TextView) findViewById(R.id.fue);
        destreza = (TextView) findViewById(R.id.agi);
        carisma = (TextView) findViewById(R.id.caris);
        inteligencia = (TextView) findViewById(R.id.intelect);
        constitucion = (TextView) findViewById(R.id.ener);
        sabiduria = (TextView) findViewById(R.id.esp);
        extras = getIntent().getExtras();
        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();
        modificacion = extras.getBoolean("modificacion");
        tiradas = findViewById(R.id.tiradas);
        resultados = new ArrayList<>();
        info=(TextView) findViewById(R.id.texto);
        ids = new ArrayList<>();





        if (modificacion) {
            modificarPersonaje();
            tiradas.setVisibility(View.GONE);
            info.setVisibility(View.GONE);
            findViewById(R.id.dados).setVisibility(View.GONE);
        }else {
            cargarTiradas();

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
    if(fuerza.getText().toString().equalsIgnoreCase("") || destreza.getText().toString().equalsIgnoreCase("")
            ||constitucion.getText().toString().equalsIgnoreCase("")||inteligencia.getText().toString().equalsIgnoreCase("")
            ||sabiduria.getText().toString().equalsIgnoreCase("")||carisma.getText().toString().equalsIgnoreCase("")){
        Toast.makeText(this, "Faltan campos sin rellenar", Toast.LENGTH_SHORT).show();
    }else {

        if (modificacion) {
            DungeonsTabla dt = new DungeonsTabla(id, extras.getInt("nivel"), extras.getString("raza")
                    , extras.getString("clase"), extras.getString("nombre"), extras.getString("alineamiento")
                    , extras.getString("transfondo"), Integer.parseInt(fuerza.getText().toString())
                    , Integer.parseInt(destreza.getText().toString()), Integer.parseInt(constitucion.getText().toString())
                    , Integer.parseInt(inteligencia.getText().toString()), Integer.parseInt(sabiduria.getText().toString())
                    , Integer.parseInt(carisma.getText().toString()));
            db.actualizarPersonajeDAD(dt);
        } else {
            DungeonsTabla dt = new DungeonsTabla
                    (0, extras.getInt("nivel"), extras.getString("raza")
                            , extras.getString("clase"), extras.getString("nombre"), extras.getString("alineamiento")
                            , extras.getString("transfondo"), Integer.parseInt(fuerza.getText().toString())
                            , Integer.parseInt(destreza.getText().toString()), Integer.parseInt(constitucion.getText().toString())
                            , Integer.parseInt(inteligencia.getText().toString()), Integer.parseInt(sabiduria.getText().toString())
                            , Integer.parseInt(carisma.getText().toString()));
            db.insertarDAD(dt);
        }
        Intent menu = new Intent(this, Seleccion.class);
        startActivity(menu);
    }
    }

    public void dados(View view){

        Intent dados=new Intent(this,LanzadorDados.class);
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
}
