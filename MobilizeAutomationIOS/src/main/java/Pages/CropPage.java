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

public class CropPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public CropPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructor "+ driver);
	}
	private static MobileElement element = null;
	/* By nextButton=By.xpath("//UIANavigationBar[1]/UIAButton[2]");
	    By backButton=By.xpath("//UIANavigationBar[1]/UIAButton[1]");*/
	By backbtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");//name("Back");//By.name("Back");	
	By next_save_btn =By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");// By.name("Next");
	By crop = By.name("Crop");
	By requiretxt = By.name("Required");
	By cropSensorTitle=By.name("CROP SENSOR INPUT");
	//By devicesDropDown=By.name("Devices");
	//By sensorDropDown=By.name("Sensors");
	By cropSensorBody=By.name("Select the appropriate device and temperature sensor input for monitoring crop data.");
	//By editcropTopText=By.name("Crop");
	By cropDeviceDropDownText=By.name("xCube Gateway 1E");
	By cropSensorDropDownText=By.name("Davis Instruments Temp/Hum Sensor");
	By skipBtn=By.name("Skip");
	By cropVarietyOptional=By.name("SensorSettingScreen_Switch_Type0_Option1");
	By cropVarietyTitle=By.name("CROP & VARIETY");
	By cropVarietyBody=By.name("Enter the crop type and variety to build a crop specific profile.");
	//By enterCropValue=By.name("Crop:");
	//By enterVarietyValue=By.name("Variety:");
	//By doneButtonKybrd=By.name("Done");
	By growingDegreeOtpional=By.name("SensorSettingScreen_Switch_Type0_Option2");
	By gddStartDateTitle=By.name("GROWING DEGREE START DATE (GDD)");
	By gdStartBody=By.name("Set the starting date to begin accumulating GDD.");
	By gdThresholdText=By.name("GDD start date:");
	By gdDatePicker=By.name("SensorSettingScreen_DateTextField_Type0_Option2");
	By gddTargetTitle=By.name("GDD TARGET");
	By gddTargetBody=By.name("Set the total number of GDD required to reach the desired stage.");
	By gddThesholdText=By.name("Set crop target:");
	By gddTargetTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By gddcalnTitle=By.name("GDD CALCULATION TYPE");
	By gddCaltnBody=By.name("Set the crop calculation format required for GDD calculation.");
	//By singleRadioButtonTxt=By.name("Single Sine");
	By integrationTxt=By.name("Integration");
	By GddPagehelpButton1=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
	By GddPagehelpButton2=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIAButton[1]");
	By GddPagehelpButton3=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
	By GddPagehelpButton4=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
	By GddPagehelpButton5=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIAButton[1]");
	By GddPagehelpButton6=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
	By GddPagehelpButton7=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
	By GddPagehelpButton8=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
	By GddPagehelpButton9=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIAButton[1]");
	By GddPagehelpButton10=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
	
	By singleSignPopUpTitle=By.name("Single Sine");
	By singleSignPopUpBody=By.name("Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.");
	By okBtn=By.name("OK");
	//By integrationPopUpTitle=By.name("Integration");
	By integrationPopUpBody=By.name("Most Accurate. Integrates all time series temperature data provided by the sensor.");
	By lowTemTitle=By.name("LOWER TEMPERATURE THRESHOLD");
	By lowTemBody=By.name("GDD will be accumulated at and above the lower threshold.");
	By lowTemThresholdTxt=By.name("Set Lower Threshold:");
	By lowTemTextBox=By.name("SensorSettingValueScreen_ValueField_Type0_Option5");
	By LwrminusBtn=By.name("SensorSettingValueScreen_MinusButton_Type0_Option5");
	By LwrplusBtn=By.name("SensorSettingValueScreen_PlusButton_Type0_Option5");
	By lowTemSlider=By.name("SensorSettingValueScreen_Slider_Type0_Option5");
	By upperTemOptional=By.name("SensorSettingScreen_Switch_Type0_Option6");
	By upperTemTitle=By.name("UPPER TEMPERATURE THRESHOLD");
	By upperTemBody=By.name("Growing degree days are accumulated above the upper threshold depending on the selected cutoff method.");
	By upperTemTextBx=By.name("SensorSettingValueScreen_ValueField_Type0_Option6");
	By uprMinus=By.name("SensorSettingValueScreen_MinusButton_Type0_Option6");
	By upprPlus=By.name("SensorSettingValueScreen_PlusButton_Type0_Option6");
	By uprTemSlider=By.name("SensorSettingValueScreen_Slider_Type0_Option6");
	By cutOffTitle=By.name("CUTOFF METHOD");
	By cutOffBody=By.name("Set the crop calculation format to resolve GDD accumulation if upper temperature threshold is met.");
	//By vertcalTxt=By.name("Vertical");
	//By horizontalTxt=By.name("Horizontal");
	//By intermediate=By.name("Intermediate");	
	By cutOffHelpBtn=By.name("RadioOptionViewCell_HelpButton_Type0_Option7");	
	By chillstrtDateOptional=By.name("SensorSettingScreen_Switch_Type0_Option8");
	By chillstartdtTitle=By.name("CHILL START DATE");
	By chillsrtdtBody=By.name("Set the starting date to begin Chill accumulation.");
	By datePickerChilSrtDt=By.name("SensorSettingScreen_DateButton_Type0_Option8");
	By chillCalnTitle=By.name("CHILL CALCULATION METHOD");
	By chillCalnBody=By.name("Set the crop calculation format required for chill unit calculation.");
	By chillclnDynmicTxt=By.name("Dynamic Chilling Portions");
	By chillcalnChillingHrs=By.name("Chilling Hours");
	By utahChllingUnits=By.name("Utah Chilling Units");
	By chilingCalnHelpBtn=By.name("RadioOptionViewCell_HelpButton_Type0_Option9");
	By chilingtatgetTitle=By.name("CHILL CALCULATION TARGET");
	By chilingTagtBody=By.name("Set the total number of Chill Units required to reach the desired stage.");
	By ChillingTxtBx=By.name("SensorSettingValueScreen_ValueField_Type0_Option10");
	By ChllinhTrgtMinus=By.name("SensorSettingValueScreen_MinusButton_Type0_Option10");
	By chillingTrgtPlus=By.name("SensorSettingValueScreen_PlusButton_Type0_Option10");
	By chillingTrgtSlider=By.name("SensorSettingValueScreen_Slider_Type0_Option10");
	By chiltartxt = By.name("CHILLING TARGET");
	By completeCropSetUpTitle=By.name("COMPLETE CROP SETUP");
	By completeSetUpBody=By.name("Save the setup to view the crop report. Go back to edit any crop setup setting.");
	By saveBtn=By.name("Save");	
	By cropVarietyCropTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//no metd
	By cropVarietyVarietyTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");//no metd
	By GDDDatepickerBtn=By.name("SensorSettingScreen_DateButton_Type0_Option2");//no metd
	By doneBtn=By.name("Done");//no metd
	
	
	//By backbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	//By next_save_btn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	By bodytxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");
	By titletxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	By togglebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
	By devicestxt = By.name("xCube Gateway 1E"); //By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	By sensortxt = By.name("Davis GroWeather, FARS");
	By pageindicator  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]");
	By devicedropdown = By.id("DISensorSelectionHeaderFooterView0");//name("Devices");//DISensorSelectionHeaderFooterView0
	By sensordropdown = By.name("Sensors");
	By optionaltxt = By.name("Optional");
	By croptxtfield = By.name("Crop:");
	By variety = By.name("Variety:");
	//By croptxtfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1CHILLING TARGET]/UIATableView[1]/UIATableCell[2]/UIA`TextField[1]");
	By varietytxtfld= By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
	By GDDstartdate = By.name("GDD start date:");
	By GDDtxtfield = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	By datebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");
	By chillstartdate = By.name("Chill Start date:");
	By setcroptarget = By.name("Set crop target:");
	By setcroptargetttfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By singleSine = By.name("Single Sine");
	By Integration = By.name("Integration");
	By SingleSinebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	By integrationbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
	By setthresholdtxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	By f = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	By thresholdtxtfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By thresoldswipe = By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAElement[1]");
	By vertialtxt = By.name("Vertical");
	By horizontaltxt = By.name("Horizontal");
	By intermediatetxt = By.name("Intermediate");
	By vertialbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	By horizontalbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
	By intermediatebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]");
	By Portionsltxt = By.name("Portions");
	By hourstxt = By.name("Hours");
	By unitstxt = By.name("Units");
	By portionbtn = By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	By hoursbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]");
	By unitsbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]");
	By savebtntxt  = By.name("Save");
	By complete_crop_titletxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]");
	By Done = By.name("Done");
	By singlesineHelpCaption=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
    By cropUnits=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
    By nextButtonTopText = By.name("Next");
    By backButtonTop= By.name("Back");
    		
    By saveTxt=By.name("Save");
    
    
    public  MobileElement getsaveTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(saveTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("saveTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("saveTxt text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getbackButtonTop() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backButtonTop);

		}catch(NoSuchElementException e){
			ATUReports.add("backButtonTop is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("backButtonTop text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getnextButtonTopText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(nextButtonTopText);

		}catch(NoSuchElementException e){
			ATUReports.add("nextButtonTopText is not displayed", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("nextButtonTopText text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getcropVarietyVarietyTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropVarietyVarietyTextBox);

		}catch(NoSuchElementException e){
			ATUReports.add("Variety text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Variety text box is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getchiltartxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chiltartxt);

		}catch(NoSuchElementException e){
			ATUReports.add("CHILLING TARGET is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CHILLING TARGET is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getchillclnDynmicTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillclnDynmicTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("chillclnDynmicTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillclnDynmicTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getchillCalnTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillCalnTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("chillCalnTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillCalnTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getcropUnits() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropUnits);

		}catch(NoSuchElementException e){
			ATUReports.add("cropUnits is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropUnits is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
	public  MobileElement getsinglesineHelpCaption() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(singlesineHelpCaption);

		}catch(NoSuchElementException e){
			ATUReports.add("singlesineHelpCaption is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("singlesineHelpCaption is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGDDDatepickerBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GDDDatepickerBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("GDDDatepickerBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GDDDatepickerBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropVarietyCropTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropVarietyCropTextBox);

		}catch(NoSuchElementException e){
			ATUReports.add("cropVarietyCropTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropVarietyCropTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public  MobileElement getsaveBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(saveBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("saveBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("saveBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcompleteSetUpBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(completeSetUpBody);

		}catch(NoSuchElementException e){
			ATUReports.add("completeSetUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("completeSetUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getcompleteCropSetUpTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(completeCropSetUpTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("completeCropSetUpTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("completeCropSetUpTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getchillingTrgtSlider() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillingTrgtSlider);

		}catch(NoSuchElementException e){
			ATUReports.add("chillingTrgtSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillingTrgtSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchillingTrgtPlus() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillingTrgtPlus);

		}catch(NoSuchElementException e){
			ATUReports.add("chillingTrgtPlus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillingTrgtPlus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getChllinhTrgtMinus() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(ChllinhTrgtMinus);

		}catch(NoSuchElementException e){
			ATUReports.add("ChllinhTrgtMinus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ChllinhTrgtMinus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getChillingTxtBx() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(ChillingTxtBx);

		}catch(NoSuchElementException e){
			ATUReports.add("ChillingTxtBx is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ChillingTxtBx is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchilingTagtBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chilingTagtBody);

		}catch(NoSuchElementException e){
			ATUReports.add("chilingTagtBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chilingTagtBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getchilingtatgetTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chilingtatgetTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("chilingtatgetTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chilingtatgetTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchilingCalnHelpBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chilingCalnHelpBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("chilingCalnHelpBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chilingCalnHelpBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getutahChllingUnits() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(utahChllingUnits);

		}catch(NoSuchElementException e){
			ATUReports.add("utahChllingUnits is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("utahChllingUnits is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getchillcalnChillingHrs() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillcalnChillingHrs);

		}catch(NoSuchElementException e){
			ATUReports.add("chillcalnChillingHrs is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillcalnChillingHrs is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getdatePickerChilSrtDt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(datePickerChilSrtDt);

		}catch(NoSuchElementException e){
			ATUReports.add("datePickerChilSrtDt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("datePickerChilSrtDt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getchillsrtdtBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillsrtdtBody);

		}catch(NoSuchElementException e){
			ATUReports.add("chillsrtdtBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillsrtdtBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchillstartdtTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillstartdtTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("chillstartdtTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillstartdtTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getchillstrtDateOptional() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillstrtDateOptional);

		}catch(NoSuchElementException e){
			ATUReports.add("chillstrtDateOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("chillstrtDateOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getcutOffHelpBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cutOffHelpBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("cutOffHelpBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cutOffHelpBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getcutOffBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cutOffBody);

		}catch(NoSuchElementException e){
			ATUReports.add("cutOffBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cutOffBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcutOffTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cutOffTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("cutOffTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cutOffTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public  MobileElement getuprTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(uprTemSlider);

		}catch(NoSuchElementException e){
			ATUReports.add("uprTemSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("uprTemSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getupprPlus() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(upprPlus);

		}catch(NoSuchElementException e){
			ATUReports.add("upprPlus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("upprPlus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getuprMinus() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(uprMinus);

		}catch(NoSuchElementException e){
			ATUReports.add("uprMinus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("uprMinus is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getupperTemTextBx() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(upperTemTextBx);

		}catch(NoSuchElementException e){
			ATUReports.add("upperTemTextBx is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("upperTemTextBx is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getupperTemBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(upperTemBody);

		}catch(NoSuchElementException e){
			ATUReports.add("upperTemBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("upperTemBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getupperTemTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(upperTemTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("upperTemTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("upperTemTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getupperTemOptional() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(upperTemOptional);

		}catch(NoSuchElementException e){
			ATUReports.add("upperTemOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("upperTemOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getlowTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(lowTemSlider);

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemSlider is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getLwrplusBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(LwrplusBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("LwrplusBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("LwrplusBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getLwrminusBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(LwrminusBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("LwrminusBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("LwrminusBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getlowTemTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(lowTemTextBox);

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getlowTemThresholdTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(lowTemThresholdTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemThresholdTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemThresholdTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getlowTemBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(lowTemBody);

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getlowTemTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(lowTemTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getintegrationPopUpBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(integrationPopUpBody);

		}catch(NoSuchElementException e){
			ATUReports.add("integrationPopUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("integrationPopUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getokBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(okBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("okBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("okBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getsingleSignPopUpBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(singleSignPopUpBody);

		}catch(NoSuchElementException e){
			ATUReports.add("singleSignPopUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("singleSignPopUpBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	public  MobileElement getsingleSignPopUpTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(singleSignPopUpTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("singleSignPopUpTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("singleSignPopUpTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement getGddPagehelpButton1() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton1);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton2() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton2);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton3() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton3);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton4() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton4);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton5() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton5);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton6() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton6);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton7() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton7);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton8() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton8);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton9() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton9);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getGddPagehelpButton10() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GddPagehelpButton10);

		}catch(NoSuchElementException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GddPagehelpButton is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getintegrationTxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(integrationTxt);

		}catch(NoSuchElementException e){
			ATUReports.add("integrationTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("integrationTxt is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getgddCaltnBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddCaltnBody);

		}catch(NoSuchElementException e){
			ATUReports.add("gddCaltnBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddCaltnBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgddcalnTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddcalnTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("gddcalnTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddcalnTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public  MobileElement getgddTargetTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddTargetTextBox);

		}catch(NoSuchElementException e){
			ATUReports.add("gddTargetTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddTargetTextBox is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getgddThesholdText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddThesholdText);

		}catch(NoSuchElementException e){
			ATUReports.add("gddThesholdText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddThesholdText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getgddTargetBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddTargetBody);

		}catch(NoSuchElementException e){
			ATUReports.add("gddTargetBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddTargetBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgddTargetTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddTargetTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("gddTargetTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddTargetTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getgdDatePicker() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gdDatePicker);

		}catch(NoSuchElementException e){
			ATUReports.add("gdDatePicker is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gdDatePicker is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getgdThresholdText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gdThresholdText);

		}catch(NoSuchElementException e){
			ATUReports.add("gdThresholdText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gdThresholdText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement getgdStartBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gdStartBody);

		}catch(NoSuchElementException e){
			ATUReports.add("gdStartBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gdStartBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getgddStartDateTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(gddStartDateTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("gddStartDateTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("gddStartDateTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getgrowingDegreeOtpional() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(growingDegreeOtpional);

		}catch(NoSuchElementException e){
			ATUReports.add("growingDegreeOtpional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("growingDegreeOtpional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropVarietyBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropVarietyBody);

		}catch(NoSuchElementException e){
			ATUReports.add("cropVarietyBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropVarietyBody is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropVarietyTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropVarietyTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("cropVarietyTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropVarietyTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropVarietyOptional() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropVarietyOptional);

		}catch(NoSuchElementException e){
			ATUReports.add("cropVarietyOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropVarietyOptional is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getskipBtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(skipBtn);

		}catch(NoSuchElementException e){
			ATUReports.add("skipBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("skipBtn is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcropSensorDropDownText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropSensorDropDownText);

		}catch(NoSuchElementException e){
			ATUReports.add("cropSensorDropDownText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropSensorDropDownText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public  MobileElement getecropDeviceDropDownText() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropDeviceDropDownText);

		}catch(NoSuchElementException e){
			ATUReports.add("cropDeviceDropDownText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropDeviceDropDownText is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	
	public  MobileElement getcropSensorTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(cropSensorTitle);

		}catch(NoSuchElementException e){
			ATUReports.add("cropSensorTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("cropSensorTitle is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	//cropSensorTitle

	public  MobileElement getsetcroptargetttfld() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(setcroptargetttfld);

		}catch(NoSuchElementException e){
			ATUReports.add("SetCropTargetField is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SetCropTargetField is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getDone() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Done);

		}catch(NoSuchElementException e){
			ATUReports.add("Done element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Done element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getrequiretxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(requiretxt);

		}catch(NoSuchElementException e){
			ATUReports.add("RequireText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("RequireText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}


	public  MobileElement getcomplete_crop_titletxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(complete_crop_titletxt);

		}catch(NoSuchElementException e){
			ATUReports.add("CompleteCropTitle Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CompleteCropTitle Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbackbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(backbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getnext_nxt_save_btn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(next_save_btn)));

		}catch(NoSuchElementException e){
			ATUReports.add("NextSaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("NextSaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcrop() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(crop)));

		}catch(NoSuchElementException e){
			ATUReports.add("EditCrop element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditCrop element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getOptionaltxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(optionaltxt);

		}catch(NoSuchElementException e){
			ATUReports.add("OptionalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("OptionalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getBodytxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(bodytxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getTitletxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(titletxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("TitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getTogglebtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(togglebtn);

		}catch(NoSuchElementException e){
			ATUReports.add("ToggleButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ToggleButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getDevicestxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(devicestxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeviceText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DevicesText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getSensortxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(sensortxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("SensorsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SensorsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getpageindicator() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(pageindicator);

		}catch(NoSuchElementException e){
			ATUReports.add("PageIndicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PageIndicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdevicedropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(devicedropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeviceDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeviceDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsensordropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(sensordropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("SensorDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SensorDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcroptxtfield() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(croptxtfield);

		}catch(NoSuchElementException e){
			ATUReports.add("CropText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CropText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getvariety() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(variety);

		}catch(NoSuchElementException e){
			ATUReports.add("Variety element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Variety element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	/*public  MobileElement getcroptxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(croptxtfld);

		}catch(NoSuchElementException e){
			ATUReports.add("CropTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CropTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	public  MobileElement getvarietytxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(varietytxtfld);

		}catch(NoSuchElementException e){
			ATUReports.add("VarietyTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("VarietyTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getGDDstartdate() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GDDstartdate);

		}catch(NoSuchElementException e){
			ATUReports.add("GDDStartDate element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GDDStartDate element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getGDDtxtfield() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(GDDtxtfield);

		}catch(NoSuchElementException e){
			ATUReports.add("GDDTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GDDTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getdatebtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(datebtn);

		}catch(NoSuchElementException e){
			ATUReports.add("DateButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DateButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getchillstartdate() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(chillstartdate);

		}catch(NoSuchElementException e){
			ATUReports.add("ChillStartDate element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ChillStartDate element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsetcroptarget() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(setcroptarget);

		}catch(NoSuchElementException e){
			ATUReports.add("SetCropTarget element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SetCropTarget element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsingleSine() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(singleSine)));

		}catch(NoSuchElementException e){
			ATUReports.add("SingleLine element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Done element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getIntegration() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(Integration)));

		}catch(NoSuchElementException e){
			ATUReports.add("Integration element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Integration element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getSingleSinebtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(SingleSinebtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SingleSineButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SingleSineButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getintegrationbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(integrationbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("IntegrationButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("IntegrationButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsetthresholdtxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(setthresholdtxt);

		}catch(NoSuchElementException e){
			ATUReports.add("SetThresholdText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SetThresholdText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getf() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(f);

		}catch(NoSuchElementException e){
			ATUReports.add("F Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("F Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getthresholdtxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(thresholdtxtfld);

		}catch(NoSuchElementException e){
			ATUReports.add("ThresholdTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ThresholdTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getthresoldswipe() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(thresoldswipe);

		}catch(NoSuchElementException e){
			ATUReports.add("ThresholdSwipe element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ThresholdSwipe element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getvertialtxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(vertialtxt);

		}catch(NoSuchElementException e){
			ATUReports.add("VerticalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("VerticalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gethorizontaltxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(horizontaltxt);

		}catch(NoSuchElementException e){
			ATUReports.add("HorizontalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HorizontalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getintermediatetxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(intermediatetxt);

		}catch(NoSuchElementException e){
			ATUReports.add("IntermediateText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("IntermediateText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getvertialbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(vertialbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("VerticalButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("VerticalButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gethorizontalbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(horizontalbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("HorizontalButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HorizontalButtonButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getintermediatebtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(intermediatebtn);

		}catch(NoSuchElementException e){
			ATUReports.add("IntermediateButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("IntermediateButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getPortionsltxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Portionsltxt);

		}catch(NoSuchElementException e){
			ATUReports.add("PortionsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PortionsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gethourstxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(hourstxt);

		}catch(NoSuchElementException e){
			ATUReports.add("HoursText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HoursText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getunitstxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(unitstxt);

		}catch(NoSuchElementException e){
			ATUReports.add("UnitsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("UnitsText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getportionbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(portionbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("PortionButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PortionButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gethoursbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(hoursbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("HoursButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HoursButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getunitsbtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(unitsbtn);

		}catch(NoSuchElementException e){
			ATUReports.add("UnitsButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("UnitsButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsavebtntxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(savebtntxt);

		}catch(NoSuchElementException e){
			ATUReports.add("SaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
