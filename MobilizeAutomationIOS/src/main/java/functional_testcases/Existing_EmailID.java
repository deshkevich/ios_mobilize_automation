package functional_testcases;

import org.testng.annotations.Test;
import Pages.Alert_Page;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadNewUserDetails;
import utility.ReadUserData;

public class Existing_EmailID {
	
	private IOSDriver driver ;
	private SignUpPage signuppage ; 
	private Alert_Page alertpage ;
	private SignUpPage signUpPage;
	private ReadUserData readUserData ;
	private ReadNewUserDetails readUserDetails;
	@Test
	
	public void SignUp_with_Existing_EmailID(){

		try {
		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		signuppage = new SignUpPage(driver);
		alertpage = new Alert_Page(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		readUserDetails=new ReadNewUserDetails();
		readUserDetails.start();
		
		
		
	
		 //Using keyboard automation to delete data
		signuppage.getclearLogo().click();
		
		MobileElement emaitxtbox = signUpPage.getemailtxtbx();
		emaitxtbox.sendKeys(readUserData.existingEmail);
		System.out.println(readUserData.existingEmail+"---readUserData.existingEmail--");
		String next = null;
		
		//Verify the next button is enabled
		if (signuppage.getnextbtn().isEnabled() ) {

			next = signuppage.getnextbtn().getText();
			if(next.isEmpty()){
				ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (next.contains("Next")) {
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
		if (signuppage.getexistingEmailAlert().isDisplayed()) {
			String errortext = signuppage.getexistingEmailAlert().getText();
			if(errortext.isEmpty()){
				ATUReports.add("Error message is not displayed", " Email already exists", errortext,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (errortext.contains("Email already exists")) {
					ATUReports.add("Email already registered", " Email already exists", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Error message is not displayed", errortext,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		} else {
			
			ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}
		
		
		signuppage.getalertOk().click();
		Thread.sleep(2000);
	
		
				
				
				
				
			/*}else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}*/
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
