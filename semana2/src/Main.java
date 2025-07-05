//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        byte valor = (byte)-129;
        System.out.println(valor);  // No es el valor correcto

        System.out.println(0.1 + 0.2);

        // Agregado
        int[] arregloInts = {1, 3, 5, 7, 9};

        String[] arregloStr = new String[] {"uno", "dos", "tres"};

        boolean[] arregloBools = new boolean[3];
        arregloBools[1] = true;

        int[][] arraglo2D = { {1, 2}, {1, 2, 4}, {5, 6, 7, 8}};

        int[][] matriz = { {1, 2, 3}, {4, 5, 6}};

        String s = "hola mundo";

        System.out.println(s.charAt(2));
    }

    protected class Alumno {

        public String nombre;
        public String cuenta;
        public double promedio;
        public String[] cursos;
    }


}