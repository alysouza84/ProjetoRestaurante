//package edu.up.br.restaurante;
//
//import java.io.*;
//
//public class FileManager
//{
//    //Redefinir novo caminho de endereço para o arquivo;
//    String pathName = "C:\\Users\\alysouza\\IdeaProjects\\ProjetoRestaurante\\CadastroRestaurante";
//
//    //Criar diretório para armazenar os arquivos;
//    public void criarDiretorioGeral()
//    {
//        File diretorio = new File(pathName);
//        if (!diretorio.exists())
//        {
//            boolean statusDir = diretorio.mkdir();
//            System.out.println(statusDir);
//        }
//    }
//
//    //Criar arquivo para armazenar os clientes;
//    public File criarArquivoClientes() throws IOException {
//        File arquivo = new File(pathName, "clientes.txt");
//        if (!arquivo.exists())
//        {
//            boolean statusArq = arquivo.createNewFile();
//            System.out.println(statusArq);
//        }
//        return arquivo;
//    }
//
//    //Criar arquivo para armazenar os funcionários;
//    public File criarArquivoFuncionarios() throws IOException {
//        File arquivo = new File(pathName, "funcionarios.txt");
//        if (!arquivo.exists())
//        {
//            boolean statusArq = arquivo.createNewFile();
//            System.out.println(statusArq);
//        }
//        return arquivo;
//    }
//
//    //Ler os clientes cadastrados no arquivo na ordem: Nome, Telefone, Endereço e Email;
//    public void lerClientes(File arquivo) throws IOException {
//        String line;
//        FileReader reader = new FileReader(arquivo);
//        BufferedReader buffered = new BufferedReader(reader);
//
//        while ((line = buffered.readLine()) != null)
//        {
//            String[] dados = line.split(";");
//            var name = dados[0];
//            var telefone = dados[1];
//            var endereco = dados[2];
//            var email = dados[3];
//
//            //Instancia um novo cliente com os dados lidos do arquivo;
//            Cliente cliente = new Cliente(name, telefone, endereco, email);
//
//            //Chama a função para imprimir os dados do cliente, da classe Cliente;
//            cliente.imprimirDadosClientes();
//        }
//    }
//
//    //Grava os clientes no arquivo na ordem: Nome, Telefone, Endereço e Email;
//    public void gravarClientes(Cliente cliente) throws IOException
//    {
//        FileWriter fileWriter = new FileWriter(criarArquivoClientes(), true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.print(cliente.name);
//        printWriter.print(";");
//        printWriter.print(cliente.telefone);
//        printWriter.print(";");
//        printWriter.print(cliente.endereco);
//        printWriter.print(";");
//        printWriter.print(cliente.email);
//        printWriter.print("\n");
//        printWriter.flush();
//        printWriter.close();
//    }
//
//    public void gravarFuncionarios(Funcionario funcionario) throws IOException {
//        FileWriter fileWriter = new FileWriter(criarArquivoFuncionarios(), true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.print(funcionario.nome);
//        printWriter.print(";");
//        printWriter.print(funcionario.telefone);
//        printWriter.print(";");
//        printWriter.print(funcionario.endereco);
//        printWriter.print(";");
//        printWriter.print(funcionario.email);
//        printWriter.print(";");
//        printWriter.print(funcionario.cargo);
//        printWriter.print(";");
//        printWriter.print(funcionario.salario);
//        printWriter.print("\n");
//        printWriter.flush();
//        printWriter.close();
//    }
//
//    public void atualizaCliente(Cliente cliente) throws IOException {
//        File arquivo = new File(pathName, "clientes.txt");
//        File arquivoTemp = new File(pathName, "clientesTemp.txt");
//        FileReader reader = new FileReader(arquivo);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        FileWriter fileWriter = new FileWriter(arquivoTemp, true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] dados = line.split(";");
//            if (dados[0].equals(cliente.name)) {
//                printWriter.print(cliente.name);
//                printWriter.print(";");
//                printWriter.print(cliente.telefone);
//                printWriter.print(";");
//                printWriter.print(cliente.endereco);
//                printWriter.print(";");
//                printWriter.print(cliente.email);
//                printWriter.print("\n");
//            } else {
//                printWriter.print(dados[0]);
//                printWriter.print(";");
//                printWriter.print(dados[1]);
//                printWriter.print(";");
//                printWriter.print(dados[2]);
//                printWriter.print(";");
//                printWriter.print(dados[3]);
//                printWriter.print("\n");
//            }
//        }
//        printWriter.flush();
//        printWriter.close();
//        bufferedReader.close();
//        reader.close();
//        arquivo.delete();
//        arquivoTemp.renameTo(arquivo);
//    }
//
//    public void exlcluirCliente(Cliente cliente) throws IOException {
//        File arquivo = new File(pathName, "clientes.txt");
//        File arquivoTemp = new File(pathName, "clientesTemp.txt");
//        FileReader reader = new FileReader(arquivo);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        FileWriter fileWriter = new FileWriter(arquivoTemp, true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] dados = line.split(";");
//            if (!dados[0].equals(cliente.name)) {
//                printWriter.print(dados[0]);
//                printWriter.print(";");
//                printWriter.print(dados[1]);
//                printWriter.print(";");
//                printWriter.print(dados[2]);
//                printWriter.print(";");
//                printWriter.print(dados[3]);
//                printWriter.print("\n");
//            }
//        }
//        printWriter.flush();
//        printWriter.close();
//        bufferedReader.close();
//        reader.close();
//        arquivo.delete();
//        arquivoTemp.renameTo(arquivo);
//    }
//
//}
