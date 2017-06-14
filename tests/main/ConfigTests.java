package main;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Config;

public class ConfigTests {
	
	private static final String TEST_CONFIG_LOCATION = "tests/testresources/test.config";
	
	@Before
	public void setUp(){
		Config.setConfigPath(TEST_CONFIG_LOCATION);
	}
	
	@Test
	public void ConfigTest() throws IOException, NoSuchAttributeException {	
		assertEquals("abcdefg", Config.getAttribute("username"));
		assertEquals("azertyuiop", Config.getAttribute("password"));
	}
	
	@Test (expected=FileNotFoundException.class)
	public void ConfigTest_FileNotFoundCase() throws IOException, NoSuchAttributeException {		
		Config.setConfigPath("tests/testresources/nonexisting.config");
		Config.getAttribute("username");
	}
	
	@Test (expected=NoSuchAttributeException.class)
	public void ConfigTest_NoSuchAttributeCase() throws IOException, NoSuchAttributeException{
		Config.getAttribute("nosuchattribute");
	}

}
