package subtitlestests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.junit.Test;

import subtitles.SRTEntry;
import subtitles.SRTFile;


public class SRTFileTests {
	
	String conversation = ""
			+ "1\r\n"
			+ "01:20:14,123 --> 01:20:15,456\r\n"
			+ "-Hello?\r\n"
			+ "-It's me!\r\n"
			+ "\r\n"
			+ "2\r\n"
			+ "01:23:14,123 --> 01:24:18,456\r\n"
			+ "-Penguins are awesome.\r\n"
			+ "\r\n"
			+ "";
	
	@Test
	public void loadTest() throws IOException{
			SRTFile file = SRTFile.load("tests/testresources/test1.srt");
			assertEquals(conversation, file.toString());
	}
	
	@Test (expected=NoSuchFileException.class)
	public void loadTest_FileNotFoundCase() throws IOException{
			SRTFile file = SRTFile.load("nonexisting.srt");
	
	}
	
	@Test
	public void toStringTest(){
		SRTFile file = new SRTFile();
		file.add(new SRTEntry("01:20:14,123", "01:20:15,456", "-Hello?\r\n-It's me!"));
		file.add(new SRTEntry("01:23:14,123", "01:24:18,456", "-Penguins are awesome."));

		assertEquals( conversation, file.toString());
		
	}

}
