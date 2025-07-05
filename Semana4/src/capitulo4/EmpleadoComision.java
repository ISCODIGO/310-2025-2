package capitulo4;

public class EmpleadoComision extends Empleado{
    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        if (this.porcentajeComision > porcentajeComision) {
            return;
        }
        this.porcentajeComision = porcentajeComision;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        if (ventas < 0) {
            return;
        }
        this.ventas = ventas;
    }

    @Override
    public double getSalario() {
        return super.getSalario() + (this.ventas * this.porcentajeComision / 100.0);
    }

    private double porcentajeComision;
    private double ventas;

    public EmpleadoComision(String nombre, double salario, String cargo, String departamento, double porcentajeComision) {
        super(nombre, salario, cargo, departamento);
        this.porcentajeComision = porcentajeComision;
    }

    public String toString() {
        return super.toString() + "\n" + "EmpleadoComision{porcentajeComision=" + porcentajeComision + "}";
    }



    public static void main(String[] args) {
        EmpleadoComision empleadoComision = new EmpleadoComision(
                "Elvis Presley",
                5000,
                "Ventas SR",
                "Ventas Foraneas",
                5
        );


        System.out.println(empleadoComision);
        empleadoComision.setVentas(1_000_000);
        System.out.println(empleadoComision.getSalario());

    }
}
