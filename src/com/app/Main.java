package com.app;

import com.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Manager man = new Manager();
        ArrayList<Conta> listaDeContas = new ArrayList<>();
        int escolha;
        
        do {
            System.out.println("=========== Sistema Bancário ===========");
            System.out.println("[ 1 ] - Criar conta\n[ 2 ] - Realizar depósito\n[ 3 ] - Realizar saque\n[ 4 ] - Realizar transferência\n[ 5 ] - Listar contas\n[ 6 ] - Calcular total de tributos\n[ 7 ] - Sair");
            System.out.print(">>> ");
            
            escolha = sc.nextInt();
            
            switch(escolha) {
                case 1:
                    System.out.println("============= Criar Conta ==============");
                    listaDeContas.add(man.criarConta());
                    break;
                case 2:
                    System.out.println("========== Realizar Depósito ===========");
                    man.realizarDeposito(listaDeContas);
                    break;
                case 3:
                    System.out.println("============ Realizar Saque ============");
                    man.realizarSaque(listaDeContas);
                    break;
                case 4:
                    System.out.println("======== Realizar Transferência ========");
                    man.realizarTransferencia(listaDeContas);
                    break;
                case 5:
                    System.out.println("============ Listar Contas =============");
                    man.listarContas(listaDeContas);
                    break;
                case 6:
                    System.out.println("====== Calcular Total de Tributos ======");
                    man.calcularTotalTributos(listaDeContas);
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Escolha um valor entre 1 e 7.");
                    break;
            }
        } while(escolha != 7);
        sc.close();
        
    }
    
}
