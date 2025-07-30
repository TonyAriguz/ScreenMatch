package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Peliculas;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {

        Peliculas miPelicula = new Peliculas("Constantine", 2005);
        miPelicula.evalua(10);
        var otraPelicula = new Peliculas("Gladiador", 2000);
        otraPelicula.evalua(9);
        Peliculas segundaPelicula = new Peliculas ("John Wick", 2014);
        segundaPelicula.evalua(9.5);
        Serie theBigBang = new Serie("The Big Bang Theory", 2007);
        theBigBang.evalua(9.5);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(segundaPelicula);
        lista.add(theBigBang);

        for (Titulo item: lista){
            System.out.println("Nombre: " + item.getNombre());
            if (item instanceof Peliculas pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion: " + pelicula.getClasificacion());
            }
        }

        ArrayList <String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Keanu Reeves");
        listaDeArtistas.add("Russell Crowe");
        listaDeArtistas.add("Halle Berry");
        listaDeArtistas.add("Jim Parsons");
        listaDeArtistas.add("Kaley Cuoco");
        listaDeArtistas.add("Johnny Galecki");
        listaDeArtistas.add("Simon Helberg");
        listaDeArtistas.add("Kunal Nayyar");
        listaDeArtistas.add("Mayim Bialik");
        listaDeArtistas.add("Melissa Rauch");

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada:" + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenada:" + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
    }
}
