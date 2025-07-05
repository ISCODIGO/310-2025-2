package recursion;

public class Fibonacci {
    public static int recursiones = 0;
    public static int recursiones2 = 0;

    public static long calcular(int posicion) {
        recursiones++;
        if (posicion == 0 || posicion == 1)
            return posicion;
        return calcular(posicion - 1) + calcular(posicion - 2);
    }

    public static long calcular(int posicion, long[] memoria) {
        recursiones2++;
        if (memoria == null) {
            memoria = new long[posicion + 1];
            memoria[0] = 0;
            memoria[1] = 1;
        }

        // Caso base: si esta memoria, retornarlo
        if (posicion < 2) {
            return posicion;
        }

        if (memoria[posicion] != 0) {
            return memoria[posicion];
        }

        // No esta calculado en la memoria
        memoria[posicion] = calcular(posicion - 1, memoria) + calcular(posicion - 2, memoria);
        return memoria[posicion];
    }

    public static void main(String[] args) {
        var v = 50;
        //System.out.println(calcular(v));
        //System.out.println("Recursiones: " + recursiones);
        //System.out.println("----------------------------");
        System.out.println(calcular(v, null));
        System.out.println("Recursiones: " + recursiones2);
    }
}
