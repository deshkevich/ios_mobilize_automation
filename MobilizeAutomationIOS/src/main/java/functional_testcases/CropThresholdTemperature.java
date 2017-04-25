/*
package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.Account_Page;
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
import utility.ReadViewName;
import utility.ReadWeatherDetails;
import utility.Read_CropPageThresholdValues;
import utility.Read_Crop_Details;
import utility.Read_Frost_Details;

public class CropThresholdTemperature {
	private static FrostPage frostpage;
	private static IOSDriver driver;
	private static CropPage cropPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private JavascriptExecutor js;
	private LoginPage loginpage;
	private ReadUserData readuserdata;
	private ReadUserData readUserData;
	private Read_Crop_Details read_crop;
	private ReadWeatherDetails read_weather_details;
	private Read_Frost_Details read_frost_details;
	private Account_Page accountpage;
	private WebElement row;
	private ReadViewName readviewname;
	// private static CropPage cropPage;
	private Read_CropPageThresholdValues readCrop;
	private static Alert_Page alertpage;

	// private static FrostPage frostpage;
	@Test
	public void cropThresholdTemperature() throws InterruptedException {

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
			accountpage = new Account_Page(driver);
			readviewname = new ReadViewName();
			readviewname.start();
			cropPage = new CropPage(driver);
			readCrop = new Read_CropPageThresholdValues();
			readCrop.start();
			alertpage = new Alert_Page(driver);
			// frostpage = new FrostPage(driver);
			System.out.println("************************ Crop Threshold Screen ***********************");

			System.out
					.println("***************************Staring- CropThresholdTemperature **************************");

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
				//driver.quit();
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
					Thread.sleep(2000);
				} else {
					ATUReports.add("Account button is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on preferences
			if (accountpage.getpreferences() != null) {
				MobileElement preferences = accountpage.getpreferences();
				String tabTextTwo = preferences.getAttribute("name");
				System.out.println(tabTextTwo + "--tabTextTwo--");
				if (preferences.isDisplayed()) {

					ATUReports.add(tabTextTwo + " tab is Displayed and Clicked on sharing tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					preferences.click();
					preferences.click();
					Thread.sleep(2000);
				} else {
					ATUReports.add(tabTextTwo + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify temperature
			int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
			for (int i = 0; i <= size; i++) {
				row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i)
						.findElementByClassName("UIAStaticText");
				if (row != null) {
					if (row.getAttribute("name").contains("Temperature")) {
						row.click();
						TimeUnit.SECONDS.sleep(20);
						ATUReports.add(
								"TemperatureUnits text is noticed in the screen  same as expected and clicked on temperature tap",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						Thread.sleep(2000);
						// Verify 'F' an c from temperature list
						MobileElement fText = (MobileElement) driver.findElement(By.xpath(
								"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));// frostpage.gettemperatureFUnitsTxt();
						String expectedFtxt = fText.getAttribute("name");
						System.out.println(expectedFtxt + "expectedFtxt");
						MobileElement cText = (MobileElement) driver.findElement(By.xpath(
								"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]"));// frostpage.gettempCUnitsTxt();
						String expectedCText = cText.getAttribute("name");
						ATUReports.add(
								"Users preferences Temperature  Units  List is displayed and  One unit is selected by default",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						TimeUnit.SECONDS.sleep(8);

						// Clicked on back button
						MobileElement backBtn = (MobileElement) driver.findElement(
								By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]"));
						if (backBtn != null) {
							backBtn.click();
							Thread.sleep(2000);
							ATUReports.add("Clicked on back button", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						// Click on the Add view button
						if (homepage.getaddbtn() != null) {
							homepage.getaddbtn().click();
							Thread.sleep(3000);
							ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						String viewName = readviewname.viewName;
						System.out.println("ViewName********" + viewName);

						// Enter The verified text in the viewname text field---
						newviewscreenpage.getview_txtfld().sendKeys(viewName);
						String enteredviewName = newviewscreenpage.getview_txtfld().getText();
						System.out.println(enteredviewName);
						if (enteredviewName.isEmpty()) {
							ATUReports.add("Verify the name entered in the View textfield in the screen ",
									enteredviewName, viewName, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (enteredviewName.equals(viewName)) {
								ATUReports.add("Verify the name entered in the View textfield in the screen ",
										enteredviewName, viewName, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Verify the name entered in the View textfield in the screen ",
										enteredviewName, viewName, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
						Thread.sleep(3000);

						// Tab on next
						if (newviewscreenpage.getviewNextBtn() != null) {
							if (newviewscreenpage.getviewNextBtn().isDisplayed()) {
								ATUReports.add("Tap on add button", LogAs.PASSED, null);
								newviewscreenpage.getviewNextBtn().click();
								Thread.sleep(8000);

							} else {
								ATUReports.add("Next  button is not dsplayed", LogAs.FAILED, null);
								newviewscreenpage.getviewNextBtn().click();
								Thread.sleep(8000);
							}

						}

						// Verify Account sharing tutorial box
						if (alertpage.getaccountScreenTutorialBoxTxt() != null) {
							ATUReports.add("Mobilize  screen  tutorial box is displayed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Precondition.tutorialDisalogBoxCreateView(alertpage.getaccountScreenTutorialBoxTxt(),
									alertpage.getcreateViewTutorialNextBtn());

							// click on close icon
							if (alertpage.getcreateViewCloseIcon() != null) {
								alertpage.getcreateViewCloseIcon().click();
								ATUReports.add("Clicked on close icon in screen tutorial box ", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							TimeUnit.SECONDS.sleep(4);

						} else {
							ATUReports.add("Mobilize  screen  tutorial box is not displayed", LogAs.INFO,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						// Click on Crop
						if (newviewscreenpage.getcrop() != null) {
							newviewscreenpage.getcrop().click();
							Thread.sleep(2000);
						}

						// Verify the title text
						if (cropPage.getcropSensorTitle() != null) {
							String crop_sensor_title = cropPage.getcropSensorTitle().getAttribute("name");
							if (crop_sensor_title.isEmpty()) {
								ATUReports.add("Verify the CROP SENSOR INPUT text  in the screen ", "CROP SENSOR INPUT",
										crop_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (crop_sensor_title.equalsIgnoreCase("CROP SENSOR INPUT")) {
									ATUReports.add("CROP SENSOR INPUT is noticed in the screen ", "CROP SENSOR INPUT",
											crop_sensor_title, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("CROP SENSOR INPUT is not observed in the screen ",
											crop_sensor_title, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
						}

						// Select any option from device drop down -
						if (cropPage.getdevicedropdown() != null) {
							// cropPage.getdevicedropdown().click();
							cropPage.getDevicestxt().click();
							ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						// Select any option from sensor drop down
						*/
