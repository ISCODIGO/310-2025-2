package org.example.listas;

public class Nodo {
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public Nodo(int dato, Nodo enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                '}';
    }

    private Nodo enlace;
    private int dato;

    public static void main(String[] args) {
        Nodo n1 = new Nodo(10, null);
        Nodo n2 = new Nodo(20, n1);

        // n2 [20 | n1]
        // n1 [10 | null]
        // n2 -> n1

        n2.getEnlace().setDato(30);  // n2 modifica a n1

        System.out.println(n1);
        System.out.println(n2);

        Nodo n3 = new Nodo(50, n2);

        // n3 -> n2 -> n1

        System.out.println("Modificar n2 desde n3");
        n3.getEnlace().setDato(-2);

        System.out.println("Mostrar n2");
        System.out.println(n2);

        System.out.println("Modificar n1 desde n3");
        n3.getEnlace().getEnlace().setDato(-1);

        System.out.println("Mostrar n1");
        System.out.println(n1);

        var n4 = new Nodo(34, n3);
        // n4 -> n3 -> n2 -> n1 -> null

        Nodo aux = n4;

        System.out.println("Recorrido de los enlaces...");
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getEnlace();
        }

    }
}
