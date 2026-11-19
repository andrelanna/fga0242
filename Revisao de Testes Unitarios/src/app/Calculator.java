package app;

public class Calculator {
	private int i;
	private int j;
	
	public Calculator(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int sum() {
		return i+j;
	}
	
	public int sub() {
		return i-j;
	}
}
