package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nombre;
    private String fechaDeLanzamiento; // 👈 Ahora es String
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, String fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo() {

    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = miTituloOmdb.year(); // Ya no se convierte a int
        if (miTituloOmdb.runtime().contains("N/A")) {
          throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, " +
                  "porque contiene 'N/A'");
        }

        // Extraer solo los números de la duración
        try {
            String duracionTexto = miTituloOmdb.runtime().split(" ")[0];
            this.duracionEnMinutos = Integer.parseInt(duracionTexto);
        } catch (Exception e) {
            this.duracionEnMinutos = 0; // Valor por defecto si falla
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaDeLanzamiento() { // 👈 Ahora retorna String
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    public boolean muestraFichaTecnica() {
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duracion de la pelicula: " + getDuracionEnMinutos() + " min");
        return false;
    }

    public boolean muestraFichaTecnicaSerie() {
        System.out.println("El nombre de la serie es: " + nombre);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duracion de la serie: " + getDuracionEnMinutos() + " min");
        return false;
    }

    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia() {
        return totalDeLasEvaluaciones == 0 ? 0 : sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getFechaDeLanzamiento().compareTo(o.getFechaDeLanzamiento());
    }

    @Override
    public String toString() {
        return """
                
                === Ficha Técnica ===
                Nombre: %s
                Año: %s
                Duración: %d min
                ======================
                """.formatted(nombre, fechaDeLanzamiento, duracionEnMinutos);
    }
}