package edu.up.br.restaurante;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mesa {
    private static final int NUMERO_MAXIMO_MESAS = 10;
    private static final List<Mesa> mesas = new ArrayList<Mesa>();
    private static final String FILE_NAME = "C:\\Users\\Lucas\\Documents\\GitHub\\ProjetoRestaurante\\src\\edu\\up\\br\\restaurante\\mesas.txt";

    private final int NumeroMesa;
    private boolean status;//true = ocupada, false = livre
    private int idPedido; //pedido que está na mesa

    public Mesa(int NumeroMesa, boolean status, int idPedido) {
        this.NumeroMesa = NumeroMesa;
        this.status = status;
        this.idPedido = idPedido;
    }

    static {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            // Se o arquivo existir, leia o status das mesas do arquivo
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(", ");

                    int numeroMesa = Integer.parseInt(parts[0].split("=")[1]);
                    boolean status = Boolean.parseBoolean(parts[1].split("=")[1]);
                    int idPedido = Integer.parseInt(parts[2].split("=")[1]);
                    mesas.add(new Mesa(numeroMesa, status, idPedido));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao ler o arquivo de mesas.");
                e.printStackTrace();
            }
        } else {
            // Se o arquivo não existir, inicialize todas as mesas como livres
            for (int i = 0; i < NUMERO_MAXIMO_MESAS; i++) {
                mesas.add(new Mesa(i + 1, false, 0));
            }
        }
    }

    public void salvarMesa()
    {
        try (PrintWriter writer = new PrintWriter(FILE_NAME))
        {
            for (Mesa mesa : mesas) {
                writer.println(mesa.toString());
                // Escreva a linha no arquivo
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de mesas.");
            e.printStackTrace();
        }
    }

    public static boolean verificarMesa(int numeroMesa) {


        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa.isStatus();
            }
        }
        return false;
    }

    public int getNumeroMesa() {
        return NumeroMesa;
    }

    public boolean isStatus() {
        return status;
    }

    public int getPedido() {
        return idPedido;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "NumeroMesa=" + NumeroMesa +
                ", status=" + status +
                ", pedido=" + idPedido +
                '}';
    }
}
