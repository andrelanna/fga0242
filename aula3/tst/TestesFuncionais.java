package tst;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({CriacaoSimulacaoTeste.class, TstInformacoesFinanciamento.class, TstCalculoPrice.class})
@IncludeCategory(TstFuncional.class)
public class TestesFuncionais {

}
