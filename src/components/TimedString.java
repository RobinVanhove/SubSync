package components;

import java.util.Map;
import java.util.Map.Entry;

import main.Util;

import java.util.TreeMap;

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
	
	public boolean isEmpty(){
		return this.length() == 0;
	}
	
	public long from(){
		if(!this.isEmpty())
			return this.getPositionMap().firstEntry().getValue();
		else
			return 0;
	}
	
	public long to(){
		if(!this.isEmpty())
			return this.getPositionMap().lastEntry().getValue();
		else return 0;
	}


	public TimedString combine(TimedString other) {
		System.out.println("Combining speech results from " + Util.timestampToString(other.from()) + " to " + Util.timestampToString(other.to()));

		TimedString newTs = this.copy();	
		
		if(other.isEmpty())
			return newTs;
		if(newTs.isEmpty())
			return other.copy();
		
		newTs.getPositionMap().put(newTs.length() + 1, newTs.getPositionMap().lastEntry().getValue());
		for (Entry<Integer, Long> e : other.getPositionMap().entrySet()) {
				newTs.getPositionMap().put(e.getKey() + newTs.length() + 1, e.getValue());

		}
			newTs.setImplodedString(newTs.getImplodedString() + " " + other.getImplodedString());
		return newTs;
	}
	
	@SuppressWarnings("unchecked")
	public TimedString copy(){
		TimedString newTs = Identity();
		newTs.setImplodedString(new String(this.getImplodedString()));
		newTs.setPositionMap((TreeMap<Integer, Long>) this.getPositionMap().clone());
		return newTs;
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
		
		for (Entry<Integer, Long> entry : this.getPositionMap().entrySet()) {
			try {
				str += this.getImplodedString().charAt(entry.getKey()) + ": " + entry.getKey() + " -->  " + entry.getValue() + " ("
						+ Util.timestampToString(entry.getValue()) + ")\n";
				
			} catch (StringIndexOutOfBoundsException e) {
				str += " : " + entry.getKey() + " -->  " + entry.getValue() + " ("
						+ Util.timestampToString(entry.getValue()) + ")\n";

			}
		}
		if (this.length() == 0)
			return "EMPTY";
		else
			return str;
	}
	
	public static TimedString Identity(){
		return new TimedString(new TreeMap<Integer, Long>(), "");
	}

}
