package functional_testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

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
import utility.ReadUserData;
import utility.Read_Frost_Details;

public class Frost_SkippingOptional {

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

	@SuppressWarnings("rawtypes")
	@Test
	public void frostSkipping() throws InterruptedException {

		try {
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
			
			
			ATUReports.add("Before launch",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
			// reset the application - 
			//close the application
			//Launch App
			driver.resetApp();
			TimeUnit.SECONDS.sleep(25);
			ATUReports.add("After launch",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		


			/*//Reset app
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
				//Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			*/
			TimeUnit.SECONDS.sleep(6);

			//TimeUnit.SECONDS.sleep(7);
			// Click on the Add view button
			homepage.getaddbtn().click();
			ATUReports.add("Clicked on Add button in the Home screen", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(5000);

			// Enter The verified text in the view name text field
			newviewscreenpage.getview_txtfld().sendKeys(read_frost_details.uniquefrostname);
			Thread.sleep(4000);

			// Click on Add button
			newviewscreenpage.getviewNextBtn().click();
			Thread.sleep(3000);

			// Click on the Frost
			String title = newviewscreenpage.getFrost().getText();
			System.out.println(title + "---title===text--");
			if (newviewscreenpage.getFrost() != null) {
				if (newviewscreenpage.getFrost().isDisplayed()) {
					newviewscreenpage.getFrost().click();
					Thread.sleep(8000);
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
						Thread.sleep(2000);

						// Click on edit settings.
						driver.findElement(By.name("Edit View")).click();
						Thread.sleep(2000);

					} else {
						ATUReports.add("Share icon element is nt visible in the screen", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					Thread.sleep(2000);
					ATUReports.add("scroll to edit view button when expected text is not diplayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					if (newviewscreenpage.getFrost().isDisplayed()) {
						newviewscreenpage.getFrost().click();
						Thread.sleep(8000);
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
			Thread.sleep(3000);
			if (frostText.isEmpty()) {
				ATUReports.add("Verify the Edit Frost in the screen ", "Frost", frostText, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frostText.equalsIgnoreCase("Frost")) {
					ATUReports.add("Edit Frost is noticed in the screen ", "Frost", frostText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(5000);

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

			// Select any option from device drop down
			WebElement Devicestxt = frostpage.getdeviceDrpDwnId();
			String devicesText = frostpage.getDevicestxt().getText();
			// Devicestxt.click();
			Thread.sleep(5000);
			ATUReports.add("Clicked on the " + devicesText + " drop down ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select drop down values
			// String deviceDrpDwnTxt = frostpage.getdevicedropdown().getText();
			frostpage.getdevicedropdown().click();
			ATUReports.add("Clicked on the " + devicesText + " drop down in " + devicesText, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(5000);

			// click on sensor drop down
			String sensorTxt = frostpage.getSensortxt().getText();

			// Select any sensor drop down value from drop down list
			String sensorDrpDwnTxt = frostpage.getsensordropdown().getText();
			frostpage.getsensordropdown().click();
			Thread.sleep(4000);

			WebElement element = frostpage.getsensordropdown();
			Thread.sleep(5000);
			TouchAction action = new TouchAction(driver);
			action.longPress(element).release().perform();
			Thread.sleep(4000);
			System.out.println("Click on sensor value");
			ATUReports.add("Clicked on the " + sensorTxt + "drop down and selected " + sensorTxt + " value is- "
					+ sensorDrpDwnTxt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// clicked on next button
			Thread.sleep(3000);
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
					ATUReports.add("Frost threshold caption text is not dispalyed in the screen ", FrostThreshold_body,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// clicked on next button
			Thread.sleep(3000);
			nextButton();

			// Verify the Early Frost Warning screen
			String Early_Frost_Warning_title = frostpage.getearlyTitle().getText();
			if (Early_Frost_Warning_title.isEmpty()) {
				ATUReports.add("Verify the Early Frost Warning text  in the screen ", "Early Frost Warning",
						Early_Frost_Warning_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (Early_Frost_Warning_title.equalsIgnoreCase("Early Frost Warning")) {
					ATUReports.add("Early Frost Warning text is displayed", "Early Frost Warning",
							Early_Frost_Warning_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						Early_Frost_Warning_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (Early_Frost_Warning_body
						.equals("Early warning threshold is set to alert for cases where frost may soon follow.")) {
					ATUReports.add("Early Frost Warning caption text is dispalyed in the screen ",
							"Early warning threshold is set to alert for cases where frost may soon follow.",
							Early_Frost_Warning_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Early Frost Warning caption text is not dispalyed in the screen ",
							Early_Frost_Warning_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
				ATUReports.add("Mobilize Notification  tutorial screen  is not displayed", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// clicked on next button
			Thread.sleep(3000);
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

			String COMPLETE_FROST_SETUP_title = frostpage.getcompletefrost_titletxt().getText();
			if (COMPLETE_FROST_SETUP_title.isEmpty()) {
				ATUReports.add("Verify the Complete Frost Setup text  in the screen ", "Complete Frost Setup",
						COMPLETE_FROST_SETUP_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (COMPLETE_FROST_SETUP_title.equalsIgnoreCase("Complete Frost Setup")) {
					ATUReports.add("Complete Frost Setup is displayed in the screen ", "Complete Frost Setup",
							COMPLETE_FROST_SETUP_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Complete Frost Setup is not noticed in the screen", COMPLETE_FROST_SETUP_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(2000);

			ATUReports.add("Succesfully skippin all frost data", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));// Next

		} catch (NullPointerException e) {
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			System.out.println("*************************** CATCH -Frost skipping optional**************************");
			e.printStackTrace();
		}

	
	}

	// Verify next button
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

}
