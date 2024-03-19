package dependenciaTestes;

public class Calculadora {

	public static int a;
	public static int b;
	public static int c;
	
	public static int m1() {
		c = c + a + b;
		return c;
	}

	public static int m2() {
		c = c + b;
		return c;
	}

	public static int m3() {
		c = c + a;
		return c;
	}

}
