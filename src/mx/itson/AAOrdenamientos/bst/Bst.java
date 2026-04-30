/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.AAOrdenamientos.bst;

/**
 *
 * @author dag13
 */
// Clase Nodo con sus atributos y constructor
class Nodo {
   int valor; // El dato que guarda el nodo
   Nodo izq;  // Referencia al hijo izquierdo
   Nodo der;  // Referencia al hijo derecho

   //Constructor para inicializar un Nodo sin hijos 
   public Nodo(int valor) {
       this.valor = valor;
       this.izq = null;
       this.der = null;
   }
}

// Clase principal de alcance público para la implementación del árbol binario
public class Bst {
    // Atributo "raiz" de tipo Nodo
    Nodo raiz;  // Referencia a la raíz del árbol binario
    
    // Método para insertar un Nodo
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);  // Llamada recursiva
    }
    
    // Insertar Nodo y su valor de forma recursiva
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor); // Caso base: inserta aquí el nodo
        }

        if (valor < actual.valor) {
            actual.izq = insertarRecursivo(actual.izq, valor); // Ir a la izquierda
        } else if (valor > actual.valor) {
            actual.der = insertarRecursivo(actual.der, valor); // Ir a la derecha
        }

        return actual; // Devuelve la raíz del subárbol
   }
    
    // Método para buscar un Nodo en el árbol por medio de su valor
    public boolean buscar(int clave){
        return buscarRecursivo(raiz, clave);    //Retorna llamada recursiva para buscar el Nodo
    }
   
    // Método para buscar el valor del Nodo de forma recursiva
    private boolean buscarRecursivo(Nodo actual, int clave) {
        if (actual == null) return false; // Caso base: No se encuentra el Nodo con valor buscado

        if (clave == actual.valor) return true; // Caso base: Se encontró el Nodo con el valor buscado

        /* Condicional: si valor buscado es menor al valor del Nodo actual, lo busca por la izquierda
           de lo contrario, lo busca por la derecha. Retornando método recursivo de búsqueda en ambos casos */
        if (clave < actual.valor) {
            return buscarRecursivo(actual.izq, clave); // Buscar a la izquierda
        } else {
            return buscarRecursivo(actual.der, clave); // Buscar a la derecha
        }
    }
    
    // Método para eliminar un Nodo por medio de su valor
    public void eliminar(int valor){
        raiz = eliminarRecursivo(raiz, valor);  // Llamada a método recursivo para eliminar Nodo
    }

    // Método recursivo para eliminar un Nodo (retorna tipo Nodo)
    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null;
        
    /* Condicional: si valor buscado para eliminar es menor al valor del Nodo actual, lo busca por la izquierda
       si es mayor, lo busca por la derecha. Retornando método recursivo para eliminar en ambos casos. De lo
       contrario, se aplican casos de eliminación */
        if (valor < actual.valor) {
            actual.izq = eliminarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = eliminarRecursivo(actual.der, valor);
        } else {
            
            // Caso 1: Si ambos atributos "izq" y "der" de tipo Nodo de clase Nodo son null, el Nodo actual no tiene hijos
            if (actual.izq == null && actual.der == null) {
                return null;    //Se elimina, pues método retorna Nodo null
            }

            // Caso 2: Un hijo
            if (actual.izq == null) return actual.der;  //Si Nodo actual no tiene hijo izquierdo, retorna el hijo derecho
            if (actual.der == null) return actual.izq;  //Si Nodo actual no tiene hijo derecho, retorna el hijo izquierdo

            // Caso 3: Dos hijos
            actual.valor = encontrarMinimo(actual.der); // Reemplaza valor con el mínimo del subárbol derecho
            actual.der = eliminarRecursivo(actual.der, actual.valor); // Elimina el sucesor
        }
        // Se retorna el Nodo raíz del subárbol actual
        return actual;
}

   // Método auxiliar para encontrar el mínimo de un subárbol
    private int encontrarMinimo(Nodo actual) {
        int min = actual.valor; //Se almacena valor del Nodo actual en variable "min"
        
        /* Se cicla el bloque mientra hijo izquierdo del Nodo actual sea
           diferente de NULL, es decir, hasta el último Nodo de la izquierda */
        while (actual.izq != null) {
            //variable "min" toma valor del hijo de la izquierda
            min = actual.izq.valor;
            //parámetro actual de tipo Nodo, toma valor del Nodo de la izquierda
            actual = actual.izq;
        }
        return min; //se retorna el valor mínimo del Nodo de hasta la izquierda
    }
    
    // Método para imprimir el árbol jerárquico
    public void imprimirArbol() {
        imprimirArbolJerarquico(raiz, 0);
    }
    
    // Método recursivo para imprimir en consola el árbol binario de manera jerárquica
    private void imprimirArbolJerarquico(Nodo actual, int nivel){
        // Caso base: si nodo actual es NULL, simplemente retorna
        if (actual == null) return;
        
        //Imprimir en consola el subárbol de la parte derecha
        imprimirArbolJerarquico(actual.der, nivel + 1);
        
        //Para imprimir los espacios y ramas de Nodos con hijos en consola según su nivel
        if (nivel != 0){
            for (int i = 0; i < nivel -1; i++) System.out.print("|\t");
            System.out.println("|-----" +  actual.valor);
        } else {
            // Si nivel no es diferente de cero, se imprime el Nodo raíz
            System.out.println(actual.valor);
        }
        //Se imprime el subárbol izquierdo en la parte inferior de la pantalla
        imprimirArbolJerarquico(actual.izq, nivel + 1); 
    }
    
    /*
    public static void main(String[] args) {
        
        Bst arbolBinario = new Bst();
        int[] valores =  {30, 15, 45, 10, 20, 40, 50, 25, 35};
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
