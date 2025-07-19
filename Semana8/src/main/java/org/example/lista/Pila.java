package org.example.lista;

public interface Pila<T> {
    void apilar(T dato);  // insertar una nueva cima
    T desapilar();  // eliminar la cima actual
    boolean estaVacio();
    T cima();  // mostrar la cima
    void vaciar();  // elimina todos los elementos

}
