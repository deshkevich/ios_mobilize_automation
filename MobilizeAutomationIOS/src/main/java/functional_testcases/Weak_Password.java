package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.Test;

import utility.ReadNewUserDetails;
import utility.ReadRegistration;
import Pages.HomePage;
import Pages.SignUpPage;
import Pages.WelcomePage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Weak_Password {


	private IOSDriver driver ;
	private SignUpPage signuppage ; 
	private ReadNewUserDetails readnewuserdetails ;
	private HomePage homepage;

	@Test
	public void weak_Password(){

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			new ReadRegistration();
			new WelcomePage(driver);
			readnewuserdetails = new ReadNewUserDetails();
			homepage = new HomePage(driver);

			//verify the Sign up button is present in the screen and click on sign up button
			if (signuppage.getsignupbtn().isDisplayed() || signuppage.getsignupbtn().isEnabled())
			{
				readnewuserdetails.start();
				signuppage.getsignupbtn().click();

				ATUReports.add("Verify the Signup button is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// verify the Email id Placeholder text
				String emailid = signuppage.getemailtxtbx().getText();
				if(emailid.isEmpty()){
					ATUReports.add("Verify the emailid placeholder text in the screen ", "Enter your Email", emailid,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (emailid.equals("Enter your Email")) {
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your Email", emailid,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", emailid,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}


				
				//Enter the email in the text box
				String emaiID =readnewuserdetails.emaiID;
				signuppage.getemailtxtbx().sendKeys(emaiID);

				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the first name screen  
				driver.hideKeyboard("Return");

				if (signuppage.getfirstTopSkip().isDisplayed()|| signuppage.getfirstTopSkip().isEnabled()) {
					ATUReports.add("Skip î  button is displayed/enabled in the First Name screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the First Name screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the last name screen
				driver.hideKeyboard("Return");

				if (signuppage.getfirstTopSkip().isEnabled() || signuppage.getfirstTopSkip().isDisplayed()) {
					ATUReports.add("Skip î  button is displayed/enabled in the First Name screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getfirstTopSkip().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the Last name screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
				String usernamevalue =readnewuserdetails.username;
				signuppage.getusername().sendKeys(usernamevalue);

				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getnextbtn().click();
			         Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Password placeholder text
				String pasword  = signuppage.getpwdTextBox().getText();
				if(pasword.isEmpty()){
					ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", "Enter password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (pasword.equals("Enter password")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter password
				String weakpasswordvalue =readnewuserdetails.weak_password;
				signuppage.getpwdTextBox().sendKeys(weakpasswordvalue);


				//Verify the Weak password  text
				String weakpasword  = signuppage.getfirstnameTextBox().getText();
				if(weakpasword.isEmpty()){
					ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (weakpasword.equals("WEAK PASSWORD")) {
						ATUReports.add("Text WEAK PASSWORD is displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				Thread.sleep(2000);
				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getnextbtn().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Confirm password  text
				String confirmpasword  = signuppage.getfirstnameTextBox().getText();
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
				String caption  = signuppage.getNameFirstTextFieldTitle().getText();
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
				signuppage.getpwdTextBox().sendKeys(weakpasswordvalue);


				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getnextbtn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Search text field
				MobileElement searchplaceholder = homepage.getsearchtxtfield();
				if (searchplaceholder.isDisplayed()) {

					ATUReports.add("Search text field is displayed", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Search text field is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			}
			else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
