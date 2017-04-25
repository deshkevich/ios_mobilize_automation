package functional_testcases;

import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import utility.ReadNewUserDetails;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Password_Not_Matching {
	private SignUpPage signuppage ; 
	private IOSDriver driver ;
	private ReadNewUserDetails readnewuserdetails ;

@Test
	public void Password_not_matching(){
		
		
		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		signuppage = new SignUpPage(driver);
		readnewuserdetails = new ReadNewUserDetails();
		readnewuserdetails.start();

		try {
			//verify the Signup button is present in the screen nd click on signup button
			if (signuppage.getsignupbtn().isDisplayed() || signuppage.getsignupbtn().isEnabled())
			{
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
				//signuppage.gettxtbx().sendKeys("testing12@gmail.com");
				
				//Enter the email in the text box
				String emaiID =readnewuserdetails.emaiID;
				signuppage.getemailtxtbx().sendKeys(emaiID);
				
				
				String next = null;
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

				//Click on Skip button in the firstname screen   
				String skip = null; 
				if (signuppage.getfirstTopSkip().isDisplayed()|| signuppage.getfirstTopSkip().isEnabled()) {

					skip = signuppage.getfirstTopSkip().getText();
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

				//Click on Skip button in the last name screen
				if (signuppage.getfirstTopSkip().isEnabled() || signuppage.getfirstTopSkip().isDisplayed()) {

					skip = signuppage.getfirstTopSkip().getText();
					if(skip.trim().isEmpty()){
						ATUReports.add("Skip button is not displayed in the Last name screen ", "Skip", skip,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (skip.trim().equals("Skip")) {
							ATUReports.add("Skip button is displayed in the Last name screen ", "Skip", skip,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Skip button is not displayed in the Last name screen ", skip,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getfirstTopSkip().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the Last name screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the username placeholder text
				String username  = signuppage.getuseranmeTxtBox().getText();
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
				//signuppage.gettxtbx().sendKeys("testing54321");
				signuppage.getuseranmeTxtBox().sendKeys(readnewuserdetails.username);

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
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter password 
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.Invalid_password);


				//Verify the Weak password  text
				String weakpasword  = signuppage.getpwdTextBox().getText();
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
				String confirmpasword  = signuppage.getconformPwdTextBox().getText();
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
				signuppage.getconformPwdTextBox().sendKeys(readnewuserdetails.Confirm_password);
				
				//Verify the caption text
				caption  = signuppage.getcaption().getText();
				if(confirmpasword.isEmpty()){
					ATUReports.add("Text caption -This password doe not match is not displayed in the screen ", "This password does not match", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (confirmpasword.equals("This password does not match")) {
						ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "This password does not match", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			}else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
