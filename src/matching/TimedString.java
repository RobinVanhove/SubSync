package matching;

import java.util.Map;
import java.util.TreeMap;

public class TimedString {
	
	private String implodedString;
	private TreeMap<Integer, Long> positionMap;
	
	public TimedString(TreeMap<Integer, Long> map, String implodedString){
		setPositionMap(map);
		setImplodedString(implodedString);
	}

	public String getImplodedString() {
		return implodedString;
	}

	private void setImplodedString(String implodedString) {
		this.implodedString = implodedString;
	}

	public Map<Integer, Long> getPositionMap() {
		return positionMap;
	}

	private void setPositionMap(TreeMap<Integer, Long> positionMap) {
		this.positionMap = positionMap;
	}

}
