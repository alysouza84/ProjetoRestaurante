package edu.up.br.restaurante;

import java.io.IOException;
import java.util.Scanner;

public class Funcionario {

    private static int count = 0;
    public int id_funcionario;
    public String nome;
    public String telefone;
    public String endereco;
    public String email;
    public String cargo;
    public String salario;

    public Funcionario(String nome, String telefone, String endereco, String email, String cargo, String salario) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public static void cadastrarFuncionario(final Scanner scanner) throws IOException {
        FileManager arquivo = new FileManager();
        arquivo.criarDiretorioGeral();
        arquivo.criarArquivoFuncionarios();

        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do funcionário: ");
        String telefone = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o endereço do funcionário: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do funcionário: ");
        String email = scanner.next();
        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.next();
        System.out.println("Digite o salário do funcionário: ");
        String salario = scanner.next();

        Funcionario funcionario = new Funcionario(nome, telefone, endereco, email, cargo, salario);

        arquivo.gravarFuncionarios(funcionario);

    }

    public void imprimirDadosFuncionarios()
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("Email: " + email);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public static void listarFuncionarios() throws IOException
    {
        FileManager arquivo = new FileManager();
        arquivo.lerFuncionarios();
    }

    public static void pesquisarFuncionario(Scanner scanner)
    {
        System.out.println("Digite o nome do funcionário que deseja buscar: ");
        String nome = scanner.next();
        FileManager.buscarFuncionario(nome);
    }

    public static void removerFuncionario(Scanner scanner)
    {
        System.out.println("Digite o nome do funcionário que deseja remover: ");
        String nome = scanner.next();
        FileManager.deletarFuncionario(nome);
    }

    public static void atualizarFuncionario(Scanner scanner) throws IOException {
        System.out.println("Digite o nome do funcionário que deseja atualizar: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do funcionário: ");
        String telefone = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o endereço do funcionário: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o email do funcionário: ");
        String email = scanner.next();
        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.next();
        System.out.println("Digite o salário do funcionário: ");
        String salario = scanner.next();

        Funcionario funcionario = new Funcionario(nome, telefone, endereco, email, cargo, salario);

        FileManager.atualizaFuncionario(funcionario);
    }

}
