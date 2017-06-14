package main;

public class Util {
	public static String timestampToString(long timestamp) {

		long ms = timestamp % 1000;
		long s = (timestamp % (60 * 1000)) / 1000;
		long m = (timestamp % (60 * 60 * 1000)) / (1000 * 60);
		long h = (timestamp % (24 * 60 * 60 * 1000)) / (1000 * 60 * 60);

		String str = String.format("%02d:%02d:%02d,%03d", h, m, s, ms);
		return str;
	}

	public static long stringToTimestamp(String timestamp) {
	
		String[] tokens = timestamp.split(":|,");

		if(!(tokens.length == 4) || !tokens[0].matches("^\\d+$") || !tokens[1].matches("^\\d+$") || !tokens[2].matches("^\\d+$") || !tokens[3].matches("^\\d+$"))
			throw new IllegalArgumentException();
		int ms = Integer.parseInt(tokens[3]);
		int s = Integer.parseInt(tokens[2]);
		int m = Integer.parseInt(tokens[1]);
		int h = Integer.parseInt(tokens[0]);

		return (h * 60 * 60 * 1000) + (m * 60 * 1000) + (s * 1000) + ms;

	}
}
