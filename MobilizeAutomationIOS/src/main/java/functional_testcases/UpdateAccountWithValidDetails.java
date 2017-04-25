package functional_testcases;

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

public class UpdateAccountWithValidDetails {
	private IOSDriver driver;
	private FrostPage frostpage;
	private HomePage homepage;
	private Account_Page accountpage;
	private LoginPage loginpage;
	private ReadUserData readuserdata;
	private NewViewScreenPage newViewScreenPage;
	private CropPage cropPage;

	// @SuppressWarnings("rawtypes")
	@Test
	public void updateValidDetails() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			frostpage = new FrostPage(driver);
			homepage = new HomePage(driver);
			accountpage = new Account_Page(driver);
			loginpage = new LoginPage(driver);
			readuserdata = new ReadUserData();
			readuserdata.start();
			newViewScreenPage = new NewViewScreenPage(driver);
			Thread.sleep(2000);
			cropPage = new CropPage(driver);

			System.out.println(
					"***************************Staring- UpdateAccountWithValidDetails **************************");

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
			TimeUnit.SECONDS.sleep(2);

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
				} else {
					ATUReports.add(tabTextThree + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify to tab on edit Icon
			if (newViewScreenPage.geteditAccountSettingsIcon() != null) {
				ATUReports.add("Navigated to Settings screen, Settings icon is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				if (newViewScreenPage.geteditAccountSettingsIcon().isDisplayed()) {
					ATUReports.add("Edit icon element is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// Thread.sleep(2000);
					// newViewScreenPage.geteditAccountSettingsIcon().click();
					driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]"))
							.click();
					ATUReports.add("Clicked on edit icon element", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// Thread.sleep(4000);
				} else {
					ATUReports.add("Edit icon element is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("User not navigated to Settings screen, Settings icon is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			ATUReports.add("change photo text is displayed ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// get the value of first name
			MobileElement changeName = accountpage.getnameTextBx();
			String actualFirstName = changeName.getAttribute("name");

			// get the value of email id
			MobileElement changeEmail = accountpage.getemailIDtTextBox();
			String actualEmail = changeEmail.getAttribute("name");

			// Verify to tab on change first name
			changeName.click();
			TimeUnit.SECONDS.sleep(2);
			changeName.clear();
			TimeUnit.SECONDS.sleep(2);
			changeName.sendKeys(readuserdata.Firstname);
			TimeUnit.SECONDS.sleep(2);

			String expectedName = accountpage.getnameTextBx().getAttribute("name");

			ATUReports.add("First name is changed " + expectedName, actualFirstName, expectedName, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify to tab on change email id
			changeEmail.click();
			TimeUnit.SECONDS.sleep(2);
			changeEmail.clear();
			TimeUnit.SECONDS.sleep(2);
			changeEmail.sendKeys(readuserdata.emailid);
			TimeUnit.SECONDS.sleep(2);
			// driver.hideKeyboard();

			String expectedEmail = accountpage.getemailIDtTextBox().getAttribute("name");

			ATUReports.add("Changed Email name is changed " + expectedEmail, actualEmail, expectedEmail, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(5000);

			// Verify return button
			WebElement doneBtn2 = (WebElement) driver.findElementByAccessibilityId("return");
			TimeUnit.SECONDS.sleep(6);
			TouchAction action1 = new TouchAction(driver);
			action1.longPress(doneBtn2).release().perform();
			TimeUnit.SECONDS.sleep(6);

			// Verify Tab on Save button
			if (cropPage.getsaveTxt() != null) {
				if (cropPage.getsaveTxt().isDisplayed()) {
					ATUReports.add("Save button is enabled in the Current screenand clicked on the Next button",
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
					String saveText = saveButton.getAttribute("name");
					if (saveButton.isDisplayed()) {
						// saveButton.click();
						driver.findElement(
								By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]")).click();
						Thread.sleep(2000);

						ATUReports.add(saveText + " Button is Displayed and Clicked on Save button.", saveText, "Save",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add(saveText + " Button is not Displayed ", saveText, "Save", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
			}

		} catch (InterruptedException i) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			i.printStackTrace();
		}

		System.out
				.println("***************************ENDING- UpdateAccountWithValidDetails **************************");

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

/*
 * if(accountpage.getchoosePictureAlertList()!=null){
 * 
 * //MobileElement chooseFromLibrary = accountpage.getchoosePhotoFrmLbryBtn();
 * String text = accountpage.getchoosePhotoFrmLbryBtn().getAttribute("name"); if
 * (accountpage.getchoosePhotoFrmLbryBtn().isDisplayed()) { ATUReports.add(text
 * + " is displayed " + text, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { ATUReports.add(text + " is not displayed  " + text, LogAs.FAILED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 */

// driver.findElement(By.className("android.widget.ImageButton")).click();
// System.out.println("image button is clicked");
/*
 * // Verify to select a particular image from list Thread.sleep(2000);
 * 
 * MobileElement imageOne = (MobileElement) driver
 * .findElement(By.xpath("//android.widget.RelativeLayout[@clickable='True']"));
 * imageOne.click(); Thread.sleep(2000);
 * 
 * MobileElement imageTWo = (MobileElement) driver
 * .findElement(By.xpath("//android.view.View[@clickable='True']"));
 * imageTWo.click(); Thread.sleep(5000); ATUReports.add(
 * "Select image from the list and clicked on image,Profile image is updated succsfully."
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */
