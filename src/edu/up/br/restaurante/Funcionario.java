package edu.up.br.restaurante;

public class Funcionario {

    private static int count = 0;
    private int id_funcionario;
    private String nome;
    private String cargo;

    public Funcionario(int id_funcionario, String nome, String cargo)
    {
        this.id_funcionario = ++count;
        this.nome = nome;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void cadastrarFuncionario()
    {
        System.out.println();


    }
}
