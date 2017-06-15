package components.interfaces;

import java.io.File;

import components.AudioFile;

public interface VideoFacade {
	
	public AudioFile getAudio(long from, long to);
	
	public long length();

}
