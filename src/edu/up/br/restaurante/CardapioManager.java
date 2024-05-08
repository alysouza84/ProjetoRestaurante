package edu.up.br.restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CardapioManager
{
    //file name definidada como final para não ser alterada
    private static final String FILE_NAME = "C:\\Users\\Lucas\\Documents\\GitHub\\ProjetoRestaurante\\src\\edu\\up\\br\\restaurante\\cardapio.txt";
    //lista é sempre inicializada com os dados do arquivo caso existam;
    private static List<Cardapio> cardapios = carregarCardapios();


    public static void salvarCardapio()
    {
        //printwriter é uma classe que escreve caracteres formatados no arquivo FILE_NAME
        try(PrintWriter writer = new PrintWriter(FILE_NAME))
        {
            for (Cardapio cardapio : cardapios)
            {
                //escreve no arquivo o cardapio  no formato padrao do toString do cardapio
                writer.println(cardapio.toString());
            }
        }catch (IOException e)
        {
            //caso ocorra um erro ao salvar o arquivo é exibido uma mensagem de erro
            System.out.println("Erro ao salvar o cardápio");
        }

    }

    //meu cadastrarProduto recebe o scanner diretamente da main;
    //esta função é responsável por cadastrar um novo produto no cardapio
    //e salvar no arquivo
    public static void cadastrarProduto(final Scanner scanner)
    {
        System.out.println("Digite o nome do item:");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do item:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o tipo do item:");
        String tipo = scanner.nextLine();
        System.out.println("Digite o preço do item:");
        double preco = scanner.nextDouble();
        scanner.nextLine();//limpa o buffer

        //cria um novo objeto, novos objetos recebem um id automaticamente
        Cardapio cardapio = new Cardapio(nome, descricao, tipo, preco);
        //adiciona o objeto na lista de cardapios
        cardapios.add(cardapio);

        //salva o cardapio no arquivo usando a funcao ja feita
        salvarCardapio();
    }


    //removerProduto recebe o scanner diretamente da main;
    //esta função é responsável por remover um produto do cardapio
    //e salvar no arquivo
    public static void removerProduto(final Scanner scanner)
    {
        //utiliza um metodo para pegar o id do produto a ser removido
        int id = pegarID(scanner);
        //carrega a lista de cardapios pra evitar falta de sincronia
        getCardapios();

        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getId() == id)
            {
                //remove o cardapio da lista de cardapios atraves do id passado
                //remove com o metodo remove do arraylist
                cardapios.remove(cardapio);
                break;
            }
        }
        //salva o cardapio no arquivo usando a funcao ja feita
        salvarCardapio();
    }


    //modificarProduto recebe o scanner diretamente da main;
    //esta função é responsável por modificar um produto do cardapio
    //e salvar no arquivo
    public static void modificarProduto(final Scanner scanner)
    {
        //utiliza um metodo para pegar o id do produto a ser modificado
        int id = pegarID(scanner);

        //pesquisa o produto atraves do id para verificar se ele existe
        // e tambem mostra as informaçoes para o usuario saber o que alterar
        //retorna o objeto a ser modificado ou null caso nao exista
        Cardapio cardapio = pesquisarProdutoID(id);

        //caso o produto exista
        if (cardapio != null) {
            System.out.println("Digite o novo nome do item:");
            String nome = scanner.nextLine();
            System.out.println("Digite a nova descrição do item:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o novo tipo do item:");
            String tipo = scanner.nextLine();
            System.out.println("Digite o novo preço do item:");
            double preco = scanner.nextDouble();
            scanner.nextLine();//limpa o buffer

            //altera os dados do cardapio utilizando os metodos set
            cardapio.setNome(nome);
            cardapio.setDescricao(descricao);
            cardapio.setTipo(tipo);
            cardapio.setPreco(preco);

            salvarCardapio();

        }else{//caso o produto nao exista

            System.out.println("Item não encontrado");
        }

    }


    //listar recebe o scanner diretamente da main;
    //esta função é responsável por listar os produtos do cardapio
    //lista por ID, tipo ou nome.
    public static void listar(final Scanner scanner)
    {
        System.out.println("Como deseja listar?");
        System.out.println("1 - Listar por ID");
        System.out.println("2 - Listar por tipo");
        System.out.println("3 - Listar por nome");
        int opcao = scanner.nextInt();
        scanner.nextLine();//limpa o buffer

        switch(opcao)
        {
            case 1:
                listarPorID();
                break;
            case 2:
                listarProdutosPorTipo(scanner);
                break;
            case 3:
                listarProdutosPorNome();
                break;
            default:
                System.out.println("Opção inválida");

        }
    }


    //listarPorID é uma função auxiliar para listar os produtos por ID
    public static void listarPorID()
    {
        //carrega a lista de cardapios para evitar falta de sincronia
        getCardapios();

        //ordena a lista de cardapios por id, o sort ordena e o comparator
        //comparing compara os ids e fica retornando a menor id ate a maior id
        cardapios.sort(Comparator.comparing(Cardapio::getId));

        //limpa a tela
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        //imprime o cabeçalho da tabela do cardapio configurado por um padrao
        //de formatação a esquerda e com um tamanho fixo para cada campo
        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");

        for (Cardapio cardapio : cardapios)
        {
            System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                    cardapio.getId(),
                    cardapio.getNome(),
                    cardapio.getDescricao(),
                    cardapio.getTipo(),
                    cardapio.getPreco());
        }
    }

    //listarProdutosPorTipo recebe o scanner diretamente da main;
    //esta função é responsável por listar os produtos do cardapio por tipo
    //sejam eles quais forem
    public static void listarProdutosPorTipo(final Scanner scanner)
    {
        System.out.println("Digite o tipo do item:");
        String tipo = scanner.nextLine();
        getCardapios();//carrega a lista de cardapios para evitar falta de sincronia

        System.out.print("\033[H\033[2J\033[3J");//limpa a tela
        System.out.flush();

        //imprime o cabeçalho da tabela do cardapio configurado pelo padrao
        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");

        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getTipo().equals(tipo))
            {
                System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                        cardapio.getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getTipo(),
                        cardapio.getPreco());
            }
        }
    }

    //listarProdutosPorNome recebe o scanner diretamente da main;
    //esta função é responsável por listar os produtos do cardapio por nome
    //sejam eles quais forem
    public static void listarProdutosPorNome()
    {
        getCardapios();//carrega a lista de cardapios para evitar falta de sincronia

        cardapios.sort(Comparator.comparing(Cardapio::getNome));//ordena a lista de cardapios por nome

        System.out.print("\033[H\033[2J\033[3J");//limpa a tela
        System.out.flush();

        //imprime o cabeçalho da tabela do cardapio configurado pelo padrao
        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");

        for (Cardapio cardapio : cardapios) {
            System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                    cardapio.getId(),
                    cardapio.getNome(),
                    cardapio.getDescricao(),
                    cardapio.getTipo(),
                    cardapio.getPreco());
        }
    }


    //pesquisarProduto recebe o scanner diretamente da main;
    //esta função é responsável por pesquisar um produto do cardapio
    //seja por ID ou por nome e mostrar na tela
    public static void pesquisarProduto(final Scanner scanner)
    {
        System.out.println("Como deseja pesquisar?");
        System.out.println("1 - Pesquisar por ID");
        System.out.println("2 - Pesquisar por nome");
        int opcao = scanner.nextInt();
        scanner.nextLine();//limpa o buffer

        //utiliza um switch para escolher a opcao de pesquisa
        switch(opcao)
        {
            case 1:
                pesquisarProdutoID(scanner);
                break;
            case 2:
                pesquisarProdutoNome(scanner);
                break;
            default:
                System.out.println("Opção inválida");

        }
    }

    //pesquisarProdutoID recebe o scanner diretamente da main;
    //esta função é responsável por pesquisar um produto do cardapio por ID
    //e mostrar na tela
    public static void pesquisarProdutoID(final Scanner scanner)
    {
        int id = pegarID(scanner);//utiliza um metodo para pegar o id do produto a ser pesquisado
        getCardapios();//carrega a lista de cardapios para evitar falta de sincronia

        //imprime o cabeçalho da tabela do cardapio configurado pelo padrao
        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");

        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getId() == id)
            {
                System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                        cardapio.getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getTipo(),
                        cardapio.getPreco());
                break;
            }
        }
    }

    //pesquisarProdutoID(id) recebe um id como parametro
    //esta função é responsável por pesquisar um produto do cardapio por ID
    //mostrar na tela e retornar o objeto pesquisado
    //é uma funcao auxiliar igual a pesquisarProdutoID(scanner)
    //mas recebe um id como parametro
    public static Cardapio pesquisarProdutoID(int id)
    {

        getCardapios();//carrega a lista de cardapios para evitar falta de sincronia

        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");

        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getId() == id)
            {
                System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                        cardapio.getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getTipo(),
                        cardapio.getPreco());
                return cardapio;//retorna o objeto pesquisado
            }
        }
        return null;//retorna null caso nao encontre o objeto
    }

    //pesquisarProdutoNome recebe o scanner diretamente da main;
    //esta função é responsável por pesquisar um produto do cardapio por nome
    //e mostrar na tela
    public static void pesquisarProdutoNome(final Scanner scanner)
    {
        System.out.println("Digite o nome do item:");
        String nome = scanner.nextLine();
        getCardapios();//carrega a lista de cardapios para evitar falta de sincronia
        System.out.printf("%-5s %-30s %-45s %-15s %-10s\n", "ID", "Nome", "Descrição", "Tipo", "Preço");
        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getNome().equals(nome))
            {
                System.out.printf("%-5d %-30s %-45s %-15s %-10.2f\n",
                        cardapio.getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getTipo(),
                        cardapio.getPreco());
                break;
            }
        }
    }

    //carregarCardapios é uma função auxiliar para carregar os produtos do cardapio
    //do arquivo FILE_NAME e retornar uma lista de cardapios
    //esta função é chamada no inicio do programa para carregar os produtos
    public static List<Cardapio> carregarCardapios() {
        List<Cardapio> cardapios = new ArrayList<>(); //cria uma lista de cardapios
        File file = new File(FILE_NAME);//cria um arquivo com o nome FILE_NAME

        try (Scanner scanner = new Scanner(file)) { //cria um scanner local para ler o arquivo
            while (scanner.hasNextLine()) {//enquanto houver linhas no arquivo ele continua lendo
                String line = scanner.nextLine();// le a linha
                String[] parts = line.split(", "); // divide a linha em partes separadas pelo delimitador ", "

                int id = Integer.parseInt(parts[0].split("=")[1]);//pega o id do cardapio e converte para inteiro
                String nome = parts[1].split("'")[1];//pega o nome do cardapio
                String descricao = parts[2].split("'")[1];//pega a descricao do cardapio
                String tipo = parts[3].split("'")[1];// pega o tipo do cardapio
                //pega o preco do cardapio e converte para double
                double preco = Double.parseDouble(parts[4].split("=")[1].replace("}", ""));

                //cria um novo objeto cardapio com os dados lidos do arquivo
                //e adiciona na lista de cardapios
                Cardapio cardapio = new Cardapio(id, nome, descricao, tipo, preco);
                cardapios.add(cardapio);
            }
        } catch (FileNotFoundException e) { //caso o arquivo nao seja encontrado ele exibe uma mensagem de erro
            System.out.println("Arquivo não encontrado. Uma nova lista será criada.");
        }
        return cardapios; //retorna a lista de cardapios lidos do arquivo ou uma lista vazia caso nao exista
    }

    //getCardapios é uma função auxiliar para carregar os produtos do cardapio
    //do arquivo FILE_NAME e atribuir a lista de cardapios
    //esta função é chamada no inicio do programa para carregar os produtos
    // e é chamada sempre que for necessário atualizar a lista de cardapios
    //é utilizada para evitar falta de sincronia entre os dados
    public static void getCardapios() {
        cardapios = carregarCardapios();
    }

    //pegarID recebe o scanner diretamente da main;
    //esta função é responsável por pegar o ID do produto a ser modificado
    //foi criada pois a maior parte das funcoes necessitam do id do produto
    public static int pegarID(final Scanner scanner)
    {
        System.out.println("digite o ID do item:");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    //MaiorID é uma função auxiliar para pegar o maior id dos cardapios
    //esta funcao é utilizada para atribuir um id automaticamente para um novo cardapio
    //utilizada exclusivamente para adequar a numeracao do contador do construtor do cardapio
    public static int MaiorID()
    {
        int maior = 0;
        getCardapios();

        for (Cardapio cardapio : cardapios)
        {
            if(cardapio.getId() > maior)
            {
                maior = cardapio.getId();
            }
        }
        return maior;
    }
}
