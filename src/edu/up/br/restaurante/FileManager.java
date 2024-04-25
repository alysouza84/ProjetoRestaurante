package edu.up.br.restaurante;

import java.io.File;
import java.io.IOException;

public class FileManager
{
    String pathNAme = "C:\\Users\\alysouza\\Documents\\GitHub\\java-projects\\src\\empresa\\up\\edu\\br\\Root";

    public void criarDiretorio()
    {
        File diretorio = new File(pathNAme);
        if (!diretorio.exists())
        {
            boolean statusDir = diretorio.mkdir();
            System.out.println(statusDir);
        }
    }

    public File criarArquivo() throws IOException {
        File arquivo = new File(pathNAme, "alunos.txt");
        if (!arquivo.exists())
        {
            boolean statusArq = arquivo.createNewFile();
            System.out.println(statusArq);
        }
        return arquivo;
    }
}
