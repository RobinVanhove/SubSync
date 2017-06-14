package recognition;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import components.AudioFile;
import components.TimedString;

public class RecognitionTests {

	@Test
	public void RecognitionTest() {
		TimedString ts = new Recognition().recognize(new AudioFile(new File("tests/testresources/test2.wav"), 0L, 5000L));
		assertEquals("can you keep a secret", ts.getImplodedString());
		assertEquals(Long.valueOf(50), ts.getPositionMap().get(0));
		assertEquals(Long.valueOf(190), ts.getPositionMap().get(4));
		assertEquals(Long.valueOf(280), ts.getPositionMap().get(8));
		assertEquals(Long.valueOf(490), ts.getPositionMap().get(13));
		assertEquals(Long.valueOf(540), ts.getPositionMap().get(15));
	}

}
