package com.SugerCrm;


import org.openqa.selenium.WebDriver;

public class AdminPage extends UsersBasePage {

	WebDriver drive = null;
	
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}

}
