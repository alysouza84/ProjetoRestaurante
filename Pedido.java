package edu.up.br.restaurante;

import java.util.List;

public class Pedido {
    private static int contadorPedidos = PedidoManager.MaiorID() + 1;//fazer o contador receber o maior id
    private int idPedido;
    private int mesa;
    private List<Cardapio> itens;
    private List<Integer> quantidades;
    private int idFuncionario;

    public Pedido(int idPedido, int mesa, List<Cardapio> itens, List<Integer> quantidades, int idFuncionario) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.itens = itens;
        this.quantidades = quantidades;
        this.idFuncionario = idFuncionario;
    }

    public Pedido(int mesa, List<Cardapio> itens, List<Integer> quantidades, int idFuncionario) {
        this.idPedido = contadorPedidos;
        this.mesa = mesa;
        this.itens = itens;
        this.quantidades = quantidades;
        this.idFuncionario = idFuncionario;
    }

    public int getId() {
        return idPedido;
    }

    public List<Cardapio> getItens() {
        return itens;
    }

    public int getMesa() {
        return mesa;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public void setItens(List<Cardapio> itens) {
        this.itens = itens;
    }

    public void setQuantidades(List<Integer> quantidades) {
        this.quantidades = quantidades;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void adicionarItem(Cardapio item, int quantidade){
        this.itens.add(item);
        this.quantidades.add(quantidade);
    }

    public void removerItem(Cardapio item){
        int index = this.itens.indexOf(item);
        this.itens.remove(index);
        this.quantidades.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder itensString = new StringBuilder();
        for (Cardapio item : itens) {
            itensString.append(item.getId()).append(";");
        }
        // Remove the trailing semicolon
        if (!itensString.isEmpty()) {
            itensString.setLength(itensString.length() - 1);
        }

        StringBuilder quantidadesString = new StringBuilder();
        for (Integer quantidade : quantidades) {
            quantidadesString.append(quantidade).append(";");
        }
        // Remove the trailing semicolon
        if (!quantidadesString.isEmpty()) {
            quantidadesString.setLength(quantidadesString.length() - 1);
        }

        return "Pedido{idPedido=" + idPedido +
                ", mesa=" + mesa +
                ", idFuncionario=" + idFuncionario +
                ", itens=" + itensString.toString() +
                ", quantidades=" + quantidadesString.toString() +
                '}';
    }
}
