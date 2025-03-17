/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package paquete1.ClaseEdades;
/**
 * Programa que almacena edades de alumnos y cuenta cuántos tienen la misma
 * edad.
 *
 * @author Camila Alfaro Rivera
 */
public class Main {

    public static void main(String[] args) {
        //se crea la lista doblemente enlazada
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        //edades
        lista.insertarOrdenado(6);
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(12);
        lista.insertarOrdenado(9);
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(12);
        lista.insertarOrdenado(12);
        lista.insertarOrdenado(6);

        //muestra cuántos alumnos tienen cada edad
        lista.mostrarFrecuenciaEdades();
    }
}

/**
 * Clase Nodo la cual representa un nodo de una lista doblemente enlazada Cada
 * uno guarda o almacna una edad y cuantos alumnos tienen esa edad
 *
 * @author Camila Alfaro Rivera
 */
class Nodo {

    int edad;
    int cantidad; // Cantidad de alumnos con la misma edad
    Nodo siguiente, anterior;

    /**
     * Constructor del nodo.
     *
     * @param edad Edad del alumno.
     */
    public Nodo(int edad) {
        this.edad = edad;
        this.cantidad = 1; // Se inicializa en 1 porque es el primer alumno con esta edad
        this.siguiente = null;
        this.anterior = null;
    }
}

/**
 * Clase de la lista doblemente enlazada hace posible poder insertar edades y
 * contar cuantos alumnos tienen la misma edad.
 *
 * @author Camila Alfaro Rivera
 */
class ListaDoblementeEnlazada {

    private Nodo cabeza;

    /**
     * Constructor de la lista doble enlazada
     *
     */
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
    }

    /**
     * agrega un nuevo nodo con la edad dada en la posicion ordenada dentro de
     * la lista pero si la edad ya existe solo le suma a el contador en lugar de
     * crear un nuevo nodo
     *
     * @param edad Edad del alumno a agregar
     */
    public void insertarOrdenado(int edad) {
        Nodo nuevo = new Nodo(edad);

        // Caso 1:lista esta vacia
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        // Caso 2:antes del primer nodo
        if (edad < cabeza.edad) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
            return;
        }

        //busca la posicion ordenada para agregar o sumar cant si ya existe
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.edad <= edad) {
            actual = actual.siguiente;
        }

        //si ya existe, solo aumentamos la cantidad y terminamos
        if (actual.edad == edad) {
            actual.cantidad++;
            return;
        }

        //agrega en la posicion correcta
        nuevo.siguiente = actual.siguiente;
        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevo;
        }
        actual.siguiente = nuevo;
        nuevo.anterior = actual;
    }

    /**
     * Muestra cuantos alumnos tienen cada edad en la lista
     */
    public void mostrarFrecuenciaEdades() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Edad: " + actual.edad + ", Cantidad de alumnos: " + actual.cantidad);
            actual = actual.siguiente;
        }
    }

}

/**profe intenté de cualquier cantidad de formas, con scanner, con buffereader y con las edades ya establecidas
 * y de ninguna forma me lo corría en omega, creo que era un error de memoria pero investigué y es por hacerlo con listas:c
 */
