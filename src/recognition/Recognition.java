package recognition;

import java.io.File;

import components.AudioFile;
import components.RecognitionFacade;
import components.TimedString;

public class Recognition implements RecognitionFacade{



	@Override
	public TimedString recognize(AudioFile audio) {
		RecognitionResults rr = IBMWatsonRecognizer.recognize(audio.getFile());
		rr.setOffset(audio.getFrom());
		return rr.toTimedString();
	}

}
