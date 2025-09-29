package com.at.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("./testdata/testdata.properties");
		Properties prop = new Properties();
		prop.load(file);
		String data = prop.getProperty(key);
		return data;
	}

}
