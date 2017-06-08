package speechrecognitiontests;

import java.io.File;

import org.junit.Test;

import recognition.SpeechRecognition;

public class SpeechRecognitionTests {
	
	@Test
	public void test2() {
		SpeechRecognition.recognize(new File("tests/testresources/test2.wav"));
	}

	//D@Test
	public void test3() {
		SpeechRecognition.recognize(new File("tests/testresources/test3.wav"));
	}

}
