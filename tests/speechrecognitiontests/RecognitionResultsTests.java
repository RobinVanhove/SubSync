package speechrecognitiontests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import matching.TimedString;
import recognition.RecognitionResults;
import recognition.SpeechRecognition;

public class RecognitionResultsTests {
	
	RecognitionResults rr;
	
	@Before
	public void setUp(){
		rr = SpeechRecognition.recognize(new File("tests/testresources/test2.wav"));

	}

	@Test
	public void RecognitionParsingTest() {
		assertEquals("can", rr.get(50L));
		assertEquals("you", rr.get(190L));
		assertEquals("keep", rr.get(280L));
		assertEquals("a", rr.get(490L));
		assertEquals("secret", rr.get(540L));
	}
	
	@Test
	public void toTimedStringTest(){
		TimedString ts = rr.toTimedString();
		assertEquals("can you keep a secret", ts.getImplodedString());
		assertTrue(50L == ts.getPositionMap().get(0));
		assertTrue(190L == ts.getPositionMap().get(4));
		assertTrue(280L == ts.getPositionMap().get(8));
		assertTrue(490L == ts.getPositionMap().get(13));
		assertTrue(540L == ts.getPositionMap().get(15));
	}

}
