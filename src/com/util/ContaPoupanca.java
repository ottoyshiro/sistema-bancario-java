package com.util;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(String cliente, double saldo) {
        super(cliente, saldo);
    }
    @Override
    public void depositar() {
        System.out.println("Depositado");
    }
    
    @Override
    public void sacar() {
        System.out.println("Sacado");
    }
    
    @Override
    public void transferir() {
        System.out.println("Transferido");
    }
}