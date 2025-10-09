package com.util;

import java.util.Scanner;

public abstract class Conta {
    private Scanner sc = new Scanner(System.in);
    private int numero;
    private String cliente;
    private double saldo;
    private static int count = 101;

    public Conta() {
        this.numero = count;
        this.addOne();
    }
        
    public void depositar(double valor) {
        this.setSaldo(getSaldo() + valor);
    }

    public void sacar(double valor) {
        this.setSaldo(getSaldo() - valor);
    };

    public void transferir(double valor, Conta destino) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void addOne() {
        count++;
    }    
        
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
        
    public int getNumero() {
        return this.numero;
    }
        
    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
