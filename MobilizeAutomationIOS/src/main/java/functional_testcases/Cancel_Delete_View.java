package functional_testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import utility.ReadUserData;
import utility.Read_Irrigation_Details;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import Pages.Alert_Page;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;

public class Cancel_Delete_View {
	private IOSDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private JavascriptExecutor js;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private ReadUserData readUserData;
	private static Alert_Page alertpage;
	// private ReadUserData readUserData ;
	private FrostPage frostpage;

	@SuppressWarnings({ "unchecked", "serial" })
	@Test
	public void delete_view() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			js = (JavascriptExecutor) driver;
			newviewscreen = new NewViewScreenPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			frostpage = new FrostPage(driver);
			alertpage = new Alert_Page(driver);

			System.out.println("***************************Staring- Cancel_Delete_View **************************");

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
								TimeUnit.SECONDS.sleep(25);
								ATUReports.add("After The Launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} catch (Exception e) {
							ATUReports.add("In The Catch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							// reset the application -
							// close the application
							//driver.quit();
							// Launch App
							driver.resetApp();
							TimeUnit.SECONDS.sleep(25);
						}
						//TimeUnit.SECONDS.sleep(6);	

			//TimeUnit.SECONDS.sleep(15);
			// Click on particular view in list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 1; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(25);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TimeUnit.SECONDS.sleep(5);
					
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

					if (newviewscreen.getshareicon() != null && newviewscreen.getshareicon().isDisplayed()) {
						ATUReports.add("verified the share icon in the : " + i + " view displayed in the Home screen",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						System.out.print("I am out of For loop");
						TimeUnit.SECONDS.sleep(10);

						// Scroll to Edit settings option
						driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
							{
								put("element", ((RemoteWebElement) driver.findElement(By.name("Edit View"))).getId());
							}
						});
						TimeUnit.SECONDS.sleep(8);
						
						// Click on edit settings.
						driver.findElement(By.name("Edit View")).click();
						TimeUnit.SECONDS.sleep(10);
						break;
					} else {
						ATUReports.add("Share icon element is not visible in the screen", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
					Thread.sleep(2000);
				}
			}
		
			

			// Tap on delete
			if (newviewscreen.getdeleteButton() != null) {
				String deleteText = newviewscreen.getdeleteButton().getAttribute("name");

				ATUReports.add("Tab on delete button. ", deleteText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				newviewscreen.getdeleteButton().click();
				TimeUnit.SECONDS.sleep(20);

				// verify the alert message text
				if (newviewscreen.getdeleteViewAlertMessage() != null) {
					String error = newviewscreen.getdeleteViewAlertMessage().getAttribute("name");

					String viewname = newviewscreen.getviewNameInChangeViewNameField().getAttribute("value");

					if (error.equals("Are you sure you want to delete view '" + viewname + "'?")) {
						ATUReports.add("Alert is displayed and the same is asserted", error,
								"Are you sure you want to delete view '" + viewname + "'?", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Alert is not displayed and the same is asserted", error,
								"Are you sure you want to delete view '" + viewname + "'?", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
				TimeUnit.SECONDS.sleep(10);

				// verify cancel and delete buttons
				if (newviewscreen.getdeleteViewCancelBtn() != null) {
					String cancel = newviewscreen.getdeleteViewCancelBtn().getText();

					if (cancel.contains("Cancel")) {
						ATUReports.add("Cancel is displayed and the same is asserted", cancel, "Cancel", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Cancel is not displayed and the same is asserted", cancel, "Cancel",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}
				TimeUnit.SECONDS.sleep(5);

				// verify cancel and delete buttons
				String delete = newviewscreen.getdeleteViewDeleteBtn().getText();
				if (delete.contains("Delete")) {
					ATUReports.add("Delete is displayed and the same is asserted", delete, "Delete", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Delete is not displayed and the same is asserted", delete, "Delete", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				// Click on Cancel button
				newviewscreen.getdeleteViewCancelBtn().click();
				TimeUnit.SECONDS.sleep(7);

				// Verify change view name text
				String viewName = newviewscreen.getnchangeViewTitle().getAttribute("name");
				if (viewName.contains("Change View Name:")) {
					ATUReports.add("User is in the same Change View Name: screen ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("User is not in the same Change View Name: screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				TimeUnit.SECONDS.sleep(10);

				// Tap on Delete
				newviewscreen.getdeleteButton().click();
				TimeUnit.SECONDS.sleep(12);
				ATUReports.add("Click on change view delete button ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


				// Click on delete button
				if(newviewscreen.getdeleteButton()!=null){
				TimeUnit.SECONDS.sleep(10);			
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]")).release().perform();
				//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]").click();
				TimeUnit.SECONDS.sleep(10);
				ATUReports.add("Click on Delete view delete button on alert ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				ATUReports.add("Delete button is not displayed ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		} catch (Exception e) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
		System.out.println("***************************ENDING- Cancel_Delete_View **************************");

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



