package recognition;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import components.TimedString;
import recognition.IBMWatsonSpeechResults;
import recognition.IBMWatsonRecognizer;

public class RecognitionResultsTests {

	@Test
	public void RecognitionParsingTest() {
		assertEquals("can", RecognitionTestSuite.rr.get(50L));
		assertEquals("you", RecognitionTestSuite.rr.get(190L));
		assertEquals("keep", RecognitionTestSuite.rr.get(280L));
		assertEquals("a", RecognitionTestSuite.rr.get(490L));
		assertEquals("secret", RecognitionTestSuite.rr.get(540L));
	}
	
	@Test
	public void toTimedStringTest(){
		TimedString ts = RecognitionTestSuite.rr.toTimedString();
		assertEquals("can you keep a secret", ts.getImplodedString());
		assertTrue(50L == ts.getPositionMap().get(0));
		assertTrue(190L == ts.getPositionMap().get(4));
		assertTrue(280L == ts.getPositionMap().get(8));
		assertTrue(490L == ts.getPositionMap().get(13));
		assertTrue(540L == ts.getPositionMap().get(15));
	}

}
