package functional_testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.ReadUserData;
import utility.Read_Change_Password;
import Pages.Account_Page;
import Pages.Alert_Page;
import Pages.CropPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Settings_page;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Verify_Change_Password {
	private IOSDriver driver;
	private HomePage homepage;
	private Account_Page accountpage;
	private Settings_page settingspage;
	private Read_Change_Password readchangepassword;
	public String currentpassword, newpassword, confirmpassword, wrgcurpwd, wrngnewpwd, wrocnfpwd;
	private LoginPage loginpage;
	private ReadUserData readUserData ;
	private Alert_Page alertpage;
	private CropPage croppage;
	// To verify the Change password functionality - we need to change/update
	// the user name and in the excel sheet under change password tab in the
	// second and third rows respectively
	// Assuming the password set is " 4ct65zps "

	@Test
	public void verify_change_password_scenario() throws InterruptedException {


		try {

			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			accountpage = new Account_Page(driver);
			settingspage = new Settings_page(driver);
			readchangepassword = new Read_Change_Password();
			loginpage = new LoginPage(driver);
			// Get the values from the change password file
			readchangepassword.start();
			readUserData = new ReadUserData();
			readUserData.start();
			alertpage =new Alert_Page(driver);
			croppage =new CropPage(driver);

			System.out.println("*************************** Verify_Change_Password **************************");
			    TimeUnit.SECONDS.sleep(10);
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
								TimeUnit.SECONDS.sleep(25);
								ATUReports.add("After The Launch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} catch (Exception e) {
							ATUReports.add("In The Catch", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							// reset the application -
							// close the application
							//driver.quit();
							// Launch App
							driver.resetApp();
							TimeUnit.SECONDS.sleep(25);
						}
						TimeUnit.SECONDS.sleep(6);

		

			//Verify change password in accounts page
			if(homepage.getaccountbtn()!=null){
				if(homepage.getaccountbtn().isDisplayed()){
					homepage.getaccountbtn().click();
					ATUReports.add("Clicked on account button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(3000);	
				}else{
					ATUReports.add("Account button is not displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(3000);	
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


			// Click on Settings button.
			if(accountpage.getaccountSettingsIcon()!=null){
				if (accountpage.getaccountSettingsIcon().isDisplayed()) {

					// click on settings button
					accountpage.getaccountSettingsIcon().click();

					ATUReports.add("Settings icon is displayed in account ,Settings page drop downlist is dispalyed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));Thread.sleep(1000);

							// Click on Change password
							MobileElement changePassword = accountpage.getchangePwdFiled();
							if (changePassword.isDisplayed()) {
								changePassword.click();
								Thread.sleep(5000);
								ATUReports.add("Navigated to Change password screen", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Change password screen is not Displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

				}

				currentpassword = readchangepassword.currentpassword;
				confirmpassword = readchangepassword.confimpassword;
				newpassword = readchangepassword.newpassword;
				wrgcurpwd = readchangepassword.wrongcurpassword;
				wrngnewpwd = readchangepassword.wrongnewpassword;
				wrocnfpwd = readchangepassword.wrongconfirmpassword;

				System.out.println("Current Password from method" + currentpassword);
				System.out.println("New Password from method" + newpassword);
				System.out.println("newpassword from method" + newpassword);

				System.out.println("wrgcurpwd" + wrgcurpwd);
				System.out.println("wrocnfpwd" + wrngnewpwd);
				System.out.println("wrocnfpwd" + wrocnfpwd);





				// Calling the generic method - of change password for Wrong
				// password scenario
				//changepassword(wrgcurpwd, wrngnewpwd, wrocnfpwd);
				// Enter Current password
				if(accountpage.getcurrent_passwordplaceholder()!=null){
					accountpage.getcurrent_passwordplaceholder().sendKeys(wrgcurpwd);
					ATUReports.add("Entered the current invalid password", wrgcurpwd, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				//Clicked on next button
				if(accountpage.getchangepwdcurrenPwdNextBtn()!=null){
					accountpage.getchangepwdcurrenPwdNextBtn().click();
					ATUReports.add("Clicked on next button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(4000);
				}

				/// Verify the alert message for Incorrect password scenario.

				WebElement alert=accountpage.getinvaliPasswordAlertd();
				if(alert!=null){
					String alertText=alert.getText();
					Thread.sleep(2000);
					ATUReports.add(alertText+" Alert is present in the screen when entered invalid password", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getokbutton().click();
					Thread.sleep(2000);
					ATUReports.add("Clicked on Ok button in "+alertText+" screen ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
					//croppage.getbackbtn().click();			
					accountpage.getchangePwdClearIcon().click();
					Thread.sleep(2000);

					//Verify change password text box
					accountpage.getcurrent_passwordplaceholder().sendKeys(currentpassword);
					ATUReports.add("Entered the current valid password", currentpassword, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					accountpage.getchangepwdcurrenPwdNextBtn().click();
					ATUReports.add("Clicked on next button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//verify new password
					accountpage.getcurrent_passwordplaceholder().sendKeys(currentpassword);
					ATUReports.add("Entered the new valid password", currentpassword, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);

					//Verify conform password
					accountpage.getConfirm_Password().sendKeys(confirmpassword);
					ATUReports.add("Entered the conform  valid password in text box ", currentpassword, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(4000);
					
					if(accountpage.getchangepwdcurrenPwdNextBtn()!=null){

						ATUReports.add("Next button is displayed in change password screen ", currentpassword, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
						if(croppage.getbackButtonTop()!=null){
							if(croppage.getbackButtonTop().isEnabled()){
							ATUReports.add("Back button is displayed in change password screen clicked on back button", currentpassword, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							TouchAction action2h= new TouchAction(driver);
							action2h.longPress(croppage.getbackButtonTop()).release().perform();
							TimeUnit.SECONDS.sleep(8);
							
							TouchAction action2hf= new TouchAction(driver);
							action2hf.longPress(croppage.getbackButtonTop()).release().perform();
							TimeUnit.SECONDS.sleep(8);
								
							}else{
								ATUReports.add("Back button is not enabled in the current screen`", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							
							}else{
								if(croppage.getbackbtn()!=null){
									if(croppage.getbackbtn().isEnabled()){
										Thread.sleep(2000);
									croppage.getbackbtn().click();
									Thread.sleep(1000);
									croppage.getbackbtn().click();
									Thread.sleep(2000);
									ATUReports.add("Back button is enabled in the current screen and clicked on the back button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}else{
										ATUReports.add("Back button is not enabled in the current screen", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
							}
							
						}

				}
		
				//Click on Settings button
				if(accountpage.getaccountSettingsIcon()!=null){
					//accountpage.getaccountSettingsIcon().click();
					Thread.sleep(3000);

					ATUReports.add("settings icon is displayed and cick on settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			


			} else {
				ATUReports.add("Settings is not present in the  screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			System.out.println("*************************** Verify_Change_Password **************************");


		} catch (Exception e) {
			System.out.println("*************************** END - Verify_Change_Password **************************");
				driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
	}

	public void changepassword(String cpassword, String npassword, String confirmpwd) {

		try {
			

			System.out.println("in the Method current :" + cpassword);
			System.out.println("in the Method  new :" + npassword);
			System.out.println("in the Method  confirm :" + confirmpwd);

			// Enter Current password
			accountpage.getcurrent_passwordplaceholder().sendKeys(cpassword);
			ATUReports.add("Entered the current password",cpassword, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Enter new password
			accountpage.getNew_Password().sendKeys(npassword);
			ATUReports.add("Entered the New password", npassword, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Enter the confirm password
			accountpage.getConfirm_Password().sendKeys(confirmpwd);
			ATUReports.add("Entered the New password", confirmpwd, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on Save button.
			accountpage.getsave().click();
			ATUReports.add("Clicked on save button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next != null) {
			if (next.isDisplayed()) {
				next.click();
			} else {
				driver.quit();
			}
		}

	}
}




























/*//Verify Tap on Settings
			MobileElement settings = accountpage.getsettings();
			if (settings.isDisplayed()) {
				ATUReports.add("Settings pop up is dispalyed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
				Thread.sleep(9000);
				ATUReports.add("Clicked on Settings Tab", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Tab on Change
				// passwordsettingspage.getChange_Password().click();
				MobileElement changePassword = settingspage.getChange_Password();
				if (changePassword.isDisplayed()) {
					changePassword.click();
					Thread.sleep(5000);
					ATUReports.add("Navigated to Change password screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Change password screen is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				currentpassword = readchangepassword.currentpassword;
				confirmpassword = readchangepassword.confimpassword;
				newpassword = readchangepassword.newpassword;
				wrgcurpwd = readchangepassword.wrongcurpassword;
				wrngnewpwd = readchangepassword.wrongnewpassword;
				wrocnfpwd = readchangepassword.wrongconfirmpassword;

				System.out.println("Current Password from method" + currentpassword);
				System.out.println("New Password from method" + newpassword);
				System.out.println("newpassword from method" + newpassword);

				System.out.println("wrgcurpwd" + wrgcurpwd);
				System.out.println("wrocnfpwd" + wrngnewpwd);
				System.out.println("wrocnfpwd" + wrocnfpwd);



				// Calling the generic method - of change password for Wrong
				// password scenario
				//changepassword(wrgcurpwd, wrngnewpwd, wrocnfpwd);
				// Enter Current password
				accountpage.getcurrent_passwordplaceholder().sendKeys(wrgcurpwd);
				ATUReports.add("Entered the current password", wrgcurpwd, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


	             //Clicked on next button
				settingspage.getChangepwdNxtBtn().click();
				ATUReports.add("Clicked on next button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				Thread.sleep(5000);

			   /// Verify the alert message for Incorrect password scenario.

				WebElement alert=driver.findElement(By.id("android:id/message"));
				String alertText=alert.getText();
				Thread.sleep(2000);
				ATUReports.add("Alert is present in the screen when entered invalid password", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.findElement(By.id("android:id/button1")).click();

				accountpage.getCancel().click();
				Thread.sleep(1000);


				 //Click on Settings button
				accountPage.getsettings().click();
				Thread.sleep(3000);
				System.out.println("Clicked on settings");
				ATUReports.add("Click Settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


	           //Click on log out button
				accountPage.getsettingsLogoutBtn().click();
				System.out.println("Clicked on logout");
				Thread.sleep(4000);
				ATUReports.add("Click Logout button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


	            //Click on Ok Button
				accountPage.getlogoutAlertOk().click();
				Thread.sleep(2000);
				ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				//Calling the generic method - of change password for Correct
				//password scenario
			 // changepassword(currentpassword,newpassword,confirmpassword);








			} else {
				ATUReports.add("Settings is not present in the  screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}		System.out.println("Clicked on ok");
 */
