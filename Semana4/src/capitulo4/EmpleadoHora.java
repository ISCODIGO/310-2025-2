package capitulo4;

public class EmpleadoHora extends Empleado{
    /*
    Herencia
    class A extends B
        - clase A se le llama: subclase, clase derivada, clase especializada
        - clase B: superclase, clase base, clase generalizada
     */

    public final int HORAS_MAXIMAS_MENSUALES =  12*7*4;

    public int getHorasLaboradas() {
        return horasLaboradas;
    }

    public void setHorasLaboradas(int horasLaboradas) {
        if (horasLaboradas < 0) {
            return;
        }

        if (horasLaboradas > HORAS_MAXIMAS_MENSUALES) {
            return;
        }

        this.horasLaboradas = horasLaboradas;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
        if (this.costoHora > costoHora) {
            return;
        }

        this.costoHora = costoHora;
    }

    @Override
    public double getSalario() {
        return super.getSalario() + this.costoHora * this.horasLaboradas;
    }

    @Override
    public String toString() {
//        return "EmpleadoHora{" +
//                "nombre='" + nombre + '\'' +
//                ", cargo='" + cargo + '\'' +
//                ", costoHora=" + costoHora +
//                '}';

        return super.toString() + "\n" + "EmpleadoHora{costoHora=" + costoHora + "}";
    }

    private int horasLaboradas;
    private double costoHora;

    public EmpleadoHora(String nombre, double salario, String cargo, String departamento, double costoHora) {
        super(nombre, salario, cargo, departamento);
        this.costoHora = costoHora;
        this.horasLaboradas = 0;
    }



    public static void main(String[] args) {
        EmpleadoHora empleadoHora = new EmpleadoHora(
                "Juana Lainez", 5000,
                "Vendedor JR",
                "Ventas Locales",
                200
        );
        System.out.println(empleadoHora);

        empleadoHora.setHorasLaboradas(100);
        System.out.println(empleadoHora.getSalario());
    }
}
