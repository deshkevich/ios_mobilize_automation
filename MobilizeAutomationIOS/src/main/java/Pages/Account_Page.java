package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Account_Page {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public Account_Page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}
	
	
	private static MobileElement element = null;
	
	By logout=By.name("Log Out");
	By logoutOk=By.name("Logout");
	By viewTab=By.name("Views");
	By preferences=By.name("Preferences");	 
	By devicesTab=By.name("Devices");	
	By title = By.id("Account");
	By alertview = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]"); 
	By sharing =By.name("Sharing");
    By following = By.name("Following");
    By frequenltyaskedqnsTtx=By.name("Frequenty Asked Question");
    By changepwdTxt=By.name("Change Password");
    By termsCondtionsTxt=By.name("Terms & Conditions");
    By settingsButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
     
	By change_passwordheader = By.name("CHANGE PASSWORD");
	By current_passwordplaceholder = By.xpath("//UIASecureTextField[1]");//Current Password
	By New_Password = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[2]");
	By Confirm_Password = By.xpath("//UIASecureTextField[2]");
	By save = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]");
	By Cancel = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
	By repair = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
	By views = By.xpath("//UIATableView[1]/UIATableGroup[1]/UIASegmentedControl[1]/UIAStaticText[1]");
	By firstname_lastname = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAStaticText[1]");
	By emailid = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[2]");
	By devicesTabAccountPage=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIASegmentedControl[1]/UIAStaticText[3]");
	
    By  accountSettingsIcon=By.name("AccountSettingsScreen_SettingsButton");
    By changepwdBackBtn=By.name("Back");
    By changepwdcurrenPwdNextBtn=By.name("next");//--//UIAApplication[1]/UIAWindow[1]/UIAButton[1]
    By CancelBtnAccountPage=By.name("Cancel"); 
	By saveBtnAccntPage=By.name("Save");
	By choosePhotoFrmLbryBtn=By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]");//name("Choose From Library");//
	By takePhoto=By.name("Take Photo");
	By canelInChanePhto=By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAActionSheet[1]/UIAButton[1]");//name("Cancel");
	By accountTitleText=By.name("Account");
	By editsettingsButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	By changePwdFiled=By.name("Change Password");
	By invaliPasswordAlert=By.name("Invalid Password");//xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]");
	By changePwdClearIcon=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]/UIAButton[1]");
	By changePhoto=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
	By choosePictureAlertList=By.name("Change Profile Photo");
	By nameTextBx=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]");
	By emailIDtTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[2]");
	By tempText=By.name("Temperature");
	By windSpeedTxt=By.name("Wind Speed");

	By rainEtTxt=By.name("Rain & ET");
	
	
	
	public  MobileElement getrainEtTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(rainEtTxt);

		}catch(NoSuchElementException e){
			//ATUReports.add("rainEtTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("rainEtTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getwindSpeedTxt1() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(windSpeedTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("windSpeedTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("windSpeedTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getwindSpeedTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(windSpeedTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("windSpeedTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("windSpeedTxt Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement gettempText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(tempText);

		}catch(NoSuchElementException e){
			ATUReports.add("tempText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tempText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public  MobileElement getemailIDtTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(emailIDtTextBox);

		}catch(NoSuchElementException e){
			ATUReports.add("emailIDtTextBox Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("emailIDtTextBox Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getnameTextBx() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(nameTextBx);

		}catch(NoSuchElementException e){
			ATUReports.add("nameTextBx Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("nameTextBx Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getchoosePictureAlertList() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(choosePictureAlertList);

		}catch(NoSuchElementException e){
			ATUReports.add("choosePictureAlertList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("choosePictureAlertList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getchangePhoto() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(changePhoto);

		}catch(NoSuchElementException e){
			ATUReports.add("changePhoto Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changePhoto Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchangePwdClearIcon() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(changePwdClearIcon);

		}catch(NoSuchElementException e){
			ATUReports.add("changePwdClearIcon Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changePwdClearIcon Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getinvaliPasswordAlertd() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(invaliPasswordAlert);

		}catch(NoSuchElementException e){
			ATUReports.add("invaliPasswordAlert Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("invaliPasswordAlert Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getchangePwdFiled() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(changePwdFiled);

		}catch(NoSuchElementException e){
			ATUReports.add("changePwdFiled Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changePwdFiled Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement geteditsettingsButton() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(editsettingsButton);

		}catch(NoSuchElementException e){
			ATUReports.add("editsettingsButton Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("editsettingsButton Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsettingsButton() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(settingsButton);

		}catch(NoSuchElementException e){
			ATUReports.add("settings Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("settings Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getaccountTitleText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(accountTitleText)));
		}catch(NoSuchElementException e){
			ATUReports.add("accountTitleText Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("accountTitleText Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcanelInChanePhto() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(canelInChanePhto)));
		}catch(NoSuchElementException e){
			ATUReports.add("canelInChanePhto Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("canelInChanePhto Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement gettakePhoton() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(takePhoto)));
		}catch(NoSuchElementException e){
			ATUReports.add("takePhoto Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("takePhoto Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	

	public  MobileElement getchoosePhotoFrmLbryBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(choosePhotoFrmLbryBtn)));
		}catch(NoSuchElementException e){
			ATUReports.add("choosePhotoFrmLbryBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("choosePhotoFrmLbryBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	public  MobileElement getsaveBtnAccntPage() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(saveBtnAccntPage)));
		}catch(NoSuchElementException e){
			ATUReports.add("saveBtnAccntPage Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("saveBtnAccntPage Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getCancelBtnAccountPage() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(CancelBtnAccountPage)));
		}catch(NoSuchElementException e){
			ATUReports.add("CancelBtnAccountPage Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CancelBtnAccountPage Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	public  MobileElement getchangepwdcurrenPwdNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(changepwdcurrenPwdNextBtn)));
		}catch(NoSuchElementException e){
			ATUReports.add("changepwdcurrenPwdNextBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changepwdcurrenPwdNextBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getchangepwdBackBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(changepwdBackBtn)));
		}catch(NoSuchElementException e){
			ATUReports.add("changepwdBackBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changepwdBackBtn Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getaccountSettingsIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(accountSettingsIcon)));
		}catch(NoSuchElementException e){
			ATUReports.add("accountSettingsIcon Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("accountSettingsIcon Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement gettermsCondtionsTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(termsCondtionsTxt)));
		}catch(NoSuchElementException e){
			ATUReports.add("termsCondtionsTxt Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("termsCondtionsTxt Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getchangepwdTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(changepwdTxt)));
		}catch(NoSuchElementException e){
			ATUReports.add("changepwdTxt Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changepwdTxt Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getfrequenltyaskedqnsTtx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(frequenltyaskedqnsTtx)));
		}catch(NoSuchElementException e){
			ATUReports.add("frequenltyaskedqnsTtx Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frequenltyaskedqnsTtx Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getfollowing() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(following)));
		}catch(NoSuchElementException e){
			ATUReports.add("following Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("following Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getsharing() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(sharing)));
		}catch(NoSuchElementException e){
			ATUReports.add("sharing Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("sharing Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getlogout() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(logout)));
		}catch(NoSuchElementException e){
			ATUReports.add("logout Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("logout Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getlogoutOk() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(logoutOk)));
		}catch(NoSuchElementException e){
			ATUReports.add("logoutOk button in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("logoutOk button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public  MobileElement getdevicesTab() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(devicesTab)));
		}catch(NoSuchElementException e){
			ATUReports.add("devices Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("devices Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getpreferences() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(preferences)));
		}catch(NoSuchElementException e){
			ATUReports.add("preferences Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("preferences Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getviewTab() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(viewTab)));
		}catch(NoSuchElementException e){
			ATUReports.add("view Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("view Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdevicesTabAccountPage() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(devicesTabAccountPage)));
		}catch(NoSuchElementException e){
			ATUReports.add("Devices Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Devices Tab in account page element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfirstname_lastname() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstname_lastname)));
		}catch(NoSuchElementException e){
			ATUReports.add("First Name element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("First Name element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getemailid() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(emailid)));
		}catch(NoSuchElementException e){
			ATUReports.add("EmailID element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EmailID element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getviews() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(views)));
		}catch(NoSuchElementException e){
			ATUReports.add("View element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("View element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getrepair() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(repair)));
		}catch(NoSuchElementException e){
			ATUReports.add("Repair element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Repair element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gettitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(title)));
		}catch(NoSuchElementException e){
			ATUReports.add("Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getalertview() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(alertview);

		}catch(NoSuchElementException e){
			ATUReports.add("Alert View element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Alert View element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	/*public  MobileElement getsettings() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(settings);

		}
		catch(NoSuchElementException e){
			ATUReports.add("Settings element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Settings element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/
	
	public  MobileElement getchange_passwordheader() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(change_passwordheader);

		}
		catch(NoSuchElementException e){
			ATUReports.add("ChangePassword Header element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ChangePassword Header element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getcurrent_passwordplaceholder() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(current_passwordplaceholder);

		}catch(NoSuchElementException e){
			ATUReports.add("CurrentPassword placeHolder element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CurrentPassword placeHolder element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getNew_Password() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(New_Password);

		}
		catch(NoSuchElementException e){
			ATUReports.add("NewPassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NewPassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getConfirm_Password() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Confirm_Password);

		}catch(NoSuchElementException e){
			ATUReports.add("ConfirmPassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ConfirmPassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsave() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(save)));

		}catch(NoSuchElementException e){
			ATUReports.add("Save element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Save element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getCancel() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(Cancel)));

		}catch(NoSuchElementException e){
			ATUReports.add("Cancel element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Cancel element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
