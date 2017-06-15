package components.interfaces;

import java.io.File;

import components.LinearScale;
import components.TimedString;

public interface SubtitleFacade {
	
	public TimedString getSubtitles();
	
	public void rescale(LinearScale ls);

}
