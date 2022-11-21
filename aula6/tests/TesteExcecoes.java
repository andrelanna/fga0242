package tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ TesteLancamentoExcecoes.class, TesteMedidaInvalidaException.class })
@IncludeCategory(TesteExcecao.class)
public class TesteExcecoes {

}