/*
						 * MobileElement SensorDrpDwn = (MobileElement)
						 * driver.findElement(By.xpath(
						 * "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"
						 * ));// UIAStaticText[1] SensorDrpDwn.click();
						 *//*


						if (cropPage.getSensortxt() != null) {
							String sensorTxt = cropPage.getSensortxt().getAttribute("name");

							cropPage.getSensortxt().click();
							Thread.sleep(2000);
						}
						ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);

						if (cropPage.getnextButtonTopText() != null) {
							if (cropPage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								TouchAction action2 = new TouchAction(driver);
								action2.longPress(cropPage.getnextButtonTopText()).release().perform();
								TimeUnit.SECONDS.sleep(15);
								// croppage.getnextButtonTopText().click();
								Thread.sleep(2000);

							} else {
								ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
						} else {
							if (cropPage.getnext_nxt_save_btn() != null) {
								if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
									Thread.sleep(2000);
									cropPage.getnext_nxt_save_btn().click();
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


						// verify the optional
						if (cropPage.getgrowingDegreeOtpional() != null) {
							cropPage.getgrowingDegreeOtpional().click();
							ATUReports.add("optional Slider is displayed in GROWIG DEGREE START DATE(GOD)",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
											growing_degree_title, LogAs.FAILED,
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

						// Click on Skip button in the Edit Crop -Crop screen.
						if (cropPage.getnextButtonTopText() != null) {
							if (cropPage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								TouchAction action2 = new TouchAction(driver);
								action2.longPress(cropPage.getnextButtonTopText()).release().perform();
								TimeUnit.SECONDS.sleep(15);
								// croppage.getnextButtonTopText().click();
								Thread.sleep(2000);

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
/************************
						 * GDD TARGET
						 ******************************//*


						if (cropPage.getgddTargetTitle() != null) {
							String crop_target = cropPage.getgddTargetTitle().getAttribute("name");
							if (crop_target.isEmpty()) {
								ATUReports.add(" GDD TARGET  element is not available in the screen ", " GDD TARGET ",
										crop_target, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (crop_target.equals("GDD TARGET")) {
									ATUReports.add(" GDD TARGET  is noticed in the screen ", " GDD TARGET ",
											crop_target, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add(" GDD TARGET  is not observed in the screen ", crop_target,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
						}

						MobileElement temparatureBox = cropPage.getgddTargetTextBox();
						String textDefaultText = temparatureBox.getAttribute("value");
						if (cropPage.getgddTargetTextBox() != null && cropPage.getgddTargetTextBox().isDisplayed()) {

							ATUReports.add(
									"Mobilize temparature value text box is displayed, and its default value is - "
											+ textDefaultText,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Entered minimum value
							cropPage.getgddTargetTextBox().click();
							cropPage.getgddTargetTextBox().clear();
							Thread.sleep(3000);
							ATUReports.add("cleared the text filed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							cropPage.getgddTargetTextBox().setValue(readCrop.crop_Gdd_Min);
							Thread.sleep(5000);
							ATUReports.add("Entered minimum value",
									cropPage.getgddTargetTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							*/
