/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos;

import java.util.Scanner;

/**
 *
 * @author dag13
 */
public class Main {
    public static void main(String[] args) {
        //Se crea una instancia de la clase "Ordenamientos":
        Ordenamientos ordenamientos = new Ordenamientos();
        
        //Se declara el arreglo a ordenar
        int[] arreglo = {2,-8,0,2};
        
        Scanner scanner = new Scanner(System.in);
        //Switch para elegir algoritmo de ordenamiento
        System.out.println("Elija el algoritmo de ordenamiento:\n1.- Burbuja\n2.- Selección\n3.- Inserción\n4.- QuickSort\n5.- Merge Sort\nOpción: ");
        
        int opcion = scanner.nextInt();
        
        //Se imprime el arreglo desordenado
        System.out.println("\nArreglo: " + java.util.Arrays.toString(arreglo));
        
        // Switch para ejecutar el algoritmo elegido
        switch(opcion) {
            case 1: ordenamientos.burbuja(arreglo); break;
            case 2: ordenamientos.seleccion(arreglo); break;
            case 3: ordenamientos.insercion(arreglo); break;
            case 4: ordenamientos.quickSort(arreglo, 0, arreglo.length-1); break;
            case 5: ordenamientos.mergeSort(arreglo, 0, arreglo.length-1); break;
            default: System.out.println("Opción no válida.");
        }
        
        //Se imprime el arreglo ordenado
        System.out.println("\nArreglo ordenado: " + java.util.Arrays.toString(arreglo) + "\n");
        
        scanner.close();
    }
}
