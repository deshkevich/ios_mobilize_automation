package functional_testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import Pages.Alert_Page;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;

public class Delete_frost {

	/**
	 * @throws InterruptedException
	 */
	private NewViewScreenPage newviewscreenpage;
	private IOSDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private CropPage cropPage;
	private FrostPage frostpage;
	private static Alert_Page alertpage;
	// @SuppressWarnings("serial")

	@Test
	public void delete_frost() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			new Alert_Page(driver);
			loginpage = new LoginPage(driver);
			newscreenpage = new NewViewScreenPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			newviewscreenpage = new NewViewScreenPage(driver);
			cropPage = new CropPage(driver);
			frostpage = new FrostPage(driver);
			alertpage = new Alert_Page(driver);

			System.out.println("***************************Staring- Delete_frost **************************");

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
			// TimeUnit.SECONDS.sleep(6);
			
			

			TimeUnit.SECONDS.sleep(6);
			// Click on particular view in list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(25);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify notification tutorial box
					if (alertpage.getnotificationTutorialBoxTxt() != null) {
						ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),
								alertpage.getcreateViewTutorialNextBtn());

						// click on close icon
						if (alertpage.getcreateViewCloseIcon() != null) {
							alertpage.getcreateViewCloseIcon().click();
							ATUReports.add("Clicked on close icon in create view tutorial ", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}

					}
					if (newviewscreen.getSettings() != null && newviewscreen.getSettings().isDisplayed()) {
						newviewscreen.getSettings().click();
						ATUReports.add(
								"verified the Frost Settings icon in the : " + i + " view displayed in the Home screen",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						TimeUnit.SECONDS.sleep(10);
						break;
					} else {
						if (frostpage.gettempUnitsPageBackBtnName() != null) {
							if (frostpage.gettempUnitsPageBackBtnName().isEnabled()) {
								ATUReports.add(
										"Back button is enabled in the in the current screen and clicked on the back button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								TimeUnit.SECONDS.sleep(8);
								TouchAction action2 = new TouchAction(driver);
								action2.longPress(frostpage.gettempUnitsPageBackBtnName()).release().perform();
								TimeUnit.SECONDS.sleep(20);

							} else {
								ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} else {
							if (frostpage.gettempUnitsPageBackBtn() != null) {
								if (frostpage.gettempUnitsPageBackBtn().isEnabled()) {
									TimeUnit.SECONDS.sleep(5);
									frostpage.gettempUnitsPageBackBtn().click();
									TimeUnit.SECONDS.sleep(5);
									ATUReports.add(
											"Back button is enabled in the in the current screen and clicked on the back button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {

									ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

						}

					}

				}
			}

			System.out.print("I am out of For loop");
			String viewtitle = newscreenpage.getviewReportTitleText().getAttribute("value");
			TimeUnit.SECONDS.sleep(2);

			// Click on edit settings.
			MobileElement editsettings = newscreenpage.geteditsettings();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("EditSettings Button is dispalyed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TimeUnit.SECONDS.sleep(3);

				} else {
					ATUReports.add("EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				// Scroll to Edit settings option
				driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
					{
						put("element", ((RemoteWebElement) driver.findElement(By.name("Delete"))).getId());
					}
				});
				TimeUnit.SECONDS.sleep(2);

				// Click on delete button
				driver.findElement(By.name("Delete")).click();
				TimeUnit.SECONDS.sleep(2);

				ATUReports.add("Delete Button is dispalyed clicked on delete button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("The Alert messge is same as expected",
						"Are you sure you want to delete frost from view '" + viewtitle + "'?", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Click on delete button
				if (driver.findElement(By.name("Delete")) != null) {
					TimeUnit.SECONDS.sleep(6);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]")).release().perform();
					TimeUnit.SECONDS.sleep(10);
					//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]").click();
					TimeUnit.SECONDS.sleep(10);
					ATUReports.add("Click on Delete view delete button on alert ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				ATUReports.add("Edit settings  element is not visible in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		} catch (InterruptedException i) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			i.printStackTrace();
		}
		System.out.println("***************************ENDING- Delete_frost **************************");

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

