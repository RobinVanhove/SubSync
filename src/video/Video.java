package video;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import components.AudioFile;
import components.interfaces.VideoFacade;

public class Video implements VideoFacade{
	
	private VideoFile videoFile;
	private static Path tempDir = null;
	
	
	public Video(File file){
		this.videoFile = new VideoFile(file, VideoFormat.getFormat(file));
	}

	@Override
	public AudioFile getAudio(long from, long to) {
		try{
		if(tempDir == null){
			tempDir = Files.createTempDirectory("SubSync_tmp");
			tempDir.toFile().deleteOnExit();
		}
		}catch(IOException e){
			System.err.println("Could not create auio write directory");
			e.printStackTrace();
		}
		AudioFile af =  new AudioFile(this.videoFile.getAudioFile(from, to - from, tempDir), from, to);
		System.out.println(af.getFile().getAbsolutePath());
		return af;
	}

	@Override
	public long length() {
		return videoFile.getLength();
	}

}
