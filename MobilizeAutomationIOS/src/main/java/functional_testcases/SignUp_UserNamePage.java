package functional_testcases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.Log;
import utility.ReadUserData;

public class SignUp_UserNamePage {
	private IOSDriver driver;
	private LoginPage loginpage;
	private SignUpPage signUpPage;
	private ReadUserData readUserData ;

	@Test
	public void signUp_UserNamePage() throws MalformedURLException, InterruptedException {
		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		new HomePage(driver);
		loginpage = new LoginPage(driver);
		signUpPage = new SignUpPage(driver);
		readUserData=new ReadUserData();
		readUserData.start();

		Log.startTestCase("SignUp_UserNamePage test Case start");
		System.out.println("*********** SignUp_UserNamePage test Case start ********");

		try {

			// Verify the Sign up text and assert
			
			
			MobileElement signup = loginpage.getsignUptext();
			if (signup != null) {
				String Sign_up_txt = signup.getText();
				if (Sign_up_txt.isEmpty()) {
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up_txt, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (Sign_up_txt.equals("Sign up")) {
						CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
						ATUReports.add("Mobilize SignUp text is Displayed. and Clicked on SignUp Text", "Sign up",
								Sign_up_txt, LogAs.PASSED, screen1);

						signup.click();
					} else {

						ATUReports.add("Mobilize SignUp text is not Displayed.", "Sign up", Sign_up_txt, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				}

			}
			Thread.sleep(2000);

			// Click on Enter email text box
			
			MobileElement emaitxtbox = signUpPage.getemailtxtbx();
			if (emaitxtbox.isDisplayed()) {
				Thread.sleep(1000);

				// Enter valid email in text box
				emaitxtbox.sendKeys(readUserData.emailid);
				Thread.sleep(2000);

				ATUReports.add("Mobilize gmail text box  is displayed and enter email in text box", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize gmail text box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				driver.close();
				return;
			}

			// Click on next button
			MobileElement nextButton = signUpPage.getnextbtn();
			nextButton.click();
			Thread.sleep(2000);

			// Verify navigated to first name screen
			
			MobileElement firstNametxt = signUpPage.getNameFirstTextFieldTitle();
			String nameText = firstNametxt.getText();

			if (nameText.isEmpty()) {
				ATUReports.add("Mobilize  First name text box is not displayed", " ENTER FIRST NAME", nameText,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (nameText.equals("ENTER FIRST NAME")) {
					ATUReports.add("Mobilize gmail text box  is displayed", "ENTER FIRST NAME", nameText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Mobilize First name text box is not displayed", "ENTER FIRST NAME", nameText,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(3000);

			/*// Click on skip button without entering first name
			MobileElement skipButton = signUpPage.getskipbtnn();
			String text = skipButton.getText();

			if (skipButton.isEnabled()) {

				ATUReports.add("Mobilize Skip button is Displayed and Clicked on skip button", "Skip ", text,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				skipButton.click();

			} else {
				ATUReports.add("Mobilize Skip button is not displayed ", "Skip ", text, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(3000);

			// Verify to Display username Text
			MobileElement userName = signUpPage.getNameTextFieldTitle();
			String userNameText = userName.getText();
			if (userNameText.contains("ENTER USERNAME")) {
				ATUReports.add("Mobilize 'ENTER USERNAME'  Screen Displayed after Skipping the first name page",
						"ENTER USERNAME", userNameText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Mobilize 'ENTER USERNAME'  Screen is not  Displayed ", "ENTER USERNAME", userNameText,
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(3000);*/

			// Verify to enter name in username text
			MobileElement userNameTextBox = signUpPage.getusername();
			userNameTextBox.click();
			Thread.sleep(3000);
			userNameTextBox.sendKeys(readUserData.Firstname);
			Thread.sleep(3000);
			ATUReports.add("Mobilize 'ENTER USERNAME'  Text box is displayed and enter user name in text box ",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			
			//enter last name in text box
			MobileElement lastrNameTextBox =(MobileElement) driver.findElementByName("Value_TextField_Identifier");
			//MobileElement userNameTextBox = signUpPage.getuserNameTextBox();
			lastrNameTextBox.click();
			Thread.sleep(3000);
			lastrNameTextBox.sendKeys("sree");
			Thread.sleep(3000);
			ATUReports.add("Mobilize 'ENTER USERNAME'  Text box is displayed and enter user name in text box ",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			
			Thread.sleep(2000);
			userNameTextBox.sendKeys(readUserData.Firstname);
			

			// Click on next
			MobileElement userNameNext= signUpPage.getnextbtn();
			userNameNext.click();
			//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[11]").click();
			Thread.sleep(2000);
			ATUReports.add("Mobilize 'Next 'button is Displayed and Clicked on Next button in user name screen ",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Enter password
			MobileElement passwordTextBox = signUpPage.getpwdTextBox();
			passwordTextBox.sendKeys(readUserData.sPassword);
			Thread.sleep(3000);
			ATUReports.add("Mobilize Enter password in 'password' text box ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on next
			MobileElement passwordNext= signUpPage.getnextbtn();
			//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[13]").click();
			// nextButton.click();
			passwordNext.click();
			Thread.sleep(2000);
			ATUReports.add("Mobilize Clicked on Next Button ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Enter conform password
			MobileElement conformpwdTextBox = signUpPage.getpwdTextBox();
			conformpwdTextBox.sendKeys(readUserData.sPassword);
			Thread.sleep(3000);
			ATUReports.add("Mobilize Enter conform password in 'conform password text box' ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on next
			MobileElement conformPwdNext= signUpPage.getnextbtn();
			ATUReports.add("Mobilize Clicked on Next Button ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[15]").click();
			conformPwdNext.click();
			Thread.sleep(3000);

			/*// Verify Added a new Image screen in the Sign up flow
			MobileElement addImageLogo =signUpPage.getaddLogo();
			if (addImageLogo.isDisplayed()) {
				ATUReports.add("Mobilize Add Photo Image logo is Displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Add Photo Image logo is not  Displayed ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Add Photo text is Displayed
			MobileElement addPhotoText = signUpPage.getaddText();
			String addText = addPhotoText.getText();
			if (addPhotoText.isDisplayed()) {
				if (addText.equals("ADD PHOTO")) {

					ATUReports.add("Mobilize Add photo text screen is Displayed", "ADD PHOTO", addText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Mobilize Add photo text screen is not  Displayed ", "ADD PHOTO", addText,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {

				driver.close();
			}
			Thread.sleep(2000);

			// Verify caption of add photo
			MobileElement caption =signUpPage.getaddcaption(); 
			String captionText = caption.getText();
			if (caption.isDisplayed()) {
				if (captionText.equals("Please add a Photo to your account.")) {

					ATUReports.add("Mobilize Add photo Caption-'Please add a Photo to your account.' is Displayed",
							"Please add a Photo to your account.", captionText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add(
							"Mobilize Add photo Caption-'Please add a Photo to your account.' is not  Displayed ",
							"Please add a Photo to your account.", captionText, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
			}

			// Verify Take photo button displayed or not
			MobileElement takePhotoButton =signUpPage.gettakePhoto();
			String takePhotoText = takePhotoButton.getText();
			if (takePhotoButton.isDisplayed()) {
				if (takePhotoText.equals("Take Photo")) {

					ATUReports.add("Mobilize Take Photo button is Displayed and Clicked on-" + takePhotoText,
							"Take Photo", takePhotoText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					takePhotoButton.click();
					Thread.sleep(3000);

					// Click on cancel
					MobileElement takePhotoCancel=signUpPage.gettakeCancel();
					takePhotoCancel.click();
					//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]").click();
					Thread.sleep(3000);

				} else {
					ATUReports.add("Mobilize Take Photo button  is not  Displayed ", "Take Photo", takePhotoText,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();

			}

			// Verify choose from library is Displayed or not
			MobileElement chooseButton = signUpPage.getchooseButton();
			String chooseText = chooseButton.getText();
			if (chooseButton.isDisplayed()) {
				if (chooseText.equals("Choose from Library")) {

					ATUReports.add("Mobilize Choose from Library button is Displayed and Clicked on-" + chooseText,
							"Choose from Library", chooseText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					chooseButton.click();
					Thread.sleep(3000);

					// Click on Cancel
					MobileElement chooseCancel=signUpPage.getchooseCancel();
					chooseCancel.click();
					driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
							.click();

				} else {
					ATUReports.add("Mobilize Choose from Library button  is not  Displayed ", "Choose from Library",
							takePhotoText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				driver.close();

			}

			// Verify next button at top right corner
			MobileElement nextAtTop =signUpPage.getnextButtonTop();
			String nextText = nextAtTop.getText();
			if (nextAtTop.isDisplayed()) {
				if (nextText.contains("Skip")) {
					ATUReports.add("Mobilize Next Button is Displayed in the screen", "Skip", nextText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Mobilize Next Button is not  Displayed ", "Skip", nextText, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
			}
			Thread.sleep(3000);

			// Verify Back button is Displayed or not
			MobileElement backButton =signUpPage.getbackButtonTop();
			String backButtonText = backButton.getText();
			if (backButton.isDisplayed()) {
				if (backButtonText.equals("Back")) {

					ATUReports.add("Mobilize Back Button is Displayed in the screen", "Back", backButtonText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Mobilize Back Button is not  Displayed ", "Back", backButtonText, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				driver.close();
			}*/
			Thread.sleep(3000);

		} catch (Exception e) {
			// e.printStackTrace();

		}

	}
}
