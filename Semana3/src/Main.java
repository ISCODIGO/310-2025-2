//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Fraccion f = new Fraccion(3, 4);
        f.imprimir();

        Fraccion g = new Fraccion(4, 5);

        Fraccion s = (Fraccion) f.sumar(g);
        s.imprimir();*/

        Conjunto100 c1 = new Conjunto100();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.imprimir();

        Conjunto100 c2 = new Conjunto100();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.imprimir();

        var c3 = c1.union(c2);
        c3.imprimir();

        var c4 = c1.interseccion(c2);
        c4.imprimir();

        String s1 = "beer";
        String s3 = "bee";

        s3 = s3 + "r";

        System.out.println(s1 == s3);
    }
}