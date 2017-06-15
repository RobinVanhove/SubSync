package video;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

import components.TimedString;
import main.Util;
import video.VideoFile;
import video.VideoFormat;

public class VideoFileTests {
	
	

	@Test
	public void ConstructorTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		assertEquals(VideoFormat.MKV, vf.getFormat());
	}
	
	@Test
	public void getAudioFileTest() throws IOException {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile(0f*1000, 5.0f * 60f*1000, Files.createTempDirectory("SubSync_test_tmp"));
		assertTrue(audioFile.delete());
	}
	
	@Test
	public void getLengthTest(){
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		assertEquals(Util.stringToTimestamp("01:01:37,000"), vf.getLength());
	}


}
