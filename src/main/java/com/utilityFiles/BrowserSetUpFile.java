package com.utilityFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserSetUpFile {
	
	protected Properties browserSetUp = new Properties();
	protected FileInputStream input;
	
	public BrowserSetUpFile() throws IOException{
		
		try {
			
			input = new FileInputStream("ConfigurationFiles\\BrowserSetUpFile.properties");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		browserSetUp.load(input);
	}
	
	public String selectDriver() {
		return browserSetUp.getProperty("Driver");
	}
	
	public String selectDriverProperty() {
		return browserSetUp.getProperty("DriverProperty");
	}
	
	public String selectDriverPath() {
		return browserSetUp.getProperty("DriverRelativePath");
	}
	public String selectCurrentTestWebPageUrl() {
		return browserSetUp.getProperty("SugerDemoPageUrl");
	}
	public String selectCurrentAvatar() {
		return browserSetUp.getProperty("Avatar");
	}
	
}





























