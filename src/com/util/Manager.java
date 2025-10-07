package com.util;

import java.util.Scanner;

public class Manager {
    private Scanner sc = new Scanner(System.in);
    
    public Conta criarConta() {
        String nome;
        int tipo;
        Conta conta = null;
        System.out.print("Digite o seu nome: ");
        nome = sc.nextLine();
        
        System.out.println("Qual tipo de conta deseja criar?");
        System.out.println("[ 1 ] - Conta Corrente\n[ 2 ] - Conta Poupança");
        System.out.print(">>> ");
        tipo = sc.nextInt();
        
        if(tipo == 1) {
        	Conta contaCorrente = new ContaCorrente(nome, 0);
        	conta = contaCorrente;
        } else if (tipo == 2) {
        	Conta contaPoupanca = new ContaPoupanca(nome, 0);
        	conta = contaPoupanca;
        }
        
        return conta;
    }
}