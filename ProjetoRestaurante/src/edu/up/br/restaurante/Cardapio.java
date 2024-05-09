package edu.up.br.restaurante;

public class Cardapio {
    private static int contador = CardapioManager.MaiorID() + 1; //inicia o contador com o maior id do arquivo + 1
    private final int id; //id é final pois não pode ser alterado
    private String nome; //nome, descricao e tipo são variáveis que podem ser alteradas
    private String descricao;
    private String tipo;
    private double preco; //preço é double pois pode ser um valor com casas decimais

    //contrutor 1 é usado para criar um novo item no cardapio com um id gerado automaticamente
    public Cardapio(String nome, String descricao, String tipo, double preco) {
        this.id = contador++; // id é incrementado a cada novo item usando o contador inicializado com o maior id do arquivo
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    //construtor 2 é usado para criar um item com um id específico
    //como o caso em que o arquivo é lido e os itens são criados com os ids que já possuem
    public Cardapio(int id, String nome, String descricao, String tipo, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //método toString é usado para imprimir o objeto de forma legível
    //é chamado para imprimir o cardápio no arquivo de forma padaronizada
    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