/*
							 * // click on done button WebElement doneBtn =
							 * (WebElement)
							 * driver.findElementByAccessibilityId("Done");
							 * Thread.sleep(5000); TouchAction action2 = new
							 * TouchAction(driver);
							 * action2.longPress(doneBtn).release().perform();
							 * Thread.sleep(6000); System.out.println(
							 * "Clicked on done button");
							 *//*


							// Next button is enabled
							// nextButtonEnabled();

							Thread.sleep(1000);
							// Verify out of range value
							cropPage.getgddTargetTextBox().click();
							Thread.sleep(2000);
							cropPage.getgddTargetTextBox().clear();
							Thread.sleep(3000);
							ATUReports.add("cleared the filed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							cropPage.getgddTargetTextBox().setValue(readCrop.crop_Gdd_OutOfRange);
							Thread.sleep(5000);
							ATUReports.add("Entered out of range  value",
									cropPage.getgddTargetTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							*/
/*
							 * // click on done button // WebElement doneBtn =
							 * (WebElement) //
							 * driver.findElementByAccessibilityId("Done");
							 * Thread.sleep(5000); // TouchAction action2 = new
							 * TouchAction(driver);
							 * action2.longPress(doneBtn).release().perform();
							 * Thread.sleep(6000); System.out.println(
							 * "Clicked on done button");
							 *//*


							// Verify Observe Next button is not Enabled.
							nextButtonIsNotEnabled();

							// Verify maximum value
							Thread.sleep(1000);
							cropPage.getgddTargetTextBox().click();
							Thread.sleep(1000);
							cropPage.getgddTargetTextBox().clear();
							Thread.sleep(2000);
							ATUReports.add("cleared the filed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							cropPage.getgddTargetTextBox().setValue(readCrop.crop_Gdd_Max);
							ATUReports.add("Entered out of range  value",
									cropPage.getgddTargetTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(2000);
							*/
/*
							 * // click on done button // WebElement doneBtn =
							 * (WebElement) //
							 * driver.findElementByAccessibilityId("Done");
							 * Thread.sleep(5000); // TouchAction action2 = new
							 * TouchAction(driver);
							 * action2.longPress(doneBtn).release().perform();
							 * Thread.sleep(6000);
							 *//*


							// click on done button

							// click on next
							nextButton();

						} else {
							ATUReports.add("temparature value text box  is not observed in the screen ",
									textDefaultText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							driver.close();
						}

						// -------GDD CALICULATION TYPE---------

						// Verify Crop title text.
						if (cropPage.getgddcalnTitle() != null) {
							String crop_calculation_type = cropPage.getgddcalnTitle().getAttribute("name");
							if (crop_calculation_type.isEmpty()) {
								ATUReports.add("GDD CALCULATION TYPE element is not available in the screen ",
										LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (crop_calculation_type.equals("GDD CALCULATION TYPE")) {
									ATUReports.add("GDD CALCULATION TYPE is noticed in the screen ",
											"GDD CALCULATION TYPE", crop_calculation_type, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								else {
									ATUReports.add("GDD Calculation Type is not observed in the screen ", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
						}

						// click on next
						nextButton();

						// --------LOWER THRESHOLD-------

						// Verify Crop title text.
						String lowerthreshold = cropPage.getlowTemTitle().getAttribute("name");
						if (lowerthreshold.isEmpty()) {
							ATUReports.add("LOWER TEMPERATURE THRESHOLD  element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (lowerthreshold.equalsIgnoreCase("LOWER TEMPERATURE THRESHOLD")) {
								ATUReports.add("LOWER TEMPERATURE THRESHOLD is noticed in the screen ",
										"LOWER THRESHOLD", lowerthreshold, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							else {
								ATUReports.add("LOWER TEMPERATURE THRESHOLD  is not observed in the screen ",
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}

						// Verify F units from temperature box
						String actualTemperatureUnits = cropPage.getcropUnits().getText();
						System.out.println(actualTemperatureUnits + "---actualTemperatureUnits---");
						System.out.println(expectedFtxt + "----expectedTempTxt");

						if (actualTemperatureUnits.isEmpty()) {
							ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (actualTemperatureUnits.contains(expectedFtxt)) {
								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualTemperatureUnits, expectedFtxt, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify Tap on Temperature value box.

								MobileElement temparatureBoxLower = cropPage.getthresholdtxtfld();
								String textDefaultTextTwo = temparatureBoxLower.getAttribute("value");
								System.out.println(textDefaultTextTwo + "---textDefaultText1---");

								if (temparatureBoxLower != null && temparatureBoxLower.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is - "
													+ textDefaultTextTwo,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify minimum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(3000);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									// Thread.sleep(2000);
									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempF_Min);
									Thread.sleep(4000);
									// driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									*/
