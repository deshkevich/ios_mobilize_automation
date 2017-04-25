package functional_testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import Pages.Account_Page;
import Pages.Alert_Page;
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
import utility.ReadViewName;
import utility.ReadWeatherDetails;
import utility.ReadWeatherThresholdValues;
import utility.Read_CropPageThresholdValues;

public class WeatherThresholdTemperature {
	private static IOSDriver driver;
	private WeatherPage weatherPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private ReadWeatherDetails read_weather_details;
	private JavascriptExecutor js;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private static FrostPage frostpage;
	private ReadWeatherThresholdValues weatherpagevalues;
	private Account_Page accountpage;
	private WebElement row;
	private ReadViewName readviewname;
	private static CropPage croppage;
	private static Alert_Page alertpage;
/*

	// private FrostPage frostpage;
	@SuppressWarnings("serial")
	@Test
	public void weatherThresholdTemperature() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			weatherPage = new WeatherPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			js = (JavascriptExecutor) driver;
			read_weather_details = new ReadWeatherDetails();
			read_weather_details.start();
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			frostpage = new FrostPage(driver);
			weatherpagevalues = new ReadWeatherThresholdValues();
			weatherpagevalues.start();
			accountpage = new Account_Page(driver);
			readviewname = new ReadViewName();
			readviewname.start();
			croppage = new CropPage(driver);
			alertpage = new Alert_Page(driver);
			System.out.println(
					"***************************Staring- WeatherThresholdTemperature **************************");

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

			// verify account button
			if (homepage.getaccountbtn() != null) {
				if (homepage.getaccountbtn().isDisplayed()) {
					homepage.getaccountbtn().click();
					ATUReports.add("Clicked on account button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(4);
				} else {
					ATUReports.add("Account button is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);
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
					TimeUnit.MILLISECONDS.sleep(50);
				} else {
					ATUReports.add(tabTextTwo + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on temperature
			if (accountpage.gettempText() != null) {
				MobileElement temp = accountpage.gettempText();
				String tabTextTwo = temp.getAttribute("name");
				if (temp.isDisplayed()) {

					ATUReports.add(tabTextTwo + " tab is Displayed and Clicked on temperature  tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					temp.click();
					TimeUnit.MILLISECONDS.sleep(4);
				} else {
					ATUReports.add("Users Temperature  list is not displayed not contains temperature text",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));// temperature
					// list
				}
			}

			// Verify 'F' an c from temperature list
			MobileElement fText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));// frostpage.gettemperatureFUnitsTxt();
			String expectedFtxt = fText.getAttribute("name");
			System.out.println(expectedFtxt + "expectedFtxt");
			MobileElement cText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]"));// frostpage.gettempCUnitsTxt();
			String expectedCText = cText.getAttribute("name");
			ATUReports
					.add("Users preferences Temperature  Units  List is displayed and  One unit is selected by default"
							+ expectedFtxt, expectedCText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			TimeUnit.SECONDS.sleep(5);

			// Verify back
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
						ATUReports.add(
								"Back button is enabled in the in the current screen and clicked on the back button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			}

			// Scroll to rain rate option
			driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
				{
					put("element", ((RemoteWebElement) driver.findElement(By.name("Rain & ET"))).getId());
				}
			});
			TimeUnit.SECONDS.sleep(15);
			ATUReports.add("Scroll to Rain & ET", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// -------*Verify Rain rate units*-----
			MobileElement rainUnitsList = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]"));
			String unitsText = rainUnitsList.getAttribute("name");

			if (unitsText.contains("Rain & ET")) {
				rainUnitsList.click();
				TimeUnit.SECONDS.sleep(15);

				// if(rainUnitsList!=null && rainUnitsList.isDisplayed()){
				ATUReports.add(unitsText + "  Units list is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verify inches
			MobileElement inchesText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
			String inchesRainText = inchesText.getAttribute("name");
			// System.out.println(inchesRainText+"------inchesRainText");

			// Verify mm
			MobileElement mmText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]"));
			String mmRainText = mmText.getAttribute("name");
			// System.out.println(mmRainText+"------mmRainText");
			TimeUnit.SECONDS.sleep(4);

			ATUReports.add("Scroll to Rain & ET and displyed units  " + inchesRainText, mmRainText, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify back button
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
						ATUReports.add(
								"Back button is enabled in the in the current screen and clicked on the back button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			}

			// Verify wind speed text
			int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
			for (int i = 0; i <= size; i++) {
				TimeUnit.SECONDS.sleep(10);
				ATUReports.add("in loop", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				row = homepage.gettableview().findElementsByClassName("UIATableCell").get(5);
				TimeUnit.SECONDS.sleep(10);
				if (row != null) {
					// if(row.getAttribute("name").contains("Wind Speed")){
					row.click();
					TimeUnit.SECONDS.sleep(10);
					ATUReports.add("Wind Speed Units list is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					break;
					// }
				}
			}

			TimeUnit.SECONDS.sleep(8);
			// Verify mph in preferences
			MobileElement mphText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
			String mphSpeedText = mphText.getAttribute("name");
			System.out.println(mphSpeedText + "------mphSpeedText------");
			TimeUnit.SECONDS.sleep(2);

			// Verify knots in preferences
			MobileElement knotsText = (MobileElement) driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]"));
			String knotsSpeedText = knotsText.getAttribute("name");
			System.out.println(knotsSpeedText + "-----knotsSpeedText------");
			TimeUnit.SECONDS.sleep(4);
			ATUReports.add("Scroll to windspeed and displyed units  " + mphSpeedText, knotsSpeedText, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify back button
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
						ATUReports.add(
								"Back button is enabled in the in the current screen and clicked on the back button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {

						ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			}

			homepage.gethomebutton().click();
			TimeUnit.SECONDS.sleep(5);

			// ************************************************* Verify weather
			// screen ********************************************************

			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();
				TimeUnit.SECONDS.sleep(3);
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
				ATUReports.add("Verify the name entered in the View textfield in the screen ", enteredviewName,
						viewName, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (enteredviewName.equals(viewName)) {
					ATUReports.add("Verify the name entered in the View textfield in the screen ", enteredviewName,
							viewName, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Verify the name entered in the View textfield in the screen ", enteredviewName,
							viewName, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);

			// Tab on next
			if (newviewscreenpage.getviewNextBtn() != null) {
				if (newviewscreenpage.getviewNextBtn().isDisplayed()) {
					ATUReports.add("Tap on add button", LogAs.PASSED, null);
					newviewscreenpage.getviewNextBtn().click();
					TimeUnit.SECONDS.sleep(8);
				} else {
					ATUReports.add("Next  button is not dsplayed", LogAs.FAILED, null);
					newviewscreenpage.getviewNextBtn().click();
					TimeUnit.SECONDS.sleep(8);
				}

			}

			// Verify notification tutorial box
			if (alertpage.getnotificationTutorialBoxTxt() != null) {
				ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),
						alertpage.getcreateViewTutorialNextBtn());

				// click on close icon
				if (alertpage.getcreateViewTutorialNextBtn() != null) {
					alertpage.getcreateViewCloseIcon().click();
					ATUReports.add("Clicked on close icon in Notification view tutorial ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				ATUReports.add("Mobilize Notification  tutorial screen  is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify weather screen
			if (newviewscreenpage.getWeather() != null) {
				String title = newviewscreenpage.getWeather().getText();
				if (newviewscreenpage.getWeather().isDisplayed()) {
					newviewscreenpage.getWeather().click();
					TimeUnit.SECONDS.sleep(8);
					ATUReports.add("Clicked on " + title + " text  in the View  screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add(title, "-  is not displayed", title, LogAs.WARNING,
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
				*/
/*
				 * if (sensorTxt.equals("")) {
				 * 
				 * }
				 *//*

				weatherPage.getSensortxt().click();
				Thread.sleep(5000);
			}
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on next button in the Weather Sensor Input

			if (croppage.getnextButtonTopText() != null) {
				if (croppage.getnextButtonTopText().isDisplayed()) {
					ATUReports.add("Next button is enabled in the Weather Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					croppage.getnextButtonTopText().click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Skip button is not enabled in the High Rain Rate Alert ", LogAs.FAILED,
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
						ATUReports.add("Skip button is not enabled in the High Rain Rate Alert ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			}

			// get the value of the optional and click on it
			if (weatherPage.getearlyFrostOptionalSlider() != null) {
				weatherPage.getearlyFrostOptionalSlider().click();
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

			// Verify the wind speed units text
			String actualWinSpeedUnits = weatherPage.getmph().getAttribute("name");
			// String actualWindSpeedKontUnits=weatherPage.getknot().getText();
			System.out.println(actualWinSpeedUnits + "---actualTemperatureUnits");
			System.out.println(mphSpeedText + "----mphSpeedText");
			if (actualWinSpeedUnits.isEmpty()) {
				ATUReports.add("actualWinSpeedUnits element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {

				if (actualWinSpeedUnits.contains(mphSpeedText)) {
					ATUReports.add("actualWinSpeedUnits text is noticed in the screen  same as expected ",
							actualWinSpeedUnits, mphSpeedText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify tap on temperature text box
					// Verify Tap on Temperature value box.

					MobileElement temparatureBox = weatherPage.getthresholdtxtfld();
					String textDefaultText = temparatureBox.getAttribute("value");
					System.out.println(textDefaultText + "---textDefaultText---");

					if (temparatureBox != null && temparatureBox.isDisplayed()) {

						ATUReports.add("Mobilize temperature value text box is displayed, and its default value is - "
								+ textDefaultText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify to enter min(value) range in text box
						temparatureBox.click();
						System.out.println("Clear the field");
						weatherPage.getthresholdtxtfld().clear();
						ATUReports.add("Cleared the text field", read_weather_details.avg_wind_speed_treshold,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
						weatherPage.getthresholdtxtfld().setValue(weatherpagevalues.MinWindMin_Mph);
						System.out.println("enter 1 value");
						System.out.println(temparatureBox.getAttribute("value") + "---textminimum value---");
						ATUReports.add("Entered minimum value", temparatureBox.getAttribute("value"), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						// driver.hideKeyboard();

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

						// Verify to enter out of range values in text
						// box
						temparatureBox.click();
						System.out.println("Clear the field");
						weatherPage.getthresholdtxtfld().clear();
						Thread.sleep(2000);
						// weatherPage.getThresholdtxtfld().sendKeys("51");
						weatherPage.getthresholdtxtfld().setValue(weatherpagevalues.MinWindOutOfRange_Mph);
						System.out.println(temparatureBox.getText() + "---text ot of value---");
						ATUReports.add("Entered Out of range value ", temparatureBox.getAttribute("value"),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// click on done button
						WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action2 = new TouchAction(driver);
						action2.longPress(doneBtn).release().perform();
						Thread.sleep(6000);
						System.out.println("Clicked on done button");

						// Verify Observe Next button is not Enabled.
						nextButtonIsNotEnabled();

						// Verify to enter max(value) range in textbox
						// it contains zero by default
						temparatureBox.click();
						System.out.println("Clear the field");
						weatherPage.getthresholdtxtfld().clear();
						Thread.sleep(2000);
						weatherPage.getthresholdtxtfld().setValue(weatherpagevalues.MinWindMin_Max_Mph);
						System.out.println(temparatureBox.getAttribute("value") + "---text maxm  value---");
						ATUReports.add("Entered maximum value", temparatureBox.getAttribute("value"), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						WebElement doneBtn0 = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action20 = new TouchAction(driver);
						action20.longPress(doneBtn0).release().perform();
						Thread.sleep(6000);
						// System.out.println("Clicked on done button");

						// clikcedOnNext();

						// nextButton();
						if (croppage.getnextButtonTopText() != null) {
							if (croppage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								TimeUnit.SECONDS.sleep(2);
								// WebElement doneBtn3 = (WebElement)
								// driver.findElementByAccessibilityId("Done");
								TouchAction actionp = new TouchAction(driver);
								actionp.longPress(croppage.getnextButtonTopText()).release().perform();
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

					} else {
						ATUReports.add(
								"temperature value text box  is not observed in 10-MINUTE AVERAGE WIND ALERT screen ",
								actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
					}

					// ************************Verify high wind alert
					// page***********

					// get the value of the optional and click on it
					if (weatherPage.getwindalertOptionalSlider() != null) {
						weatherPage.getwindalertOptionalSlider().click();
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
										highwindalert_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("HIGH WIND ALERT is not observed in the screen ", highwindalert_title,
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
					}

					// Verify weather title text.
					String highwindalert_title = weatherPage.gethighWindAlertTitle().getAttribute("name");
					if (highwindalert_title.isEmpty()) {
						ATUReports.add("Verify the HIGH WIND ALERT text  in the screen ", "High Wind Alert",
								highwindalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (highwindalert_title.equalsIgnoreCase("High Wind Alert")) {
							ATUReports.add("High Wind Alert is noticed in the screen ", "High Wind Alert",
									highwindalert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("HIGH WIND ALERT is not observed in the screen ", highwindalert_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify text box units text
					if (actualWinSpeedUnits.contains(mphSpeedText)) {
						ATUReports.add("high wind alertUnits text is noticed in the screen  same as expected ",
								actualWinSpeedUnits, mphSpeedText, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify tap on temperature text box
						MobileElement highWindTextBox = weatherPage.gethighWindAlertTextBox();
						String textBoxDefaultText = highWindTextBox.getAttribute("value");
						System.out.println(textBoxDefaultText + "---textBoxDefaultText---");

						if (highWindTextBox != null && highWindTextBox.isDisplayed()) {

							ATUReports.add(
									"Mobilize high wind alert  text box is displayed, and its default value is - "
											+ textDefaultText,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter out of range values in text
							// box

							weatherPage.gethighWindAlertTextBox().click();
							weatherPage.gethighWindAlertTextBox().clear();
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.INSERT);
							Thread.sleep(1000);
							// weatherPage.gethighWindAlertTextBox().sendKeys("101");weatherpagevalues
							weatherPage.gethighWindAlertTextBox().setValue(weatherpagevalues.high_wind_ot_range_mph);
							// System.out.println(weatherPage.gethighWindAlertTextBox().getText()
							// + "---text ot of value---");
							ATUReports.add("Entered Out of range value ",
									weatherPage.gethighRainAlertTxtBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// click on done button
							WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action2 = new TouchAction(driver);
							action2.longPress(doneBtn).release().perform();
							Thread.sleep(6000);
							System.out.println("Clicked on done button");

							// Verify Observe Next button is not Enabled.
							nextButtonIsNotEnabled();

							// Verify to enter min(value) range in text box
							weatherPage.gethighWindAlertTextBox().click();
							weatherPage.gethighWindAlertTextBox().clear();
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.INSERT);
							System.out.println("Clear the field");
							Thread.sleep(2000);
							// weatherPage.gethighWindAlertTextBox().sendKeys("1");weatherpagevalues
							weatherPage.gethighWindAlertTextBox().setValue(weatherpagevalues.high_wind_min_mph);
							// System.out.println("enter 1 value");
							// System.out.println(weatherPage.gethighWindAlertTextBox().getAttribute("value")
							// + "---textminimum value---");
							ATUReports.add("Entered minimum value",
									weatherPage.gethighRainAlertTxtBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							// driver.hideKeyboard();

							*/
/*
							 * // click on done button //WebElement doneBtn =
							 * (WebElement)
							 * driver.findElementByAccessibilityId("Done");
							 * Thread.sleep(5000); //TouchAction action2 = new
							 * TouchAction(driver);
							 * action2.longPress(doneBtn).release().perform();
							 * Thread.sleep(6000); System.out.println(
							 * "Clicked on done button");
							 *//*


							// Next button is enabled
							// nextButtonEnabled();

							// Verify to enter max(value) range in text box
							// it contains zero by default
							weatherPage.gethighWindAlertTextBox().click();
							weatherPage.gethighWindAlertTextBox().clear();
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.INSERT);
							System.out.println("Clear the field");
							Thread.sleep(2000);
							// weatherPage.gethighWindAlertTextBox().sendKeys("100");weatherpagevalues
							weatherPage.gethighWindAlertTextBox().setValue(weatherpagevalues.high_wind_max_mph);
							System.out.println(weatherPage.gethighWindAlertTextBox().getAttribute("value")
									+ "---text maxm  value---");
							ATUReports.add("Entered maximum value",
									weatherPage.gethighWindAlertTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							// driver.hideKeyboard("Done");
							Thread.sleep(1000);

							WebElement doneBtnl = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction actionl = new TouchAction(driver);
							actionl.longPress(doneBtnl).release().perform();
							Thread.sleep(6000);

							// Next button is enabled
							// nextButton();
							if (croppage.getnextButtonTopText() != null) {
								if (croppage.getnextButtonTopText().isDisplayed()) {
									ATUReports.add(
											"Next button is enabled in the Current screenand clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									TimeUnit.SECONDS.sleep(2);

									WebElement doneBtn3 = (WebElement) driver.findElementByAccessibilityId("Done");
									TouchAction action3 = new TouchAction(driver);
									action3.longPress(croppage.getnextButtonTopText()).release().perform();
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									}
								}
							}

						} else {
							ATUReports.add("High wind alert temperature value text box  is not observed in the screen ",
									actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							driver.close();
						}

					} else {
						ATUReports.add("high wind alertUnits text is noticed in the screen  not same as expected ",
								actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				} else {

					// --------------************" VERIFY MINUTE AVERAGE ALERT &
					// HIGH WIND ALERT IN" KNOTS " UNITS
					// ************----------------
					// ------------Verify--------knots units-------

					String knotsUnits = weatherPage.getmph().getAttribute("name");
					System.out.println(knotsSpeedText + "-------knotsSpeedText---");
					if (knotsUnits.contains(knotsSpeedText)) {
						ATUReports.add("actualWinSpeedUnits text is noticed in the screen  same as expected ",
								knotsUnits, knotsSpeedText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify tap on temperature text box
						MobileElement temparatureBox = weatherPage.getthresholdtxtfld();
						String textDefaultText = temparatureBox.getAttribute("value");
						System.out.println(textDefaultText + "---textDefaultText---");

						if (temparatureBox != null && temparatureBox.isDisplayed()) {

							ATUReports.add(
									"Mobilize temperature value text box is displayed, and its default value is - "
											+ textDefaultText,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter min(value) range in
							// text box
							System.out.println("Clear the field");
							weatherPage.getthresholdtxtfld().clear();
							// weatherPage.getminuteavgTextBx().sendKeys(Keys.INSERT);
							Thread.sleep(2000);
							weatherPage.getthresholdtxtfld().setValue(weatherpagevalues.MinWindMin_Knots);
							Thread.sleep(1000);
							ATUReports.add("Entered minimum value", temparatureBox.getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Next button is enabled
							ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter out of range values in text
							// box
							Thread.sleep(1000);
							weatherPage.getthresholdtxtfld().clear();
							// weatherPage.getminuteavgTextBx().sendKeys(Keys.INSERT);
							Thread.sleep(2000);

							// weatherPage.getThresholdtxtfld().sendKeys("44");weatherpagevalue
							weatherPage.getthresholdtxtfld().setValue(weatherpagevalues.MinWindMinOutOfRange_Knots);
							Thread.sleep(2000);
							System.out.println(temparatureBox.getAttribute("value") + "---text ot of value---");
							ATUReports.add("Entered Out of range value ", temparatureBox.getText(), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify button is not enabled
							ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter max(value) range in textbox
							// it contains zero by default
							weatherPage.getthresholdtxtfld().clear();
							Thread.sleep(2000);
							weatherPage.getthresholdtxtfld().sendKeys(weatherpagevalues.MinWindMin_Max_Knots);
							System.out.println(temparatureBox.getAttribute("value") + "---text maxm  value---");
							ATUReports.add("Entered maximum value", temparatureBox.getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(1000);

							WebElement doneBtn3 = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action2 = new TouchAction(driver);
							action2.longPress(doneBtn3).release().perform();
							Thread.sleep(6000);

							// clikcedOnNext
							if (croppage.getnextButtonTopText() != null) {
								if (croppage.getnextButtonTopText().isDisplayed()) {
									ATUReports.add(
											"Next button is enabled in the Current screenand clicked on the Next button",
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									}
								}

							}

						} else {
							ATUReports.add("temperature value text box  is not observed in the screen ", knotsUnits,
									knotsSpeedText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							driver.close();
						} // konts wind avrage

						// ************ high wind alert*******************

						// get the value of the optional and click on it
						if (weatherPage.getwindalertOptionalSlider() != null) {
							weatherPage.getwindalertOptionalSlider().click();
							ATUReports.add("optional Slider is displayed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						// Verify Crop title text.
						if (weatherPage.gethighWindAlertTitle() != null) {
							String highwindalert_title = weatherPage.gethighWindAlertTitle().getAttribute("name");
							// System.out.println(title);
							if (highwindalert_title.isEmpty()) {
								ATUReports.add("Verify the HIGH WIND ALERT text  in the screen ", "HIGH WIND ALERT",
										highwindalert_title, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (highwindalert_title.equals("HIGH WIND ALERT")) {
									ATUReports.add("High Wind Alert is noticed in the screen ", "HIGH WIND ALERT",
											highwindalert_title, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("HIGH WIND ALERT is not observed in the screen ",
											highwindalert_title, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
						}

						// Verify text box units text
						if (knotsUnits.contains(knotsSpeedText)) {
							ATUReports.add("high wind alertUnits text is noticed in the screen  same as expected ",
									knotsSpeedText, knotsUnits, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Tap on Temperature value box.
							MobileElement highWindTextBox = weatherPage.gethighWindAlertTextBox();
							String textBoxDefaultText = highWindTextBox.getAttribute("value");
							System.out.println(textBoxDefaultText + "---textBoxDefaultText---");

							if (highWindTextBox != null && highWindTextBox.isDisplayed()) {

								ATUReports.add(
										"Mobilize high wind alert  text box is displayed, and its default value is - "
												+ textDefaultText,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter min(value) range in
								// text box
								weatherPage.gethighWindAlertTextBox().click();

								// Verify to enter min(value) range in text box
								weatherPage.gethighWindAlertTextBox().click();
								weatherPage.gethighWindAlertTextBox().clear();
								// weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								weatherPage.gethighWindAlertTextBox().setValue(weatherpagevalues.high_wind_min_knots);
								System.out.println(weatherPage.gethighWindAlertTextBox().getAttribute("value")
										+ "-----text manimum  value---");
								ATUReports.add("Entered minimum value",
										weatherPage.gethighWindAlertTextBox().getAttribute("value"), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								// driver.hideKeyboard();
								Thread.sleep(1000);

								// Next button is enabled
								// Verify button is not enabled
								ATUReports.add("Next button is  enabled in current screen", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter out of range values in text
								// box
								weatherPage.gethighWindAlertTextBox().click();
								Thread.sleep(2000);
								weatherPage.gethighWindAlertTextBox().clear();
								// weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
								Thread.sleep(4000);
								weatherPage.gethighWindAlertTextBox()
										.setValue(weatherpagevalues.high_wind_ot_range_knots);
								System.out.println(highWindTextBox.getAttribute("value") + "---text out of value---");
								ATUReports.add("Entered Out of range value ", highWindTextBox.getAttribute("value"),
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								*/
/*
								 * WebElement done = (WebElement)
								 * driver.findElementByAccessibilityId("Done");
								 * Thread.sleep(5000); TouchAction action = new
								 * TouchAction(driver);
								 * action.longPress(done).release().perform();
								 * Thread.sleep(6000);
								 *//*


								// Verify Observe Next button is not Enabled.
								// Verify button is not enabled
								ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter max(value) range in textbox
								// it contains zero by default
								Thread.sleep(4000);
								weatherPage.gethighWindAlertTextBox().clear();
								Thread.sleep(3000);
								weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_max_knots);
								System.out.println(highWindTextBox.getAttribute("value") + "---text maxm  value---");
								ATUReports.add("Entered maximum value", highWindTextBox.getAttribute("value"),
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								// driver.hideKeyboard();
								Thread.sleep(2000);

								// click on done button
								WebElement done9 = (WebElement) driver.findElementByAccessibilityId("Done");
								Thread.sleep(5000);
								TouchAction action9 = new TouchAction(driver);
								action9.longPress(done9).release().perform();
								Thread.sleep(6000);

								// ClikcedOnNext
								if (croppage.getnextButtonTopText() != null) {
									if (croppage.getnextButtonTopText().isDisplayed()) {
										ATUReports.add(
												"Next button is enabled in the Current screenand clicked on the Next button",
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
									}

								}

							} else {
								ATUReports.add(
										"high wind alertUnits text is noticed in the screen  not same as expected ",
										knotsSpeedText, knotsUnits, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
						} // high wind knots

					} // rain units
				}

				// ********************************DAily rain alert
				// ********************

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

				// ********************************Verify the rain units
				// text*********************************

				String dailyRain = weatherPage.getin().getAttribute("name");
				// System.out.println(dailyRain+"---daliyRain---highlyRain---in/hr
				// actual----");
				// System.out.println(inchesRainText+"-----inchesRainText----expected---inches----");
				if (dailyRain.isEmpty()) {

				} else {
					if (dailyRain.contains(inchesRainText)) {
						ATUReports.add("Daily rain alert Units text is noticed in the screen  same as expected ",
								dailyRain, inchesRainText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify to enter max(value) range in textbox
						// it contains zero by default

						weatherPage.getdailyRainAlertTextBox().click();
						weatherPage.getdailyRainAlertTextBox().clear();
						// weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
						// weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.INSERT);
						Thread.sleep(3000);
						weatherPage.getdailyRainAlertTextBox().setValue(weatherpagevalues.daily_rain_max_mm_max);
						Thread.sleep(2000);
						System.out.println(weatherPage.getdailyRainAlertTextBox().getAttribute("value")
								+ "---text maxm  value---");
						ATUReports.add("Entered maximum value",
								weatherPage.getdailyRainAlertTextBox().getAttribute("value"), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(1000);

						// Next button is enabled
						// Verify button is not enabled
						ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify to enter out of range values in text
						// box
						weatherPage.getdailyRainAlertTextBox().click();
						weatherPage.getdailyRainAlertTextBox().clear();
						Thread.sleep(2000);
						weatherPage.getdailyRainAlertTextBox().setValue(weatherpagevalues.daily_rain_ot_range_mm);
						Thread.sleep(4000);
						System.out.println(weatherPage.getdailyRainAlertTextBox().getAttribute("value")
								+ "---text out of value---");
						ATUReports.add("Entered Out of range value ",
								weatherPage.getdailyRainAlertTextBox().getAttribute("value"), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify Observe Next button is not Enabled.
						// Verify button is not enabled
						ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify to enter min(value) range in
						// text box
						// MobileElement minimumValue=(MobileElement)
						// driver.findElementById("com.davis.mobilize:id/et_daily_rain_threshold");
						weatherPage.getdailyRainAlertTextBox().clear();
						// minimumValue.sendKeys(Keys.DELETE);
						// minimumValue.sendKeys(Keys.INSERT);
						Thread.sleep(3000);
						weatherPage.getdailyRainAlertTextBox().sendKeys(weatherpagevalues.daily_ran_min_mm);
						Thread.sleep(3000);
						// System.out.println(weatherPage.getdailyRainAlertTextBox().getAttribute("value")
						// + "-----text manimum value---");
						ATUReports.add("Entered minimum value",
								weatherPage.getdailyRainAlertTextBox().getAttribute("value"), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(1000);

						// click on done button
						WebElement doneBtn5 = (WebElement) driver.findElementByAccessibilityId("Done");
						Thread.sleep(5000);
						TouchAction action5 = new TouchAction(driver);
						action5.longPress(doneBtn5).release().perform();
						Thread.sleep(6000);

						// clikcedOnNext //nextButton();
						if (croppage.getnextButtonTopText() != null) {
							if (croppage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
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

					} else {
						ATUReports.add("Daily Rain alerts units mm is diplayed", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						// clikcedOnNext
						if (croppage.getnextButtonTopText() != null) {
							if (croppage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								TimeUnit.SECONDS.sleep(2);
								// WebElement doneBtn3 = (WebElement)
								// driver.findElementByAccessibilityId("Done");
								TouchAction action2 = new TouchAction(driver);
								action2.longPress(croppage.getnextButtonTopText()).release().perform();
								TimeUnit.SECONDS.sleep(15);
								croppage.getnextButtonTopText().click();
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
					}

				}

				// *************************High rain alert
				// ***********************

				// get the value of the optional and click on it
				if (weatherPage.getwindalertOptionalSlider() != null) {
					weatherPage.getwindalertOptionalSlider().click();
					ATUReports.add("optional Slider is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

				// Verify high rain units
				String highRain = weatherPage.getin().getAttribute("name");
				System.out.println(highRain + "---highRainn---highlyRain---in/hr actual----");
				System.out.println(inchesRainText + "-----mmRainText----expected---inches----");
				if (highRain.isEmpty()) {

				} else {
					if (highRain.contains(inchesRainText)) {
						ATUReports.add("High rain rate  alert Units text is noticed in the screen  same as expected ",
								highRain, inchesRainText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify Tap on Temperature value box.

						MobileElement highRainTextBox = weatherPage.gethighRainAlertTxtBox();
						String textBoxDefaultTextHighRainTwo = highRainTextBox.getAttribute("value");
						System.out.println(textBoxDefaultTextHighRainTwo + "---textBoxDefaultTextHighRainTwo---");

						if (highRainTextBox != null && highRainTextBox.isDisplayed()) {

							ATUReports.add(
									"Mobilize High rain rate  alert  text box is displayed, and its default value is - "
											+ textBoxDefaultTextHighRainTwo,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter min(value) range in
							// text box
							weatherPage.gethighRainAlertTxtBox().click();
							weatherPage.gethighRainAlertTxtBox().clear();
							weatherPage.gethighRainAlertTxtBox().setValue(weatherpagevalues.high_rain_inches_min);
							Thread.sleep(4000);
							System.out.println(weatherPage.gethighRainAlertTxtBox().getAttribute("value")
									+ "-----text manimum  value---");
							ATUReports.add("Entered minimum value",
									weatherPage.gethighRainAlertTxtBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							// driver.hideKeyboard();
							Thread.sleep(1000);

							// Verify button is not enabled
							ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter out of range values in text
							// box
							weatherPage.gethighRainAlertTxtBox().click();
							weatherPage.gethighRainAlertTxtBox().clear();
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.DELETE);
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.INSERT);
							Thread.sleep(2000);
							// weatherPage.gethighRainTextBox().sendKeys("255.0");weather
							// page values
							weatherPage.gethighRainAlertTxtBox().setValue(weatherpagevalues.high_rain_inches_ot_range);
							System.out.println(weatherPage.gethighRainAlertTxtBox().getAttribute("value")
									+ "---text out of value---");
							ATUReports.add("Entered Out of range value ",
									weatherPage.gethighRainAlertTxtBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Observe Next button is not Enabled.
							ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter max(value) range in textbox
							weatherPage.gethighRainAlertTxtBox().click();
							weatherPage.gethighRainAlertTxtBox().clear();
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.DELETE);
							// weatherPage.gethighRainAlertTxtBox().sendKeys(Keys.INSERT);
							Thread.sleep(2000);
							weatherPage.gethighRainAlertTxtBox().sendKeys(weatherpagevalues.high_rain_max_inches);
							System.out.println(weatherPage.gethighRainAlertTxtBox().getAttribute("value")
									+ "---text maxm  value---");
							ATUReports.add("Entered maximum value",
									weatherPage.gethighRainAlertTxtBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(1000);

							/// click on done button
							WebElement doneBtn6 = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action6 = new TouchAction(driver);
							action6.longPress(doneBtn6).release().perform();
							Thread.sleep(6000);

							// clikcedOnNext
							if (croppage.getnextButtonTopText() != null) {
								if (croppage.getnextButtonTopText().isDisplayed()) {
									ATUReports.add(
											"Next button is enabled in the Current screenand clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									TimeUnit.SECONDS.sleep(2);
									// WebElement doneBtn3 = (WebElement)
									// driver.findElementByAccessibilityId("Done");
									TouchAction action2 = new TouchAction(driver);
									action2.longPress(croppage.getnextButtonTopText()).release().perform();
									TimeUnit.SECONDS.sleep(15);
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									}
								}

							}

						} else {
							ATUReports.add("high Rain alert Units text is noticed in the screen  not same as expected ",
									highRain, inchesRainText, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}

					} else {

						ATUReports.add("High Rain alerts units mm is diplayed", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						// clikcedOnNext
						if (croppage.getnextButtonTopText() != null) {
							if (croppage.getnextButtonTopText().isDisplayed()) {
								ATUReports.add(
										"Next button is enabled in the Current screenand clicked on the Next button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								TimeUnit.SECONDS.sleep(2);
								// WebElement doneBtn3 = (WebElement)
								// driver.findElementByAccessibilityId("Done");
								TouchAction action2 = new TouchAction(driver);
								action2.longPress(croppage.getnextButtonTopText()).release().perform();
								TimeUnit.SECONDS.sleep(15);
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

					}
				}
				// -------------******* VERIFY HIGH & LOW TEMPERATURE IN " F "
				// UNITS *****---------------

				// get the value of the optional and click on it
				if (weatherPage.gethighTemOptionalSlider() != null) {
					weatherPage.gethighTemOptionalSlider().click();
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

				// Verify temperature units from current page

				String actualTemperatureUnits = weatherPage.getftxt().getText();
				System.out.println(actualTemperatureUnits + "---actualTemperatureUnits--f");
				System.out.println(expectedFtxt + "----expectedTempTxt----f");

				if (actualTemperatureUnits.isEmpty()) {
					ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {

					if (actualTemperatureUnits.contains(expectedFtxt)) {
						ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
								actualTemperatureUnits, expectedFtxt, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Verify Tap on Temperature value box.

						MobileElement temparatureBox2 = weatherPage.gethighTemTextBox();
						String textDefaultText2 = temparatureBox2.getAttribute("value");
						System.out.println(textDefaultText2 + "---textDefaultText--high temp----- -");

						if (temparatureBox2 != null && temparatureBox2.isDisplayed()) {

							ATUReports.add(
									"Mobilize temperature value text box is displayed, and its default value is - "
											+ textDefaultText2,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter min(value) range in text box
							temparatureBox2.click();
							System.out.println("Clear the field");
							weatherPage.gethighTemTextBox().clear();
							// weatherPage.gethighTemTextBox().sendKeys(Keys.INSERT);
							Thread.sleep(2000);
							// weatherPage.gethighTemptxBox().sendKeys("0");weatherpagevalues
							weatherPage.gethighTemTextBox().setValue(weatherpagevalues.hightem_F_min);
							// System.out.println("enter 0 value");

							// Next button is enabled
							// Verify button is not enabled
							ATUReports.add("Next button is  enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter out of range values in text
							// box
							// it contains zero by default
							temparatureBox2.click();
							// weatherPage.getTemperatureBox().clear();
							Thread.sleep(1000);
							// MobileElement highTempBx=(MobileElement)
							// driver.findElementById("com.davis.mobilize:id/et_high_temp");
							// highTempBx.sendKeys(Keys.CLEAR);
							weatherPage.gethighTemTextBox().clear();
							// weatherPage.gethighTemTextBox().sendKeys(Keys.INSERT);
							// Thread.sleep(2000);

							// weatherPage.gethighTemTextBox().sendKeys(Keys.DELETE);
							// weatherPage.gethighTemTextBox().sendKeys(Keys.INSERT);
							// highTempBx.sendKeys("151");weatherpagevalues
							weatherPage.gethighTemTextBox().setValue(weatherpagevalues.high_tem_F_ot_range);
							Thread.sleep(3000);

							System.out.println(weatherPage.gethighTemTextBox().getAttribute("value")
									+ "---text out of range value---");
							ATUReports.add("Entered Out of range value ",
									weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Observe Next button is not Enabled.
							ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify to enter max(value) range in textbox
							// MobileElement highTempBx2=(MobileElement)
							// driver.findElementById("com.davis.mobilize:id/et_high_temp");
							weatherPage.gethighTemTextBox().click();
							weatherPage.gethighTemTextBox().clear();
							// highTempBx2.sendKeys(Keys.INSERT);
							Thread.sleep(2000);
							weatherPage.gethighTemTextBox().sendKeys(weatherpagevalues.high_temp_F_max);
							Thread.sleep(1000);
							System.out.println(weatherPage.gethighTemTextBox().getAttribute("value")
									+ "---text maximum range value---");
							ATUReports.add("Entered maximum value",
									weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(3000);

							// click on done button
							WebElement doneBtn8 = (WebElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action8 = new TouchAction(driver);
							action8.longPress(doneBtn8).release().perform();
							Thread.sleep(6000);

							// clikcedOnNext
							if (croppage.getnextButtonTopText() != null) {
								if (croppage.getnextButtonTopText().isDisplayed()) {
									ATUReports.add(
											"Next button is enabled in the Current screenand clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									TimeUnit.SECONDS.sleep(2);
									// WebElement doneBtn3 = (WebElement)
									// driver.findElementByAccessibilityId("Done");
									TouchAction action2 = new TouchAction(driver);
									action2.longPress(croppage.getnextButtonTopText()).release().perform();
									TimeUnit.SECONDS.sleep(15);
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									}
								}

							}
						} else {
							ATUReports.add("temperature value text box  is not observed in the screen ",
									actualTemperatureUnits, expectedFtxt, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							driver.close();
						}

						// ********** Low Temperature alert **********
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
							ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ",
									"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (lowtemplert_title.equals("LOW TEMPERATURE ALERT")) {
								ATUReports.add("Low Temperature Alert is noticed in the screen ",
										"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("LOW TEMPERATURE ALERT is not observed in the screen ",
										lowtemplert_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}

						// Verify temperature units from current page

						String actualLowTemperatureUnits = weatherPage.getftxt().getText();
						System.out.println(actualLowTemperatureUnits + "---actualTemperatureUnits--c");
						System.out.println(expectedFtxt + "----cUnitsActualText----c");

						if (actualLowTemperatureUnits.isEmpty()) {
							ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (actualLowTemperatureUnits.contains(expectedFtxt)) {
								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualLowTemperatureUnits, expectedFtxt, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify Tap on Temperature value box.

								MobileElement lowTemperatureBox = weatherPage.getlowTemTemTextBox();
								String lowTemperatureBoxDefaultText = lowTemperatureBox.getAttribute("value");
								System.out.println(lowTemperatureBoxDefaultText
										+ "---lowTemperatureBoxDefaultText--high temp----- -");

								if (lowTemperatureBox != null && lowTemperatureBox.isDisplayed()) {

									ATUReports.add(
											"Mobilize temperature value text box is displayed, and its default value is - "
													+ lowTemperatureBoxDefaultText,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify to enter min(value) range in text
									// box
									lowTemperatureBox.click();
									System.out.println("Clear the field");
									weatherPage.getlowTemTemTextBox().clear();
									// weatherPage.getlowTemTemTextBox().sendKeys(Keys.INSERT);
									Thread.sleep(1000);
									weatherPage.getlowTemTemTextBox().setValue(weatherpagevalues.low_tem_f_min);
									// System.out.println("enter 0 value");

									// System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
									// + "---textminimum value---");
									ATUReports.add("Entered minimum value",
											weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(3000);

									// Next button is enabled
									// Verify button is not enabled
									ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify to enter out of range values in
									// text
									// box

									Thread.sleep(1000);
									weatherPage.getlowTemTemTextBox().clear();
									Thread.sleep(2000);
									weatherPage.getlowTemTemTextBox().setValue(weatherpagevalues.low_temp_f_ot_range);
									Thread.sleep(4000);
									System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
											+ "---text ot of value---");
									ATUReports.add("Entered Out of range value ",
											weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify Observe Next button is not
									// Enabled.
									// Verify button is not enabled
									ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify to enter max(value) range in
									// textbox
									weatherPage.getlowTemTemTextBox().click();
									weatherPage.getlowTemTemTextBox().clear();
									// weatherPage.getlowTemTemTextBox().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									// weatherPage.getlowTempTxtBox().sendKeys("50");weatherpagevalues
									weatherPage.getlowTemTemTextBox().sendKeys(weatherpagevalues.low_f_max);
									System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
											+ "---text maxm  value---");
									ATUReports.add("Entered maximum value",
											weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(3000);

									// click on done button
									WebElement doneBt9 = (WebElement) driver.findElementByAccessibilityId("Done");
									Thread.sleep(5000);
									TouchAction action9 = new TouchAction(driver);
									action9.longPress(doneBt9).release().perform();
									Thread.sleep(6000);

									// clikcedOnNext
									if (croppage.getnextButtonTopText() != null) {
										if (croppage.getnextButtonTopText().isDisplayed()) {
											ATUReports.add(
													"Next button is enabled in the Current screenand clicked on the Next button",
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											TimeUnit.SECONDS.sleep(2);
											// WebElement doneBtn3 =
											// (WebElement)
											// driver.findElementByAccessibilityId("Done");
											TouchAction action2 = new TouchAction(driver);
											action2.longPress(croppage.getnextButtonTopText()).release().perform();
											TimeUnit.SECONDS.sleep(15);
											croppage.getnextButtonTopText().click();
											Thread.sleep(2000);

										} else {
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
												ATUReports.add("Next button is not enabled in the current screen`",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
										}

									}

									// Verify weather title text.
									String complete_weather_title = weatherPage.getcomplete_weather_titletxt()
											.getAttribute("name");
									// System.out.println(title);
									if (complete_weather_title.isEmpty()) {
										ATUReports.add("Verify the Complete Weather Setup text  in the screen ",
												"COMPLETE WEATHER SETUP", complete_weather_title, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (complete_weather_title.equals("COMPLETE WEATHER SETUP")) {
											ATUReports.add("Complete Weather Setup is noticed in the screen ",
													"COMPLETE WEATHER SETUP", complete_weather_title, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Complete Weather Setup is not observed in the screen ",
													complete_weather_title, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}

								} else {
									ATUReports.add("temperature value text box  is not observed in the screen ",
											actualLowTemperatureUnits, expectedFtxt, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

							} else {
								driver.close();
							}

						} // low temperaure box

					} else {

						// -------------**************** VERIFY HIGH & LOW
						// TEMPERATURE IN C UNITS
						// **********************---------------

						if (actualTemperatureUnits.contains(expectedCText)) {
							ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
									actualTemperatureUnits, expectedCText, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Tap on Temperature value box.
							MobileElement temparatureBox4 = weatherPage.gethighTemTextBox();
							String textDefaultText4 = temparatureBox4.getAttribute("value");
							System.out.println(temparatureBox4 + "---textDefaultText--high temp-- in c units---- -");

							if (temparatureBox4 != null && temparatureBox4.isDisplayed()) {

								ATUReports.add(
										"Mobilize temperature value text box is displayed, and its default value is - "
												+ textDefaultText4,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter min(value) range in text box
								temparatureBox4.click();
								// MobileElement highTempBx2=(MobileElement)
								// driver.findElementById("com.davis.mobilize:id/et_high_temp");
								weatherPage.gethighTemTextBox().clear();
								// highTempBx2.sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								// highTempBx2.sendKeys("0");weatherpagevalues
								weatherPage.gethighTemTextBox().setValue(weatherpagevalues.high_temp_c_min);
								Thread.sleep(2000);
								System.out.println(weatherPage.gethighTemTextBox().getAttribute("value")
										+ "---textminimum value   in c---");
								ATUReports.add("Entered minimum value",
										weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Next button is enabled
								// Verify button is not enabled
								ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter out of range values in text
								// box
								// it contains zero by default
								weatherPage.gethighTemTextBox().click();
								Thread.sleep(1000);
								// weatherPage.gethighTemTextBox().sendKeys(Keys.DELETE);
								weatherPage.gethighTemTextBox().clear();
								Thread.sleep(2000);
								// weatherPage.gethighTemptxBox().sendKeys("66");weatherpagevalues
								weatherPage.gethighTemTextBox().setValue(weatherpagevalues.high_temp_c_ot_range);
								Thread.sleep(1000);
								System.out.println(weatherPage.gethighTemTextBox().getAttribute("value")
										+ "---text out of range value- in c--");
								ATUReports.add("Entered Out of range value ",
										weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								// driver.hideKeyboard();

								// Verify Observe Next button is not Enabled.
								ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter max(value) range in textbox
								weatherPage.gethighTemTextBox().click();
								Thread.sleep(1000);
								weatherPage.gethighTemTextBox().clear();
								Thread.sleep(2000);
								// weatherPage.gethighTemptxBox().sendKeys("65");

								weatherPage.gethighTemTextBox().sendKeys(weatherpagevalues.high_temp_c_max);
								Thread.sleep(1000);
								System.out.println(weatherPage.gethighTemTextBox().getAttribute("value")
										+ "---text maximum range value in c---");
								ATUReports.add("Entered maximum value",
										weatherPage.gethighTemTextBox().getAttribute("value"), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								// driver.hideKeyboard();
								Thread.sleep(2000);

								// click on done button
								WebElement done1 = (WebElement) driver.findElementByAccessibilityId("Done");
								Thread.sleep(5000);
								TouchAction action1 = new TouchAction(driver);
								action1.longPress(done1).release().perform();
								Thread.sleep(6000);

								// clikcedOnNext
								if (croppage.getnextButtonTopText() != null) {
									if (croppage.getnextButtonTopText().isDisplayed()) {
										ATUReports.add(
												"Next button is enabled in the Current screenand clicked on the Next button",
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
										ATUReports.add("Next button is not enabled in the current screen`",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
											ATUReports.add("Next button is not enabled in the current screen`",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
									}

								}

							} else {
								ATUReports.add("temperature value text box  is not observed in the screen ",
										actualTemperatureUnits, expectedCText, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.close();
							}

							// --------*****Verify Low Temperature
							// alert***--------

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
								ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ",
										"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (lowtemplert_title.equals("LOW TEMPERATURE ALERT")) {
									ATUReports.add("Low Temperature Alert is noticed in the screen ",
											"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("LOW TEMPERATURE ALERT is not observed in the screen ",
											lowtemplert_title, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// Verify temperature units from current page

							String actualLowTemperatureUnits = weatherPage.getftxt().getText();
							System.out.println(actualLowTemperatureUnits + "---actualTemperatureUnits--c");
							// System.out.println(cUnitsActualText +
							// "----cUnitsActualText----c");

							if (actualLowTemperatureUnits.isEmpty()) {
								ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (actualLowTemperatureUnits.contains(expectedCText)) {
									ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
											actualLowTemperatureUnits, expectedCText, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify Tap on Temperature value box.

									MobileElement lowTemperatureBox = weatherPage.getlowTemTemTextBox();
									String lowTemperatureBoxDefaultText = lowTemperatureBox.getAttribute("value");
									System.out.println(lowTemperatureBoxDefaultText
											+ "---lowTemperatureBoxDefaultText--high temp----- -");

									if (lowTemperatureBox != null && lowTemperatureBox.isDisplayed()) {
										ATUReports.add(
												"Mobilize temperature value text box is displayed, and its default value is - "
														+ lowTemperatureBoxDefaultText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter min(value) range in
										// text box
										lowTemperatureBox.click();
										System.out.println("Clear the field");
										weatherPage.getlowTemTemTextBox().clear();
										Thread.sleep(2000);
										// weatherPage.getlowTempTxtBox().sendKeys("0");weatherpagevalues
										weatherPage.getlowTemTemTextBox().setValue(weatherpagevalues.low_c_min);
										Thread.sleep(2000);
										// System.out.println("enter 0 value");
										// System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
										// + "---textminimum value---");
										ATUReports.add("Entered minimum value",
												weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										// driver.hideKeyboard();

										// Next button is enabled
										// Verify button is not enabled
										ATUReports.add("Next button is enabled in current screen", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter out of range values
										// in text
										// box
										// it contains zero by default

										// weatherPage.getTemperatureBox().clear();
										Thread.sleep(1000);
										weatherPage.getlowTemTemTextBox().click();
										weatherPage.getlowTemTemTextBox().clear();
										Thread.sleep(2000);
										weatherPage.getlowTemTemTextBox()
												.setValue(weatherpagevalues.low_temp_c_ot_range);
										Thread.sleep(1000);

										System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
												+ "---text ot of value---");
										ATUReports.add("Entered Out of range value ",
												weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify Observe Next button is not
										// Enabled.
										ATUReports.add("Next button is not enabled in current screen", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter max(value) range in
										// textbox
										weatherPage.getlowTemTemTextBox().clear();
										Thread.sleep(2000);
										// weatherPage.getlowTempTxtBox().sendKeys("10");weatherpagevalues
										weatherPage.getlowTemTemTextBox().sendKeys(weatherpagevalues.low_temp_c_max);
										System.out.println(weatherPage.getlowTemTemTextBox().getAttribute("value")
												+ "---text maxm  value---");
										ATUReports.add("Entered maximum value",
												weatherPage.getlowTemTemTextBox().getAttribute("value"), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										// driver.hideKeyboard();
										Thread.sleep(1000);

										// click on done button
										WebElement done6 = (WebElement) driver.findElementByAccessibilityId("Done");
										Thread.sleep(5000);
										TouchAction action6 = new TouchAction(driver);
										action6.longPress(done6).release().perform();
										Thread.sleep(6000);

										// clikcedOnNext();
										// nextButton();

										if (croppage.getnextButtonTopText() != null) {
											if (croppage.getnextButtonTopText().isDisplayed()) {
												ATUReports.add(
														"Next button is enabled in the Current screenand clicked on the Next button",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												TimeUnit.SECONDS.sleep(2);
												TouchAction action2 = new TouchAction(driver);
												action2.longPress(croppage.getnextButtonTopText()).release().perform();
												TimeUnit.SECONDS.sleep(15);
												Thread.sleep(2000);

											} else {
												ATUReports.add("Next button is not enabled in the current screen`",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
													ATUReports.add("Next button is not enabled in the current screen`",
															LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												}
											}

										}

										// Verify weather title text.
										String complete_weather_title = weatherPage.getcomplete_weather_titletxt()
												.getAttribute("name");
										if (complete_weather_title.isEmpty()) {
											ATUReports.add("Verify the Complete Weather Setup text  in the screen ",
													"COMPLETE WEATHER SETUP", complete_weather_title, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (complete_weather_title.equals("COMPLETE WEATHER SETUP")) {
												ATUReports.add("Complete Weather Setup is noticed in the screen ",
														"COMPLETE WEATHER SETUP", complete_weather_title, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Complete Weather Setup is not observed in the screen ",
														complete_weather_title, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

									} else {
										ATUReports.add("temperature value text box  is not observed in the screen ",
												actualTemperatureUnits, expectedFtxt, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
									}

								} else {
									driver.close();
								}
							}

						} //

					}
				} // high and low tem c units

			}
			System.out.println(
					"***************************ENDING- WeatherThresholdTemperature **************************");
			ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");
		} catch (Exception e) {// InterruptedException
			System.out.println(
					"***************************CATCH- WeatherThresholdTemperature **************************");
			driver.resetApp();
			//driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}

	}
*/

