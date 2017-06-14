package components;

import java.io.File;

public class AudioFile{
	
	private File file;
	private long from, to;

	public AudioFile(File file, long from, long to) {
		super();
		this.file = file;
		this.from = from;
		this.to = to;
	}
	public File getFile() {
		return file;
	}
	public long getFrom() {
		return from;
	}
	public long getTo() {
		return to;
	}


}