/*
									 * // click on done button WebElement
									 * doneBtn = (WebElement)
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(4000); TouchAction
									 * action2 = new TouchAction(driver);
									 * action2.longPress(doneBtn).release().
									 * perform(); Thread.sleep(4000);
									 * System.out.println(
									 * "Clicked on done button");
									 *//*


									// Next button is enabled
									// nextButtonEnabled();

									Thread.sleep(2000);
									// Verify out of range value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);

									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempF_OutOfRange);
									Thread.sleep(2000);
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);
									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement)
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); TouchAction
									 * action1 = new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Verify Observe Next button is not
									// Enabled.
									nextButtonIsNotEnabled();

									Thread.sleep(2000);
									// Verify maximum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);

									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempF_Max);
									Thread.sleep(4000);
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Verify Observe Next button is Enabled.
									// clikcedOnNext();
									nextButton();
									nextButton();

								} else {
									ATUReports.add(
											"temparature value text box  is not observed in the screen lower threshold screen ",
											textDefaultTextTwo, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								} // end lower

								// ------UPPER THRESHOLD---------

								// Get optional into enable moode
								if (cropPage.getupperTemOptional() != null) {
									cropPage.getupperTemOptional().click();
									ATUReports.add("optional Slider is displayed in UPPER TEMPERATURE THRESHOLD ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);
								// verify the back button in the CROP SENSOR
								// INPUT screen

								// Verify Crop title text.
								if (cropPage.getupperTemTitle() != null) {
									String upperthreshold = cropPage.getupperTemTitle().getAttribute("name");
									// System.out.println(title);
									if (upperthreshold.isEmpty()) {
										ATUReports.add(
												"UPPER TEMPERATURE THRESHOLD  element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (upperthreshold.equals("UPPER TEMPERATURE THRESHOLD")) {
											ATUReports.add("UPPER TEMPERATURE THRESHOLD  is noticed in the screen ",
													"UPPER THRESHOLD", upperthreshold, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"UPPER TEMPERATURE THRESHOLD  is not observed in the screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								// Verify units
								MobileElement temparatureBoxUpper = cropPage.getthresholdtxtfld();
								String textDefaultTextThree = temparatureBoxUpper.getText();
								System.out.println(textDefaultTextThree + "---textDefaultText---");

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualTemperatureUnits, expectedFtxt, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxUpper != null && temparatureBoxUpper.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is - "
													+ textDefaultTextThree,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Entered out of range value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(2000);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									cropPage.getthresholdtxtfld().clear();
									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									cropPage.getthresholdtxtfld().setValue(readCrop.upper_TempF_OutOfRange);
									Thread.sleep(2000);
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement) driver
									 * .findElementByAccessibilityId("Done");
									 * Thread.sleep(5000); TouchAction action1 =
									 * new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Verify Observe Next button is not
									// Enabled.
									// nextButtonIsNotEnabled();

									Thread.sleep(2000);
									// Entered minimum value
									MobileElement minm = cropPage.getthresholdtxtfld();
									minm.click();
									Thread.sleep(1000);

									cropPage.getthresholdtxtfld().clear();
									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									minm.setValue(readCrop.upper_TempF_Min);

									// System.out.println("entered min value");
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*

									// Next button is enabled
									nextButtonEnabled();

									Thread.sleep(2000);
									// Entered maximum value
									cropPage.getthresholdtxtfld().click();

									cropPage.getthresholdtxtfld().clear();
									Thread.sleep(2000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									// cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().setValue(readCrop.upper_Temp_MaxF);

									// System.out.println("entered max value");
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(4000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(4000);
									 *//*


									// clikcedOnNext();
									nextButton();
									nextButton();
								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextThree, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

								// ----------CUTT OFF METHOD-------------

								// Verify Crop title text.
								if (cropPage.getcutOffTitle() != null) {
									String cutoffmethod = cropPage.getcutOffTitle().getAttribute("name");
									// System.out.println(title);
									if (cutoffmethod.isEmpty()) {
										ATUReports.add("CUTOFF METHOD element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (cutoffmethod.equals("CUTOFF METHOD")) {
											ATUReports.add("CUTOFF METHOD is noticed in the screen ", "CUTOFF METHOD",
													cutoffmethod, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

										else {
											ATUReports.add("CUTOFF METHOD is not observed in the screen ", LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								// click on next
								nextButton();

								// -------------CHILL START
								// DATE----------------------

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
									ATUReports.add("CHILL START DATE element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillstartdate.equalsIgnoreCase("CHILL START DATE")) {
										ATUReports.add("CHILL START DATE is noticed in the screen ", "CHILL START DATE",
												chillstartdate, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("CHILL START DATE is not observed in the screen ", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// verify the date is enabled or not and then
								// Click on
								// the date tab
								if (cropPage.getdatePickerChilSrtDt() != null) {
									cropPage.getdatePickerChilSrtDt().click();

									// Click on done button
									cropPage.getDone().click();
									Thread.sleep(2000);
								}

								// click on next
								nextButton();

								// -------------CHILL START CALCULATION
								// METHOD----
								// Verify Crop title text.
								String chillcalculationtdate = cropPage.getchillCalnTitle().getAttribute("name");
								// System.out.println(title);
								if (chillcalculationtdate.isEmpty()) {
									ATUReports.add("CHILL CALCULATION METHOD element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillcalculationtdate.equals("CHILL CALCULATION METHOD")) {
										ATUReports.add("CHILL CALCULATION METHOD is noticed in the screen ",
												"CHILL CALCULATION METHOD", chillcalculationtdate, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("CHILL CALCULATION METHOD is not observed in the screen ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// click on next
								nextButton();
								/// ---------CHILLING TARGET-------------

								// Verify Crop title text.
								if (cropPage.getchiltartxt() != null) {
									String chillingthreshold = cropPage.getchiltartxt().getAttribute("name");
									// System.out.println(title);
									if (chillingthreshold.isEmpty()) {
										ATUReports.add("CHILLING TARGET element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (chillingthreshold.equals("CHILLING TARGET")) {
											ATUReports.add("CHILLING TARGET is noticed in the screen ",
													"CHILLING TARGET", chillingthreshold, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("CHILLING TARGET is not observed in the screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								Thread.sleep(5000);

								// Verify chilling target temp units
								MobileElement temparatureBoxtarget = cropPage.getChillingTxtBx();
								String textDefaultTextFour = temparatureBoxtarget.getText();
								System.out.println(textDefaultTextFour + "---textDefaultTextFour---");
								String targetUnits = cropPage.getChillingTxtBx().getText();

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										targetUnits, targetUnits, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxtarget != null && temparatureBoxtarget.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is Empty - "
													+ textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Enter minimum value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(1000);
									cropPage.getChillingTxtBx().clear();
									// cropPage.getChillingTxtBx().sendKeys(Keys.DELETE);
									// cropPage.getChillingTxtBx().sendKeys(Keys.ENTER);
									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_Min);

									ATUReports.add("Entered minimum value in the threshold field ", textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(4000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement) driver
									 * .findElementByAccessibilityId("Done");
									 * Thread.sleep(4000); TouchAction action1 =
									 * new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(4000);
									 *//*


									// Next button is enabled
									// nextButtonEnabled();

									Thread.sleep(2000);
									// Enter out of range value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(2000);
									cropPage.getChillingTxtBx().clear();

									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_OutOfRange);
									// driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getChillingTxtBx().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);
									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*

									// Verify Observe Next button is not
									// Enabled.
									nextButtonIsNotEnabled();

									Thread.sleep(2000);
									// Enter maximum value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(1000);
									cropPage.getChillingTxtBx().clear();
									Thread.sleep(3000);
									ATUReports.add("cleared the filed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_Max);
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getChillingTxtBx().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// clikcedOnNext
									nextButton();
									// clikcedOnNext
									nextButton();

									// Verify COMPLETE CROP SETUP title text.
									if (cropPage.getcompleteCropSetUpTitle() != null) {
										String complete_crop_setup = cropPage.getcompleteCropSetUpTitle()
												.getAttribute("name");
										if (complete_crop_setup.isEmpty()) {
											ATUReports.add("Verify the Complete Crop Setup text  in the screen ",
													"Complete Crop Setup", complete_crop_setup, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (complete_crop_setup.equalsIgnoreCase("COMPLETE CROP SETUP")) {
												ATUReports.add(
														"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
														"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Complete Crop Setup is not observed in the screen ",
														complete_crop_setup, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}
									}

									// Verify save button
									if (cropPage.getsaveTxt() != null) {
										if (cropPage.getsaveTxt().isDisplayed()) {
											ATUReports.add(
													" Save button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											TouchAction action2 = new TouchAction(driver);
											action2.longPress(cropPage.getsaveTxt()).release().perform();
											TimeUnit.SECONDS.sleep(15);
											// croppage.getnextButtonTopText().click();
											Thread.sleep(2000);

										} else {
											ATUReports.add("Save button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
									} else {
										if (cropPage.getnext_nxt_save_btn() != null) {
											if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
												Thread.sleep(2000);
												cropPage.getnext_nxt_save_btn().click();
												Thread.sleep(2000);
												ATUReports.add(
														" Save button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Save button is not enabled in the current screen`",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
										}

									}

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextFour, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

							} else {// C unitslower threshold
								if (actualTemperatureUnits.contains(expectedCText)) {

									ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
											actualTemperatureUnits, expectedCText, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									System.out.println(actualTemperatureUnits + "----actualTemperatureUnits-c-");

									// Verify Tap on Temperature value box.

									MobileElement temparatureBoxLower = cropPage.getthresholdtxtfld();
									String textDefaultTextTwo = temparatureBoxLower.getAttribute("value");
									System.out.println(textDefaultTextTwo + "---textDefaultText1---");

									// Verify minimum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									// cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);

									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempC_Min);
									driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(4000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement) driver
									 * .findElementByAccessibilityId("Done");
									 * Thread.sleep(5000); TouchAction action1 =
									 * new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Next button is enabled
									nextButtonEnabled();

									// Verify out of range value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);

									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempC_OutOfRange);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*

									// Verify Observe Next button is not
									// Enabled.
									nextButtonIsNotEnabled();

									// Verify maximum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									*/
