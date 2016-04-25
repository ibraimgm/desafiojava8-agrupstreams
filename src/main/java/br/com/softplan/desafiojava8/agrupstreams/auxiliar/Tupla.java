package br.com.softplan.desafiojava8.agrupstreams.auxiliar;

public final class Tupla<A, B> {
    private A a;
    private B b;

    public Tupla(A a, B b) {
        super();
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return getA() + ": " + getB();
    }


}
