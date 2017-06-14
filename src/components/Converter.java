package components;

import java.util.stream.LongStream;

import recognition.Recognition;
import video.Video;

public class Converter {
	
	public static final long FRAGMENT_LENGTH = 3 * 60 * 1000;
	public static final int SKIP = 3;
	
	private Video video;
	private Recognition recognition;
	
	public Converter(Video video){
		setVideo(video);
		setRecognition(new Recognition());
	}
	
	public TimedString execute(){
		return LongStream.range(0, this.getVideo().length())
		.filter(i -> i % (FRAGMENT_LENGTH * (SKIP + 1))  == 0)
		.mapToObj(i -> this.getVideo().getAudio(i, i + FRAGMENT_LENGTH - 1))
		.map(af -> this.getRecognition().recognize(af))
		.reduce((ts1, ts2) -> ts1.combine(ts2)).get();
		
	}

	private Video getVideo() {
		return video;
	}

	private void setVideo(Video video) {
		this.video = video;
	}

	private Recognition getRecognition() {
		return recognition;
	}

	private void setRecognition(Recognition recognition) {
		this.recognition = recognition;
	}

}
