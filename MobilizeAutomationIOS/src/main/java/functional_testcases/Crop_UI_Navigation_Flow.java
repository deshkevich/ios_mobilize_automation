/*
package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.ReadUserData;
import utility.ReadWeatherDetails;
import utility.Read_Crop_Details;
import utility.Read_Frost_Details;
import Pages.Alert_Page;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import functional_testcases.Add_Frost;

public class Crop_UI_Navigation_Flow {
	private FrostPage frostpage;
	private static IOSDriver driver;
	private CropPage cropPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private JavascriptExecutor js;
	private LoginPage loginpage;
	private ReadUserData readuserdata;
	private ReadUserData readUserData;
	private Read_Crop_Details read_crop;
	private ReadWeatherDetails read_weather_details;
	private Read_Frost_Details read_frost_details;

	// private static CropPage croppage;
	@Test

	public void addingCrop() throws InterruptedException {

		try {
			frostpage = new FrostPage(driver);
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			readuserdata = new ReadUserData();
			readuserdata.start();
			cropPage = new CropPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			new Alert_Page(driver);
			js = (JavascriptExecutor) driver;
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			read_crop = new Read_Crop_Details();
			read_crop.start();
			read_weather_details = new ReadWeatherDetails();
			read_weather_details.start();
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();

			System.out.println("*************************** Crop_UI_Navigation_Flow **************************");
			ATUReports.add("Before launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			TimeUnit.SECONDS.sleep(10);
			// reset the application -
			// close the application
			// driver.quit();
			// Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("After launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			*/
/*//*
/ Reset app
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

			TimeUnit.SECONDS.sleep(7);*//*

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
			Thread.sleep(3000);
			// Click on Crop
			if (newviewscreenpage.getcrop() != null) {
				newviewscreenpage.getcrop().click();

			}
			Thread.sleep(2000);
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
			cropPage.getDevicestxt().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			if (cropPage.getSensortxt() != null) {
				String sensorTxt = cropPage.getSensortxt().getAttribute("name");
				*/
/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 *//*

				cropPage.getSensortxt().click();
				Thread.sleep(5000);
			}
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			Thread.sleep(2000);
			*/
