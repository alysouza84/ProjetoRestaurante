package edu.up.br;

//import edu.up.br.restaurante.Cliente;
import edu.up.br.restaurante.CardapioManager;
//import edu.up.br.restaurante.FileManager;
//import edu.up.br.restaurante.Funcionario;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    //metodo geral do scanner, o final impede que seja alterado e que seja acessado por outra classe
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        //menu do restaurante que chama os metodos de submenus
        // pedidos, cadastros, listagem e pesquisar;
        boolean sair = true;

        while(sair){
            System.out.print("\033[H\033[2J\033[3J");
            System.out.flush();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem vindo ao restaurante LUCAL!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("O que você precisa fazer: ");
            System.out.println("1 - Pedidos");
            System.out.println("2 - Clientes.");
            System.out.println("3 - Funcionários.");
            System.out.println("4 - Cardapio");
            System.out.println("5 - Listagem.");
            System.out.println("6 - Pesquisar.");
            System.out.println("7 - Sair.");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            int opcao = scanner.nextInt();

            switch (opcao) {
//                case 1:
//                    Pedidos();
//                    break;
//                case 2:
//                    Clientes();
//                    break;
//                case 3:
//                    Funcionarios();
//                    break;
                case 4:
                    Cardapios();
                    break;
//                case 5:
//                    Listagem();
//                    break;
//                case 6:
//                    Pesquisar();
//                    break;
                case 7:
                    System.out.println("7 - Sair.");
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();

    }

    //metodo que chama os metodos de pedidos e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
   /* public static void Pedidos() throws IOException {
        boolean Voltar = true;
        do{
            System.out.print("\033[H\033[2J\033[3J");
            System.out.flush();
            System.out.println("\n       Pedidos:    \n\n");
            System.out.println("1 - Cadastrar Pedido.");
            System.out.println("2 - Fechar Conta.");
            System.out.println("3 - Modificar Pedido.");
            System.out.println("4 - Cancelar Pedido.");
            System.out.println("5 - Listar Pedidos.");
            System.out.println("6 - Voltar.");

            int opcao = scanner.nextInt();

            switch (opcao)
//            {
//                case 1:
//                    Pedidos.cadastrarPedido(scanner);
//                    break;
//                case 2:
//                    Pedidos.fecharConta();
//                    break;
//                case 3:
//                    Pedidos.modificarPedido();
//                    break;
//                case 4:
//                    Pedidos.cancelarPedido();
//                    break;
//                case 5:
//                    Pedidos.listarPedidos();
//                    break;
//                case 6:
//                    Voltar = false;
//                    break;
//                default:
//                    System.out.println("Opção inválida.");
//            }
//        } while (Voltar);
    }*/


    //metodo que chama os metodos de cadastros e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
    /*public static void Clientes() throws IOException {
        boolean Voltar = true;
        do{
            System.out.print("\033[H\033[2J\033[3J");
            System.out.flush();
            System.out.println("\n       Cadastros:    \n\n");
            System.out.println("1 - Cadastrar Cliente.");
            System.out.println("2 - Atualizar cliente.");
            System.out.println("3 - Excluir Cliente.");
            System.out.println("4 - Listar clientes");
            System.out.println("5 - Pesquisar Cliente.");
            System.out.println("6 - Voltar.");

            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    Cliente.cadastrarCliente(scanner);
                    break;
                case 2:
                    Cliente.atualizarCliente(scanner);
                    break;
                case 3:
                    Clientes.removerCliente();
                    break;
                case 4:
                    Clientes.listarClientes();
                    break;
                case 5:
                    Clientes.pesquisarCliente();
                case 6:
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }*/

    /*public static void Funcionarios() throws IOException {
        boolean Voltar = true;
        do{
            System.out.print("\033[H\033[2J\033[3J");
            System.out.flush();
            System.out.println("\n       Cadastros:    \n\n");
            System.out.println("1 - Cadastrar Funcionario.");
            System.out.println("2 - Atualizar Funcionario.");
            System.out.println("3 - Excluir Funcionario.");
            System.out.println("4 - Listar Funcionarios.");
            System.out.println("5 - Voltar.");

            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    Funcionario.cadastrarFuncionario(scanner);
                    break;
                case 2:
                    Funcionario.removerFuncionario();
                    break;
                case 3:
                    Funcionario.modificarFuncionario();
                    break;
                case 4:
                    Funcionario.listarFuncionarios();
                    break;
                case 5:
                    Funcionario.pesquisarFuncionario();
                    break;
                case 6:
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }*/


    //todas as chamadas sao feita para cardapioManager
    public static void Cardapios(){
        boolean Voltar = true;
        while(Voltar){
            System.out.print("\033[H\033[2J\033[3J"); // codigo ANSI e "limpar" tela no terminal
            System.out.flush();
            System.out.println("\n       Cardapio:    \n\n");
            System.out.println("1 - Cadastrar Prato.");
            System.out.println("2 - Atualizar Prato.");
            System.out.println("3 - Excluir Prato.");
            System.out.println("4 - Listar Pratos.");
            System.out.println("5 - Pesquisar Prato.");
            System.out.println("6 - Voltar.");

            int opcao = scanner.nextInt();
            scanner.nextLine();//limpar buffer

            switch (opcao)
            {
                case 1:
                    CardapioManager.cadastrarProduto(scanner);
                    break;
                case 2:
                    CardapioManager.modificarProduto(scanner);
                    break;
                case 3:
                    CardapioManager.removerProduto(scanner);
                    break;
                case 4:
                    CardapioManager.listar(scanner);
                    break;
                case 5:
                    CardapioManager.pesquisarProduto(scanner);
                    break;
                case 6:
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    //metodo que chama os metodos de listagem e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
    /*public static void Listagem()
    {
        boolean Voltar = true;
        do{
            System.out.println("\n       Listagem:    \n\n");
            System.out.println("1 - Listar Pedidos.");
            System.out.println("2 - Listar Clientes.");
            System.out.println("3 - Listar Funcionarios.");
            System.out.println("4 - Listar Cardapio.");
            System.out.println("5 - Listar Mesas.");
            System.out.println("6 - Voltar.");

            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    Pedido.listarPedidos();
                    break;
                case 2:
                    Cliente.listarClientes();
                    break;
                case 3:
                    Funcionario.listarFuncionarios();
                    break;
                case 4:
                    cardapio.listarCardapio();
                    break;
                case 5:
                    cardapio.listarMesas();
                    break;
                case 6:
                    System.out.println("6 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }*/

    /*public static void Pesquisar()
    {
        boolean Voltar = true;
        do{
            System.out.println("\n       Pesquisar:    \n\n");
            System.out.println("1 - Pesquisar Cliente.");
            System.out.println("2 - Pesquisar Funcionário.");
            System.out.println("3 - Pesquisar Cardapio.");
            System.out.println("4 - Pesquisar Pedido.");
            System.out.println("5 - Pesquisar Mesa.");
            System.out.println("6 - Voltar.");

            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    cardapio.pesquisarPedido();
                    break;
                case 2:
                    cardapio.pesquisarCliente();
                    break;
                case 3:
                    cardapio.pesquisarFuncionario();
                    break;
                case 4:
                    cardapio.pesquisarProduto();
                    break;
                case 5:
                    System.out.println("5 - Pesquisar Mesa."); // sera?
                    break;
                case 6:
                    System.out.println("6 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }*/
}