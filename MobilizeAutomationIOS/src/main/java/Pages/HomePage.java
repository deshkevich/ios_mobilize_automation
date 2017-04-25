package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.google.common.base;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class HomePage {

	IOSDriver driver = (IOSDriver)TestAppiumDriver.getAppiumDriver();

	public HomePage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =(IOSDriver) driver;
		//System.out.println("From HomePage Constructor "+ driver);
	}
	private static MobileElement element = null;
	By searchtxtfield = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIATextField[1]");
	By locationiocn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
    By homebutton = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	By accountbtn =By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	By addbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
	//By shareIcon=By.name("")
	By editViewBtn=By.name("Edit View");
	By clearicon = By.name("Clear text");
	By table_first_row = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	By sharedusername = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]");
	By tableview = By.className("UIATableView");

	By weatherTitle=By.name("WEATHER"); //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]
	By irrigationTitle=By.name("IRRIGATION");//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[2]
	By frostTitle=By.name("FROST");//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]
	By cropTitle=By.name("CROP");//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[2]
	By gpsInformn=By.name("Add GPS information");
	By shareviewnameTxt=By.name("SHARE TE VIEW:");
	By shareviewNameCaption=By.name("Share this view with any Mobilize user or invite a new user to create an account.");
	
	
	
	public  MobileElement getshareviewNameCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(shareviewNameCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("shareviewNameCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("shareviewNameCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getshareviewnameTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(shareviewnameTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("shareviewnameTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("shareviewnameTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgpsInformn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(gpsInformn)));

		}catch(NoSuchElementException e){
			ATUReports.add("gpsInformn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gpsInformn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement geteditViewBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(editViewBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("editViewBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("editViewBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement gettableview() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tableview)));

		}catch(NoSuchElementException e){
			ATUReports.add("TableView element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TableView element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsharedusername() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(sharedusername)));

		}catch(NoSuchElementException e){
			ATUReports.add("ShaerdUserName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SharedUserName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gettable_first_row() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(table_first_row)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("TableFirstRow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TableFirstRow element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsearchtxtfield() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(searchtxtfield)));

		}catch(NoSuchElementException e){
			ATUReports.add("SearchTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SeacrhTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getlocationiocn() throws InterruptedException{
		try{
			element  = (MobileElement)  ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(locationiocn)));

		}catch(NoSuchElementException e){
			ATUReports.add("LocationIcon is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("LocationIcon is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gethomebutton() throws InterruptedException{
		try{
			element  = (MobileElement)  ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(homebutton)));

		}catch(NoSuchElementException e){
			ATUReports.add("HomeButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HomeButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public  MobileElement getaddbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver,40)).until(ExpectedConditions.elementToBeClickable((addbtn))));

		}catch(NoSuchElementException e){
			ATUReports.add("AddButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AddButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getaccountbtn() throws InterruptedException{
		try{
			element  = (MobileElement)  ((new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(accountbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("AccountButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("AccountButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getclearicon() throws InterruptedException{
		try{
			element  = (MobileElement)  ((new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(clearicon)));

		}catch(NoSuchElementException e){
			ATUReports.add("ClearIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ClearIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}





	/*private static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
	            .pollingEvery(500, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);

	    return wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver webDriver) {
	            return driver.findElement(locator);
	        }
	    });
	}*/


}






/*// Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(15, TimeUnit.SECONDS)
	       .pollingEvery(3, TimeUnit.SECONDS)
	       .ignoring(NoSuchElementException.class);

	   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return driver.findElement(By.id("foo"));
	     }
	   });*/





/*public WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)

                .pollingEvery(5, TimeUnit.SECONDS)

        .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                }
        );
        return  foo;
    };*/

