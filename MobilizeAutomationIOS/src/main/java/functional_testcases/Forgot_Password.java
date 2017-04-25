package functional_testcases;

import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.Read_Change_Password;
import Pages.Alert_Page;
import Pages.LoginPage;
import Pages.SignUpPage;

public class Forgot_Password {

	private SignUpPage signuppage ; 
	private IOSDriver driver ;
	private LoginPage loginpage ;
	private Alert_Page alertpage ;
	private ReadUserData readUserData ;
	private Read_Change_Password changePassword;
	private Read_Change_Password readchangepassword;
@Test
	public void forgot_password(){


		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			loginpage = new LoginPage(driver);
			alertpage = new Alert_Page(driver);
			readUserData=new ReadUserData();
			readUserData.start();
			changePassword=new Read_Change_Password();
			changePassword.start();
			readchangepassword = new Read_Change_Password();
			readchangepassword.start();
			//Click on loginpage text.
			//loginpage.getlogintext().click();

			ATUReports.add("Clicked on Login text", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Enter any value
			//loginpage.getUserNametxtbx().sendKeys("xcube");
			loginpage.getUserNametxtbx().sendKeys(readUserData.sUserName);
			String username = loginpage.getUserNametxtbx().getText();
			if(username.isEmpty()){
				ATUReports.add("Verify the Mobilize logo text", "xcube", username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (username.equals(readUserData.sUserName)) {
					ATUReports.add("Mobilize logo is displayed", "xcube", username,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Verify the Mobilize logo text", "xcube", username,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}	

			//Click on Next button
			loginpage.getNextButton().click();
			
			Thread.sleep(3000);
			// enter password in the Password in the text box
			MobileElement password = loginpage.getPasswordtxtbx();
			if (password != null) {
				if (password.isDisplayed()) {
					password.sendKeys(readchangepassword.newpassword);
					//driver.hideKeyboard("Return");

				} else {
					driver.quit();

				}
			}

			// Click on Next button
			loginpage.getnextPswd().click();
			Thread.sleep(18000);
			
			
			//Verify the error message
			String error =  alertpage.geterror().getText();
			if(error.isEmpty()){
				ATUReports.add("Next button is not displayed in the screen ", "Error", error,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (error.equals("Error")) {
					ATUReports.add("Next button is displayed in the screen ", "Error", error,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Next button is not displayed in the screen ", error,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			
			//Verify the error caption message
			String errormessage =  alertpage.getforgotpasswordtxt().getText();
			if(errormessage.isEmpty()){
				ATUReports.add("Next button is not displayed in the screen ", "Credentials are required to access this resource.", errormessage,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (errormessage.equals("Credentials are required to access this resource.")) {
					ATUReports.add("Next button is displayed in the screen ", "Credentials are required to access this resource.", errormessage,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Next button is not displayed in the screen ", errormessage,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			
			//Click on ok Button
			alertpage.getokbutton().click();
			ATUReports.add("Clicked on Ok Button in the alert box",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
