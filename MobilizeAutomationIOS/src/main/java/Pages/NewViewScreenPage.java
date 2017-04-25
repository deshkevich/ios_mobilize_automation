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

public class NewViewScreenPage {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public NewViewScreenPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}
	private static MobileElement element = null;

	By backtxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
	By backbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]");
	By viewlogo = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
	By viewname = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]");
	By view_txt_blw = By.name("This will be used for sorting and will be listed on the home screen.");
	By view_txtfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");//By.name("IAddViewScreen_ViewNameInputTextField");
	By addtxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
	By addbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[5]");
	
	By addgpstxt = By.name("Add GPS information");
	By Frost = By.name("FROST");
	By frostCaption=By.name("Track temperatures");
	By Weather = By.name("WEATHER");
	By weatherCaption=By.name("Track forecast");
	By crop = By.name("CROP");
	By cropCaption=By.name("Monitor growth cycle");
	By irrigation = By.name("IRRIGATION");
	By irrigationCaption=By.name("Monitor irrigation");
	
	By monitor_irrigation = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[3]");
	By shareicon = By.name("ShareIcon");//xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]");
	 
	By edit  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]");
	By emaileditext = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
	By settingsicon = By.name("SettingsButton_Frost");
	By settingsiconweather = By.name("SettingsButton_Weather");//xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAButton[3]");
	By settingsiconcrop = By.name("SettingsButton_Crop");//xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[5]/UIAButton[2]");
	By settingsiconirrigation = By.name("SettingsButton_Irrigation");//xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[7]/UIAButton[2]");
	By title =By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAStaticText[1]");
	By editsettingsbtn =By.name("Edit Settings");
	
	By settingsButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
    By editAccountSettingsIcon=By.name("Edit_profile");//By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
  //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]
	By viewNameHeading=By.name("VIEW NAME");
	By viewNextBtn=By.name("AddNewViewScreen_NextButton");
	By viewscreenCancelBtn=By.name("AddNewViewScreen_CancelButton");
	By editViewBtn=By.name("Edit View");
	By shareViewPageCaption=By.name("Share this view with any Mobilize user or invite a new user to create an account.");
	By noShareUsersText=By.name(": No users have been invited yet.");
	By sharingViewTitleCaptionText=By.name("Sharing View with:");
	By gpsInformationText=By.name("Add GPS information");
	By backBtn=By.name("Back");
	By newViewList=By.className("UIATableView");
	By changeViewTitle=By.name("Change View Name:");
	By deleteButton=By.name("Delete");
    By deleteViewAlertMessage=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
  
    By deleteViewCancelBtn=By.name("Cancel");
    By deleteViewDeleteBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
    By viewNameInChangeViewNameField=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]");
    By succesMessage=By.name("Success");////UIAApplication[1]/UIAWindow[1]/UIAAlert[1]
    By successCaption=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");  
    By successOkBtn=By.name("OK");//xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
    By frostReportTextPath=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]");
   By viewReportTitleText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAStaticText[1]");
   
   By invalidEmailAlert=By.xpath("//UIAAlert[1]");
   By invalidEmailAlertText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]");
   By sharedviewsList=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");
   By shareBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
  By irrigationreportText=By.name("IRRIGATION");

  By saveBtn=By.name("Save");
  
  public  MobileElement getsaveBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(saveBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("saveBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("saveBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
  
  
  public  MobileElement getirrigationreportText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(irrigationreportText);
		}catch(NoSuchElementException e){
			ATUReports.add("shareBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("shareBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
  
   public  MobileElement getshareBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(shareBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("shareBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("shareBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getsharedviewsList() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(sharedviewsList);
		}catch(NoSuchElementException e){
			ATUReports.add("sharedviewsList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("sharedviewsList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getinvalidEmailAlertText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(invalidEmailAlertText);
		}catch(NoSuchElementException e){
			ATUReports.add("inalidEmailAlertText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("inalidEmailAlertText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getinvalidEmailAlert() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(invalidEmailAlert);
		}catch(NoSuchElementException e){
			ATUReports.add("invalidEmailAlert Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("invalidEmailAlert Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement geteditAccountSettingsIcon() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(editAccountSettingsIcon);
		}catch(NoSuchElementException e){
			ATUReports.add("editAccountSettingsIcon Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("editAccountSettingsIcon Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getviewReportTitleText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewReportTitleText);
		}catch(NoSuchElementException e){
			ATUReports.add("viewReportTitleText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("viewReportTitleText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getfrostReportTextPath() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(frostReportTextPath);
		}catch(NoSuchElementException e){
			ATUReports.add("frostReportTextPath Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostReportTextPath Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getsuccessOkBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(successOkBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("successOkBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("successOkBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getsuccessCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(successCaption);
		}catch(NoSuchElementException e){
			ATUReports.add("successCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("successCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   
   public  MobileElement getsuccesMessage() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(succesMessage);
		}catch(NoSuchElementException e){
			ATUReports.add("succesMessage Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("succesMessage Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   public  MobileElement getviewNameInChangeViewNameField() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewNameInChangeViewNameField);
		}catch(NoSuchElementException e){
			ATUReports.add("viewNameInChangeViewNameField Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("viewNameInChangeViewNameField Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
   
    
    public  MobileElement getdeleteViewDeleteBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(deleteViewDeleteBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("deleteViewDeleteBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("deleteViewDeleteBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
  public  MobileElement getdeleteViewCancelBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(deleteViewCancelBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("deleteViewCancelBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("deleteViewCancelBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
  
    public  MobileElement getdeleteViewAlertMessage() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(deleteViewAlertMessage);
		}catch(NoSuchElementException e){
			ATUReports.add("deleteViewAlertMessage Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("deleteViewAlertMessage Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
	public  MobileElement getdeleteButton() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(deleteButton);
		}catch(NoSuchElementException e){
			ATUReports.add("deleteButton Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("deleteButton Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getnchangeViewTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(changeViewTitle);
		}catch(NoSuchElementException e){
			ATUReports.add("changeViewTitle Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("changeViewTitle Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getnewViewList() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(newViewList);
		}catch(NoSuchElementException e){
			ATUReports.add("newViewList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("newViewList Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getbackBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backBtn);
		}catch(NoSuchElementException e){
			ATUReports.add("backBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("backBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgpsInformationText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gpsInformationText);
		}catch(NoSuchElementException e){
			ATUReports.add("gpsInformationText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gpsInformationText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getfrostCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(frostCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("frostCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement getweatherCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(weatherCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("weatherCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("weatherCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("cropCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getirrigationCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(irrigationCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("irrigationCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("irrigationCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsharingViewTitleCaptionText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(sharingViewTitleCaptionText);

		}catch(NoSuchElementException e){
			ATUReports.add("sharingViewTitleCaptionText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("sharingViewTitleCaptionText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getnoShareUsersText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(noShareUsersText);

		}catch(NoSuchElementException e){
			ATUReports.add("noShareUsersText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("noShareUsersText Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getshareViewPageCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(shareViewPageCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("shareViewPageCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("shareViewPageCaption Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement geteditViewBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(editViewBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("editViewBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("editViewBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getviewscreenCancelBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewscreenCancelBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("viewscreenCancelBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("viewscreenCancelBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getviewNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewNextBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("viewNextBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("viewNextBtn Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getviewNameHeading() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewNameHeading);

		}catch(NoSuchElementException e){
			ATUReports.add("viewNameHeading Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("viewNameHeading Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	
	/*public  MobileElement getdelete() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(delete);

		}catch(NoSuchElementException e){
			ATUReports.add("Delete Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Delete Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/
	
	public  MobileElement getsettingsiconirrigation() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(settingsiconirrigation);

		}catch(NoSuchElementException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getsettingsiconcrop() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(settingsiconcrop);

		}catch(NoSuchElementException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsettingsiconweather() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(settingsiconweather);

		}catch(NoSuchElementException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getemaileditext() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(emaileditext);

		}catch(NoSuchElementException e){
			ATUReports.add("EmailEditText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EmailEditText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getedit() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(edit);


		}catch(NoSuchElementException e){
			ATUReports.add("EditText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getshareicon() throws InterruptedException{
		try{
			element  = (MobileElement)((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(shareicon)));

		}catch(NoSuchElementException e){
			ATUReports.add("ShareIcon is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ShareIcon is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getmonitor_irrigation() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(monitor_irrigation)));

		}catch(NoSuchElementException e){
			ATUReports.add("MonitorIrrigation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("MonitorIrrigation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getirrigation() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(irrigation)));

		}catch(NoSuchElementException e){
			ATUReports.add("Irrigation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Irrigation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcrop() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(crop)));

		}catch(NoSuchElementException e){
			ATUReports.add("CropText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CropText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getWeather() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(Weather)));

		}catch(NoSuchElementException e){
			ATUReports.add("WeatherText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("WeatherText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getFrost() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(Frost)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getSettings() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(settingsicon)));
		}catch(NoSuchElementException e)
		{
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			return null;

		}catch (TimeoutException e) {
			// TODO: handle exception
			ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			return null;
		}
		return element;
	}

	public  MobileElement gettitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(title)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement geteditsettings() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(editsettingsbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("EditSettings element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditSettings element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getaddgpstxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(addgpstxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("AddGPSText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AddGPSText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbacktxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backtxt);

		}catch(NoSuchElementException e){
			ATUReports.add("BackTExt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbackbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(backbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getviewlogo() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewlogo);

		}catch(NoSuchElementException e){
			ATUReports.add("ViewLogo element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ViewLogo element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getviewname() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewname);

		}catch(NoSuchElementException e){
			ATUReports.add("ViewName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ViewName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getview_txt_blw() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(view_txt_blw);

		}catch(NoSuchElementException e){
			ATUReports.add("ViewTextBelow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ViewTextBelow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getview_txtfld() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(view_txtfld)));

		}catch(NoSuchElementException e){
			ATUReports.add("ViewTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ViewTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getaddtxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(addtxt)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("AddText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AddText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getaddbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(addbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("AddButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AddButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
