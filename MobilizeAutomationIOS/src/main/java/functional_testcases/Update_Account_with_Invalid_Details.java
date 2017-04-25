package functional_testcases;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.Account_Page;
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

public class Update_Account_with_Invalid_Details {

	private IOSDriver driver;
	private FrostPage frostpage;
	private HomePage homepage;
	private Account_Page accountpage;
	private LoginPage loginpage;
	private ReadUserData readuserdata;
	private NewViewScreenPage newViewScreenPage;
	private CropPage cropPage;

	@Test
	public void UpdateAccountWithInvaliDetails() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			frostpage = new FrostPage(driver);
			homepage = new HomePage(driver);
			accountpage = new Account_Page(driver);
			loginpage = new LoginPage(driver);
			readuserdata = new ReadUserData();
			readuserdata.start();
			newViewScreenPage = new NewViewScreenPage(driver);
			cropPage = new CropPage(driver);

			System.out.println(
					"***************************Staring- Update_Account_with_Invalid_Details **************************");
			TimeUnit.SECONDS.sleep(8);
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
				// driver.quit();
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			// TimeUnit.SECONDS.sleep(6);

			TimeUnit.SECONDS.sleep(18);
			// verify account button
			if (homepage.getaccountbtn() != null) {
				if (homepage.getaccountbtn().isDisplayed()) {
					homepage.getaccountbtn().click();
					ATUReports.add("Clicked on account button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(10);
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

					ATUReports.add(tabTextThree + " tab is Displayed and Clicked on following tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Devices.click();
					Devices.click();
					TimeUnit.SECONDS.sleep(1);
				} else {
					ATUReports.add(tabTextThree + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify to tab on edit Icon
			if (newViewScreenPage.geteditAccountSettingsIcon() != null) {
				ATUReports.add("Navigated to Settings screen, Settings icon is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				if (newViewScreenPage.geteditAccountSettingsIcon() != null
						&& newViewScreenPage.geteditAccountSettingsIcon().isDisplayed()) {
					ATUReports.add("Edit icon element is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]"))
							.click();
					// newViewScreenPage.geteditAccountSettingsIcon().click();
					TimeUnit.SECONDS.sleep(4);

				} else {
					ATUReports.add("Edit icon element is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("User not navigated to Settings screen, Settings icon is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			TimeUnit.SECONDS.sleep(4);

			// get the value of first name
			// MobileElement changeName = accountpage.getnameTextBx();
			// String actualFirstName =
			// accountpage.getnameTextBx().getAttribute("name");

			// get the value of email id
			MobileElement changeEmail = accountpage.getemailIDtTextBox();
			String actualEmail = accountpage.getemailIDtTextBox().getAttribute("name");

			// Verify to tab on change and enter in valid email id in email id
			// tetx box
			changeEmail.click();
			Thread.sleep(2000);
			changeEmail.clear();
			Thread.sleep(2000);
			changeEmail.sendKeys(readuserdata.InvalidEmail);
			Thread.sleep(2000);

			String expectedEmail = accountpage.getemailIDtTextBox().getAttribute("name");

			ATUReports.add("Entered invalid email id in text box " + expectedEmail, actualEmail, expectedEmail,
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// String expectedEmailText= changeEmail.getText();
			if (expectedEmail.contains(readuserdata.InvalidEmail)) {
				ATUReports.add("Entered invalid email id is same as expected" + expectedEmail, actualEmail,
						expectedEmail, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {

				ATUReports.add("Entered invalid email id is not same as expected " + expectedEmail, actualEmail,
						expectedEmail, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				Thread.sleep(2000);
			}

			// Verify return button
			WebElement doneBtn2 = (WebElement) driver.findElementByAccessibilityId("return");
			Thread.sleep(6000);
			TouchAction action1 = new TouchAction(driver);
			action1.longPress(doneBtn2).release().perform();
			Thread.sleep(8000);

		
			ATUReports.add("Profile picture is displayed  ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add("change photo text is displayed ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify Tab on Save button
			if (cropPage.getsaveTxt() != null) {
				if (cropPage.getsaveTxt().isDisplayed()) {
					ATUReports.add("Save button is enabled in the Current screenand clicked on the Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TimeUnit.SECONDS.sleep(8);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(6);

				} else {
					ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
			} else {
				if (newViewScreenPage.getbackbtn() != null) {
					MobileElement saveButton = newViewScreenPage.getbackbtn();
					// String saveText = saveButton.getAttribute("name");
					if (saveButton.isDisplayed()) {

						driver.findElement(
								By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]")).click();
						// saveButton.click();
						Thread.sleep(2000);
						ATUReports.add("Save Button is Displayed and Clicked on Save button.", "Save", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add("Save Button is not Displayed ", "Save", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(2000);

				}
			}

			// Verify alert message
			if (newViewScreenPage.getinvalidEmailAlert() != null) {
				String emailText = newViewScreenPage.getinvalidEmailAlertText().getAttribute("name");
				if (newViewScreenPage.getinvalidEmailAlertText().isDisplayed()) {
					ATUReports.add(emailText + " alert is  Displayed ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					newViewScreenPage.getsuccessOkBtn().click();
					ATUReports.add("Clicked on ok button ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					newViewScreenPage.getbacktxt().click();
					// Thread.sleep(2000);
					Thread.sleep(2000);
					ATUReports.add("Clicked on back button ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("NO Alert is dispalyed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		} catch (InterruptedException i) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			i.printStackTrace();
		}
		System.out.println(
				"***************************ENDING- Update_Account_with_Invalid_Details **************************");

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
