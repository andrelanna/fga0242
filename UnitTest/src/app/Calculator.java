package app;

import exceptions.LimitException;

public class Calculator {
	
	private static final int HIGHER_LIMIT = 32767;
    private static final int LOWER_LIMIT = -32768;
	
	public short sum(int i, int j) throws LimitException {
		int result = i + j;
		
		if (result > HIGHER_LIMIT) {
			throw new LimitException("Higher limit extrapoled");
		} else if (result < LOWER_LIMIT) {
			throw new LimitException("Lower limit extrapoled");
		}

		return (short) (result);
	}
	
	public short subtraction(int i, int j) throws LimitException {
		int result = i - j;
		
		if (result > HIGHER_LIMIT) {
			throw new LimitException("Higher limit extrapoled");
		} else if (result < LOWER_LIMIT) {
			throw new LimitException("Lower limit extrapoled");
		}

		return (short) (result);
	}
}
