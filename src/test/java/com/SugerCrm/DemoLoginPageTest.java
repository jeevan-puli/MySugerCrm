package com.SugerCrm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilityFiles.BrowserSetUpFile;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;



public class DemoLoginPageTest {
	
	public WebDriver driver = null;
	DemoLoginPage demoLogPg = null;
	public WebDriverWait wait;
	public BrowserSetUpFile browserSetup = null;
	
	public static final String USERNAME = "jeevankumarpuli1";
	public static final String AUTOMATE_KEY = "xwZHrMyRp5VaUcp4Hyo9";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	

	@BeforeTest
	public void openDemoPage() throws IOException{
		
		browserSetup = new BrowserSetUpFile();
		
		if(browserSetup.selectDriver().equalsIgnoreCase("chrome")) {
			
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "69.0 beta");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1024x768");
		    
			driver = new RemoteWebDriver(new URL(URL), caps);
				
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

		driver.get(browserSetup.selectCurrentTestWebPageUrl());
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		
		System.out.println("===================== Your are in Suger CRM Demo Page===================");
	}
	
	@AfterTest
	public void quitBrowser() {
		
		driver.quit();
	
	}
	
	@Test(priority = 1, groups = "UI")
	public void verifyDemoText() {
		
		String dText = demoLogPg.checkDemoText();
		Assert.assertTrue(dText.contentEquals("Explore your Sugar Free Trial"));
			
	}

	@Test(priority = 2, groups = "UI")
	public void verifyPreferenceText() {
		
		String pText = demoLogPg.checkLocakPreferenceText();

		Assert.assertTrue(pText.contentEquals("1"+"\nChoose your local preferences"));
			
	}
	
	@Test(priority = 3, groups = "UI")
	public void LanguageDDVisible() throws InterruptedException {
		
		demoLogPg.languageLinkClickable();
		Thread.sleep(1000);
		
		boolean vis = demoLogPg.languageselectDDVisible();
		Assert.assertTrue(vis);
		
	}
	
	@Test(priority = 4, groups = "UI")
	public void DateDDVisible() {
		
		demoLogPg.dateFormatIconClickable();
		
		boolean vis = demoLogPg.dateFormatSelectDDVisible();
		Assert.assertTrue(vis);
		
	}
	
	@Test(priority = 5, groups = "UI")
	public void verifyContactUsText() {
		
		String CU = demoLogPg.getContactUsText();
		System.out.println(CU);
		
		Assert.assertTrue(CU.contentEquals("Contact us"));
	}
	
	@Test(priority =6, groups = "UI")
	public void checkResourceCenterText() {
		
		String RC = demoLogPg.getResourceCText();
		Assert.assertTrue(RC.contentEquals("Resource Center."));
		
	}
	@Test(priority = 7, groups = "Functional")
	public void LoginAsVP() throws InterruptedException {
		
		String pageTitleBefore = demoLogPg.pageTitle();
		
		demoLogPg.canLoginAsVp();
		
		String PageTitleAfter = demoLogPg.pageTitle();
		
		Assert.assertFalse(pageTitleBefore.contentEquals(PageTitleAfter));
		
	}
	
	@Test(priority = 8, groups = "Functional")
	public void LoginAsSR() throws InterruptedException {

		//LogOut
		driver.findElement(By.cssSelector("#userActions > div > button > i")).click();
		driver.findElement(By.cssSelector("li[class= 'profileactions-logout']")).click();
		Thread.sleep(3000);
		
		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		
		String pageTitleBefore = demoLogPg.pageTitle();
		demoLogPg.canLoginAsSr();
		Thread.sleep(5000);
		
		String PageTitleAfter = demoLogPg.pageTitle();
		Assert.assertFalse(pageTitleBefore.contentEquals(PageTitleAfter));
		
	}
	
	@Test(priority = 9, groups = "Functional")
	public void LoginAsCS() throws InterruptedException {
	
		//LogOut
		driver.findElement(By.cssSelector("#userActions > div > button > i")).click();
		driver.findElement(By.cssSelector("li[class= 'profileactions-logout']")).click();
		Thread.sleep(5000);

		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		
		String pageTitleBefore = demoLogPg.pageTitle();
		demoLogPg.canLoginAsCs();
		Thread.sleep(5000);
		
		String PageTitleAfter = demoLogPg.pageTitle();
		Assert.assertFalse(pageTitleBefore.contentEquals(PageTitleAfter));
	}
	
	@Test(priority = 10, groups = "UI")
	public void verifyResourceLink() throws InterruptedException {

		//LogOut
		driver.findElement(By.cssSelector("#userActions > div > button > i")).click();
		driver.findElement(By.cssSelector("li[class= 'profileactions-logout']")).click();
		Thread.sleep(3000);

		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		
		String pageTitleBefore = demoLogPg.pageTitle();
		demoLogPg.canNavigateToResource();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabs2.get(1));
		
		demoLogPg = PageFactory.initElements(driver, DemoLoginPage.class);
		Thread.sleep(3000);
		
		String PageTitleAfter = demoLogPg.pageTitle();
		
		Assert.assertFalse(pageTitleBefore.contentEquals(PageTitleAfter));
	}
	
}