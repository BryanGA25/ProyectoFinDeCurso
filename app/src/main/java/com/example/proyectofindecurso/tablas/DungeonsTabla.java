package com.example.proyectofindecurso.tablas;

public class DungeonsTabla {

    private Integer id;
    private Integer nivel;
    private String raza;
    private String clase;
    private String nombre;
    private String alineamiento;
    private String transfondo;
    private Integer fuerza;
    private Integer destreza;
    private Integer constitucion;
    private Integer inteligencia;
    private Integer sabiduria;
    private Integer carisma;

    public DungeonsTabla(Integer id, Integer nivel, String raza, String clase, String nombre, String alineamiento, String transfondo, Integer fuerza, Integer destreza, Integer constitucion, Integer inteligencia, Integer sabiduria, Integer carisma) {
        this.id = id;
        this.nivel = nivel;
        this.raza = raza;
        this.clase = clase;
        this.nombre = nombre;
        this.alineamiento = alineamiento;
        this.transfondo = transfondo;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlineamiento() {
        return alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    public String getTransfondo() {
        return transfondo;
    }

    public void setTransfondo(String transfondo) {
        this.transfondo = transfondo;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;
    }

    public Integer getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(Integer constitucion) {
        this.constitucion = constitucion;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(Integer sabiduria) {
        this.sabiduria = sabiduria;
    }

    public Integer getCarisma() {
        return carisma;
    }

    public void setCarisma(Integer carisma) {
        this.carisma = carisma;
    }
}
