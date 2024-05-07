package edu.up.br.restaurante;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public Cliente(String cpf, String nome, String telefone, String endereco, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
}
