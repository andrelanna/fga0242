package app;

public class Parser {

	private String string;
	private Stack stack;

	private Parser(String string) {
		this.string = string;
	}

	public static Parser getParser(String string) {
		return new Parser(string);
	}

	public boolean isBalanced() {
		if (string.length() %2 != 0) {
			return false; 
		}
		
		stack = Stack.getStack();
		
		for (int i=0; i<string.length(); i++) {
			if (string.charAt(i) == ')') {
				if (stack.top() == '(') {
					try {
						stack.pop();
					} catch (EmptyStackException e) {
						e.printStackTrace();
					}
				}
			} else if (string.charAt(i) == ']'){
				if (stack.top() == '[') {
					try {
						stack.pop();
					} catch (EmptyStackException e) {
						e.printStackTrace();
					}
				}
			} else if (string.charAt(i) == '}'){
				if (stack.top() == '{') {
					try {
						stack.pop();
					} catch (EmptyStackException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				stack.push(string.charAt(i));
			}
		}
		
		if (stack.getSize() == 0) {
			return true; 
		} else {
			return false;
		}
	}

}
