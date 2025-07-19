package org.example.lista;

import java.util.LinkedList;

/*
Para este ejemplo la cima sera el primer nodo.
 */
public class PilaLE<T> implements Pila<T> {
    private LinkedList<T> lista;

    public PilaLE() {
        lista = new LinkedList<>();
    }

    @Override
    public void apilar(T dato) {
        lista.addFirst(dato);
    }

    @Override
    public T desapilar() {
        return lista.removeFirst();
    }

    @Override
    public boolean estaVacio() {
        return lista.isEmpty();
    }

    @Override
    public T cima() {
        return lista.getFirst();
    }

    @Override
    public void vaciar() {
        lista.clear();
    }
}
