package org.example.lista;

import java.util.Scanner;

/*

Verificar si una expresion (string) es valido segun la
constitucion de sus parentesis.

Ejemplo:
(2+3) * (3 / (3-1)) -> Valido
(2+3( * ) -> Invalido
(2+3) + 4) -> Invalido
 */
public class Parentesis {
    public static boolean esValido(String exp) {
        Pila<Character> caracteres = new PilaArray<>(exp.length());

        for(int i = 0; i < exp.length(); i++) {
            char caracter = exp.charAt(i);
            if (caracter == '(') {
                caracteres.apilar(caracter);
            }

            if (caracter == ')') {
                try {
                    caracteres.desapilar();
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return caracteres.estaVacio();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expresion = scanner.nextLine();

        System.out.println(esValido(expresion));

    }
}
