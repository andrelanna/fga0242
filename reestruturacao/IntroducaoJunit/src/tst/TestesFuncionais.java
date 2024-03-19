package tst;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({CadastrarAlunoFeliz.class, CadastrarAlunoInvalido.class})
@ExcludeCategory(Excecao.class)
@IncludeCategory(Funcional.class)
public class TestesFuncionais {

}
