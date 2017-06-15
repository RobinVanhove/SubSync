package video;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Random;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.MultimediaInfo;
import main.Util;

class VideoFile {

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

	public File getAudioFile(float offset, float duration, Path tmpDir) {
		System.out.println("Converting video to audio from " + Util.timestampToString((long) offset) + " to " + Util.timestampToString((long) (offset + duration)));
		File target = new File(tmpDir.toString() + "\\" + AUDIO_OUTPUT_NAME + "_" + nextFileHash() + "." + AUDIO_OUTPUT_FORMAT);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec(this.getFormat().getWavCodec());
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat(AUDIO_OUTPUT_FORMAT);
		attrs.setAudioAttributes(audio);
		attrs.setOffset(offset / 1000);
		attrs.setDuration(duration / 1000);
		Encoder encoder = new Encoder();
		try {
			encoder.encode(this.getVideoFile(), target, attrs);
			
		} catch (IllegalArgumentException | EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}

	public long getLength() {
		MultimediaInfo info;
		try {
			info = new Encoder().getInfo(this.getVideoFile());
			return info.getDuration();

		} catch (EncoderException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public VideoFormat getFormat() {
		return format;
	}

	private void setFormat(VideoFormat format) {
		this.format = format;
	}
	
	private static String nextFileHash(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}

}
