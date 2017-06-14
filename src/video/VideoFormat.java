package video;

import java.io.File;

enum VideoFormat {
	MKV, UNSUPPORTED;

	public String getWavCodec() {
		switch (this) {
		case MKV:
			return "pcm_s16le";
		default:
			throw new UnsupportedOperationException();
		}
	}

	public static VideoFormat getFormat(File file) {
		String[] nameParts = file.getName().split("\\.");
		String extension = nameParts[nameParts.length - 1];
		VideoFormat format;
		try {
			format = valueOf(extension.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.err.println("Video format " + extension + " is not supported");
			e.printStackTrace();
			format = VideoFormat.UNSUPPORTED;
		}
		return format;

	}
}
