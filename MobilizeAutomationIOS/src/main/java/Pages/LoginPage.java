package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class LoginPage {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public LoginPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By userNametxtbx = By.name("Enter your username");//Login_TextField-value-Enter your username
	By passwordtxtbx = By.name("Enter your password");//Login_TextField-Enter your password
	By logoHeading= By.name("MOBILIZE");// UIAStaticText[4]
	By logo_caption = By.name("By Davis Instruments");
	By signUptext = By.name("Login_SighUp");
	By logintext = By.name("Login_Login");
	By nextButton = By.name("NextButton:Enter your username");
	By nextPswd = By.name("NextButton:Enter your password");
	By passwordtxtb = By.cssSelector("//sfdsu");
	By cleartxtbrnicon = By.name("Clear text");
	By loginForgotIcon = By.name("Login_Forgot_Button");
	By pwdbackButton=By.name("Back:1");
	By forgotpwddbackButton=By.name("Back:-1");
	By mobilizeLogoImage=By.name("AppLogo");//no method
	By enterPasswordTitleText=By.name("ENTER PASSWORD");//no method     
	By helpbutton = By.name("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");



	public MobileElement getenterPasswordTitleText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(enterPasswordTitleText)));

		} catch (NoSuchElementException e) {
			ATUReports.add("enterPasswordTitleText iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("enterPasswordTitleText is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getmobilizeLogoImage() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(mobilizeLogoImage)));

		} catch (NoSuchElementException e) {
			ATUReports.add("mobilizeLogoImage iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("mobilizeLogoImage is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public MobileElement getforgotpwddbackButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(forgotpwddbackButton)));

		} catch (NoSuchElementException e) {
			ATUReports.add("forgotpwddbackButton iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("forgotpwddbackButton is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public MobileElement getpwdbackButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(pwdbackButton)));

		} catch (NoSuchElementException e) {
			ATUReports.add("backButton iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("backButton is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getloginForgotIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(loginForgotIcon)));

		} catch (NoSuchElementException e) {
			ATUReports.add("loginForgotIcon iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("loginForgotIcon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getnextPswd() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(nextPswd)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Next button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Next button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gethelpbutton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(helpbutton)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Help button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Help button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcleartxtbrnicon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(cleartxtbrnicon)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Clear button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Clear button iCon is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getUserNametxtbx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(userNametxtbx)));

		} catch (NoSuchElementException e) {
			ATUReports.add("UserNameTextBox element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("UserNameTextBox element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNextButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(nextButton)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Next Button element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Next Button element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getPasswordtxtbx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(passwordtxtbx)));

		} catch (NoSuchElementException e) {
			ATUReports.add("PasswordTextBox element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("PasswordTextBox element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlogoHeading() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(logoHeading)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Logo element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Logo element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsignUptext() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(signUptext)));

		} catch (NoSuchElementException e) {
			ATUReports.add("SignUpButton element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("SignUpButton element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlogintext() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(logintext)));

		} catch (NoSuchElementException e) {
			ATUReports.add("LoginText element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("LoginText element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlogo_caption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(logo_caption)));

		} catch (NoSuchElementException e) {
			ATUReports.add("LogoCaption is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("LogoCaption is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
