package functional_testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.Read_Frost_Details;
import utility.Read_Irrigation_Details;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import Pages.CropPage;
import Pages.HomePage;
import Pages.IrrigationPage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Irrigation_verify_Alert {
	private IOSDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private IrrigationPage irrigationPage;
	private ReadUserData readUserData;
	private Read_Irrigation_Details readirrgation;
	private Read_Frost_Details read_frost_details;
	private CropPage croppage;

	@Test
	public void verify_alert_skipping_optional() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			irrigationPage = new IrrigationPage(driver);
			readirrgation = new Read_Irrigation_Details();
			readirrgation.start();
			readUserData = new ReadUserData();
			readUserData.start();
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			croppage = new CropPage(driver);

			System.out.println(
					"***************************** Irrigation_verify_Alert *****************************************");
			TimeUnit.SECONDS.sleep(10);
			ATUReports.add("Before launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("After launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			/*try {
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
			}*/

			TimeUnit.SECONDS.sleep(6);
			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Enter The verified text in the viewname text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
				ATUReports.add("Entered the value in the text box", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				newviewscreenpage.getviewNextBtn().click();
				Thread.sleep(9000);
			}

			// Scroll to Irrigation icon
			driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
				{
					put("element", ((RemoteWebElement) newviewscreenpage.getirrigation()).getId());
				}
			});
			Thread.sleep(3000);

			// Click on the Irrigation
			if (newviewscreenpage.getirrigation() != null) {
				newviewscreenpage.getirrigation().click();
			}
			Thread.sleep(2000);

			// verify the header text
			verify_Header();

			// Verify skip
			if (croppage.getskipBtn() != null) {
				if (croppage.getskipBtn().isDisplayed()) {
					ATUReports.add("Skip button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getskipBtn()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Skip button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
			} else {
				if (croppage.getnext_nxt_save_btn() != null) {
					if (croppage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						croppage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add(
								"Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * PRESSURE SENSOR
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// verify the optional text
			verify_Optionaltxt();

			// Verify skip
			if (croppage.getskipBtn() != null) {
				if (croppage.getskipBtn().isDisplayed()) {
					ATUReports.add("Skip button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getskipBtn()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Skip button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
			} else {
				if (croppage.getnext_nxt_save_btn() != null) {
					if (croppage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						croppage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add(
								"Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * FLOW METER SENSOR
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// verify the optional text
			verify_Optionaltxt();

			if (croppage.getskipBtn() != null) {
				if (croppage.getskipBtn().isDisplayed()) {
					ATUReports.add("Skip button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getskipBtn()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Skip button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
			} else {
				if (croppage.getnext_nxt_save_btn() != null) {
					if (croppage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						croppage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add(
								"Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * ET READING
			 ************************************************************************************************************/

			// verify the header text
			verify_Header();

			// verify the back button
			verify_Back_button();

			// verify the optional text
			verify_Optionaltxt();

			if (croppage.getskipBtn() != null) {
				if (croppage.getskipBtn().isDisplayed()) {
					ATUReports.add("Skip button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getskipBtn()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Skip button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);
						ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
			} else {
				if (croppage.getnext_nxt_save_btn() != null) {
					if (croppage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						croppage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add(
								"Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			TimeUnit.SECONDS.sleep(10);
			ATUReports.add("Cancel Adding Irrigation Alert is displayed in the screen and the same is asserted",
					"Cancel Adding Irrigation?", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Go Back button is displayed", "Go Back", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Continue button is displayed clicked on continue button", "Continue", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			if (irrigationPage.geterror_title() != null) {
				if (irrigationPage.geterror_title().isDisplayed()) {
					TimeUnit.SECONDS.sleep(2);
					String error_title = irrigationPage.geterror_title().getAttribute("name");

					if (error_title.contains("Cancel Adding Irrigation?")) {
						ATUReports.add(
								"Cancel Adding Irrigation Alert is displayed in the screen and the same is asserted",
								error_title, "Cancel Adding Irrigation?", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Cancel Adding Irrigation Alert is displayed wrong in the screen ", error_title,
								"Cancel Adding Irrigation?", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

				// Verify the Continue button is displayed and Click on Continue
				// button
				if (irrigationPage.getcontinuetxt() != null) {
					String continuetxt = irrigationPage.getcontinuetxt().getText();
					if (continuetxt.trim().equals("Continue")) {
						ATUReports.add("Continue button is displayed", continuetxt, "Continue", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Continue button is displayed wrong ", continuetxt, "Continue", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					// Click on Continue button
					// irrigationPage.getcontinuetxt().click();
				}

				// Verify the Go back button is displayed and Click on Go back
				// button
				if (irrigationPage.getgobacktxt() != null) {
					String back = irrigationPage.getgobacktxt().getText();
					if (back.trim().equals("Go Back")) {
						ATUReports.add("Go Back button is displayed", back, "Go Back", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						irrigationPage.getgobacktxt().click();
						TimeUnit.SECONDS.sleep(2);
					} else {
						ATUReports.add("Go Back button is displayed wrong ", back, "Go Back", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				
				}

			} else {
				ATUReports.add("Cancel Adding Irrigation Alert is not displayed in the screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			System.out.println(
					"***************************** verify_alert_skipping_optional *****************************************");

		} catch (Exception e) {
			System.out.println(
					"***************************** In Catch verify_alert_skipping_optional *****************************************");
			driver.resetApp();
			//driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			//System.out.println("*************************** CATCH -Frost skipping optional**************************");
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

	private void verify_Back_button() {

		// Verify the back button text
		String back_btn;
		try {
			back_btn = irrigationPage.getbackbtn().getAttribute("name");

			if (back_btn.isEmpty()) {
				ATUReports.add("Back button element is not visible", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				/* if (back_btn.equals("Back")) { */
				ATUReports.add("Back text is noticed in the screen ", "Back", back_btn, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				/*
				 * } else { ATUReports.add("Back is not observed in the screen "
				 * , back_btn, LogAs.FAILED, new CaptureScreen(
				 * ScreenshotOf.BROWSER_PAGE)); }
				 */
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void verify_require_text() { // Verify the required button text
	 * String required; try { required =
	 * irrigationPage.getrequiretxt().getText();
	 * 
	 * if (required.isEmpty()) { ATUReports.add(
	 * "Required element is not visible", null, LogAs.WARNING, new
	 * CaptureScreen( ScreenshotOf.BROWSER_PAGE));
	 * 
	 * } else { if (required.equals("Required")) { ATUReports.add(
	 * "Required text is noticed in the screen ", "Required", required,
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else {
	 * ATUReports.add( "Required text is not observed in the screen ", required,
	 * LogAs.FAILED, new CaptureScreen( ScreenshotOf.BROWSER_PAGE)); } } } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	private void verify_Header() {
		String editirrigation;
		try {
			editirrigation = irrigationPage.editirrigationtxt().getAttribute("name");

			if (editirrigation.isEmpty()) {
				ATUReports.add("Irrigation element is not avaialble in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else if (editirrigation.equals("Irrigation")) {
				ATUReports.add("Irrigation is noticed in the screen ", "Irrigation", editirrigation, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Irrigation is noticed in the screen ", editirrigation, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonNextButton2() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

	private void verify_Optionaltxt() {
		// Verify the Optional button text
		String Optional;
		try {
			// Verify the Optional button text
			if (irrigationPage.optionaltxt() != null) {
				Optional = irrigationPage.optionaltxt().getAttribute("name");
				if (Optional.isEmpty()) {
					ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (Optional.equals("Optional")) {
						ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Optional text is not observed in the screen ", Optional, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIASecureTextField[1]