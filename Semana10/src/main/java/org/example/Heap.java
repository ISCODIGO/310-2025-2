package org.example;

public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {
    private T[] arreglo;
    private int ultimoIndice;

    public Heap(int capacidad) {
        arreglo = (T[]) new Comparable[capacidad];
        ultimoIndice = -1;
    }

    private int izquierda(int padre) {
        return 2 * padre + 1;
    }

    private int derecha(int padre) {
        return 2 * padre + 2;
    }

    private int padre(int hijo) {
        return Math.ceilDiv(hijo - 2, 2);
    }

    /**
     * Indica la cantidad o la disposicion de los hijos
     * @param posicion
     * @return 0: nodo hoja, -1: hijo izquierda, 1: hijo derecha, 2: tiene ambos hijos
     */
    private int getHijos(int posicion) {
        int i = izquierda(posicion);
        int d = derecha(posicion);

        boolean hayIzquierda = i <= ultimoIndice;
        boolean hayDerecha = d <= ultimoIndice;

        if (!hayIzquierda && !hayDerecha) return 0;
        if (hayIzquierda && hayDerecha) return 2;
        return hayIzquierda ? 1 : -1;
    }

    protected abstract boolean comparar(T padre, T hijo);

    private int elegirHijo(int padre) {
        int i = izquierda(padre);
        int d = derecha(padre);

        int hijos = getHijos(padre);
        if (hijos == -1) return d;
        if (hijos == 1) return i;

        T valorIzq = arreglo[i];
        T valorDer = arreglo[d];
        return comparar(valorIzq, valorDer) ? i : d;
    }

    private void intercambiar(int i, int j) {
        T temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    /**
     * Determinar si un nodo debe intercambiar con su padre
     * @param posicion
     */
    private void subir(int posicion) {
        if (posicion == 0) return;

        int posPadre = padre(posicion);
        T padre = arreglo[posPadre];
        T hijo = arreglo[posicion];

        if (!comparar(padre, hijo)) {
            intercambiar(posPadre, posicion);
            subir(posPadre);
        }
    }

    /**
     * Determinar si un nodo debe intercambiar con uno de sus hijos
     * @param posicion
     */
    private void bajar(int posicion) {
        int cantidadHijos = getHijos(posicion);
        if (cantidadHijos == 0) return;

        int posHijo = elegirHijo(posicion);
        T padre = arreglo[posicion];
        T hijo = arreglo[posHijo];
        if (!comparar(padre, hijo)) {
            intercambiar(posicion, posHijo);
            bajar(posHijo);
        }
    }

    @Override
    public void agregar(T dato) {
        if (++ultimoIndice == arreglo.length) {
            throw new IndexOutOfBoundsException("Heap lleno");
        }
        arreglo[ultimoIndice] = dato;
        subir(ultimoIndice);
    }

    @Override
    public void vaciar() {
        ultimoIndice = -1;
    }

    @Override
    public T extraer() {
        if (ultimoIndice < 0) {
            throw new IllegalStateException("Heap vacío");
        }

        T raiz = arreglo[0];
        intercambiar(0, ultimoIndice--);
        bajar(0);
        return raiz;
    }

    @Override
    public T frente() {
        if (ultimoIndice < 0) {
            throw new IllegalStateException("Heap vacío");
        }
        return arreglo[0];
    }
}
