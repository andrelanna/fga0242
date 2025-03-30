
package tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;

@RunWith(Categories.class)
@SuiteClasses({ CriacaoSimulacaoTeste.class, TstCalculoPrice.class, TstInformacoesFinanciamento.class })
@IncludeCategory(TstExcecao.class)
public class TestesExcecao {

}