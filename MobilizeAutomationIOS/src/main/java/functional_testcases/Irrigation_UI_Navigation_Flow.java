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
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import utility.ReadUserData;
import utility.ReadWeatherDetails;
import utility.Read_Frost_Details;
import utility.Read_Irrigation_Details;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.IrrigationPage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.WeatherPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Irrigation_UI_Navigation_Flow {

	private IOSDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private IrrigationPage irrigationPage;
	private JavascriptExecutor js;
	private Read_Irrigation_Details read_irrigation;
	private ReadUserData readUserData;
	private Read_Irrigation_Details readirrgation;
	private ReadWeatherDetails read_weather_details;
	private WeatherPage weatherPage;
	private Read_Frost_Details read_frost_details;
	private static CropPage croppage;

	@Test
	public void Irrigation_verify_UI_navigation_flow() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			irrigationPage = new IrrigationPage(driver);
			js = (JavascriptExecutor) driver;
			read_irrigation = new Read_Irrigation_Details();
			read_irrigation.start();
			readUserData = new ReadUserData();
			readUserData.start();
			// readUserData =new readUserData();
			read_weather_details = new ReadWeatherDetails();
			read_weather_details.start();
			weatherPage = new WeatherPage(driver);
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			croppage = new CropPage(driver);

			System.out.println("*************************** Irrigation_UI_Navigation_Flow **************************");

			TimeUnit.SECONDS.sleep(10);
			ATUReports.add("", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// reset the application -
			// close the application
			// driver.quit();
			// Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);

		
			TimeUnit.SECONDS.sleep(6);
			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(7000);
			// Enter The verified text in the viewname text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
				ATUReports.add("Entered the value in the text box", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(7000);

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				newviewscreenpage.getviewNextBtn().click();
				Thread.sleep(6000);
			}
			// Scroll till the Irrigation
			driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
				{
					put("element", ((RemoteWebElement) newviewscreenpage.getirrigation()).getId());
				}
			});
			// Click on the Irrigation

			if (newviewscreenpage.getirrigation() != null) {
				newviewscreenpage.getirrigation().click();
			}
			Thread.sleep(5000);

			/************************
			 * Soil Moisture Sensor
			 ******************************/

			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getetsoilMoistreOtionalSlider() != null) {
				irrigationPage.getetsoilMoistreOtionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			// Verify Irrigation title text.
			if (irrigationPage.getsoilMoistureTitle() != null) {
				String soil = irrigationPage.getsoilMoistureTitle().getAttribute("name");
				if (soil.isEmpty()) {
					ATUReports.add("SOIL MOISTURE SENSOR element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (soil.equalsIgnoreCase("SOIL MOISTURE SENSOR")) {
						ATUReports.add("SOIL MOISTURE SENSOR is noticed in the screen ", "SOIL MOISTURE SENSOR", soil,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("SOIL MOISTURE SENSOR is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.getsoilMoistureBody() != null) {
				String soil_body = irrigationPage.getsoilMoistureBody().getAttribute("name");
				if (soil_body.isEmpty()) {
					ATUReports.add("Soil Moisture Sensor body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (soil_body.contains(
							"Select the appropriate device and sensor inputs for monitoring soil moisture.")) {
						ATUReports.add("Soil Moisture Sensor body text is noticed in the screen ",
								"Select the appropriate device and sensor inputs for monitoring soil moisture.",
								soil_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("Soil Moisture Sensor is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Select any option from device drop down -
			weatherPage.getdevicedropdown().click();
			weatherPage.getDevicestxt().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			MobileElement SensorDrpDwn = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"));// UIAStaticText[1]
			SensorDrpDwn.click();

			if (irrigationPage.getIrrigationSensorDropDownText() != null) {
				String sensorTxt = irrigationPage.getIrrigationSensorDropDownText().getAttribute("name");
				/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 */
				irrigationPage.getIrrigationSensorDropDownText().click();
				ATUReports.add("Clicked on the Sensor drop down and selected the  " + sensorTxt, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			// String sensorTxt =
			// irrigationPage.getIrrigationSensorDropDownText().getAttribute("name");

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
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
			Thread.sleep(2000);

			/***************************************************************************************************************
			 * SATURATION THRESHOLD
			 ************************************************************************************************************/

			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getsaturtnOptionalSlider() != null) {
				irrigationPage.getsaturtnOptionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			// Verify SATURATION THRESHOLD title text.
			if (irrigationPage.titletxt() != null) {
				String saturation_threshold_head = irrigationPage.titletxt().getText();
				if (saturation_threshold_head.isEmpty()) {
					ATUReports.add("Verify the SATURATION THRESHOLD text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (saturation_threshold_head.equals("SATURATION THRESHOLD")) {
						ATUReports.add("SATURATION THRESHOLD is noticed in the screen", "SATURATION THRESHOLD",
								saturation_threshold_head, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("SATURATION THRESHOLD is not noticed in the screen", "SATURATION THRESHOLD",
								saturation_threshold_head, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String saturation_body = irrigationPage.bodytxt().getText();
				if (saturation_body.isEmpty()) {
					ATUReports.add("Saturation Threshold body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (saturation_body.equals("Saturation threshold sets the topline of field moisture capacity.")) {
						ATUReports.add("Saturation Threshold body text is noticed in the screen ",
								"Saturation threshold sets the topline of field moisture capacity.", saturation_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("SATURATION THRESHOLD is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Saturation text.
			if (irrigationPage.getsaturation_text() != null) {
				String saturation_txt = irrigationPage.getsaturation_text().getAttribute("name");
				if (saturation_txt.isEmpty()) {
					ATUReports.add("SATURATION element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (saturation_txt.equals("Saturation:")) {
						ATUReports.add("SATURATION text is noticed in the screen ", "Saturation:", saturation_txt,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("SATURATION text is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Enter some value in the Saturation
			if (irrigationPage.getsaturationtxtfld() != null) {
				irrigationPage.getsaturationtxtfld().clear();
				// irrigationPage.getsaturationtxtfld().sendKeys("33");
				String saturation = read_irrigation.saturation_threshold;
				irrigationPage.getsaturationtxtfld().sendKeys(saturation);
				Thread.sleep(1000);
				ATUReports.add("Saturation value given in the text box", read_irrigation.saturation_threshold,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  SATURATION THRESHOLD screen and Clicked on Next button",
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
			/***************************************************************************************************************
			 * WILTING THRESHOLD
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getwiltingtOptionalSlider() != null) {
				irrigationPage.getwiltingtOptionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Chill start date title text.
			if (irrigationPage.titletxt() != null) {
				String wilting_thresold_body = irrigationPage.titletxt().getText();
				if (wilting_thresold_body.isEmpty()) {
					ATUReports.add("Verify the WILTING THRESHOLD text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (wilting_thresold_body.equals("WILTING THRESHOLD")) {
						ATUReports.add("WILTING THRESHOLD is noticed in the screen", "WILTING THRESHOLD",
								wilting_thresold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("WILTING THRESHOLD is not noticed in the screen", "WILTING THRESHOLD",
								wilting_thresold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String wilting_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (wilting_body.isEmpty()) {
					ATUReports.add("Wilting Threshold body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (wilting_body.contains(
							"Wilting threshold sets the lower limit, indicating the onset of plant stress due to under watering.")) {
						ATUReports.add("Wilting Threshold body text is noticed in the screen ",
								"Wilting threshold sets the lower limit, indicating the onset of plant stress due to under watering.",
								wilting_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("WILTING THRESHOLD is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Saturation text.
			if (irrigationPage.getsaturation_text() != null) {
				String saturation_txt_wilting = irrigationPage.getsaturation_text().getText();
				if (saturation_txt_wilting.isEmpty()) {
					ATUReports.add("SATURATION element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (saturation_txt_wilting.equals("Saturation:")) {
						ATUReports.add("SATURATION text is noticed in the screen ", "Saturation:",
								saturation_txt_wilting, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("SATURATION text is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Enter some value in the wilting Saturation
			if (irrigationPage.getsaturationtxtfld() != null) {
				irrigationPage.getsaturationtxtfld().clear();
				// irrigationPage.getsaturationtxtfld().sendKeys("33");
				irrigationPage.getsaturationtxtfld().sendKeys(read_irrigation.wilting_threshold);
				Thread.sleep(1000);
				ATUReports.add("Saturation value given in the text box", read_irrigation.wilting_threshold,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify next btn

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  WILTING THRESHOLD screen and Clicked on Next button",
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
			/***************************************************************************************************************
			 * EARLY WARNING THRESHOLD
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// Verify optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getearlyOptional() != null) {
				irrigationPage.getearlyOptional().click();
				Thread.sleep(2000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Chill start date title text.
			if (irrigationPage.titletxt() != null) {
				String early_thresold_title = irrigationPage.titletxt().getText();
				if (early_thresold_title.isEmpty()) {
					ATUReports.add("Verify the EARLY WARNING THRESHOLD text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (early_thresold_title.equals("EARLY WARNING THRESHOLD")) {
						ATUReports.add("EARLY WARNING THRESHOLD is noticed in the screen", "EARLY WARNING THRESHOLD",
								early_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("EARLY WARNING THRESHOLD is not noticed in the screen",
								"EARLY WARNING THRESHOLD", early_thresold_title, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String early_waring_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (early_waring_body.isEmpty()) {
					ATUReports.add("Early Warning Thresholdbody element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (early_waring_body.equals(
							"Early warning threshold is set to alert prior to when actual wilting threshold conditions are met.")) {
						ATUReports.add("EARLY WARNING THRESHOLD body text is noticed in the screen ",
								"Early warning threshold is set to alert prior to when actual wilting threshold conditions are met.",
								early_waring_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Early Warning Threshold caption text is not observed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Enter some value in the Saturation
			if (irrigationPage.getsaturationtxtfld() != null) {
				irrigationPage.getsaturationtxtfld().clear();
				// irrigationPage.getsaturationtxtfld().sendKeys("34");
				irrigationPage.getsaturationtxtfld().sendKeys(read_irrigation.early_waring_threshold);
				Thread.sleep(1000);
				ATUReports.add("Saturation value given in the text box", read_irrigation.early_waring_threshold,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify next btn

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  EARLY WARNING THRESHOLD screen and Clicked on Next button",
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
			/***************************************************************************************************************
			 * LOW SALINITY THRESHOLD
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getlowSalinityOptional() != null) {
				irrigationPage.getlowSalinityOptional().click();
				Thread.sleep(3000);
				ATUReports.add("Optional Slier is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Chill start date title text.
			if (irrigationPage.titletxt() != null) {
				String low_ec_thresold_title = irrigationPage.titletxt().getText();
				if (low_ec_thresold_title.isEmpty()) {
					ATUReports.add("Verify the LOW SALINITY THRESHOLD text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (low_ec_thresold_title.equals("LOW SALINITY THRESHOLD")) {
						ATUReports.add("LOW SALINITY THRESHOLD is noticed in the screen", "LOW SALINITY THRESHOLD",
								low_ec_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("LOW SALINITY THRESHOLD is not noticed in the screen", "LOW SALINITY THRESHOLD",
								low_ec_thresold_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String low_ec_thresold_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (low_ec_thresold_body.isEmpty()) {
					ATUReports.add("Low Salinity Threshold body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (low_ec_thresold_body.equals("Alert triggered if salinity is at or below threshold.")) {
						ATUReports.add("Low Salinity Threshold body text is noticed in the screen ",
								"Alert triggered if salinity is at or below threshold.", low_ec_thresold_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Low Salinity ThresholdD caption text is not observed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Enter some value in the Saturation
			if (irrigationPage.getsaturationtxtfld() != null) {
				irrigationPage.getsaturationtxtfld().clear();
				Thread.sleep(2000);
				irrigationPage.getsaturationtxtfld().sendKeys("1.0");
				Thread.sleep(2000);
				// irrigationPage.getsaturationtxtfld().sendKeys(read_irrigation.early_waring_threshold);
				ATUReports.add("Saturation value given in the text box", read_irrigation.saturation_threshold,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify next btn
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  LOW SALINITY THRESHOLD screen and Clicked on Next button",
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
			/***************************************************************************************************************
			 * HIGH EC THRESHOLD
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.gethighSalinityOptional() != null) {
				irrigationPage.gethighSalinityOptional().click();
				Thread.sleep(3000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify HIGH EC THRESHOLD title text.
			if (irrigationPage.titletxt() != null) {
				String high_ec_thresold_title = irrigationPage.titletxt().getText();
				if (high_ec_thresold_title.isEmpty()) {
					ATUReports.add("Verify the HIGH SALINITY THRESHOLD text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (high_ec_thresold_title.contains("HIGH SALINITY THRESHOLD")) {
						ATUReports.add("HIGH SALINITY THRESHOLD is noticed in the screen", "HIGH SALINITY THRESHOLD",
								high_ec_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("HIGH SALINITY THRESHOLD is not noticed in the screen",
								"HIGH SALINITY THRESHOLD", high_ec_thresold_title, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String high_ec_thresold_body = irrigationPage.bodytxt().getText();
				if (high_ec_thresold_body.isEmpty()) {
					ATUReports.add("High Salinity Threshold body element is not available in the screen ",
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (high_ec_thresold_body.equals("Alert triggered if salinity is at or above threshold.")) {
						ATUReports.add("High Salinity Threshold body text is noticed in the screen ",
								"Alert triggered if salinity is at or above threshold.", high_ec_thresold_body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("High Salinity Threshold caption text is not observed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Enter some value in the Saturation
			if (irrigationPage.getsaturationtxtfld() != null) {
				irrigationPage.getsaturationtxtfld().clear();
				irrigationPage.getsaturationtxtfld().sendKeys("1.7");
				Thread.sleep(2000);
				// irrigationPage.getsaturationtxtfld().sendKeys(read_irrigation.high_ec_threshold);
				ATUReports.add("Saturation value given in the text box", read_irrigation.high_ec_threshold,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

			// Verify next btn

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next  button is enabled in the Current screen and Clicked on Next button",
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

			/***************************************************************************************************************
			 * PRESSURE SENSOR
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// Verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getpressureOptional() != null) {
				irrigationPage.getpressureOptional().click();
				Thread.sleep(3000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Chill start date title text.
			if (irrigationPage.titletxt() != null) {
				String pressure_sensor_title = irrigationPage.titletxt().getText();
				if (pressure_sensor_title.isEmpty()) {
					ATUReports.add("Verify the PRESSURE SENSOR/SWITCH text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (pressure_sensor_title.contains("PRESSURE SENSOR/SWITCH")) {
						ATUReports.add("PRESSURE SENSOR/SWITCH is noticed in the screen", "PRESSURE SENSOR/SWITCH",
								pressure_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("PRESSURE SENSOR/SWITCH is not noticed in the screen", "PRESSURE SENSOR/SWITCH",
								pressure_sensor_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String pressure_sensor_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (pressure_sensor_body.isEmpty()) {
					ATUReports.add("Pressure Sensor/Switch body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (pressure_sensor_body.contains(
							"Select the appropriate device and sensor input for monitoring irrigation status.")) {
						ATUReports.add("Pressure Sensor/Switch body text is noticed in the screen ",
								"Select the appropriate device and sensor input for monitoring irrigation status.",
								pressure_sensor_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Pressure Sensor/Switch caption text is not observed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Select any option from device drop down -
			weatherPage.getdevicedropdown().click();
			weatherPage.getDevicestxt().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			MobileElement SensorDrpDwn1 = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"));// UIAStaticText[1]
			SensorDrpDwn1.click();

			if (irrigationPage.getsensortxt_item() != null) {
				String sensorTxt = irrigationPage.getsensortxt_item().getText();
				irrigationPage.getsensortxt_item().click();
				Thread.sleep(5000);
				ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verify next btn
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next  button is enabled in the Current screen and Clicked on Next button",
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
			/***************************************************************************************************************
			 * FLOW METER SENSOR
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// Verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getflowMtrOptionalSlider() != null) {
				irrigationPage.getflowMtrOptionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify FLOW METER SENSOR title text.
			if (irrigationPage.titletxt() != null) {
				String flow_meter_sensor_title = irrigationPage.titletxt().getText();
				if (flow_meter_sensor_title.isEmpty()) {
					ATUReports.add("Verify the FLOW METER SENSOR text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (flow_meter_sensor_title.equals("FLOW METER SENSOR")) {
						ATUReports.add("FLOW METER SENSOR is noticed in the screen", "FLOW METER SENSOR",
								flow_meter_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("FLOW METER SENSOR is not noticed in the screen", "FLOW METER SENSOR",
								flow_meter_sensor_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String flow_meter_sensor_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (flow_meter_sensor_body.isEmpty()) {
					ATUReports.add("Flow Meter Sensor body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (flow_meter_sensor_body.contains(
							"Select the appropriate device and sensor input for monitoring irrigation flow status.")) {
						ATUReports.add("Flow Meter Sensor body text is noticed in the screen ",
								"Select the appropriate device and sensor input for monitoring irrigation flow status.",
								flow_meter_sensor_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("FLOW METER SENSOR caption text is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// **************************************** Flow Meter Sensor is not
			// working *************************************//*

			// Select any option from device drop down -
			weatherPage.getdevicedropdown().click();
			weatherPage.getDevicestxt().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			MobileElement SensorDrpDwn2 = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"));// UIAStaticText[1]
			SensorDrpDwn2.click();

			if (irrigationPage.getpressuresensortxt_item() != null) {
				String sensorTxt = irrigationPage.getpressuresensortxt_item().getText();

				irrigationPage.getpressuresensortxt_item().click();
				Thread.sleep(5000);
			}
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next  button is enabled in the Current screen and Clicked on Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

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
			/***************************************************************************************************************
			 * ET READING
			 ************************************************************************************************************/

			// verify the header text
			// verify_Header();

			// verify the back button
			verify_Back_button();

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getetReadngOptional() != null) {
				irrigationPage.getetReadngOptional().click();
				Thread.sleep(2000);
				ATUReports.add("Optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Chill start date title text.
			if (irrigationPage.titletxt() != null) {
				String et_reading_title = irrigationPage.titletxt().getText();
				if (et_reading_title.isEmpty()) {
					ATUReports.add("Verify the ET READING text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (et_reading_title.equals("ET READING")) {
						ATUReports.add("ET READING is noticed in the screen", "ET READING", et_reading_title,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("ET READING is not noticed in the screen", "ET READING", et_reading_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.bodytxt() != null) {
				String et_reading_body = irrigationPage.bodytxt().getText();
				// System.out.println(title);
				if (et_reading_body.isEmpty()) {
					ATUReports.add("ET Reading body element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (et_reading_body.equals(
							"Select the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).")) {
						ATUReports.add("ET READING body text is noticed in the screen ",
								"Select the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).",
								et_reading_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("ET READING caption text is not observed in the screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Select any option from device drop down -
			if (weatherPage.getdevicedropdown() != null) {
				weatherPage.getdevicedropdown().click();
				if (weatherPage.getDevicestxt() != null) {
					weatherPage.getDevicestxt().click();
					ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Select any option from sensor drop down
					MobileElement SensorDrpDwn4 = (MobileElement) driver.findElement(By.xpath(
							"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[4]"));// UIAStaticText[1]
					SensorDrpDwn4.click();

					if (irrigationPage.getet_reading_item() != null) {
						String sensorTxt = irrigationPage.getet_reading_item().getText();
						irrigationPage.getet_reading_item().click();
						Thread.sleep(5000);
					}
					ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Devices list is not displayed", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				// Verify next button
				if (croppage.getnextButtonTopText() != null) {
					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add("Next  button is enabled in the Current screen and Clicked on Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						croppage.getnextButtonTopText().click();
						Thread.sleep(2000);

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
			} else {
				ATUReports.add("devices drop down list is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			/***************************************************************************************************************
			 * COMPLETE IRRIGATION SETUP
			 ************************************************************************************************************/

			// verify the back button
			verify_Back_button();

			// Verify COMPLETE IRRIGATION SETUP title text.
			if (irrigationPage.getcomplete_irrigation_titletxt() != null) {
				String complete_irrigation_title = irrigationPage.getcomplete_irrigation_titletxt().getText();
				if (complete_irrigation_title.isEmpty()) {
					ATUReports.add("Verify the COMPLETE IRRIGATION SETUP text  in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (complete_irrigation_title.equals("COMPLETE IRRIGATION SETUP")) {
						ATUReports.add("COMPLETE IRRIGATION SETUP is noticed in the screen",
								"COMPLETE IRRIGATION SETUP", complete_irrigation_title, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("COMPLETE IRRIGATION SETUP is not noticed in the screen",
								"COMPLETE IRRIGATION SETUP", complete_irrigation_title, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify Irrigation Body text.
			if (irrigationPage.getcomplete_irrigation_body_txt() != null) {
				String complete_irrigation_body = irrigationPage.getcomplete_irrigation_body_txt().getText();
				// System.out.println(title);
				if (complete_irrigation_body.isEmpty()) {
					ATUReports.add("Complete Irrigation Setup body element is not available in the screen ",
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (complete_irrigation_body.equals(
							"Save the setup to view the irrigation report. Go back to edit any irrigation setup setting.")) {
						ATUReports.add("Complete Irrigation Setup body text is noticed in the screen ",
								"Save the setup to view the irrigation report. Go back to edit any irrigation setup setting.",
								complete_irrigation_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Complete Irrigation Setup caption text is not observed in the screen ",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify next button
			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					ATUReports.add(
							"Save  button is enabled in the  Complete Irrigation Setup screen and Clicked on Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					ATUReports.add("Successfully created the irrigation setup", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getsaveTxt()).release().perform();
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
			System.out.println(
					"*************************** ENDING - Irrigation_UI_Navigation_Flow **************************");

		} catch (Exception e) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			System.out.println(
					"*************************** CATCH - Irrigation_UI_Navigation_Flow **************************");
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

	private void verify_Header() {
		String editirrigation;
		try {
			editirrigation = irrigationPage.editirrigationtxt().getAttribute("name");

			if (editirrigation.isEmpty()) {
				ATUReports.add("Edit Irrigation element is not avaialble in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else if (editirrigation.equals("Edit Irrigation")) {
				ATUReports.add("Edit Irrigation is noticed in the screen ", "Edit Irrigation", editirrigation,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Edit Irrigation is noticed in the screen ", editirrigation, LogAs.FAILED,
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
		try {// Verify the Optional button text
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
