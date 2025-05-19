package tst;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ CadastroPessoa.class, 
				TstUniaoMatrimonio.class, 
				TstFiliacao.class})
@IncludeCategory({Funcional.class})
public class AllTests {

}
