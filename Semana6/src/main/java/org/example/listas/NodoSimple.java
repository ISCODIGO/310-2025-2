package org.example.listas;

public class NodoSimple {
    public NodoSimple(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return String.valueOf(this.dato);
    }

    private int dato;

    public static void main(String[] args) {
        NodoSimple n1 = new NodoSimple(10);
        NodoSimple n2 = n1;  // n2 -> n1 (copia superficial o referencia)

        n2.setDato(20);

        System.out.println(n1);
        System.out.println(n2);
    }

}
