package tst;

import static org.junit.Assert.*;


import org.junit.Test;

import app.EmptyStackException;
import app.Stack;

public class StackTest {

	@Test
	public void testAddCharEmptyList() {
		Stack stack = Stack.getStack(); 
		assertTrue(stack.push('a'));
		assertEquals(1, stack.getSize());
		assertEquals('a', stack.top());
	}
	
	@Test 
	public void testAddCharExistingStack() {
		Stack stack = Stack.getStack();
		assertTrue(stack.push('a'));
		assertTrue(stack.push('b'));
		assertEquals(2, stack.getSize());
		assertEquals('b', stack.top());
	}
	
	@Test 
	public void removeElementExistingStack() {
		Stack stack = Stack.getStack();
		stack.push('a'); 
		stack.push('b');
		try {
			assertEquals('b', stack.pop());
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} 
		assertEquals(1, stack.getSize());
		assertEquals('a', stack.top());
	}

	@Test 
	public void removeElementFromSingleStack() {
		Stack stack = Stack.getStack();
		stack.push('a');
		try {
			assertEquals('a', stack.pop());
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		assertEquals(0, stack.getSize());
	}
	
	@Test (expected=app.EmptyStackException.class)
	public void removeElementFromEmptyStack() throws app.EmptyStackException {
		Stack stack = Stack.getStack();
		assertEquals(0, stack.getSize());
		stack.pop();
	}
}
