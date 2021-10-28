package main.java.app;

import main.java.app.exception.ArquivoNaoEncontradoException;
import main.java.app.exception.DelimitadorInvalidoException;
import main.java.app.exception.DisposicaoInvalidaException;
import main.java.app.exception.EscritaNaoPermitidaException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ArquivoNaoEncontradoException,
                                                  DelimitadorInvalidoException,
                                                  EscritaNaoPermitidaException,
                                                  DisposicaoInvalidaException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Olá!\n Sr(a) usuário, informe os seguintes parâmetros: \n1) Delimitador: ");

        final String delimiter = scan.nextLine();

        System.out.println("\n2) Disposição: ");
        final String disposition = scan.nextLine();

        System.out.println("\n3) Caminho do arquivo para ser lido: ");
        final String path = scan.nextLine();

        System.out.println("\n4) Caminho do arquivo para ser escrito: ");
        final String outputPath = scan.nextLine();

        Persistencia persistencia = new Persistencia();

        try {
            System.out.println("\nProcessando arquivo...");
            persistencia.loadFile(path, delimiter, disposition, outputPath);
            System.out.println("\nArquivo processado com sucesso!");
        } catch (IOException e) {
            System.out.println("\nDesculpe! Erro ao processar arquivo.");
        }

    }

}
