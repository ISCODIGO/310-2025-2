package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxHeapTest {
    Heap<Integer> monticulo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        monticulo = new MaxHeap<>(10);
    }

    @Test
    void testInsercion() {
        monticulo.agregar(10);
        Assertions.assertEquals(10, monticulo.frente());

        monticulo.agregar(55);
        Assertions.assertEquals(55, monticulo.frente());

        monticulo.agregar(22);
        Assertions.assertEquals(55, monticulo.frente());
    }

    @Test
    void testExtraccion() {
        monticulo.agregar(10);
        monticulo.agregar(2);
        monticulo.agregar(20);
        monticulo.agregar(5);

        Assertions.assertEquals(20, monticulo.extraer());
        Assertions.assertEquals(10, monticulo.extraer());
        Assertions.assertEquals(5, monticulo.extraer());
    }
}