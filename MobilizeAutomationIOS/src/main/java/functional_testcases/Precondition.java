package functional_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
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
import io.appium.java_client.ios.IOSDriver;
import utility.Log;
import utility.ReadUserData;

public class Precondition {
	@SuppressWarnings("rawtypes")
	private static IOSDriver driver;
	private static LoginPage loginpage;
	private static HomePage homepage;
	private static ReadUserData readUserData;
	private static Alert_Page alertpage;

	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	public static void precondition() throws InterruptedException {
		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
		//frostpage = new FrostPage(driver);
		homepage = new HomePage(driver);
		//ewviewscreenpage = new NewViewScreenPage(driver);
		//js = (JavascriptExecutor) driver;  
		//read_frost_details = new Read_Frost_Details();
		//read_frost_details.start();
		loginpage = new LoginPage(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		alertpage=new Alert_Page(driver);
		Log.startTestCase("Precondtion test Case start");
		System.out.println("*********** Precondtion test Case start ********");

		try {

			// enter user in the user name text box
			MobileElement username = loginpage.getUserNametxtbx();
			if (username != null) {
				String usertx= username.getText();

				if (usertx.equals("Enter your username")) {
					CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
					ATUReports.add("Username text box text  is displayed same as expected-","Enter your username", usertx, LogAs.PASSED, screen1);

					username.click();
					username.sendKeys("xcube");
					//readUserData.sUserName
					Thread.sleep(4000);					
				}else{
					ATUReports.add("Verify the usertx text is not displayed ", "Enter your username", usertx, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}else{
				ATUReports.add("Verify the usertx text box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.quit();
			}

			//Click on Next button
			clickonNextButton();
			TimeUnit.SECONDS.sleep(5);	
			// enter password in the Password in the  text box
			MobileElement pwd = loginpage.getPasswordtxtbx();

			if (pwd!= null) {
				String pwdtxt= pwd.getAttribute("name");

				if (pwdtxt.equals("Enter your password")) {
					CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
					ATUReports.add("Passowrd text box text is displayed same as expected-","Enter your password", pwdtxt, LogAs.PASSED, screen1);
					pwd.click();					
					pwd.sendKeys(readUserData.sPassword);
					Thread.sleep(4000);

				}else{
					ATUReports.add("Verify the pwdtxt text is not displayed","Enter your password", pwdtxt, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}else{
				ATUReports.add("Verify the pwdtxt text box is not displayed","Enter your password", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.quit();
			}


			//Click on Next button
			MobileElement nextPawd=loginpage.getnextPswd();
			ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
			if(nextPawd!=null){
				ATUReports.add("Next button is displayed same as expected", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(9000);
				if(nextPawd.isDisplayed()){
					ATUReports.add("Next button is displayed and clicked on next button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					nextPawd.click();
					TimeUnit.SECONDS.sleep(10);	

				}else{
					ATUReports.add("Next button is not displayed ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				ATUReports.add("Next button is not displayed ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			//Close pop up Alert_Page alert page	
			if(alertpage.getcreateViewTutorialBox()!=null){
				Precondition.tutorialDisalogBoxCreateView(alertpage.getcreateViewTutorialBox(),alertpage.getcreateViewTutorialNextBtn());
				ATUReports.add("Mobilize create view tutorial screen  is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


				//Click on next button
				if(alertpage.getcreateViewTutorialNextBtn()!=null){
					String tutorialNextButton=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
					ATUReports.add("Clicked on "+tutorialNextButton+"button",tutorialNextButton, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getcreateViewTutorialNextBtn().click();
					TimeUnit.SECONDS.sleep(2);	
				}

				//Verify 2nd tutorial box
				Precondition.tutorialDisalogBoxCreateView(alertpage.getcreateViewTutorialBox(),alertpage.getcreateViewTutorialNextBtn());


				//Click on next button
				if(alertpage.getcreateViewTutorialNextBtn()!=null){
					String tutorialNextButton2=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
					ATUReports.add("Clicked on "+tutorialNextButton2+"button",tutorialNextButton2, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getcreateViewTutorialNextBtn().click();

					TimeUnit.SECONDS.sleep(2);	
		
				}
				//Verify 3rd tutorial box
				Precondition.tutorialDisalogBoxCreateView(alertpage.getcreateViewTutorialBox(),alertpage.getcreateViewTutorialNextBtn());


				//Click on ok button
				if(alertpage.getcreateViewTutorialNextBtn()!=null){
					String tutorialNextButton3=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
					ATUReports.add(tutorialNextButton3+"button is displayed ",tutorialNextButton3, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					//alertpage.getcreateViewTutorialNextBtn().click();
				}

				//click on close icon
				if(alertpage.getcreateViewTutorialNextBtn()!=null){
					ATUReports.add("Clicked on close icon in create view tutorial ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getcreateViewCloseIcon().click();
					TimeUnit.SECONDS.sleep(4);	

				}


			}else{
				ATUReports.add("Mobilize create view tutorial screen  is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			TimeUnit.SECONDS.sleep(10);	

			//Verify add view tutorial screen 1 in home page
			if(alertpage.getaddViewTutorialDialogBox()!=null){
				Precondition.tutorialDisalogBoxCreateView(alertpage.getaddViewTutorialDialogBox(),alertpage.getcreateViewTutorialNextBtn());

				ATUReports.add("Mobilize add view tutorila screen  is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


				/*//Click on next button in 1st screen
								if(alertpage.getcreateViewTutorialNextBtn()!=null){
								String tutorialNextButtonAddView=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
								alertpage.getcreateViewTutorialNextBtn().click();
								ATUReports.add("Clicked on "+tutorialNextButtonAddView+"button",tutorialNextButtonAddView+" in add view first screen tutorial box",LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);		

								}
								//Verify add view tutorial screen 2 in home page
								Precondition.tutorialDisalogBoxCreateView(alertpage.getaddViewTutorialDialogBox(),alertpage.getcreateViewTutorialNextBtn());


								//Click on next button in 2nd screen
								if(alertpage.getcreateViewTutorialNextBtn()!=null){
								String tutorialNextButtonAddView2=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
								alertpage.getcreateViewTutorialNextBtn().click();
								ATUReports.add("Clicked on "+tutorialNextButtonAddView2+"button",tutorialNextButtonAddView2+" in add view 2nd  screen tutorial box", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);		
								}

								//Verify add view tutorial screen 3 in home page
								Precondition.tutorialDisalogBoxCreateView(alertpage.getaddViewThirdScreenTutorilaBox(),alertpage.getcreateViewTutorialNextBtn());

								//Click on next button in 3rd screen
								if(alertpage.getcreateViewTutorialNextBtn()!=null){
								String tutorialNextButtonAddView3=alertpage.getcreateViewTutorialNextBtn().getAttribute("name");
								alertpage.getcreateViewTutorialNextBtn().click();
								ATUReports.add("Clicked on "+tutorialNextButtonAddView3+"button",tutorialNextButtonAddView3+" in add view 3 rd screen tutorial box", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);		
								}*/

				//click on close icon
				if(alertpage.getcreateViewCloseIcon()!=null){
					ATUReports.add("Clicked on close icon in Add view 3rd screen tutorial box", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getcreateViewCloseIcon().click();
					TimeUnit.SECONDS.sleep(10);	

				}
			}else{
				ATUReports.add("Mobilize add view tutorial screen  is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}


			//Verify notification tutorial box
			if(alertpage.getnotificationTutorialBoxTxt()!=null){
				Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),alertpage.getcreateViewTutorialNextBtn());
				ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


				//click on close icon
				if(alertpage.getcreateViewCloseIcon()!=null){
					ATUReports.add("Clicked on close icon in Notification tutorial box",LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getcreateViewCloseIcon().click();

				}		

			}else{
				ATUReports.add("Mobilize Notification  tutorial screen  is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method used to click on next button
	public static void clickonNextButton() throws InterruptedException {
		if (loginpage.getNextButton()!=null) {
			MobileElement next = loginpage.getNextButton();
			if (next.isDisplayed()) {
				next.click();
			} else {
				driver.quit();
			}
		}
	}


	public static <WebElmenet> void tutorialDisalogBoxCreateView(WebElement TutorialBox,WebElmenet NextBtn) throws InterruptedException{

		if(TutorialBox!=null){
			if(TutorialBox.isDisplayed()){
				TimeUnit.SECONDS.sleep(4);	
				String tutorialText=TutorialBox.getAttribute("name");
				String tutorialNextButton=((WebElement) NextBtn).getAttribute("name");
				ATUReports.add("Mobilize tutorial dialog box  "+tutorialText+ "is displayed in home page with  "+tutorialNextButton+" button",tutorialText,tutorialNextButton, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

		}else{
			ATUReports.add("Mobilize tutorial dialog box is in home page is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	@SuppressWarnings("unused")
	public static  <WebElmenet> void tutorialDisalogBoxWithCloseIcon(WebElement TutorialBox,WebElmenet NextBtn) throws InterruptedException{

		if(TutorialBox!=null){
			if(TutorialBox!=null){
				if(TutorialBox.isDisplayed()){
					String tutorialText=TutorialBox.getAttribute("name");
					String tutorialNextButton=((WebElement) NextBtn).getAttribute("name");
					ATUReports.add("Mobilize tutorial dialog box  "+tutorialText+ "is displayed in home page with  "+tutorialNextButton+" button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(2000);
					alertpage.getcreateViewCloseIcon().click();
					Thread.sleep(2000);
					ATUReports.add("Clicked on close icon  ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				ATUReports.add("Mobilize notification tutorial dialog box in home page is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

	}

}
