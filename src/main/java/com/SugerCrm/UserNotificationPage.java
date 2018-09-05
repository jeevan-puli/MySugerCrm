package com.SugerCrm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserNotificationPage extends UsersBasePage {

	WebDriver driver = null;
	
	@FindBy(css = "div[class= 'flex-list-view-content'] > table > tbody > tr:nth-child(1) > td:nth-child(5) > span")
	WebElement firstNotificationStatusBtn;
	
	
	public UserNotificationPage(WebDriver driver) {
		super(driver);
	
	}
	
	public String firstNotificationStatusBtnText() {
		return firstNotificationStatusBtn.getText();
	}
	
	public void clickFirstNotificationStatusBtn() {
		firstNotificationStatusBtn.click();
	}

	
	

	
	

}
