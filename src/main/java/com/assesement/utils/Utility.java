package com.assesement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "/src/test/resources/com/assesement/config/config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		return prop;
	}
}
