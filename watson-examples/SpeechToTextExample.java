

import java.io.File;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;


/**
 * Recognize a sample wav file and print the transcript into the console output. Make sure you are using UTF-8 to print
 * messages; otherwise, you will see question marks.
 */
public class SpeechToTextExample {

  public static void main(String[] args) {
    SpeechToText service = new SpeechToText();
    RecognizeOptions options = new RecognizeOptions.Builder().timestamps(true).build();
    service.setUsernameAndPassword("b5821638-269d-46d9-aa63-3d6104af149c", "EAVRIp5CEcIr");
    
    File audio = new File("test3.wav");
    SpeechResults transcript = service.recognize(audio, options).execute();
    System.out.println(transcript);
  }
}
