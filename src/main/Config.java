package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.NoSuchAttributeException;

public class Config {

	private static final String DEFAULT_CONFIG_PATH = ".config";
	
	private static String configPath = DEFAULT_CONFIG_PATH;
	private static Config instance = null;

	private Map<String, String> attributeMap;
	

	private static Config getInstance() throws IOException {
		if (instance == null)
			instance = new Config();
		return instance;
	}
	
	public static String getAttribute(String attrName) throws IOException, NoSuchAttributeException{
		String attribute = getInstance().getAttributeMap().get(attrName);
		if(attribute == null)
			throw new NoSuchAttributeException();
		else return attribute;
	}

	private Config() throws IOException {
		this.setAttributeMap(load(getConfigPath()));
	}

	private static Map<String, String> load(String configPath) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		String line;
		InputStream fis = new FileInputStream(configPath);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			String attrName = line.split("=")[0];
			String attrValue = line.split("=")[1];
			map.put(attrName, attrValue);
		}
		br.close();

		return map;
		// TODO Auto-generated method stub

	}

	private Map<String, String> getAttributeMap() {
		return attributeMap;
	}

	private void setAttributeMap(Map<String, String> attributeMap) {
		this.attributeMap = attributeMap;
	}

	public static String getConfigPath() {
		return configPath;
	}

	public static void setConfigPath(String configPath) {
		Config.configPath = configPath;
	}
	
	

}
