package org.example.listas;

public interface Lista {
    void crear();  // crear la lista inicial
    void agregar(int dato);  // colocar un elemento al final de la lista
    void insertar(int posicion, int dato);
    void remover(int dato);
    void removerPorPosicion(int posicion);
    void limpiar();  // eliminar todos los elementos de la lista
    int buscar(int dato);  // devuelve posicion del dato o -1
    void imprimir();
    boolean estaVacia();
    int primero(); // obtener el dato del primer nodo
    int ultimo();  // obtener el dato del ultimo nodo
    int cantidad();  // obtener la cantidad de nodos de la lista
}
