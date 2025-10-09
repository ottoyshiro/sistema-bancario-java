package com.util;

public class ContaCorrente extends Conta implements ITributavel {

    @Override
    public void sacar(double valor) {
        super.sacar(valor * 1.05);
    }

    @Override
    public void transferir(double valor, Conta destino) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public double calculaTributos() {
        return this.getSaldo()/100;
    }
}