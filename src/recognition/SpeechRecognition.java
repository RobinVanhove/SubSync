package recognition;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;

import main.Config;
import main.Converter;

public class SpeechRecognition {
	
	  public static RecognitionResults recognize(File audio) {
		    SpeechToText service = new SpeechToText();
		    RecognizeOptions options = new RecognizeOptions.Builder().timestamps(true).inactivityTimeout((int) (Converter.FRAGMENT_LENGTH / 1000)).build();
		    try {
				service.setUsernameAndPassword(Config.getAttribute("username"), Config.getAttribute("password"));
			} catch (NoSuchAttributeException | IOException e) {
				e.printStackTrace();
			} catch ( com.ibm.watson.developer_cloud.service.exception.BadRequestException e){
				System.out.println("No speech found in this of fragment");
			}

		    return new RecognitionResults(service.recognize(audio, options).execute());
	  }
	  
	  
	  
	  

}
