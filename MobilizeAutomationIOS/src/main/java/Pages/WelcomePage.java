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

public class WelcomePage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();


	public WelcomePage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By welcometext = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]");

	//WELCOME, Create your first view to begin mobilizing.
	public  MobileElement getwelcometext() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(welcometext)));

		}catch(NoSuchElementException e){
			ATUReports.add("WelcomeText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("WelcomeText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
