package com.utilityFiles;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TakeScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://zysxsk7370.trial.sugarcrm.com/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[data-username='admin']")).click();
		Thread.sleep(10000);
		

		WebElement sugerCubeIcon = driver.findElement(By.cssSelector("a[class= 'cube btn btn-invisible btn-link']"));
		
		
		Screenshot currentSugerCubeIconImg = new AShot().takeScreenshot(driver, sugerCubeIcon);
		ImageIO.write(currentSugerCubeIconImg.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\ResourceFiles\\expectedimg.png"));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