/*
									 * cropPage.getthresholdtxtfld().sendKeys(
									 * Keys.DELETE);
									 * cropPage.getthresholdtxtfld().sendKeys(
									 * Keys.INSERT);
									 *//*

									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().setValue(readCrop.low_TempC_Max);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// clikcedOnNext
									nextButton();
									nextButton();

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											expectedCText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}
								// ------UPPER THRESHOLD---------

								// Get optional into enable moode
								if (cropPage.getupperTemOptional() != null) {
									cropPage.getupperTemOptional().click();
									ATUReports.add("optional Slider is displayed in UPPER TEMPERATURE THRESHOLD ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);
								// verify the back button in the CROP SENSOR
								// INPUT screen

								// Verify Crop title text.
								if (cropPage.getupperTemTitle() != null) {
									String upperthreshold = cropPage.getupperTemTitle().getAttribute("name");
									// System.out.println(title);
									if (upperthreshold.isEmpty()) {
										ATUReports.add(
												"UPPER TEMPERATURE THRESHOLD  element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (upperthreshold.equals("UPPER TEMPERATURE THRESHOLD")) {
											ATUReports.add("UPPER TEMPERATURE THRESHOLD  is noticed in the screen ",
													"UPPER THRESHOLD", upperthreshold, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"UPPER TEMPERATURE THRESHOLD  is not observed in the screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								// Verify units
								MobileElement temparatureBoxUpper = cropPage.getthresholdtxtfld();
								String textDefaultTextThree = temparatureBoxUpper.getText();
								System.out.println(textDefaultTextThree + "---textDefaultText---");

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualTemperatureUnits, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxUpper != null && temparatureBoxUpper.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is - "
													+ textDefaultTextThree,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Entered maximum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().clear();

									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().setValue(readCrop.upper_TempC_Max);
									// driver.hideKeyboard();
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement) driver
									 * .findElementByAccessibilityId("Done");
									 * Thread.sleep(5000); TouchAction action1 =
									 * new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Next button is enabled
									nextButtonEnabled();

									// Entered out of range value

									cropPage.getthresholdtxtfld().click();
									cropPage.getthresholdtxtfld().clear();
									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().setValue(readCrop.upper_TempC_OutOfRange);
									// driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(6000);

									*/
