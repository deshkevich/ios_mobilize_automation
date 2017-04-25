package functional_testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

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
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.Read_Crop_Details;
import utility.Read_Frost_Details;

public class Verify_Edit_Crop_Report {

	private IOSDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newscreenpage;
	private FrostPage frostpage;
	private Read_Frost_Details read_frost_details;
	private JavascriptExecutor js;
	private WeatherPage weatherPage;
	private CropPage cropPage;
	// private Read_Crop_Details readcropdetails ;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private NewViewScreenPage newviewscreenpage;
	private Read_Crop_Details read_crop;
	private WebElement row;
	private static CropPage croppage;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Test
	public void verifyEditCropView() throws InterruptedException {

		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);

		newscreenpage = new NewViewScreenPage(driver);
		croppage = new CropPage(driver);
		frostpage = new FrostPage(driver);
		read_frost_details = new Read_Frost_Details();
		read_frost_details.start();
		weatherPage = new WeatherPage(driver);
		js = (JavascriptExecutor) driver;
		cropPage = new CropPage(driver);
		// readcropdetails = new Read_Crop_Details();
		// readcropdetails.start();
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		Thread.sleep(2000);
		read_crop = new Read_Crop_Details();
		read_crop.start();

		try {

			System.out
					.println("***************************Staring- Verify_Edit_Crop_Report **************************");
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

			// Verify view list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(15);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (newscreenpage.getsettingsiconcrop() != null
							&& newscreenpage.getsettingsiconcrop().isDisplayed()) {
						newscreenpage.getsettingsiconcrop().click();
						Thread.sleep(5000);
						break;

					} else {
						if (frostpage.gettempUnitsPageBackBtnName() != null) {
							if (frostpage.gettempUnitsPageBackBtnName().isEnabled()) {
								ATUReports.add(
										"Back button is enabled in the in the current screen and clicked on the back button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								TimeUnit.SECONDS.sleep(5);
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
									TimeUnit.SECONDS.sleep(2);
									frostpage.gettempUnitsPageBackBtn().click();
									TimeUnit.SECONDS.sleep(2);
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

			// Verify the Edit Weather text
			List<WebElement> list = driver.findElements(By.className("UIAStaticText"));
			if (list.get(1) != null) {
				String editweather = list.get(1).getText();

				if (editweather.isEmpty()) {
					ATUReports.add("Verify the Walk-through Setup in the screen ", "Walk-through Setup", editweather,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else if (editweather.equals("Walk-through Setup")) {
					ATUReports.add("Walk-through Setup is noticed in the screen ", "Walk-through Setup", editweather,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Edit Weather is not noticed in the screen ", "Walk-through Setup", editweather,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			// Verify the Edit Weather title
			MobileElement editsettings = newscreenpage.geteditsettings();
			if (editsettings != null) {
				String weathertxt = editsettings.getAttribute("label");
				if (weathertxt.isEmpty()) {
					ATUReports.add("Edit Settings element is empty ", weathertxt, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (weathertxt.equals("Edit Settings")) {
						ATUReports.add("Edit Settings is displayed", weathertxt, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Edit Settings is not displayed", weathertxt, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				editsettings.click();
				Thread.sleep(5000);
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

			// Click on next button in the Crop Sensor Input
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					// croppage.getnextButtonTopText().click();
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

			/**********************************
			 * CROP & VARIETY
			 ***********************************/

			/*
			 * // get the value of the optional and click on it if
			 * (cropPage.getcropVarietyOptional()!= null) {
			 * cropPage.getcropVarietyOptional().click(); ATUReports.add(
			 * "optional Slider is displayed in crop & Variety", LogAs.PASSED,
			 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			 * Thread.sleep(2000); }
			 */

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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			} /*****************************
				 * GROWING DEGREE START DATE
				 ******************************/
			/*
			 * // verify the optional if (cropPage.getgrowingDegreeOtpional()!=
			 * null) { cropPage.getgrowingDegreeOtpional().click();
			 * ATUReports.add(
			 * "optional Slider is displayed in GROWIG DEGREE START DATE(GOD)" ,
			 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
			 * Thread.sleep(2000);
			 */

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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/*****************************
			 * GDD TARGET
			 ******************************/

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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/*****************************************************
			 * GDD CALCULATION TYPE SCREEN
			 ***********************************************************/

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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/*****************************************************
			 * LOWER TEMPERATURE THRESHOLD SCREEN
			 ***********************************************************/

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

			// Verify on Plus icon
			Add_Frost.plusIconButton(cropPage.getLwrplusBtn());

			// Verify on minus icon
			Add_Frost.minusIconButton(cropPage.getLwrminusBtn());

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/*****************************************************
			 * UPPER THRESHOLD SCREEN
			 ***********************************************************/

			/*
			 * // Get optional into enable moode if
			 * (cropPage.getupperTemOptional() != null) {
			 * cropPage.getupperTemOptional().click(); ATUReports.add(
			 * "optional Slider is displayed in UPPER TEMPERATURE THRESHOLD ",
			 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
			 * Thread.sleep(2000);
			 */
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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			} /***************************************************************************************************************
				 * CUTOFF METHOD SCREEN *
				 ************************************************************************************************************/

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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * CHILL START DATE SCREEN *
			 ************************************************************************************************************/

			/*
			 * // Get optional into enable moode if
			 * (cropPage.getchillstrtDateOptional() != null) {
			 * cropPage.getchillstrtDateOptional().click(); ATUReports.add(
			 * "optional Slider is displayed in CHILL START DATE", LogAs.PASSED,
			 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
			 * Thread.sleep(2000);
			 */
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

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * CHILL CALCULATION METHOD SCREEN *
			 ************************************************************************************************************/

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

			// Verify next button
			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * CHILLING TARGET SCREEN *
			 ************************************************************************************************************/

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

			// click on minus icon
			if (cropPage.getChllinhTrgtMinus() != null) {
				Add_Frost.minusIconButton(cropPage.getChllinhTrgtMinus());
				ATUReports.add(
						"Minus icon is displayed and clicked on Minus icon then Temperature value decreased"
								+ cropPage.getChillingTxtBx().getText(),
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(5000);
			}

			Thread.sleep(2000);
			// Click on next button 
			if(cropPage.getnextButtonTopText()!=null){
				if(cropPage.getnextButtonTopText().isDisplayed()){
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(cropPage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				}else{
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}else{
				if(cropPage.getnext_nxt_save_btn()!=null){
					if(cropPage.getnext_nxt_save_btn().isDisplayed()){
						Thread.sleep(2000);
						cropPage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					}else{
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * COMPLETE CROP SETUP SCREEN *
			 ************************************************************************************************************/

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

			// Verify save btn
			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					TimeUnit.SECONDS.sleep(2);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					Thread.sleep(2000);
					ATUReports.add("Save button is enabled in the complete CROP setup and clicked on the Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					ATUReports.add("Successfully created the CROP setup by skipping optional data", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
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

		} catch (NullPointerException e) {
			e.printStackTrace();
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
		}
		System.out.println("***************************Ending- Verify_Edit_Crop_Report **************************");

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
