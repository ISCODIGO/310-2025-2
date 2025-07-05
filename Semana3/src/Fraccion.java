public class Fraccion implements IFraccion {
    private int d;
    private int n;

    public Fraccion(int numerador, int denominador){
        this.d = denominador;
        this.n = numerador;
    }

    @Override
    public int getNumerador() {
        return n;
    }

    @Override
    public int getDenomidor() {
        return d;
    }

    @Override
    public IFraccion sumar(IFraccion otro) {
        int denonimador = this.getDenomidor() * otro.getDenomidor();
        int numerador = this.getNumerador() * otro.getDenomidor() +
                this.getDenomidor() * otro.getNumerador();

        return new Fraccion(numerador, denonimador);
    }

    @Override
    public IFraccion restar(IFraccion otro) {
        return null;
    }

    @Override
    public IFraccion multiplicar(IFraccion otro) {
        return null;
    }

    @Override
    public IFraccion dividir(IFraccion otro) {
        return null;
    }

    @Override
    public void imprimir() {
        if (n % d == 0) {
            System.out.println(n/d);
        } else {
            System.out.println(String.format("%d / %d", n, d));
        }
    }
}
