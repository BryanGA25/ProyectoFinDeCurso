package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SeleccionadorFichaDAD extends AppCompatActivity {

    private Spinner personajes;
    private BaseDeDatos db;
    private SQLiteDatabase database;
    private ArrayList<String> nombres;
    private ArrayList<Integer> ids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionador_ficha_dad);

        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();
        personajes = (Spinner) findViewById(R.id.personajes);
        nombres = new ArrayList<>();
        ids = new ArrayList<>();
        cargarSpinner();

    }


    public void visualizar(View view) {

        Intent ver = new Intent(this, DungeonsCreacion1.class);
        ver.putExtra("modificacion", true);
        ver.putExtra("id", ids.get(personajes.getSelectedItemPosition()));
        startActivity(ver);
    }

    public void borrar(View view) {

        database.delete("DungeonsAndDragons", "_id=" + ids.get(personajes.getSelectedItemPosition()), null);
        cargarSpinner();
    }


    public void cargarSpinner() {
        Bundle extras = getIntent().getExtras();
        String seleccion = extras.getString("seleccion");
        Cursor c=null;
        switch (seleccion) {

            case "Dungeons And Dragons":
                c = database.rawQuery("select _id , nombre from DungeonsAndDragons", null);
                break;
            case "World of Warcraft":
                c = database.rawQuery("select _id , nombre from WorldOfWarcraft", null);
                break;
        }
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                nombres.add(c.getString(c.getColumnIndex("nombre")));
                ids.add(c.getInt(c.getColumnIndex("_id")));
            } while (c.moveToNext());
            ArrayAdapter<CharSequence> nombresAdpater = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nombres);
            personajes.setAdapter(nombresAdpater);
        }

    }


}
