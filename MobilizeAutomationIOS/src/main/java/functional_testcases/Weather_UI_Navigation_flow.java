package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utility.ReadUserData;
import utility.ReadWeatherDetails;
import Pages.CropPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.WeatherPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

//Update the Unique weather name in the weather details excel sheet 
public class Weather_UI_Navigation_flow {

	private static IOSDriver driver;
	private WeatherPage weatherPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private ReadWeatherDetails read_weather_details;
	private JavascriptExecutor js;
	private LoginPage loginpage;
	private ReadUserData readUserData;

	private static CropPage croppage;

	@Test
	public void Add_weather() {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			weatherPage = new WeatherPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			js = (JavascriptExecutor) driver;
			read_weather_details = new ReadWeatherDetails();
			read_weather_details.start();
			Thread.sleep(9000);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			croppage = new CropPage(driver);
			ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");
			
			
			System.out.println("*************************** Weather_UI_Navigation_flow **************************");

			TimeUnit.SECONDS.sleep(8);
			//Reset app
			if(homepage.gethomebutton()!=null){
				if(homepage.gethomebutton().isDisplayed()){
					ATUReports.add("Home button is displayed and enabled in the home screen ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					homepage.gethomebutton().click();
					TimeUnit.SECONDS.sleep(10);
				}
			}else{
				ATUReports.add("Home button is not displayed in current screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Before The close",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
				// reset the application - 
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
				ATUReports.add("After The Launch",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			

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

			// get the value of the optional and click on it
			if (weatherPage.getminuteavgOptinalSlider() != null) {
				weatherPage.getminuteavgOptinalSlider().click();
				Thread.sleep(2000);
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

			// Verify the back button text
			String back_btn_text_10minute_average = weatherPage.getBackButton().getAttribute("name");
			if (back_btn_text_10minute_average.isEmpty()) {
				ATUReports.add("Verify the back button text in the screen ", "Back", back_btn_text_10minute_average,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (back_btn_text_10minute_average.equals("Back")) {
					ATUReports.add("Back text is noticed in the screen ", "Back", back_btn_text_10minute_average,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Back is not observed in the screen ", back_btn_text_10minute_average, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String weather_body = weatherPage.getBodytxt().getText();
			if (weather_body.isEmpty()) {
				ATUReports.add("Verify the Weather caption text  in the screen ",
						"Alert activated if wind speed average threshold is met for any 10-minute span.", weather_body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (weather_body
						.equals("Alert activated if wind speed average threshold is met for any 10-minute span.")) {
					ATUReports.add("Weather caption text is dispalyed in the screen ",
							"Alert activated if wind speed average threshold is met for any 10-minute span.",
							weather_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Weather caption text is not dispalyed in the screen ", weather_body, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Enter some value in the Average Wind Speed
			if(weatherPage.getthresholdtxtfld()!=null){
			weatherPage.getthresholdtxtfld().click();
			ATUReports.add("Clicked on the text field", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
			weatherPage.getthresholdtxtfld().clear();
			ATUReports.add("Cleared the text field", read_weather_details.avg_wind_speed_treshold, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// weatherPage.getthresholdtxtfld().setValue("-.33");
			// weatherPage.getthresholdtxtfld().clear();
			// ATUReports.add("Cleared the text
			// field",read_weather_details.avg_wind_speed_treshold,LogAs.PASSED,
			// new CaptureScreen(
			// ScreenshotOf.BROWSER_PAGE));
			weatherPage.getthresholdtxtfld().sendKeys(read_weather_details.avg_wind_speed_treshold);
			Thread.sleep(2000);
			ATUReports.add("Average Wind Speed given in the text box", read_weather_details.avg_wind_speed_treshold,
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// click on done button
						if (driver.findElementByAccessibilityId("Done") != null) {
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
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action22 = new TouchAction(driver);
					action22.longPress(croppage.getnextButtonTopText()).release().perform();
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
			/************************
			 * High Wind Alert
			 ******************************/

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

			// get the value of the optional and click on it
			if (weatherPage.getwindalertOptionalSlider() != null) {
				weatherPage.getwindalertOptionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Crop title text.
			if (weatherPage.gethighWindAlertTitle() != null) {
				String highwindalert_title = weatherPage.gethighWindAlertTitle().getAttribute("name");
				// System.out.println(title);
				if (highwindalert_title.isEmpty()) {
					ATUReports.add("Verify the HIGH WIND ALERT text  in the screen ", "HIGH WIND ALERT",
							highwindalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (highwindalert_title.equals("HIGH WIND ALERT")) {
						ATUReports.add("High Wind Alert is noticed in the screen ", "HIGH WIND ALERT",
								highwindalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("HIGH WIND ALERT is not observed in the screen ", highwindalert_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
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
			if (driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			}
			// click on next
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction action0 = new TouchAction(driver);
					action0.longPress(croppage.getnextButtonTopText()).release().perform();
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
			/************************
			 * Daily Rain Alert
			 ******************************/

			// Verify the Optional button text
			String Optional_daily_rain = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional_daily_rain.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional_daily_rain.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional_daily_rain,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional_daily_rain, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			// get the value of the optional and click on it
			if (weatherPage.getdaliyRainOptionalSlider() != null) {
				weatherPage.getdaliyRainOptionalSlider().click();
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(3000);

			// Verify weather title text.
			String dailyrainalert_title = weatherPage.getdailyRainTitle().getAttribute("name");
			// System.out.println(title);
			if (dailyrainalert_title.isEmpty()) {
				ATUReports.add("Verify the Daily Rain Alert text  in the screen ", "DAILY RAIN ALERT",
						dailyrainalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (dailyrainalert_title.equals("DAILY RAIN ALERT")) {
					ATUReports.add("Daily Rain Alert is noticed in the screen ", "DAILY RAIN ALERT",
							dailyrainalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("DAILY RAIN ALERT is not observed in the screen ", dailyrainalert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String dailyrainalert_body = weatherPage.getBodytxt().getText();
			if (dailyrainalert_body.isEmpty()) {
				ATUReports.add("Verify the Daily Rain Alert caption text  in the screen ",
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

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			if(weatherPage.getdailyRainAlertTextBox()!=null){
			Thread.sleep(4000);
			weatherPage.getdailyRainAlertTextBox().clear();
			Thread.sleep(3000);
			weatherPage.getdailyRainAlertTextBox().sendKeys(read_weather_details.Daily_Rain_alert);
			System.out.println(weatherPage.getdailyRainAlertTextBox().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.getdailyRainAlertTextBox().getAttribute("value"),
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if (driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
			/************************
			 * HIGH RAIN RATE ALERT
			 ******************************/

			// Verify the Optional button text
			String Optional_high_rain = weatherPage.getOptionaltxt().getText();
			if (Optional_high_rain.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional_high_rain.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional_high_rain,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional_high_rain, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// get the value of the optional and click on it
			if (weatherPage.gethighRainAlertOptionalSlider() != null) {
				weatherPage.gethighRainAlertOptionalSlider().click();
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(3000);
			}
			// Verify Crop title text.
			String highrainalert_title = weatherPage.gethighRainAlertTitle().getAttribute("name");
			// System.out.println(title);
			if (highrainalert_title.isEmpty()) {
				ATUReports.add("Verify the HIGH RAIN RATE ALERT text  in the screen ", "HIGH RAIN RATE ALERT",
						highrainalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highrainalert_title.equals("HIGH RAIN RATE ALERT")) {
					ATUReports.add("HIGH RAIN RATE ALERT is noticed in the screen ", "HIGH RAIN RATE ALERT",
							highrainalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH RAIN RATE ALERT is not observed in the screen ", highrainalert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String highrainalert_body = weatherPage.getBodytxt().getText();
			if (highrainalert_body.isEmpty()) {
				ATUReports.add("Verify the High rain rate alert caption text  in the screen ",
						"Alert activated if rain rate per hour threshold is met.", highrainalert_body, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (highrainalert_body.equals("Alert activated if rain rate per hour threshold is met.")) {
					ATUReports.add("High rain rate alert caption text is dispalyed in the screen ",
							"Alert activated if rain rate per hour threshold is met.", highrainalert_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("High rain rate alert caption text is not dispalyed in the screen ",
							highrainalert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			if(weatherPage.gethighRainAlertTxtBox()!=null){
			Thread.sleep(4000);
			weatherPage.gethighRainAlertTxtBox().clear();
			Thread.sleep(3000);
			weatherPage.gethighRainAlertTxtBox().sendKeys(read_weather_details.Daily_Rain_alert);
			System.out.println(weatherPage.gethighRainAlertTxtBox().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.gethighRainAlertTxtBox().getAttribute("value"),
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if (driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			}
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction actionf = new TouchAction(driver);
					actionf.longPress(croppage.getnextButtonTopText()).release().perform();
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

			/************************
			 * High Temperature Alert
			 ******************************/

			// Verify the Optional button text
			String Optional_High_temp_ = weatherPage.getOptionaltxt().getAttribute("name");
			if (Optional_High_temp_.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional_High_temp_.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional_High_temp_,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional_High_temp_, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// get the value of the optional and click on it
			if (weatherPage.gethighTemOptionalSlider() != null) {
				weatherPage.gethighTemOptionalSlider().click();
				Thread.sleep(2000);
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			// Verify weather title text.
			String hightemplert_title = weatherPage.gethighTemTitle().getAttribute("name");
			// System.out.println(title);
			if (hightemplert_title.isEmpty()) {
				ATUReports.add("Verify the High Temperature Alert text  in the screen ", "HIGH TEMPERATURE ALERT",
						hightemplert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (hightemplert_title.equals("HIGH TEMPERATURE ALERT")) {
					ATUReports.add("High Temperature Alert is noticed in the screen ", "HIGH TEMPERATURE ALERT",
							hightemplert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH TEMPERATURE ALERT is not observed in the screen ", hightemplert_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the Weather
			String hightemplert_body = weatherPage.getBodytxt().getText();
			System.out.println(hightemplert_body + "hightemplert_body");
			if (hightemplert_body.isEmpty()) {
				ATUReports.add("Verify the High Temperature Alert caption text  in the screen ",
						"Alert activated if current temperature meets or exceeds threshold.", hightemplert_body,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (hightemplert_body.contains("Alert activated if current temperature meets or exceeds threshold.")) {
					ATUReports.add("HIGH TEMPERATURE ALERT caption text is dispalyed in the screen ",
							"Alert activated if current temperature meets or exceeds threshold.", hightemplert_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("HIGH TEMPERATURE ALERT caption text is not dispalyed in the screen ",
							hightemplert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			if(weatherPage.gethighTemTextBox()!=null){
			Thread.sleep(4000);
			weatherPage.gethighTemTextBox().clear();
			Thread.sleep(3000);
			weatherPage.gethighTemTextBox().sendKeys(read_weather_details.Daily_Rain_alert);
			System.out.println(weatherPage.gethighTemTextBox().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if (driver.findElementByAccessibilityId("Done") != null) {
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
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction actionbb = new TouchAction(driver);
					actionbb.longPress(croppage.getnextButtonTopText()).release().perform();
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
			/************************
			 * Low Temperature Alert
			 ******************************/

			// Verify the Optional button text
			String Optional_Low_temp = weatherPage.getOptionaltxt().getText();
			if (Optional_Low_temp.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional_Low_temp.equals("Optional")) {
					ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional_Low_temp,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional_Low_temp, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// get the value of the optional and click on it
			if (weatherPage.getlowTemOptional() != null) {
				weatherPage.getlowTemOptional().click();
				ATUReports.add("optional Slider is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify wather title text.
			String lowtemplert_title = weatherPage.getlowTemTitle().getAttribute("name");
			// System.out.println(title);
			if (lowtemplert_title.isEmpty()) {
				ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ", "LOW TEMPERATURE ALERT",
						lowtemplert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (lowtemplert_title.equals("LOW TEMPERATURE ALERT")) {
					ATUReports.add("Low Temperature Alert is noticed in the screen ", "LOW TEMPERATURE ALERT",
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

			// Verify to enter max(value) range in textbox
			// it contains zero by default
			if(weatherPage.getlowTemTemTextBox()!=null){
			Thread.sleep(4000);
			weatherPage.getlowTemTemTextBox().clear();
			Thread.sleep(3000);
			weatherPage.getlowTemTemTextBox().sendKeys(read_weather_details.Low_temp_alert);
			System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value") + "---text maxm  value---");
			ATUReports.add("Entered maximum value", weatherPage.getlowTemTemTextBox().getAttribute("value"),
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// driver.hideKeyboard();
			Thread.sleep(2000);

			// click on done button
			if (driver.findElementByAccessibilityId("Done") != null) {
				WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
				Thread.sleep(5000);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(doneBtn).release().perform();
				Thread.sleep(6000);
				// System.out.println("Clicked on done button");
				ATUReports.add("Clicked on Done button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			}
			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction actionhh = new TouchAction(driver);
					actionhh.longPress(croppage.getnextButtonTopText()).release().perform();
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
			/************************
			 * Complete Weather Setup
			 ******************************/

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

			// Verify the body text in the
			// Weather
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
					ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
					// WebElement doneBtn3 = (WebElement)
					// driver.findElementByAccessibilityId("Done");
					TouchAction actionkk = new TouchAction(driver);
					actionkk.longPress(croppage.getsaveTxt()).release().perform();
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

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		System.out.println("***************************ENDING- Weather_UI_Navigation_flow **************************");

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

	public void optionalSlider(WebElement element) throws InterruptedException {
		// get the value of the optional and click on it
		Thread.sleep(4000);
		if (element.isDisplayed()) {
			ATUReports.add("Optional Slier is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			// WebElement optionalElement
			// =frostpage.getearlyFrostOptionalSlider();
			int xInitialOptional = element.getLocation().getX() + element.getSize().getWidth() / 2;
			int yInitialOptional = element.getLocation().getY() + element.getSize().getHeight() / 2;
			System.out.println("xInitialOptional " + xInitialOptional + "yInitialOptional" + yInitialOptional);
			driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional + 70, yInitialOptional, 5000);// 50
																											// for
																											// 22
			Thread.sleep(2000);
		} else {
			ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	public static void thresholdSlider(WebElement lastElement) throws InterruptedException {

		// move the slider
		Thread.sleep(4000);
		// WebElement lastElement =frostpage.getTempSlider();
		Thread.sleep(2000);
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth() / 2;
		int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight() / 2;
		System.out.println("xInitial " + xInitial + "yInitial" + yInitial);
		driver.swipe(xInitial, yInitial, xInitial + 98, yInitial, 5000);
		ATUReports.add("Slider is displayed and moved the slider from left to right", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
