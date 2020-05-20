package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DungeonsCreacion2 extends AppCompatActivity {

    TextView fuerza;
    TextView destreza;
    TextView carisma;
    TextView inteligencia;
    TextView constitucion;
    TextView sabiduria;

    BaseDeDatos db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeons_creacion2);
        fuerza=(TextView)findViewById(R.id.fue);
        destreza=(TextView)findViewById(R.id.des);
        carisma=(TextView)findViewById(R.id.caris);
        inteligencia=(TextView)findViewById(R.id.intelect);
        constitucion=(TextView)findViewById(R.id.cons);
        sabiduria=(TextView)findViewById(R.id.sab);

        db=new BaseDeDatos(this);

    }


    public void guardar(View view){
        Bundle extras=getIntent().getExtras();


        db.insertarDAD(extras.getInt("nivel"),extras.getString("raza")
                ,extras.getString("clase"),extras.getString("nombre"),extras.getString("alineamiento")
                ,extras.getString("transfondo"),Integer.parseInt(fuerza.getText().toString())
                ,Integer.parseInt(destreza.getText().toString()),Integer.parseInt(constitucion.getText().toString())
                ,Integer.parseInt(inteligencia.getText().toString()),Integer.parseInt(sabiduria.getText().toString())
                , Integer.parseInt(carisma.getText().toString()  ));
    }
}
