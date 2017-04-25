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

public class Settings_page {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();


	public Settings_page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By Frequenty_Asked_Questions = By.name("Frequenty Asked Questions");
	By Change_Password =By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]"); //By.name("Change Password");

	public  MobileElement getFrequenty_Asked_Questions() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(Frequenty_Asked_Questions)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrequentyAskedQuestions element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrequentyAskedQuestions element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getChange_Password() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(Change_Password)));

		}catch(NoSuchElementException e){
			ATUReports.add("ChangePassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ChangePassword element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
