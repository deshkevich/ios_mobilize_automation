package functional_testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.http.*;
import org.openqa.selenium.remote.service.DriverService.*;

import utility.ReadDeviceConfiguration;

import com.thoughtworks.selenium.ScreenshotListener;
import com.thoughtworks.selenium.webdriven.commands.CaptureScreenshotToString;

import atu.testng.reports.ATUReports;
import atu.testng.reports.exceptions.ATUReporterStepFailedException;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.AuthorDetails;
import atu.testng.reports.utils.Utils;
import atu.testrecorder.ATUTestRecorder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

import org.apache.commons.exec.CommandLine;


public class Driverintiation {


	@SuppressWarnings("rawtypes")
	public static IOSDriver iOSdriver = null;
	@SuppressWarnings("rawtypes")
	public static AppiumDriver apdriver = null;
	DesiredCapabilities capabilities = null;
	@SuppressWarnings("rawtypes")
	public static IOSDriver driver=null;
	@SuppressWarnings("unused")
	private static String APPIUMSERVERSTART = "node /home/adminuser/Java_Projects/Appium/appium";
	public static CommandLine command = new CommandLine("/bin/sh -c");
	atu.testng.reports.utils.AuthorDetails ad= new AuthorDetails();
	private ReadDeviceConfiguration rdc ;

	String Appium_Node_Path="/Applications/Appium.app/Contents/Resources/node/bin/node";
	String Appium_JS_Path="/Applications/Appium.app/Contents/Resources/node_modules/appium/lib/appium.js";
	AppiumDriverLocalService appiumService;


	public  Driverintiation() throws MalformedURLException,IllegalStateException {

	}


	@SuppressWarnings("rawtypes")
	@BeforeTest
	//@Parameters("device") String device
	public void searchTest() throws MalformedURLException,InterruptedException{
		rdc = new ReadDeviceConfiguration();
		rdc.start();
		Thread.sleep(10000);

		if(driver==null){

			DesiredCapabilities capabilities = null;

			//if(device.equalsIgnoreCase("mobile1")){
			try{
				//rdc.PlatformName - rdc.platformVersion - rdc.DeviceName
				System.out.println("************1st ****************");
				//Setting up the desired capabilities

				appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
						usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
						withAppiumJS(new File(Appium_JS_Path)).withIPAddress("127.0.0.1").usingPort(4723));

				/*service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
								.usingDriverExecutable(new File("/usr/local/bin/node"))
								.withAppiumJS(
										new File(
												"/usr/local/lib/node_modules/appium/bin/appium.js"))*/
				//								);

				//				service.start();
				appiumService.start();
				Thread.sleep(26000);
				System.out.println("appiumService.isRunning:"+appiumService.isRunning());
				System.out.println("appiumService.getUrl:"+appiumService.getUrl());

				System.out.println("************Mobilize ****************");
				//Setting up the desired capabilities
				capabilities = new DesiredCapabilities();
				//Config configdta =new Config();
				//System.out.println("*************Mobile1**************");

				capabilities.setCapability("automationName", "Appium");
				//capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("platformName", ReadDeviceConfiguration.PlatformName);
				capabilities.setCapability("platformVersion", ReadDeviceConfiguration.platformVersion);
				capabilities.setCapability("deviceName", ReadDeviceConfiguration.DeviceName);
				capabilities.setCapability("bundleId",ReadDeviceConfiguration.bundleId);
				//capabilities.setCapability("app", rdc.Applicationpath);
				capabilities.setCapability("udid",ReadDeviceConfiguration.UDID );
				capabilities.setCapability("nativeInstrumentsLib", true);
				//How long (in seconds) Appium will wait for a new command from the client before assuming the client quit and ending the session
				capabilities.setCapability("newCommandTimeout",0);
				capabilities.setCapability("autoWebview", false);
				capabilities.setCapability("orientation", "PORTRAIT");
				//Timeout in seconds while waiting for device to become ready
				capabilities.setCapability("deviceReadyTimeout", 20);
				capabilities.setCapability("sendKeyStrategy", "oneByOne");
				//capabilities.setCapability("NoReset", true);
				//capabilities.setCapability("fullReset", true);
				//The ios automation script used to determined if the app has been launched, by default the system wait for the page source not to be empty. The result must be a boolean
				//capabilities.setCapability("waitForAppScript", "30");
				//capabilities.setCapability("autoAcceptAlerts", true);
				capabilities.setCapability("interKeyDelay", 20);
				//Amount of time in ms to wait for instruments before assuming it hung and failing the session
				capabilities.setCapability("launchTimeout", 50000);
				//capabilities.setCapability("launchTimeout", 50000);

				
				System.out.println("appiumService.isRunning:"+appiumService.isRunning());

				apdriver = new IOSDriver(appiumService.getUrl(), capabilities);
				(new TestAppiumDriver()).setAppiumDriver(apdriver);
				//ATUReports.indexPageDescription = " Mobilize test results ";
				//ATUReports.currentRunDescription = "This is a test Run";
				ATUReports.setAuthorInfo("Appium User", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "Ver 1.0");
				driver = (IOSDriver) TestAppiumDriver.getAppiumDriver();
				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				ATUReports.setWebDriver(driver);
				setAuthorInfoForReports();
				setIndexPageDescription();
				ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"2.0");


			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}
			//}
		}
	}

	private void setIndexPageDescription() {

		ATUReports.indexPageDescription = "Mobilize Project Description <br/> <b>Can include Full set of HTML Tags</b>";
	}

	private void setAuthorInfoForReports() {
		ATUReports.currentRunDescription = ReadDeviceConfiguration.DeviceName+""+ReadDeviceConfiguration.PlatformName+""+ReadDeviceConfiguration.platformVersion;

	}

	@SuppressWarnings("rawtypes")
	public IOSDriver getInstance(){
		System.out.println(" in get instance method "+ driver);
		return (IOSDriver) driver;
	}

	@AfterTest
	public void finish(){
		System.out.println(" in FINISH method ");
		driver.quit();
		appiumService.stop();

	}
}


