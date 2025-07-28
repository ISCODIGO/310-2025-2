package org.example;

public interface IHeap<T extends Comparable<T>> {
    void agregar(T dato);
    void vaciar();
    T extraer();
    T frente();
}
