package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Escriba el nombre de una película o serie para buscar:");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            String direccion = "https://www.omdbapi.com/?t=" +
                    busqueda.replace(" ", "+") +
                    "&apikey=dd55f67c";  // Asegúrate de que tu API key sea válida

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Título ya convertido: " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección: ");
                System.out.println(e.getMessage());
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println("Error de conversión: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Mostrar todos los títulos agregados
        System.out.println(titulos);

        // ✅ Escritura del archivo JSON (ahora con manejo de errores)
        try {
            FileWriter escritura = new FileWriter("titulos.json");
            escritura.write(gson.toJson(titulos));
            escritura.close();
            System.out.println("Archivo 'titulos.json' guardado exitosamente en: " + System.getProperty("user.dir"));
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo 'titulos.json'. Verifica permisos o ruta.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Finalizado el proceso de búsqueda.");
    }
}