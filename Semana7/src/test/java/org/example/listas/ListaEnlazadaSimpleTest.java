package org.example.listas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEnlazadaSimpleTest {

    ListaEnlazadaSimple<Integer> enlazadaSimple;

    @BeforeEach
    void setUp() {
        enlazadaSimple = new ListaEnlazadaSimple<>();
        enlazadaSimple.agregar(10);
    }

    @Test
    void testCuandoHayUnNodo() {
        Assertions.assertEquals(1, enlazadaSimple.cantidad());
        Assertions.assertEquals(10, enlazadaSimple.primero());
        Assertions.assertEquals(10, enlazadaSimple.ultimo());
    }

    @Test
    void testCuandoSeAgregaNod() {
        enlazadaSimple.agregar(20);  // 10 -> 20
        Assertions.assertEquals(2, enlazadaSimple.cantidad());
        Assertions.assertEquals(10, enlazadaSimple.primero());
        Assertions.assertEquals(20, enlazadaSimple.ultimo());

    }
}