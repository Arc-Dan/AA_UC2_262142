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
        int[] arreglo = {6,3,8,9,4};
        
        //Se utiliza el método de instancia del algoritmo deseado y se da como argumento el arreglo
        ordenamientos.seleccion(arreglo);
        
        //Se imprime el arreglo ordenado
        for (int e : arreglo) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }
}
