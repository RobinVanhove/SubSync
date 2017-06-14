package recognition;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import main.Config;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RecognitionResultsTests.class,
	RecognitionTests.class,
})


public class RecognitionTestSuite {
	
	private static final String REAL_CONFIG_LOCATION = ".config";

	
	public static RecognitionResults rr;
	
	@BeforeClass
	public static void init(){
		Config.setConfigPath(REAL_CONFIG_LOCATION);
		rr = IBMWatsonRecognizer.recognize(new File("tests/testresources/test2.wav"));
	}

	

}
