/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2.ClaseCompetencia;
//import java.util.Scanner;


/**
 * Programa que encuentra repeticiones de numeros
 * especificamente el primer número repetido en la lista.
 * 
 * @author Camila Alfaro Rivera
 * 
 * 
 */
public class Main {
    public static void main(String[] args) {
        // Caso 1: números 2 4 7 9 5 1 sin repetir
        System.out.println("Caso 1: numeros 2, 4, 7, 9, 5, 1");
        ListaEnlazada lista1 = new ListaEnlazada();
        lista1.insertar(2);
        lista1.insertar(4);
        lista1.insertar(7);
        lista1.insertar(9);
        lista1.insertar(5);
        lista1.insertar(1);
        mostrarResultado(lista1);
        
        // Caso 2: números 3 1 4 2 2 5 1 6 repitiendo el 2
        System.out.println("\nCaso 2: Numeros 3, 1, 4, 2, 2, 5, 1, 6");
        ListaEnlazada lista2 = new ListaEnlazada();
        lista2.insertar(3);
        lista2.insertar(1);
        lista2.insertar(4);
        lista2.insertar(2);
        lista2.insertar(2);
        lista2.insertar(5);
        lista2.insertar(1);
        lista2.insertar(6);
        mostrarResultado(lista2);
        
        // Caso 3: numeros 5 5 4 3 2 1 repitiendo el 5
        System.out.println("\nCaso 3:  Numeros 5, 5, 4, 3, 2, 1");
        ListaEnlazada lista3 = new ListaEnlazada();
        lista3.insertar(5);
        lista3.insertar(5);
        lista3.insertar(4);
        lista3.insertar(3);
        lista3.insertar(2);
        lista3.insertar(1);
        mostrarResultado(lista3);
        
        // Caso 4: numeros 1 2 3 4 5 6 7 1 repitiendo el 1
        System.out.println("\nCaso 4: Numeros 1, 2, 3, 4, 5, 6, 7, 1");
        ListaEnlazada lista4 = new ListaEnlazada();
        lista4.insertar(1);
        lista4.insertar(2);
        lista4.insertar(3);
        lista4.insertar(4);
        lista4.insertar(5);
        lista4.insertar(6);
        lista4.insertar(7);
        lista4.insertar(1);
        mostrarResultado(lista4);
    }
    
    /**
     * Muestra el resultado del caso imprimiendo la lista y el primer numero que se haya repetido
     * @author Camila Alfaro Rivera
     * @param lista La lista enlazada a revisar
     */
    private static void mostrarResultado(ListaEnlazada lista) {
        System.out.print("Lista: ");
        lista.mostrar();
        
        int resultado = lista.encontrarPrimerRepetido();
        
        if (resultado == -1) {
            System.out.println("No hay numeros repetidos.");
        } else {
            System.out.println("El primer nmero repetido es: " + resultado);
        }
    }
}

/**
 * Clase Nodo que representa un elemento de la lista enlazada
 * 
 * @author Camila Alfaro Rivera
 */
class Nodo {
    private int dato;
    private Nodo siguiente;

    /**
     * Constructor de la clase Nodo
     * 
     * @param dato el valor que guardará el nodo
     * @author Camila Alfaro Rivera
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

/**
 * Clase ListaEnlazada que maneja una lista enlazada simple
 * @author Camila Alfaro Rivera
 */
class ListaEnlazada {
    private Nodo primero;

    /**
     * Constructor de la clase ListaEnlazada
     * inicia una lista vacía
     */
    public ListaEnlazada() {
        this.primero = null;
    }

    /**
     * agrega un valor al final de la lista enlazada
     * 
     * @param valor valor que se quiere insertar en la lista
     * @author Camila Alfaro Rivera
     */
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    /**
     * Muestra todos los elementos de la lista enlazada
     * @author Camila Alfaro Rivera
     */
    public void mostrar() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    /**
     * Encuentra el primer num que se repite en la lista enlazada
     * 
     * @return El primer numero repetido o -1 si no se encuentran repeticiones
     * 
     * @author Camila Alfaro Rivera
     */
    public int encontrarPrimerRepetido() {
        Nodo actual = primero;
        while (actual != null) {
            int valorActual = actual.getDato();
            Nodo comparar = actual.getSiguiente();
            while (comparar != null) {
                if (comparar.getDato() == valorActual) {
                    return valorActual;
                }
                comparar = comparar.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
        return -1;
    }
}

