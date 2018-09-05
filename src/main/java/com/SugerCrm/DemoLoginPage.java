package com.SugerCrm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DemoLoginPage {
	
	WebDriver driver = null;

	@FindBy(css = "img[class =loginLogo]")
	WebElement sugerMainLogo;
	
	@FindBy(css = "div[class = 'content-header'] > h1")
	WebElement demoText;
	
	@FindBy(css = "div[class='step step1'] > p[class='header']")
	WebElement localPreferenceText;
	
	@FindBy(css = "div[data-action= 'languageList']")
	WebElement languageSelectionLink;
	
	@FindBy(css = "#languageListTrial > div > div > ul")
	WebElement languageOptionsDDMenu;
	
	@FindBy(css ="button[title= 'Date format']")
	WebElement dateformatIcon;
	
	@FindBy(css = "#dateFormatList > div > div > ul")
	WebElement dateOptionsDDMenu;
	
	@FindBy(css = "div[data-username= 'jim']")
	WebElement vpJim;
	
	@FindBy(css ="div[data-username= 'chris']")
	WebElement srChris;
	
	@FindBy(css = "div[data-username= 'charles']")
	WebElement csCharles;
	
	@FindBy(css = "div[data-username= 'jane']")
	WebElement mrjane;
	
	@FindBy(css = "a[data-username='admin']")
	WebElement admin;
	
	@FindBy(css = "a[data-username= 'sally']")
	WebElement privacyOfficer;
	
	@FindBy(css = "a[data-username= 'user']")
	WebElement anotherUser;
	
	@FindBy(css = "button[title= 'Contact us']")
	WebElement contactUs;
	
	@FindBy(css = "a[target= '_blank']")
	WebElement ResourceCenter;
	
	//Constructor
	public DemoLoginPage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	//Data Fuctions
	
	public String pageTitle() {
		
		return driver.getTitle();
	}
	
	public WebElement checkSugerMainLogo() {
		
		return sugerMainLogo;
	}
	
	public String checkDemoText(){
		
		System.out.println("Text in this field is:" +demoText.getText());
		return demoText.getText();
	}
	
	public String checkLocakPreferenceText() {
		
		return localPreferenceText.getText();
	}
	
	public void languageLinkClickable() {
		
		languageSelectionLink.click();
		
	}
	
	public boolean languageselectDDVisible() {
		
		return languageOptionsDDMenu.isDisplayed();
	}
	
	public void dateFormatIconClickable() {
		
		dateformatIcon.click();
	}
	
	public boolean dateFormatSelectDDVisible() {
		
		return dateOptionsDDMenu.isDisplayed();
		
	}
	
	public void canLoginAsVp() throws InterruptedException {
		
		vpJim.click();
		Thread.sleep(5000);
	}
	
	public void canLoginAsSr() throws InterruptedException {
		
		srChris.click();
		Thread.sleep(5000);
	}
	
	public void canLoginAsCs() {
		
		csCharles.click();
	}
	
	public void canLoginAsMr() {
		
		mrjane.click();
	}
	
	public void canLoginAsAdmin() {
		
		admin.click();
	}
	
	public void canLoginAsPo() {
		
		privacyOfficer.click();
	}
	
	public void canLoginAsReguralUser() {
		
		anotherUser.click();
	}
	
	public String getContactUsText() {
		
		return contactUs.getText();
	}
	public void canContactUs() {
		
		contactUs.click();
		
	}
	
	public void canNavigateToResource() {
		
		ResourceCenter.click();
	}
	
	public String getResourceCText() {
		return ResourceCenter.getText();
	}

}
	
	
	


