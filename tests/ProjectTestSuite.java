
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import components.ComponentsTestSuite;
import main.MainTestSuite;
import recognition.RecognitionTestSuite;
import subtitles.SubtitlesTestSuite;

import video.VideoTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainTestSuite.class,
        SubtitlesTestSuite.class,
        RecognitionTestSuite.class,
        ComponentsTestSuite.class,
        VideoTestSuite.class
})

public class ProjectTestSuite {	
	
	@BeforeClass
	public static void init(){
		RecognitionTestSuite.init();
	}
}
