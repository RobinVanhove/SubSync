package recognition;

public enum VideoFormat {
	MKV, AVI, MP4;

	public String getToWavCodec() {
		switch (this) {
		case MKV:
			return "pcm_s16le";
		default:
			throw new UnsupportedOperationException();
		}
	}
}
