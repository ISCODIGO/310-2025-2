package org.example;

import java.util.Arrays;

public class ColaArr<T> implements Cola<T> {
    private T[] arr;

    public int getFin() {
        return fin;
    }

    public int getFrente() {
        return frente;
    }

    private int fin;
    private int frente;

    public ColaArr(int capacidad) {
        arr = (T[]) new Object[capacidad];
        fin = -1;
        frente = 0;
    }

    protected int siguiente(int posicion) {
        return posicion + 1;
    }

    @Override
    public void encolar(T dato) {
        if (estaLlena()) throw new RuntimeException("Cola Llena");

        fin = siguiente(fin);
        arr[fin] = dato;
    }

    @Override
    public T desencolar() {
        T aux = frente();
        frente = siguiente(frente);
        return aux;
    }

    @Override
    public T frente() {
        if (estaVacia()) throw new RuntimeException("Cola vacia");

        return arr[frente];
    }

    @Override
    public void vaciar() {
        frente = 0;
        fin = -1;
    }

    @Override
    public boolean estaVacia() {
        return fin < frente;
    }

    public boolean estaLlena() {
        return frente == arr.length - 1;
    }

    @Override
    public String toString() {
        return String.format("%s\nFrente: %s\nFin: %s",
                Arrays.toString(arr),
                frente(),
                arr[fin]);
    }
}
