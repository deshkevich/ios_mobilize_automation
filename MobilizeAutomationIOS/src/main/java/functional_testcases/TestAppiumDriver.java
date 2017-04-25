package functional_testcases;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Alert_Page;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.IrrigationPage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.SignUpPage;
import Pages.WelcomePage;

public class TestAppiumDriver {
	public static WebDriverWait mywait;
	private static AppiumDriver driver;
	

	public static WebDriverWait getAppiumDriverWait() {
		return mywait;
	}

	public void setWebDriverWait(WebDriverWait webDriverwait) {
		TestAppiumDriver.mywait = webDriverwait;
	}

	public static AppiumDriver getAppiumDriver() {
		//System.out.println("from Model class"+driver);
		return driver;
	}

	public void setAppiumDriver(AppiumDriver driver) {
		TestAppiumDriver.driver = driver;
	}

}

