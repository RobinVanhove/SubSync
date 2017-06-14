package components;

import java.io.File;

public interface VideoFacade {
	
	public AudioFile getAudio(long from, long to);
	
	public long length();

}
