package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WarcraftCreacion1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warcraft_creacion1);
    }
    public void siguiente(View view) {
        Intent actividad = new Intent(this,WarcraftCreacion2.class);
        startActivity(actividad);
    }
}
