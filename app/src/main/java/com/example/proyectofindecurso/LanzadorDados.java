package com.example.proyectofindecurso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class LanzadorDados extends AppCompatActivity {

    private Spinner dado;
    private int cantidad;
    private TextView resultado;
    private TextView cantidadT;
    private ArrayList<Integer> valores;
    private BaseDeDatos db;
    private SQLiteDatabase database;
    private int total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador_dados);
        resultado = (TextView) findViewById(R.id.resultado);
        cantidadT = (TextView) findViewById(R.id.cantidad);
        dado = (Spinner) findViewById(R.id.tipo);
        db = new BaseDeDatos(this);
        database = db.getReadableDatabase();
        ArrayAdapter<CharSequence> dados = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
        dado.setAdapter(dados);
    }

    public void lanzar(View view) {
        valores = new ArrayList();
        resultado.setText("");
        String tipo = dado.getSelectedItem().toString();
        String numero = tipo.replace("D", "");
        int variable = Integer.parseInt(numero);
        cantidad = Integer.parseInt(cantidadT.getText().toString());

        for (int i = 0; i < cantidad; i++) {

            int valor = (int) (Math.random() * variable + 1);

            resultado.setText(resultado.getText().toString() + valor);
            if (i < cantidad) {
                resultado.append(",");
            }
            valores.add(valor);
        }
        resultado.setText(resultado.getText().toString().substring(0, resultado.getText().length() - 1));

    }

    public void guardar(View view){
        int menor = valores.get(0);

        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i) < menor) {
                menor = valores.get(i);
            }
        }
        Integer is = menor;
        valores.remove(is);
        total=0;
        for (int i : valores
        ) {
            total=i+total;
        }
        db.insertarTirada(total);
        total=0;

    }

}
