package com.util;

import java.util.ArrayList;
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
        sc.nextLine();
        if(tipo == 1) {
            conta = new ContaCorrente();
        } else if (tipo == 2) {
        	conta = new ContaPoupanca();
        }
        conta.setCliente(nome);
        
        return conta;
    }

    public void realizarDeposito(ArrayList<Conta> listaDeContas) {
        int numero;
        double valor;

        if (listaDeContas.size() > 0) {
            System.out.print("Insira o número da conta: ");
            numero = sc.nextInt();
            System.out.print("Insira o valor a ser depositado: ");
            valor = sc.nextDouble();
            sc.nextLine();
            if(valor > 0) {
                for (Conta conta : listaDeContas) {
                    if (conta.getNumero() == numero) {
                        conta.depositar(valor);
                        System.out.printf("Valor de R$ %.2f depositado na conta %d com sucesso!\n", valor, numero);
                        return;
                    }
                }
                System.out.println("Número da conta não existe.");
            } else {
                System.out.println("Valor precisa ser positivo.");
            }
        } else {
            System.out.println("Crie uma conta primeiro.");
        }
    }

    public void realizarSaque(ArrayList<Conta> listaDeContas) {
        int numero;
        double valor;

        if (listaDeContas.size() > 0) {
            System.out.print("Insira o número da conta: ");
            numero = sc.nextInt();
            System.out.print("Insira o valor a ser sacado: ");
            valor = sc.nextDouble();
            sc.nextLine();
            if(valor > 0) {
                for (Conta conta : listaDeContas) {
                    if (conta.getNumero() == numero) {
                        if (conta.getSaldo() >= valor * 1.05 && conta instanceof ContaCorrente cc) {
                            cc.sacar(valor);
                            System.out.printf("Valor de R$ %.2f sacado na conta %d com taxa de 5%% com sucesso!\n", valor, numero);
                        } else if (conta.getSaldo() >= valor && conta instanceof ContaPoupanca) {
                            conta.sacar(valor);
                            System.out.printf("Valor de R$ %.2f sacado na conta %d com sucesso!\n", valor, numero);
                        } else {
                            System.out.println("Valor insuficiente na conta.");
                        }
                        return;

                    }
                }
                System.out.println("Número da conta não existe.");
            } else {
                System.out.println("Valor precisa ser positivo.");
            }
        } else {
            System.out.println("Crie uma conta primeiro.");
        }
    }

    public void realizarTransferencia(ArrayList<Conta> listaDeContas) {
        int remetente, destinatario;
        double valor;

        if (listaDeContas.size() > 1) {
            System.out.print("Insira o número da conta: ");
            remetente = sc.nextInt();
            System.out.print("Insira o número da conta de destino: ");
            destinatario = sc.nextInt();
            System.out.print("Insira o valor a ser transferido: ");
            valor = sc.nextDouble();
            sc.nextLine();

            if (valor > 0) {
                for (Conta conta : listaDeContas) {
                    if (conta.getNumero() == remetente) {
                        for (Conta destino : listaDeContas) {
                            if (destino.getNumero() == destinatario) {
                                if (conta.getSaldo() >= valor * 1.05 && conta instanceof ContaCorrente cc) {
                                    cc.transferir(valor, destino);
                                    System.out.printf("A conta %d transferiu R$ %.2f para a conta %d com sucesso.\n", conta.getNumero(), valor, destino.getNumero());
                                } else if (conta.getSaldo() >= valor && conta instanceof ContaPoupanca) {
                                    conta.transferir(valor, destino);
                                    System.out.printf("A conta %d transferiu R$ %.2f para a conta %d com sucesso.\n", conta.getNumero(), valor, destino.getNumero());
                                } else {
                                    System.out.println("Valor insuficiente na conta.");
                                }
                                return;
                            }
                        }
                        System.out.println("Número da conta de destino não existe.");
                    }
                }
                System.out.println("Número da conta a transferir não existe.");
            } else {
                System.out.println("Valor precisa ser positivo.");
            }
        } else {
            System.out.println("Você precisa de pelo menos duas contas para transferir. Vá criar.");
        }
    }

    public void listarContas(ArrayList<Conta> listaDeContas) {

        if (listaDeContas.size() > 0) {
            for (Conta conta : listaDeContas) {
                System.out.println("\n========================================");
                if (conta instanceof ContaCorrente) {
                    System.out.println("Conta Corrente");
                } else {
                    System.out.println("Conta Poupança");
                }
                System.out.printf("Número da conta: %d\nNome do cliente: %s\nSaldo da conta: %.2f\n", conta.getNumero(), conta.getCliente(), conta.getSaldo());
                System.out.println("========================================");
            }
        } else {
            System.out.println("Crie uma conta primeiro.");
        }
    }

    public void calcularTotalTributos(ArrayList<Conta> listaDeContas) {

        if (listaDeContas.size() > 0) {
            double totalTributos = 0.0;
            for (Conta conta : listaDeContas) {
                if (conta instanceof ITributavel contaTributavel) {
                    totalTributos += contaTributavel.calculaTributos();
                }
            }
            System.out.println("\n========================================");
            System.out.println("Total de tributos a recolher: R$ " + totalTributos);
            System.out.println("========================================");
        } else {
            System.out.println("Crie uma conta primeiro.");
        }
    }
}