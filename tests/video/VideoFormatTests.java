package video;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class VideoFormatTests {

	@Test
	public void getWavCodecTests() {
		assertEquals("pcm_s16le", VideoFormat.MKV.getWavCodec());
	}
	
	@Test
	public void getFormat_SupportedCase() {
		assertEquals(VideoFormat.MKV, VideoFormat.getFormat(new File("testvideo.mkv")));
	}
	
	@Test
	public void getFormat_UnsupportedCase() {
		assertEquals(VideoFormat.UNSUPPORTED, VideoFormat.getFormat(new File("testvideo.abc")));
	}

}
