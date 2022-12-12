package app;

public class Stack {

	private char[] stack;
	private int size;

	private Stack() {
		this.stack = new char[0];
		this.size = 0; 
	}
	
	public static Stack getStack() {
		return new Stack();
	}

	public boolean push(char c) {
		char[] temp = new char[stack.length + 1];
		for (int i=0; i<size; i++) {
			temp[i] = stack[i]; 
		}

		temp[size] = c; 
		
		stack = temp; 
		if (stack[size] == c) {
			size++; 
			return true;
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	public char top() {
		return stack[size-1];
	}

	public char pop() throws EmptyStackException {
		char resposta = '\0';
		if (size==0) {
			throw new EmptyStackException(); 
		} 
		
		resposta = stack[size-1];
		
		char temp[] = new char[size - 1]; 
		for (int i=0; i<size-1; i++) {
			temp[i] = stack[i]; 
		}
		
		stack = temp;
		size--; 
		
		return resposta;
	}

}
