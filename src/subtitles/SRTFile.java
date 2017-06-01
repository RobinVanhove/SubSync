package subtitles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SRTFile extends ArrayList<SRTEntry> {

	public static SRTFile load(Path path) throws IOException {
		byte[] encoded = Files.readAllBytes(path);
		String str = new String(encoded, Charset.forName("UTF-8"));
		return parse(str);

	}
	
	private static SRTFile parse(String str) {
		SRTFile file = new SRTFile();
		String[] entryStrings = str.split("\r\n\r\n");
		for(String entryString : entryStrings){
			String[] entryLines = entryString.split("\r\n");
			String timingLine = entryLines[1];
			String from = timingLine.split(" --> ")[0];
			String to = timingLine.split(" --> ")[1];
			String text = "";
			for(int i = 2; i < entryLines.length; i++){
				text += entryLines[i];
				if(!(i == entryLines.length - 1))
					text += "\r\n";
			}
			
			file.add(new SRTEntry(from, to, text));
		
			
		}
		return file;
	}

	public static SRTFile load(String path) throws IOException {
		return load(Paths.get(path));

	}

	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < this.size(); i++) {
			s += (i + 1) + "\r\n" + this.get(i).toString() + "\r\n\r\n";
		}
		return s;
	}

}
