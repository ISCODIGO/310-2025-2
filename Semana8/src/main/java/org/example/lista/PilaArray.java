package org.example.lista;

public class PilaArray<T> implements Pila<T> {
    // atributos
    T[] arreglo;
    int cima;

    public PilaArray(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        cima = -1;
    }

    @Override
    public void apilar(T dato) {
        if (estaLleno()) {
            throw new RuntimeException("Pila llena");
        }

        arreglo[++cima] = dato;
    }

    @Override
    public T desapilar() {
        T eliminado = cima();
        cima--;
        return eliminado;
    }

    @Override
    public boolean estaVacio() {
        return cima == -1;
    }

    public boolean estaLleno() {
        return cima == this.arreglo.length - 1;
    }

    @Override
    public T cima() {
        if (estaVacio()) {
            throw new RuntimeException("Pila vacia");
        }

        return arreglo[cima];
    }

    @Override
    public void vaciar() {
        cima = -1;
    }


}
