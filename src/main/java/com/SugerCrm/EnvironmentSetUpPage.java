package com.SugerCrm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilityFiles.BrowserSetUpFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnvironmentSetUpPage {
	
	WebDriver driver = null;
	DemoLoginPage demoLogPg = null;
	WebDriverWait wait;
	BrowserSetUpFile browserSetup = null;
	
	public  EnvironmentSetUpPage() throws IOException {
		
		browserSetup = new BrowserSetUpFile();
		
		if(browserSetup.selectDriver().equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				
		}else if(browserSetup.selectDriver().equalsIgnoreCase("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserSetup.selectDriver().equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Can not Find given Driver: Running Test with Chrome Driver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		// opening SugarDemo home page
		driver.get(browserSetup.selectCurrentTestWebPageUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//calling DemoLoginPage Constructor
		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		System.out.println("===================== Your are in Suger CRM Demo Page===================");
	}
	

}
