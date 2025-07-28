package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinHeapTest {
    Heap<Integer> monticulo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        monticulo = new MinHeap<>(10);
    }

    @Test
    void testInsercion() {
        monticulo.agregar(10);
        Assertions.assertEquals(10, monticulo.frente());

        monticulo.agregar(5);
        Assertions.assertEquals(5, monticulo.frente());

        monticulo.agregar(2);
        Assertions.assertEquals(2, monticulo.frente());

        monticulo.agregar(3);
        Assertions.assertEquals(2, monticulo.frente());
    }

    @Test
    void testExtraccion() {
        monticulo.agregar(10);
        monticulo.agregar(2);
        monticulo.agregar(20);
        monticulo.agregar(5);

        Assertions.assertEquals(2, monticulo.extraer());
        Assertions.assertEquals(5, monticulo.extraer());
        Assertions.assertEquals(10, monticulo.extraer());
    }
}