/***********************************
			 * CROP & VARIETY
			 ****************************************//*


			// get the value of the optional and click on it
			if (cropPage.getcropVarietyOptional() != null) {
				cropPage.getcropVarietyOptional().click();
				ATUReports.add("optional Slider is displayed in crop & Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			// verify the optional text
			verify_Optionaltxt();
			Thread.sleep(3000);

			// Verify Crop title text.
			if (cropPage.getTitletxt() != null) {
				String crop_sensor_title1 = cropPage.getTitletxt().getText();
				// System.out.println(title);
				if (crop_sensor_title1.isEmpty()) {
					ATUReports.add("CROP & VARIETY element is not available in the screen ", "CROP & VARIETY",
							crop_sensor_title1, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_sensor_title1.equalsIgnoreCase("CROP & VARIETY")) {
						ATUReports.add("CROP & VARIETY is noticed in the screen ", "CROP & VARIETY", crop_sensor_title1,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("CROP & VARIETY is not observed in the screen ", crop_sensor_title1,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String crop_body = cropPage.getBodytxt().getText();
				if (crop_body.isEmpty()) {
					ATUReports.add("Verify the Crop & Variety caption text  in the screen ",
							"Enter the crop type and variety to build a crop specific profile.", crop_body,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
			}

			// Verify the Crop: text in the crop
			if (cropPage.getcroptxtfield() != null) {
				String crop_body = cropPage.getcroptxtfield().getAttribute("name");
				if (crop_body.isEmpty()) {
					ATUReports.add("Verify the Crop: caption text  in the screen ", "Crop:", crop_body, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_body.contains("Crop:")) {
						ATUReports.add("Crop: caption text is dispalyed in the screen ", "Crop:", crop_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop caption text is not dispalyed in the screen ", crop_body, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}
			// Enter Crop details
			if (cropPage.getcropVarietyCropTextBox() != null) {
				cropPage.getcropVarietyCropTextBox().clear();
				cropPage.getcropVarietyCropTextBox().click();
				Thread.sleep(3000);
				cropPage.getcropVarietyCropTextBox().setValue(read_crop.crop);// read_crop.crop
				Thread.sleep(3000);
				ATUReports.add("Entered crop details", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				 // click on done button
				if((WebElement) driver.findElementByAccessibilityId("Done")!=null){
					WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
					Thread.sleep(5000);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(doneBtnrr).release().perform();
					Thread.sleep(6000);
					//System.out.println("Clicked on done button");
					ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if((WebElement) driver.findElementByAccessibilityId("Done")!=null){
						WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action2 = new TouchAction(driver);
						action2.longPress(doneBtnrr).release().perform();
						Thread.sleep(6000);
						//System.out.println("Clicked on done button");
						ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}
				

			}

			Thread.sleep(2000);
			// Verify the Crop: text in the crop
			if (cropPage.getvariety() != null) {
				// Enter Variety details
				if (cropPage.getcropVarietyVarietyTextBox() != null) {
					cropPage.getcropVarietyVarietyTextBox().clear();
					cropPage.getcropVarietyVarietyTextBox().click();
					Thread.sleep(3000);
					cropPage.getcropVarietyVarietyTextBox().sendKeys(read_crop.variety);
					ATUReports.add("Entered Variety details ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// click on done button
					if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
						WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action2 = new TouchAction(driver);
						action2.longPress(doneBtnrr).release().perform();
						Thread.sleep(6000);
						// System.out.println("Clicked on done button");
						ATUReports.add("Clicked on Done button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
							WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action2 = new TouchAction(driver);
							action2.longPress(doneBtnrr).release().perform();
							Thread.sleep(6000);
							// System.out.println("Clicked on done button");
							ATUReports.add("Clicked on Done button", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
					}

				}
			}

			Thread.sleep(2000);
			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/***************************************
			 * GROWIG DEGREE START DATE(GOD)
			 *******************************************//*


			// verify the optional text
			verify_Optionaltxt();

			// verify the optional
			if (cropPage.getgrowingDegreeOtpional() != null) {
				cropPage.getgrowingDegreeOtpional().click();
				ATUReports.add("optional Slider is displayed in GROWIG DEGREE START DATE(GOD)", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Growing degree start date title text.
			if (cropPage.getgddStartDateTitle() != null) {
				String growing_degree_title = cropPage.getgddStartDateTitle().getAttribute("name");
				if (growing_degree_title.isEmpty()) {
					ATUReports.add("Verify the GROWING DEGREE START DATE (GDD) text  in the screen ",
							"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (growing_degree_title.equals("GROWING DEGREE START DATE (GDD)")) {
						ATUReports.add("GROWING DEGREE START DATE (GDD) is noticed in the screen ",
								"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("GROWING DEGREE START DATE (GDD) is not observed in the screen ",
								growing_degree_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Growing degree start date error title
			// text.
			if (cropPage.getBodytxt() != null) {
				String error_body = cropPage.getBodytxt().getText();
				if (error_body.isEmpty()) {
					ATUReports.add("Verify the text under the title in the Alert ",
							"Set the starting date to begin accumulating GDD.", error_body, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (error_body.equals("Set the starting date to begin accumulating GDD.")) {
						ATUReports.add("Text under the title is present in the Alert ",
								"Set the starting date to begin accumulating GDD.", error_body, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Text under the title is not present in the Alert ", error_body, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// verify the date is enabled or not and then Click on
			// the date tab
			if (cropPage.getGDDDatepickerBtn() != null) {
				cropPage.getGDDDatepickerBtn().click();
				Thread.sleep(3000);
				// Click on done button
				cropPage.getDone().click();

			}

			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/************************ GDD TARGET ******************************//*


			// Verify Crop title text.
			if (cropPage.getgddTargetTitle() != null) {
				String crop_target = cropPage.getgddTargetTitle().getAttribute("name");
				if (crop_target.isEmpty()) {
					ATUReports.add(" GDD TARGET  element is not available in the screen ", " GDD TARGET ", crop_target,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_target.equals("GDD TARGET")) {
						ATUReports.add(" GDD TARGET  is noticed in the screen ", " GDD TARGET ", crop_target,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add(" GDD TARGET  is not observed in the screen ", crop_target, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String crop_Target_body = cropPage.getBodytxt().getText();
				if (crop_Target_body.isEmpty()) {
					ATUReports.add("Verify the GDD Target caption text  in the screen ", crop_Target_body,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_Target_body.contains("Set the total number of GDD required to reach the desired stage.")) {
						ATUReports.add("GDD Target caption text is dispalyed in the screen ",
								"Set the total number of GDD required to reach the desired stage.", crop_Target_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("GDD Target caption text is not dispalyed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Click on Skip button

			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/*****************************************************
			 * GDD CALCULATION TYPE SCREEN
			 ***********************************************************//*


			// Verify Crop title text.
			if (cropPage.getgddcalnTitle() != null) {
				String crop_calculation_type = cropPage.getgddcalnTitle().getAttribute("name");
				if (crop_calculation_type.isEmpty()) {
					ATUReports.add("GDD CALCULATION TYPE element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_calculation_type.equals("GDD CALCULATION TYPE")) {
						ATUReports.add("GDD CALCULATION TYPE is noticed in the screen ", "GDD CALCULATION TYPE",
								crop_calculation_type, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("GDD Calculation Type is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String crop_calculation_type_body = cropPage.getBodytxt().getText();
				if (crop_calculation_type_body.isEmpty()) {
					ATUReports.add("Verify the GDD Calculation Type caption text  in the screen ",

							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (crop_calculation_type_body
							.contains("Set the crop calculation format required for GDD calculation.")) {
						ATUReports.add("CROP CALCULATION TYPE caption text is dispalyed in the screen ",
								"Set the crop calculation format required for GDD calculation.",
								crop_calculation_type_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("GDD Calculation Type caption text is not dispalyed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verifying help icons
			if (cropPage.getGddPagehelpButton1() != null) {
				cropPage.getGddPagehelpButton1().click();
				Thread.sleep(2000);
				if (cropPage.getsingleSine() != null) {
					String singlesineText = cropPage.getsingleSine().getAttribute("name");
					ATUReports.add(singlesineText + " help button is diplayed upon clicked on-" + singlesineText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				if (cropPage.getsinglesineHelpCaption() != null) {
					String helpCaption = cropPage.getsinglesineHelpCaption().getText();
					Thread.sleep(1000);
					ATUReports.add(" help button is diplayed upon clicked on-", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					if (helpCaption.contains(
							"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.")) {
						ATUReports.add("Single Sine Help button Text is Observed",
								"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.",
								helpCaption, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					cropPage.getokBtn().click();
					Thread.sleep(2000);
				}
			}
			if (cropPage.getGddPagehelpButton2() != null) {
				cropPage.getGddPagehelpButton2().click();
				if (cropPage.getintegrationTxt() != null) {
					String integrationIcon = cropPage.getintegrationTxt().getText();
					ATUReports.add(integrationIcon + " help button is diplayed clicked on-" + integrationIcon,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					String integrationCaption = cropPage.getintegrationPopUpBody().getText();
					if (integrationCaption.contains(
							"Most Accurate. Integrates all time series temperature data provided by the sensor.")) {
						ATUReports.add(integrationIcon + " Help button Text is Observed",
								"Most Accurate. Integrates all time series temperature data provided by the sensor.",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					cropPage.getokBtn().click();
					Thread.sleep(2000);
				}
			}

			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/*****************************************************
			 * LOWER TEMPERATURE THRESHOLD
			 ***********************************************************//*


			// Verify Crop title text.
			String lowerthreshold = cropPage.getlowTemTitle().getAttribute("name");
			if (lowerthreshold.isEmpty()) {
				ATUReports.add("LOWER TEMPERATURE THRESHOLD  element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (lowerthreshold.equalsIgnoreCase("LOWER TEMPERATURE THRESHOLD")) {
					ATUReports.add("LOWER TEMPERATURE THRESHOLD is noticed in the screen ", "LOWER THRESHOLD",
							lowerthreshold, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("LOWER TEMPERATURE THRESHOLD  is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			if (cropPage.getBodytxt() != null) {
				String lower_threshold_body = cropPage.getBodytxt().getText();
				if (lower_threshold_body.isEmpty()) {
					ATUReports.add("Verify the Lower Temperature Threshold caption text  in the screen ",

							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (lower_threshold_body.contains("GDD will be accumulated at and above the lower threshold.")) {
						ATUReports.add("Lower Temperature Threshold caption text is dispalyed in the screen ",
								"GDD will be accumulated at and above the lower threshold.", lower_threshold_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Lower Temperature Threshold caption text is not dispalyed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			if (cropPage.getlowTemThresholdTxt() != null) {
				String lower_threshold_body = cropPage.getlowTemThresholdTxt().getText();
				if (lower_threshold_body.isEmpty()) {
					ATUReports.add("Verify the Set Lower Threshold: caption text  in the screen ", lower_threshold_body,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (lower_threshold_body.contains("Set Lower Threshold:")) {
						ATUReports.add("Set Lower Threshold: caption text is dispalyed in the screen ",
								"Set Lower Threshold:", lower_threshold_body, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Lower Temperature Threshold caption text is not dispalyed in the screen ",
								lower_threshold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the f&c text
			if (cropPage.getcropUnits() != null) {
				String Units = cropPage.getcropUnits().getText();

				if (Units.isEmpty()) {
					ATUReports.add(Units + "element is not visible", null, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (Units.equals("°F")) {
						ATUReports.add("°F text is noticed in the screen ", "°F", Units, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (Units.equals("°C")) {
							ATUReports.add("°C text is not observed in the screen ", Units, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
				}
			}

			// Verify on Plus icon
			Add_Frost.plusIconButton(cropPage.getLwrplusBtn());

			// Verify on minus icon
			Add_Frost.minusIconButton(cropPage.getLwrminusBtn());

			// Enter some value in the Saturation
			if (cropPage.getthresholdtxtfld() != null) {
				cropPage.getthresholdtxtfld().clear();
				String lowerthreshold1 = read_crop.lower_threshold;
				cropPage.getthresholdtxtfld().sendKeys(lowerthreshold1);
				ATUReports.add("Enetered temaperature value", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// click on done button
				if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
					WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
					Thread.sleep(5000);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(doneBtnrr).release().perform();
					Thread.sleep(6000);
					// System.out.println("Clicked on done button");
					ATUReports.add("Clicked on Done button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
						WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action2 = new TouchAction(driver);
						action2.longPress(doneBtnrr).release().perform();
						Thread.sleep(6000);
						// System.out.println("Clicked on done button");
						ATUReports.add("Clicked on Done button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/*****************************************************
			 * UPPER TEMPERATURE THRESHOLD
			 ***********************************************************//*


			// Get optional into enable moode
			if (cropPage.getupperTemOptional() != null) {
				cropPage.getupperTemOptional().click();
				ATUReports.add("optional Slider is displayed in UPPER TEMPERATURE THRESHOLD ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);
			// verify the back button in the CROP SENSOR INPUT screen

			// Verify Crop title text.
			if (cropPage.getupperTemTitle() != null) {
				String upperthreshold = cropPage.getupperTemTitle().getAttribute("name");
				// System.out.println(title);
				if (upperthreshold.isEmpty()) {
					ATUReports.add("UPPER TEMPERATURE THRESHOLD  element is not available in the screen ",
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (upperthreshold.equals("UPPER TEMPERATURE THRESHOLD")) {
						ATUReports.add("UPPER TEMPERATURE THRESHOLD  is noticed in the screen ", "UPPER THRESHOLD",
								upperthreshold, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("UPPER TEMPERATURE THRESHOLD  is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String upper_threshold_body = cropPage.getBodytxt().getText();
				if (upper_threshold_body.isEmpty()) {
					ATUReports.add("Verify the Upper Temperature  caption text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (upper_threshold_body.equals(
							"Growing degree days are accumulated above the upper threshold depending on the selected cutoff method.")) {
						ATUReports.add("Upper Temperature Threshold caption text is dispalyed in the screen ",
								"Growing degree days are accumulated above the upper threshold depending on the selected cutoff method.",
								upper_threshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Upper Temperature Threshold caption text is not dispalyed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(5000);
			}

			// Click on Plus icon
			if (cropPage.getupprPlus() != null) {
				Add_Frost.plusIconButton(cropPage.getupprPlus());
			}
			// click on minus icon
			if (cropPage.getuprMinus() != null) {
				Add_Frost.minusIconButton(cropPage.getuprMinus());
			}

			// Enter some value in the Saturation
			if (cropPage.getthresholdtxtfld() != null) {
				cropPage.getthresholdtxtfld().clear();
				String upperthreshold1 = read_crop.upper_threshold;
				System.out.println(upperthreshold1);
				cropPage.getthresholdtxtfld().sendKeys(upperthreshold1);

				// click on done button
				if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
					WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
					Thread.sleep(5000);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(doneBtnrr).release().perform();
					Thread.sleep(6000);
					// System.out.println("Clicked on done button");
					ATUReports.add("Clicked on Done button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
						WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action2 = new TouchAction(driver);
						action2.longPress(doneBtnrr).release().perform();
						Thread.sleep(6000);
						// System.out.println("Clicked on done button");
						ATUReports.add("Clicked on Done button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			// click on done button

			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/***************************************************************************************************************
			 * CUTOFF METHOD *
			 ************************************************************************************************************//*


			// Verify Crop title text.
			if (cropPage.getcutOffTitle() != null) {
				String cutoffmethod = cropPage.getcutOffTitle().getAttribute("name");
				// System.out.println(title);
				if (cutoffmethod.isEmpty()) {
					ATUReports.add("CUTOFF METHOD element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (cutoffmethod.equals("CUTOFF METHOD")) {
						ATUReports.add("CUTOFF METHOD is noticed in the screen ", "CUTOFF METHOD", cutoffmethod,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("CUTOFF METHOD is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String cutoff_body = cropPage.getBodytxt().getText();
				if (cutoff_body.isEmpty()) {
					ATUReports.add("Verify the Cutoff Method caption text  in the screen ",

							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (cutoff_body.contains(
							"Set the crop calculation format to resolve GDD accumulation if upper temperature threshold is met.")) {
						ATUReports.add("Cutoff Method caption text is dispalyed in the screen ",
								"Set the crop calculation format to resolve GDD accumulation if upper temperature threshold is met.",
								cutoff_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Cutoff Method caption text is not dispalyed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verifying help icons
			if (cropPage.getGddPagehelpButton6() != null) {
				cropPage.getGddPagehelpButton6().click();
				Thread.sleep(2000);

				if (cropPage.getvertialtxt() != null) {
					String verticalText = cropPage.getvertialtxt().getAttribute("name");
					ATUReports.add(verticalText + " help button is diplayed clicked on-" + verticalText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					String helpCaption = cropPage.getsinglesineHelpCaption().getText();
					Thread.sleep(100);

					if (helpCaption.contains("Stops GDD accumulation above upper threshold.")) {
						ATUReports.add("Single Sine Help button Text is Observed",
								"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.",
								helpCaption, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					cropPage.getokBtn().click();
					Thread.sleep(200);
				}

			}

			if (cropPage.getGddPagehelpButton5() != null) {
				cropPage.getGddPagehelpButton5().click();
				Thread.sleep(2000);
				if (cropPage.gethorizontaltxt() != null) {
					String horizontaltxt = cropPage.gethorizontaltxt().getText();
					ATUReports.add(horizontaltxt + " help button is diplayed clicked on-" + horizontaltxt, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// String
					// helpCaption=cropPage.getsinglesineHelpCaption().getText();
					if (horizontaltxt.contains("Continues accumulation above upper threshold.")) {
						ATUReports.add(horizontaltxt + " Help button Text is Observed",
								"Continues accumulation above upper threshold.", horizontaltxt, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					cropPage.getokBtn().click();
					Thread.sleep(200);
				}

			}
			if (cropPage.getGddPagehelpButton4() != null) {
				cropPage.getGddPagehelpButton4().click();
				Thread.sleep(2000);
				String intermediate = cropPage.getintermediatetxt().getAttribute("name");
				ATUReports.add(intermediate + " help button is diplayed clicked on-" + intermediate, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				if (intermediate.contains("GDD accumulation tapers off above upper threshold.")) {
					ATUReports.add(intermediate + " Help button Text is Observed",
							"GDD accumulation tapers off above upper threshold.", intermediate, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				cropPage.getokBtn().click();
				Thread.sleep(200);

			}
			// Click on Skip button

			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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
			*/
