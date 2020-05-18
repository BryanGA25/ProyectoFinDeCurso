package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LanzadorDados extends AppCompatActivity {

    Spinner dado;
    int cantidad;
    TextView resultado;
    TextView cantidadT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador_dados);
        resultado=(TextView)findViewById(R.id.resultado);
        cantidadT=(TextView)findViewById(R.id.cantidad);
        dado=(Spinner)findViewById(R.id.tipo);

        ArrayAdapter<CharSequence> dados=ArrayAdapter.createFromResource(this,R.array.tipo,android.R.layout.simple_spinner_item);
        dado.setAdapter(dados);
    }

    public void lanzar(View view){

        resultado.setText("");
        String tipo=dado.getSelectedItem().toString();
        String numero=tipo.replace("D","");
        int variable= Integer.parseInt(numero);
        cantidad=Integer.parseInt(cantidadT.getText().toString());

        for(int i=0;i<cantidad;i++){

             int valor=(int)(Math.random()*variable+1);
             resultado.setText(resultado.getText().toString()+valor);
             if (i<cantidad){
                 resultado.append(",");
             }
        }
        resultado.setText(resultado.getText().toString().substring(0,resultado.getText().length()-1));

    }

}
