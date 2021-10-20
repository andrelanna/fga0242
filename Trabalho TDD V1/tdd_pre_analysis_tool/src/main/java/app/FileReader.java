package main.java.app;

import main.java.app.exception.ArquivoNaoEncontradoException;
import main.java.app.exception.DelimitadorInvalidoException;
import main.java.app.exception.DisposicaoInvalidaException;
import main.java.app.exception.EscritaNaoPermitidaException;

import java.io.*;

public class FileReader {
	
	public void loadFile(final String path, final String delimiter, final String disposition,
	                     final String outputPath) throws IOException,
	                                                     ArquivoNaoEncontradoException,
	                                                     DelimitadorInvalidoException,
	                                                     EscritaNaoPermitidaException, DisposicaoInvalidaException {
		File file = new File(path);
		
		//verify if file exists
		if (!file.exists()) {
			throw new ArquivoNaoEncontradoException("File not found on path: " + path);
		}
		
		//verify delimiter length
		if (delimiter.length() > 1) {
			throw new DelimitadorInvalidoException("Delimiter should not have more than 1 character: " + delimiter);
		}
		
		if (disposition.isEmpty()
		    || (!disposition.equalsIgnoreCase("colunas")
		        && !disposition.equalsIgnoreCase("linhas"))) {
			
			throw new DisposicaoInvalidaException(
							"Invalid disposition: " + disposition + ". It should be 'linhas' or 'colunas'");
		}
		
		//verify if file is writable
		File outputFile = new File(outputPath);
		outputFile.createNewFile();
		
		if (!outputFile.canWrite()) {
			throw new EscritaNaoPermitidaException("File not writable on path: " + path);
		}
		
		String st;
		String evolution;
		
		int counter = 1;
		
		BufferedReader br = new BufferedReader(new java.io.FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, false));
		
		if ("linhas".equalsIgnoreCase(disposition)) {
			while ((st = br.readLine()) != null) {
				
				if (!st.contains("-")) {
					writer.append(delimiter);
					writer.append(st);
				} else {
					final String pattern = "[^0-9]";
					final String emptyReplacement = "";
					
					if (counter > 1 && st.contains("-")) {
						writer.append(System.lineSeparator());
						evolution = st.replaceAll(pattern, emptyReplacement);
						writer.append(evolution);
						counter++;
					} else if (counter == 1) {
						evolution = st.replaceAll(pattern, emptyReplacement);
						writer.append(evolution);
						counter++;
					}
				}
			}
			writer.close();
			
		} else {
			System.out.println("\nDesculpe, mas no momento só estamos processando diposição por linhas!");
		}
		
	}
	
}