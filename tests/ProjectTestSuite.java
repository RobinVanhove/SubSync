


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import maintests.MainTestSuite;
import speechrecognitiontests.RecognitionTestSuite;
import subtitlestests.SubtitlesTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainTestSuite.class,
        SubtitlesTestSuite.class,
        RecognitionTestSuite.class
})


public class ProjectTestSuite {}
