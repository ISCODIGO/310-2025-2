public interface IConjunto {
    boolean agregar(int valor);
    IConjunto union(IConjunto otro);
    IConjunto interseccion(IConjunto otro);
    IConjunto complemento(IConjunto otro);
    IConjunto diferencia(IConjunto otro);
    void imprimir();
}
