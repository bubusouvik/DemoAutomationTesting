/**
 * Author: Souvik Guria
 * Description: Get the data from property files.
 */
package com.at.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	// common data
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("./testdata/testdata.properties");
		Properties prop = new Properties();
		prop.load(file);
		String data = prop.getProperty(key);
		return data;
	}

	// get the dates
	public String getDateFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("./testdata/dates.properties");
		Properties prop = new Properties();
		prop.load(file);
		String data = prop.getProperty(key);
		return data;
	}

}