/***************************************************************************************************************
			 * CHILL START DATE SCREEN *
			 ************************************************************************************************************//*


			// verify the optional text
			// verify_Optionaltxt();

			// Get optional into enable moode
			if (cropPage.getchillstrtDateOptional() != null) {
				cropPage.getchillstrtDateOptional().click();
				ATUReports.add("optional Slider is displayed in CHILL START DATE", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);
			// Verify Crop title text.
			String chillstartdate = cropPage.getchillstartdtTitle().getAttribute("name");
			if (chillstartdate.isEmpty()) {
				ATUReports.add("CHILL START DATE element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillstartdate.equalsIgnoreCase("CHILL START DATE")) {
					ATUReports.add("CHILL START DATE is noticed in the screen ", "CHILL START DATE", chillstartdate,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("CHILL START DATE is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
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
			}

			// verify the date is enabled or not and then Click on
			// the date tab
			if (cropPage.getdatePickerChilSrtDt() != null) {
				cropPage.getdatePickerChilSrtDt().click();

				// Click on done button
				cropPage.getDone().click();
				Thread.sleep(2000);
			}
			// Click on Skip button

			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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
			*/
/***************************************************************************************************************
			 * CHILL CALCULATION METHOD *
			 ************************************************************************************************************//*


			// Verify Crop title text.
			String chillcalculationtdate = cropPage.getchillCalnTitle().getAttribute("name");
			// System.out.println(title);
			if (chillcalculationtdate.isEmpty()) {
				ATUReports.add("CHILL CALCULATION METHOD element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillcalculationtdate.equals("CHILL CALCULATION METHOD")) {
					ATUReports.add("CHILL CALCULATION METHOD is noticed in the screen ", "CHILL CALCULATION METHOD",
							chillcalculationtdate, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CHILL CALCULATION METHOD is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String chillcalculationtype_body = cropPage.getBodytxt().getText();
				if (chillcalculationtype_body.isEmpty()) {
					ATUReports.add("Verify the Chill Calculation Method caption text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (chillcalculationtype_body
							.equals("Set the crop calculation format required for chill unit calculation.")) {
						ATUReports.add("Chill Calculation Method caption text is dispalyed in the screen ",
								"Set the crop calculation format required for chill unit calculation.",
								chillcalculationtype_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Chill Calculation Method caption text is not dispalyed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verifying help icons
			if (cropPage.getGddPagehelpButton7() != null) {
				cropPage.getGddPagehelpButton7().click();
				Thread.sleep(2000);

				String dynamicTextText = cropPage.getchillclnDynmicTxt().getText();
				ATUReports.add(dynamicTextText + " help button is diplayed clicked on-" + dynamicTextText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				String helpCaption = cropPage.getsinglesineHelpCaption().getText();
				Thread.sleep(100);

				if (helpCaption.contains(
						"Hourly CROP data is needed for the model. This model is based on the assumption that chill accumulates in a two-step process. In the first step, low temperatures lead to the formation of an intermediate product. This process is reversible, and the intermediate product can be destroyed by heat. Once a certain critical concentration of the intermediary is reached, in a second stage the intermediate product is transformed irreversibly into a product of a Chill Portion, and the concentration of the intermediate product fall to zero and the dynamic cure exhibits a periodic behavior. Chill Portions are accumulated, contributing to fulfillment of chilling requirements. It calculates chilling accumulation as ‘chill portions’ using a range of temperatures from ~35 - 55°F (~1.7 - 13°C) and accounts for chill cancellation due to fluctuating warm temperatures. The model works only during the stage between leaf drop in the fall and bud break in the spring.")) {
					ATUReports.add(dynamicTextText + "Help button Text is Observed",
							"Hourly CROP data is needed for the model. This model is based on the assumption that chill accumulates in a two-step process. In the first step, low temperatures lead to the formation of an intermediate product. This process is reversible, and the intermediate product can be destroyed by heat. Once a certain critical concentration of the intermediary is reached, in a second stage the intermediate product is transformed irreversibly into a product of a Chill Portion, and the concentration of the intermediate product fall to zero and the dynamic cure exhibits a periodic behavior. Chill Portions are accumulated, contributing to fulfillment of chilling requirements. It calculates chilling accumulation as ‘chill portions’ using a range of temperatures from ~35 - 55°F (~1.7 - 13°C) and accounts for chill cancellation due to fluctuating warm temperatures. The model works only during the stage between leaf drop in the fall and bud break in the spring.",
							helpCaption, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				cropPage.getokBtn().click();
				Thread.sleep(200);
			}

			if (cropPage.getGddPagehelpButton9() != null) {
				cropPage.getGddPagehelpButton9().click();
				Thread.sleep(2000);
				if (cropPage.getchillcalnChillingHrs() != null) {
					String utahChilligHrs = cropPage.getchillcalnChillingHrs().getAttribute("name");
					ATUReports.add(utahChilligHrs + " help button is diplayed clicked on-" + utahChilligHrs,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// String
					// integrationCaption=cropPage.getintegrationPopUpBody().getText();
					if (utahChilligHrs.contains(
							" The model contains a weight function assigning different chilling efficiencies to different temperature ranges. The model requires hourly temperature for calculation. Each hour of the day is given positive, negative, or no chilling units based on the temperature in that hour.")) {
						ATUReports.add(utahChilligHrs + " Help button Text is Observed",
								" The model contains a weight function assigning different chilling efficiencies to different temperature ranges. The model requires hourly temperature for calculation. Each hour of the day is given positive, negative, or no chilling units based on the temperature in that hour.",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					cropPage.getokBtn().click();
					Thread.sleep(200);
				}

			}
			// Click on Skip button
			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/***************************************************************************************************************
			 * CHILLING TARGET *
			 ************************************************************************************************************//*


			// Verify Crop title text.
			if (cropPage.getchiltartxt() != null) {
				String chillingthreshold = cropPage.getchiltartxt().getAttribute("name");
				// System.out.println(title);
				if (chillingthreshold.isEmpty()) {
					ATUReports.add("CHILLING TARGET element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (chillingthreshold.equals("CHILLING TARGET")) {
						ATUReports.add("CHILLING TARGET is noticed in the screen ", "CHILLING TARGET",
								chillingthreshold, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("CHILLING TARGET is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			Thread.sleep(5000);

			// Verify the body text in the crop
			if (cropPage.getBodytxt() != null) {
				String CHILLINGTHRESHOLD_body = cropPage.getBodytxt().getText();
				if (CHILLINGTHRESHOLD_body.isEmpty()) {
					ATUReports.add("Verify the Chilling Target caption text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (CHILLINGTHRESHOLD_body
							.contains("Set the total number of Chill Units required to reach the desired stage.")) {
						ATUReports.add("Chilling Target caption text is dispalyed in the screen ",
								"Set the total number of Chill Units required to reach the desired stage.",
								CHILLINGTHRESHOLD_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Chilling Target caption text is not dispalyed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			Thread.sleep(6000);

			// Click on Plus icon
			if (cropPage.getchillingTrgtPlus() != null) {
				Add_Frost.plusIconButton(cropPage.getchillingTrgtPlus());
				ATUReports.add(
						"Plus icon is displayed and clicked on Plus icon then Temperature value increased"
								+ cropPage.getChillingTxtBx().getText(),
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(3000);
			}

			// click on minus icon
			if (cropPage.getChllinhTrgtMinus() != null) {
				Add_Frost.minusIconButton(cropPage.getChllinhTrgtMinus());
				ATUReports.add(
						"Minus icon is displayed and clicked on Minus icon then Temperature value decreased"
								+ cropPage.getChillingTxtBx().getText(),
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(5000);
			}

			// Click on Skip button

			if (cropPage.getnextButtonTopText() != null) {
				if (cropPage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			*/
