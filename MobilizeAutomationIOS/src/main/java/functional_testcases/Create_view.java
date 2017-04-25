

package functional_testcases;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utility.ReadUserData;
import utility.ReadViewName;

public class Create_view {
	private ReadUserData readUserData ;
	@SuppressWarnings("rawtypes")
	private IOSDriver driver ;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage ;
	private ReadViewName readviewname ;
	private LoginPage loginpage;
	private static Alert_Page alertpage;
	//private ReadViewName readViewName;
	//private SignUpPage signUpPage;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void createView() throws MalformedURLException, InterruptedException{


		try {


			driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			loginpage = new LoginPage(driver);
			readviewname=new ReadViewName();
			readviewname.start();
			readUserData =new ReadUserData();
			readUserData.start();
			alertpage=new Alert_Page(driver);

			System.out.println("***************************Staring- Create_view **************************");

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
				TimeUnit.SECONDS.sleep(30);
			}

			TimeUnit.SECONDS.sleep(6);				
			//Verify the Home button is displayed in the Home screen
			if(homepage.gethomebutton()!=null){
				if (homepage.gethomebutton().isDisplayed()) {
					ATUReports.add("Home button is displayed in the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Home button is not displayed in the screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			//Verify the Add button is displayed in the Home screen
			if(homepage.getaddbtn()!=null){
				if (homepage.getaddbtn().isDisplayed()) {
					ATUReports.add("Add button is displayed in the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(3000);
				} else {
					ATUReports.add("Add button is not displayed in the screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			}

			//Click on the Add view button
			if(homepage.getaddbtn()!=null){
				homepage.getaddbtn().click();
				Thread.sleep(3000);
				ATUReports.add("Clicked on Add button in the Home screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			//Verify the View screen is displayed
			String back = newviewscreenpage.getviewscreenCancelBtn().getText();
			System.out.println(back);
			if(back.isEmpty()){
				ATUReports.add("Cancel button text is not available in the screen ", "Cancel", back,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (back.equals("Cancel")) {
					ATUReports.add("Cancel button is displayed in the screen ", "Cancel", back,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Cancel button is not displayed in the screen ", back,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}


			//Verify the View screen is displayed
			String view = newviewscreenpage.getviewNameHeading().getText();
			System.out.println(view);
			if(view.isEmpty()){
				ATUReports.add("View Name text is not available in the screen ", "VIEW NAME", view,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (view.equals("VIEW NAME")) {
					ATUReports.add("View Name text is displayed in the screen ", "VIEW NAME", view,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("View Name text is not displayed in the screen ", view,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			//Verify the View text caption  is displayed
			String viewtxtblw = newviewscreenpage.getview_txt_blw().getText();
			if(viewtxtblw.isEmpty()){
				ATUReports.add("Verify the View Name text below the title  in the screen ", "This will be used for sorting and will be listed on the home screen.", view,LogAs.WARNING, null);

			}else{
				if (viewtxtblw.equals("This will be used for sorting and will be listed on the home screen.")) {
					ATUReports.add("Verify the View Name text below the title  in the screen ", "This will be used for sorting and will be listed on the home screen.", view,LogAs.PASSED,null);
				}else{
					ATUReports.add("Verify the View Name text below the title  in the screen ", view,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			//Verify the View text field  is displayed---
			String viewtxtfld = newviewscreenpage.getview_txtfld().getText();
			if(viewtxtfld.isEmpty()){
				ATUReports.add("Verify the View textfield placceholder in the screen ", "View Name", view,LogAs.WARNING, null);

			}else{
				if (viewtxtfld.equals("View Name")) {
					ATUReports.add("Verify the View textfield placceholder in the screen ", "View Name", view,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Verify the View textfield placceholder in the screen ", view,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			try {
				String viewName = readviewname.viewName;
				System.out.println("ViewName********"+viewName);

				//Enter The verified text in the viewname text field---
				newviewscreenpage.getview_txtfld().sendKeys(viewName);
				String enteredviewName = newviewscreenpage.getview_txtfld().getText();
				System.out.println(enteredviewName);
				if(enteredviewName.isEmpty()){
					ATUReports.add("Verify the name entered in the View textfield in the screen ", enteredviewName, viewName,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (enteredviewName.equals(viewName)) {
						ATUReports.add("Verify the name entered in the View textfield in the screen ", enteredviewName, viewName,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the name entered in the View textfield in the screen ", viewName,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(3000);




				//Verify notification tutorial box
				if(alertpage.getnotificationTutorialBoxTxt()!=null){
					ATUReports.add("Mobilize Notification  tutorial screen  is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Precondition.tutorialDisalogBoxCreateView(alertpage.getnotificationTutorialBoxTxt(),alertpage.getcreateViewTutorialNextBtn());


					//click on close icon
					if(alertpage.getcreateViewCloseIcon()!=null){
						alertpage.getcreateViewCloseIcon().click();
						ATUReports.add("Clicked on close icon in create view tutorial ",LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}

				//Verify the Add button in the top right is enabled.

				if (newviewscreenpage.getviewNextBtn().isDisplayed()) {
					ATUReports.add("Tap on add button",LogAs.PASSED,null);
					newviewscreenpage.getviewNextBtn().click();
					Thread.sleep(8000);


					WebElement tableview=(WebElement) driver.findElement(By.className("UIATableView"));

					if(tableview!=null){
						List<WebElement> tableCell=tableview.findElements(By.className("UIATableCell"));

						Thread.sleep(2000);
						if(tableCell!=null){	
							Thread.sleep(1000);
							//String staticText=tableCell.get(i).findElement(By.xpath("//UIAStaticText[2]")).getText();
							ATUReports.add("View screens list is displayed in the View  screen ", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	

						}else{
							ATUReports.add("View screens list is not displayed in the View  screen ", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}				
					}//null


				} else {
					ATUReports.add("Add next button is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				ATUReports.add("View created succesfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}catch(NullPointerException e){
				e.printStackTrace();
			}


		}catch(InterruptedException e){
			driver.resetApp();
			TimeUnit.SECONDS.sleep(20);
			e.printStackTrace();
		}
		catch(NoClassDefFoundError e){
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
		System.out.println("***************************ENDING- Create_view **************************");

	}

	public void clickonNextButton() throws InterruptedException
	{
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		}else{
			driver.quit();
		}
	}
}








/*//Verify frost
if(staticText.contains("FROST")){
	Thread.sleep(1000);
	ATUReports.add("FROST is displayed ", LogAs.PASSED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	//tableCell.get(i).findElement(By.className("UIAStaticText")).click();
	//break;
}else{
//Verify weather
if(staticText.contains("WEATHER")){
	Thread.sleep(1000);
	ATUReports.add("WEATHER is displayed clicked on WEATHER", LogAs.PASSED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	//tableCell.get(i).findElement(By.className("UIAStaticText")).click();
	//break;
}else{

//Verify crop
if(staticText.contains("CROP")){
	ATUReports.add("CROP is displayed clicked on CROP", LogAs.PASSED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	//tableCell.get(i).findElement(By.className("UIAStaticText")).click();
	//break;
}else{
	//Verify to scroll up to edit button
	WebElement element = newviewscreenpage.geteditViewBtn();
	Actions actions = new Actions(driver);
	actions.moveToElement(element);
	// actions.click();
	actions.perform();


	//Verify irrigation

	if(staticText.contains("IRRIGATION")){
		ATUReports.add("IRRIGATION is displayed clicked on irrigation", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		tableCell.get(i).findElement(By.className("UIAStaticText")).click();
		break;
}else{
	ATUReports.add("View screens list is not displayed in the View  screen ", LogAs.FAILED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}


}
}*/
//}