package org.example;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(int capacidad) {
        super(capacidad);
    }

    @Override
    protected boolean comparar(T primerElemento, T segundoElemento) {
        return primerElemento.compareTo(segundoElemento) <= 0;
    }
}
