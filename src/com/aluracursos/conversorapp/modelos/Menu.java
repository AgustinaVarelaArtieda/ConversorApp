package com.aluracursos.conversorapp.modelos;

import com.aluracursos.conversorapp.consultas.ConsultaApi;
import com.aluracursos.conversorapp.excepcion.ErrorEnConversionDeDuracionException;
import java.util.Scanner;

public class Menu {
    private final Scanner lectura = new Scanner(System.in);
    private final ConsultaApi consulta = new ConsultaApi();
    private String monedaDeOrigen;
    private String monedaDeDestino;

    private void displayMenu() {
        System.out.println("***************************************** \n");
        System.out.println("Bienvenido/a al Conversor de Monedas!");
        System.out.println("\n Seleccione lo que desea convertir: \n");
        System.out.println("1) Dólar a Peso Argentino");
        System.out.println("2) Peso Argentino a Dólar");
        System.out.println("3) Dólar a Real Brasileño");
        System.out.println("4) Real Brasileño a Dólar");
        System.out.println("5) Dólar a Peso Boliviano");
        System.out.println("6) Peso Boliviano a Dólar");
        System.out.println("7) Salir");
        System.out.println("***************************************** \n");
    }

    private int eleccionUsuario() {
        int opcionElegida = -1;
        while (opcionElegida < 1 || opcionElegida > 7) {
            try {
                opcionElegida = Integer.parseInt(lectura.nextLine());
                if (opcionElegida < 1 || opcionElegida > 7) {
                    System.out.println("***************************************** \n");
                    System.out.println("Opción inválida. Por favor ingrese una opción válida entre 1 y 7");
                    System.out.println("***************************************** \n");
                }
            } catch (NumberFormatException e) {
                System.out.println("***************************************** \n");
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                System.out.println("***************************************** \n");
            }
        }
        return opcionElegida;
    }

    private double cantidadAConvertir () {
        double cantidad = 0;
        boolean validacion = false;
        while (!validacion) {
            System.out.println("***************************************** \n");
            System.out.println("Ingrese la cantidad que desea convertir: ");
            try {
                cantidad = Double.parseDouble(lectura.nextLine());
                if (cantidad < 0) {
                    System.out.println("***************************************** \n");
                    System.out.println("La cantidad no puede ser negativa, intente con una cantidad válida.");
                    System.out.println("***************************************** \n");
                } else {
                    validacion = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                System.out.println("***************************************** \n");
            }
        }
        return cantidad;
    }

    public void run() {
        while (true) {
            displayMenu();
            int eleccionDelUsuario = eleccionUsuario();
            if (eleccionDelUsuario == 7) {
                System.out.println("***************************************** \n");
                System.out.println("Saliendo del programa, que tenga un buen día!");
                break;
            }

            switch (eleccionDelUsuario){
                case 1: monedaDeOrigen = "USD"; monedaDeDestino = "ARS"; break;
                case 2: monedaDeOrigen = "ARS"; monedaDeDestino = "USD"; break;
                case 3: monedaDeOrigen = "USD"; monedaDeDestino = "BRL"; break;
                case 4: monedaDeOrigen = "BRL"; monedaDeDestino = "USD"; break;
                case 5: monedaDeOrigen = "USD"; monedaDeDestino = "BOB"; break;
                case 6: monedaDeOrigen = "BOB"; monedaDeDestino = "USD"; break;
            }

            try {
                double cantidad = cantidadAConvertir();
                Moneda consultaConversion = consulta.buscaMoneda(monedaDeOrigen, monedaDeDestino, cantidad);
                System.out.println("***************************************** \n");
                System.out.println("El cambio de " + cantidad + " " + monedaDeOrigen + " a " + monedaDeDestino + " es de:  " + consultaConversion.conversion_result() + " [" + monedaDeDestino + "] ");
                System.out.println("Se utilizó una tasa de conversión de: " + consultaConversion.conversion_rate() + ".");
            } catch ( ErrorEnConversionDeDuracionException e){
                System.out.println("Error al realizar la conversión: " + e.getMessage());
                System.out.println("***************************************** \n");
            } catch (RuntimeException e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("***************************************** \n");
            }
        }
    }
}