/*
									 * // click on done button //
									 * System.out.println("click on done //
									 * button"); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Verify Observe Next button is not
									// Enabled.
									// nextButtonIsNotEnabled();

									// Entered minimum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().clear();
									// cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().setValue(readCrop.upper_TempC_Min);
									driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);

									*/
/*
									 * // System.out.println("click on done //
									 * button"); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// clikcedOnNext();
									nextButton();

									// clikcedOnNext();
									nextButton();

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextThree, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

								// ----------CUTT OFF METHOD-------------

								// Verify Crop title text.
								if (cropPage.getcutOffTitle() != null) {
									String cutoffmethod = cropPage.getcutOffTitle().getAttribute("name");
									// System.out.println(title);
									if (cutoffmethod.isEmpty()) {
										ATUReports.add("CUTOFF METHOD element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (cutoffmethod.equals("CUTOFF METHOD")) {
											ATUReports.add("CUTOFF METHOD is noticed in the screen ", "CUTOFF METHOD",
													cutoffmethod, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

										else {
											ATUReports.add("CUTOFF METHOD is not observed in the screen ", LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								// clikcedOnNext();
								nextButton();
								*/
/*
								 * // click on next button if
								 * (cropPage.getnext_nxt_save_btn().isEnabled())
								 * { cropPage.getnext_nxt_save_btn().click();
								 * ATUReports.add(
								 * "Skip  button is enabled and Clicked on Skip button in the CUT OFF screen "
								 * , LogAs.PASSED, new
								 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								 *
								 * } else { ATUReports.add(
								 * "Skip  button is not enabled", LogAs.FAILED,
								 * new
								 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
								 *//*

								// -------------CHILL START
								// DATE----------------------

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
									ATUReports.add("CHILL START DATE element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillstartdate.equalsIgnoreCase("CHILL START DATE")) {
										ATUReports.add("CHILL START DATE is noticed in the screen ", "CHILL START DATE",
												chillstartdate, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("CHILL START DATE is not observed in the screen ", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// verify the date is enabled or not and then
								// Click on
								// the date tab
								if (cropPage.getdatePickerChilSrtDt() != null) {
									cropPage.getdatePickerChilSrtDt().click();

									// Click on done button
									cropPage.getDone().click();
									Thread.sleep(2000);
								}

								// Verify next btuuon
								if (cropPage.getnextButtonTopText() != null) {
									if (cropPage.getnextButtonTopText().isDisplayed()) {
										ATUReports.add(
												"Next button is enabled in the Current screenand clicked on the Next button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										TimeUnit.SECONDS.sleep(2);

										TouchAction action2 = new TouchAction(driver);
										action2.longPress(cropPage.getnextButtonTopText()).release().perform();
										TimeUnit.SECONDS.sleep(15);
										// croppage.getnextButtonTopText().click();
										Thread.sleep(2000);

									} else {
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
									ATUReports.add("CHILL CALCULATION METHOD element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillcalculationtdate.equals("CHILL CALCULATION METHOD")) {
										ATUReports.add("CHILL CALCULATION METHOD is noticed in the screen ",
												"CHILL CALCULATION METHOD", chillcalculationtdate, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("CHILL CALCULATION METHOD is not observed in the screen ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// Verify next btuuon
								if (cropPage.getnextButtonTopText() != null) {
									if (cropPage.getnextButtonTopText().isDisplayed()) {
										ATUReports.add(
												"Next button is enabled in the Current screenand clicked on the Next button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										TimeUnit.SECONDS.sleep(2);

										TouchAction action2 = new TouchAction(driver);
										action2.longPress(cropPage.getnextButtonTopText()).release().perform();
										TimeUnit.SECONDS.sleep(15);
										// croppage.getnextButtonTopText().click();
										Thread.sleep(2000);

									} else {
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
										ATUReports.add("CHILLING TARGET element is not available in the screen ",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (chillingthreshold.equals("CHILLING TARGET")) {
											ATUReports.add("CHILLING TARGET is noticed in the screen ",
													"CHILLING TARGET", chillingthreshold, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("CHILLING TARGET is not observed in the screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
								}

								Thread.sleep(5000);

								// Verify chilling target temp units
								MobileElement temparatureBoxtarget = cropPage.getChillingTxtBx();
								String textDefaultTextFour = temparatureBoxtarget.getText();
								System.out.println(textDefaultTextFour + "---textDefaultTextFour---");
								String targetUnits = cropPage.getChillingTxtBx().getAttribute("name");

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										targetUnits, targetUnits, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxtarget != null && temparatureBoxtarget.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is Empty - "
													+ textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Enter maximum value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(2000);
									cropPage.getChillingTxtBx().clear();
									// cropPage.getChillingTxtBx().sendKeys(Keys.INSERT);
									Thread.sleep(3000);

									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_Max);
									// driver.hideKeyboard();
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getChillingTxtBx().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);
									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); MobileElement doneBtn2 =
									 * (MobileElement) driver
									 * .findElementByAccessibilityId("Done");
									 * Thread.sleep(5000); TouchAction action1 =
									 * new TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Next button is enabled
									nextButtonEnabled();

									// Enter out of range value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(1000);
									cropPage.getChillingTxtBx().clear();
									// cropPage.getChillingTxtBx().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_OutOfRange);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getChillingTxtBx().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(4000);

									*/
