package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties properties;

	private static final String CONFIG_FILE_PATH = ".\\src\\test\\resources\\config.properties";

	public ConfigReader() throws IOException {
		properties = new Properties();

		FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
		properties.load(fileInputStream);

	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));

	}
}
