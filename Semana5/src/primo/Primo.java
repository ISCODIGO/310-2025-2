package primo;

public class Primo {

    // O(n)
    public static boolean esPrimo(long numero) {
        long inicio = System.currentTimeMillis();
        long sentencias = 0;
        if (numero % 2 == 0) return true;  // evaluar todos los pares
        for (long i = 3; i < numero/3; i+=2) {
            sentencias++;
            if (numero % i == 0) {
                return false;
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo: " + (fin-inicio));
        System.out.println("Sentencias: " + sentencias);
        return true;
    }

    public static boolean esPrimoEficiente(long numero) {
        long inicio = System.currentTimeMillis();
        long sentencias = 0;
        for (long i = 2; i < (long) Math.sqrt(numero); i++) {
            sentencias++;
            if (numero % i == 0) {
                return false;
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo: " + (fin-inicio));
        System.out.println("Sentencias: " + sentencias);
        return true;
    }

    public static void main(String[] args) {
        boolean resultado = Primo.esPrimoEficiente(965588510483L);
        //boolean resultado = Primo.esPrimoEficiente(843472373);
        System.out.println(resultado);
    }
}
