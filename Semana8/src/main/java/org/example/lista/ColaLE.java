package org.example.lista;

import java.util.LinkedList;

public class ColaLE<T> implements Cola<T> {
    private LinkedList<T> lista;

    public ColaLE() {
        lista = new LinkedList<>();
    }

    @Override
    public void encolar(T dato) {
        lista.add(dato);
    }

    @Override
    public T desencolar() {
        return lista.removeFirst();
    }

    @Override
    public T frente() {
        return lista.getFirst();
    }

    @Override
    public void vaciar() {
        lista.clear();
    }

    @Override
    public boolean estaVacia() {
        return lista.isEmpty();
    }

}
