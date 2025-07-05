package org.example.listas;

public interface Lista<T> {
    void crear();  // crear la lista inicial
    void agregar(T dato);  // colocar un elemento al final de la lista
    void insertar(int posicion, T dato);
    void remover(T dato);
    void removerPorPosicion(int posicion);
    void limpiar();  // eliminar todos los elementos de la lista
    int buscar(T dato);  // devuelve posicion del dato o -1
    void imprimir();
    boolean estaVacia();
    T primero(); // obtener el dato del primer nodo
    T ultimo();  // obtener el dato del ultimo nodo
    int cantidad();  // obtener la cantidad de nodos de la lista
}
