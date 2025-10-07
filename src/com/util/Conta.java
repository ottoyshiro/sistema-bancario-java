package com.util;

import java.util.Scanner;

public abstract class Conta {
    private Scanner sc = new Scanner(System.in);
    private int numero;
    private String cliente;
    private double saldo;
    private static int count = 100;    
    
        
    public abstract void depositar();
    public abstract void sacar();
    public void transferir() {
        System.out.printf("Número da conta: %d\nNome do cliente: %s\n", this.getNumero(), this.getCliente());
        System.out.printf("Saldo atual: %.2f\n", this.getSaldo());
        double valor = sc.nextDouble();
        double saldo = getSaldo();
        if(valor > 0 || saldo > 0) {
            System.out.printf("Valor de R$ %.2f transferido com sucesso!\n", valor);
            saldo -= valor;
            setSaldo(saldo);      
        } else {
            System.out.println("Ocorreu um erro ao depositar, verifique se o valor é valido e tente novamente.");
        }
    };
        
    public Conta(String cliente, double saldo) {
        this.numero = count;
        this.addOne(); 
        this.cliente = cliente;
        this.saldo = saldo;    
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