/***************************************************************************************************************
			 * COMPLETE CROP SETUP SCREEN *
			 ************************************************************************************************************//*


			// Verify COMPLETE CROP SETUP title text.
			if (cropPage.getcompleteCropSetUpTitle() != null) {
				String complete_crop_setup = cropPage.getcompleteCropSetUpTitle().getAttribute("name");
				if (complete_crop_setup.isEmpty()) {
					ATUReports.add("Verify the Complete Crop Setup text  in the screen ", "Complete Crop Setup",
							complete_crop_setup, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (complete_crop_setup.equalsIgnoreCase("COMPLETE CROP SETUP")) {
						ATUReports.add(
								"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
								"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Complete Crop Setup is not observed in the screen ", complete_crop_setup,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			Thread.sleep(2000);

			// Click on Skip button

			// Verify save button
			if (cropPage.getsaveTxt() != null) {
				if (cropPage.getsaveTxt().isDisplayed()) {
					ATUReports.add(
							"Save button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box with F units",
							"Save", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TouchAction action2j = new TouchAction(driver);
					action2j.longPress(cropPage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				if (cropPage.getnext_nxt_save_btn() != null) {
					if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
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

			System.out
					.println("*************************** ENDING - Crop_UI_Navigation_Flow **************************");

		} catch (Exception e) {
			System.out
					.println("*************************** CATCH - Crop_UI_Navigation_Flow **************************");
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			// TODO: handle exception
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

	private void verify_Header() {
		String editcrop;
		try {
			editcrop = cropPage.getcrop().getText();

			if (editcrop.isEmpty()) {
				ATUReports.add("Edit Crop element is not avaialble in the screen ", "Crop", editcrop, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else if (editcrop.equals("Crop")) {
				ATUReports.add("Crop is noticed in the screen ", "Crop", editcrop, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Crop is noticed in the screen ", "Crop", editcrop, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void verify_Optionaltxt() {
		// Verify the Optional button text
		String Optional;
		try {
			Optional = cropPage.getOptionaltxt().getText();

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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void nextButton() throws InterruptedException {
		@SuppressWarnings("unchecked")
		List<WebElement> list = driver.findElements(By.className("UIAButton"));
		// ATUReports.add("Clicked from the list
		// variable",list.get(0).getText(),LogAs.PASSED,new
		// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ATUReports.add("Clicked from the list variable", list.get(1).getText(), LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));// Next
		ATUReports.add("Clicked from the list variable", list.get(2).getText(), LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));// back

		// Click on next button in the Sensor Input
		if (list.get(1).isEnabled()) {
			Thread.sleep(2000);
			list.get(1).click();
			Thread.sleep(3000);
			ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

}
*/
