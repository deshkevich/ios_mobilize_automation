package functional_testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

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
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.Read_Frost_Details;
import utility.Read_Irrigation_Details;

public class Verify_Edit_Irrigation_Report {
	private IOSDriver driver;
	private HomePage homepage;
	private WebElement row;
	private WebElement row1;
	private NewViewScreenPage newscreenpage;
	private FrostPage frostpage;
	private Read_Frost_Details read_frost_details;
	private IrrigationPage irrigationPage;
	private Read_Irrigation_Details read_irrigation;
	// private NewViewScreenPage newviewscreenpage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private WeatherPage weatherPage;
	private CropPage croppage;

	@SuppressWarnings({ "static-access", "unchecked" })
	@Test
	public void verifyEditirrigationView() throws InterruptedException {
		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			new NewViewScreenPage(driver);
			newscreenpage = new NewViewScreenPage(driver);
			frostpage = new FrostPage(driver);
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			new WeatherPage(driver);
			new CropPage(driver);
			irrigationPage = new IrrigationPage(driver);
			read_irrigation = new Read_Irrigation_Details();
			read_irrigation.start();
			// newscreenpage = new NewViewScreenPage(driver);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			weatherPage = new WeatherPage(driver);
			croppage = new CropPage(driver);

			System.out.println(
					"***************************Staring- Verify_Edit_Irrigation_Report **************************");
			
			TimeUnit.SECONDS.sleep(10);
			ATUReports.add("Before launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// reset the application 
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("after launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
				// Verify view list
				if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i);
					row.click();
					TimeUnit.SECONDS.sleep(20);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (newscreenpage.getsettingsiconirrigation() != null
							&& newscreenpage.getsettingsiconirrigation().isEnabled()) {
						if (newscreenpage.getsettingsiconirrigation().isDisplayed()) {
							newscreenpage.getsettingsiconirrigation().click();
							TimeUnit.SECONDS.sleep(10);
							ATUReports.add("irigation settings is dispalyed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							break;
						} else {
							// Scroll to rain rate option
							driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
								{
									put("element",
											((RemoteWebElement) driver.findElement(By.name("Edit View"))).getId());
								}
							});
							TimeUnit.SECONDS.sleep(15);
							ATUReports.add("Scroll to Edit View", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							if (newscreenpage.getsettingsiconirrigation().isDisplayed()) {
								newscreenpage.getsettingsiconirrigation().click();
								TimeUnit.SECONDS.sleep(5);
								ATUReports.add("irigation settings is dispalyed", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							break;
						}

					} else {

						if (frostpage.gettempUnitsPageBackBtnName() != null) {
							if (frostpage.gettempUnitsPageBackBtnName().isEnabled()) {
								ATUReports.add(
										"Back button is enabled in the in the current screen and clicked on the back button",
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
				// System.out.println(editfrost);
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

			if (newscreenpage.geteditsettings() != null) {
				MobileElement editsettings = newscreenpage.geteditsettings();
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
			}
			TimeUnit.SECONDS.sleep(10);

			/*
			 * // get the value of the optional and click on it if
			 * (irrigationPage.getetsoilMoistreOtionalSlider()!=null) {
			 * irrigationPage.getetsoilMoistreOtionalSlider().click();
			 * ATUReports.add("optional Slier is not displayed",
			 * LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
			 */
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

			/*
			 * // Select any option from device drop down -
			 * irrigationPage.getdevicedropdown().click();
			 * irrigationPage.getDevicestxt().click(); ATUReports.add(
			 * "Clicked on the device drop down and selected the xcube Gatewaay 1E"
			 * , LogAs.PASSED, new CaptureScreen( ScreenshotOf.BROWSER_PAGE));
			 * 
			 * // Select any option from sensor drop down
			 */

			// MobileElement SensorDrpDwn = (MobileElement)
			// driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[2]"));//UIAStaticText[1]
			// SensorDrpDwn.click();
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
			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add(
							"Next  button is enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action5 = new TouchAction(driver);
					action5.longPress(croppage.getnextButtonTopText()).release().perform();
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
			 * SATURATION THRESHOLD
			 ************************************************************************************************************/

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getsaturtnOptionalSlider() != null) {
				if (irrigationPage.getsaturtnOptionalSlider().isEnabled()) {
					irrigationPage.getsaturtnOptionalSlider() .click();
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
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

			// Enter some value in the Saturation
			if (irrigationPage.getsaturatnPlusBtn() != null) {
				irrigationPage.getsaturatnPlusBtn().click();
				ATUReports.add("Clicked on Increment button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			

			// Verify next button
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
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * WILTING THRESHOLD
			 ************************************************************************************************************/

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getwiltingtOptionalSlider() != null) {
				if (irrigationPage.getwiltingtOptionalSlider().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify Chill start date title text.
					if (irrigationPage.titletxt() != null) {
						String wilting_thresold_body = irrigationPage.titletxt().getText();
						if (wilting_thresold_body.isEmpty()) {
							ATUReports.add("Verify the WILTING THRESHOLD text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (wilting_thresold_body.equals("WILTING THRESHOLD")) {
								ATUReports.add("WILTING THRESHOLD is noticed in the screen", "WILTING THRESHOLD",
										wilting_thresold_body, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("WILTING THRESHOLD is not noticed in the screen", "WILTING THRESHOLD",
										wilting_thresold_body, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

					// Verify Irrigation Body text.
					if (irrigationPage.bodytxt() != null) {
						String wilting_body = irrigationPage.bodytxt().getText();
						// System.out.println(title);
						if (wilting_body.isEmpty()) {
							ATUReports.add("Wilting Threshold body element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
					// Enter some value in the Saturation
					if (irrigationPage.getwlitingPlusBtn() != null) {
						irrigationPage.getwlitingPlusBtn().click();
						ATUReports.add("Clicked on Increment button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					Thread.sleep(2000);

				}
			}
			// Verify next button
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
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * EARLY WARNING THRESHOLD
			 ************************************************************************************************************/
			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getearlyOptional() != null) {
				if (irrigationPage.getearlyOptional().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify Chill start date title text.
					if (irrigationPage.titletxt() != null) {
						String early_thresold_title = irrigationPage.titletxt().getText();
						if (early_thresold_title.isEmpty()) {
							ATUReports.add("Verify the EARLY WARNING THRESHOLD text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (early_thresold_title.equals("EARLY WARNING THRESHOLD")) {
								ATUReports.add("EARLY WARNING THRESHOLD is noticed in the screen",
										"EARLY WARNING THRESHOLD", early_thresold_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
							ATUReports.add("Early Warning Thresholdbody element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

				}
			}

			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(10);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * LOW EC THRESHOLD
			 ************************************************************************************************************/
			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getlowSalinityOptional() != null) {
				if (irrigationPage.getlowSalinityOptional().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify Chill start date title text.
					if (irrigationPage.titletxt() != null) {
						String low_ec_thresold_title = irrigationPage.titletxt().getText();
						if (low_ec_thresold_title.isEmpty()) {
							ATUReports.add("Verify the LOW SALINITY THRESHOLD text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (low_ec_thresold_title.equals("LOW SALINITY THRESHOLD")) {
								ATUReports.add("LOW SALINITY THRESHOLD is noticed in the screen",
										"LOW SALINITY THRESHOLD", low_ec_thresold_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("LOW SALINITY THRESHOLD is not noticed in the screen",
										"LOW SALINITY THRESHOLD", low_ec_thresold_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

					// Verify Irrigation Body text.
					if (irrigationPage.bodytxt() != null) {
						String low_ec_thresold_body = irrigationPage.bodytxt().getText();
						// System.out.println(title);
						if (low_ec_thresold_body.isEmpty()) {
							ATUReports.add("Low Salinity Threshold body element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
					if (irrigationPage.getlowSalinityPlusBtn() != null) {
						irrigationPage.getlowSalinityPlusBtn().click();
						ATUReports.add("Clicked on Increment button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					Thread.sleep(2000);
				}
			}
			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(10);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * HIGH EC THRESHOLD
			 ************************************************************************************************************/
			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.gethighSalinityOptional() != null) {
				if (irrigationPage.gethighSalinityOptional().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify HIGH EC THRESHOLD title text.
					if (irrigationPage.titletxt() != null) {
						String high_ec_thresold_title = irrigationPage.titletxt().getText();
						if (high_ec_thresold_title.isEmpty()) {
							ATUReports.add("Verify the HIGH SALINITY THRESHOLD text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (high_ec_thresold_title.contains("HIGH SALINITY THRESHOLD")) {
								ATUReports.add("HIGH SALINITY THRESHOLD is noticed in the screen",
										"HIGH SALINITY THRESHOLD", high_ec_thresold_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
					if (irrigationPage.gethighSalntyPlus() != null) {
						irrigationPage.gethighSalntyPlus().click();
						ATUReports.add("Clicked on Increment button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					Thread.sleep(2000);
				}
			}

			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(10);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * PRESSURE SENSOR/SWITCH
			 ************************************************************************************************************/
			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getpressureOptional() != null) {
				if (irrigationPage.getpressureOptional().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify Chill start date title text.
					if (irrigationPage.titletxt() != null) {
						String pressure_sensor_title = irrigationPage.titletxt().getText();
						if (pressure_sensor_title.isEmpty()) {
							ATUReports.add("Verify the PRESSURE SENSOR/SWITCH text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (pressure_sensor_title.contains("PRESSURE SENSOR/SWITCH")) {
								ATUReports.add("PRESSURE SENSOR/SWITCH is noticed in the screen",
										"PRESSURE SENSOR/SWITCH", pressure_sensor_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("PRESSURE SENSOR/SWITCH is not noticed in the screen",
										"PRESSURE SENSOR/SWITCH", pressure_sensor_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

						}
					}

					// Verify Irrigation Body text.
					if (irrigationPage.bodytxt() != null) {
						String pressure_sensor_body = irrigationPage.bodytxt().getText();
						// System.out.println(title);
						if (pressure_sensor_body.isEmpty()) {
							ATUReports.add("Pressure Sensor/Switch body element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (pressure_sensor_body.contains(
									"Select the appropriate device and sensor input for monitoring irrigation status.")) {
								ATUReports.add("Pressure Sensor/Switch body text is noticed in the screen ",
										"Select the appropriate device and sensor input for monitoring irrigation status.",
										pressure_sensor_body, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Pressure Sensor/Switch caption text is not observed in the screen ",
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

				}
			}
			if (irrigationPage.getsensortxt_item() != null) {
				String sensorTxt = irrigationPage.getsensortxt_item().getText();
				/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 */
				irrigationPage.getsensortxt_item().click();
				Thread.sleep(5000);
				ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * FLOW METER SENSOR
			 ************************************************************************************************************/

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getflowMtrOptionalSlider() != null) {
				if (irrigationPage.getflowMtrOptionalSlider().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify FLOW METER SENSOR title text.
					if (irrigationPage.titletxt() != null) {
						String flow_meter_sensor_title = irrigationPage.titletxt().getText();
						if (flow_meter_sensor_title.isEmpty()) {
							ATUReports.add("Verify the FLOW METER SENSOR text  in the screen ", LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							if (flow_meter_sensor_title.equals("FLOW METER SENSOR")) {
								ATUReports.add("FLOW METER SENSOR is noticed in the screen", "FLOW METER SENSOR",
										flow_meter_sensor_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("FLOW METER SENSOR is not noticed in the screen", "FLOW METER SENSOR",
										flow_meter_sensor_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

					// Verify Irrigation Body text.
					if (irrigationPage.bodytxt() != null) {
						String flow_meter_sensor_body = irrigationPage.bodytxt().getText();
						// System.out.println(title);
						if (flow_meter_sensor_body.isEmpty()) {
							ATUReports.add("Flow Meter Sensor body element is not available in the screen ",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (flow_meter_sensor_body.contains(
									"Select the appropriate device and sensor input for monitoring irrigation flow status.")) {
								ATUReports.add("Flow Meter Sensor body text is noticed in the screen ",
										"Select the appropriate device and sensor input for monitoring irrigation flow status.",
										flow_meter_sensor_body, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("FLOW METER SENSOR caption text is not observed in the screen ",
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}
				}
			}

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
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}
			/***************************************************************************************************************
			 * ET READING
			 ************************************************************************************************************/

			// verify the optional text
			verify_Optionaltxt();

			// get the value of the optional and click on it
			if (irrigationPage.getetReadngOptional() != null) {
				if (irrigationPage.getetReadngOptional().isEnabled()) {
					ATUReports.add("optional Slider is enabled", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					irrigationPage.getetReadngOptional().click();
					Thread.sleep(3000);

					// Verify ET READING title text.
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
								ATUReports.add("ET READING is not noticed in the screen", "ET READING",
										et_reading_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
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

			if (irrigationPage.getdevicesdropdown() != null) {
				if (irrigationPage.getdevicesdropdown().isDisplayed()) {

					irrigationPage.getdevicesdropdown().click();
					if (weatherPage.getDevicestxt() != null) {
						weatherPage.getDevicestxt().click();
						ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Select any option from sensor drop down
						MobileElement SensorDrpDwn4 = (MobileElement) driver.findElement(By.xpath(
								"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[4]"));
						SensorDrpDwn4.click();

						if (irrigationPage.getet_reading_item() != null) {
							String sensorTxt = irrigationPage.getet_reading_item().getText();
							/*
							 * if (sensorTxt.equals("")) {
							 * 
							 * }
							 */
							irrigationPage.getet_reading_item().click();
							Thread.sleep(5000);
						}
						ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Devices list is not displayed it displays : There are no devices available ","There are no devices available",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				} else {
					ATUReports.add("Devices list is not displayed it displays : There are no devices available ","There are no devices available",
							LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify next button
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(8);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					// croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
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
						ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}

			}

			/***************************************************************************************************************
			 * COMPLETE IRRIGATION SETUP
			 ************************************************************************************************************/

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

			// Verify save button
			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					ATUReports.add(
							"Save  button is enabled in the  Complete Irrigation Setup screen and Clicked on Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(3000);

					ATUReports.add("Successfully created the irrigation setup", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// croppage.getsaveTxt().click();
					Thread.sleep(2000);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(15);

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
		System.out
				.println("***************************ENDING- Verify_Edit_Irrigation_Report **************************");

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

	private void verify_Back_button() {

		// Verify the back button text
		String back_btn;
		try {
			back_btn = irrigationPage.getbackbtn().getText();

			if (back_btn.isEmpty()) {
				ATUReports.add("Back button element is not visible", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (back_btn.equals("Back")) {
					ATUReports.add("Back text is noticed in the screen ", "Back", back_btn, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Back is not observed in the screen ", back_btn, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}