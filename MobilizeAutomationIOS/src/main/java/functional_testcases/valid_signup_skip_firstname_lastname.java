package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.Test;

import utility.ReadNewUserDetails;
import utility.ReadRegistration;
import utility.ReadUserData;
import Pages.SignUpPage;
import Pages.WelcomePage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class valid_signup_skip_firstname_lastname {

	private IOSDriver driver ;
	private ReadRegistration rrs ;
	private SignUpPage signuppage ; 
	private WelcomePage welcomepage ;
	private ReadNewUserDetails readnewuserdetails ;
	private ReadUserData readUserData ;
	@Test
	public void valid_Signup_Skip_Firstname_Lastname(){

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			rrs = new ReadRegistration();
			welcomepage = new WelcomePage(driver);
			readnewuserdetails = new ReadNewUserDetails();
			readnewuserdetails.start();
			readUserData=new ReadUserData();
			readUserData.start();
			
			//verify the Signup button is present in the screen nd click on signup button
			if (signuppage.getsignUpText().isDisplayed() || signuppage.getsignUpText().isEnabled())
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
				
				
				MobileElement emaitxtbox = signuppage.getemailtxtbx();
				System.out.println(emaitxtbox.getText()+"---emaitxtbox--");
				emaitxtbox.sendKeys(readUserData.emailid);
				String next =signuppage.getnextbtn().getText();
				System.out.println(next+"--next--");
				
			
				//Verify the next button is enabled
				if (signuppage.getnextbtn().isEnabled() ) {
				 // next = signuppage.getnextbtn().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						if (next.contains("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}				
				}
					//Click on the next button
					signuppage.getnextbtn().click();

					//Click on Skip button in the first name screen
					//driver.hideKeyboard("Return");
					if (signuppage.getfirstTopSkip().isDisplayed()|| signuppage.getfirstTopSkip().isEnabled()) {

						ATUReports.add("Skip î  button is displayed/enabled in the First Name screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						//Click on the next button
						signuppage.getfirstTopSkip().click();
						
						
					} else {
						ATUReports.add("Skip î  button is not displayed/enabled in the First Name screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					//driver.hideKeyboard("Return");
					
					
					
					//Verify the user name placeholder text
					String username  = signuppage.getuseranmeTxtBox().getText();
					if(username.isEmpty()){
						ATUReports.add("Placeholder text Enter your username is not displayed in the screen ", "Enter your username", username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (username.equals("Enter your username")) {
							ATUReports.add("Placeholder textEnter your username is displayed in the screen ", "Enter your username", username,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Placeholder text Enter your username is not displayed in the screen ", username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					/*//Enter text in the user name 
					signuppage.getusername().sendKeys(readnewuserdetails.username);

					//Verify the next button is enabled
					if (signuppage.getuserNameNextBtn().isEnabled() ) {

						ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						//Click on the next button
						signuppage.getuserNameNextBtn().click();
					} else {
						ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}*/
				//Enter text in the username 
				signuppage.getfirstnameTextBox().sendKeys(readnewuserdetails.invalidusername);
				
				//Verify the Invalid Uername text
				String invalid_username = signuppage.getfirstnameTextBox().getText();
				
				if(invalid_username.isEmpty()){
					ATUReports.add("Invalid UserName  is not displayed in the screen ", "INVALID USERNAME", invalid_username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (invalid_username.equals("INVALID USERNAME")) {
						ATUReports.add("Invalid UserName is displayed in the screen ", "INVALID USERNAME", invalid_username,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Invalid UserName is not displayed in the screen ", invalid_username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Verify the Caption below the Invalid Uername text
				
				String invalid_usernamecaption = signuppage.getpwdHeadingCaption().getText();
				
				if(invalid_usernamecaption.isEmpty()){
					ATUReports.add("Invalid UserName caption is not displayed in the screen ", "Must be six or more charecters", invalid_usernamecaption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (invalid_usernamecaption.equals("Must be six or more charecters")) {
						ATUReports.add("Invalid UserName caption is displayed in the screen ", "Must be six or more charecters", invalid_usernamecaption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Invalid UserName caption is not displayed in the screen ", invalid_usernamecaption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Clear the text - Tap on clear button.
				//signuppage.getcleartxtbtn().click();
				
				//Enter the valid user name
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
					ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", "Enter your password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (pasword.equals("Enter your password")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter your password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				
		/*		
				The below code is for Invalid password assertion
				
		*/		
				//Enter text in the Password 
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.Invalid_password);
				
				//Verify the Invalid Password text
				String invalidpasword = signuppage.getpwdTextBox().getText();
				
				if(invalidpasword.isEmpty()){
					ATUReports.add("Invalid Password is not displayed in the screen ", "INVALID PASSWORD", invalidpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (invalidpasword.equals("INVALID PASSWORD")) {
						ATUReports.add("Invalid Password is displayed in the screen ", "INVALID PASSWORD", invalidpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Invalid Password is not displayed in the screen ", invalidpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Verify the Caption below the Invalid Passwod text
				
				String invalid_passwordcaption = signuppage.getpwdHeadingCaption().getText();
				
				if(invalid_passwordcaption.isEmpty()){
					ATUReports.add("Invalid Password caption is not displayed in the screen ", "Must be six or more charecters", invalid_passwordcaption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (invalid_passwordcaption.equals("Must be six or more charecters")) {
						ATUReports.add("Invalid Password caption is displayed in the screen ", "Must be six or more charecters", invalid_passwordcaption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Invalid Password caption is not displayed in the screen ", invalid_passwordcaption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Clear the text - Tap on clear button.
				//signuppage.getpasswordTextBox().clear();
				
				
				
				/*		
				The below code is for Weak password assertion
				
		*/		
				//Enter text in the Weak Password 
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.weak_password);
				
				//Verify the Weak Password text
				String weakpasword = signuppage.getpwdHeadingText().getText();
				
				if(weakpasword.isEmpty()){
					ATUReports.add("WEAK Password is not displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (weakpasword.equals("WEAK PASSWORD")) {
						ATUReports.add("WEAK Password is displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("WEAK Password is not displayed in the screen ", weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Clear the text - Tap on clear button.
				signuppage.getconformPwdTextBox().clear();
				
				
				
				
				/*		
				The below code is for GOOD password assertion
				
		*/		
				//Enter text in the GOOD Password 
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.weak_password);
				
				//Verify the Weak Password text
				String goodpasword = signuppage.getpwdHeadingText().getText();
				
				if(goodpasword.isEmpty()){
					ATUReports.add("GOOD Password is not displayed in the screen ", "GOOD PASSWORD", goodpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (goodpasword.equals("GOOD PASSWORD")) {
						ATUReports.add("GOOD Password is displayed in the screen ", "GOOD PASSWORD", goodpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("GOOD Password is not displayed in the screen ", goodpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
				//Clear the text - Tap on clear button.
				signuppage.getpwdTextBox().clear();
				
				/*		
				The below code is for STRONG password assertion
				
		*/		
				//Enter text in the STRONG Password 
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.Strong_password);
				
				//Verify the Weak Password text
				String strongpasword = signuppage.getpwdHeadingText().getText();
				
				if(strongpasword.isEmpty()){
					ATUReports.add("STRONG Password is not displayed in the screen ", "STRONG PASSWORD", strongpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (strongpasword.equals("STRONG PASSWORD")) {
						ATUReports.add("STRONG Password is displayed in the screen ", "STRONG PASSWORD", strongpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("STRONG Password is not displayed in the screen ", strongpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
				String confirmpasword  = signuppage.getpwdHeadingText().getText();
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
				signuppage.getpwdTextBox().sendKeys(readnewuserdetails.Confirm_password);

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

				//Verify the welcome text
				String welcome  = welcomepage.getwelcometext().getText();
				if(welcome.isEmpty()){
					ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "WELCOME, Create your first view to begin mobilizing.", welcome,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (welcome.equals("WELCOME, Create your first view to begin mobilizing.")) {
						ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "WELCOME, Create your first view to begin mobilizing.", welcome,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", welcome,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			}
			else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			driver.closeApp();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
