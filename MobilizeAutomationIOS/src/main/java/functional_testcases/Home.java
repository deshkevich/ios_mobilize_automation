package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import Pages.Account_Page;
import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import Pages.SignUpPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;

public class Home {
	private IOSDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newview;
	private Account_Page accountoage;
	private ReadUserData readUserData;
	private static Alert_Page alertpage;

	@Test
	public void verify_Homescreen_UI() throws InterruptedException {

		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			new SignUpPage(driver);
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			newview = new NewViewScreenPage(driver);
			accountoage = new Account_Page(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			alertpage = new Alert_Page(driver);
			System.out.println("************************ Home Screen test ***********************");

			ATUReports.add("In The Catch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
				// driver.quit();
				// Launch App
				driver.resetApp();
				TimeUnit.SECONDS.sleep(30);
			}
			TimeUnit.SECONDS.sleep(6);

			// Get the Search field place holder text
			if (homepage.getsearchtxtfield() != null) {
				MobileElement searchplaceholder = homepage.getsearchtxtfield();
				if (searchplaceholder.isDisplayed()) {

					// String searchplaceholdertxt = searchplaceholder;
					if (searchplaceholder.isDisplayed()) {
						ATUReports.add("Verify the search placeholder text is displayed in the screen", "Search",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Verify the search placeholder text is not  displayed in the screen",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Get the Home button and verify is enabled
			if (homepage.gethomebutton().isDisplayed() && homepage.gethomebutton().isEnabled()) {
				ATUReports.add("Home button is displayed and enabled in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Home button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Get the Account button and verify is enabled
			if (homepage.getaccountbtn().isDisplayed() && homepage.getaccountbtn().isEnabled()) {
				ATUReports.add("Account button is displayed and enabled in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Account button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Tap on Account button.
			MobileElement account = homepage.getaccountbtn();
			if (account.isDisplayed()) {
				homepage.getaccountbtn().click();
				TimeUnit.SECONDS.sleep(3);

				// Verify Account sharing tutorial box
				if (alertpage.getaccountScreenTutorialBoxTxt() != null) {
					ATUReports.add("Mobilize Account screen  tutorial box is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Precondition.tutorialDisalogBoxCreateView(alertpage.getaccountScreenTutorialBoxTxt(),
							alertpage.getcreateViewTutorialNextBtn());

					// click on close icon
					if (alertpage.getcreateViewCloseIcon() != null) {
						alertpage.getcreateViewCloseIcon().click();
						ATUReports.add("Clicked on close icon in Account screen tutorial box ", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					Thread.sleep(4000);

				} else {
					ATUReports.add("Mobilize Account screen  tutorial box is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				if (accountoage.gettitle() != null) {
					// Verify the account text in the Account screen
					String accounttxt = accountoage.gettitle().getText();
					if (accounttxt.trim().isEmpty()) {
						ATUReports.add("Header text is missing in the screen ", "Account", accounttxt, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (accounttxt.trim().equals("Account")) {
							ATUReports.add("Navigated to Account screen", "Account", accounttxt, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Header text is missing in the screen ", accounttxt, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
				}

			}

			// Tap on Home button.
			MobileElement home = homepage.gethomebutton();
			if (home.isDisplayed()) {
				home.click();
			}

			// Get the Add view button and verify is enabled
			if (homepage.getaddbtn().isDisplayed() && homepage.getaddbtn().isEnabled()) {
				ATUReports.add("Add view button is displayed and enabled in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Add view button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Add view button
			MobileElement addviewbtn = homepage.getaddbtn();
			if (addviewbtn.isDisplayed()) {
				addviewbtn.click();

			}

			// Verify the ViewName text in the view screen
			MobileElement newvieww = newview.getviewname();
			if (newvieww.isDisplayed()) {
				String viewname = newvieww.getText();
				System.out.println(viewname);
				if (viewname.isEmpty()) {
					ATUReports.add("VIEW NAME is missing in the screen ", "VIEW NAME", viewname, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (viewname.equals("VIEW NAME")) {
						ATUReports.add("Navigated to VIEW NAME screen", "VIEW NAME", viewname, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("VIEW NAME is missing in the screen ", viewname, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			MobileElement caption = newview.getview_txt_blw();
			if (caption.isDisplayed()) {
				String captiontxt = caption.getText();
				System.out.println(captiontxt);
				if (captiontxt.isEmpty()) {
					ATUReports.add("VIEW NAME caption text is missing in the screen ",
							"This will be used for sorting and will be listed on the home screen.", captiontxt,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (captiontxt.equals("This will be used for sorting and will be listed on the home screen.")) {
						ATUReports.add(" VIEW NAME caption text is equals with the expected",
								"This will be used for sorting and will be listed on the home screen.", captiontxt,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("VIEW NAME caption text is not equals with the expected ", captiontxt,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
			}

			// Tap on back button in the add view screen.
			newview.getbacktxt().click();

			// home button

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			// driver.resetApp();
			// TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		} catch (InterruptedException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		}
	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}
}
