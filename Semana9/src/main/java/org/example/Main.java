package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new ColaArrC<>(5);
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        cola.desencolar();
        cola.desencolar();
        cola.desencolar();
        cola.encolar(40);
        cola.encolar(50);
        cola.encolar(60);
        cola.encolar(70);
        cola.desencolar();
        cola.encolar(80);
        cola.desencolar();
        cola.encolar(90);
        System.out.println(cola);
    }
}