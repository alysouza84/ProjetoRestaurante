package edu.up.br;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //menu do restaurante
        Boolean sair = true;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem vindo ao restaurante LUCAL!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("O que você precisa fazer: ");
            System.out.println("1 - Cadastrar/Apagar (Cliente, Funcionário, Cardápio)");
            System.out.println("2 - Fazer Reserva.");
            System.out.println("3 - Fazer Pedido.");
            System.out.println("4 - Fechar Conta de Mesa.");
            System.out.println("5 - Sair.");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("1 - Cadastrar/Apagar (Cliente, Funcionário, Cardápio)");
                    break;
                case 2:
                    System.out.println("2 - Fazer Reserva.");
                    break;
                case 3:
                    System.out.println("3 - Fazer Pedido.");
                    break;
                case 4:
                    System.out.println("4 - Fechar Conta de Mesa.");
                    break;
                case 5:
                    System.out.println("5 - Sair.");
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (sair);


    }
}