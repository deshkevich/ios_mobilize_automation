package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.xml.internal.bind.v2.runtime.Name;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class SignUpPage {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();


	public SignUpPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;
	By signUpText=By.name("Login_SighUp");
	By NameFirstTextFieldTitle=By.name("ENTER FIRST NAME");
	By nextbtn=By.name("NextButton:Enter your Email");
	By emailtxtbx= By.name("Enter your Email");
	//email_firstname_lastname_username_setpassword_confirmpassword_txtbox  replace this 
	By firstnameTextBox=By.name("Enter your first name");

	//insted of using unique next button
	By firstnmeNextbtn=By.name("NextButton:Enter your first name");
	By firstTopBack=By.name("Back:-10");
	By firstTopSkip=By.name("Next:1");

	//------neeed to captured here -------**********????
	By lastnmeText=By.name("ENTER LAST NAME");
	By lastNameTxtBx=By.name("Enter your last name");
	By lastnameBextBtn=By.name("NextButton:Enter your last name");
	By useranmextx=By.name("ENTER USERNAME");
	By useranmeTxtBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[4]");//name("Enter your username");
	By userNameNextBtn=By.xpath("//UIAButton[11]");//name("NextButton:Enter your username");
	By pwdTxt=By.name("ENTER PASSWORD");
	By pwdBacktBtn=By.name("Back:-1");
	By pwdTextBox=By.name("Enter your password");//xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");//name("Enter your password");
	By pwdNextBtn=By.name("NextButton:Enter your password");
	By conformPwdTxt=By.name("CONFIRM PASSWORD");
	By conformPwdTextBox=By.name("Confirm your password");
	By conformPwdNextBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[19]");//name("NextButton:Confirm your password");
	By addPhotoText=By.name("ADD PHOTO");
	By takePhotoBtn=By.name("Take Photo");
	By chooseBtn=By.name("Choose from Library");
	By skipBtninaddPhoto=By.name("skip");
	By backBtnAddPhoto=By.name("back");
	By clearLogo=By.name("Clear text");
	By existingEmailAlert=By.name("Email already exist.");
	By alertOk=By.name("OK");
	By signupbtn = By.name("Login_SighUp");
	By username = By.name("Enter your username");
	By caption = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");
	By pwdHeadingText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]");
	By pwdAllNextBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[13]");//name("NextButton:Enter your password");
	// NextButton:Enter your password
	By pwdHeadingCaption=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]");
	
	public  MobileElement getaddPhotoText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(addPhotoText)));

		}catch(NoSuchElementException e){
			ATUReports.add("addPhotoText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("addPhotoText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getpwdHeadingCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(pwdHeadingCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("pwdHeadingCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("pwdHeadingCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getpwdAllNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(pwdAllNextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("pwdAllNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("pwdAllNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getpwdHeadingText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(pwdHeadingText)));

		}catch(NoSuchElementException e){
			ATUReports.add("pwdHeadingText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("pwdHeadingText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getuserNameNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(userNameNextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("userNameNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("userNameNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getlastNameTxtBx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(lastNameTxtBx)));

		}catch(NoSuchElementException e){
			ATUReports.add("lastNameTxtBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lastNameTxtBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
		
	public  MobileElement getuseranmeTxtBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(useranmeTxtBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("useranmeTxtBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("useranmeTxtBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public  MobileElement getconformPwdNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(conformPwdNextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("conformPwdNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("conformPwdNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getconformPwdTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(conformPwdTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("conformPwdTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("conformPwdTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getconformPwdTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(conformPwdTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("conformPwdTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("conformPwdTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	//By caption = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");

	/*By email_firstname_lastname_username_setpassword_confirmpassword_txtbox = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");	
	By passwordTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
	By confrmpwdTxtbx=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[2]");
	By NameTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[3]");
	//By setpassword_confirmpassword_txtbox = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
	By nextbtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]");Login_Next
	//By closebtn = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	//By cleartxtbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]/UIAButton[1]");
	By backbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");

	By skipbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	By firstname_lastname_username_pawd_logo= By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
	By firstname_lastname_username_pwd_txt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]");//By.name("Enter your first name");
	//By NameTextFieldTitle=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]");ENTER FIRST NAME
	By caption = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");
	By userNameTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[4]");
	By userNmNextbtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[11]");
	By passwdNextButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[13]");
    By conformpwdNext=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[15]");
    By addLogo=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
    By addText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]");
    By addcaption=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]");
    By takePhoto=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]");
    By takeCancel=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");
    By chooseButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");
    By chooseCancel=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
    By nextButtonTop=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]");
    By backButtonTop=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	 */

	public  MobileElement getcaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(caption)));

		}catch(NoSuchElementException e){
			ATUReports.add("Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public  MobileElement getpwdTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pwdTextBox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("pwdTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("pwdTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getusername() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(username)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Username element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Username is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getpwdBacktBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(pwdBacktBtn)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("pwdBacktBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("pwdBacktBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getalertOk() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(alertOk)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("alertOk element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("alertOk is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getexistingEmailAlert() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(existingEmailAlert)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("existingEmailAlert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("existingEmailAlert is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getclearLogo() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(clearLogo)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("clearLogo element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("clearLogo is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getsignUpText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(signUpText)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("signUpText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("signUpText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}



	public  MobileElement getlastnmeTextTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(lastnmeText)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("lastnmeText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lastnmeText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}



	public  MobileElement getfirstTopSkip() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstTopSkip)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("firstTopSkip element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("firstTopSkip is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}





	public  MobileElement getfirstTopBack() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstTopBack)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("firstTopBack element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("firstTopBack is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}




	public  MobileElement getfirstnmeNextbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstnmeNextbtn)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("firstnmeNextbtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("firstnmeNextbtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getfirstnameTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstnameTextBox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("firstnameTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("firstnameTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}




	/* public  MobileElement getbackButtonTop() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(backButtonTop)));
  			//System.out.println("Element "+element.getId());

  		}catch(NoSuchElementException e){
  			ATUReports.add("Back Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("Back Button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
	 */


	/*public  MobileElement getnextButtonTop() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(nextButtonTop)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Next Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Next Button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	/*  public  MobileElement getchooseCancel() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(chooseCancel)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Choose Cancel Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Choose Cancel Button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


    public  MobileElement getchooseButton() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(chooseButton)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Choose  Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Choose  Button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

    public  MobileElement gettakeCancel() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(takeCancel)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Take phtoto  cancel element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Take phtoto cancel is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}



    public  MobileElement gettakePhoto() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(takePhoto)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Take phtoto element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Take phtoto is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

    public  MobileElement getaddcaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(addcaption)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Add caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Add caption is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

    public  MobileElement getaddText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(addText)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Add Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Add Text is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


    public  MobileElement getaddLogo() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(addLogo)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Add Logo element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Add Logo is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

    public  MobileElement getconformpwdNext() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(conformpwdNext)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Conform Password Next button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Conform Password Next button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getpasswdNextButton() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(passwdNextButton)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Password Next button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Password Next button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getuserNmNextbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(userNmNextbtn)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("User Name Next button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("User Name Next button is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getconfrmpwdTxtbx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(confrmpwdTxtbx)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Conform password Text box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Conform password Text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/


	public  MobileElement getnextbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(nextbtn)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Next button Telement is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Next button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	/*public  MobileElement getuserNameTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(userNameTextBox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("User Name TextBox Telement is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("User Name TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/






	public  MobileElement getNameFirstTextFieldTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(NameFirstTextFieldTitle)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("NameFirstTextFieldTitle Name Text Field Title Telement is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NameFirstTextFieldTitle Name Text Field Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	/*public  MobileElement getpasswordTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(passwordTextBox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Password TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Password TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getNameTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(NameTextBox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Name TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Name TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement gettxtbx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(email_firstname_lastname_username_setpassword_confirmpassword_txtbox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/


	public  MobileElement getemailtxtbx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(emailtxtbx)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("Email id TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Email id TextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	/*public  MobileElement getpedtxtbx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(setpassword_confirmpassword_txtbox)));
			//System.out.println("Element "+element.getId());

		}catch(NoSuchElementException e){
			ATUReports.add("ConfirmPasswordTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ConfirmPasswordTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	public  MobileElement getsignupbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(signupbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SignUpButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SignUpButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}

/*

	public  MobileElement getclosebtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(closebtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("CloseButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CloseButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcleartxtbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(cleartxtbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("ClearTextButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ClearTextButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbackbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(backbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getskipbtnn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(skipbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SkipButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SkipButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getfirstname_lastname_username_pawd_logo() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstname_lastname_username_pawd_logo)));

		}catch(NoSuchElementException e){
			ATUReports.add("Logo is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Logo is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getfirstname_lastname_username_pwd_txt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(firstname_lastname_username_pwd_txt)));

		}catch(NoSuchElementException e){
			ATUReports.add("PasswordText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PasswordText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(caption)));

		}catch(NoSuchElementException e){
			ATUReports.add("Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
 */