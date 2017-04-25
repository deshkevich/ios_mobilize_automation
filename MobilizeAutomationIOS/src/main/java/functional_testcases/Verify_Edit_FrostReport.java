package functional_testcases;

//The view name is BP4281
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.ReadUserData;
import utility.Read_Frost_Details;
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

public class Verify_Edit_FrostReport {

	@SuppressWarnings("rawtypes")
	private IOSDriver driver;
	private HomePage homepage;
	private WebElement row;
	private NewViewScreenPage newscreenpage;
	private FrostPage frostpage;
	private Read_Frost_Details read_frost_details;
	private JavascriptExecutor js;
	private WeatherPage weatherPage;
	private Sheet sh;
	private ExcelUtils eu;
	private String viewname;
	private LoginPage loginpage;
	private NewViewScreenPage newviewscreenpage;
	private ReadUserData readUserData;
	private static CropPage croppage;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void verifyEditFr53zostView() throws InterruptedException, IOException {

		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		frostpage = new FrostPage(driver);
		read_frost_details = new Read_Frost_Details();
		read_frost_details.start();
		weatherPage = new WeatherPage(driver);
		loginpage = new LoginPage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		js = (JavascriptExecutor) driver;
		croppage = new CropPage(driver);
		try {
			System.out.println("***************************Staring- Verify_Edit_FrostReport **************************");

			TimeUnit.SECONDS.sleep(10);
			//Reset app
			try{
				if(homepage.gethomebutton()!=null){
					if(homepage.gethomebutton().isDisplayed()){
						ATUReports.add("Home button is displayed and enabled in the home screen ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						homepage.gethomebutton().click();
						TimeUnit.SECONDS.sleep(25);

					}
				}else{
					ATUReports.add("Home button is not displayed in current screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					ATUReports.add("Before The close",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					// reset the application - 
					driver.resetApp();
					TimeUnit.SECONDS.sleep(30);
					ATUReports.add("After The Launch",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}catch(Exception e){
				ATUReports.add("In The Catch",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
				// reset the application - 
				//close the application
				//driver.quit();
				//Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			
			TimeUnit.SECONDS.sleep(6);

			//Verify view list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(15);
					if (newscreenpage.getSettings() != null && newscreenpage.getSettings().isDisplayed()) {
						newscreenpage.getSettings().click();
						TimeUnit.SECONDS.sleep(15);
						break;
					} else {

						// Verify back
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



			/******************************
			 * FROST SENSOR INPUT
			 **************************************/

			// Verify the title text
			String titleText = frostpage.getfrostSensorTitle().getText();
			System.out.println(titleText + "---ttile--");
			if (titleText.isEmpty()) {
				ATUReports.add("Verify the Sensor Input text  in the screen ", "FROST SENSOR INPUT".toUpperCase(),
						titleText, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (titleText.equalsIgnoreCase("FROST SENSOR INPUT")) {
					ATUReports.add("FROST SENSOR INPUT text is noticed in the screen ", "FROST SENSOR INPUT", titleText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("FROST SENSOR INPUT text is not observed in the screen ", titleText, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			// Verify the body text
			String body = frostpage.getfrostSensorCaption().getText();
			// System.out.println(body);
			if (body.isEmpty()) {
				ATUReports.add("Verify the Frost Sensor Input caption text  in the screen ",
						"Select the appropriate device and sensor inputs for monitoring frost data.", body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (body.contains("Select the appropriate device and sensor inputs for monitoring frost data.")) {
					ATUReports.add("Frost Sensor Input caption text  in the screen",
							"Select the appropriate device and sensor inputs for monitoring frost data.", body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost Sensor Input caption text  is not displayed in the screen", body,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(4000);

			frostpage.getsensordropdown().click();
			Thread.sleep(2000);

			// Click on next button in the Sensor Input
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//croppage.getnextButtonTopText().click();
					Thread.sleep(7000);
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
						/*TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);*/
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

			/**********************************************************
			 * FROST THRESHOLD
			 **********************************************************/
			// get the value of the optional and click on it

			if (frostpage.getplusIcon() != null) {
				ATUReports.add("Verify the 10-Minute Average Wind Alert text  in the screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				frostpage.getplusIcon().click();
			}

			if (frostpage.getfrostThresholdtitletxt() != null) {
				// Verify the title text in the Frost Threshold
				String FrostThreshold_title = frostpage.getfrostThresholdtitletxt().getText();
				if (FrostThreshold_title.isEmpty()) {
					ATUReports.add("Verify the FROST THRESHOLD text  in the screen ", "FROST THRESHOLD",
							FrostThreshold_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (FrostThreshold_title.equals("FROST THRESHOLD")) {
						ATUReports.add("FROST THRESHOLD text is noticed in the screen ", "FROST THRESHOLD",
								FrostThreshold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("FROST THRESHOLD text is not observed in the screen ", FrostThreshold_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Verify caption
			if (frostpage.getfrostThresholdCaption() != null) {

				// Verify the body text
				String FrostThreshold_body = frostpage.getfrostThresholdCaption().getAttribute("name");

				if (FrostThreshold_body.isEmpty()) {
					ATUReports.add("Verify the Frost Threshold caption text  in the screen ",
							"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
							FrostThreshold_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (FrostThreshold_body.equals(
							"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.")) {
						ATUReports.add("Frost threshold caption text is dispalyed in the screen ",
								"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
								FrostThreshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Frost threshold caption text is not dispalyed in the screen ",
								FrostThreshold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//croppage.getnextButtonTopText().click();
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
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

			/******************************
			 * FROST THRESHOLD
			 **************************************/

			// get the value of the optional and click on it
			if (frostpage.getearlyFrostOptionalSlider() != null) {
				if (frostpage.getearlyFrostOptionalSlider().isEnabled()) {
					ATUReports.add("Optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (frostpage.geteralyFrostPlusIcon() != null) {
						frostpage.geteralyFrostPlusIcon().click();
						ATUReports.add("Clicked on High Wind Increment icon in the screen ", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					if (frostpage.getearlyTitle() != null) {

						// Verify the Early Frost Warning screen
						String Early_Frost_Warning_title = frostpage.getearlyTitle().getAttribute("name");
						if (Early_Frost_Warning_title.isEmpty()) {
							ATUReports.add("Verify the EARLY FROST WARNING text  in the screen ", "EARLY FROST WARNING",
									Early_Frost_Warning_title, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (Early_Frost_Warning_title.equals("EARLY FROST WARNING")) {
								ATUReports.add("EARLY FROST WARNING text is displayed", "Early Frost Warning",
										Early_Frost_Warning_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("EARLY FROST WARNING", Early_Frost_Warning_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

					// Verify the body text
					String Early_Frost_Warning_body = frostpage.getBodytxt().getText();
					if (Early_Frost_Warning_body.isEmpty()) {
						ATUReports.add("Verify the Early Frost Warning caption text  in the screen ",
								"An early warning for frost will give you advanced notice if you are nearing your Frost forecast.",
								Early_Frost_Warning_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (Early_Frost_Warning_body.equals(
								"Early warning threshold is set to alert for cases where frost may soon follow.")) {
							ATUReports.add("Early Frost Warning caption text is dispalyed in the screen ",
									"Early warning threshold is set to alert for cases where frost may soon follow.",
									Early_Frost_Warning_body, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Early Frost Warning caption text is not dispalyed in the screen ",
									Early_Frost_Warning_body, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

				} else {
					ATUReports.add("optional Slider is not enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//croppage.getnextButtonTopText().click();
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
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
			/******************************
			 * EARLY FROST WARNING
			 **************************************/

			// Verify title text
			if (frostpage.getcompletefrost_titletxt() != null) {
				String COMPLETE_FROST_SETUP_title = frostpage.getcompletefrost_titletxt().getText();
				if (COMPLETE_FROST_SETUP_title.isEmpty()) {
					ATUReports.add("Verify the Complete Frost Setup text  in the screen ", "COMPLETE FROST SETUP",
							COMPLETE_FROST_SETUP_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (COMPLETE_FROST_SETUP_title.equals("COMPLETE FROST SETUP")) {
						ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ", "COMPLETE FROST SETUP",
								COMPLETE_FROST_SETUP_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen", COMPLETE_FROST_SETUP_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			Thread.sleep(2000);
			if (frostpage.getcompletefrostbodytxt() != null) {
				// Verify the body text
				String complete_Frost_setup_body = frostpage.getcompletefrostbodytxt().getText();
				// System.out.println(body);
				if (complete_Frost_setup_body.isEmpty()) {
					ATUReports.add("Verify the COMPLETE FROST SETUP caption text  in the screen ",
							"Save the setup to view the frost report. Go back to edit any frost setup setting.",
							complete_Frost_setup_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (complete_Frost_setup_body.equals(
							"Save the setup to view the frost report. Go back to edit any frost setup setting.")) {
						ATUReports.add("COMPLETE FROST SETUP caption text is dispalyed in the screen ",
								"Save the setup to view the frost report.Go back to edit any frost setup setting.",
								complete_Frost_setup_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("COMPLETE FROST SETUP caption text is not dispalyed in the screen ",
								complete_Frost_setup_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Click on save button

			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					ATUReports.add("Successfully created the Frost setup by skipping optional data", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//croppage.getsaveTxt().click();
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					Thread.sleep(2000);

				} else {
					ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					ATUReports.add("Unable to create Frost by skipping the optional data", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} else {
				if (croppage.getnext_nxt_save_btn() != null) {
					if (croppage.getnext_nxt_save_btn().isDisplayed()) {
						Thread.sleep(2000);
						croppage.getnext_nxt_save_btn().click();
						Thread.sleep(2000);
						ATUReports.add(
								"Save button is enabled in the in the current screen and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						ATUReports.add("Unable to create Weather by skipping the optional data", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			TimeUnit.SECONDS.sleep(10);
			if(homepage.gethomebutton()!=null){
				if(homepage.gethomebutton().isDisplayed()){
					ATUReports.add("Home button is displayed and enabled in the home screen ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					homepage.gethomebutton().click();
					TimeUnit.SECONDS.sleep(10);

				}
			}

		} catch (NullPointerException e) {
			System.out.println("The row element is not displayed");
			ATUReports.add("First Table Row is not dispalyed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Log.error("Table Row is not dispalyed");
			System.out.println(
					"***************************** In Catch Edit Frost report *****************************************");
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);

			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The row element is not displayed");
			ATUReports.add("First Table Row is not dispalyed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Log.error("Table Row is not dispalyed");
			e.printStackTrace();
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
		
		}

		System.out.println("***************************Ending- Verify_Edit_FrostReport **************************");

	}
}
