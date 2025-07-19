package org.example.lista;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaArrayTest {

    private Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new PilaArray<>(5);
    }

    @Test
    void testPilaVacia() {
        Assertions.assertTrue(pila.estaVacio());
        Assertions.assertThrows(Exception.class, () -> {
            pila.cima();
        });
    }

    @Test
    void testApilamiento() {
        pila.apilar(10);
        Assertions.assertFalse(pila.estaVacio());
        Assertions.assertEquals(10, pila.cima());

        pila.apilar(20);
        Assertions.assertEquals(20, pila.cima());
    }

    @Test
    void testDesapilamiento() {
        pila.apilar(10);
        pila.apilar(20);

        Assertions.assertEquals(20, pila.desapilar());
        Assertions.assertEquals(10, pila.desapilar());
        Assertions.assertTrue(pila.estaVacio());
    }

    @Test
    void testUnderFlow() {
        Assertions.assertThrows(Exception.class, () -> {
            pila.desapilar();
        });
    }

    @Test
    void testOverFlow() {
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(20);

        Assertions.assertThrows(Exception.class, () -> {
            pila.apilar(0);
        });
    }

    @Test
    void testVaciado() {
        pila.apilar(10);
        pila.vaciar();

        Assertions.assertTrue(pila.estaVacio());
    }
}