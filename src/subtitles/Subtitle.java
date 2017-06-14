package subtitles;

import java.io.File;
import java.io.IOException;

import components.SubtitleFacade;
import components.TimedString;

public class Subtitle implements SubtitleFacade{

	@Override
	public TimedString getSubtitles(File file) {
		try {
			SRTFile srtFile = SRTFile.load(file);
			return srtFile.toTimedString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
