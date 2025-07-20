package org.example;

public class ColaArrC<T> extends ColaArr<T> {
    private int capacidad;
    public ColaArrC(int capacidad) {
        super(capacidad);
        this.capacidad = capacidad;
    }

    @Override
    protected int siguiente(int posicion) {
        return (posicion + 1) % this.capacidad;
    }

    @Override
    public boolean estaVacia() {
        return getFrente() == siguiente(getFin());
    }

    @Override
    public boolean estaLlena() {
        return getFrente() == siguiente(siguiente(getFin()));
    }
}
