package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Parser;

public class ColchetesTest {

	@Test
	public void testParentesesBalanceadoSimples() {
		Parser parser = Parser.getParser("[]");
		assertTrue(parser.isBalanced()); 
	}
	
	@Test
	public void testParentesesDesbalanceadoSimples() {
		Parser parser = Parser.getParser("[");
		assertTrue(!parser.isBalanced());
	}
	
	@Test
	public void testParentesesDesbalanceadoPar() {
		Parser parser = Parser.getParser("[[");
		assertTrue(!parser.isBalanced());
	}
	
	@Test
	public void testParesParentesesBalanceados() {
		Parser parser = Parser.getParser("[][]");
		assertTrue(parser.isBalanced());
	}
	
	@Test
	public void testParentesesAninhados() {
		Parser parser = Parser.getParser("[[]]");
		assertTrue(parser.isBalanced());
	}
	
	@Test
	public void testParentesesBalanceadosAninhados() {
		Parser parser = Parser.getParser("[[[][][][[][]]]]");
		assertTrue(parser.isBalanced());
	}

}
