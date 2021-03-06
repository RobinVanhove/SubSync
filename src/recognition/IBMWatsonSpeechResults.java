package recognition;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;

import components.Converter;
import components.TimedString;
import components.interfaces.TimedStringSource;
import main.Util;


class IBMWatsonSpeechResults extends TreeMap<Long, String> implements TimedStringSource{

	private long offset;
	
	public IBMWatsonSpeechResults(SpeechResults sr) {
		this.parseSpeechResults(sr);
	}

	private void parseSpeechResults(SpeechResults sr) {
		List<Transcript> resultList = sr.getResults();
		for (Transcript t : resultList) {
			if (t.isFinal()) {
				try {
					JSONObject obj = new JSONObject(t.toString());
					JSONArray timestamps = ((JSONObject) (obj.getJSONArray("alternatives").get(0)))
							.getJSONArray("timestamps");

					for (int i = 0; i < timestamps.length(); i++) {
						JSONArray timestampObj = timestamps.getJSONArray(i);
						this.put((long) (Float.parseFloat(timestampObj.get(1).toString()) * 1000),
								timestampObj.get(0).toString());
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public TimedString toTimedString() {
		
		System.out.println("Fetched speech results from " + Util.timestampToString(this.getOffset()));
		String implodedString = "";
		TreeMap<Integer, Long> positionMap = new TreeMap<Integer, Long>();
		for(Map.Entry<Long,String> entry : this.entrySet()) {
			  Long key = entry.getKey();
			  String value = entry.getValue();
			  
			  positionMap.put(implodedString.length(), key + this.getOffset());
			  implodedString += value.toLowerCase() + " ";
			  
			}
		
		if(implodedString.isEmpty())
			return new TimedString(new TreeMap<Integer, Long>(), "");
		else
			return new TimedString(positionMap, implodedString.substring(0, implodedString.length() - 1));
		
	}

	private long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	

}
