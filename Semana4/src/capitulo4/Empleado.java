package capitulo4;

import java.text.DecimalFormat;
import java.time.LocalDate;



public class Empleado {
    /*
     atributos -> datos
     metodos -> funciones {construir objetos, lectura de atributos, escritura de atributos}
     --------------
     Clase -> plantilla que fabrica objeto
     Objeto -> producto/instancia de una clase
     --------------
     Estado -> valor actual de un atributo
     Identidad -> diferenciar objetos
     --------------
     static -> pertenencia a la clase
     por defecto los elementos pertenecen al objeto
     --------------
     Pilares de la Programación Orientada a Objetos
     1. Abstracción: la realidad se puede abstraer. Se puede indicar el nivel de detalle de acuerdo
     al problema.
     2. Encapsulamiento: visualización de los datos (nivel de ocultamiento).
        - private: propio objeto (en el caso de los atributos, todos deben ser privados).
        - protected: propio objeto, dentro del package, dentro de subclase
        - default: propio objeto, dentro del package, dentro de subclase
        - public: propio objeto, dentro del package, fuera del package (funciones principales), dentro de subclase.
     3. Herencia: reutilizar código.
     4. Polimorfismo: identificar en tiempo de compilacion y/o ejecución la estructura idónea.

     */

    public Empleado(String nombre, double salario, String cargo, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;

        // Valores calculados
        this.incrementarSecuencia();
        this.codigo = String.valueOf(Empleado.secuencia);
        this.fechaIngreso = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    public Empleado() {
        this("Prueba", 0, "", "");
    }

    public void incrementarSecuencia() {
        Empleado.secuencia++;
    }

    public double getSalario() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(salario));
    }

    public void setSalario(double salario) {
        // no se puede reducir el salario
        if (this.salario > salario) {
            return;
        }

        // no se puede incrementar el doble
        if (salario / this.salario > 2.0) {
            return;
        }

        this.salario = salario;
    }

    private double salario;
    String nombre;  // ocultamiento default
    public LocalDate fechaIngreso;
    protected String cargo;
    private String departamento;
    private String codigo;

    private static int secuencia;



    public static void main(String[] args) {
        /*Empleado empleado = new Empleado();  //  los 4 atributos son accesibles
        Empleado.secuencia = 10;

        empleado.incrementarSecuencia();

        System.out.println(Empleado.secuencia);

        Empleado otro = new Empleado();
        otro.incrementarSecuencia();

        System.out.println(Empleado.secuencia);*/

        Empleado e1 = new Empleado();
        System.out.println(e1);

        Empleado e2 = new Empleado("Fernando Zepeda", 25000.345654, "Analista", "Mercadeo");
        System.out.println(e2);
        e2.setSalario(10_000);  // intento de reduccion
        e2.setSalario(100_000); // intento de aumento fuera de rango

        System.out.println(e2.getSalario());



    }



}
