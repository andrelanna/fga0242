package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCadastroPensaoAlimenticia {
	
	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void testeCadastroUmaPensaoAlimenticia() {
		String dependente = "Jose da Silva";
		String parentesco = "filho";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		
		assertEquals(1000f, irpf.getTotalPensaoAlimenticia(), 0f);
	}
	
	@Test
	public void testeCadastroDuasPensoesAlimenticia() {
		String dependente = "Jose da Silva";
		String parentesco = "filho";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		dependente = "Laura da Silva";
		parentesco = "filha";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		
		assertEquals(2000f, irpf.getTotalPensaoAlimenticia(), 0f);
	}
	
	
	@Test
	public void testeCadastroQuatrosPensoesAlimenticia() {
		String dependente = "Jose da Silva";
		String parentesco = "filho";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		dependente = "Laura da Silva";
		parentesco = "filha";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		dependente = "Carlos da Silva";
		parentesco = "Alimentando";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		dependente = "Maria da Silva";
		parentesco = "Mae";
		irpf.cadastrarDependente(dependente, parentesco);
		irpf.cadastrarPensaoAlimenticia(dependente, 1000f);
		
		assertEquals(3000f, irpf.getTotalPensaoAlimenticia(), 0f);
	}
}
