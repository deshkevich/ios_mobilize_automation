package functional_testcases;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.Account_Page;
import Pages.Alert_Page;
import Pages.FrostPage;
import Pages.HomePage;
import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;

public class Account {

	@SuppressWarnings("rawtypes")
	private IOSDriver driver;
	private HomePage homepage;
	private Account_Page accountpage;
	private ReadUserData readUserData;
	@SuppressWarnings("unused")
	private LoginPage loginpage;
	private static Alert_Page alertpage;
	@SuppressWarnings({ "rawtypes", "static-access", "unused" })
	@Test
	public void account() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			new FrostPage(driver);
			homepage = new HomePage(driver);
			accountpage = new Account_Page(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			TimeUnit.SECONDS.sleep(9);	
			loginpage = new LoginPage(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			alertpage=new Alert_Page(driver);
			TimeUnit.SECONDS.sleep(9);	
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
			//TimeUnit.SECONDS.sleep(6);
		
			TimeUnit.SECONDS.sleep(8);
			//verify account button
			if(homepage.getaccountbtn()!=null){

				if(homepage.getaccountbtn().isDisplayed()){
					homepage.getaccountbtn().click();
					ATUReports.add("Clicked on account button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					TimeUnit.SECONDS.sleep(2);	
				}else{
					ATUReports.add("Account button is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			//Verify Account sharing  tutorial box
			if(alertpage.getaccountScreenTutorialBoxTxt()!=null){
				ATUReports.add("Mobilize Account screen  tutorial box is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Precondition.tutorialDisalogBoxCreateView(alertpage.getaccountScreenTutorialBoxTxt(),alertpage.getcreateViewTutorialNextBtn());

				//click on close icon
				if(alertpage.getcreateViewCloseIcon()!=null){
					alertpage.getcreateViewCloseIcon().click();
					ATUReports.add("Clicked on close icon in Account screen tutorial box ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				TimeUnit.SECONDS.sleep(4);

			}else{
				ATUReports.add("Mobilize Account screen  tutorial box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on view
			if(accountpage.getviewTab()!=null){
				MobileElement viewTab = accountpage.getviewTab();
				String tabTextOne = viewTab.getAttribute("name");
				System.out.println(tabTextOne+"--tabTextOne--");
				if(viewTab!=null){
					if (viewTab.isDisplayed()) {

						ATUReports.add(tabTextOne+" tab is Displayed and Clicked on view tab", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						viewTab.click();
					} else {
						ATUReports.add(tabTextOne+" tab is not Displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}else{
					ATUReports.add("Account button is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on preferences
			if(accountpage.getpreferences()!=null){
				MobileElement preferences = accountpage.getpreferences();
				String tabTextTwo = preferences.getAttribute("name");
				System.out.println(tabTextTwo+"--tabTextTwo--");
				if (preferences.isDisplayed()) {

					ATUReports.add(tabTextTwo+" tab is Displayed and Clicked on sharing tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					preferences.click();
				} else {
					ATUReports.add(tabTextTwo+" tab is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on Devices
			if(accountpage.getdevicesTab()!=null){
				MobileElement Devices = accountpage.getdevicesTab();
				String tabTextThree = Devices.getAttribute("name");
				System.out.println(tabTextThree+"---tabTextThree--");
				if (Devices.isDisplayed()) {

					ATUReports.add(tabTextThree+" tab is Displayed and Clicked on following tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Devices.click();
				} else {
					ATUReports.add(tabTextThree+" tab is not Displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Settings clicked on settings
			if(accountpage.getaccountSettingsIcon()!=null){
				MobileElement settings = accountpage.getaccountSettingsIcon();
				//String tabTextFour = Devices.getText();
				if (settings.isDisplayed()) {

					ATUReports.add("settings tab is Displayed and Clicked on settings tab", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					settings.click();
				} else {
					ATUReports.add("settings tab is not Displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				TimeUnit.SECONDS.sleep(1);
			}

			//Clicked on log out
			if(accountpage.getlogout()!=null){
				MobileElement logout = accountpage.getlogout();
				String tabTextFive = logout.getAttribute("name");
				System.out.println(tabTextFive+"---tabTextFive-");
				if (logout.isDisplayed()) {

					ATUReports.add(tabTextFive+" button Displayed and Clicked on logout  button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					logout.click();
					TimeUnit.SECONDS.sleep(2);
				} else {
					ATUReports.add(tabTextFive+"  button is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on ok
			if(accountpage.getlogoutOk()!=null){
				MobileElement logoutOk = accountpage.getlogoutOk();
				String tabTextSix = logoutOk.getAttribute("name");
				System.out.println(tabTextSix+"---tabTextSix--");
				if (logoutOk.isDisplayed()) {

					ATUReports.add(tabTextSix+" button is Displayed in pop up and Clicked on"+tabTextSix+" button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					logoutOk.click();
					TimeUnit.SECONDS.sleep(3);
				} else {
					ATUReports.add(tabTextSix+" button is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

		}
		catch (Exception e) {
			// TODO: handle exception
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
	}
}
