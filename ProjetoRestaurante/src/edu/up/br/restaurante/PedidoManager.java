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
    private static final String FILE_NAME_PEDIDOS = "C:\\Users\\Lucas\\Documents\\GitHub\\ProjetoRestaurante\\src\\edu\\up\\br\\restaurante\\arquivos\\pedidos.txt";
    private static List<Pedido> pedidos = carregarPedidos();

    // Método para carregar os pedidos do arquivo salvando na lista pedidos
    public static void getPedidos() {
        pedidos = carregarPedidos();
    }

    // Método para adicionar um pedido na lista pedidos e salvar no arquivo
    public static void adicionarPedido(Scanner scanner)
    {
        // Carrega a lista de pedidos para evitar falta de sincronia
        getPedidos();

        //verifica se a mesa está ocupada e se ela é valida, caso não seja pede para digitar novamente
        //a parte de verificar se a mesa está ocupada está no metodo verificarMesa mas ele nao esta funcionando
        //corretamente
        int mesa;
        do {
            System.out.println("Digite a numero da mesa: ");
            mesa = scanner.nextInt();
            scanner.nextLine();
            if (mesa < 1 || mesa > 10) {
                System.out.println("Mesa inválida.");
            }
        } while (Mesa.verificarMesa(mesa));

        //cria uma lista de itens e uma lista de quantidades
        List<Cardapio> itens = new ArrayList<>();
        List <Integer> quantidades = new ArrayList<>();

        String continuar = "s";
        while(continuar.equals("s"))
        {
            //lista os itens do cardapio
            CardapioManager.listarPorID();

            //busca o item no cardapio pelo id digitado e se não encontrar exibe uma mensagem de erro
            System.out.println("Digite o id do item: ");
            int idItem = scanner.nextInt();
            scanner.nextLine();
            Cardapio item = CardapioManager.buscarItem(idItem);
            if(item == null)
            {
                System.out.println("Item não encontrado.");
                continue;
            }
            //adiciona o item na lista de itens
            itens.add(item);

            //adiciona a quantidade do item na lista de quantidades
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

        //cria um novo pedido com a mesa, os itens, as quantidades e o id do funcionario
        //adiciona o pedido na lista de pedidos e o id do pedido é gerado automaticamente
        Pedido pedido = new Pedido(mesa, itens, quantidades, idFuncionario);
        pedidos.add(pedido);
        salvarPedidos();

    }

    // Método para modificar um pedido na lista pedidos e salvar no arquivo entre 3 opcoes de modificacao
    public static void modificarPedido(final Scanner scanner)
    {
        // Carrega a lista de pedidos para evitar falta de sincronia
        getPedidos();

        // Verifica se a lista de pedidos está vazia
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para modificar.");
            return;
        }

        // Lista os pedidos
        listarPedidos();

        //pega com base no numero da mesa para fazer a edicao
        System.out.println("Digite o numero da mesa que deseja modificar: ");
        int idMesa = scanner.nextInt();
        scanner.nextLine();

        //busca o pedido pelo id da mesa e retorna o objeto dela
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
                    break;
                case 3:
                    modificarRemoverItem(scanner, pedido);
                    break;
                case 4:
                    voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }
    }

    // Método para modificar a mesa de um pedido se digitar uma mesa valida ele troca seu pedido para aquela mesa
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

    // Método para adicionar um item a um pedido
    public static void modificarAdicionarItem(Scanner scanner, Pedido pedido)
    {
        //lista os itens do cardapio pega o item pelo id e pergunta a quantidade dele e atualiza a lista de itens do pedido
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

    // Método para remover um item de um pedido se digitar um item valido ele remove o item da lista de itens do pedido
    // e da lista de quantidades
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
            //retorna o index do item na lista de itens do pedido se ele existir
            int index = pedido.getItens().indexOf(item);
            if (index == -1) {
                System.out.println("Item não encontrado no pedido.");
                continue;
            }
            //remove da lista com base no index fornecido, tanto de quantidade quanto de itens
            pedido.getItens().remove(index);
            pedido.getQuantidades().remove(index);
            salvarPedidos();
            marca = false;
        }
    }

    // Método para remover um pedido da lista pedidos e salvar no arquivo
    public static void removerPedido(Scanner scanner)
    {
        getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para remover.");
            return;
        }
        listarPedidos();

        //se o numero do pedido for valido ele busca o pedido relacionado a mesa e remove ele da lista de pedidos
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

    // Método para buscar um pedido na lista pedidos pelo id da mesa e retorna o pedido se ele existir
    // exibe os detalhes do pedido ja formatado
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

    // Método para buscar um pedido na lista pedidos pelo id do pedido e retorna o pedido se ele existir
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

    // Método para listar todos os pedidos na lista pedidos
    public static void listarPedidos() {
        getPedidos(); // Atualiza a lista de pedidos

        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos.");
            return;
        }


        for (Pedido pedido : pedidos) {
            System.out.printf("\n\n%-5s %-10s %-10s\n", "ID", "Mesa", "Funcionário");
            System.out.printf("%-5d %-10d %-10d\n",
                    pedido.getId(),
                    pedido.getMesa(),
                    pedido.getIdFuncionario()
            );

            System.out.printf("\n%-30s %-35s %-15s %-10s\n", "ID Item", "Nome Item", "Quantidade", "Preço Item");
            for (int i = 0; i < pedido.getItens().size(); i++) {
                Cardapio item = pedido.getItens().get(i);
                int quantidade = pedido.getQuantidades().get(i);
                System.out.printf("%-30d %-35s %-15d %-10.2f\n",
                        item.getId(),
                        item.getNome(),
                        quantidade,
                        item.getPreco());
            }
        }
    }

    // Método para fechar um pedido na lista pedidos e salvar no arquivo
    // exibe o total do pedido e remove o pedido da lista de pedidos
    public static void fecharConta(Scanner scanner) {
        getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para fechar.");
            return;
        }
        listarPedidos();

        System.out.println("Digite o ID do pedido que deseja fechar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = buscarPedido(idPedido);
        if(pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        double total = 0;
        for (int i = 0; i < pedido.getItens().size(); i++) {
            Cardapio item = pedido.getItens().get(i);
            int quantidade = pedido.getQuantidades().get(i);
            total += item.getPreco() * quantidade;
        }

        System.out.printf("O total do pedido %d é: %.2f\n", idPedido, total);

        pedidos.remove(pedido);
        salvarPedidos();
    }

    //salva no arquivo usando o toString do pedido
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


    //carrega os pedidos do arquivo e retorna uma lista de pedidos com os pedidos do arquivo
    //caso ocorra um erro ao ler o arquivo é exibido uma mensagem de erro
    //caso a linha do arquivo não esteja no formato correto é exibido uma mensagem de erro
    //utiliza o split para separar os itens da linha em parts
    public static List<Pedido> carregarPedidos()
    {
        List<Pedido> pedidos = new ArrayList<>();
        File file = new File(FILE_NAME_PEDIDOS);

        try(Scanner scanner = new Scanner(file))
        {
            if (!scanner.hasNextLine()) {
                System.out.println("O arquivo está vazio.");
                return pedidos;
            }

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

                if (itensString.length != quantidadesString.length) {
                    System.out.println("Número de itens e quantidades não correspondem na linha: " + line);
                    continue;
                }

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


    //metodo para pegar o maior id da lista de pedidos e retornar para ser usado no cadastro de pedidos
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




