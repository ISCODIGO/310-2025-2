package org.example;

public interface Cola<T> {
    void encolar(T dato);  // colocar un dato al final de la cola
    T desencolar();  // removemos el dato del frente de la cola
    T frente();  // valor mas antiguo de la cola
    void vaciar();
    boolean estaVacia();
}
