package main;

import java.io.File;
import java.io.IOException;

import components.Converter;
import components.TimedString;
import video.Video;


class SubSync_Main {

	public static void main(String args[]) {
		run();
	}
	
	public static void run(){
		Video video = new Video(new File("tests/testresources/Game of Thrones - s01e01 - Winter Is Coming.mkv"));
		Converter converter = new Converter(video);
		System.out.println(converter.execute());
		
	}
}
