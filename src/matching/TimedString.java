package matching;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import subtitles.SRTEntry;

public class TimedString {

	private String implodedString;
	private TreeMap<Integer, Long> positionMap;

	public TimedString(TreeMap<Integer, Long> map, String implodedString) {
		setPositionMap(map);
		setImplodedString(implodedString);
	}

	public int length() {
		return this.getImplodedString().length();
	}

	public void append(TimedString other) {
		this.getPositionMap().put(this.length() + 1, this.getPositionMap().lastEntry().getValue());
		for (Entry<Integer, Long> e : other.getPositionMap().entrySet()) {
			this.getPositionMap().put(e.getKey() + this.length() + 1, e.getValue());
		}
		this.setImplodedString(this.getImplodedString() + " " + other.getImplodedString());
	}

	public String getImplodedString() {
		return implodedString;
	}

	private void setImplodedString(String implodedString) {
		this.implodedString = implodedString;
	}

	public TreeMap<Integer, Long> getPositionMap() {
		return positionMap;
	}

	private void setPositionMap(TreeMap<Integer, Long> positionMap) {
		this.positionMap = positionMap;
	}

	@Override
	public String toString() {
		String str = this.getImplodedString() +"\n";
		int i = 0;
		for (Entry<Integer, Long> entry : this.getPositionMap().entrySet()) {
			try {
				str += this.getImplodedString().charAt(i) + ": " + entry.getKey() + " -->  " + entry.getValue() + " ("
						+ SRTEntry.timestampToString(entry.getValue()) + ")\n";
				i++;
			} catch (StringIndexOutOfBoundsException e) {
				str += " : " + entry.getKey() + " -->  " + entry.getValue() + " ("
						+ SRTEntry.timestampToString(entry.getValue()) + ")\n";

			}
		}
		if (this.length() == 0)
			return "EMPTY";
		else
			return str;
	}

}
