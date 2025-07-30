package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Peliculas;
import com.aluracursos.screenmatch.modelos.Serie;


import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Peliculas miPelicula = new Peliculas("Constantine", 2005);
        miPelicula.setDuracionEnMinutos(121);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(9.8);
        miPelicula.evalua(8.5);
        miPelicula.evalua(10);
        System.out.println("Media de evaluaciones de la pelicula: " + miPelicula.calculaMedia());

        var otraPelicula = new Peliculas("Gladiador", 2000);
        otraPelicula.setDuracionEnMinutos(155);
        otraPelicula.muestraFichaTecnica();

        otraPelicula.evalua(8.5);
        otraPelicula.evalua(7.5);
        otraPelicula.evalua(9.5);
        System.out.println("Media de evaluaciones de la pelicula: " + otraPelicula.calculaMedia());

        Peliculas segundaPelicula = new Peliculas ("John Wick", 2014);
        segundaPelicula.setDuracionEnMinutos(101);
        segundaPelicula.muestraFichaTecnica();

        segundaPelicula.evalua(10);
        segundaPelicula.evalua(9.5);
        segundaPelicula.evalua(9.0);
        System.out.println("Media de evaluaciones de la pelicula: " + segundaPelicula.calculaMedia());

        Serie theBigBang = new Serie("The Big Bang Theory", 2007);

        theBigBang.setTemporadas(12);
        theBigBang.setMinutosPorEpisodio(22);
        theBigBang.setEpisodiosPorTemporada(24);
        theBigBang.muestraFichaTecnicaSerie();

        theBigBang.evalua(10);
        theBigBang.evalua(9.5);
        theBigBang.evalua(10);
        System.out.println("Media de evaluaciones de la serie: " + theBigBang.calculaMedia());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(otraPelicula);
        calculadora.incluye(segundaPelicula);
        calculadora.incluye(theBigBang);
        System.out.println("Tiempo necesario para ver tus peliculas y series en favoritos "
                + calculadora.getTiempoTotal() + " min");
        System.out.println("*************************************************************");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("El Big Bang");
        episodio.setSerie(theBigBang);
        episodio.setTotalVisualizaciones(200);

        filtroRecomendacion.filtra(episodio);

        ArrayList <Peliculas> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(segundaPelicula);

        ArrayList <Serie> listaDeSeries = new ArrayList<>();
        listaDeSeries.add(theBigBang);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());

        System.out.println("Tamaño de la lista de series: " + listaDeSeries.size());
        System.out.println("La primera serie es: " + listaDeSeries.get(0).getNombre());
        System.out.println(listaDeSeries.toString());
        System.out.println("toString de la serie: " + listaDeSeries.get(0).toString());
        System.out.println("*************************************************************");

    }
}
