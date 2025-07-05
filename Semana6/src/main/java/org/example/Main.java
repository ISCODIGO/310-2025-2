package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var elementos = new int[]{5, 3, 8, 2, 7, 10, 1, 6, 1_000_000};
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // F  T  T  T  F  T  T  T  T  F  T  --> almacen

        // O(n)
        int maximo = elementos[0];
        for(int i = 1; i < elementos.length; i++) {
            if (elementos[i] > maximo) {
                maximo = elementos[i];
            }
        }

        var almacen = new boolean[maximo + 1];

        // O(n)
        for(int i = 0; i < elementos.length; i++) {
            almacen[elementos[i]] = true;
        }

        var resultado = new int[elementos.length];
        // O(m)
        for(int i = 0, k = 0; i < almacen.length; i++) {
            if (almacen[i]) {
                resultado[k++] = i;
            }
        }

        // O(n+n+m) -> O(n+m)  n >= m -> O(n) // n < m -> O(m)

        System.out.println(Arrays.toString(resultado));

        // --- Pruebas para ListaEnlazadaSimple ---
        org.example.listas.ListaEnlazadaSimple<Integer> enlazadaSimple = new org.example.listas.ListaEnlazadaSimple<>();
        enlazadaSimple.agregar(10);

        // pruebas del funcionamiento de los metodos
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(10 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(20);  // 10 -> 20
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(20 == enlazadaSimple.ultimo());

        enlazadaSimple.removerPorPosicion(1);
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(10 == enlazadaSimple.primero());
        System.out.println(10 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(20);
        enlazadaSimple.removerPorPosicion(0);
        System.out.println(1 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(20 == enlazadaSimple.ultimo());

        enlazadaSimple.agregar(30);
        enlazadaSimple.agregar(40);  // 20 -> 30 -> 40
        enlazadaSimple.removerPorPosicion(1);
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(40 == enlazadaSimple.ultimo());
        System.out.println("Actual...");
        System.out.println(1 == enlazadaSimple.buscar(40));

        enlazadaSimple.agregar(50);
        // 20 -> 40 -> 50
        System.out.println(0 == enlazadaSimple.buscar(20));
        System.out.println(1 == enlazadaSimple.buscar(40));
        System.out.println(2 == enlazadaSimple.buscar(50));

        enlazadaSimple.remover(40);
        System.out.println(2 == enlazadaSimple.cantidad());
        System.out.println(20 == enlazadaSimple.primero());
        System.out.println(50 == enlazadaSimple.ultimo());
    }
}
