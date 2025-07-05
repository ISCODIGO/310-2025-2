package capitulo5;

public class Recursion1 {
    public static void f(int contador) {
        System.out.println("F..." + contador);
        if (contador < 100) {  // caso base
            f(++contador);  // case recursivo
        }

        // caso recursivo -> caso base
    }

    public static void main(String[] args) {
        f(0);
    }
}
