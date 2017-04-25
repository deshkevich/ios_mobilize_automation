/*
package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.Alert_Page;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.Log;
import utility.ReadUserData;

public class View_sharing {

	*/
/**
	 * @throws InterruptedException
	 *//*

	private IOSDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private Alert_Page alertpage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private static FrostPage frostpage;

	@Test
	public void verifyViewSharing() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			alertpage = new Alert_Page(driver);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			frostpage = new FrostPage(driver);

			System.out.println("*************************** View_sharing **************************");

			ATUReports.add("Before launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// reset the application
			// Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("After launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			TimeUnit.SECONDS.sleep(6);
			// verify shared view list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(18);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (newviewscreen.getshareicon() != null && newviewscreen.getshareicon().isDisplayed()) {
						ATUReports.add("verified the share icon in the : " + i + " view displayed in the Home screen",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						break;
					} else {
						if (frostpage.gettempUnitsPageBackBtnName() != null) {
							if (frostpage.gettempUnitsPageBackBtnName().isDisplayed()) {
								ATUReports.add(
										"Back button is enabled in the in the current screen and clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								TouchAction action2 = new TouchAction(driver);
								action2.longPress(frostpage.gettempUnitsPageBackBtnName()).release().perform();
								TimeUnit.SECONDS.sleep(15);

							} else {
								ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} else {
							if (frostpage.gettempUnitsPageBackBtn() != null) {
								if (frostpage.gettempUnitsPageBackBtn().isEnabled()) {
									Thread.sleep(2000);
									frostpage.gettempUnitsPageBackBtn().click();
									Thread.sleep(2000);
									ATUReports.add(
											"Back button is enabled in the in the current screen and clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}

							}

						}
					}
				}
			}
			System.out.print("I am out of For loop");
			if (newviewscreen.getshareicon() != null) {
				newviewscreen.getshareicon().click();
				Thread.sleep(2000);
			} else {
				ATUReports.add("Share icon element is nt visible in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			TimeUnit.SECONDS.sleep(5);
			if (alertpage.getnofolwerstxt() != null) {
				String nofollower = alertpage.getnofolwerstxt().getAttribute("name");
				if (nofollower.isEmpty()) {
					ATUReports.add("Verify the Alert mesage text", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (nofollower.equals("No users have been invited yet.")) {
						ATUReports.add("No users have been invited yet. Alert message is displayed", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						// alertpage.getokbutton().click();
						// ATUReports.add("Clicked on the Ok button",
						// LogAs.PASSED, new
						// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						if (newviewscreen.getedit() != null) {
							if (newviewscreen.getedit().isEnabled()) {
								ATUReports.add("Edit button is enabled", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("Edit button is not enabled in not shared by user view", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
						}

					} else {
						ATUReports.add("Alert mesage  text text", "No users have been invited yet.", nofollower,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			} else {
				ATUReports.add("No Alert message is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);
			// Verify shared view
			if (newviewscreen.getedit() != null) {
				if (newviewscreen.getedit().isEnabled()) {
					ATUReports.add("Edit button is enabled in shared view", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Edit button is not enabled", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			// Enter some value in the text box
			if (newviewscreen.getemaileditext() != null) {
				TimeUnit.SECONDS.sleep(5);
				newviewscreen.getemaileditext().setValue(readUserData.usernmaeTwo);
				TimeUnit.SECONDS.sleep(20);
				ATUReports.add("Entered user name in text box ", readUserData.usernmaeTwo, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// click on return button
				if ((WebElement) driver.findElementByAccessibilityId("Search") != null) {
					WebElement doneBtn2f = (WebElement) driver.findElementByAccessibilityId("Search");
					TimeUnit.SECONDS.sleep(10);
					TouchAction action1a = new TouchAction(driver);
					action1a.longPress(doneBtn2f).release().perform();
					TimeUnit.SECONDS.sleep(10);
					ATUReports.add("Tap on serach in keyboard", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					WebElement doneBtn2w = (WebElement) driver.findElementByAccessibilityId("Search");
					TimeUnit.SECONDS.sleep(10);
					TouchAction action16 = new TouchAction(driver);
					action16.longPress(doneBtn2w).release().perform();
					TimeUnit.SECONDS.sleep(10);
					ATUReports.add("Tap on serach in keyboard", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				if (newviewscreen.getsharedviewsList() != null) {
					TimeUnit.SECONDS.sleep(8);
					ATUReports.add("shared users list is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// newviewscreen.getsharedviewsList().click();

					newviewscreen.getsharedviewsList().click();
					TimeUnit.SECONDS.sleep(15);

					// driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]").click();
					ATUReports.add("Clicked on the specific user name from shared users list ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					newviewscreen.getshareBtn().click();
					TimeUnit.SECONDS.sleep(15);

					
					// driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]").click();
					ATUReports.add("Clicked on the Share button on alert", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TimeUnit.SECONDS.sleep(3);
					// driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]").click();
					ATUReports.add("View Shared with the client successfully", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("shared users list is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				Log.error("Edit button element is not displayed");
			}

			System.out.println("*************************** ENDING - View_sharing **************************");

		} catch (NullPointerException e) {
			System.out.println("*************************** CATCH - View_sharing **************************");
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			System.out.println("The row element is not displayed");
			// ATUReports.add("First Table Row is not displayed",
			// LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
			Log.error("Table Row is not dispalyed");
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

// new WebDriverWait(driver, 2).until(ExpectedConditions.alertIsPresent());
*/
