package edu.up.br.restaurante;


import java.io.IOException;

import java.util.Scanner;

public class Cliente
{
    private static int idCount = 0;
    private static int id_cliente;
    public static String name;
    public static String telefone;
    public static String endereco;
    public static String email;

    public Cliente(int id_cliente, String name, String telefone, String endereco, String email)
    {
        this.id_cliente = ++idCount;
        this.name = name;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente (String name, String telefone, String endereco, String email)
    {
        this.id_cliente = ++idCount;
        this.name = name;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public static void setIdCount(int idCount) {
        Cliente.idCount = idCount;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void cadastrarCliente(final Scanner scanner) throws IOException
    {
        //Cria arquivo usando a classe FileManager;
        FileManager arquivo = new FileManager();

        //Verifica se o diretório e o arquivo existem, caso não existam, faz a criação dos mesmos;
        arquivo.criarDiretorioGeral();
        arquivo.criarArquivoClientes();

        //eu trouxe o scanner da main para ca, mas o metodo ser static da problema com o id;
        scanner.nextLine();
        //Solicita ao usuário que informe os dados do cliente;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.next();
        System.out.println();
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        //Instancia um novo cliente com os dados informados;
        Cliente cliente = new Cliente(name, telefone, endereco, email);

        //Grava os dados do cliente no arquivo;
        arquivo.gravarClientes(cliente);

    }

//    public static void atualizarCliente(final Scanner scanner) throws IOException {
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//        System.out.println("Digite o nome do cliente para atualizar: ");
//        String name = scanner.next();
//        System.out.println("Digite o telefone do cliente: ");
//        String telefone = scanner.next();
//        System.out.println("Digite o endereço do cliente: ");
//        String endereco = scanner.next();
//        System.out.println("Digite o email do cliente: ");
//        String email = scanner.next();
//        System.out.println();
//        System.out.println("Cliente cadastrado com sucesso!");
//        System.out.println();
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//
//        Cliente cliente = new Cliente( name, telefone, endereco, email);
//
//        FileManager.atualizaCliente(cliente);
//    }

    public static void  atualizarCliente(final Scanner scanner) throws IOException
    {
        System.out.println("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.next();

        Cliente cliente = new Cliente(id, name, telefone, endereco, email);
        FileManager.atualizaCliente(cliente);

    }

    //Função chamada em FileManager para imprimir os dados do cliente;
    public static void imprimirDadosClientes()
    {

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("ID: " + id_cliente);
        System.out.println("Nome: " + name);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("Email: " + email);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }

    public static void deletarCliente(final Scanner scanner) throws IOException {
        System.out.println("Digite o nome do cliente que deseja deletar: ");
        String name = scanner.next();
        FileManager.deletarCliente(name);
    }

    public static void buscarCliente(final Scanner scanner) throws IOException {
        System.out.println("Digite o nome do cliente que deseja buscar: ");
        String name = scanner.next();
        FileManager.buscarCliente(name);
    }

    public static void listarClientes() throws IOException
    {
        FileManager arquivo = new FileManager();
        arquivo.lerClientes();
    }


}

