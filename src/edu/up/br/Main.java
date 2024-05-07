package edu.up.br;

import edu.up.br.restaurante.Gerenciamento;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //menu do restaurante que chama os metodos de submenus
        // pedidos, cadastros, listagem e pesquisar;
        boolean sair = true;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Bem vindo ao restaurante LUCAL!");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("O que você precisa fazer: ");
            System.out.println("1 - Pedidos");
            System.out.println("2 - Cadastros.");
            System.out.println("3 - Listagem.");
            System.out.println("4 - Pesquisar.");
            System.out.println("5 - Sair.");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Pedidos();
                    break;
                case 4:
                    Cadastros();
                    break;
                case 5:
                    Listagem();
                    break;
                case 6:
                    Pesquisar();
                    break;
                case 7:
                    System.out.println("5 - Sair.");
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!sair);


    }

    //metodo que chama os metodos de pedidos e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
    public static void Pedidos()
    {
        boolean Voltar = true;
        do{
            System.out.println("\n       Pedidos:    \n\n");
            System.out.println("1 - Cadastrar Pedido.");
            System.out.println("2 - Fechar Conta.");
            System.out.println("3 - Modificar Pedido.");
            System.out.println("4 - Cancelar Pedido.");
            System.out.println("5 - Voltar.");

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    System.out.println("1 - Cadastrar Pedido.");
                    Gerenciamento.gerenciarPedidos(opcao);
                    break;
                case 2:
                    System.out.println("2 - Fechar Conta.");
                    Gerenciamento.gerenciarPedidos(opcao);
                    break;
                case 3:
                    System.out.println("3 - Modificar Pedido.");
                    Gerenciamento.gerenciarPedidos(opcao);
                    break;
                case 4:
                    System.out.println("4 - Cancelar Pedido.");
                    Gerenciamento.gerenciarPedidos(opcao);
                    break;
                case 5:
                    System.out.println("5 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }


    //metodo que chama os metodos de cadastros e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
    public static void Cadastros()
    {
        boolean Voltar = true;
        do{
            System.out.println("\n       Cadastros:    \n\n");
            System.out.println("1 - Cadastrar Cliente.");
            System.out.println("2 - Cadastrar Funcionário.");
            System.out.println("3 - Cadastrar Pedido.");
            System.out.println("4 - Voltar.");

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao)
            {
                //? o cadastro inclui as funcoes de cadastrar, modificar ou excluir?
                //? ainda nao sei se coloco tudo aqui ou se crio um metodo para cada funcao
                //? dentro do gerenciamento com outro menu para cada um
                case 1:
                    System.out.println("1 - Cadastrar Cliente.");
                    break;
                case 2:
                    System.out.println("2 - Cadastrar Funcionário.");
                    break;
                case 3:
                    System.out.println("3 - Cadastrar Pedido.");
                    break;
                case 4:
                    System.out.println("4 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }

    //metodo que chama os metodos de listagem e manda para o gerenciamento a requisição
    //de acordo com a opção escolhida
    public static void Listagem()
    {
        boolean Voltar = true;
        do{
            //? a listagem inclui caminho para modificar o dado escolhido ou só exibir?
            //? poderia na listagem de clientes selecionar um cliente e ser jogado
            //? para um menu de modificação de dados ou exclusao de maneira direta;
            System.out.println("\n       Listagem:    \n\n");
            System.out.println("1 - Listar Clientes.");
            System.out.println("2 - Listar Funcionários.");
            System.out.println("3 - Listar Cardapio.");
            System.out.println("4 - Listar Pedidos.");
            System.out.println("5 - Listar Mesas.");
            System.out.println("6 - Voltar.");

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    System.out.println("1 - Listar Clientes.");
                    break;
                case 2:
                    System.out.println("2 - Listar Funcionários.");
                    break;
                case 3:
                    System.out.println("3 - Listar Cardapio.");
                    break;
                case 4:
                    System.out.println("4 - Listar Pedidos.");
                    break;
                case 5:
                    System.out.println("5 - Listar Mesas.");
                    break;
                case 6:
                    System.out.println("6 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }

    public static void Pesquisar()
    {
        boolean Voltar = true;
        do{
            //? a mesma coisa com a anterior, por estar pesquisando um especifico eu poderia
            //? ter a opção de modificar ou excluir o dado pesquisado;
            System.out.println("\n       Pesquisar:    \n\n");
            System.out.println("1 - Pesquisar Cliente.");
            System.out.println("2 - Pesquisar Funcionário.");
            System.out.println("3 - Pesquisar Cardapio.");
            System.out.println("4 - Pesquisar Pedido.");
            System.out.println("5 - Pesquisar Mesa.");
            System.out.println("6 - Voltar.");

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    System.out.println("1 - Pesquisar Cliente.");
                    break;
                case 2:
                    System.out.println("2 - Pesquisar Funcionário.");
                    break;
                case 3:
                    System.out.println("3 - Pesquisar Cardapio.");
                    break;
                case 4:
                    System.out.println("4 - Pesquisar Pedido.");
                    break;
                case 5:
                    System.out.println("5 - Pesquisar Mesa.");
                    break;
                case 6:
                    System.out.println("6 - Voltar.");
                    Voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (Voltar);
    }
}