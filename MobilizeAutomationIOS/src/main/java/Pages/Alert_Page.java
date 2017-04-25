package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Alert_Page {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();


	public Alert_Page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By error =By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]");// By.name("Error");
	By emailtxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	By forgotpassword = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");//By.name("Credentials are required to access this resource.");
	By okbutton = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");//By.name("OK");
	By nousersfound = By.name("No shared users found");
	By Mobilize = By.name("Mobilize");
	By locationheader = By.name("Allow “Mobilize” to access your location while you use the app?");
	By Dont_Allow = By.name("Don’t Allow");
	By Allow = By.name("Allow");
	By skipthe_gdd_date = By.name("Skip GDD Start Date");
	By gdd_error_boday = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	By skipbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
	By cancelbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
	By nofollowersAlert = By.className("UIAAlert");
	By nofolwerstxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAStaticText[1]");
	By createViewTutorialBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
    By createViewTutorialNextBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	By cancelAddingBody=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	By cancelAdding=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]");	
	By gdpsWithLocationBody=By.xpath("//UIAApplication[1]/UIAWindow[5]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]");
	By gpsAllowBtn=By.name("Allow");
	By gpsInformationHeading=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]");
	By createViewCloseIcon=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	By addViewTutorialDialogBox=By.name("Add a view to track Frost, Weather, Crop or Irrigation data with your sensors.");
	By addViewThirdScreenTutorilaBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]");
	By notificationTutorialBoxTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");
	By accountScreenTutorialBoxTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]");
	
	
	public  MobileElement getaccountScreenTutorialBoxTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(accountScreenTutorialBoxTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("accountScreenTutorialBoxTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("accountScreenTutorialBoxTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getnotificationTutorialBoxTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(notificationTutorialBoxTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("notificationTutorialBoxTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("notificationTutorialBoxTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getaddViewThirdScreenTutorilaBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(addViewThirdScreenTutorilaBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("addViewThirdScreenTutorilaBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("addViewThirdScreenTutorilaBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getaddViewTutorialDialogBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(addViewTutorialDialogBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("addViewTutorialDialogBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("addViewTutorialDialogBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getcreateViewCloseIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(createViewCloseIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("createViewCloseIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("createViewCloseIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgpsInformationHeading() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(gpsInformationHeading)));

		}catch(NoSuchElementException e){
			ATUReports.add("gpsInformationHeading element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gpsInformationHeading element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgpsAllowBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(gpsAllowBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("gpsAllowBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gpsAllowBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgdpsWithLocationBody() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(gdpsWithLocationBody)));

		}catch(NoSuchElementException e){
			ATUReports.add("gpsWithoutLocationBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gpsWithoutLocationBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	 public  MobileElement getcancelAddingBody() throws InterruptedException{
			try{
				element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(cancelAddingBody)));

			}catch(NoSuchElementException e){
				ATUReports.add("cancelAddingBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}catch(TimeoutException e){
				ATUReports.add("cancelAddingBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}
			return element;
		}
	 public  MobileElement getcancelAdding() throws InterruptedException{
			try{
				element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(cancelAdding)));

			}catch(NoSuchElementException e){
				ATUReports.add("cancelAdding element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}catch(TimeoutException e){
				ATUReports.add("cancelAdding element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}
			return element;
		}
	    
	 
    public  MobileElement getcreateViewTutorialNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(createViewTutorialNextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("createViewTutorialNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("createViewTutorialNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
	public  MobileElement getcreateViewTutorialBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(createViewTutorialBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("createViewTutorialBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("createViewTutorialBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getnofolwerstxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(nofolwerstxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("NoFollowers element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NoFollowers element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getnofollowersAlert() throws InterruptedException{

		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(nofollowersAlert)));

		}catch(NoSuchElementException e){
			ATUReports.add("NoFollowersAlert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NoFollowersAlert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getskipbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(skipbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SkipBUtton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SkipButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcancelbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(cancelbtn)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("CancelBUtton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CancelButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getgdd_error_boday() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gdd_error_boday);

		}catch(NoSuchElementException e){
			ATUReports.add("GddErrorBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddErrorBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getskipthe_gdd_date() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(skipthe_gdd_date);

		}catch(NoSuchElementException e){
			ATUReports.add("SkipGddDate is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SkipGddDate is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	//WELCOME, Create your first view to begin mobilizing.
	public  MobileElement getAllow() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Allow);

		}catch(NoSuchElementException e){
			ATUReports.add("AllowText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AllowText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getDont_Allow() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Dont_Allow);

		}catch(NoSuchElementException e){
			ATUReports.add("DontAllow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DontAllow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getlocationheader() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(locationheader);

		}catch(NoSuchElementException e){
			ATUReports.add("LoactionHeader is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Location Header is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement geterror() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(error);

		}catch(NoSuchElementException e){
			ATUReports.add("Error element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Error element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getemailtxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(emailtxt);

		}catch(NoSuchElementException e){
			ATUReports.add("EmailText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EmailText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getforgotpasswordtxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(forgotpassword);

		}catch(NoSuchElementException e){
			ATUReports.add("ForgotPassword Text is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ForgotPassword Text is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getokbutton() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(okbutton);

		}catch(NoSuchElementException e){
			ATUReports.add("OkButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("OkButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
