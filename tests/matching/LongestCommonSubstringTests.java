package matching;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubstringTests {

	@Test
	public void LLCSStrTest_NormalCase() {
		String s1 = "abcdefgi";
		String s2 = "avefcdefgj";
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		assertEquals(2, lcs.getPositionInFirstString());
		assertEquals(5, lcs.getLength());
		assertEquals("cdefg", lcs.getSolution());
	}
	
	@Test
	public void LLCSStrTest_reverseCase() {
		String s1 = "abcdefgi";
		String s2 = "avefcdefgj";
		LongestCommonSubstring lcs = new LongestCommonSubstring(s2, s1);
		assertEquals(4, lcs.getPositionInFirstString());
		assertEquals(5, lcs.getLength());
		assertEquals("cdefg", lcs.getSolution());
	}
	
	@Test
	public void LLCSStrTest_ZeroCase() {
		String s1 = "abcdefg";
		String s2 = "hijkl";
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		assertEquals(0, lcs.getPositionInFirstString());
		assertEquals(0, lcs.getLength());
		assertEquals("", lcs.getSolution());
	}

}
