package org.example.listas;

public class ListaEnlazadaSimple implements Lista {
    class Nodo {
        int dato;
        Nodo sig;

        public Nodo(int dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    // atributos
    private int cantidad;
    private Nodo primero;
    private Nodo ultimo;

    public ListaEnlazadaSimple() {
        crear();
    }

    // O(1)
    @Override
    public void crear() {
        cantidad = 0;
        primero = null;
        ultimo = null;
    }

    private void crearPrimerNodo(Nodo nodo) {
        primero = nodo;
        ultimo = nodo;
    }

    @Override
    public void agregar(int dato) {
        // Agregar el nodo al final de la lista
        var nuevo = new Nodo(dato);
        if (this.estaVacia()) {
            crearPrimerNodo(nuevo);
        }
        else {
           ultimo.sig = nuevo;
           ultimo = nuevo;
        }
        cantidad++;
    }

    @Override
    public void insertar(int posicion, int dato) {
        if (this.estaVacia()) {
            // se debe crear el primer nodo
        }
    }

    @Override
    public void remover(int dato) {
        // obtener la posicion
        int posicion = buscar(dato);  // O(n)
        removerPorPosicion(posicion);  // O(n)

    }

    private void removerPrimero() {
        primero = primero.sig;
    }

    private void removerUltimo() {
        Nodo aux = primero;

        while (aux.sig != ultimo) {
            aux = aux.sig;
        }

        ultimo = aux;
        aux.sig = null;
    }

    private Nodo get(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException();
        }

        Nodo aux = primero;
        int p = 0;
        while(p < posicion) {
            p++;
            aux = aux.sig;
        }

        return aux;
    }

    @Override
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException();
        }

        if (cantidad == 1) {
            limpiar();
        } else{
            if (posicion == 0) {
                removerPrimero();
            } else if (posicion == cantidad - 1) {
                removerUltimo();
            } else {
                // Encontrar el previo
                Nodo previo = get(posicion - 1);
                previo.sig = previo.sig.sig;
            }
            cantidad--;
        }
    }

    // O(1)
    @Override
    public void limpiar() {
        crear();
    }

    @Override
    public int buscar(int dato) {
        if (dato == ultimo.dato) {
            return cantidad - 1;
        }

        int indice = 0;
        for(Nodo aux = primero; aux != ultimo; aux = aux.sig, indice++) {
            if (aux.dato == dato) {
                 return indice;
            }
        }

        return -1;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public int primero() {
        return this.primero.dato;
    }

    @Override
    public int ultimo() {
        return this.ultimo.dato;
    }

    @Override
    public int cantidad() {
        return this.cantidad;
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple enlazadaSimple = new ListaEnlazadaSimple();
        enlazadaSimple.agregar(10);

        // pruebas del funcionamiento de los metodos
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(10 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(20);  // 10 -> 20
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(20 == enlazadaSimple.ultimo());

        enlazadaSimple.removerPorPosicion(1);
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(10 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(20);
        enlazadaSimple.removerPorPosicion(0);
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(20 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(30);
        enlazadaSimple.agregar(40);  // 20 -> 30 -> 40
        enlazadaSimple.removerPorPosicion(1);
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(40 == enlazadaSimple.ultimo());
        System.out.println(40 == enlazadaSimple.primero.sig.dato);

        enlazadaSimple.agregar(50);
        // 20 -> 40 -> 50
        System.out.println(0 == enlazadaSimple.buscar(20));
        System.out.println(1 == enlazadaSimple.buscar(40));
        System.out.println(2 == enlazadaSimple.buscar(50));

        System.out.println("Actual...");
        enlazadaSimple.remover(40);
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(50 == enlazadaSimple.ultimo());
    }
}
