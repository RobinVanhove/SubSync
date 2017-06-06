package speechrecognitiontests;

import java.io.File;

import org.junit.Test;

import recognition.SpeechRecognition;

public class SpeechRecognitionTests {

	@Test
	public void test() {
		SpeechRecognition.recognize(new File("tests/testresources/test3.wav"));
	}

}
