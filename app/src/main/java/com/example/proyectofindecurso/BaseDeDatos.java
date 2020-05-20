package com.example.proyectofindecurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {


    private static final String nombreDB="BaseFichas";
    private static final int VERSION_BD = 1;

    private String crearTablaDAD="CREATE TABLE DungeonsAndDragons (_id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER, " +
            "raza TEXT, clase TEXT, nombre TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            " destreza INTEGER, constitucion INTEGER, inteligencia TEXT, sabiduria TEXT, carisma TEXT)";



    private SQLiteDatabase bd;


    public BaseDeDatos(Context context) {
        super(context, nombreDB, null, VERSION_BD);
        bd = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaDAD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void insertarDAD(Integer nivel, String raza, String clase, String nombre, String alineamiento, String transfondo,
            Integer fuerza, Integer destreza, Integer constitucion, Integer inteligencia, Integer sabiduria, Integer carisma){


        ContentValues cv = new ContentValues();
        cv.put("nivel", nivel);
        cv.put("raza", raza);
        cv.put("clase", clase);
        cv.put("nombre", nombre);
        cv.put("alineamiento", alineamiento);
        cv.put("transfondo", transfondo);
        cv.put("fuerza", fuerza);
        cv.put("destreza", destreza);
        cv.put("constitucion", constitucion);
        cv.put("inteligencia", inteligencia);
        cv.put("sabiduria", sabiduria);
        cv.put("carisma", carisma);



        bd.insert("DungeonsAndDragons", null, cv);
    }

    public  void verPersonajeDAD(){

    }
}
