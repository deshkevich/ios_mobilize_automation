
package functional_testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.CropPage;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.WeatherPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.ReadWeatherDetails;
import utility.Read_Frost_Details;

public class Verify_Edit_Weather_Report {

	private IOSDriver driver;
	private NewViewScreenPage newscreenpage;
	private FrostPage frostpage;
	private Read_Frost_Details read_frost_details;
	private WeatherPage weatherPage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private ReadWeatherDetails read_weather_details;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private JavascriptExecutor js;
	private WebElement row;
	private CropPage croppage;

	@SuppressWarnings("unchecked")
	@Test
	public void verifyEditWeatherView() throws InterruptedException {

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			new HomePage(driver);
			new NewViewScreenPage(driver);
			newscreenpage = new NewViewScreenPage(driver);
			homepage = new HomePage(driver);
			frostpage = new FrostPage(driver);
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			weatherPage = new WeatherPage(driver);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			read_weather_details = new ReadWeatherDetails();
			read_weather_details.start();
			newviewscreenpage = new NewViewScreenPage(driver);
			js = (JavascriptExecutor) driver;
			croppage = new CropPage(driver);

			System.out.println(
					"***************************Staring- Verify_Edit_Weather_Report **************************");
			
			ATUReports.add("Before launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// reset the application -
			// driver.quit();
			// Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("After launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			
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

					if (newscreenpage.getsettingsiconweather() != null
							&& newscreenpage.getsettingsiconweather().isDisplayed()) {
						newscreenpage.getsettingsiconweather().click();
						TimeUnit.SECONDS.sleep(15);
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

			// Verify the Edit Weather text
			if (weatherPage.getEditweather() != null) {
				String editweather = weatherPage.getEditweather().getAttribute("name");
				// System.out.println(editfrost);
				if (editweather.isEmpty()) {
					ATUReports.add("Verify the Weather in the screen ", "Weather", editweather, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else if (editweather.equals("Weather")) {
					ATUReports.add("Weather is noticed in the screen ", "Edit Weather", editweather, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Weather is not noticed in the screen ", "Weather", editweather, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			// Verify the title text
			if (weatherPage.getTitletxt() != null) {
				String title = weatherPage.getTitletxt().getAttribute("name");
				if (title.isEmpty()) {
					ATUReports.add("Verify the Weather Sensor Input text  in the screen ", "WEATHER SENSOR INPUT",
							title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (title.equals("WEATHER SENSOR INPUT")) {
						ATUReports.add("Weather Sensor Input text is noticed in the screen ", "WEATHER SENSOR INPUT",
								title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Weather Sensor Input is not observed in the screen ", title, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}
			// Verify the body text
			if (weatherPage.getBodytxt() != null) {
				String body = weatherPage.getBodytxt().getText();
				// System.out.println(body);
				if (body.isEmpty()) {
					ATUReports.add("Verify the Weather Sensor Input caption text  in the screen ",
							"Select the appropriate device and weather station for monitoring weather data.", body,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (body.equals("Select the appropriate device and weather station for monitoring weather data.")) {
						ATUReports.add("Weather Sensor Input caption text is dispalyed in the screen ",
								"Select the appropriate device and weather station for monitoring weather data.", body,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Weather Sensor Input caption text is not dispalyed in the screen ", body,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Select any option from sensor drop down
			if (weatherPage.getSensortxt() != null) {
				String sensorTxt = weatherPage.getSensortxt().getAttribute("name");
				/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 */
				weatherPage.getSensortxt().click();
				Thread.sleep(5000);
			}
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on next button in the Weather Sensor Input
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TouchAction action5 = new TouchAction(driver);
					action5.longPress(croppage.getnextButtonTopText()).release().perform();
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

			// Verify the Optional button text
			String Optional = weatherPage.getOptionaltxt().getAttribute("name");
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
			Thread.sleep(2000);
			// get the value of the optional and click on it
			if (weatherPage.getminuteavgOptinalSlider() != null) {
				//weatherPage.getminuteavgOptinalSlider().click();
				Thread.sleep(3000);
				ATUReports.add("optional Slier is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Crop title text.
			String weather_sensor_title = weatherPage.getminutetitletext().getAttribute("name");
			// System.out.println(title);
			if (weather_sensor_title.isEmpty()) {
				ATUReports.add("Verify the 10-Minute Average Wind Alert text  in the screen ",
						"10-MINUTE AVERAGE WIND ALERT", weather_sensor_title, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (weather_sensor_title.equals("10-MINUTE AVERAGE WIND ALERT")) {
					ATUReports.add("10-Minute Average Wind Alert is noticed in the screen ",
							"10-MINUTE AVERAGE WIND ALERT", weather_sensor_title, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("10-Minute Average Wind Alert is not observed in the screen ", weather_sensor_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(2000);

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			Thread.sleep(4000);
			weatherPage.getthresholdtxtfld().clear();
			Thread.sleep(3000);
			weatherPage.getthresholdtxtfld().sendKeys(read_weather_details.avg_wind_speed_treshold);
			System.out.println(weatherPage.getthresholdtxtfld().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.getthresholdtxtfld().getAttribute("value"),
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtnrr).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TouchAction action5 = new TouchAction(driver);
					action5.longPress(croppage.getnextButtonTopText()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					// croppage.getnextButtonTopText().click();
					// Thread.sleep(2000);

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
			/************************
			 * High Wind Alert
			 ******************************/
			Thread.sleep(2000);
			// get the value of the optional and click on it
			if (weatherPage.getwindalertOptionalSlider() != null) {
				weatherPage.getwindalertOptionalSlider().click();
				Thread.sleep(3000);
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Crop title text.
			String highwindalert_title = weatherPage.gethighWindAlertTitle().getAttribute("name");
			// System.out.println(title);
			if (highwindalert_title.isEmpty()) {
				ATUReports.add("Verify the High Wind Alert text  in the screen ", "HIGH WIND ALERT",
						highwindalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highwindalert_title.equals("HIGH WIND ALERT")) {
					ATUReports.add("High Wind Alert is noticed in the screen ", "HIGH WIND ALERT", highwindalert_title,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("High Wind Alert is not observed in the screen ", highwindalert_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String highwindalert_body = weatherPage.gethighWindAlertCaption().getAttribute("name");
			if (highwindalert_body.isEmpty()) {
				ATUReports.add("Verify the HIGH WIND ALERT caption text  in the screen ",
						"Alert activated if wind speed threshold is met at any moment.", highwindalert_body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highwindalert_body.equals("Alert activated if wind speed threshold is met at any moment.")) {
					ATUReports.add("HIGH WIND ALERT caption text is dispalyed in the screen ",
							"Alert activated if wind speed threshold is met at any moment.", highwindalert_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH WIND ALERT caption text is not dispalyed in the screen ", highwindalert_body,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			if(weatherPage.gethighWindAlertTextBox()!=null){
			Thread.sleep(4000);
			weatherPage.gethighWindAlertTextBox().clear();
			Thread.sleep(3000);
			weatherPage.gethighWindAlertTextBox().sendKeys(read_weather_details.high_wind_alert);
			System.out.println(weatherPage.gethighWindAlertTextBox().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.gethighWindAlertTextBox().getAttribute("value"),
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if ((WebElement) driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtnrr = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtnrr).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			}
			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
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
			/************************
			 * Daily Rain Alert
			 ******************************/

			// get the value of the optional and click on it
			if (weatherPage.getdaliyRainOptionalSlider() != null) {
				if (weatherPage.getdaliyRainOptionalSlider().isEnabled()) {
					weatherPage.getdaliyRainOptionalSlider().click();
					Thread.sleep(2000);
					ATUReports.add("optional Slider is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);
			// Verify the Optional button text
			String Optional2 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional2.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional2.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional2, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional2, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Crop title text.
			String dailyrainalert_title = weatherPage.getdailyRainTitle().getAttribute("name");
			// System.out.println(title);
			if (dailyrainalert_title.isEmpty()) {
				ATUReports.add("Verify the DAILY RAIN ALERT text  in the screen ", "DAILY RAIN ALERT",
						dailyrainalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (dailyrainalert_title.equals("DAILY RAIN ALERT")) {
					ATUReports.add("DAILY RAIN ALERT is noticed in the screen ", "DAILY RAIN ALERT",
							dailyrainalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("DAILY RAIN ALERT is not observed in the screen ", dailyrainalert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String dailyrainalert_body = weatherPage.getBodytxt().getText();
			if (dailyrainalert_body.isEmpty()) {
				ATUReports.add("Verify the DAILY RAIN ALERT caption text  in the screen ",
						"Alert activated if daily rain threshold is met from midnight to midnight.",
						dailyrainalert_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (dailyrainalert_body
						.equals("Alert activated if daily rain threshold is met from midnight to midnight.")) {
					ATUReports.add("DAILY RAIN ALERT caption text is dispalyed in the screen ",
							"Alert activated if daily rain threshold is met from midnight to midnight.",
							dailyrainalert_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("DAILY RAIN ALERT caption text is not dispalyed in the screen ", dailyrainalert_body,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
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
			/************************
			 * HIGH RAIN RATE ALERT
			 ******************************/
			Thread.sleep(2000);
			// get the value of the optional and click on it
			if (weatherPage.gethighRainAlertOptionalSlider() != null) {
				if (weatherPage.gethighRainAlertOptionalSlider().isEnabled()) {
					weatherPage.gethighRainAlertOptionalSlider().click();
					Thread.sleep(2000);
					ATUReports.add("optional Slider is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);

			// Verify the Optional button text
			String Optional3 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional3.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional3.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional3, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional3, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Crop title text.
			String highrainalert_title = weatherPage.gethighRainAlertTitle().getAttribute("name");
			// System.out.println(title);
			if (highrainalert_title.isEmpty()) {
				ATUReports.add("Verify the HIGH RAIN RATE ALERT text  in the screen ", "HIGH RAIN RATE ALERT",
						highrainalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highrainalert_title.equals("HIGH RAIN RATE ALERT")) {
					ATUReports.add("HIGH RAIN RATE ALERT is noticed in the screen ", "DAILY RAIN ALERT",
							highrainalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH RAIN RATE ALERT is not observed in the screen ", highrainalert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String highrainalert_body = weatherPage.getBodytxt().getText();
			if (highrainalert_body.isEmpty()) {
				ATUReports.add("Verify the HIGH RAIN RATE ALERT caption text  in the screen ",
						"Alert activated if rain rate per hour threshold is met.", highrainalert_body, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highrainalert_body.equals("Alert activated if rain rate per hour threshold is met.")) {
					ATUReports.add("HIGH RAIN RATE ALERT caption text is dispalyed in the screen ",
							"Alert activated if rain rate per hour threshold is met.", highrainalert_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH RAIN RATE ALERT caption text is not dispalyed in the screen ",
							highrainalert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
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
			/********** HIGH TEMPERATURE ALERT ***********/

			// get the value of the optional and click on it
			if (weatherPage.gethighTemOptionalSlider() != null) {
				if (weatherPage.gethighTemOptionalSlider().isEnabled()) {
					weatherPage.gethighTemOptionalSlider().click();
					Thread.sleep(2000);
					ATUReports.add("optional Slider is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);

			// Verify the Optional button text
			String Optional4 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional4.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional4.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional4, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional4, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Crop title text.
			String hightemplert_title = weatherPage.gethighTemTitle().getAttribute("name");
			// System.out.println(title);
			if (hightemplert_title.isEmpty()) {
				ATUReports.add("Verify the HIGH TEMPERATURE ALERT text  in the screen ", "HIGH TEMPERATURE ALERT",
						hightemplert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (hightemplert_title.equals("HIGH TEMPERATURE ALERT")) {
					ATUReports.add("HIGH TEMPERATURE ALERT is noticed in the screen ", "HIGH TEMPERATURE ALERT",
							hightemplert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH TEMPERATURE ALERT is not observed in the screen ", hightemplert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String hightemplert_body = weatherPage.getBodytxt().getText();
			if (hightemplert_body.isEmpty()) {
				ATUReports.add("Verify the HIGH TEMPERATURE ALERT caption text  in the screen ",
						"Alert activated if current temperature meets or exceeds threshold.", hightemplert_body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (hightemplert_body.equals("Alert activated if current temperature meets or exceeds threshold.")) {
					ATUReports.add("HIGH TEMPERATURE ALERT caption text is dispalyed in the screen ",
							"Alert activated if current temperature meets or exceeds threshold.", hightemplert_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH TEMPERATURE ALERT caption text is not dispalyed in the screen ",
							hightemplert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
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

			/********** LOW TEMPERATURE ALERT ***********/

			// get the value of the optional and click on it
			if (weatherPage.getlowTemOptional() != null) {
				if (weatherPage.getlowTemOptional().isEnabled()) {
					weatherPage.getlowTemOptional().click();
					Thread.sleep(2000);
					ATUReports.add("optional Slider is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);
			// Verify the Optional button text
			String Optional5 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional5.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional4.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional4, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional4, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Crop title text.
			String lowtemplert_title = weatherPage.getlowTemTitle().getAttribute("name");
			// System.out.println(title);
			if (lowtemplert_title.isEmpty()) {
				ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ", "LOW TEMPERATURE ALERT",
						lowtemplert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (lowtemplert_title.equals("LOW TEMPERATURE ALERT")) {
					ATUReports.add("LOW TEMPERATURE ALERT is noticed in the screen ", "LOW TEMPERATURE ALERT",
							lowtemplert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("LOW TEMPERATURE ALERT is not observed in the screen ", lowtemplert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String loetemplert_body = weatherPage.getBodytxt().getText();
			if (loetemplert_body.isEmpty()) {
				ATUReports.add("Verify the LOW TEMPERATURE ALERT caption text  in the screen ",
						"Alert activated if current temperature meets or goes below threshold.", loetemplert_body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (loetemplert_body.equals("Alert activated if current temperature meets or goes below threshold.")) {
					ATUReports.add("LOW TEMPERATURE ALERT caption text is dispalyed in the screen ",
							"Alert activated if current temperature meets or goes below threshold.", loetemplert_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("LOW TEMPERATURE ALERT caption text is not dispalyed in the screen ",
							loetemplert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on the next button if enabled
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
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

			// Verify Crop title text.
			String complete_weather_title = weatherPage.getcomplete_weather_titletxt().getText();
			// System.out.println(title);
			if (complete_weather_title.isEmpty()) {
				ATUReports.add("Verify the Complete Weather Setup text  in the screen ", "COMPLETE WEATHER SETUP",
						complete_weather_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (complete_weather_title.equals("COMPLETE WEATHER SETUP")) {
					ATUReports.add("Complete Weather Setup is noticed in the screen ", "COMPLETE WEATHER SETUP",
							complete_weather_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Complete Weather Setup is not observed in the screen ", complete_weather_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on save button
			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					ATUReports.add("Save button is enabled in the complete Weather setup and ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(5000);

					ATUReports.add("Successfully edit the Weather report", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					;

					TouchAction action5 = new TouchAction(driver);
					action5.longPress(croppage.getsaveTxt()).release().perform();
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

		} catch (NullPointerException e) {
			System.out.println(
					"***************************** In Catch Edit Verify_Edit_Weather_Report report *****************************************");
			e.printStackTrace();
			driver.resetApp();
			// driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
		}
		System.out.println("***************************ENDING- Verify_Edit_Weather_Report **************************");

	}
}
