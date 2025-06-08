/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[5];

        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ":");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            String genero = "";
            while (true) {
                System.out.print("Genero (M/F): ");
                genero = scanner.nextLine().trim().toUpperCase();
                if (genero.equals("M") || genero.equals("F")) {
                    break;
                } else {
                    System.out.println("Entrada invalida. Solo se permite 'M' o 'F'.");
                }
            }

            int edad = -1;
            while (true) {
                System.out.print("Edad (0-120): ");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    if (edad >= 0 && edad <= 120) {
                        break;
                    } else {
                        System.out.println("Edad fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingresa un numero valido.");
                }
            }

            personas[i] = new Persona(nombre, apellido, genero, edad);
            System.out.println();
        }

        System.out.println("Nombres y Generos:");
        mostrarNombresYGeneros(personas);

        System.out.println("\nPromedio de edades: " + calcularPromedioEdad(personas));

        System.out.println("Cantidad de personas con genero Masculino (M): " + contarGenero(personas, "M"));
        System.out.println("Cantidad de personas con genero Femenino (F): " + contarGenero(personas, "F"));
    }

    public static void mostrarNombresYGeneros(Persona[] personas) {
        for (Persona p : personas) {
            System.out.println("- Nombre: " + p.getNombre() + " | Genero: " + p.getGenero());
        }
    }

    public static double calcularPromedioEdad(Persona[] personas) {
        int suma = 0;
        for (Persona p : personas) {
            suma += p.getEdad();
        }
        return (double) suma / personas.length;
    }

    public static int contarGenero(Persona[] personas, String generoBuscado) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }
}