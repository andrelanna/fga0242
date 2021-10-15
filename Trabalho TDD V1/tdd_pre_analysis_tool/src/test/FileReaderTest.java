package test;

import app.FileReader;
import app.exception.ArquivoNaoEncontradoException;
import app.exception.DelimitadorInvalidoException;
import app.exception.EscritaNaoPermitidaException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    private static final String NOT_EXISTING_PATH = "C:/Users/NotExistingPath/file.txt";
    private static final String DELIMITER = ";";
    private static final String READ_ONLY_PREFIX = "ReadOnly";
    private static final String READ_ONLY_SUFFIX = "txt";

    @Test(expected = ArquivoNaoEncontradoException.class)
    public void fileNotFoundShouldThrowException() throws IOException, ArquivoNaoEncontradoException,
            DelimitadorInvalidoException, EscritaNaoPermitidaException {
        fileReader.loadFile(NOT_EXISTING_PATH, DELIMITER);
    }

    @Test(expected = EscritaNaoPermitidaException.class)
    public void fileWithoutPermissionToWriteShouldThrowException() throws IOException, ArquivoNaoEncontradoException,
            DelimitadorInvalidoException, EscritaNaoPermitidaException {

        File readOnlyFile = File.createTempFile(READ_ONLY_PREFIX, READ_ONLY_SUFFIX,
                new File(System.getProperty("user.home")));

        readOnlyFile.setReadOnly();
        readOnlyFile.deleteOnExit();

        fileReader.loadFile(readOnlyFile.getPath(), DELIMITER);
    }

}
