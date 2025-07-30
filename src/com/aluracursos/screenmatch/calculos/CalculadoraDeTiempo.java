package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Peliculas;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return this.tiempoTotal;
    }

    public void incluye(Titulo titulo) {
        System.out.println("Incluyendo: " + titulo.getNombre() + " con duración de "
                + titulo.getDuracionEnMinutos() + " minutos.");
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
