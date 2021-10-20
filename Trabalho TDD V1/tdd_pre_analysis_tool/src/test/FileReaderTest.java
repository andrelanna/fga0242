package test;

import main.java.app.FileReader;
import main.java.app.exception.ArquivoNaoEncontradoException;
import main.java.app.exception.DelimitadorInvalidoException;
import main.java.app.exception.DisposicaoInvalidaException;
import main.java.app.exception.EscritaNaoPermitidaException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileReaderTest {
	
	private final FileReader fileReader = new FileReader();
	
	private static final String NOT_EXISTING_PATH = "C:/Users/NotExistingPath/file.txt";
	private static final String DELIMITER = ";";
	private static final String INVALID_DELIMITER = "--";
	private static final String EXISTING_PATH = System.getProperty("user.dir") +
	                                            "/tdd_pre_analysis_tool/src/main/resources/analysisTime.out";
	private static String OUTPUT_PATH = System.getProperty("user.dir") +
	                                    "/tdd_pre_analysis_tool/src/main/resources/analysisTimeTab.out";
	private static String OUTPUT_READONLY_PATH = System.getProperty("user.dir") +
	                                    "/tdd_pre_analysis_tool/src/main/resources/readOnly.out";
	
	@Test(expected = ArquivoNaoEncontradoException.class)
	public void fileNotFoundShouldThrowException() throws IOException, ArquivoNaoEncontradoException,
	                                                      DelimitadorInvalidoException, EscritaNaoPermitidaException,
	                                                      DisposicaoInvalidaException {
		fileReader.loadFile(NOT_EXISTING_PATH, DELIMITER, "colunas", OUTPUT_PATH);
	}
	
	@Test(expected = DisposicaoInvalidaException.class)
	public void dispositionInvalidException() throws IOException, ArquivoNaoEncontradoException,
	                                                 DelimitadorInvalidoException, EscritaNaoPermitidaException,
	                                                 DisposicaoInvalidaException {
		
		fileReader.loadFile(EXISTING_PATH,
		                    DELIMITER, "qualquercoisa", OUTPUT_PATH);
	}
	
	@Test(expected = EscritaNaoPermitidaException.class)
	public void fileWithoutPermissionToWriteShouldThrowException() throws IOException, ArquivoNaoEncontradoException,
	                                                                      DelimitadorInvalidoException,
	                                                                      EscritaNaoPermitidaException,
	                                                                      DisposicaoInvalidaException {
		
		File readOnlyFile = new File(OUTPUT_READONLY_PATH);
		readOnlyFile.createNewFile();
		
		readOnlyFile.setReadOnly();
		fileReader.loadFile(EXISTING_PATH, DELIMITER, "linhas", OUTPUT_READONLY_PATH);
		readOnlyFile.delete();
	}
	
	@Test(expected = DelimitadorInvalidoException.class)
	public void invalidDelimiterShouldThrowException() throws IOException, ArquivoNaoEncontradoException,
	                                                          DelimitadorInvalidoException, EscritaNaoPermitidaException,
	                                                          DisposicaoInvalidaException {
		
		fileReader.loadFile(EXISTING_PATH, INVALID_DELIMITER, "colunas", OUTPUT_PATH);
	}
	
	@Test
	public void processSuccessFile() throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException,
	                                 DelimitadorInvalidoException, IOException, DisposicaoInvalidaException {
		
		fileReader.loadFile(EXISTING_PATH, DELIMITER, "colunas", OUTPUT_PATH);
		
		File file = new File(OUTPUT_PATH);
		Assert.assertNotNull(file);
		Assert.assertTrue(file.exists());
	}
	
}