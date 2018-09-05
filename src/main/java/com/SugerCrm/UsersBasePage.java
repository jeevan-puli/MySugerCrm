package com.SugerCrm;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class UsersBasePage extends DemoLoginPage{
	
	public WebDriver driver = null;
	
	@FindBy(css = "a[class= 'cube btn btn-invisible btn-link']")
	WebElement sugerCubeIcon;
	
	@FindBy(css = "button[aria-label= 'Home - More']")
	WebElement sugerCubeIconDDBtn;
	
	@FindBy(css = "span[class= 'btn-group home open'] > div")
	WebElement sugerCubeIconDDMenu;
	
	@FindBy(css = "button[aria-label= 'More Modules']")
	WebElement dashLetOverFlowBtn;
	
	@FindBy(css = "input[aria-label='Global Search']")
	WebElement searchBar;
	
	@FindBy(css = "a[data-action= 'search_icon']")
	WebElement searchBarIcon;
	
	@FindBy(css = "button[data-original-title= 'Favorite']")
	WebElement favaroiteBtn;
	
	@FindBy(css = "div[data-name= 'notifications-list-button']")
	WebElement notificationBtn;
	
	@FindBy(css = "button[aria-label= 'User Menu']")
	WebElement userIcon;
	
	@FindBy(css = "button[aria-label= 'User Menu'] > i")
	WebElement userIconDropDown;
	
	@FindBy(css = "button[data-original-title= 'Quick Create'] > i")
	WebElement quickCreatePlusIcon;
	
	@FindBy(css = "a[name= 'add_button']")
	WebElement creatButton;
	
	@FindBy(css = "a[class= 'btn dropdown-toggle btn-primary']")
	WebElement creatButtonDDBtn;
	
	@FindBy(css = "img[data-metadata='logo']")
	WebElement bottomLogo;
	
	@FindBy(css = "button[data-action= 'mobile']]")
	WebElement bottomMobileBtn;
	
	@FindBy(css = "button[data-action= 'shortcuts']")
	WebElement bottomShortcutsBtn;
	
	@FindBy(css = "button[data-action= 'feedback']")
	WebElement bottomFeedBackBtn;
	
	@FindBy(css = "button[data-action= 'help']")
	WebElement bottomHelpBtn;
	
	@FindBy(css = "i[class= 'fa fa-bars span1']")
	WebElement notificationsSandwichIcon;
	
	//Constructor
	public UsersBasePage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	//Methods
	public void clickSugerCubeIcon() {
		sugerCubeIcon.click();
	}
	
	public BufferedImage getSugerCubeIconImg() throws IOException {
		
		
		Screenshot currentSugerCubeIconImg = new AShot().takeScreenshot(driver, sugerCubeIcon);
		ImageIO.write(currentSugerCubeIconImg.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\ResourceFiles\\ActualRuntimeSugerCubeImage.png"));
		return currentSugerCubeIconImg.getImage();
	}
	
	public boolean isSugerCubeIconVisable() {
		return sugerCubeIcon.isDisplayed();
	}
	
	public void clickSugerCubeIconDDBtn() {
		sugerCubeIconDDBtn.click();
	}
	
	public boolean doesSugerCubeIconDDMenupopulate() {
		return sugerCubeIconDDMenu.isDisplayed();
			
	}
	
	public boolean isSugerCubeIconDDBtnVisible() {
		return sugerCubeIconDDBtn.isDisplayed();
	}
	
	public void clickBashletOverFlowBtn() {
		dashLetOverFlowBtn.click();
	}
	
	public boolean clickBashletOverFlowBtnVisible() {
		return dashLetOverFlowBtn.isDisplayed();
	}
	
	public void clickOnSearchBar() {
		searchBar.click();
	}
	
	public String getTextInSearchBar() {
		return searchBar.getText();
	}
	
	public void clickSearchBarIcon() {
		searchBarIcon.click();
	}
	
	public boolean isNotificationIconVisible() {
		return notificationBtn.isDisplayed();
				
	}
	
	public void clickNotificationIcon() {
		notificationBtn.click();
	}
	
	public String countNotifications() {
		return notificationBtn.getText();
	}
	public String getNotificationIconColour() {
		return notificationBtn.getCssValue("colour");
	}
	
	public boolean isUserIconVisible() {
		return userIcon.isDisplayed();
	}
	
	public void clickUserIcon() {
		userIcon.click();
	}
	
	public void getUsericonImage() {
		userIcon.getScreenshotAs(OutputType.FILE);
	}
	
	public void clickUserIconDDBtn() {
		userIconDropDown.click();
	}
	
	public boolean isQuickCreatPlusVisible() {
		return quickCreatePlusIcon.isDisplayed();
	}
	
	public void clickQuickCreatPlus() {
		quickCreatePlusIcon.click();
	}
	
	public boolean isFavaroitesBtnVisible() {
		return favaroiteBtn.isDisplayed();
	}
	
	public boolean isFavaroitesBtnEnabled() {
		return favaroiteBtn.isEnabled();
	}
	
	public boolean isFavaroitesBtnSelected() {
		return favaroiteBtn.isSelected();
	}

	public boolean isCreateBtnVisible() {
		return creatButton.isDisplayed();
	}
	
	public String getCreateBtnText() {
		return creatButton.getText();
	}
	
	public String getCreateBtnColor() {
		return creatButton.getCssValue("colour");
	}
	
	public void clickCreateBtn() {
		creatButton.click();
	}
	
	public boolean isCreateBtnDDVisible() {
		return creatButtonDDBtn.isDisplayed();
	}
	
	public void clickCreateBtnDDIcon() {
		creatButtonDDBtn.click();
	}
	
	public boolean isBottonMobileIconVisible() {
		return bottomMobileBtn.isDisplayed();
	}
	
	public String getBottonMobileIconText() {
		return bottomMobileBtn.getText();
	}
	
	public void clickBottonMobileIcon() {
		bottomMobileBtn.click();
	}
	
	public boolean isBottomShortcutsIconVisible() {
		return bottomShortcutsBtn.isDisplayed();
	}
	
	public String getBottomShortcutsIconText() {
		return bottomShortcutsBtn.getText();
	}
	
	public void clickBottomShortcutsIcon() {
		bottomShortcutsBtn.click();
	}
	
	public boolean isBottomFeedBackIconVisible() {
		return bottomFeedBackBtn.isDisplayed();
	}
	
	public String getBottomFeedBackIconText() {
		return bottomFeedBackBtn.getText();
	}
	
	public void clickBottomFeedBackIcon() {
		bottomFeedBackBtn.click();
	}
	
	public boolean isBottomHelpIconVisible() {
		return bottomHelpBtn.isDisplayed();
	}
	
	public String getBottomHelpIconText() {
		return bottomHelpBtn.getText();
	}
	
	public void clickBottomHelpIcon() {
		bottomHelpBtn.click();
	}
	
	public void clickBottomLogoIcon() {
		bottomLogo.click();
	}
	
	public void getBottomLogoImage() {
		bottomLogo.getScreenshotAs(OutputType.FILE);
	}
	
	public void clickNotificatinsSWBtn() {
		notificationsSandwichIcon.click();
	}

}
