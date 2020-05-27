package com.example.proyectofindecurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectofindecurso.tablas.DungeonsTabla;

public class BaseDeDatos extends SQLiteOpenHelper {


    private static final String nombreDB = "BaseFichas";
    private static final int VERSION_BD = 1;

    private String crearTablaDAD = "CREATE TABLE DungeonsAndDragons (_id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER, " +
            "raza TEXT, clase TEXT, nombre TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            " destreza INTEGER, constitucion INTEGER, inteligencia TEXT, sabiduria TEXT, carisma TEXT)";

    private String crearTablaTiradas = "CREATE TABLE Tiradas (_id INTEGER PRIMARY KEY AUTOINCREMENT, resultado INTEGER)";
    private SQLiteDatabase bd;


    public BaseDeDatos(Context context) {
        super(context, nombreDB, null, VERSION_BD);
        bd = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaDAD);
        db.execSQL(crearTablaTiradas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TAble IF EXISTS "+"DungeonsAndDragons");
        db.execSQL("DROP TAble IF EXISTS "+"Tiradas");
        onCreate(db);
    }


    public void insertarDAD(Integer nivel, String raza, String clase, String nombre, String alineamiento, String transfondo,
                            Integer fuerza, Integer destreza, Integer constitucion, Integer inteligencia, Integer sabiduria, Integer carisma) {


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

    public void actualizarPersonajeDAD(DungeonsTabla dt) {

        ContentValues cv=new ContentValues();

        cv.put("nivel", dt.getNivel());
        cv.put("raza", dt.getRaza());
        cv.put("clase", dt.getClase());
        cv.put("nombre", dt.getNombre());
        cv.put("alineamiento", dt.getAlineamiento());
        cv.put("transfondo", dt.getTransfondo());
        cv.put("fuerza", dt.getFuerza());
        cv.put("destreza", dt.getDestreza());
        cv.put("constitucion", dt.getConstitucion());
        cv.put("inteligencia", dt.getInteligencia());
        cv.put("sabiduria", dt.getSabiduria());
        cv.put("carisma", dt.getCarisma());

        bd.update("DungeonsAndDragons",cv,"_id="+dt.getId(),null);
    }


    public void borrarTirada(int id){
        bd.delete("Tiradas","_id="+id,null);
    }


    public void insertarTirada(int resultado){
        ContentValues cv = new ContentValues();
        cv.put("resultado",resultado);
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAA");
        bd.insert("Tiradas",null,cv);
    }
}
