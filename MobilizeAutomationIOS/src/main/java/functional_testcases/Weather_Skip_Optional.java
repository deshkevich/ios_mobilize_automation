package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.CropPage;
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

public class Weather_Skip_Optional {

	private IOSDriver driver;
	private WeatherPage weatherPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private ReadWeatherDetails read_weather_details;
	private static CropPage croppage;

	@Test
	public void weather_Skip_Optional() throws InterruptedException {

		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		weatherPage = new WeatherPage(driver);
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		read_weather_details = new ReadWeatherDetails();
		read_weather_details.start();
		croppage = new CropPage(driver);
		try {

			System.out.println("*************************** Weather_Skip_Optional **************************");
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
			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();
				TimeUnit.SECONDS.sleep(2);
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Enter The verified text in the view name text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_weather_details.uniqueweather);
				ATUReports.add("Entered some value in the text box", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			TimeUnit.SECONDS.sleep(2);

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				// Click on Add button
				newviewscreenpage.getviewNextBtn().click();
				Thread.sleep(3000);
				TimeUnit.SECONDS.sleep(3);
				ATUReports.add("Clicked on the Next button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Click on the Weather
			if (newviewscreenpage.getWeather() != null) {
				newviewscreenpage.getWeather().click();
				TimeUnit.SECONDS.sleep(2);
				ATUReports.add("Clicked on the Weather option displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verify the Edit Weather text
			if (weatherPage.getEditweather() != null) {
				String editweather = weatherPage.getEditweather().getAttribute("name");
				// System.out.println(editfrost);
				if (editweather.isEmpty()) {
					ATUReports.add("Verify the Weather in the screen ", "Weather", editweather, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else if (editweather.equals("Weather")) {
					ATUReports.add("Weather is noticed in the screen ", "Weather", editweather, LogAs.PASSED,
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

			// Select any option from device drop down -
			if (weatherPage.getdevicedropdown() != null) {
				// weatherPage.getdevicedropdown().click();
				weatherPage.getDevicestxt().click();
				ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify skip
			if (croppage.getskipBtn() != null) {
				if (croppage.getskipBtn().isDisplayed()) {
					ATUReports.add(
							"Skip button is enabled in the Current screen 10-MINUTE AVERAGE WIND ALERT and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getskipBtn()).release().perform();
					TimeUnit.SECONDS.sleep(15);

				} else {
					ATUReports.add("Skip button is not enabled in the current screen 10-MINUTE AVERAGE WIND ALERT",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					if (croppage.getnextButtonTopText().isDisplayed()) {
						ATUReports.add(
								"Next button is enabled in the Current screen and 10-MINUTE AVERAGE WIND ALERT clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						TouchAction action2 = new TouchAction(driver);
						action2.longPress(croppage.getnextButtonTopText()).release().perform();
						TimeUnit.SECONDS.sleep(15);
						ATUReports.add(
								"Next button is enabled in the Current screen 10-MINUTE AVERAGE WIND ALERT and clicked on the Next button",
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
								"Next button is enabled in the in the current screen 10-MINUTE AVERAGE WIND ALERT and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the current screen 10-MINUTE AVERAGE WIND ALERT",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

			// Verify the Optional button text
			String Optional1 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional1.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional1.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional1, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional1, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
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
			TimeUnit.SECONDS.sleep(2);

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

			// Verify the Optional button text
			String Optional5 = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional5.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional5.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional5, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional5, LogAs.FAILED,
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

			// Verify the body text in the Weather
			String complete_weather_body = weatherPage.getcomplete_weather_body_txt().getText();
			if (complete_weather_body.isEmpty()) {
				ATUReports.add("Verify the Complete Weather Setup caption text  in the screen ",
						"Save the setup to view the weather report. Go back to edit any weather setup setting.",
						complete_weather_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (complete_weather_body.equals(
						"Save the setup to view the weather report. Go back to edit any weather setup setting.")) {
					ATUReports.add("Complete Weather Setup caption text is dispalyed in the screen ",
							"Save the setup to view the weather report. Go back to edit any weather setup setting.",
							complete_weather_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Complete Weather Setup caption text is not dispalyed in the screen ",
							complete_weather_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on save button
			if (croppage.getsaveTxt() != null) {
				if (croppage.getsaveTxt().isDisplayed()) {
					ATUReports.add(
							"Save button is enabled in the complete Weather setup and clicked on the Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					TouchAction action2 = new TouchAction(driver);
					action2.longPress(croppage.getsaveTxt()).release().perform();
					TimeUnit.SECONDS.sleep(15);
					ATUReports.add("Successfully created the Weather setup by skipping optional data", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

			System.out.println("*************************** ENDING Weather_Skip_Optional **************************");

		} catch (Exception e) {
			System.out.println("*************************** CATCH Weather_Skip_Optional **************************");
				driver.resetApp();
				TimeUnit.SECONDS.sleep(20);
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
}

/*
 * // enter user name in the user name text box MobileElement username =
 * loginpage.getUserNametxtbx(); if (username.isDisplayed()) {
 * 
 * loginpage.getUserNametxtbx().sendKeys(readUserData.sUserName); }else{
 * driver.quit(); }
 * 
 * //Click on Next button MobileElement next = loginpage.getNextButton(); if
 * (next.isDisplayed()) { next.click(); }else{ driver.quit(); }
 * 
 * // enter password in the Password in the text box MobileElement password =
 * loginpage.getPasswordtxtbx(); if (password.isDisplayed()) {
 * password.sendKeys(readUserData.sPassword);
 * 
 * } else { driver.quit();
 * 
 * }
 * 
 * //Click on Next button MobileElement nextPawd=loginpage.getnextPswd();
 * nextPawd.click();
 */
