package com.example.proyectofindecurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectofindecurso.tablas.DungeonsTabla;
import com.example.proyectofindecurso.tablas.PathfinderTabla;
import com.example.proyectofindecurso.tablas.WarcraftTabla;

public class BaseDeDatos extends SQLiteOpenHelper {


    private static final String nombreDB = "BaseFichas";
    private static final int VERSION_BD = 1;

    private String crearTablaDAD = "CREATE TABLE DungeonsAndDragons (_id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER, " +
            "raza TEXT, clase TEXT, nombre TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            "destreza INTEGER, constitucion INTEGER, inteligencia INTEGER, sabiduria INTEGER, carisma INTEGER)";


    private String crearTablaPathfinder = "CREATE TABLE Pathfinder (_id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER, " +
            "raza TEXT, clase TEXT, nombre TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            "destreza INTEGER, constitucion INTEGER, inteligencia INTEGER, sabiduria INTEGER, carisma INTEGER)";


    private String crearTablaWarcraft = "CREATE TABLE WorldOfWarcraft (_id INTEGER PRIMARY KEY AUTOINCREMENT, nivel INTEGER," +
            "raza TEXT, clase TEXT, nombre TEXT, faccion TEXT, alineamiento TEXT, transfondo TEXT, fuerza INTEGER," +
            "agilidad INTEGER, energia INTEGER, inteligencia INTEGER, espiritu INTEGER, carisma INTEGER)";

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
        db.execSQL(crearTablaPathfinder);
        db.execSQL(crearTablaWarcraft);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TAble IF EXISTS " + "DungeonsAndDragons");
        db.execSQL("DROP TAble IF EXISTS " + "Tiradas");
        db.execSQL("DROP TAble IF EXISTS " + "WorldOfWarcraft");
        db.execSQL("DROP TAble IF EXISTS " + "Pathfinder");
        onCreate(db);
    }

    public void insertarWarcraft(WarcraftTabla wt) {
        ContentValues cv = new ContentValues();
        cv.put("nivel", wt.getNivel());
        cv.put("raza", wt.getRaza());
        cv.put("clase", wt.getClase());
        cv.put("nombre", wt.getNombre());
        cv.put("faccion", wt.getFaccion());
        cv.put("alineamiento", wt.getAlineamiento());
        cv.put("transfondo", wt.getTransfondo());
        cv.put("fuerza", wt.getFuerza());
        cv.put("agilidad", wt.getAgilidad());
        cv.put("energia", wt.getEnergia());
        cv.put("inteligencia", wt.getInteligencia());
        cv.put("espiritu", wt.getEsperitu());
        cv.put("carisma", wt.getCarisma());

        bd.insert("WorldOfWarcraft", null, cv);


    }

    public void actualizarWarcraft(WarcraftTabla wt) {
        ContentValues cv = new ContentValues();
        cv.put("nivel", wt.getNivel());
        cv.put("raza", wt.getRaza());
        cv.put("clase", wt.getClase());
        cv.put("nombre", wt.getNombre());
        cv.put("faccion", wt.getFaccion());
        cv.put("alineamiento", wt.getAlineamiento());
        cv.put("transfondo", wt.getTransfondo());
        cv.put("fuerza", wt.getFuerza());
        cv.put("agilidad", wt.getAgilidad());
        cv.put("energia", wt.getEnergia());
        cv.put("inteligencia", wt.getInteligencia());
        cv.put("espiritu", wt.getEsperitu());
        cv.put("carisma", wt.getCarisma());

        bd.update("WorldOfWarcraft", cv, "_id=" + wt.getId(), null);
    }


    public void insertarDAD(DungeonsTabla dt) {


        ContentValues cv = new ContentValues();
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


        bd.insert("DungeonsAndDragons", null, cv);
    }

    public void actualizarPersonajeDAD(DungeonsTabla dt) {

        ContentValues cv = new ContentValues();

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

        bd.update("DungeonsAndDragons", cv, "_id=" + dt.getId(), null);
    }


    public void borrarTirada(int id) {
        bd.delete("Tiradas", "_id=" + id, null);
    }


    public void insertarTirada(int resultado) {
        ContentValues cv = new ContentValues();
        cv.put("resultado", resultado);
        bd.insert("Tiradas", null, cv);
    }

    public void insertarPathfinder(PathfinderTabla pt) {

        ContentValues cv = new ContentValues();
        cv.put("nivel", pt.getNivel());
        cv.put("raza", pt.getRaza());
        cv.put("clase", pt.getClase());
        cv.put("nombre", pt.getNombre());
        cv.put("alineamiento", pt.getAlineamiento());
        cv.put("transfondo", pt.getTransfondo());
        cv.put("fuerza", pt.getFuerza());
        cv.put("destreza", pt.getDestreza());
        cv.put("constitucion", pt.getConstitucion());
        cv.put("inteligencia", pt.getInteligencia());
        cv.put("sabiduria", pt.getSabiduria());
        cv.put("carisma", pt.getCarisma());


        bd.insert("Pathfinder", null, cv);
    }

    public void actualizarPersonajePathfinder(PathfinderTabla pt) {
        ContentValues cv = new ContentValues();
        cv.put("nivel", pt.getNivel());
        cv.put("raza", pt.getRaza());
        cv.put("clase", pt.getClase());
        cv.put("nombre", pt.getNombre());
        cv.put("alineamiento", pt.getAlineamiento());
        cv.put("transfondo", pt.getTransfondo());
        cv.put("fuerza", pt.getFuerza());
        cv.put("destreza", pt.getDestreza());
        cv.put("constitucion", pt.getConstitucion());
        cv.put("inteligencia", pt.getInteligencia());
        cv.put("sabiduria", pt.getSabiduria());
        cv.put("carisma", pt.getCarisma());


        bd.update("Pathfinder", cv, "_id=" + pt.getId(), null);

    }
}
