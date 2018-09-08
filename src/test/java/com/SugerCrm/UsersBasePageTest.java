package com.SugerCrm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;

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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class UsersBasePageTest {
	
	public WebDriver driver = null;
	
	UsersBasePage usersBasePg = null;
	
	public WebDriverWait wait;
	
	public BrowserSetUpFile browserSetup = null;
	
	public UserNotificationPage userNotiPg = null;
	
	public static final String USERNAME = "jeevankumarpuli1";
	public static final String AUTOMATE_KEY = "xwZHrMyRp5VaUcp4Hyo9";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	@BeforeTest
	public void openBrowserWithCurrentTestPageUrl() throws IOException, InterruptedException {
		
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
		
		usersBasePg = PageFactory.initElements(driver, UsersBasePage.class);
		
		System.out.println("====================Avatar Selection======================");
		
		if(browserSetup.selectCurrentAvatar().equalsIgnoreCase("Admin")) {
				
			System.out.println("Your are now Logged In as: Admin");
			usersBasePg.canLoginAsAdmin();
		
		}else if(browserSetup.selectCurrentAvatar().equalsIgnoreCase("Vp")) {
				
			System.out.println("Your are now Logged In as: VP");
			usersBasePg.canLoginAsVp();
		
		}else if(browserSetup.selectCurrentAvatar().equalsIgnoreCase("SR")) {
			
			System.out.println("Your are now Logged In as: SR");
			usersBasePg.canLoginAsSr();
		
		}else {
			
			System.out.println("Error:Can not find the Avatar you want to login As\nAs an laternative you are logged in as VP");
			usersBasePg.canLoginAsVp();
		}
		Thread.sleep(10000);
		usersBasePg = PageFactory.initElements(driver, UsersBasePage.class);
		
	}
	
	@Test(priority = 11, groups = "UI")
	public void SugerCrmCubeIconVisibe() {

		System.out.println("====================Suger Icon Visibility Test=============");
		
		boolean vis = usersBasePg.isSugerCubeIconVisable();
		System.out.println("Suger Cube Icon Is Visable:"+vis);
		Assert.assertTrue(vis);
	}
	
	@Test(priority = 12, groups = "UI" )
	public void verifySugerCubeIcon() throws IOException {
		
		System.out.println("====================Suger Icon correctness test===================");
	
		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\ResourceFiles\\ExpectedSugerCubeImage.png"));
		BufferedImage actualImage = usersBasePg.getSugerCubeIconImg();
		
		ImageDiffer comparingImages = new ImageDiffer();
		ImageDiff differenceInImage = comparingImages.makeDiff(expectedImage, actualImage);
		
		Assert.assertFalse(differenceInImage.hasDiff(),"Images Are Same");
		
	}
	
	@Test(priority = 13, groups = "Functional")
	public void ClickSugerCubeIcon() {
		
		System.out.println("====================Suger Icon ClickTest===================");
		
		String deforeClickPageTitle = usersBasePg.pageTitle();
		System.out.println("CubeIcon Before Click:"+deforeClickPageTitle);
		
		usersBasePg.clickSugerCubeIcon();
		
		String afterClickPageTitle = usersBasePg.pageTitle();
		System.out.println("CubeIcon After Click:"+afterClickPageTitle);
		
		Assert.assertFalse(deforeClickPageTitle.equalsIgnoreCase(afterClickPageTitle));
		System.out.println("Suger Cube Icon clicked Successfully");
		
	}
	
	@Test(priority = 14, groups = "Functional")
	public void ClickSugerCubeIconDDBtn( ) {
		
		System.out.println("====================Suger Icon DorpDown Btn ClickTest===================");
		
		usersBasePg.clickSugerCubeIconDDBtn();
		
		boolean vis = usersBasePg.doesSugerCubeIconDDMenupopulate();
		System.out.println("Suger Cube Icon DropDown Visible:"+vis);
		
		Assert.assertTrue(vis);
		
	}
	
	@Test(priority = 15, groups = "UI")
	public void DashLetOverFlowBtnVisible() {
		
		System.out.println("====================DashLet OverFlow Btn Visiblty Test===================");
		
		boolean vis = usersBasePg.clickBashletOverFlowBtnVisible();
		System.out.println("DashLet OverFlow Btn Visible:"+vis);
		
		Assert.assertTrue(vis);
		
	}
	
	@Test(priority = 16, groups = "Functional")
	public void notificationsBadgeCountReduced() throws InterruptedException {
		
		System.out.println("====================Check notificatin badge count reduced after reading notfication===================");
		
		String beforReadCount = usersBasePg.countNotifications();
		System.out.println("Count Before Reading the Notification is:"+beforReadCount);
		
		usersBasePg.clickNotificationIcon();
		
		usersBasePg.clickNotificatinsSWBtn();
		Thread.sleep(3000);
	
		userNotiPg = PageFactory.initElements(driver, UserNotificationPage.class);
		
		userNotiPg.clickFirstNotificationStatusBtn();
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		String afterReadCount = userNotiPg.countNotifications();
		System.out.println("Count After Reading the Notification is:"+afterReadCount);
		
		Assert.assertFalse(beforReadCount.contentEquals(afterReadCount));
		
	}

	@AfterTest
	public void closeTheBrowser() {
		
		driver.quit();
		System.out.println("====================Browser Closed SuccessFully===================");
		
	}
}
