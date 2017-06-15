package recognition;

import java.io.File;

import components.AudioFile;
import components.TimedString;
import components.interfaces.RecognitionFacade;

public class Recognition implements RecognitionFacade{



	@Override
	public TimedString recognize(AudioFile audio) {
		IBMWatsonSpeechResults rr = IBMWatsonRecognizer.recognize(audio.getFile());
		rr.setOffset(audio.getFrom());
		return rr.toTimedString();
	}

}
