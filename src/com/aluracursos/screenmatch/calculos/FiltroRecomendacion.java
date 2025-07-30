package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {

    public void filtra(Clasificacion clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Con buena evaluacion en estos momentos");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Con evaluacion regular en estos momentos");
        } else {
            System.out.println("Incluyelo en tu lista para ver y evaluar");
        }
    }
}
