/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos;

/**
 *
 * @author dag13
 */
public class Main {
    public static void main(String[] args) {
        //Se crea una instancia de la clase "Ordenamientos":
        Ordenamientos ordenamientos = new Ordenamientos();
        
        //Se declara el arreglo a ordenar
        int[] arreglo = {14,6,12};
        
        //Se imprime el arreglo desordenado
        System.out.println("\nArreglo: " + java.util.Arrays.toString(arreglo));
        
        //Se utiliza el método de instancia del algoritmo deseado y se da como argumento el arreglo
        //ordenamientos.burbuja(arreglo);
        //ordenamientos.seleccion(arreglo);
        ordenamientos.insercion(arreglo);
        
        //Se imprime el arreglo ordenado
        System.out.println("\nArreglo ordenado: " + java.util.Arrays.toString(arreglo) + "\n");
    }
}
