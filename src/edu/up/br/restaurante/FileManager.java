package edu.up.br.restaurante;

import java.io.*;

public class FileManager {
    //Redefinir novo caminho de endereço para o arquivo;
    private static final String pathName = "C:\\Users\\alysouza\\IdeaProjects\\ProjetoRestaurante\\CadastroRestaurante";

    //Criar diretório para armazenar os arquivos;
    public void criarDiretorioGeral() {
        File diretorio = new File(pathName);
        if (!diretorio.exists()) {
            boolean statusDir = diretorio.mkdir();
            System.out.println(statusDir);
        }
    }

    //Criar arquivo para armazenar os clientes;
    public File criarArquivoClientes() throws IOException {
        File arquivo = new File(pathName, "clientes.txt");
        if (!arquivo.exists()) {
            boolean statusArq = arquivo.createNewFile();
            System.out.println(statusArq);
        }
        return arquivo;
    }

    //Criar arquivo para armazenar os funcionários;
    public File criarArquivoFuncionarios() throws IOException {
        File arquivo = new File(pathName, "funcionarios.txt");
        if (!arquivo.exists()) {
            boolean statusArq = arquivo.createNewFile();
            System.out.println(statusArq);
        }
        return arquivo;
    }

    //Deleta o cliente do arquivo a partir do ID.
    public static void deletarCliente(String id) {
        File arquivo = new File(pathName, "clientes.txt");
        File arquivoTemp = new File(pathName, "clientesTemp.txt");
        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter fileWriter = new FileWriter(arquivoTemp, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dados = line.split(";");
                if (!dados[0].equals(id)) { // compare with id instead of name
                    for (String dado : dados) {
                        printWriter.print(dado);
                        printWriter.print(";");
                    }
                    printWriter.print("\n");
                }
            }
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
            reader.close();
            arquivo.delete();
            arquivoTemp.renameTo(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//  public static void deletarCliente(String id) {
//        File arquivo = new File(pathName, "clientes.txt");
//        File arquivoTemp = new File(pathName, "clientesTemp.txt");
//        try {
//            FileReader reader = new FileReader(arquivo);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            FileWriter fileWriter = new FileWriter(arquivoTemp, true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] dados = line.split(";");
//                if (!dados[0].equals(id)) { // compara IDs
//                    printWriter.print(dados[0]);
//                    printWriter.print(";");
//                    printWriter.print(dados[1]);
//                    printWriter.print(";");
//                    printWriter.print(dados[2]);
//                    printWriter.print(";");
//                    printWriter.print(dados[3]);
//                    printWriter.print(";");
//                    printWriter.print(dados[4]);
//                    printWriter.print("\n");
//                }
//            }
//            printWriter.flush();
//            printWriter.close();
//            bufferedReader.close();
//            reader.close();
//            arquivo.delete();
//            arquivoTemp.renameTo(arquivo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //Busca o cliente no arquivo a partir do nome.
    public static void buscarCliente(String name) {
        File arquivo = new File(pathName, "clientes.txt");
        boolean clienteEncontrado = false; // Flag para checar se o cliente foi encontrado.
        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dados = line.split(";");
                if (dados[1].equals(name)) {
                    clienteEncontrado = true; // flag para cliente encontrado.
                    System.out.println("Nome: " + dados[1]);
                    System.out.println("Telefone: " + dados[2]);
                    System.out.println("Endereço: " + dados[3]);
                    System.out.println("Email: " + dados[4]);
                }
            }
            if (!clienteEncontrado) { // Se a flag for falsa, print a mensagem
                System.out.println("cliente não encontrado"); // print a mensagem
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ler os clientes cadastrados no arquivo na ordem: ID, Nome, Telefone, Endereço e Email;
    public static void lerClientes() throws IOException {
        File arquivo = new File(pathName, "clientes.txt");
        FileReader reader = new FileReader(arquivo);
        BufferedReader buffered = new BufferedReader(reader);
        String line;

        if (arquivo.length() == 0) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }

        while ((line = buffered.readLine()) != null) {
            String[] dados = line.split(";");
            var id_cliente = Integer.parseInt(dados[0]);
            var name = dados[1];
            var telefone = String.valueOf(dados[2]);
            var endereco = String.valueOf(dados[3]);
            var email = String.valueOf(dados[4]);

            //Instancia um novo cliente com os dados lidos do arquivo;
            Cliente cliente = new Cliente(name, telefone, endereco, email);
            Cliente.setIdCount(id_cliente); // seta o id do cliente.

            //Chama a função para imprimir os dados do cliente, da classe Cliente;
            Cliente.imprimirDadosClientes();
        }
    }

    //Grava os clientes no arquivo na ordem: Nome, Telefone, Endereço e Email;
    public void gravarClientes(Cliente cliente) throws IOException {
        FileWriter fileWriter = new FileWriter(criarArquivoClientes(), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(cliente.getId_cliente());
        printWriter.print(";");
        printWriter.print(cliente.name);
        printWriter.print(";");
        printWriter.print(cliente.telefone);
        printWriter.print(";");
        printWriter.print(cliente.endereco);
        printWriter.print(";");
        printWriter.print(cliente.email);
        printWriter.print("\n");
        printWriter.flush();
        printWriter.close();
    }

    //Atualiza os dados do cliente no arquivo a partir do ID.
    public static void atualizaCliente(Cliente cliente) throws IOException {
        File arquivo = new File(pathName, "clientes.txt");
        File arquivoTemp = new File(pathName, "clientesTemp.txt");
        FileReader reader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(reader);
        FileWriter fileWriter = new FileWriter(arquivoTemp, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] dados = line.split(";");
            if (dados[0].equals(String.valueOf(cliente.getId_cliente()))) {
                printWriter.print(cliente.getId_cliente());
                printWriter.print(";");
                printWriter.print(cliente.getName());
                printWriter.print(";");
                printWriter.print(cliente.getTelefone());
                printWriter.print(";");
                printWriter.print(cliente.getEndereco());
                printWriter.print(";");
                printWriter.print(cliente.getEmail());
                printWriter.print("\n");
            } else {
                for (String dado : dados) {
                    printWriter.print(dado);
                    printWriter.print(";");
                }
                printWriter.print("\n");
            }
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
        reader.close();
        arquivo.delete();
        arquivoTemp.renameTo(arquivo);
    }

    public void gravarFuncionarios(Funcionario funcionario) throws IOException {
        FileWriter fileWriter = new FileWriter(criarArquivoFuncionarios(), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(funcionario.nome);
        printWriter.print(";");
        printWriter.print(funcionario.telefone);
        printWriter.print(";");
        printWriter.print(funcionario.endereco);
        printWriter.print(";");
        printWriter.print(funcionario.email);
        printWriter.print(";");
        printWriter.print(funcionario.cargo);
        printWriter.print(";");
        printWriter.print(funcionario.salario);
        printWriter.print("\n");
        printWriter.flush();
        printWriter.close();
    }

    //Ler os funcionários cadastrados no arquivo na ordem: Nome, Telefone, Endereço, Email, Cargo e Salário;
    public static void lerFuncionarios() throws IOException {
        File arquivo = new File(pathName, "funcionarios.txt");
        FileReader reader = new FileReader(arquivo);
        BufferedReader buffered = new BufferedReader(reader);
        String line;

        if (arquivo.length() == 0) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        while ((line = buffered.readLine()) != null) {
            String[] dados = line.split(";");
            var name = dados[0];
            var telefone = String.valueOf(dados[1]);
            var endereco = String.valueOf(dados[2]);
            var email = String.valueOf(dados[3]);
            var cargo = String.valueOf(dados[4]);
            var salario = String.valueOf(dados[5]);

            //Instancia um novo funcionário com os dados lidos do arquivo;
            Funcionario funcionario = new Funcionario(name, telefone, endereco, email, cargo, salario);

            //Chama a função para imprimir os dados do funcionário, da classe Funcionario;
            funcionario.imprimirDadosFuncionarios();
        }
    }

    //Busca o funcionário no arquivo a partir do nome.
    public static void buscarFuncionario(String nome) {
        File arquivo = new File(pathName, "funcionarios.txt");
        boolean funcionarioEncontrado = false; // Flag para checar se o funcionário foi encontrado.
        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dados = line.split(";");
                if (dados[0].equals(nome)) {
                    funcionarioEncontrado = true; // flag para funcionário encontrado.
                    System.out.println("Nome: " + dados[0]);
                    System.out.println("Telefone: " + dados[1]);
                    System.out.println("Endereço: " + dados[2]);
                    System.out.println("Email: " + dados[3]);
                    System.out.println("Cargo: " + dados[4]);
                    System.out.println("Salário: " + dados[5]);
                }
            }
            if (!funcionarioEncontrado) { // Se a flag for falsa, print a mensagem
                System.out.println("Funcionário não encontrado"); // print a mensagem
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Deleta o funcionário do arquivo a partir do nome.
    public static void deletarFuncionario(String nome)
    {
        File arquivo = new File(pathName, "funcionarios.txt");
        File arquivoTemp = new File(pathName, "funcionariosTemp.txt");
        boolean funcionarioDeletado = false; // Flag para verificar se o funcionário foi achado e deletado.
        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter fileWriter = new FileWriter(arquivoTemp, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dados = line.split(";");
                if (!dados[0].equals(nome))
                {
                    for (String dado : dados) {
                        printWriter.print(dado);
                        printWriter.print(";");
                    }
                    printWriter.print("\n");
                } else {
                    funcionarioDeletado = true; // Funcionario achado e deletado;
                }
            }
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
            reader.close();
            arquivo.delete();
            arquivoTemp.renameTo(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!funcionarioDeletado) { // Se a flag for falsa, a mensagem é pintada na tela.
            System.out.println("O funcionário não pôde ser deletado, pois não foi encontrado"); // print the message
        }
    }

    //Atualiza os dados do funcionário no arquivo a partir do nome.
    public static void atualizaFuncionario(Funcionario funcionario) throws IOException {
        File arquivo = new File(pathName, "funcionarios.txt");
        File arquivoTemp = new File(pathName, "funcionariosTemp.txt");
        FileReader reader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(reader);
        FileWriter fileWriter = new FileWriter(arquivoTemp, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] dados = line.split(";");
            if (dados[0].equals(funcionario.getNome())) {
                printWriter.print(funcionario.getNome());
                printWriter.print(";");
                printWriter.print(funcionario.getTelefone());
                printWriter.print(";");
                printWriter.print(funcionario.getEndereco());
                printWriter.print(";");
                printWriter.print(funcionario.getEmail());
                printWriter.print(";");
                printWriter.print(funcionario.getCargo());
                printWriter.print(";");
                printWriter.print(funcionario.getSalario());
                printWriter.print("\n");
            } else {
                for (String dado : dados) {
                    printWriter.print(dado);
                    printWriter.print(";");
                }
                printWriter.print("\n");
            }
        }
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
        reader.close();
        arquivo.delete();
        arquivoTemp.renameTo(arquivo);
    }

}