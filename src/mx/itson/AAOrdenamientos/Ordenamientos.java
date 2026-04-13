/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos;

import java.util.Arrays;

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
    
    public static int[] insercion(int[] arreglo){
        //Declaración de variable que almacena el tamaño del arreglo
        int n = arreglo.length;     // 1
        
        //El ciclo empieza a iterar desde el elemento de la segunda posición
        for(int i = 1; i < n; i++){     // 1 + n + n
            //La primera llave es el valor del segundo elemento
            int key = arreglo[i];       // 1
            //Se almacena el índice del elemento anterior
            int j = i - 1;      // 1
            
            //Se cicla mientras "j" sea mayor o igual a cero y el valor del elemento actual, y anterior a la llave, sea mayor a la misma
            while(j >= 0 && arreglo[j] > key){      // n + n
                //Se guarda el valor del elemento actual en la siguiente posición del arreglo (la posición de la llave)
                arreglo[j + 1] = arreglo[j];        // 1
                //Variable "j" adquiere el valor del index anterior a la posición actual
                j = j - 1;      // 1
            }
            /*Cuando ya no se cumple la condición del ciclo:
            1.- Si "j" es menor a cero, la llave se guarda en la primera posición del arreglo (index 0)
            2.- Si valor del elemento en posición "j" es menor a la llave, ésta se guarda en la siguiente posición de dicho elemento*/
            arreglo[j + 1] = key;   // 1
        }
        //Se retorna el arreglo ordenado
        return arreglo;     // 1    8 + (2n)(2n) -> O(n^2)
    }
    
    //Algoritmo de Ordenamiento QuickSort
    public static void quickSort(int[] arreglo, int inicio, int fin){
        //Condición para el caso base
        if(inicio < fin){   // 1
            
            //Almacenar el valor del index del pivote actual
            int pivoteIndice = particion(arreglo, inicio, fin);  // Complejidad temporal de "particion": O(n)
            
            /* Donde: c = comparaciones;  T(n) llamadas a particiones
                T(n) = c∙n
            Caso promedio: T(n) = (c∙n)(log n)  -> T(n) = O(n log n)
            
            Peor de los casos: T(n) = c∙(n∙(n+1))/2  -> T(n) = O(n^2)
            */
            
            //Ordenar sub arreglo de elementos con index menores al del pivote
            quickSort(arreglo, inicio, pivoteIndice - 1);   // 1  Caso promedio: O(n log n); Peor de los casos: O(n^2)
            
            //Ordenar sub arreglo de elementos con index mayores al del pivote
            quickSort(arreglo, pivoteIndice + 1, fin);   // 1
        }
    }
    
    //Particiones para Algoritmo de Ordenamiento QuickSort
    public static int particion(int[] arreglo, int inicio, int fin){
        //Variable 'pivote' toma valor de elemento de la última posición (primer argumento dado a parámetro 'fin' en método 'quickSort' es: "arreglo.length-1")
        int pivote = arreglo[fin];      // 1
        
        //Se inicializa 'i' en una posición anterior al primer index de la partición actual
        int i = inicio - 1;     // 1+1 = 2
        
        //Se recorren los elementos de la partición actual
        for (int j = inicio; j < fin; j++){     // 1 + n + n -> 1 + 2n
            //Verificar si valor del elemento actual es menor al valor del pivote
            if(arreglo[j] < pivote){    // 1
                //Se incrementa en 1 el index
                i++;    // 1
                //Se almacena el valor del elemento en posición 'i' en variable auxiliar
                int aux = arreglo[i];   // 1
                //Elemento en posición actual adquiere el valor del elemento menor al pivote (coloca el menor a la izquierda)
                arreglo[i] = arreglo[j];    // 1
                //Elemento menor al pivote adquiere el valor de elemento en posición 'i' (se intercambian posiciones)
                arreglo[j] = aux;   // 1
            }
        }
        /*Al finalizar el ciclo, todos los elementos menores al pivote se encuentran a la izquierda de "i"
          y los elementos mayores al pivote se encuentran a la derecha de "i"
        */
        //Se declara auxiliar para colocar el pivote a la derecha del elemento menor
        int aux = arreglo[i + 1];   // 1+1 = 2
        //Se intercambian posiciones del pivote con la del elemento a la derecha del menor
        arreglo[i + 1] = arreglo[fin];  // 1+1 = 2
        arreglo[fin] = aux;     // 1
        
        //Se retorna el index del pivote
        return i + 1;   //(operación aritmética y retorno) 1+1 = 2    16 + 2n -> O(n)
    }
    
    public static void mergeSort(int[] arreglo, int inicio, int fin){   //5 + (n)(log n) -> n log n -> O(n log n)
        //Condicional para el caso recursivo y el caso base (si no se cumple)
        if(inicio < fin){   // 1
            //Se almacena el valor del medio del arreglo para dividirlo en dos mitades
            int medio = inicio + (fin - inicio) / 2;    //4
            
            //Llamada recursiva del lado izquierdo
            mergeSort(arreglo, inicio, medio);  //log n
            
            //Llamada recursiva del lado derecho
            mergeSort(arreglo, medio+1, fin);   //log n
            
            //Se llama el método de 'merge' para ordenar y unir los subarreglos
            merge(arreglo, inicio, medio, fin); //O(n)
        }
    }
    public static void merge(int[] arreglo, int inicio, int medio, int fin){    // 27 + 2n + 2n + n -> O(n)
        //Calcular tamaño de subarreglos temporales
        int n1 = medio - inicio + 1;    //Parte izquierda   3
        int n2 = fin - medio;    //Parte derecha    2
        
        //Crear arreglos temporales para almacenar las dos mitades
        int[] izquierdaArr = new int[n1];   //1
        int[] derechaArr = new int[n2];   //1
        
        //Llenar arreglos temporales con sus respectivos elementos
        for(int i = 0; i < n1; i++){    //Mitad izquierda   1 + n + n -> 1 + 2n
            izquierdaArr[i] = arreglo[inicio + i];  //2
        }
        for(int j = 0; j < n2; j++){    //Mitad derecha
            derechaArr[j] = arreglo[medio + 1 + j]; //3
        }
        
        //Índices iniciales     3
        int i = 0;  //subarreglo de la izquierda
        int j = 0;  //subarreglo de la derecha
        int k = inicio; //inicio del arreglo original
        
        //Mientras ambos subarreglos tengan elementos, se comparan y se ordenan en el arreglo original
        while(i < n1 && j < n2){    // n/2 + n/2  -> n
            if(izquierdaArr[i] <= derechaArr[j]){   //1
                arreglo[k] = izquierdaArr[i];   //Colocar elemento menor en posición actual del ciclo  1
                i++; //avanzar en la parte izquierda  1
            } else{
                arreglo[k] = derechaArr[j];     //1
                j++;    //1
            }
            k++; //avanzar en el arreglo original n -> (n/2 + n/2) + n  -> 2n
        }
        
        //Copiar elementos restantes del subarreglo izquierdo, en caso de que existan
        while(i < n1){  //n/2
            arreglo[k] = izquierdaArr[i];
            i++;
            k++;
        }
        //Copiar elementos restantes del subarreglo derecho, en caso de que existan
        while(j < n2){  //n/2   -> n/2 + n/2 -> n
            arreglo[k] = derechaArr[j];
            j++;
            k++;
        }
    }   // 27 + 2n + 2n + n -> O(n)
    
}