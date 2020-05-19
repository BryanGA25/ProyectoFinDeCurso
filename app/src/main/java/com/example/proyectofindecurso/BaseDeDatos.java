package com.example.proyectofindecurso;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {


    private String crearTablaDAD="CREATE TABLE DungeonsAndDragons ( id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER, " +
            "raza TEXT, clase TEXT, nombre TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            " destreza INTEGER, constitucion INTEGER, inteligencia TEXT, sabiduria TEXT, carisma TEXT)";


    private SQLiteDatabase bd;

    public BaseDeDatos( Context context,String name,SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabase bd) {
        super(context, name, factory, version);
        bd=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaDAD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
