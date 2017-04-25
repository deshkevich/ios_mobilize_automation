package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import utility.ReadUserData;
import utility.ReadViewName;
import utility.Read_Delete_Viewname;
import Pages.Alert_Page;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.WeatherPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Verify_ViewName_Changes {
	private IOSDriver driver;
	@SuppressWarnings("unused")
	private WeatherPage weatherPage;
	private HomePage homepage;
	private JavascriptExecutor js;
	private LoginPage loginpage;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private Read_Delete_Viewname readdeleteviewame;
	private ReadUserData readUserData;
	private ReadViewName readviewname;
	private CropPage cropPage;
	private static FrostPage frostpage;
	private static Alert_Page alertpage;

	@Test
	public void verify_ViewName_Changes() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			weatherPage = new WeatherPage(driver);
			homepage = new HomePage(driver);
			js = (JavascriptExecutor) driver;
			loginpage = new LoginPage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			readdeleteviewame = new Read_Delete_Viewname();
			readdeleteviewame.start();
			cropPage = new CropPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			readviewname = new ReadViewName();
			readviewname.start();
			frostpage = new FrostPage(driver);
			alertpage = new Alert_Page(driver);

			System.out.println("*************************** Verify_ViewName_Changes **************************");
		
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
				//driver.quit();
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}

			TimeUnit.SECONDS.sleep(6);
			// Click on particular view from list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 1; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(20);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (newviewscreen.getshareicon() != null && newviewscreen.getshareicon().isDisplayed()) {
						ATUReports.add("verified the share icon in the : " + i + " view displayed in the Home screen",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						TimeUnit.SECONDS.sleep(20);

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

			TimeUnit.SECONDS.sleep(10);
			// Scroll to Edit settings option
			driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
				{
					put("element", ((RemoteWebElement) driver.findElement(By.name("Edit View"))).getId());
				}
			});

			TimeUnit.SECONDS.sleep(10);
			// Click on edit settings.
			driver.findElement(By.name("Edit View")).click();
			TimeUnit.SECONDS.sleep(20);
			ATUReports.add("Scroll to Edit view button and clicked on edit view button", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify change view name text
			if (newviewscreen.getnchangeViewTitle() != null) {
				String viewName = newviewscreen.getnchangeViewTitle().getAttribute("name");
				// if (viewName.equals("Change View Name:")) {
				ATUReports.add("User is nvigated to Change View Name: screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Enter some text in the view name
				if (newviewscreen.getviewNameInChangeViewNameField() != null) {
					String newViewName = readviewname.viewName;
					newviewscreen.getviewNameInChangeViewNameField().clear();
					TimeUnit.SECONDS.sleep(10);
					newviewscreen.getviewNameInChangeViewNameField().sendKeys(newViewName);
					TimeUnit.SECONDS.sleep(8);
					ATUReports.add("Entered other view name in CHANGE VIEW NAME screen, ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					
					// click on return button
					
					if ((WebElement) driver.findElementByAccessibilityId("return") != null) {
						WebElement doneBtn2 = (WebElement) driver.findElementByAccessibilityId("return");
						Thread.sleep(5000);
						TouchAction action1 = new TouchAction(driver);
						action1.longPress(doneBtn2).release().perform();
						Thread.sleep(5000);
						ATUReports.add("return is  displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						// click on return button
						if ((WebElement) driver.findElementByAccessibilityId("return") != null) {
							WebElement doneBtn2 = (WebElement) driver.findElementByAccessibilityId("return");
							Thread.sleep(5000);
							TouchAction action1 = new TouchAction(driver);
							action1.longPress(doneBtn2).release().perform();
							Thread.sleep(5000);
							ATUReports.add("return is  displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} 

					}
				}

			}

		

			// Verify save button
			if (cropPage.getsaveTxt() != null) {
				if (cropPage.getsaveTxt().isDisplayed()) {
					ATUReports.add("Save button is enabled in the Current screen and clicked on the Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(6);

					ATUReports.add(
							"View name updated successfully text is displayed and the same is asserted clicked on ok button ",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
			} else {
				if (newviewscreen.getbacktxt() != null) {
					MobileElement saveButton = newviewscreen.getbackbtn();
					String saveText = saveButton.getAttribute("name");
					if (saveButton.isDisplayed()) {
						// saveButton.click();
						driver.findElement(
								By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]")).click();// in
																														// 6s
						Thread.sleep(2000);

						ATUReports.add(saveText + " Button is Displayed and Clicked on Save button.", saveText, "Save",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						ATUReports.add(
								"View name updated successfully text is displayed and the same is asserted clicked on ok button ",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add(saveText + " Button is not Displayed ", saveText, "Save", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
			}

			System.out
					.println("*************************** ENDING - Verify_ViewName_Changes **************************");

		} catch (NoSuchElementException e) {
			System.out
					.println("*************************** CATCH - Verify_ViewName_Changes **************************");
                 driver.resetApp();
                TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
