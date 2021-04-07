package estacionamento;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class AcessoTest {

	Acesso a; 
	@Before
	public void setUP(){
		a = new Acesso(17, 4, 2012, 8, 0);
	}
	
	@Test
	public void testeApenasFracoes() {
		a.setHoraSaida(8);
		a.setMinutosSaida(40);
		assertEquals(6.0f, a.calcularValor(), 0);
	}
	
	@Test
	public void testeUmaHoraCheia() {
		a.setHoraSaida(9);
		a.setMinutosSaida(0);
		assertEquals(7.0f, a.calcularValor(), 0);
	}
	
	@Test
	public void testeDuasHorasCheias(){
		a.setHoraSaida(10);
		a.setMinutosSaida(0);
		assertEquals(14.0f, a.calcularValor(), 0);
	}
	
	@Test
	public void testeNoveHoras() {
		a.setHoraSaida(17);
		a.setMinutosSaida(0);
		assertEquals(30.0f, a.calcularValor(), 0);
	}

}
