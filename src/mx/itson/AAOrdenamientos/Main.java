/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos;

import java.util.Scanner;
import mx.itson.AAOrdenamientos.bst.Bst;

/**
 *
 * @author dag13
 */
public class Main {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancia de la clase Ordenamientos
        Ordenamientos ordenamientos = new Ordenamientos();
        // Instancia del árbol binario
        Bst arbolBinario = new Bst();

        // Menú principal
        System.out.print("\nSeleccione una opción:\n1.- Algoritmos de Ordenamiento\n2.- Árbol de búsqueda Binaria\nOpción: ");
        int opcionPrincipal = scanner.nextInt();

        if (opcionPrincipal == 1) {
            // --- SUBMENÚ DE ORDENAMIENTO ---
            int[] arreglo = {2, -8, 0, 2};

            System.out.println("\nElija el algoritmo de ordenamiento:\n1.- Burbuja\n2.- Selección\n3.- Inserción\n4.- QuickSort\n5.- Merge Sort\nOpción: ");
            int opcionOrdenamiento = scanner.nextInt();

            // Imprimir arreglo original
            System.out.println("\nArreglo original: " + java.util.Arrays.toString(arreglo));

            // Ejecutar algoritmo elegido
            switch(opcionOrdenamiento) {
                case 1: ordenamientos.burbuja(arreglo); break;
                case 2: ordenamientos.seleccion(arreglo); break;
                case 3: ordenamientos.insercion(arreglo); break;
                case 4: ordenamientos.quickSort(arreglo, 0, arreglo.length-1); break;
                case 5: ordenamientos.mergeSort(arreglo, 0, arreglo.length-1); break;
                default: System.out.println("Opción no válida.");
            }

            // Imprimir arreglo ordenado
            System.out.println("\nArreglo ordenado: " + java.util.Arrays.toString(arreglo));

            }else if (opcionPrincipal == 2){
                // --- SUBMENÚ DE BST ---
                boolean salir = false;
                while (!salir) {
                    System.out.println("\nÁrbol Binario\nElija una de las opciones:");
                    System.out.println("1.- Insertar nodo");
                    System.out.println("2.- Buscar nodo");
                    System.out.println("3.- Eliminar nodo");
                    System.out.println("4.- Imprimir árbol");
                    System.out.println("5.- Salir");
                    System.out.print("Opción: ");
                    int opcionBST = scanner.nextInt();

                    switch(opcionBST) {
                        case 1:
                            System.out.println("Insertar nodo");
                            while(true){
                                System.out.print("\n[Ingrese un valor negativo para salir]\nValor: ");
                                int valor = scanner.nextInt();
                                if(valor < 0){
                                    break;
                                }
                                arbolBinario.insertar(valor);
                                System.out.println("Nodo insertado.");
                                }
                            break;

                        case 2:
                            System.out.print("\nIngrese el valor a buscar: ");
                            int clave = scanner.nextInt();
                            boolean encontrado = arbolBinario.buscar(clave);
                            System.out.println(encontrado ? "Valor encontrado en el árbol." : "Valor NO encontrado.");
                            break;

                        case 3:
                            System.out.print("\nIngrese el valor a eliminar: ");
                            int valorEliminar = scanner.nextInt();
                            arbolBinario.eliminar(valorEliminar);
                            System.out.println("Nodo eliminado.");
                            break;

                        case 4:
                            System.out.println("\nEstructura del árbol:");
                            arbolBinario.imprimirArbol();
                            break;
                            
                        case 5: salir = true; break;
                        
                        default: System.out.println("\nOpción no válida.");
                    }
                }
            }else{
                System.out.println("Opción no válida.");
            }
        scanner.close();
}
    /*
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
        
        // Se instancia clase "Bst"
        Bst arbolBinario = new Bst();
        int[] valores =  {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arbolBinario.insertar(v);
        }
        
        System.out.println("Estructura del arbol: ");
        arbolBinario.imprimirArbol();
        
        System.out.println("-----------");
        arbolBinario.eliminar(45);
        arbolBinario.imprimirArbol();
    }
    */
}
