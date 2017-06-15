package matching;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

class LongestCommonSubstring {

	private String s1, s2;
	private int positionInS1, length;

	public LongestCommonSubstring(String s1, String s2) {
		this.setS1(s1);
		this.setS2(s2);
		this.solveDynamically(this.getS1(), this.getS2());
	}

	private void solveDynamically(String S1, String S2) {
		int Start = 0;
		int Max = 0;
		for (int i = 0; i < S1.length(); i++) {
			for (int j = 0; j < S2.length(); j++) {
				int x = 0;
				while (S1.charAt(i + x) == S2.charAt(j + x)) {
					x++;
					if (((i + x) >= S1.length()) || ((j + x) >= S2.length()))
						break;
				}
				if (x > Max) {
					Max = x;
					Start = i;
				}
			}
		}
		this.setPositionInS1(Start);
		this.setLength(Max);

	}

	public int getPositionInFirstString() {
		return this.positionInS1;
	}

	public int getLength() {
		return this.length;
	}

	private String getS1() {
		return s1;
	}

	private void setS1(String s1) {
		this.s1 = s1;
	}

	private String getS2() {
		return s2;
	}

	private void setS2(String s2) {
		this.s2 = s2;
	}

	public String getSolution() {
		return this.getS1().substring(this.getPositionInFirstString(),
				this.getPositionInFirstString() + this.getLength());
	}

	private int getPositionInS1() {
		return positionInS1;
	}

	private void setPositionInS1(int positionInS1) {
		this.positionInS1 = positionInS1;
	}

	private void setLength(int length) {
		this.length = length;
	}

}
