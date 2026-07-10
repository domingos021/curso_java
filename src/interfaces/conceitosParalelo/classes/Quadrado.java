package interfaces.conceitosParalelo.classes;

import interfaces.conceitosParalelo.model.FIiguraGeometrica;

public class Quadrado implements FIiguraGeometrica {
    //=> implements quer dizer: segue o contrato do:
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    @Override  //sobrescreve a interface
    public double calcularArea() {
        //return Math.pow(lado, 2);
        return lado * lado;
    }

    /*
    public double gerarArea() {
        //return Math.pow(lado, 2);
        return lado * lado;
    }

     */

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}
