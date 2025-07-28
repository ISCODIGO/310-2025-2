package org.example;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(int capacidad) {
        super(capacidad);
    }

    @Override
    protected boolean comparar(T primerElemento, T segundoElemento) {
        return primerElemento.compareTo(segundoElemento) > 0;
    }
}
