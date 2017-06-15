package components.interfaces;

import java.io.File;

import components.AudioFile;
import components.TimedString;

public interface RecognitionFacade {
	
	public TimedString recognize(AudioFile audio);

}
