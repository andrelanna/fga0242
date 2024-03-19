package lcs;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCSTest {
	
	String str1 = "ABCBDAB";
    String str2 = "BDCAB";
    String resp = "BDAB";

	@Test
	public void test() {
		AssertEquals(resp, LCS.findLCS(str1, str2));
	}

}
