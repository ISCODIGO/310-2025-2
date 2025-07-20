package org.example;

public class ColaPrioridad<T> {

    private Cola<T>[] prioridades;

    public ColaPrioridad(int capacidad, int capacidadPorCola) {
        prioridades = new Cola[capacidad];

        for (int i = 0; i < prioridades.length; i++) {
            prioridades[i] = new ColaArrC<>(capacidadPorCola);
        }
    }

    public void encolar(int prioridad, T dato) {
        if (prioridad < 0 || prioridad >= prioridades.length)
            throw new IllegalArgumentException("Prioridad invalida");

        prioridades[prioridad].encolar(dato);
    }

    public T desencolar() {
        for (Cola<T> cola : prioridades) {
            if (!cola.estaVacia()) {
                return cola.desencolar();
            }
        }

        throw new RuntimeException("Cola Prioritaria Vacia");
    }

    public T frente() {
        for (Cola<T> cola : prioridades) {
            if (!cola.estaVacia()) {
                return cola.frente();
            }
        }
        throw new RuntimeException("Cola Prioritaria Vacia");
    }

    public void vaciar() {
        for (Cola<T> cola : prioridades) {
            cola.vaciar();
        }
    }

    public boolean estaVacia() {
          for (Cola<T> cola : prioridades) {
                if (!cola.estaVacia()) {
                     return false;
                }
          }
          return true;
     }

    public static void main(String[] args) {
        ColaPrioridad<String> cola = new ColaPrioridad<>(3, 10);
        cola.encolar(2, "Maria");
        cola.encolar(1, "Susana");
        cola.encolar(0, "Victor");
        cola.encolar(0, "Ariana");
        cola.encolar(1, "Alberto");
        cola.encolar(2, "Juan");
        cola.encolar(1, "Roberto");
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
    }
}
