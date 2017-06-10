package speechrecognitiontests;

import java.io.File;

import org.junit.Test;

import matching.TimedString;
import recognition.RecognitionResults;
import recognition.SpeechRecognition;
import recognition.VideoFile;
import recognition.VideoFormat;

public class VideoFileTests {

	//D@Test
	public void ConstructorTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
	}
	
	//D@Test
	public void getAudioFileTest() {
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile(0f, 5.0f * 60f);
	}
	
	@Test
	public void VideoFragmentToTextTest(){
		VideoFile vf = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		File audioFile = vf.getAudioFile(10*60f, 2.0f * 60f);
		RecognitionResults rr = SpeechRecognition.recognize(audioFile);
		TimedString ts = rr.toTimedString();
		System.out.println(ts.getImplodedString());
		System.out.println(ts);
	}

}
