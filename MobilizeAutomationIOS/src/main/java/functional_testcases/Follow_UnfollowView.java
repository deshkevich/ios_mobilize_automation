package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import Pages.Account_Page;
import Pages.Alert_Page;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;

public class Follow_UnfollowView {
	private WebElement row;
	private IOSDriver driver;
	private FrostPage frostpage;
	private HomePage homepage;
	private Account_Page accountpage;
	private ReadUserData readUserData;
	private LoginPage loginpage;
	private NewViewScreenPage newViewScreenPage;
	private CropPage cropPage;
	private static Alert_Page alertpage;
	@SuppressWarnings("unused")
	@Test
	public void followUnfollow() throws InterruptedException {
		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			frostpage = new FrostPage(driver);
			homepage = new HomePage(driver);
			accountpage = new Account_Page(driver);
			Thread.sleep(9000);
			readUserData = new ReadUserData();
			readUserData.start();
			loginpage = new LoginPage(driver);
			newViewScreenPage = new NewViewScreenPage(driver);
			cropPage = new CropPage(driver);
			alertpage = new Alert_Page(driver);
			System.out.println("***************************  Follow_UnfollowView **************************");

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
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}

			TimeUnit.SECONDS.sleep(6);

			// verify account button
			if (homepage.getaccountbtn() != null) {
				if (homepage.getaccountbtn().isDisplayed()) {
					homepage.getaccountbtn().click();
					TimeUnit.SECONDS.sleep(10);
					ATUReports.add("Clicked on account button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				} else {
					ATUReports.add("Account button is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				ATUReports.add("Account button is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		

			// Click on Devices
			if (accountpage.getdevicesTab() != null) {
				MobileElement Devices = accountpage.getdevicesTab();
				String tabTextThree = Devices.getAttribute("name");
				System.out.println(tabTextThree + "---tabTextThree--");
				if (Devices.isDisplayed()) {

					ATUReports.add(tabTextThree + " tab is Displayed and Clicked on devices tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Devices.click();
					TimeUnit.SECONDS.sleep(6);
					//Devices.click();
					TimeUnit.SECONDS.sleep(6);
				} else {
					ATUReports.add(tabTextThree + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			TimeUnit.SECONDS.sleep(6);
			
			
				// Click on view
				if (accountpage.getviewTab() != null) {
					MobileElement viewTab = accountpage.getviewTab();
					String tabTextOne = viewTab.getAttribute("name");
					System.out.println(tabTextOne + "--tabTextOne--");
					if (viewTab != null) {
						if (viewTab.isDisplayed()) {

							ATUReports.add(tabTextOne + " tab is Displayed and Clicked on view tab", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							viewTab.click();
							TimeUnit.SECONDS.sleep(10);
							//viewTab.click();

							// verify the following is displayed
							MobileElement following = accountpage.getfollowing();
							String subListText = following.getAttribute("name");// stText---");
							if (subListText.contains("Following")) {
								//following.click();
								TimeUnit.SECONDS.sleep(5);
								following.click();
								//TimeUnit.SECONDS.sleep(18);
								ATUReports.add(subListText + " Text is displayed same as expected", "Following",
										subListText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								ATUReports.add(
										"If Following users list is not displayed ,Following views are not displays any following users information ",
										LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								TimeUnit.SECONDS.sleep(6);
								 driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();								
									TimeUnit.SECONDS.sleep(15);
									//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
								
									ATUReports.add(
											"verified the Following  user view in current page it displays unfollow view button  in the view displayed in the Account screen",
											LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
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
									
									// Scroll to Edit settings option
									driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
										{
											put("element",
													((RemoteWebElement) driver.findElement(By.name("Unfollow View"))).getId());
										}
									});
									TimeUnit.SECONDS.sleep(2);
									// Click on edit settings.
									driver.findElement(By.name("Unfollow View")).click();
									TimeUnit.SECONDS.sleep(6);

									ATUReports.add(
											"Unfollow View icon element is visible in the screen and clicked on unfollow view icon to unfollow current view",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									TimeUnit.SECONDS.sleep(2);
								
								
								} else {
									ATUReports.add("Following users list is not displayed", LogAs.INFO,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

							} else {
								ATUReports.add("View  Text is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
					
						} else {
							ATUReports.add(tabTextOne + " tab is not Displayed", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					} else {
						ATUReports.add("View  button is not displayed", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
			System.out.println("*************************** ENDING - Follow_UnfollowView **************************");

		}catch(

	Exception e)
	{
		driver.resetApp();
		System.out.println("*************************** CATCH - Follow_UnfollowView **************************");
		TimeUnit.SECONDS.sleep(20);
		// TODO: handle exception
		e.printStackTrace();
	}

}

}
