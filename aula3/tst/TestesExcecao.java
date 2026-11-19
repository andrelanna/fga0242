package tst;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({TstInformacoesFinanciamento.class, CriacaoSimulacaoTeste.class, TstCalculoPrice.class})
@IncludeCategory(TstExcecao.class)
public class TestesExcecao {}