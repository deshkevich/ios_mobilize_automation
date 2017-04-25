package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.ReadViewName;
import utility.Read_Frost_Details;

public class Verify_Location_Alert_Message {

	private IOSDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private ReadViewName readviewname;
	private Alert_Page alertpage;
	private ReadUserData readUserData;
	@SuppressWarnings("unused")
	private LoginPage loginpage;
	private Read_Frost_Details read_frost_details;

	@SuppressWarnings("rawtypes")
	@Test
	public void Verify_Location_Alert_Message_firstTime() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			readviewname = new ReadViewName();
			loginpage = new LoginPage(driver);
			alertpage = new Alert_Page(driver);
			readviewname = new ReadViewName();
			readviewname.start();
			readUserData = new ReadUserData();
			readUserData.start();
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();

			System.out.println("*************************** Verify_Location_Alert_Message **************************");

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

			TimeUnit.SECONDS.sleep(8);
			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();// ----using xpath here
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				TimeUnit.SECONDS.sleep(5);
			}

			// Enter The verified text in the view name text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
				ATUReports.add("Entered view name in text box", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				TimeUnit.SECONDS.sleep(4);
			}

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				newviewscreenpage.getviewNextBtn().click();
				ATUReports.add("Clicked on add next button in view name screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				TimeUnit.SECONDS.sleep(5);
			}

			// Verify notification tutorial box
			if (alertpage.getnotificationTutorialBoxTxt() != null) {
				ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),
						alertpage.getcreateViewTutorialNextBtn());

				// click on close icon
				if (alertpage.getcreateViewTutorialNextBtn() != null) {
					alertpage.getcreateViewCloseIcon().click();
					ATUReports.add("Clicked on close icon in Notification view tutorial ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				ATUReports.add("Mobilize Notification  tutorial screen  is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Location symbol of GPS information.
			String gps = newviewscreenpage.getaddgpstxt().getText();
			if (alertpage.getgpsInformationHeading() != null) {
				if (gps.isEmpty()) {
					ATUReports.add("Verify the Add GPS informationr text is displayed in the screen", gps, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (alertpage.getgpsInformationHeading().isDisplayed()) {
						// Click on Add GPS information location symbol.
						alertpage.getgpsInformationHeading().click();
						TimeUnit.SECONDS.sleep(5);

						ATUReports.add(
								"Verify the Add GPS information text is displayed in the screen cLicked on location symbol",
								gps, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Verify the Add GPS information text is not displayed in the screen", gps,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				// Verify the alert message
				Thread.sleep(5000);
				if (alertpage.getgpsAllowBtn() != null) {
					if (alertpage.getgpsAllowBtn().isDisplayed()) {
						String allowText = alertpage.getgpsAllowBtn().getAttribute("name");
						// System.out.println(allowText+"--1 text--");
						ATUReports.add("The Allow with  location alert message is dispalyed with text ", "Allow",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						// alertpage.getgpsAllowBtn().click();
						Thread.sleep(2000);
						TouchAction action2hk = new TouchAction(driver);
						action2hk.longPress(alertpage.getgpsAllowBtn()).release().perform();
						TimeUnit.SECONDS.sleep(10);
					} else {
						if (alertpage.getgpsAllowBtn().isDisplayed()) {
							alertpage.getgpsAllowBtn().click();
							TimeUnit.SECONDS.sleep(8);
						}
					}

				} else {
					ATUReports.add(
							"The Allow with location alert message is not dispalyed if location is enabled in current Device  settings.",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			System.out.println(
					"*************************** ENDING - Verify_Location_Alert_Message **************************");

		} catch (Exception e) {
			System.out.println(
					"*************************** CATCH - Verify_Location_Alert_Message **************************");
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}

	}

}
