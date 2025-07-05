import java.lang.foreign.StructLayout;

/**
 * Numeros naturales entre 0 y 100
 */
public class Conjunto100 implements IConjunto {
    public static int CAPACIDAD = 100;
    private boolean[] datos;

    public Conjunto100() {
        datos = new boolean[CAPACIDAD + 1];
    }

    @Override
    public boolean agregar(int valor) {
        // Validar que valor este en el rango
        if (valor < 0 || valor > CAPACIDAD) {
            return false;
        }

        if (datos[valor]) {
            // El valor ya estaba ingresado
            return false;
        }

        // El valor no existia en el conjunto
        datos[valor] = true;
        return true;
    }

    @Override
    public IConjunto union(IConjunto otro) {
        Conjunto100 nuevo = new Conjunto100();
        Conjunto100 cOtro = (Conjunto100) otro;

        for (int i = 0; i < nuevo.datos.length; i++) {
            if (this.datos[i] || cOtro.datos[i]) {
                nuevo.agregar(i);
            }
        }
        return nuevo;
    }

    @Override
    public IConjunto interseccion(IConjunto otro) {
        Conjunto100 nuevo = new Conjunto100();
        Conjunto100 cOtro = (Conjunto100) otro;

        for (int i = 0; i < nuevo.datos.length; i++) {
            if (this.datos[i] && cOtro.datos[i]) {
                nuevo.agregar(i);
            }
        }
        return nuevo;
    }

    @Override
    public IConjunto complemento(IConjunto otro) {
        return null;
    }

    @Override
    public IConjunto diferencia(IConjunto otro) {
        return null;
    }

    @Override
    public void imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < CAPACIDAD; i++) {
            if (this.datos[i]) {
                sb.append(i);
                sb.append(", ");
            }
        }
        sb.append("}");

        System.out.println(sb.toString());
    }

}
