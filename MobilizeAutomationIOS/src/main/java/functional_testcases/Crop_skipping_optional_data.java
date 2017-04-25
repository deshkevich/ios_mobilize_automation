package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import utility.Read_Crop_Details;
import utility.Read_Frost_Details;

public class Crop_skipping_optional_data {

	@SuppressWarnings("rawtypes")
	private IOSDriver driver;
	private CropPage cropPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private Alert_Page alertpage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private Read_Crop_Details read_crop;
	private FrostPage frostpage;
	private Read_Frost_Details read_frost_details;
	private static CropPage croppage;

	@Test
	public void addingCrop() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			cropPage = new CropPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			alertpage = new Alert_Page(driver);
			loginpage = new LoginPage(driver);
			read_crop = new Read_Crop_Details();
			read_crop.start();
			readUserData = new ReadUserData();
			readUserData.start();
			frostpage = new FrostPage(driver);
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			croppage = new CropPage(driver);

			System.out.println(
					"***************************Staring- Crop_skipping_optional_data **************************");
			


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
				// driver.quit();
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			TimeUnit.SECONDS.sleep(6);
			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();// ----using xpath here
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(5000);
			}

			// Enter The verified text in the view name text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
				Thread.sleep(5000);
			}

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				newviewscreenpage.getviewNextBtn().click();
				Thread.sleep(3000);
			}

			// Click on Crop
			if (newviewscreenpage.getcrop() != null) {
				newviewscreenpage.getcrop().click();

			}

			// Verify the Edit Crop text
			if (cropPage.getcrop() != null) {
				String editcrop = cropPage.getcrop().getAttribute("name");
				if (editcrop.isEmpty()) {
					ATUReports.add("Verify the Edit Crop in the screen ", "Edit Crop", editcrop, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else if (editcrop.contains("Crop")) {
					ATUReports.add("Edit Crop is noticed in the screen ", "Edit Crop", editcrop, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify the title text
					String crop_sensor_title = cropPage.getcropSensorTitle().getAttribute("name");
					if (crop_sensor_title.isEmpty()) {
						ATUReports.add("Verify the Crop Sensor Input text  in the screen ", "Crop Sensor Input",
								crop_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (crop_sensor_title.equalsIgnoreCase("Crop Sensor Input")) {
							ATUReports.add("Crop Sensor Input is noticed in the screen ", "Crop Sensor Input",
									crop_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Crop Sensor Input is not observed in the screen ", crop_sensor_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

				} else {
					ATUReports.add("Edit Crop is not  noticed in the screen ", "Edit Crop", editcrop, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop sensor
			if (cropPage.getBodytxt() != null) {
				String cropbody = cropPage.getBodytxt().getText();

				if (cropbody.isEmpty()) {
					ATUReports.add("Verify the Crop Sensor Input caption text  in the screen ",
							"Select the appropriate device and temperature sensor input for monitoring crop data.",
							cropbody, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (cropbody.equals(
							"Select the appropriate device and temperature sensor input for monitoring crop data.")) {
						ATUReports.add("Crop Sensor Input caption text is dispalyed in the screen ",
								"Select the appropriate device and temperature sensor input for monitoring crop data.",
								cropbody, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop Sensor Input caption text is not dispalyed in the screen ", cropbody,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Select any option from device drop down -
			// cropPage.getdevicedropdown().click();
			cropPage.getDevicestxt().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			// MobileElement SensorDrpDwn = (MobileElement)
			// driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"));//UIAStaticText[1]
			// SensorDrpDwn.click();

			if (cropPage.getSensortxt() != null) {
				String sensorTxt = cropPage.getSensortxt().getAttribute("name");
				/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 */
				cropPage.getSensortxt().click();
				Thread.sleep(5000);
			}
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

			// Verify Crop title text.
			String crop_sensor_title1 = cropPage.getTitletxt().getAttribute("name");
			// System.out.println(title);
			if (crop_sensor_title1.isEmpty()) {
				ATUReports.add("Crop & Variety element is not available in the screen ", "Crop Sensor Input",
						crop_sensor_title1, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_sensor_title1.equalsIgnoreCase("Crop & Variety")) {
					ATUReports.add("Crop & Variety is noticed in the screen ", "Crop & Variety", crop_sensor_title1,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop & Variety is not observed in the screen ", crop_sensor_title1, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			String crop_body = cropPage.getBodytxt().getText();
			if (crop_body.isEmpty()) {
				ATUReports.add("Verify the Crop & Variety caption text  in the screen ",
						"Enter the crop type and variety to build a crop specific profile.", crop_body, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_body.contains("Enter the crop type and variety to build a crop specific profile.")) {
					ATUReports.add("Crop & Variety caption text is dispalyed in the screen ",
							"Enter the crop type and variety to build a crop specific profile.", crop_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop caption text is not dispalyed in the screen ", crop_body, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify next
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

			// Verify Growing degree start date title text.
			String growing_degree_title = cropPage.getgddStartDateTitle().getAttribute("name");
			System.out.println(growing_degree_title + "growing_degree_title");
			if (growing_degree_title.isEmpty()) {
				ATUReports.add("Verify the GROWING DEGREE START DATE (GDD) text  in the screen ",
						"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (growing_degree_title.equalsIgnoreCase("Growing Degree Start Date (GDD)")) {
					ATUReports.add("GROWING DEGREE START DATE (GDD) is noticed in the screen ",
							"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("GROWING DEGREE START DATE (GDD) is not observed in the screen ",
							growing_degree_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);

			ATUReports.add("Next button is enabled in the corrent screen and clicked on the Next button", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// verify next

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

			// Verify Growing degree start date title text.

			ATUReports.add("Skip the GDD Start Date? is noticed in the screen ", "Skip the GDD Start Date?",

					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Text under the title is present in the Alert ",
					"You will not be able to monitor GDD if you skip this step.",

					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			String error_title = alertpage.getskipthe_gdd_date().getText();
			if (error_title.isEmpty()) {
				ATUReports.add("Verify the Skip the GDD Start Date? text  in the screen ", "Skip the GDD Start Date?",
						error_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (error_title.equals("Skip GDD Start Date")) {
					ATUReports.add("Skip the GDD Start Date? is noticed in the screen ", "Skip the GDD Start Date?",
							error_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Skip the GDD Start Date? is not observed in the screen ", error_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Growing degree start date error title

			ATUReports.add("Clicked on the Skip button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// Click on the skip button
			if (alertpage.getskipbtn().isEnabled()) {
				alertpage.getskipbtn().click();
				ATUReports.add("Clicked on the Skip button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Skip  button is not enabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Crop title text.
			String chillstartdate = cropPage.getchillstartdtTitle().getAttribute("name");
			if (chillstartdate.isEmpty()) {
				ATUReports.add("Chill Start Date element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillstartdate.equals("CHILL START DATE")) {
					ATUReports.add("Chill Start Date is noticed in the screen ", "CHILL START DATE", chillstartdate,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("Chill Start Date is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop

			String chillstartdate_body = cropPage.getBodytxt().getText();
			if (chillstartdate_body.isEmpty()) {
				ATUReports.add("Verify the Chill Start Date caption text  in the screen ",

						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillstartdate_body.equals("Set the starting date to begin Chill accumulation.")) {
					ATUReports.add("Chill Start Date caption text is dispalyed in the screen ",
							"Set the starting date to begin Chill accumulation.", chillstartdate_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Chill Start Date caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

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

			// Verify Growing degree start date title text.

			ATUReports.add("Cancel Adding Crop? is noticed in the screen ", "Cancel Adding Crop?",

					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			alertpage.getskipbtn().click();
			Thread.sleep(400);

			// Verify chill start date start date error title
			// text.

			ATUReports.add("Text under the title is present in the Alert ",
					"You need to set either the GDD or Chill start date. By not setting any dates, no Crop report will be added.",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Clicked on the continue button", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add("Successfully skipping optional crop optional data", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);

		}
		System.out
				.println("***************************Staring- Crop_skipping_optional_data **************************");

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
			ATUReports.add("Clicked on next button in user name text box", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			driver.quit();
		}
	}

}

