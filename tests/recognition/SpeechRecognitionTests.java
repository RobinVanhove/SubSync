package recognition;

import java.io.File;

import org.junit.Test;

import recognition.IBMWatsonRecognizer;

public class SpeechRecognitionTests {
	
	//D@Test
	public void test2() {
		IBMWatsonRecognizer.recognize(new File("tests/testresources/test2.wav"));
	}

	//D@Test
	public void test3() {
		IBMWatsonRecognizer.recognize(new File("tests/testresources/test3.wav"));
	}

}
