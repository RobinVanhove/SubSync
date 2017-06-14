package subtitles;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SRTEntryTests.class,
        SRTFileTests.class,
        SubTitleTests.class
})


public class SubtitlesTestSuite {}
