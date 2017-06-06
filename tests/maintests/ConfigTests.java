package maintests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

import org.junit.Before;
import org.junit.Test;

import main.Config;

public class ConfigTests {
	
	@Before
	public void setUp(){
		Config.setConfigPath("tests/testresources/test.config");

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