	public static void nextButton() throws InterruptedException {

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
					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}

	}

	public static void nextButtonEnabled() throws InterruptedException {

		if (croppage.getnextButtonTopText() != null) {
			if (croppage.getnextButtonTopText().isDisplayed()) {
				Thread.sleep(2000);
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} else {
			if (croppage.getnext_nxt_save_btn() != null) {
				if (croppage.getnext_nxt_save_btn().isDisplayed()) {
					Thread.sleep(2000);
					// croppage.getnext_nxt_save_btn().click();

					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

	public static void nextButtonIsNotEnabled() throws InterruptedException {

		if (croppage.getnextButtonTopText() != null) {
			if (croppage.getnextButtonTopText().isDisplayed()) {
				Thread.sleep(2000);
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} else {
			if (croppage.getnext_nxt_save_btn() != null) {
				if (croppage.getnext_nxt_save_btn().isDisplayed()) {
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

		// Verify back
		if (frostpage.gettempUnitsPageBackBtnName() != null) {
			if (frostpage.gettempUnitsPageBackBtnName().isEnabled()) {
				ATUReports.add("Back button is enabled in the in the current screen and clicked on the back button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				TimeUnit.SECONDS.sleep(2);
				TouchAction action2 = new TouchAction(driver);
				action2.longPress(frostpage.gettempUnitsPageBackBtnName()).release().perform();
				TimeUnit.SECONDS.sleep(15);

			} else {
				ATUReports.add("Back button is not enabled in the current screen`", LogAs.INFO,
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

					ATUReports.add("Back button is not enabled in the current screen`", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

		}

	}

}

/*
 * // Scroll to wind speed Dimension dimensions
 * =//driver.manage().window().getSize(); Double screenHeightStart =
 * dimensions.getHeight() * 0.5; int scrollStart = screenHeightStart.intValue();
 * System.out.println("s="+scrollStart); Double screenHeightEnd =
 * dimensions.getHeight() * 0.2; int scrollEnd = screenHeightEnd.intValue();
 * 
 * for (int i = 0; i < dimensions.getHeight(); i++) { ATUReports.add("in loop",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * driver.swipe(0,scrollStart,0,scrollEnd,20000); if
 * (driver.findElement(By.name("Wind Speed")).isDisplayed()){ break; }
 * TimeUnit.SECONDS.sleep(20); ATUReports.add(
 * "Wind Speed Units list is displayed", LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); driver.findElement(By.name(
 * "Wind Speed")).click(); TimeUnit.SECONDS.sleep(10);
 * 
 * }
 */

// ---------Verify windSpeed-----
// MobileElement windSpeedUnits =(MobileElement)
// driver.findElement(By.name("Wind Speed"));//(MobileElement)
// driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]"));
// WebElement windSpeed=driver.findElement(By.name("Wind Speed"));
// String windSpeedText=windSpeed.getAttribute("name");
// System.out.println(windSpeedText+"------windSpeedText--------");
// if(windSpeedText.contains("Wind Speed")){
// windSpeedUnits.click();

/*
 * // Scroll to rain rate option driver.executeScript("mobile: scrollTo", new
 * HashMap<String, String>() { { put("element", ((RemoteWebElement)
 * driver.findElement(By.name("Barometric Pressure"))).getId()); } });
 * Thread.sleep(4000); ATUReports.add("Scroll to Barometric Pressure ",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */

/*
 * // Scroll to rain rate option driver.executeScript("mobile: scrollTo", new
 * HashMap<String, String>() { { put("element", ((RemoteWebElement)
 * driver.findElement(By.name("Barometric Pressure"))).getId()); } });
 * Thread.sleep(4000); ATUReports.add("Scroll to Barometric Pressure ",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */
// name("Wind Speed")

/*
 * // Verify temperature int size =
 * homepage.gettableview().findElementsByClassName("UIATableCell").size(); for
 * (int i = 0; i <= size; i++) { row =
 * homepage.gettableview().findElementsByClassName("UIATableCell").get(i).
 * findElementByClassName("UIAStaticText"); if(row!=null){
 * if(row.getAttribute("name").contains("Temperature")){ row.click();
 * 
 * ATUReports.add(
 * "TemperatureUnits text is noticed in the screen  same as expected and clicked on temperature tap"
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */

/*
 * // Verify user selected units from preferences. if (homepage.gettableview()
 * != null) { ATUReports.add("Users preferences list is displayed",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */
