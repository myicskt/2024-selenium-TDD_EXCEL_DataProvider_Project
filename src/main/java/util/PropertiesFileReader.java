package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	String filePath;

	public PropertiesFileReader(String filePath) {
		this.filePath = filePath;
	}

	public String getProperty(String key) {
		String property = "";
		try {
			FileInputStream file = new FileInputStream(filePath);
			Properties properties = new Properties();
			properties.load(file);
			property = properties.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}

}
