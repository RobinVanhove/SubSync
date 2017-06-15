package subtitles;

import java.io.File;
import java.io.IOException;

import components.LinearScale;
import components.TimedString;
import components.interfaces.SubtitleFacade;

public class Subtitle implements SubtitleFacade{
	
	private File file;
	
	public Subtitle(File file){
		this.setFile(file);
	}

	@Override
	public TimedString getSubtitles() {
		try {
			SRTFile srtFile = SRTFile.load(getFile());
			return srtFile.toTimedString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private File getFile() {
		return file;
	}
	private void setFile(File file) {
		this.file = file;
	}

	@Override
	public void rescale(LinearScale ls) {
		// TODO Auto-generated method stub
		
	}

}
