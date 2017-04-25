package functional_testcases;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import Pages.Alert_Page;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Existing_UserID {

	private IOSDriver driver ;
	private SignUpPage signuppage ; 
	private Alert_Page alertpage ;
	private SignUpPage signUpPage;
	private ReadUserData readUserData ;


	@Test
	public void SIgnUP_with_Existing_UserID(){
		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			alertpage = new Alert_Page(driver);
			signUpPage = new SignUpPage(driver);
			readUserData=new ReadUserData();
			readUserData.start();


			//verify the Signup button is present in the screen nd click on signup button
			if (signuppage.getsignupbtn().isDisplayed() || signuppage.getsignupbtn().isEnabled())
			{
				signuppage.getsignupbtn().click();

				ATUReports.add("Verify the Signup button is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// verify the Email id Placeholder text
				try{
					signuppage.getusername().clear();
				}catch(WebDriverException e)
				{
					ATUReports.add("Signup text box is clear",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				String emailidtxt = signuppage.getusername().getAttribute("value");

				if(emailidtxt.isEmpty()){
					ATUReports.add("Verify the emailid placeholder text in the screen ", "Enter your username", emailidtxt,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (emailidtxt.equals("Enter your username")) {
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your username", emailidtxt,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement emaitxtbox = signUpPage.getemailtxtbx();
						emaitxtbox.sendKeys(readUserData.emailid);

					}else{
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", emailidtxt,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				String next = null;
				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() && signuppage.getnextbtn().isDisplayed()) {

					next = signuppage.getnextbtn().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the firstname screen   
				String skip = null; 
				if (signuppage.getfirstTopSkip().isDisplayed()|| signuppage.getfirstTopSkip().isEnabled()) {

					skip = signuppage.getfirstTopSkip().getAttribute("value");
					System.out.println("Skip button"+skip);
					if(skip.trim().isEmpty()){
						ATUReports.add("Skip button is not displayed in the First Name screen ", "Skip", skip,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (skip.trim().equalsIgnoreCase("Skip")) {
							ATUReports.add("Skip button is displayed in the First Name screen ", "Skip", skip,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Skip button is not displayed in the First Name screen ", skip,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getfirstTopSkip().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the First Name screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the username placeholder text
				String username  = signuppage.getusername().getText();
				if(username.isEmpty()){
					ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", "Enter username", username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (username.equals("Enter username")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter username", username,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter text in the username 
				//signuppage.gettxtbx().sendKeys("testing12345");
				MobileElement userNameTextBox = signUpPage.getusername();
				userNameTextBox.click();
				Thread.sleep(3000);
				userNameTextBox.sendKeys(readUserData.Firstname);
				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					next = signuppage.getnextbtn().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Password placeholder text
				String pasword  = signuppage.getpwdTextBox().getText();
				if(pasword.isEmpty()){
					ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", "Enter password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (pasword.equals("Enter password")) {
						ATUReports.add("Placeholder text Enter Password is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter password 
				MobileElement passwordTextBox = signUpPage.getpwdTextBox();
				passwordTextBox.sendKeys(readUserData.sPassword);
				Thread.sleep(3000);


				//Verify the Weak password  text
				String weakpasword  = signuppage.getNameFirstTextFieldTitle().getText();
				if(weakpasword.isEmpty()){
					ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (weakpasword.equals("WEAK PASSWORD")) {
						ATUReports.add("Text WEAK PASSWORD is displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					next = signuppage.getnextbtn().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Confirm password  text
				String confirmpasword  = signuppage.getNameFirstTextFieldTitle().getText();
				if(confirmpasword.isEmpty()){
					ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (confirmpasword.equals("CONFIRM PASSWORD")) {
						ATUReports.add("Text CONFIRM PASSWORD is displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", confirmpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}


				//Verify the caption text
				String caption  = signuppage.getcaption().getText();
				if(caption.isEmpty()){
					ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Please retype password to confirm", caption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (caption.equals("Please retype password to confirm")) {
						ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Please retype password to confirm", caption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", caption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter the Confirm password
				//signuppage.getpedtxtbx().sendKeys("123456");
				MobileElement conformpwdTextBox = signUpPage.getpwdTextBox();
				conformpwdTextBox.sendKeys(readUserData.sPassword);
				Thread.sleep(3000);


				//Verify the caption text
				caption  = signuppage.getcaption().getText();
				if(confirmpasword.isEmpty()){
					ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Password match", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (confirmpasword.equals("Password match")) {
						ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Password match", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", confirmpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					next = signuppage.getnextbtn().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Error message
				if (alertpage.geterror().isDisplayed()) {
					String errortext =alertpage.getemailtxt().getText();
					if(errortext.isEmpty()){
						ATUReports.add("Error message is not displayed", "Username exists.", errortext,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (errortext.equals("Username exists.")) {
							ATUReports.add("Email already exists", "Username exists.", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Error message is not displayed", errortext,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
				} else {

					ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
			}else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
