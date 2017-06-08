package recognition;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

public class VideoFile {

	private static final String AUDIO_OUTPUT_NAME = "audio";
	private static final String AUDIO_OUTPUT_FORMAT = "wav";
	
	private File file;
	private VideoFormat format;

	public VideoFile(File file, VideoFormat format) {
		this.setVideoFile(file);
		this.setFormat(format);
	}

	private File getVideoFile() {
		return file;
	}

	private void setVideoFile(File videoFile) {
		this.file = videoFile;
	}

	public File getAudioFile() {
		File target = new File(AUDIO_OUTPUT_NAME+"."+AUDIO_OUTPUT_FORMAT);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec(this.getFormat().getToWavCodec());
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat(AUDIO_OUTPUT_FORMAT);
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		try {
			encoder.encode(this.getVideoFile(), target, attrs);
		} catch (IllegalArgumentException | EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}

	private VideoFormat getFormat() {
		return format;
	}

	private void setFormat(VideoFormat format) {
		this.format = format;
	}

}
