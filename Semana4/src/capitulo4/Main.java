package capitulo4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Fernando Zepeda",
                25000.345654,
                "Analista",
                "Mercadeo");

        EmpleadoHora e2 = new EmpleadoHora(
                "Juana Lainez", 5000,
                "Vendedor JR",
                "Ventas Locales",
                200
        );

        EmpleadoComision e3 = new EmpleadoComision(
                "Elvis Presley",
                5000,
                "Ventas SR",
                "Ventas Foraneas",
                5
        );

        Empleado[] empleados = {e1, e2, e3};

        e2.setHorasLaboradas(100);
        e3.setVentas(1_000_000);

        for(Empleado empleado : empleados) {
            System.out.println(empleado);
            System.out.println(empleado.getSalario());
            System.out.println("-------------------");
        }
    }
}