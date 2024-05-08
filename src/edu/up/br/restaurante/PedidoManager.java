package edu.up.br.restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PedidoManager {
    private static final String FILE_NAME_PEDIDOS = "C:\\Users\\Lucas\\Documents\\GitHub\\ProjetoRestaurante\\src\\edu\\up\\br\\restaurante\\pedidos.txt";
    private static List<Pedido> pedidos = carregarPedidos();

    public static void getPedidos() {
        pedidos = carregarPedidos();
    }

    public static void adicionarPedido(Scanner scanner)
    {
        System.out.println("teste");
        getPedidos();
        System.out.println("teste");
        int mesa;
        do {
            System.out.println("Digite a numero da mesa: ");
            mesa = scanner.nextInt();
            scanner.nextLine();
            if (mesa < 1 || mesa > 10) {
                System.out.println("Mesa inválida.");
            }
        } while (Mesa.verificarMesa(mesa));


        List<Cardapio> itens = new ArrayList<>();
        List <Integer> quantidades = new ArrayList<>();

        String continuar = "s";
        while(continuar.equals("s"))
        {
            CardapioManager.listarPorID();

            System.out.println("Digite o id do item: ");
            int idItem = scanner.nextInt();
            scanner.nextLine();
            Cardapio item = CardapioManager.buscarItem(idItem);
            if(item == null)
            {
                System.out.println("Item não encontrado.");
                continue;
            }
            itens.add(item);

            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            quantidades.add(quantidade);

            System.out.println("Deseja adicionar mais itens? (s/n)");
            continuar = scanner.nextLine();
        }

        System.out.println("Digite o id do funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = new Pedido(mesa, itens, quantidades, idFuncionario);
        pedidos.add(pedido);
        salvarPedidos();

    }

    public static void modificarPedido(final Scanner scanner)
    {
        getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para modificar.");
            return;
        }
        listarPedidos();

        System.out.println("Digite o numero da mesa que deseja modificar: ");
        int idMesa = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = buscarMesa(idMesa);
        if(pedido == null)
        {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Digite o que gostaria de modificar: ");

        boolean voltar = true;
        while(voltar) {
            System.out.println("1 - mudar Mesa.");
            System.out.println("2 - adicionar item.");
            System.out.println("3 - remover item.");
            System.out.println("4 - voltar.");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    modificarMudarMesa(scanner, pedido);
                    break;
                case 2:
                    modificarAdicionarItem(scanner, pedido);
                case 3:
                    modificarRemoverItem(scanner, pedido);
                case 4:
                    voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }
    }

    public static void modificarMudarMesa(Scanner scanner, Pedido pedido)
    {
        int mesa;
        do {
            System.out.println("Digite a nova mesa: ");
            mesa = scanner.nextInt();
            scanner.nextLine();
            if (mesa < 1 || mesa > 10) {
                System.out.println("Mesa inválida.");
            }
        } while (Mesa.verificarMesa(mesa));
        pedido.setMesa(mesa);
        salvarPedidos();
    }

    public static void modificarAdicionarItem(Scanner scanner, Pedido pedido)
    {
        CardapioManager.listarPorID();
        boolean marca = true;

        while (marca)
        {
            System.out.println("Digite o id do item que deseja adicionar: ");
            int idItem = scanner.nextInt();
            scanner.nextLine();
            Cardapio item = CardapioManager.buscarItem(idItem);

            if (item == null) {
            System.out.println("Item não encontrado.");
            continue;
            }
            pedido.getItens().add(item);
            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            pedido.getQuantidades().add(quantidade);
            salvarPedidos();
            marca = false;
        }
    }

    public static void modificarRemoverItem(Scanner scanner, Pedido pedido)
    {
        boolean marca = true;
        while (marca)
        {
            System.out.println("Digite o id do item que deseja remover: ");
            int idItem = scanner.nextInt();
            scanner.nextLine();
            Cardapio item = CardapioManager.buscarItem(idItem);
            if (item == null) {
                System.out.println("Item não encontrado.");
                continue;
            }
            int index = pedido.getItens().indexOf(item);
            if (index == -1) {
                System.out.println("Item não encontrado no pedido.");
                continue;
            }
            pedido.getItens().remove(index);
            pedido.getQuantidades().remove(index);
            salvarPedidos();
            marca = false;
        }
    }

    public static void removerPedido(Scanner scanner)
    {
        getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para remover.");
            return;
        }
        listarPedidos();


        int idPedido;
        do {
            System.out.println("Digite o numero da mesa que deseja remover: ");
            idPedido = scanner.nextInt();
            scanner.nextLine();
            if (idPedido < 1 || idPedido > 10) {
                System.out.println("Número de mesa inválido. Por favor, insira um número entre 1 e 50.");
            }
        } while (idPedido < 1 || idPedido > 10);

        Pedido pedido = buscarPedido(idPedido);
        if(pedido == null)
        {
            System.out.println("Pedido não encontrado.");
            return;
        }

        pedidos.remove(pedido);
        salvarPedidos();
    }


    public static Pedido buscarMesa(int id)
    {
        getPedidos(); // carrega a lista de pedidos para evitar falta de sincronia

        for (Pedido pedido : pedidos)
        {
            if (pedido.getMesa() == id) { // verifica se a mesa corresponde ao ID fornecido
                System.out.printf("%-5s %-10s %-30s\n", "Mesa", "ID Funcionário", "Itens do Pedido");
                System.out.printf("%-5d\n", pedido.getMesa());

                System.out.printf("%-30s %-45s %-15s %-10s\n", "ID Item", "Nome Item", "Quantidade", "Preço Item");
                for (int i = 0; i < pedido.getItens().size(); i++) {
                    Cardapio item = pedido.getItens().get(i);
                    int quantidade = pedido.getQuantidades().get(i);
                    System.out.printf("%-30d %-45s %-15d %-10.2f\n",
                            item.getId(),
                            item.getNome(),
                            quantidade,
                            item.getPreco());
                }
                return pedido; // retorna o pedido se o ID corresponder
            }
        }
        return null; // retorna null se nenhum pedido com o ID fornecido for encontrado
    }

    public static Pedido buscarPedido(int id)
    {
        getPedidos(); // carrega a lista de pedidos para evitar falta de sincronia

        for (Pedido pedido : pedidos)
        {
            if (pedido.getId() == id) { // verifica se o ID do pedido corresponde ao ID fornecido
                System.out.printf("%-5s %-10s %-30s\n", "Mesa", "ID Funcionário", "Itens do Pedido");
                System.out.printf("%-5d\n", pedido.getMesa());

                System.out.printf("%-30s %-45s %-15s %-10s\n", "ID Item", "Nome Item", "Quantidade", "Preço Item");
                for (int i = 0; i < pedido.getItens().size(); i++) {
                    Cardapio item = pedido.getItens().get(i);
                    int quantidade = pedido.getQuantidades().get(i);
                    System.out.printf("%-30d %-45s %-15d %-10.2f\n",
                            item.getId(),
                            item.getNome(),
                            quantidade,
                            item.getPreco());
                }
                return pedido; // retorna o pedido se o ID corresponder
            }
        }
        return null; // retorna null se nenhum pedido com o ID fornecido for encontrado
    }

    public static void listarPedidos(){
        getPedidos();

        pedidos.sort(Comparator.comparing(Pedido :: getMesa));

        //limpa a tela
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        //imprime o cabeçalho da tabela do cardapio configurado por um padrao
        //de formatação a esquerda e com um tamanho fixo para cada campo
        System.out.printf("%-5s %-10s %-30s\n", "Mesa", "Valor Total", "Nome do Funcionário");

        for (Pedido pedido : pedidos)
        {
            double valorTotal = 0;
            for (int i = 0; i < pedido.getItens().size(); i++) {
                valorTotal += pedido.getItens().get(i).getPreco() * pedido.getQuantidades().get(i);
            }

            //String nomeFuncionario = buscarNomeFuncionario(pedido.getIdFuncionario()); // criar funcao para pegar nome do funcionario.

            System.out.printf("%-5d %-10.2f \n", pedido.getMesa(), valorTotal); //nomeFuncionario); %-5d %-10.2f %-30s

        }
    }

    public static void salvarPedidos()
    {
        //printwriter é uma classe que escreve caracteres formatados no arquivo FILE_NAME
        try(PrintWriter writer = new PrintWriter(FILE_NAME_PEDIDOS))
        {
            for (Pedido Pedido : pedidos)
            {
                //escreve no arquivo o cardapio  no formato padrao do toString do cardapio
                writer.println(Pedido.toString());
            }
        }catch (IOException e)
        {
            //caso ocorra um erro ao salvar o arquivo é exibido uma mensagem de erro
            System.out.println("Erro ao salvar o cardápio");
        }

    }



    public static List<Pedido> carregarPedidos()
    {
        List<Pedido> pedidos = new ArrayList<>();
        File file = new File(FILE_NAME_PEDIDOS);

        try(Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");

                if (parts.length < 5) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                int idPedido = Integer.parseInt(parts[0].split("=")[1]);
                int mesa = Integer.parseInt(parts[1].split("=")[1]);
                int idFuncionario = Integer.parseInt(parts[2].split("=")[1]);
                List<Cardapio> itens = new ArrayList<>();
                List<Integer> quantidades = new ArrayList<>();
                String[] itensString = parts[3].split("=")[1].split(";");
                String[] quantidadesString = parts[4].split("=")[1].split(";");
                for(int i = 0; i < itensString.length; i++)
                {

                    int idItem = Integer.parseInt(itensString[i].replaceAll("\\D+",""));
                    int quantidade = Integer.parseInt(quantidadesString[i].replaceAll("\\D+",""));
                    Cardapio item = CardapioManager.buscarItem(idItem);
                    if (item == null) {
                        System.out.println("Item not found: " + idItem);
                        continue;
                    }
                    itens.add(item);
                    quantidades.add(quantidade);
                }
                Pedido pedido = new Pedido(idPedido, mesa, itens, quantidades, idFuncionario);
                pedidos.add(pedido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler o arquivo de pedidos.");
            e.printStackTrace();
        }
        return pedidos;
    }

    public static int MaiorID()
    {
        int maior = 0;
        getPedidos();

        for (Pedido pedido : pedidos)
        {
            if(pedido.getId() > maior)
            {
                maior = pedido.getId();
            }
        }
        return maior;
    }
}




