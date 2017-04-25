package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Search {

	private IOSDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private WebElement row;

	@Test
	public void Verify_the_search_keyword_dismissed() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();

			// Reset app
			try {
				if (homepage.gethomebutton() != null) {
					if (homepage.gethomebutton().isDisplayed()) {
						ATUReports.add("Home button is displayed and enabled in the home screen ", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						homepage.gethomebutton().click();
						TimeUnit.SECONDS.sleep(25);

					}
				} else {
					ATUReports.add("Home button is not displayed in current screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					ATUReports.add("Before The close", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// reset the application -
					driver.resetApp();
					TimeUnit.SECONDS.sleep(30);
					ATUReports.add("After The Launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} catch (Exception e) {
				ATUReports.add("In The Catch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// reset the application -
				// close the application
				// driver.quit();
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			TimeUnit.SECONDS.sleep(6);

			// Verify the user is in Home screen or not
			if (driver.getPageSource().contains("Search")) {
				ATUReports.add("Search placeholder text is Present in the screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Search is not Present in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Search box and enter keyword to search view.
			homepage.getsearchtxtfield().sendKeys(readUserData.searchData);

			System.out.println(readUserData.searchData + "---readUserData.search--");
			ATUReports.add("Tab on search box and " + readUserData.searchData + " as given as search keyword",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(7000);
			
			
			// Clear the search field
			if((homepage.getsearchtxtfield()!=null)){
			ATUReports.add("Clear button is displayed in the search field", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			homepage.getclearicon().click();
			Thread.sleep(8000);
			ATUReports.add("Cleared the search result by tapping on X button in the search field",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			if (homepage.getsearchtxtfield().isDisplayed()) {
				Thread.sleep(4000);

				ATUReports.add(
						"No Search keyword is displayed in the search field after performing clear operation.",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			} else {
				ATUReports.add(
						"Search keyword is still displayed in the search fieldafter performing clear operation",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			}
			           // click on return button
						if((WebElement) driver.findElementByAccessibilityId("return")!=null){
							WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("return");
							Thread.sleep(5000);
							TouchAction action2 = new TouchAction(driver);
							action2.longPress(doneBtnrr).release().perform();
							Thread.sleep(6000);
							//System.out.println("Clicked on done button");
							ATUReports.add("Clicked on return button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}else{
							WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("return");
							Thread.sleep(5000);
							TouchAction action2 = new TouchAction(driver);
							action2.longPress(doneBtn).release().perform();
							Thread.sleep(6000);
							//System.out.println("Clicked on done button");
							ATUReports.add("Clicked on return button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

			// Verify the search text is in Home screen or not
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					ATUReports.add("Entered data is dispalyed from the search result", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(8000);
						break;
					
							
					}

				} // for loop
	
			

		} catch (Exception e) {
			// driver.resetApp();
			// TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}
}