/*
									 * // click on done button
									 * System.out.println("click on done button"
									 * ); // MobileElement doneBtn2 =
									 * (MobileElement) //
									 * driver.findElementByAccessibilityId(
									 * "Done"); Thread.sleep(5000); //
									 * TouchAction action1 = new //
									 * TouchAction(driver);
									 * action1.longPress(doneBtn2).release().
									 * perform(); Thread.sleep(5000);
									 *//*


									// Verify Observe Next button is not
									// Enabled.
									nextButtonIsNotEnabled();

									// Enter minimum value
									cropPage.getChillingTxtBx().click();
									Thread.sleep(2000);
									cropPage.getChillingTxtBx().clear();
									// cropPage.getChillingTxtBx().sendKeys(Keys.INSERT);
									Thread.sleep(4000);
									cropPage.getChillingTxtBx().setValue(readCrop.chilling_Target_Min);
									// driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ", textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);

									// click on done button
									System.out.println("click on done button");
									WebElement doneBtn2 = (WebElement) driver.findElementByAccessibilityId("Done");
									Thread.sleep(5000);
									TouchAction action1k = new TouchAction(driver);
									action1k.longPress(doneBtn2).release().perform();
									Thread.sleep(5000);

									// clikcedOnNext
									// nextButton();

									// clikcedOnNext
									nextButton();

									*/
