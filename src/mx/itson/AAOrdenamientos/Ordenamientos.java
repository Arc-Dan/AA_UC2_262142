/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos;

/**
 *
 * @author dag13
 */
public class Ordenamientos {
    
    //Método para el ordenamiento de Burbuja
    public static int[] burbuja(int[] arreglo){
        // Se declara variable 'n' para almacenar el tamaño del arreglo
        int n = arreglo.length;     // 1
        
        //Inicio del algoritmo
        //Se iterará el arreglo desde elemento con index 0 hasta el último elemento
        for(int i = 0; i < n-1; i++){   // 1 + n + n
            
            /* Se iterará el arreglo para cada elemento del mismo, comenzando desde elemento
               con index 0, hasta el último, menos la cantidad de ciclos externos completados */
            for(int j = 0; j < n-1-i; j++){     // 1 + n + n
                
                //Condicional para comparar si valor del elemento actual es mayor a valor del elemento siguiente
                if(arreglo[j] > arreglo[j+1]){  // 1 + 1
                    //Se declara variable auxiliar para almacenar valor mayor
                    int aux = arreglo[j];   // 1
                    //Se asigna valor de elemento menor al elemento de la posición actual
                    arreglo[j] = arreglo[j+1];  // 1 + 1
                    //Se asigna valor del auxiliar (mayor valor) al elemento siguiente (se intercambian las posiciones)
                    arreglo[j+1] = aux;     //1 + 1
                }
            }
        }
        //Se retorna el arreglo ordenado
        return arreglo;     // 1    11 + 2n x 2n -> O(n^2)
    }
    
    //Algoritmo de ordenamiento por Selección
    public static int[] seleccion(int[] arreglo){
        //Declaración de variable que almacena el tamaño del arreglo
        int n = arreglo.length;     // 1
        
        //Ciclo para iterar los elementos del arreglo por medio de sus índices
        for(int i = 0; i < n - 1; i++){     // 1 + n + n -> 1 + 2n
            
            //Se inicializa variable con valor de la posición del elemento actual en el ciclo
            int indexMinimo = i;    // 1
            
            //Se iteran los elementos del arreglo desde el elemento siguiente al elemento actual del ciclo exterior
            for(int j = i + 1; j < n; j++){     // 1 + 1 + n + n -> 2 + 2n
                //Compara si elemento actual es menor al elemento anterior, para encontrar el mínimo en el arreglo
                if(arreglo[j] < arreglo[indexMinimo]){      // 1
                    //Al encontrar elemento de menor valor, se guarda index de nuevo mínimo
                    indexMinimo = j;    // 1
                }
            }
            //Al finalizar ciclo interno se intercambian posiciones del valor actual y el valor mínimo encontrado
            //Se declara variable auxiliar que guarda el valor mínimo
            int aux = arreglo[indexMinimo];     // 1
            //Coloca valor de elemento actual de la iteración en la posición del elemento del valor mínimo
            arreglo[indexMinimo] = arreglo[i];  // 1
            //Coloca el valor mínimo en la posición actual de la iteración (se intercambian posiciones)
            arreglo[i] = aux;   // 1
        }
        //Se retorna el arreglo ordenado
        return arreglo;     // 1    11 + (2n)(2n) -> O(n^2)
    }
    
}