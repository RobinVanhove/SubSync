package main;

import java.io.File;
import java.io.IOException;

import matching.TimedString;
import recognition.RecognitionResults;
import recognition.SpeechRecognition;
import recognition.VideoFile;
import recognition.VideoFormat;
import subtitles.SRTFile;

public class SubSync_Main {

	public static void main(String args[]) {
		run();
	}
	
	public static void run(){
		try {
			
			System.out.println("[1]  Loading subtitle file: tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.srt");
			SRTFile srtFile = SRTFile.load(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.srt"));
			TimedString subtitleText = srtFile.toTimedString();
			
			System.out.println("[2]  Loading video file: tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv");
			VideoFile videoFile = new VideoFile(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"), VideoFormat.MKV);
		
			System.out.println("[3]  Reading audio from video file and running IBM Watson voice recognition on audio");
			TimedString recognizedText = new Converter(videoFile).execute();			
			System.out.println(recognizedText);
			System.out.println(recognizedText.getImplodedString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