/***************************************************************************************************************
									 * COMPLETE CROP SETUP SCREEN *
									 ************************************************************************************************************//*


									// Verify COMPLETE CROP SETUP title text.
									if (cropPage.getcompleteCropSetUpTitle() != null) {
										String complete_crop_setup = cropPage.getcompleteCropSetUpTitle()
												.getAttribute("name");
										if (complete_crop_setup.isEmpty()) {
											ATUReports.add("Verify the Complete Crop Setup text  in the screen ",
													"Complete Crop Setup", complete_crop_setup, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (complete_crop_setup.equalsIgnoreCase("COMPLETE CROP SETUP")) {
												ATUReports.add(
														"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
														"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Complete Crop Setup is not observed in the screen ",
														complete_crop_setup, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}
									}

									// Verify save button
									// Verify next btuuon
									if (cropPage.getsaveTxt() != null) {
										if (cropPage.getsaveTxt().isDisplayed()) {
											ATUReports.add(
													" Save button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(2000);
											TouchAction action2 = new TouchAction(driver);
											action2.longPress(cropPage.getsaveTxt()).release().perform();
											TimeUnit.SECONDS.sleep(15);
											// croppage.getnextButtonTopText().click();
											Thread.sleep(2000);

										} else {
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
												ATUReports.add("Next button is not enabled in the current screen`",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
										}

									}

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextFour, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

							}
						}

						break;
					} else {
						ATUReports.add("Users Temperature  list is not displayed not contains temperature text",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}
				// row

			} // for loop

		} catch (InterruptedException i) {// InterruptedException i
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			i.printStackTrace();
		}
		System.out.println("***************************ENDING- CropThresholdTemperature **************************");

	}

	public static void nextButton() throws InterruptedException {

		if (cropPage.getnextButtonTopText() != null) {
			if (cropPage.getnextButtonTopText().isDisplayed()) {
				ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				TimeUnit.SECONDS.sleep(2);

				TouchAction action2 = new TouchAction(driver);
				action2.longPress(cropPage.getnextButtonTopText()).release().perform();
				TimeUnit.SECONDS.sleep(15);
				// croppage.getnextButtonTopText().click();
				Thread.sleep(2000);

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
					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

	public static void nextButtonEnabled() throws InterruptedException {

		if (cropPage.getnextButtonTopText() != null) {
			if (cropPage.getnextButtonTopText().isDisplayed()) {
				Thread.sleep(2000);
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} else {
			if (cropPage.getnext_nxt_save_btn() != null) {
				if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
					Thread.sleep(2000);
					// croppage.getnext_nxt_save_btn().click();

					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

	public static void nextButtonIsNotEnabled() throws InterruptedException {

		if (cropPage.getnextButtonTopText() != null) {
			if (cropPage.getnextButtonTopText().isDisplayed()) {
				Thread.sleep(2000);
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} else {
			if (cropPage.getnext_nxt_save_btn() != null) {
				if (cropPage.getnext_nxt_save_btn().isDisplayed()) {
					Thread.sleep(2000);
					ATUReports.add("Next button is enabled in the in the current screen ", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

	public static void backButton() throws InterruptedException {

		if (frostpage.gettempUnitsPageBackBtnName() != null) {
			if (frostpage.gettempUnitsPageBackBtnName().isEnabled()) {
				ATUReports.add("Back button is enabled in the in the current screen and clicked on the back button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				TimeUnit.SECONDS.sleep(2);
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
					ATUReports.add("Back button is enabled in the in the current screen and clicked on the back button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {

					ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

		}

	}
}
*/
