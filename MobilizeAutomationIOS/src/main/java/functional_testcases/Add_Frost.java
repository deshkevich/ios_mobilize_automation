package functional_testcases;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
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
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadDeviceConfiguration;
import utility.ReadUserData;
import utility.Read_Frost_Details;

//Update the unique frost details in the excel sheet
@SuppressWarnings("unused")
public class Add_Frost {

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
	private static CropPage croppage;
	private Account_Page accountpage;

	// This method includes the back button and Next button functionality
	@SuppressWarnings("rawtypes")
	@Test
	public void addFrost() throws InterruptedException {
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
		croppage = new CropPage(driver);

		accountpage = new Account_Page(driver);
		try {

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
			// enter user in the user name text box
			MobileElement username = loginpage.getUserNametxtbx();
			if (username != null) {
				String usertx = username.getText();

				if (usertx.equals("Enter your username")) {
					CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
					ATUReports.add("Username text box text  is displayed same as expected-", "Enter your username",
							usertx, LogAs.PASSED, screen1);

					username.click();
					username.sendKeys(readUserData.sUserName);
					Thread.sleep(4000);
				} else {
					ATUReports.add("Verify the usertx text is not displayed ", "Enter your username", usertx,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				ATUReports.add("Verify the usertx text box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.quit();
			}

			// Click on Next button
			clickonNextButton();
			TimeUnit.SECONDS.sleep(5);
			// enter password in the Password in the text box
			MobileElement pwd = loginpage.getPasswordtxtbx();

			if (pwd != null) {
				String pwdtxt = pwd.getAttribute("name");

				if (pwdtxt.equals("Enter your password")) {
					CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
					ATUReports.add("Passowrd text box text is displayed same as expected-", "Enter your password",
							pwdtxt, LogAs.PASSED, screen1);
					pwd.click();
					pwd.sendKeys(readUserData.sPassword);
					Thread.sleep(4000);

				} else {
					ATUReports.add("Verify the pwdtxt text is not displayed", "Enter your password", pwdtxt,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				ATUReports.add("Verify the pwdtxt text box is not displayed", "Enter your password", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.quit();
			}

			// Click on Next button
			MobileElement nextPawd = loginpage.getnextPswd();
			ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");
			if (nextPawd != null) {
				ATUReports.add("Next button is displayed same as expected", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(9000);
				if (nextPawd.isDisplayed()) {
					ATUReports.add("Next button is displayed and clicked on next button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					nextPawd.click();
					TimeUnit.SECONDS.sleep(10);

				} else {
					ATUReports.add("Next button is not displayed ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} else {
				ATUReports.add("Next button is not displayed ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on the Add view button
			if (homepage.getaddbtn() != null) {
				homepage.getaddbtn().click();
				ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				TimeUnit.SECONDS.sleep(5);
			}

			// Enter The verified text in the view name text field
			if (newviewscreenpage.getview_txtfld() != null) {
				newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
				Thread.sleep(4000);
			}

			// Click on Add button
			if (newviewscreenpage.getviewNextBtn() != null) {
				newviewscreenpage.getviewNextBtn().click();
				TimeUnit.SECONDS.sleep(9);

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
			// Click on the Frost
			String title = newviewscreenpage.getFrost().getText();
			System.out.println(title + "---title===text--");
			if (newviewscreenpage.getFrost() != null) {
				if (newviewscreenpage.getFrost().isDisplayed()) {
					newviewscreenpage.getFrost().click();
					TimeUnit.SECONDS.sleep(8);
					ATUReports.add("Clicked on " + title + " text  in the View  screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add(title, "-  is displayed clicked on-", title, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					WebElement element = newviewscreenpage.geteditViewBtn();
					if (newviewscreenpage.getshareicon() != null) {

						// Scroll to Edit settings option
						driver.executeScript("mobile: scrollTo", new HashMap<String, String>() {
							{
								put("element", ((RemoteWebElement) driver.findElement(By.name("Edit View"))).getId());
							}
						});
						TimeUnit.SECONDS.sleep(2);
						// Click on edit settings.
						driver.findElement(By.name("Edit View")).click();
						TimeUnit.SECONDS.sleep(2);

					} else {
						ATUReports.add("Share icon element is nt visible in the screen", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					Thread.sleep(2000);
					ATUReports.add("scroll to edit view button when expected text is not diplayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					if (newviewscreenpage.getFrost().isDisplayed()) {
						newviewscreenpage.getFrost().click();
						TimeUnit.SECONDS.sleep(8);
						ATUReports.add("Clicked on " + title + " text  in the View  screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			} else {
				ATUReports.add(title, "-  is not displayed", title, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify the Edit Frost text
			MobileElement fostTitle = frostpage.getfrostViewTitleText();
			String frostText = fostTitle.getText();
			System.out.println(frostText + "----frostText------");
			TimeUnit.SECONDS.sleep(3);
			if (frostText.isEmpty()) {
				ATUReports.add("Verify the Edit Frost in the screen ", "Frost", frostText, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frostText.equalsIgnoreCase("Frost")) {
					ATUReports.add("Edit Frost is noticed in the screen ", "Frost", frostText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(5);

					// Verify the title text
					String titleText = frostpage.getfrostSensorTitle().getText();
					System.out.println(titleText + "---ttile--");
					if (titleText.isEmpty()) {
						ATUReports.add("Verify the Sensor Input text  in the screen ",
								"FROST SENSOR INPUT".toUpperCase(), titleText, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (titleText.equalsIgnoreCase("FROST SENSOR INPUT")) {
							ATUReports.add("FROST SENSOR INPUT text is noticed in the screen ", "FROST SENSOR INPUT",
									titleText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("FROST SENSOR INPUT text is not observed in the screen ", titleText,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						if (body.contains(
								"Select the appropriate device and sensor inputs for monitoring frost data.")) {
							ATUReports.add("Frost Sensor Input caption text  in the screen",
									"Select the appropriate device and sensor inputs for monitoring frost data.", body,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost Sensor Input caption text  is not displayed in the screen", body,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					TimeUnit.SECONDS.sleep(5);

					// Select any option from device drop down
					WebElement Devicestxt = frostpage.getdeviceDrpDwnId();
					String devicesText = frostpage.getDevicestxt().getText();
					// Devicestxt.click();
					TimeUnit.SECONDS.sleep(5);
					ATUReports.add("Clicked on the " + devicesText + " drop down ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Select drop down values
					String deviceDrpDwnTxt = frostpage.getdevicedropdown().getText();
					frostpage.getdevicedropdown().click();
					ATUReports.add("Clicked on the " + devicesText + " drop down " + deviceDrpDwnTxt, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(10);

					// click on sensor drop down
					// MobileElement SensorDrpDwn = frostpage.getsensorxpath();
					String sensorTxt = frostpage.getSensortxt().getText();
					TimeUnit.SECONDS.sleep(10);

					// Select any sensor drop down value from drop down list
					String sensorDrpDwnTxt = frostpage.getsensordropdown().getText();

					WebElement element = frostpage.getsensordropdown();
					Thread.sleep(5000);
					TouchAction action = new TouchAction(driver);
					action.longPress(element).release().perform();
					Thread.sleep(4000);
					ATUReports.add("Clicked on the " + sensorTxt + "drop down and selected " + sensorTxt + " value is- "
							+ sensorDrpDwnTxt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// clicked on next button
					TimeUnit.SECONDS.sleep(3);
					nextButton();

					// Verify the title text in the Frost Threshold
					String FrostThreshold_title = frostpage.getfrostThresholdtitletxt().getText();
					if (FrostThreshold_title.isEmpty()) {
						ATUReports.add("Verify the Frost Threshold text  in the screen ", "FROST THRESHOLD",
								FrostThreshold_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (FrostThreshold_title.equalsIgnoreCase("FROST THRESHOLD")) {
							ATUReports.add("Frost Threshold text is noticed in the screen ", "FROST THRESHOLD",
									FrostThreshold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost Threshold text is not observed in the screen ", FrostThreshold_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify the body text
					String FrostThreshold_body = frostpage.getfrostThresholdCaption().getText();
					if (FrostThreshold_body.isEmpty()) {
						ATUReports.add("Verify the Frost Threshold caption text  in the screen ",
								"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
								FrostThreshold_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (FrostThreshold_body.contains(
								"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.")) {
							ATUReports.add("Frost threshold caption text is dispalyed in the screen ",
									"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
									FrostThreshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost threshold caption text is not dispalyed in the screen ",
									FrostThreshold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Enter some value in the Temperature
					frostpage.getfrostTextBox().clear();
					System.out.println("Enter value in text box");
					Thread.sleep(6000);
					frostpage.getfrostTextBox().sendKeys(read_frost_details.frost_threshold_temp);
					ATUReports.add("Temperature value given in the text box", read_frost_details.frost_threshold_temp,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(5);

					// click on done button
					WebElement doneBtn = (WebElement) driver.findElementByAccessibilityId("Done");
					TimeUnit.SECONDS.sleep(5);
					TouchAction action2 = new TouchAction(driver);
					action2.longPress(doneBtn).release().perform();
					TimeUnit.SECONDS.sleep(5);
					// System.out.println("Clicked on done button");

					// move the slider
					if (frostpage.getTempSlider() != null) {
						thresholdSlider(frostpage.getTempSlider());
						TimeUnit.SECONDS.sleep(5);
					}

					// Click on Plus icon
					if (frostpage.getplusIcon() != null) {
						plusIconButton(frostpage.getplusIcon());
						ATUReports.add(
								"Plus icon is displayed and clicked on Plus icon then Temperature value increased "
										+ frostpage.getfrostTextBox().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(3000);
					}
					// click on minus icon
					if (frostpage.getminusIcon() != null) {
						minusIconButton(frostpage.getminusIcon());
						ATUReports.add(
								"Minus icon is displayed and clicked on Minus icon then Temperature value decreased "
										+ frostpage.getfrostTextBox().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(5000);
					}

					// clicked on next button
					Thread.sleep(3000);
					nextButton();

					// Verify the Early Frost Warning screen
					if (frostpage.getearlyTitle() != null) {
						String Early_Frost_Warning_title = frostpage.getearlyTitle().getText();
						if (Early_Frost_Warning_title.isEmpty()) {
							ATUReports.add("Verify the Early Frost Warning text  in the screen ", "Early Frost Warning",
									Early_Frost_Warning_title, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							if (Early_Frost_Warning_title.equalsIgnoreCase("Early Frost Warning")) {
								ATUReports.add("Early Frost Warning text is displayed", "Early Frost Warning",
										Early_Frost_Warning_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Early Frost Warning", Early_Frost_Warning_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}

						// Verify the body text
						String Early_Frost_Warning_body = frostpage.getBodytxt().getText();
						if (Early_Frost_Warning_body.isEmpty()) {
							ATUReports.add("Verify the Early Frost Warning caption text  in the screen ",
									"An early warning for frost will give you advanced notice if you are nearing your Frost forecast.",
									Early_Frost_Warning_body, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

						// Verify notification tutorial box
						if (alertpage.getnotificationTutorialBoxTxt() != null) {
							ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),
									alertpage.getcreateViewTutorialNextBtn());

							// click on close icon
							if (alertpage.getcreateViewCloseIcon() != null) {
								alertpage.getcreateViewCloseIcon().click();
								ATUReports.add("Clicked on close icon in create view tutorial ", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}

						}
						// get the value of the optional and click on it
						if (frostpage.getearlyFrostOptionalSlider() != null) {
							frostpage.getearlyFrostOptionalSlider().click();
							Thread.sleep(2000);
							ATUReports.add("optional Slider is displayed in " + Early_Frost_Warning_title, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						Thread.sleep(2000);

						// Enter some value in the Temperature
						if (frostpage.getearlyFrostTextBox() != null) {
							frostpage.getearlyFrostTextBox().clear();
							Thread.sleep(5000);
							// frostpage.gettemparaturetxtfld().sendKeys("34");
							frostpage.getearlyFrostTextBox().sendKeys(read_frost_details.early_frost_warning);
							ATUReports.add("Temperature value given in the text box",
									read_frost_details.early_frost_warning, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(5000);

							// click on done button
							System.out.println("click on done button");
							MobileElement doneBtn2 = (MobileElement) driver.findElementByAccessibilityId("Done");
							Thread.sleep(5000);
							TouchAction action1 = new TouchAction(driver);
							action1.longPress(doneBtn2).release().perform();
							Thread.sleep(5000);

						}
					}
					// move the slider
					if (frostpage.getearlyFrostThresholdSlider() != null) {
						thresholdSlider(frostpage.getearlyFrostThresholdSlider());
						Thread.sleep(4000);
					}

					// Click on Plus icon
					if (frostpage.geteralyFrostPlusIcon() != null) {
						plusIconButton(frostpage.geteralyFrostPlusIcon());
						ATUReports.add(
								"Plus icon is displayed and clicked on Plus icon then Temperature value increased"
										+ frostpage.getearlyFrostTextBox().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(3000);
					}

					// click on minus icon
					if (frostpage.geteralyFrostMinus() != null) {
						minusIconButton(frostpage.geteralyFrostMinus());
						ATUReports.add(
								"Minus icon is displayed and clicked on Minus icon then Temperature value decreased"
										+ frostpage.getearlyFrostTextBox().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(4000);

						// clicked on next button
						Thread.sleep(3000);
						nextButton();
					}
					if (frostpage.getcompletefrost_titletxt() != null) {

						String COMPLETE_FROST_SETUP_title = frostpage.getcompletefrost_titletxt().getText();
						if (COMPLETE_FROST_SETUP_title.isEmpty()) {
							ATUReports.add("Verify the Complete Frost Setup text  in the screen ",
									"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							if (COMPLETE_FROST_SETUP_title.equalsIgnoreCase("Complete Frost Setup")) {
								ATUReports.add("Complete Frost Setup is displayed in the screen ",
										"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Complete Frost Setup is not noticed in the screen",
										COMPLETE_FROST_SETUP_title, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
						Thread.sleep(2000);

						// Verify the body text

						String complete_Frost_setup_body = frostpage.getcompletefrostbodytxt().getText();
						// System.out.println(body + "Complete body");
						if (complete_Frost_setup_body.isEmpty()) {
							ATUReports.add("Verify the Complete Frost Setup caption text in the screen ",
									"Save the setup to view the frost report. Go back to edit any frost setup setting.",
									complete_Frost_setup_body, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							if (complete_Frost_setup_body.equals(
									"Save the setup to view the frost report. Go back to edit any frost setup setting.")) {
								ATUReports.add("Complete Frost Setup caption text is dispalyed in the screen ",
										"Save the setup to view the frost report. Go back to edit any frost setup setting.",
										complete_Frost_setup_body, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Complete Frost Setup caption text is not dispalyed in the screen ",
										complete_Frost_setup_body, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
						Thread.sleep(4000);

					}

					// Click on save button in the Complete Frost Setup
					if (croppage.getsaveTxt() != null) {
						if (croppage.getsaveTxt().isDisplayed()) {
							ATUReports.add("Save button is enabled in the Current screenand clicked on the Next button",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							TouchAction action99 = new TouchAction(driver);
							action99.longPress(croppage.getsaveTxt()).release().perform();
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
								Thread.sleep(3000);
								ATUReports.add("Clicked on  button,Succesfully created frost report screen",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(4000);
							} else {
								ATUReports.add("Save button is not enabled in the current screen`", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
						}

					}
				}

				// Verify notification tutorial box after creating frost.
				if (alertpage.getnotificationTutorialBoxTxt() != null) {
					ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),
							alertpage.getcreateViewTutorialNextBtn());

					// click on close icon
					if (alertpage.getcreateViewCloseIcon() != null) {
						alertpage.getcreateViewCloseIcon().click();
						ATUReports.add("Clicked on close icon in create view tutorial ", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}

				// verify account button
				if (homepage.getaccountbtn() != null) {
					if (homepage.getaccountbtn().isDisplayed()) {
						// homepage.getaccountbtn().click();
						ATUReports.add("Account button is displayed", LogAs.PASSED,
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

			}

		} catch (InterruptedException e) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(8);
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
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
		driver.swipe(xInitial, yInitial, xInitial + 80, yInitial, 5000);
		ATUReports.add("Slider is displayed and moved the slider from left to right", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	public static void plusIconButton(WebElement lastElement) throws InterruptedException {
		// move the slider
		Thread.sleep(4000);
		// WebElement lastElement =frostpage.getplusIcon();

		if (lastElement.isDisplayed()) {
			lastElement.click();
			ATUReports.add("Plus icon is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {

			ATUReports.add("Plus icon is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.close();
		}
	}

	public static void minusIconButton(WebElement lastElement) throws InterruptedException {
		// move the slider
		Thread.sleep(6000);
		// WebElement lastElement2 =frostpage.getminusIcon();
		if (lastElement != null) {
			if (lastElement.isDisplayed()) {
				lastElement.click();
				ATUReports.add("Minus icon is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {

				ATUReports.add("Minus icon is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.close();
			}
		}
	}

	public static void nextButton() throws InterruptedException {

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
					ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

		}
	}

	public static void backButton() throws InterruptedException {

		Thread.sleep(2000);

		if (croppage.getbackButtonTop() != null) {
			if (croppage.getbackButtonTop().isDisplayed()) {
				ATUReports.add("Next button is enabled in the in the current screen and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				croppage.getbackButtonTop().click();
				Thread.sleep(3000);

			} else {
				ATUReports.add("Next button is not enabled in the current screen`", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		} else {
			if (croppage.getbackbtn() != null) {
				if (croppage.getbackbtn().isEnabled()) {
					Thread.sleep(2000);
					croppage.getbackbtn().click();
					Thread.sleep(2000);
					ATUReports.add("Back button is enabled in the current screen and clicked on the back button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Back button is not enabled in the current screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		}

		// }

	}

}