package org.example.listas;

public class ListaEnlazadaSimple<T> implements Lista<T> {
    static class Nodo<T> {
        T dato;
        Nodo<T> sig;

        public Nodo(T dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    // atributos
    private int cantidad;
    private Nodo<T> primero;
    private Nodo<T> ultimo;

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

    private void crearPrimerNodo(Nodo<T> nodo) {
        primero = nodo;
        ultimo = nodo;
    }

    @Override
    // Nuevo método para agregar cualquier tipo de dato
    public void agregar(T dato) {
        var nuevo = new Nodo<>(dato);
        if (this.estaVacia()) {
            crearPrimerNodo(nuevo);
        } else {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        cantidad++;
    }

    @Override
    // Nuevo método para insertar cualquier tipo de dato
    public void insertar(int posicion, T dato) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException();
        }
        var nuevo = new Nodo<>(dato);
        if (posicion == 0) {
            nuevo.sig = primero;
            primero = nuevo;
            if (cantidad == 0) {
                ultimo = nuevo;
            }
        } else if (posicion == cantidad) {
            if (ultimo != null) {
                ultimo.sig = nuevo;
            }
            ultimo = nuevo;
            if (cantidad == 0) {
                primero = nuevo;
            }
        } else {
            Nodo<T> previo = get(posicion - 1);
            nuevo.sig = previo.sig;
            previo.sig = nuevo;
        }
        cantidad++;
    }

    @Override
    // Nuevo método para remover cualquier tipo de dato
    public void remover(T dato) {
        if (estaVacia()) return;

        Nodo<T> actual = primero;
        Nodo<T> previo = null;
        int pos = 0;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                if (previo == null) {
                    removerPrimero();
                } else if (actual == ultimo) {
                    removerUltimo();
                } else {
                    previo.sig = actual.sig;
                    cantidad--;
                }
                return;
            }
            previo = actual;
            actual = actual.sig;
            pos++;
        }
    }

    private void removerPrimero() {
        if (primero != null) {
            primero = primero.sig;
            cantidad--;
            if (primero == null) {
                ultimo = null;
            }
        }
    }

    private void removerUltimo() {
        if (primero == null) return;
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
            cantidad = 0;
            return;
        }
        Nodo<T> aux = primero;
        while (aux.sig != ultimo) {
            aux = aux.sig;
        }
        ultimo = aux;
        aux.sig = null;
        cantidad--;
    }

    private Nodo<T> get(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> aux = primero;
        int p = 0;
        while (p < posicion) {
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
        } else if (posicion == 0) {
            removerPrimero();
        } else if (posicion == cantidad - 1) {
            removerUltimo();
        } else {
            Nodo<T> previo = get(posicion - 1);
            previo.sig = previo.sig.sig;
            cantidad--;
        }
    }

    // O(1)
    @Override
    public void limpiar() {
        crear();
    }

    @Override
    // Nuevo método para buscar cualquier tipo de dato
    public int buscar(T dato) {
        int indice = 0;
        for (Nodo<T> aux = primero; aux != null; aux = aux.sig, indice++) {
            if (aux.dato.equals(dato)) {
                return indice;
            }
        }
        return -1;
    }

    @Override
    public void imprimir() {
        Nodo<T> aux = primero;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.sig != null) sb.append(" -> ");
            aux = aux.sig;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public T primero() {
        if (primero == null) throw new IllegalStateException("Lista vacía");
        return primero.dato;
    }

    @Override
    public T ultimo() {
        if (ultimo == null) throw new IllegalStateException("Lista vacía");
        return ultimo.dato;
    }

    @Override
    public int cantidad() {
        return this.cantidad;
    }
}
