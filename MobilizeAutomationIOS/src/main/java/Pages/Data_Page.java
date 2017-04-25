package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Data_Page {


	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public Data_Page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructo "+ driver);
	}
	private static MobileElement element = null;

	By backbtntxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	By backbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	By header = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
	By edit = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	By viewdatabtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	By readData = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");


	public  MobileElement getbackbtntxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backbtntxt);

		}catch(NoSuchElementException e){
			ATUReports.add("BackButtonText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButtonText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getheader() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(header);

		}catch(NoSuchElementException e){
			ATUReports.add("HeaderText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HeaderText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getbackbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("BackButtonText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButtonText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

	public  MobileElement getviewdatabtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(viewdatabtn);

		}catch(NoSuchElementException e){
			ATUReports.add("ViewDataButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ViewDataButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getreadData() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(readData);

		}catch(NoSuchElementException e){
			ATUReports.add("ReadData element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ReadData element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
