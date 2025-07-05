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
    }
}