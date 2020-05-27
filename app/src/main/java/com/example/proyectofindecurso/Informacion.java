package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        TextView info = (TextView) findViewById(R.id.informacion);
        Bundle extras = getIntent().getExtras();
        String seleccion = extras.getString("seleccion");
        switch (seleccion) {

            case "Dungeons And Dragons":
                info.setText(R.string.informacion_dad);
            default:
                System.out.println("NADA");
                break;
        }
    }


}
