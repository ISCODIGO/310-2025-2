package org.example.listas;

import java.util.Iterator;

public class Ejercicio8_3 {
    public record Termino(int coeficiente, int exponente) { }

    public static void calcularPolinomioCuadratico(Lista<Termino> p) {
        for(double x = 0; x <= 5.0; x+= 0.5) {
            double y = 0;
            for (int i = 0; i < p.cantidad(); i++) {
                Termino t = p.getDato(i);
                y += t.coeficiente * Math.pow(x, t.exponente);
            }
            System.out.println(String.format("Y(%.1f) = %.2f", x, y));
        }
    }

    public static void calcularPolinomioLineal(ListaEnlazadaSimple<Termino> p) {
        for(double x = 0; x <= 5.0; x+= 0.5) {
            double y = 0;
            Iterator<Termino> iterator = p.iterator();
            while(iterator.hasNext()) {
                Termino t = iterator.next();
                y += t.coeficiente * Math.pow(x, t.exponente);
            }
            System.out.println(String.format("Y(%.1f) = %.2f", x, y));
        }
    }
    public static void main(String[] args) {
        ListaEnlazadaSimple<Termino> polinomio = new ListaEnlazadaSimple<>();
        polinomio.agregar(new Termino(3, 4));
        polinomio.agregar(new Termino(-4, 2));
        polinomio.agregar(new Termino(11, 0));

        calcularPolinomioLineal(polinomio);
    }
}
