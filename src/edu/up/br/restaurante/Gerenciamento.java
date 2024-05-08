//package edu.up.br.restaurante;
//
//import java.io.IOException;
//
//import java.util.Scanner;
//
//public class Gerenciamento {
//    //EM MODIFICACAO GERALLLLLLL!!!!!
//}
//    public static void gerenciarPedidos(final Scanner scanner, int opcao) {
//        switch (opcao) {
//            case 1:
//                Pedidos.cadastrarPedido(scanner);
//                break;
//            case 2:
//                Pedidos.fecharConta();
//                break;
//            case 3:
//                Pedidos.modificarPedido();
//                break;
//            case 4:
//                Pedidos.cancelarPedido();
//                break;
//            case 5:
//                Pedidos.listarPedidos();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//        }
//    }
//
//    public static void gerenciarClientes(final Scanner scanner, int opcao) throws IOException {
//        switch(opcao){
//            case 1:
//                Cliente.cadastrarCliente(scanner);
//                break;
//            case 2:
//                Clientes.removerCliente();
//                break;
//            case 3:
//                Clientes.modificarCliente();
//                break;
//            case 4:
//                Clientes.listarClientes();
//                break;
//            case 5:
//                Clientes.pesquisarCliente();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//        }
//
//
//    }
//
//    public static void gerenciarFuncionarios(final Scanner scanner, int opcao) throws IOException {
//        switch (opcao) {
//            case 1:
//                Funcionario.cadastrarFuncionario(scanner);
//                break;
//            case 2:
//                Funcionario.removerFuncionario();
//                break;
//            case 3:
//                Funcionario.modificarFuncionario();
//                break;
//            case 4:
//                Funcionario.listarFuncionarios();
//                break;
//            case 5:
//                Funcionario.pesquisarFuncionario();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//        }
//    }
//
//    public static void gerenciarCardapio(final Scanner scanner, int opcao) {
//        switch (opcao) {
//            case 1:
//                Cardapio.cadastrarProduto(scanner);
//                break;
//            case 2:
//                Cardapio.removerProduto();
//                break;
//            case 3:
//                Cardapio.modificarProduto();
//                break;
//            case 4:
//                Cardapio.listarProdutos();
//                break;
//            case 5:
//                Cardapio.pesquisarProduto();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//        }
//    }
//
//    public static void gerenciarListagem(int opcao) {
//        switch (opcao){
//            case 1:
//                cardapio.listarPedidos();
//                break;
//            case 2:
//                cardapio.listarClientes();
//                break;
//            case 3:
//                cardapio.listarFuncionarios();
//                break;
//            case 4:
//                cardapio.listarCardapio();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//        }
//
//    }
//
//    public static void gerenciarPesquisa(int opcao) {
//        switch (opcao){
//            case 1:
//                cardapio.pesquisarPedido();
//                break;
//            case 2:
//                cardapio.pesquisarCliente();
//                break;
//            case 3:
//                cardapio.pesquisarFuncionario();
//                break;
//            case 4:
//                cardapio.pesquisarProduto();
//                break;
//            default:
//                System.out.println("Erro desconhecido.");
//                break;
//
//    }
//}
