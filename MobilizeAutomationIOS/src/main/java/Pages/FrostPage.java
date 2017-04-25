
package Pages;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class FrostPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();


	public FrostPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//System.out.println("From Constructor "+ driver);
	}
	private static MobileElement element = null;
    By tempSlider=By.name("SensorSettingValueScreen_Slider_Type1_Option1");//xpath("//UIAStaticText[@name='SensorSettingValueScreen_Slider_Type1_Option1']");//name("SensorSettingValueScreen_Slider_Type1_Option1");
    By plusIcon =By.name("SensorSettingValueScreen_PlusButton_Type1_Option1");
    By minusIcon=By.name("SensorSettingValueScreen_MinusButton_Type1_Option1");
    By frostThresholdtitletxt = By.xpath("//UIAStaticText[@name='FROST THRESHOLD']");//name("FROST THRESHOLD");
	By frostThresholdCaption=By.name("Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.");
	//SensorSettingValueScreen_ValueField_Type1_Option1
	By frostTextBox=By.name("SensorSettingValueScreen_ValueField_Type1_Option1");//xpath("//UIAStaticText[@name='SensorSettingValueScreen_ValueField_Type1_Option1']");//name("SensorSettingValueScreen_ValueField_Type1_Option1");
	By devicestxt =By.id("Devices");//DISensorSelectionHeaderFooterView0//xpath("//UIAStaticText[@name='Devices']");
	By sensortxt = By.id("Sensors");//DISensorSelectionHeaderFooterView	
	By sensorvalue2 = By.xpath("//UIAStaticText[@name='Davis Instruments Temp/Hum Sensor']");//name("Davis Instruments Temp/Hum Sensor");
	//By sensordropdown1 = By.name("Davis GroWeather, FARS");
	By Sensordropdown2 = By.id("Sentek Drill & Drop TriSCAN 60 cm");
	By frostViewTitleText=By.xpath("//UIAStaticText[@name='Frost']");
    By frostSensorTitle=By.xpath("//UIAStaticText[@name='FROST SENSOR INPUT']");////UIAStaticText[@name='Select the appropriate device and sensor inputs for monitoring frost data.']
    By frostSensorCaption=By.xpath("//UIAStaticText[@name='Select the appropriate device and sensor inputs for monitoring frost data.']");
    By earlyFrostOptionalSlider=By.name("SensorSettingScreen_Switch_Type1_Option2");
    By earlyTitle=By.xpath("//UIAStaticText[@name='EARLY FROST WARNING']");//name("EARLY FROST WARNING");
    By earlyFrostCaption=By.name("Early warning threshold is set to alert for cases where frost may soon follow.");
    By earlyFrostTextBox=By.name("SensorSettingValueScreen_ValueField_Type1_Option2");
    By earlyFrostThresholdSlider=By.name("SensorSettingValueScreen_Slider_Type1_Option2");
    By eralyFrostPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type1_Option2");
    By eralyFrostMinus=By.name("SensorSettingValueScreen_MinusButton_Type1_Option2");
    By completeFrostSetUpTitle=By.name("COMPLETE FROST SETUP");
    By completeFrostCaption=By.name("Save the setup to view the frost report. Go back to edit any frost setup setting.");   		
	By backbtnQnMrk = By.name("Back");
	By next_nxt_save_btn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");// By.name("Next");
	By editfrost = By.name("Frost");
	By nextButtonQnMrk=By.name("Next");
	By thresholdTemText=By.name("Temperature:");
	By eidtSettingsButton=By.name("Edit Settings");
	By deleteSettingsBtn=By.name("Delete");
	By deleteViewPopUpCancelBtn=By.name("Cancel");
	By deleteViewPopUpDeleteBtn=By.name("Delete");
	By skipBtn=By.name("Skip");
	By backBtn=By.name("Back");
	
	By bodytxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");	
	By completefrost_titletxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]");
	By completefrostbodytxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]");	
	By pageindicator  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]");
	By devicedropdown =By.name("xCube Gateway 1E");////UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]
	By sensordropdown = By.name("Davis GroWeather, FARS");
	By temparaturetxtfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By Optional = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
	By frost_title = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]");
	By sensorxpath = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[4]");
	//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableGroup[4]
	By doneBtn=By.name("Done");
	By frostReportTxt=By.name("FROST");
	By deviceDrpDwnId=By.id("DISensorSelectionHeaderFooterView0");
	By drpdwnsNextBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	By drpDownBackButtonXapth=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");////UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]
	By saveBtn=By.name("Save");
	By temperatureFUnitsTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	
	By tempCUnitsTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	
	By tempUnitsPageBackBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
	By frostPpageTemFUnitText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");//name("°F");
	By tempUnitsPageBackBtnName=By.name("Back");
	

	
	public  MobileElement gettempUnitsPageBackBtnName() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(tempUnitsPageBackBtnName)));

		}catch(NoSuchElementException e){
			ATUReports.add("tempUnitsPageBackBtnName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tempUnitsPageBackBtnName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfrostPpageTemFUnitText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostPpageTemFUnitText)));

		}catch(NoSuchElementException e){
			ATUReports.add("frostPpageTemFUnitText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostPpageTemFUnitText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public  MobileElement gettempUnitsPageBackBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(tempUnitsPageBackBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("tempUnitsPageBackBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tempUnitsPageBackBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement gettempCUnitsTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(tempCUnitsTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("tempCUnitsTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tempCUnitsTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement gettemperatureFUnitsTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(temperatureFUnitsTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("temperatureFUnitsTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("temperatureFUnitsTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdrpDownBackButtonXapth() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(drpDownBackButtonXapth)));

		}catch(NoSuchElementException e){
			ATUReports.add("drpDownBackButtonXapth element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("drpDownBackButtonXapth element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsaveBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(saveBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("saveBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("saveBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getbackBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(backBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("backBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("backBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getskipBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(skipBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("skipBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("skipBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdrpdwnsNextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(drpdwnsNextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("DrpdwnsNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DrpdwnsNextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getdeviceDrpDwnId() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(deviceDrpDwnId)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeviceDrpDwnId element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeviceDrpDwnId element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfrostReportTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostReportTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostReportTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostReportTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getdoneBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(doneBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("DoneBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DoneBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getdeleteViewPopUpDeleteBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(deleteViewPopUpDeleteBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeleteViewPopUpDeleteBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeleteViewPopUpDeleteBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdeleteViewPopUpCancelBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(deleteViewPopUpCancelBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeleteViewPopUpCancelBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeleteViewPopUpCancelBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdeleteSettingsBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(deleteSettingsBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeleteSettingsBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeleteSettingsBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement geteidtSettingsButton() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(eidtSettingsButton)));

		}catch(NoSuchElementException e){
			ATUReports.add("EdiSettingsButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditSettingsButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getthresholdTemText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(thresholdTemText)));

		}catch(NoSuchElementException e){
			ATUReports.add("ThresholdTemText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ThresholdTemText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getnextButtonQnMrk() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(nextButtonQnMrk)));

		}catch(NoSuchElementException e){
			ATUReports.add("NextButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NextButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	
	public  MobileElement geteralyFrostMinus() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(eralyFrostMinus)));

		}catch(NoSuchElementException e){
			ATUReports.add("EralyFrostMinus element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EralyFrostMinus element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement geteralyFrostPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(eralyFrostPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("EralyFrostPlusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EralyFrostPlusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getearlyFrostThresholdSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(earlyFrostThresholdSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyFrostThresholdSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyFrostThresholdSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getearlyFrostTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(earlyFrostTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyFrostTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyFrostTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getearlyFrostCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(earlyFrostCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyFrostCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyFrostCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getearlyTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(earlyTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getearlyFrostOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(earlyFrostOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyFrostOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyFrostOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	
	public  MobileElement getfrostSensorCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostSensorCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("frostSensorCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostSensorCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getfrostSensorTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostSensorTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("frostSensorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostSensorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getfrostViewTitleText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostViewTitleText)));

		}catch(NoSuchElementException e){
			ATUReports.add("frostViewTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostViewTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfrostTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("frostTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("frostTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfrostThresholdCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostThresholdCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostThresholdCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostThresholdCaption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getfrostThresholdtitletxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(frostThresholdtitletxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostThresholdtitletxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostThresholdtitletxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getminusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("MinusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("MinusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getplusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(plusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("PlusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PlusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement getTempSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(tempSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("TempSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TempSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	public  MobileElement getsensorxpath() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(sensorxpath)));

		}catch(NoSuchElementException e){
			ATUReports.add("Sensor element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Sensor element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getcompletefrost_titletxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(completefrost_titletxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcompletefrostbodytxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(completefrostbodytxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("FrostBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("FrostBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getOptional() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(Optional)));

		}catch(NoSuchElementException e){
			ATUReports.add("Optonal element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Optional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gettemparaturetxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(temparaturetxtfld)));

		}catch(NoSuchElementException e){
			ATUReports.add("TemperatureTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TemperatureTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbackbtnQnMrk() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(backbtnQnMrk)));

		}catch(NoSuchElementException e){
			ATUReports.add("backbtnQnMrk element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("backbtnQnMrk element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getnext_nxt_save_btn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(next_nxt_save_btn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement geteditfrost() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(editfrost)));

		}catch(NoSuchElementException e){
			ATUReports.add("EditFrost element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditFrost element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getBodytxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(bodytxt)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}



	public  MobileElement getDevicestxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(devicestxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("DevicesText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DevicesText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getSensortxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(sensortxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("SensorText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SensorText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getpageindicator() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(pageindicator)));

		}catch(NoSuchElementException e){
			ATUReports.add("Page Indicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Page Indicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdevicedropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(devicedropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("Device Dropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Device Dropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsensordropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(sensordropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("Sensor Dropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Sensor Dropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement getsensordropdown2() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Sensordropdown2)));

		}catch(NoSuchElementException e){
			ATUReports.add("Sensor Dropdown2 element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Sensor Dropdown2 element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}



