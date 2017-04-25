package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadNewUserDetails;
import utility.ReadRegistration;
import utility.ReadUserData;
import Pages.HomePage;
import Pages.SignUpPage;
import Pages.WelcomePage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


//Need to add the new user details in the NewUserDetails excel sheet and accordingly change the row numbers in the  "ReadNewUserDetails.java" class
public class GoodPassword_scenario {
	
	private IOSDriver driver ;
	private SignUpPage signuppage ; 
	private ReadNewUserDetails readnewuserdetails ;
	private HomePage homepage;
	private ReadUserData readUserData ;
	@Test
	public void good_password_scenario() throws InterruptedException{

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			new ReadRegistration();
			new WelcomePage(driver);
			readnewuserdetails = new ReadNewUserDetails();
			readnewuserdetails.start();
			homepage = new HomePage(driver);
			readUserData=new ReadUserData();
			readUserData.start();
			
			
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
			
		
			
			//verify the Signup button is present in the screen nd click on signup button
			if (signuppage.getsignUpText().isDisplayed() || signuppage.getsignUpText().isEnabled())
			{
				signuppage.getsignUpText().click();

				ATUReports.add("Verify the Signup button is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// verify the Email id Placeholder text
				String emailid = signuppage.getemailtxtbx().getText();
				System.out.println(emailid+"---emailid--");
				if(emailid.isEmpty()){
					ATUReports.add("Verify the emailid placeholder text in the screen ", "Enter your Email", emailid,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (emailid.equals("Enter your Email")) {
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your Email", emailid,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", emailid,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}
			
			Thread.sleep(2000);
				
				
			//Enter the email in the text box
			MobileElement emaitxtbox = signuppage.getemailtxtbx();
			System.out.println(emaitxtbox.getText()+"---emaitxtbox--");
			emaitxtbox.sendKeys(readUserData.emailid);
			String next =signuppage.getnextbtn().getText();
			System.out.println(next+"--next--");
			
		
			//Verify the next button is enabled
			if (signuppage.getnextbtn().isEnabled() ) {
			 // next = signuppage.getnextbtn().getText();
				if(next.isEmpty()){
					ATUReports.add("Next button is not displayed in the screen ", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					if (next.contains("Next")) {
						ATUReports.add("Next button is displayed in the screen ", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						
						//Enter text in the user name 
						signuppage.getuseranmeTxtBox().sendKeys(readnewuserdetails.username);
						ATUReports.add("Entered user name in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}else{
						ATUReports.add("Placeholder text Enter your username is not displayed in the screen ", username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				

				//Verify the next button is enabled
				if (signuppage.getuserNameNextBtn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getuserNameNextBtn().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Password placeholder text
				String pasword  = signuppage.getpwdTextBox().getAttribute("name");
				if(pasword.isEmpty()){
					ATUReports.add("Placeholder text Enter your password is not displayed in the screen ", "Enter your password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					if (pasword.equals("Enter your password")) {
						ATUReports.add("Enter your password is displayed in the screen and entered password in text box ", "Enter your password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						//Enter password 
						signuppage.getpwdTextBox().sendKeys(readnewuserdetails.good_password);
						Thread.sleep(5000);
					}else{
						ATUReports.add("Placeholder text Enter your password is not displayed in the screen ","Enter your password", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				


				//Verify the Weak password  text
				String weakpasword  = signuppage.getpwdHeadingText().getText();
				if(weakpasword.isEmpty()){
					ATUReports.add("Text GOOD PASSWORD is not displayed in the screen ", "GOOD PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(5000);
				}else{
					if (weakpasword.equals("GOOD PASSWORD")) {
						ATUReports.add("Text GOOD PASSWORD is displayed in the screen ", "GOOD PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text GOOD PASSWORD is not displayed in the screen ","GOOD PASSWORD" ,weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			

				//Verify the next button is enabled
				if (signuppage.getpwdAllNextBtn().isEnabled() ) {
					ATUReports.add("Next button is displayed & enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					//Click on the next button
					signuppage.getpwdAllNextBtn().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Confirm password  text
				String confirmpasword  = signuppage.getpwdHeadingText().getAttribute("name");
				if(confirmpasword.isEmpty()){
					ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(5000);
				}else{
					if (confirmpasword.equals("CONFIRM PASSWORD")) {
						ATUReports.add("Text CONFIRM PASSWORD is displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", confirmpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}


				//Verify the caption text
				String caption  = signuppage.getpwdHeadingCaption().getText();
				if(caption.isEmpty()){
					ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Please retype password to confirm", caption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (caption.equals("Please retype password to confirm")) {
						ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Please retype password to confirm", caption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(5000);
						//Enter the Confirm password
						signuppage.getconformPwdTextBox().sendKeys(readnewuserdetails.good_password);
						
					}else{
						ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", caption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				

				//Verify the caption text
				caption  = signuppage.getpwdHeadingCaption().getAttribute("name");
				if(caption.isEmpty()){
					ATUReports.add("Text caption -Password match is not displayed in the screen ", "Password match", caption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					if (caption.equals("Password match")) {
						ATUReports.add("Text caption -Password match is displayed in the screen ", "Password match", caption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
						/*driver.findElementByAccessibilityId("Login_Next").click();
						
						ATUReports.add("Next button is  enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
					}else{
						ATUReports.add("Text caption -Password match is not displayed in the screen ", caption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(2000);
				

			/*	//Verify the add text field
				MobileElement addPhotoFiled= signuppage.getaddPhotoText();
				String addPhotoFiledText=addPhotoFiled.getText();
				if (addPhotoFiled.isDisplayed()) {

					ATUReports.add(addPhotoFiledText+" text field is displayed", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add(addPhotoFiledText+" text field is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}*/

				

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
	
	}

}
