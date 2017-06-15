package subtitles;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import components.TimedString;

public class SubTitleTests {

	@Test
	public void SubtitleTest() {
		TimedString ts = new Subtitle(new File("tests/testresources/short.srt")).getSubtitles();
		assertEquals("hello it's me penguins are awesome", ts.getImplodedString());
		assertEquals(Long.valueOf(4814123), ts.getPositionMap().get(0));
		assertEquals(Long.valueOf(5058456), ts.getPositionMap().get(34));
		
	}

}
