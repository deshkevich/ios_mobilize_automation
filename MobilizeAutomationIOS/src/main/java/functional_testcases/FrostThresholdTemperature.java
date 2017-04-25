package functional_testcases;

import java.util.concurrent.TimeUnit;

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
import utility.ReadDeviceConfiguration;
import utility.ReadFrostThresholdValues;
import utility.ReadUserData;
import utility.ReadViewName;
//import utility.Read_FrostPageThresholdValues;
import utility.Read_Frost_Details;

public class FrostThresholdTemperature {
	@SuppressWarnings("rawtypes")
	private static IOSDriver driver;
	private FrostPage frostpage;
	@SuppressWarnings("unused")
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private Read_Frost_Details read_frost_details;
	private JavascriptExecutor js;
	private static LoginPage loginpage;
	private ReadUserData readUserData;
	private ReadDeviceConfiguration path;
	private static Alert_Page alertpage;
	private Account_Page accountpage;
	private ReadViewName readviewname;
	// private FrostPage frostpage;
	private WebElement row;
	private static CropPage croppage;
	private ReadFrostThresholdValues readfrost;

	@Test
	public void verifyFrostThresholdTemperature() throws InterruptedException {

		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		frostpage = new FrostPage(driver);
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		js = (JavascriptExecutor) driver;
		read_frost_details = new Read_Frost_Details();
		read_frost_details.start();
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		path = new ReadDeviceConfiguration();
		path.start();
		alertpage = new Alert_Page(driver);
		accountpage = new Account_Page(driver);
		readviewname = new ReadViewName();
		readviewname.start();
		croppage = new CropPage(driver);
		readfrost = new ReadFrostThresholdValues();
		readfrost.start();
		try {

			System.out.println(
					"***************************Staring- FrostThresholdTemperature **************************");

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
					Thread.sleep(1000);
				} else {
					ATUReports.add(tabTextTwo + " tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify user selected units from preferences.
			if (homepage.gettableview() != null) {
				ATUReports.add("Users preferences list is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Verify temperature
				int size = homepage.gettableview().findElementsByClassName("UIATableCell").size();
				for (int i = 0; i <= size; i++) {
					row = homepage.gettableview().findElementsByClassName("UIATableCell").get(i)
							.findElementByClassName("UIAStaticText");
					if (row != null) {
						if (row.getAttribute("name").contains("Temperature")) {
							row.click();
							TimeUnit.SECONDS.sleep(15);
							ATUReports.add(
									"TemperatureUnits text is noticed in the screen  same as expected and clicked on temperature tap",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify 'F' an c from temperature list
							MobileElement fText = frostpage.gettemperatureFUnitsTxt();
							String expectedFtxt = fText.getAttribute("name");
							System.out.println(expectedFtxt + "expectedFtxt");
							MobileElement cText = frostpage.gettempCUnitsTxt();
							String expectedCText = cText.getAttribute("name");
							ATUReports.add(
									"Users preferences Temperature  Units  List is displayed and  One unit is selected by default",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Clicked on back button
							if (frostpage.gettempUnitsPageBackBtn() != null) {
								frostpage.gettempUnitsPageBackBtn().click();
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

							// Enter The verified text in the viewname text
							// field---
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

							// Verify frost
							if (newviewscreenpage.getFrost() != null) {
								String title = newviewscreenpage.getFrost().getText();
								if (newviewscreenpage.getFrost().isDisplayed()) {
									newviewscreenpage.getFrost().click();
									Thread.sleep(8000);
									ATUReports.add("Clicked on " + title + " text  in the View  screen", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add(title, "-  is not displayed", title, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// Verify Observe application navigated to Sensor
							// Input
							// screen and

							// Verify the title text
							if (frostpage.getfrostSensorTitle() != null) {
								String titleText = frostpage.getfrostSensorTitle().getText();
								System.out.println(titleText + "---ttile--");
								if (titleText.isEmpty()) {
									ATUReports.add("Verify the Sensor Input text  in the screen ",
											"FROST SENSOR INPUT".toUpperCase(), titleText, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (titleText.equalsIgnoreCase("FROST SENSOR INPUT")) {
										ATUReports.add("FROST SENSOR INPUT text is noticed in the screen ",
												"FROST SENSOR INPUT", titleText, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("FROST SENSOR INPUT text is not observed in the screen ",
												titleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
							}

							// Select any option from device drop down
							WebElement Devicestxt = frostpage.getdeviceDrpDwnId();
							String devicesText = frostpage.getDevicestxt().getText();
							// Devicestxt.click();
							Thread.sleep(5000);
							ATUReports.add("Clicked on the " + devicesText + " drop down ", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Select drop down values
							String deviceDrpDwnTxt = frostpage.getdevicedropdown().getText();
							frostpage.getdevicedropdown().click();
							ATUReports.add("Clicked on the " + devicesText + " drop down " + deviceDrpDwnTxt,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(4000);

							// click on sensor drop down
							// MobileElement SensorDrpDwn =
							// frostpage.getsensorxpath();//----using xpath here
							String sensorTxt = frostpage.getSensortxt().getText();
							System.out.println(sensorTxt + "---Sensortxt");
							// SensorDrpDwn.click();
							Thread.sleep(3000);

							// Select any sensor drop down value from drop down
							// list
							String sensorDrpDwnTxt = frostpage.getsensordropdown().getText();

							WebElement element = frostpage.getsensordropdown();
							Thread.sleep(3000);
							TouchAction action = new TouchAction(driver);
							action.longPress(element).release().perform();
							Thread.sleep(4000);
							System.out.println("Click on sensor value");
							ATUReports.add(
									"Clicked on the " + sensorTxt + "drop down and selected " + sensorTxt
											+ " value is- " + sensorDrpDwnTxt,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// clicked on next button
							Thread.sleep(3000);
							nextButton();

							// Verify the title text in the Frost Threshold
							if (frostpage.getfrostThresholdtitletxt() != null) {
								String FrostThreshold_title = frostpage.getfrostThresholdtitletxt().getText();
								if (FrostThreshold_title.isEmpty()) {
									ATUReports.add("Verify the Frost Threshold text  in the screen ", "FROST THRESHOLD",
											FrostThreshold_title, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (FrostThreshold_title.equalsIgnoreCase("FROST THRESHOLD")) {
										ATUReports.add("Frost Threshold text is noticed in the screen ",
												"FROST THRESHOLD", FrostThreshold_title, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Frost Threshold text is not observed in the screen ",
												FrostThreshold_title, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
							}

							// Verify temperature units F--°F
							if (frostpage.getfrostPpageTemFUnitText() != null) {
								String frostPageUnits = frostpage.getfrostPpageTemFUnitText().getAttribute("name");

								if (frostPageUnits.contains(expectedFtxt)) {

									ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
											frostPageUnits, expectedFtxt, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify Tap on Temperature value box.
									if (frostpage.getfrostTextBox() != null
											&& frostpage.getfrostTextBox().isDisplayed()) {
										MobileElement temparatureBox = frostpage.getfrostTextBox();
										String textDefaultText = frostpage.getfrostTextBox().getAttribute("value");

										ATUReports.add(
												"Mobilize temperature value text box is displayed, and its default value is - "
														+ textDefaultText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter min(value) range in
										// text box
										frostpage.getfrostTextBox().click();
										System.out.println("Clear the field");
										frostpage.getfrostTextBox().clear();
										// frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										frostpage.getfrostTextBox().sendKeys(readfrost.frost_F_MinimumValue);
										System.out.println(
												readfrost.frost_F_MinimumValue + "----readfrost.frost_F_MinimumValue");
										System.out.println("enter 0 value");

										System.out.println(
												frostpage.getfrostTextBox().getText() + "---textminimum value---");
										ATUReports.add("Entered minimum value", temparatureBox.getAttribute("value"),
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// click on done button
										WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
										Thread.sleep(5000);
										TouchAction action2 = new TouchAction(driver);
										action2.longPress(doneBtn).release().perform();
										Thread.sleep(6000);
										System.out.println("Clicked on done button");

										// Next button is enalbled
										nextButtonEnabled();

										// Verify to enter out of range values
										// in text
										// box
										// it contains zero by default
										Thread.sleep(1000);
										frostpage.getfrostTextBox().clear();
										// frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										frostpage.getfrostTextBox().sendKeys(readfrost.frost_F_OutOfRangeValue);
										Thread.sleep(2000);
										System.out.println(readfrost.frost_F_OutOfRangeValue
												+ "---readfrost.frost_F_OutOfRangeValue");
										System.out.println(temparatureBox.getText() + "---text ot of value---");
										ATUReports.add("Entered Out of range value ",
												temparatureBox.getAttribute("value"), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// click on done button
										// WebElement doneBtn = (WebElement)
										// driver.findElementByAccessibilityId("Done");
										Thread.sleep(5000);
										// TouchAction action2 = new
										// TouchAction(driver);
										action2.longPress(doneBtn).release().perform();
										Thread.sleep(6000);
										System.out.println("Clicked on done button");

										// Next button is enalbled
										ATUReports.add("Next button is not enabled in the in the current screen ",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										nextButtonIsNotEnabled();
										/*
										 * //Verify next button in not enabled
										 * if(croppage.getnext_nxt_save_btn()!=
										 * null){
										 * if(croppage.getnext_nxt_save_btn().
										 * isEnabled()){ Thread.sleep(2000);
										 * //croppage.getnext_nxt_save_btn().
										 * click(); Thread.sleep(2000);
										 * ATUReports.add(
										 * "Next button is enabled in the in the current screen and clicked on the Next button"
										 * , LogAs.FAILED, new
										 * CaptureScreen(ScreenshotOf.
										 * BROWSER_PAGE));
										 * 
										 * }else{
										 * 
										 * ATUReports.add(
										 * "Next button is not enabled in the current screen"
										 * , LogAs.PASSED, new
										 * CaptureScreen(ScreenshotOf.
										 * BROWSER_PAGE)); } }
										 * Thread.sleep(2000);
										 */

										// Verify to enter max(value) range in
										// textbox
										// it contains zero by default
										frostpage.getfrostTextBox().clear();
										// frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										frostpage.getfrostTextBox().sendKeys(readfrost.frost_F_MaximumValue);
										System.out.println(temparatureBox.getText() + "---text maxm  value---");
										ATUReports.add("Entered maximum value", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(1000);

										// click on done button
										// WebElement doneBtn = (WebElement)
										// driver.findElementByAccessibilityId("Done");
										Thread.sleep(5000);
										// TouchAction action2 = new
										// TouchAction(driver);
										action2.longPress(doneBtn).release().perform();
										Thread.sleep(6000);
										System.out.println("Clicked on done button");

										// Verify Observe Next button is
										// Enabled.
										// clikcedOnNext
										nextButton();

										/*
										 * if(croppage.getnext_nxt_save_btn()!=
										 * null){
										 * if(croppage.getnext_nxt_save_btn().
										 * isEnabled()){ Thread.sleep(2000);
										 * croppage.getnext_nxt_save_btn().click
										 * (); Thread.sleep(2000);
										 * ATUReports.add(
										 * "Next button is enabled in the in the current screen and clicked on the Next button"
										 * , LogAs.PASSED, new
										 * CaptureScreen(ScreenshotOf.
										 * BROWSER_PAGE)); }else{
										 * ATUReports.add(
										 * "Next button is not enabled in the current screen`"
										 * , LogAs.FAILED, new
										 * CaptureScreen(ScreenshotOf.
										 * BROWSER_PAGE)); } }
										 */

									} else {
										ATUReports.add("temperature value text box  is not observed in the screen ",
												frostPageUnits, expectedFtxt, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
									}

									// Verify the Early Frost Warning screen
									if (frostpage.getearlyTitle() != null) {
										String Early_Frost_Warning_title = frostpage.getearlyTitle().getText();
										if (Early_Frost_Warning_title.isEmpty()) {
											ATUReports.add("Verify the Early Frost Warning text  in the screen ",
													"Early Frost Warning", Early_Frost_Warning_title, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											if (Early_Frost_Warning_title.equalsIgnoreCase("Early Frost Warning")) {
												ATUReports.add("Early Frost Warning text is displayed",
														"Early Frost Warning", Early_Frost_Warning_title, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Early Frost Warning", Early_Frost_Warning_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

										// get the value of the optional and
										// click on it
										if (frostpage.getearlyFrostOptionalSlider() != null) {
											frostpage.getearlyFrostOptionalSlider().click();
											Thread.sleep(2000);
											ATUReports.add(
													"optional Slider is displayed in " + Early_Frost_Warning_title,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);

									}

									// Enter some value in the Temperature
									if (frostpage.getearlyFrostTextBox() != null) {
										if (frostpage.getearlyFrostTextBox().isDisplayed()) {
											ATUReports.add(
													"Mobilize temperature value text box is displayed, and its default value is - "
															+ frostpage.getearlyFrostTextBox().getAttribute("value"),
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// Verify minm value
											// Verify to enter min(value) range
											// in text box
											frostpage.getearlyFrostTextBox().click();
											frostpage.getearlyFrostTextBox().clear();
											// frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											System.out.println("Clear the field");

											frostpage.getearlyFrostTextBox().sendKeys(readfrost.frost_F_MinimumValue);

											System.out.println("enter 0 value");

											System.out.println(frostpage.getearlyFrostTextBox().getText()
													+ "---textminimum value---");
											ATUReports.add("Entered minimum value",
													frostpage.getearlyFrostTextBox().getAttribute("value"),
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// click on done button
											System.out.println("click on done button");
											MobileElement doneBtn2 = (MobileElement) driver
													.findElementByAccessibilityId("Done");
											Thread.sleep(5000);
											TouchAction action1 = new TouchAction(driver);
											action1.longPress(doneBtn2).release().perform();
											Thread.sleep(5000);

											// Verify Observe Next button is
											// Enabled.
											nextButtonEnabled();

											// Verify to enter out of range
											// values in text
											// box
											// it contains zero by default
											Thread.sleep(1000);
											frostpage.getearlyFrostTextBox().clear();
											// frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											frostpage.getearlyFrostTextBox()
													.sendKeys(readfrost.frost_F_OutOfRangeValue);
											System.out.println(readfrost.frost_F_OutOfRangeValue
													+ "---readfrost.frost_F_OutOfRangeValue");
											System.out.println(frostpage.getearlyFrostTextBox().getAttribute("value")
													+ "---text ot of value---");
											ATUReports.add("Entered Out of range value ",
													frostpage.getearlyFrostTextBox().getAttribute("value"),
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// click on done button
											WebElement doneBtn = (WebElement) driver
													.findElementByAccessibilityId("Done");
											Thread.sleep(5000);
											TouchAction action2 = new TouchAction(driver);
											action2.longPress(doneBtn).release().perform();
											Thread.sleep(6000);
											System.out.println("Clicked on done button");

											// Verify Observe Next button is not
											// Enabled.
											nextButtonIsNotEnabled();

											// Verify to enter max(value) range
											// in textbox
											// it contains zero by default
											frostpage.getearlyFrostTextBox().clear();
											// frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											frostpage.getearlyFrostTextBox().sendKeys(readfrost.frost_F_MaximumValue);
											System.out.println(frostpage.getearlyFrostTextBox().getText()
													+ "---text maxm  value---");
											ATUReports.add("Entered maximum value",
													frostpage.getearlyFrostTextBox().getAttribute("value"),
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(1000);

											// click on done button
											// WebElement doneBtn = (WebElement)
											// driver.findElementByAccessibilityId("Done");
											Thread.sleep(5000);
											// TouchAction action2 = new
											// TouchAction(driver);
											action2.longPress(doneBtn).release().perform();
											Thread.sleep(6000);
											System.out.println("Clicked on done button");

											// Next button is enabled
											nextButton();
											/*
											 * if(croppage.getnext_nxt_save_btn(
											 * )!=null){
											 * if(croppage.getnext_nxt_save_btn(
											 * ).isEnabled()){
											 * Thread.sleep(2000);
											 * croppage.getnext_nxt_save_btn().
											 * click(); Thread.sleep(2000);
											 * ATUReports.add(
											 * "Next button is enabled in the in the current screen and clicked on the Next button"
											 * , LogAs.PASSED, new
											 * CaptureScreen(ScreenshotOf.
											 * BROWSER_PAGE)); }else{
											 * ATUReports.add(
											 * "Next button is not enabled in the current screen`"
											 * , LogAs.FAILED, new
											 * CaptureScreen(ScreenshotOf.
											 * BROWSER_PAGE)); } }
											 */

											if (frostpage.getcompletefrost_titletxt() != null) {

												String COMPLETE_FROST_SETUP_title = frostpage
														.getcompletefrost_titletxt().getText();
												if (COMPLETE_FROST_SETUP_title.isEmpty()) {
													ATUReports.add(
															"Verify the Complete Frost Setup text  in the screen ",
															"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
															LogAs.WARNING,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													if (COMPLETE_FROST_SETUP_title
															.equalsIgnoreCase("Complete Frost Setup")) {
														ATUReports.add(
																"Complete Frost Setup is displayed in the screen ",
																"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
																LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add(
																"Complete Frost Setup is not noticed in the screen",
																COMPLETE_FROST_SETUP_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
												}
												Thread.sleep(2000);

												// Verify save button
												if (croppage.getsaveTxt() != null) {
													if (croppage.getsaveTxt().isDisplayed()) {
														ATUReports.add(
																"SAve button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box with F units",
																"Save", LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														croppage.getsaveTxt().click();
														Thread.sleep(2000);

													} else {
														ATUReports.add(
																"Next button is not enabled in the current screen`",
																LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													}
												} else {
													if (croppage.getnext_nxt_save_btn() != null) {
														if (croppage.getnext_nxt_save_btn().isDisplayed()) {
															Thread.sleep(2000);
															croppage.getnext_nxt_save_btn().click();
															Thread.sleep(2000);
															ATUReports.add(
																	"SAve button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box with F units",
																	"Save", LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add(
																	"Next button is not enabled in the current screen`",
																	LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

														}
													}

												}

											}

										} else {
											ATUReports.add(
													"TemperatureUnits text box is not observed in the EARLY FROST screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

									}

								} else {
									if (frostPageUnits.contains(expectedCText)) { // Frost
																					// page
																					// c
																					// units
										ATUReports.add(
												"TemperatureUnits text is noticed in the screen  same as expected ",
												frostPageUnits, expectedCText, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										if (frostpage.getfrostTextBox() != null
												&& frostpage.getfrostTextBox().isDisplayed()) {
											MobileElement temperatureBox = frostpage.getfrostTextBox();

											// Verify to enter min(value) range
											// in
											// text box
											frostpage.getfrostTextBox().click();
											// Thread.sleep(1000);
											System.out.println("Clear the field");
											frostpage.getfrostTextBox().sendKeys(Keys.DELETE);
											frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(1000);
											frostpage.getfrostTextBox().sendKeys(readfrost.Frost_C_Minm);
											System.out.println(readfrost.Frost_C_Minm + "----readfrost.Frost_C_Minm");
											System.out.println("enter -1 value");

											System.out.println(
													temperatureBox.getAttribute("value") + "---textminimum value---");
											ATUReports.add("Entered minimum value",
													temperatureBox.getAttribute("value"), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// click on done button
											WebElement doneBtn = (WebElement) driver
													.findElementByAccessibilityId("Done");
											Thread.sleep(5000);
											TouchAction action2 = new TouchAction(driver);
											action2.longPress(doneBtn).release().perform();
											Thread.sleep(6000);
											System.out.println("Clicked on done button");

											// Next button is enabled
											nextButtonEnabled();

											// Verify to enter out of range
											// values
											// in text box
											// it contains zero by default
											Thread.sleep(2000);
											frostpage.getfrostTextBox().sendKeys(Keys.DELETE);
											frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(1000);
											frostpage.getfrostTextBox().sendKeys(readfrost.Frost_C_OutOf_Range);
											Thread.sleep(1000);
											System.out.println(
													readfrost.Frost_C_OutOf_Range + "---readfrost.Frost_C_OutOf_Range");
											System.out.println(
													temperatureBox.getAttribute("value") + "---text ot of value---");
											ATUReports.add("Entered Out of range value ",
													temperatureBox.getAttribute("value"), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// Verify Observe Next button is not
											// Enabled.
											nextButtonIsNotEnabled();

											// Verify to enter max(value) range
											// in
											// textbox
											// it contains zero by default
											Thread.sleep(1000);
											frostpage.getfrostTextBox().sendKeys(Keys.DELETE);
											frostpage.getfrostTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(1000);
											frostpage.getfrostTextBox().sendKeys(readfrost.Frost_C_Maxm);

											System.out.println(
													temperatureBox.getAttribute("value") + "---text maxm  value---");
											ATUReports.add("Entered maximum value",
													temperatureBox.getAttribute("value"), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(1000);

											// clicked on next button
											Thread.sleep(3000);
											nextButton();

											//
										} else {
											ATUReports.add(
													"TemperatureUnits text box is not observed in the Frost threshold  screen ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} //

										// Verify the Early Frost Warning screen
										if (frostpage.getearlyTitle() != null) {
											String Early_Frost_Warning_title = frostpage.getearlyTitle().getText();
											if (Early_Frost_Warning_title.isEmpty()) {
												ATUReports.add("Verify the Early Frost Warning text  in the screen ",
														"Early Frost Warning", Early_Frost_Warning_title, LogAs.WARNING,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												if (Early_Frost_Warning_title.equalsIgnoreCase("Early Frost Warning")) {
													ATUReports.add("Early Frost Warning text is displayed",
															"Early Frost Warning", Early_Frost_Warning_title,
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													ATUReports.add("Early Frost Warning", Early_Frost_Warning_title,
															LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
											}

											// get the value of the optional and
											// click on it
											if (frostpage.getearlyFrostOptionalSlider() != null) {
												frostpage.getearlyFrostOptionalSlider().click();
												Thread.sleep(2000);
												ATUReports.add(
														"optional Slider is displayed in " + Early_Frost_Warning_title,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											Thread.sleep(2000);
										}

										if (frostpage.getearlyFrostTextBox() != null) {
											if (frostpage.getearlyFrostTextBox().isDisplayed()) {
												String actualDefaultText = frostpage.getearlyFrostTextBox()
														.getAttribute("value");

												ATUReports.add(
														"Mobilize temperature value text box is displayed with "
																+ expectedCText + " and its default value is - "
																+ actualDefaultText,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												// Verify minm value
												// Verify to enter min(value)
												// range in
												// text box
												frostpage.getearlyFrostTextBox().click();
												Thread.sleep(1000);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.DELETE);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
												Thread.sleep(2000);
												System.out.println("Clear the field");
												frostpage.getearlyFrostTextBox().sendKeys(readfrost.early_C_frost_Minm);
												System.out.println("enter -1 value");
												System.out
														.println(frostpage.getearlyFrostTextBox().getAttribute("value")
																+ "---textminimum value---");
												ATUReports.add("Entered minimum value",
														frostpage.getearlyFrostTextBox().getAttribute("value"),
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												// click on done button
												System.out.println("click on done button");
												MobileElement doneBtn2 = (MobileElement) driver
														.findElementByAccessibilityId("Done");
												Thread.sleep(5000);
												TouchAction action1 = new TouchAction(driver);
												action1.longPress(doneBtn2).release().perform();
												Thread.sleep(5000);

												// Next button is enabled
												nextButtonEnabled();

												// Verify to enter out of range
												// values
												// in text box
												// it contains zero by default

												Thread.sleep(2000);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.DELETE);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
												Thread.sleep(2000);
												frostpage.getearlyFrostTextBox()
														.sendKeys(readfrost.early_C_Frost_OutOfRage);
												System.out.println(readfrost.early_C_Frost_OutOfRage
														+ "---readfrost.early_C_Frost_OutOfRage");
												System.out
														.println(frostpage.getearlyFrostTextBox().getAttribute("value")
																+ "---text ot of value---");
												ATUReports.add("Entered Out of range value ",
														frostpage.getearlyFrostTextBox().getAttribute("value"),
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												// click on done button
												System.out.println("click on done button");
												// MobileElement doneBtn2 =
												// (MobileElement)
												// driver.findElementByAccessibilityId("Done");
												Thread.sleep(5000);
												// TouchAction action1 = new
												// TouchAction(driver);
												action1.longPress(doneBtn2).release().perform();
												Thread.sleep(5000);

												// Verify Observe Next button is
												// not Enabled.
												nextButtonIsNotEnabled();

												// Verify to enter max(value)
												// range in
												// textbox
												// it contains zero by default
												Thread.sleep(1000);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.DELETE);
												frostpage.getearlyFrostTextBox().sendKeys(Keys.INSERT);
												Thread.sleep(2000);
												Thread.sleep(1000);
												frostpage.getearlyFrostTextBox().sendKeys(readfrost.early_C_Frost_Maxm);
												System.out
														.println(frostpage.getearlyFrostTextBox().getAttribute("value")
																+ "---text maxm  value---");
												ATUReports.add("Entered maximum value",
														frostpage.getearlyFrostTextBox().getAttribute("value"),
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												Thread.sleep(1000);

												// click on done button
												System.out.println("click on done button");
												// MobileElement doneBtn2 =
												// (MobileElement)
												// driver.findElementByAccessibilityId("Done");
												Thread.sleep(5000);
												// TouchAction action1 = new
												// TouchAction(driver);
												action1.longPress(doneBtn2).release().perform();
												Thread.sleep(5000);

												// Next button is enabled
												nextButton();

												if (frostpage.getcompletefrost_titletxt() != null) {

													String COMPLETE_FROST_SETUP_title = frostpage
															.getcompletefrost_titletxt().getText();
													if (COMPLETE_FROST_SETUP_title.isEmpty()) {
														ATUReports.add(
																"Verify the Complete Frost Setup text  in the screen ",
																"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
																LogAs.WARNING,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														if (COMPLETE_FROST_SETUP_title
																.equalsIgnoreCase("Complete Frost Setup")) {
															ATUReports.add(
																	"Complete Frost Setup is displayed in the screen ",
																	"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
																	LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add(
																	"Complete Frost Setup is not noticed in the screen",
																	COMPLETE_FROST_SETUP_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
													}
													Thread.sleep(2000);

													// Verify save button

													// Verify save button
													if (croppage.getsaveTxt() != null) {
														if (croppage.getsaveTxt().isDisplayed()) {
															ATUReports.add(
																	"Save button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box with F units",
																	"Save", LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															croppage.getsaveTxt().click();
															Thread.sleep(2000);

														} else {
															ATUReports.add(
																	"Next button is not enabled in the current screen`",
																	LogAs.FAILED,
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
																		LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															} else {
																ATUReports.add(
																		"save button is not enabled in the current screen`",
																		LogAs.FAILED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															}
														}

													}

											

												}

											} else {
												ATUReports.add(
														"TemperatureUnits text box is not observed in the EARLY FROST screen with C units ",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

									}
								} // total else brase

							} // temp frost page units text
							break;
						} else {
							ATUReports.add("Users Temperature  list is not displayed not contains temperature text",
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					}

				} // for loop teperature

			} else {// table view
				ATUReports.add("Users preferences list is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		} catch (InterruptedException i) {// InterruptedException i
			// i.printStackTrace();
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
		}
		System.out.println("***************************Ending- FrostThresholdTemperature **************************");

	}

	public static void nextButton() throws InterruptedException {
		if (croppage.getnextButtonTopText() != null) {
			if (croppage.getnextButtonTopText().isDisplayed()) {
				ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				TimeUnit.SECONDS.sleep(2);

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

		if (croppage.getnextButtonTopText() != null) {
			if (croppage.getnextButtonTopText().isDisplayed()) {
				ATUReports.add("Next button is enabled in the Current screenand clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
					// croppage.getnext_nxt_save_btn().click();
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

	public static void nextButtonIsNotEnabled() throws InterruptedException {

		if (croppage.getnextButtonTopText() != null) {
			if (croppage.getnextButtonTopText().isEnabled()) {
				Thread.sleep(2000);
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} else {
			if (croppage.getnext_nxt_save_btn() != null) {
				if (croppage.getnext_nxt_save_btn().isDisplayed()) {
					Thread.sleep(2000);
					// croppage.getnext_nxt_save_btn().click();
					Thread.sleep(2000);
					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

}
