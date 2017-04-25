package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pages.Alert_Page;
import Pages.HomePage;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadNewUserDetails;
import utility.ReadUserData;

public class SignUp {
	private IOSDriver driver ;
	private SignUpPage signuppage ; 
	//private SignUpPage signUpPage;
	private ReadUserData readUserData ;
	private ReadNewUserDetails readUserDetails;
	private HomePage homepage;
	private Alert_Page alertpage;
	@Test	
	public void signUp() throws InterruptedException{

		try {
			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			new Alert_Page(driver);
			readUserData=new ReadUserData();
			readUserData.start();
			readUserDetails=new ReadNewUserDetails();
			readUserDetails.start();
			//WebDriverWait wait=new WebDriverWait(driver,10);
			homepage = new HomePage(driver);
			alertpage =new Alert_Page(driver);
			
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
				 
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						if (next.contains("Next")) {
							signuppage.getnextbtn().click();
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}				
				}
				
				
				//Verify alert
				if(alertpage.getokbutton()!=null){
					alertpage.getokbutton().click();
					ATUReports.add("Alert is displayed in current screen clicked on ok in alert button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Alert is not displayed in current screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
			// Verify navigated to first name screen
			String gmailText = signuppage.getNameFirstTextFieldTitle().getText();
			//System.out.println(gmailText+"---gmailText--");
			if (gmailText.isEmpty()) {
				ATUReports.add("Mobilize  gmail text box is not displayed", " ENTER FIRST NAME",
						gmailText, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (gmailText.equalsIgnoreCase("ENTER FIRST NAME")) {
					ATUReports.add("Mobilize user name  text box  is displayed", "ENTER FIRST NAME",
							gmailText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				} else {
					ATUReports.add("Mobilize user name text box is not displayed", "ENTER FIRST NAME",
							gmailText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			
			//driver.hideKeyboard();

			

		
				
				
			
			
				}//alert 
		
	}catch (InterruptedException e) {
		driver.resetApp();
		TimeUnit.SECONDS.sleep(20);
		// TODO: handle exception
		e.printStackTrace();
	}

			}
	}

	
