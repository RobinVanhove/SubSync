package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.LongStream;

import org.apache.commons.lang3.tuple.Pair;

import matching.TimedString;
import recognition.RecognitionResults;
import recognition.SpeechRecognition;
import recognition.VideoFile;

public class Converter {
	
	public static final long FRAGMENT_LENGTH = 3 * 60 * 1000;
	public static final int SKIP = 4;
	
	VideoFile videoFile;
	
	public Converter(VideoFile vf){
		this.setVideoFile(vf);
	}
	
	public TimedString execute(){
		long length = this.getVideoFile().getLength();
		int step =  (int) FRAGMENT_LENGTH;
		
		class Pair<T>{
			long time; T object;			
			public Pair(long time, T object){ this.time = time; this.object = object; }
		}
		
		
		try {
			Path tmpPath;
			tmpPath = Files.createTempDirectory("SubSync_tmp");
			TimedString result =  LongStream.range(0, length)
					.filter(i -> i % (step * (SKIP + 1))== 0)
					.parallel()
					.mapToObj(i -> new Pair<File>(i, this.getVideoFile().getAudioFile(i, FRAGMENT_LENGTH, tmpPath)))
					.map(p -> new Pair<RecognitionResults>(p.time, SpeechRecognition.recognize(p.object)))
					.map(p -> { p.object.setOffset(p.time); return p.object.toTimedString();})
					.reduce(TimedString.Identity(), (t1,t2) -> t1.combine(t2));
			tmpPath.toFile().deleteOnExit();
			return result;
				
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	
		
		
	}

	private VideoFile getVideoFile() {
		return videoFile;
	}

	private void setVideoFile(VideoFile videoFile) {
		this.videoFile = videoFile;
	}

}
