package subtitles_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import subtitles.SRTEntry;

public class SRTEntryTests {

	@Test
	public void ConstructorTest() {
		SRTEntry entry = new SRTEntry(3600123, 3604456, "-Foo?\n-Bar!");
		assertEquals(3600123, entry.getFrom());
		assertEquals(3604456, entry.getTo());
		assertEquals("-Foo?\n-Bar!", entry.getText());
	}
	
	@Test
	public void ConstructorTest_Overload1() {
		SRTEntry entry = new SRTEntry("05:53:54,123", "05:55:34,456", "-Foo?\n-Bar!");
		assertEquals(21234123, entry.getFrom());
		assertEquals(21334456, entry.getTo());
		assertEquals("-Foo?\n-Bar!", entry.getText());
	}
	
	@Test
	public void toStringTest(){
		SRTEntry entry = new SRTEntry("05:53:54,123", "05:55:34,456", "-Foo?\n-Bar!");
		assertEquals("05:53:54,123 --> 05:55:34,456\n-Foo?\n-Bar!", entry.toString());
	}
	
	@Test
	public void stringtoTimeStamp(){
		assertEquals(1234567, SRTEntry.stringToTimestamp("00:20:34,567"));
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void stringtoTimeStamp_WrongFormatCase(){
		assertEquals(1234567, SRTEntry.stringToTimestamp("test"));
	}


}
