package main;

import java.io.IOException;

import javax.naming.directory.NoSuchAttributeException;

public class SubSync_Main {

	public static void main(String args[]) {

		try {
			System.out.println(Config.getAttribute("username"));
			System.out.println(Config.getAttribute("password"));
		} catch (NoSuchAttributeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
