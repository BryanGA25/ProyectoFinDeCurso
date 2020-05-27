package com.example.proyectofindecurso.tablas;

public class TiradasTabla {

    private Integer id;
    private Integer resultado;

    public TiradasTabla(Integer id, Integer resultado) {
        this.id = id;
        this.resultado = resultado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
}
