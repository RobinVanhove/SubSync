package video;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import components.AudioFile;
import main.Util;

public class VideoTests {
	
	//D@Test
	public void createTestAudioFile(){
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		vf.getAudioFile((float) Util.stringToTimestamp("00:10:00,000") , (float) 2 * 1000 * 60, new File("tests/testresources").toPath());
	}

	@Test
	public void getAudioTest() throws IOException {
		File expectedFile = new File("tests/testresources/got_audio_10_12.wav");
		
		Video video = new Video(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"));
		File actualFile = video.getAudio(Util.stringToTimestamp("00:10:00,000") , Util.stringToTimestamp("00:12:00,000")).getFile();
		
		
		byte[] expectedData = Files.readAllBytes(expectedFile.toPath());
		byte[] actualData = Files.readAllBytes(actualFile.toPath());
		
		assertArrayEquals(expectedData, actualData);

		
	}

}
