package com.app;

import com.util.*;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Manager man = new Manager();
        int escolha;
        
        do {
            System.out.println("========== Sistema Bancário ==========");
            System.out.println("[ 1 ] - Criar conta\n[ 2 ] - Realizar depósito\n[ 3 ] - Realizar saque\n[ 4 ] - Realizar transferência\n[ 5 ] - Listar contas\n[ 6 ] - Calcular total de tributos\n[ 7 ] - Sair");
            System.out.print(">>> ");
            
            escolha = sc.nextInt();
            
            switch(escolha) {
                case 1:
                    System.out.println("============= Criar Conta =============");
                    ContaCorrente cc = (ContaCorrente) man.criarConta();
                    cc.calculaTributos();
                    break;
                case 2:
                    System.out.println("========== Realizar Depósito ==========");
                    break;
                case 3:
                    System.out.println("============ Realizar Saque ===========");
                    break;
                case 4:
                    System.out.println("======== Realizar Transferência =======");
                    break;
                case 5:
                    System.out.println("============ Listar Contas ============");
                    break;
                case 6:
                    System.out.println("====== Calcular Total de Tributos =====");
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
