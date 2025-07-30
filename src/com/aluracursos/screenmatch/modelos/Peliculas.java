package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Peliculas extends Titulo implements Clasificacion {
    private String director;

    // ❌ Antes: int fechaDeLanzamiento
    // ✅ Ahora: String fechaDeLanzamiento
    public Peliculas(String nombre, int fechaDeLanzamiento) {
        super(nombre, String.valueOf(fechaDeLanzamiento)); // Ahora coincide con el constructor de Titulo
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Peliculas: " + super.toString();
    }
}