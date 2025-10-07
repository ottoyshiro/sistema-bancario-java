package com.util;

import java.util.Scanner;

public class ContaCorrente extends Conta implements ITributavel {
    private Scanner sc = new Scanner(System.in);
    
    public ContaCorrente(String cliente, double saldo) {
        super(cliente, saldo);
    }
        
    @Override
    public void depositar() {
        System.out.println("Depositar:");
        double valor = sc.nextDouble();
        double saldo = getSaldo();
        if(valor > 0) {
            saldo += valor;
            this.setSaldo(saldo);
            System.out.printf("Valor de R$ %.2f depositado com sucesso!\n", valor);
        } else {
            System.out.println("Ocorreu um erro ao depositar, verifique se o valor é valido e tente novamente.");
        }
        
    }
    
    @Override
    public void sacar() {
        System.out.println("Sacar");
        System.out.printf("Número da conta: %d\nNome do cliente: %s\n", this.getNumero(), this.getCliente());
        System.out.printf("Saldo atual: %.2f\n", this.getSaldo());
    }
    
    @Override
    public void calculaTributos() {
        double tributos = this.getSaldo()/100;
        System.out.println(tributos);
    }
}