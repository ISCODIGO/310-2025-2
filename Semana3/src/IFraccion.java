public interface IFraccion {
    int getNumerador();
    int getDenomidor();

    IFraccion sumar(IFraccion a);
    IFraccion restar(IFraccion a);
    IFraccion multiplicar(IFraccion a);
    IFraccion dividir(IFraccion a);
    void imprimir();
}
