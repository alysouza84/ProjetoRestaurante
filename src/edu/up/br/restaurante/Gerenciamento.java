package edu.up.br.restaurante;

public class Gerenciamento {
    public static void gerenciarPedidos(int opcao) {
        switch (opcao) {
            case 1:
                Pedidos.cadastrarPedido();
                break;
            case 2:
                Pedidos.fecharConta();
                break;
            case 3:
                Pedidos.modificarPedido();
                break;
            case 4:
                Pedidos.cancelarPedido();
                break;
            default:
                System.out.println("Erro desconhecido.");
                break;
        }
    }

    public static void gerenciarCardastros() {

    }

    public static void gerenciarListagem() {

    }

    public static void gerenciarPesquisa() {

    }
}
