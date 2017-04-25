package functional_testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import jxl.Sheet;
import utility.ExcelUtils;
import utility.Log;
import utility.ReadUserData;
import utility.ReadViewName;

public class Login {

	private IOSDriver driver ;
	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();
	private LoginPage loginpage ;
	private ReadUserData readUserData ;
	private ReadViewName readviewame ;
	private HomePage homepage ;
	private static Alert_Page alertpage;

	@SuppressWarnings("static-access")
	@Test
	public void login() throws MalformedURLException, InterruptedException {

		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		homepage = new HomePage(driver);
		readUserData= new ReadUserData();
		readUserData.start();
		readviewame = new ReadViewName();
		readviewame.start();
		alertpage=new Alert_Page(driver);
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1");

		Log.startTestCase("Login test Case start");
		System.out.println("*********** Login test Case start ********");

		TimeUnit.SECONDS.sleep(10);

		
		driver.findElement(By.name("Enter your username")).sendKeys("xcube");
		
		//verify the logo is present in the screen.
		if (loginpage.getmobilizeLogoImage()!=null) {
			if (loginpage.getmobilizeLogoImage().isDisplayed()) {
				ATUReports.add(" Mobilize logo is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("The Logo is not displayed in the screen ",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

		// Verify the text under the logo
		if (loginpage.getlogo_caption()!=null) {
			String title = loginpage.getlogo_caption().getText();
			if(title.isEmpty()){
				ATUReports.add("Verify the Mobilize logo text", "By Davis Instruments", title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (title.equals("By Davis Instruments")) {
					ATUReports.add("Mobilize logo caption text is matched with expected", "By Davis Instruments", title,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Mobilize logo caption text doesn't matched with expected", "By Davis Instruments", title,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		}


		//Verify the Sign up text and assert
		if (loginpage.getsignUptext()!=null) {
			String Sign_up = loginpage.getsignUptext().getText();
			//System.out.println(Sign_up);
			if(Sign_up.isEmpty()){
				ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (Sign_up.equals("Login_SighUp")) {
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		}
		


		//Verify the Login text and assert
		if (loginpage.getlogintext()!=null) {
			String Login = loginpage.getlogintext().getText();
			//System.out.println(Login);
			if(Login.isEmpty()){
				ATUReports.add("Verify the Login text", "Log in", Login,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (Login.equals("Login_Login")) {
					ATUReports.add("Log in text is displayed as expected", "Log in", Login,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Log in text is not displayed as expected", "Log in", Login,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		}
		
		//Click on log in button

		//Clear the text in the Username text box if any.
		if (loginpage.getUserNametxtbx()!=null) {
			if (loginpage.getUserNametxtbx().getText().isEmpty()) {

			} else {
				loginpage.getUserNametxtbx().clear();
			}
		}
		
		//Verify the Next button
		//String next = loginpage.getNextButton().getText();

		// Calling precondition
		Precondition addClass = new Precondition();
		addClass.precondition();	 
		Thread.sleep(9000);







	}

}




