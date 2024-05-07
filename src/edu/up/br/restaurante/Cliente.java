package edu.up.br.restaurante;


import java.io.IOException;

import java.util.Scanner;

public class Cliente
{
    private static int count = 0;
    private int id_cliente;
    public String name;
    public String telefone;
    public String endereco;
    public String email;

    public Cliente(int id_cliente, String name, String telefone, String endereco, String email)
    {
        this.id_cliente = ++count;
        this.name = name;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente (String name, String telefone, String endereco, String email)
    {
        this.name = name;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public static void cadastrarCliente(final Scanner scanner) throws IOException {
        //Cria arquivo usando a classe FileManager;
        FileManager arquivo = new FileManager();

        //Verifica se o diretório e o arquivo existem, caso não existam, faz a criação dos mesmos;
        arquivo.criarDiretorioGeral();
        arquivo.criarArquivoClientes();

        //eu trouxe o scanner da main para ca, mas o metodo ser static da problema com o id;

        //Solicita ao usuário que informe os dados do cliente;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite o nome do cliente: ");
        String name = scanner.next();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.next();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.next();
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

    public static void atualizarCliente(final Scanner scanner) throws IOException {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite o nome do cliente para atualizar: ");
        String name = scanner.next();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.next();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.next();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.next();
        System.out.println();
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        Cliente cliente = new Cliente(id_cliente, name, telefone, endereco, email);

        FileManager.atualizaCliente(cliente);
    }

    //Função chamada em FileManager para imprimir os dados do cliente;
    public void imprimirDadosClientes()
    {

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("ID: " + this.id_cliente);
        System.out.println("Nome: " + this.name);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Email: " + this.email);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }
}
