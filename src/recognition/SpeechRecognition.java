package recognition;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import main.Config;

public class SpeechRecognition {
	
	  public static RecognitionResults recognize(File audio) {
		    SpeechToText service = new SpeechToText();
		    RecognizeOptions options = new RecognizeOptions.Builder().timestamps(true).build();
		    try {
				service.setUsernameAndPassword(Config.getAttribute("username"), Config.getAttribute("password"));
			} catch (NoSuchAttributeException | IOException e) {
				e.printStackTrace();
			}

		    return new RecognitionResults(service.recognize(audio, options).execute());
	  }
	  
	  
	  
	  

}
