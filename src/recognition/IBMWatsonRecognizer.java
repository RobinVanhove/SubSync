package recognition;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;

import components.Converter;
import main.Config;

class IBMWatsonRecognizer{
	
	  public static IBMWatsonSpeechResults recognize(File audio) {
		    SpeechToText service = new SpeechToText();
		    
		    RecognizeOptions options = new RecognizeOptions.Builder()
		    								.timestamps(true)
		    								.inactivityTimeout((int) (Converter.FRAGMENT_LENGTH / 1000))
		    								.profanityFilter(false)
		    								.build();
		    
		    try {
				service.setUsernameAndPassword(Config.getAttribute("username"), Config.getAttribute("password"));
			} catch (NoSuchAttributeException | IOException e) {
				e.printStackTrace();
			} catch ( com.ibm.watson.developer_cloud.service.exception.BadRequestException e){
				System.out.println("Maybe no speech found in this fragment?");
				e.printStackTrace();
			}
		    
		    return new IBMWatsonSpeechResults(service.recognize(audio, options).execute());
	  }
	  
	  
	  
	  

}
