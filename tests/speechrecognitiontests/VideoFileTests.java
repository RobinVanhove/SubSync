package speechrecognitiontests;

import java.io.File;

import org.junit.Test;

import recognition.VideoFile;
import recognition.VideoFormat;

public class VideoFileTests {

	@Test
	public void ConstructorTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
	}
	
	@Test
	public void getAudioFileTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile();
	}

}
