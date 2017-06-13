package speechrecognitiontests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

import matching.TimedString;
import recognition.RecognitionResults;
import recognition.SpeechRecognition;
import recognition.VideoFile;
import recognition.VideoFormat;
import subtitles.SRTEntry;

public class VideoFileTests {

	//D@Test
	public void ConstructorTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
	}
	
	//D@Test
	public void getAudioFileTest() throws IOException {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile(0f*1000, 5.0f * 60f*1000, Files.createTempDirectory("SubSync_test_tmp"));
	}
	
	//D@Test
	public void VideoFragmentToTextTest() throws IOException{
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile(10*60f*1000, 3.0f * 60f*1000, Files.createTempDirectory("SubSync_test_tmp"));
		System.out.println(audioFile.getName());
		RecognitionResults rr = SpeechRecognition.recognize(audioFile);
		TimedString ts = rr.toTimedString();
		System.out.println(ts.getImplodedString());
		System.out.println(ts);
	}
	
	@Test
	public void getLengthTest(){
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		assertEquals(SRTEntry.stringToTimestamp("01:01:37,000"), vf.getLength());
	}

}
