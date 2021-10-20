package main.java.app;

import main.java.app.exception.ArquivoNaoEncontradoException;
import main.java.app.exception.DelimitadorInvalidoException;
import main.java.app.exception.DisposicaoInvalidaException;
import main.java.app.exception.EscritaNaoPermitidaException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Olá!\n Sr(a) usuário, informe os seguintes parâmetros: \n1) Delimitador: ");
		
		String delimiter = scan.nextLine();
		
		System.out.println("\n2) Disposição: ");
		
		String disposition = scan.nextLine();
		
		System.out.println("\n3) Caminho do arquivo para ser lido: ");
		
		String path = scan.nextLine();
		
		System.out.println("\n4) Caminho do arquivo para ser escrito: ");
		String outputPath = scan.nextLine();
		
		FileReader fileReader = new FileReader();
		
		try {
			System.out.println("\nProcessando arquivo...");
			fileReader.loadFile(path, delimiter, disposition, outputPath);
			System.out.println("\nArquivo processado com sucesso!");
		} catch (IOException e) {
			System.out.println("\nDesculpe! Erro ao processar arquivo.");
		} catch (ArquivoNaoEncontradoException e) {
			System.out.println("\nPrezado(a), o arquivo não existe!");
		} catch (DelimitadorInvalidoException e) {
			System.out.println("\nPrezado(a), o delimitador é inválido!");
		} catch (EscritaNaoPermitidaException e) {
			System.out.println("\nPrezado(a), o arquivo não permite escrita!");
		} catch (DisposicaoInvalidaException e) {
			System.out.println("\nPrezado(a), a disposição está inválida");
		}
		
	}
	
}
