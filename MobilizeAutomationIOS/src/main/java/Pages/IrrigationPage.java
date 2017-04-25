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

public class IrrigationPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public IrrigationPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;
	
	By soilMoistureOptional=By.name("SensorSettingScreen_Switch_Type3_Option0");
	By soilMoistureTitle=By.name("SOIL MOISTURE SENSOR");
	By soilMoistureBody=By.name("Select the appropriate device and sensor inputs for monitoring soil moisture.");
	By backbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	By skipbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	By editirrigationtxt = By.name("Irrigation"); //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]
	By soilMoistreOtionalSlider=By.name("SensorSettingScreen_Switch_Type3_Option0");
	By optionaltxt = By.name("Optional");
	By IrrigationDeviceDropDownText=By.name("xCube Gateway 1E");
	By  IrrigationSensorDropDownText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[4]");
	
	By saturatnThresholdTitle=By.name("SATURATION THRESHOLD");
	By saturatnThresholdBody=By.name("Saturation threshold sets the topline of field moisture capacity.");
	By saturnThresholdTxtBx=By.name("SensorSettingValueScreen_ValueField_Type3_Option1");
	By saturatnPlusBtn=By.name("SensorSettingValueScreen_PlusButton_Type3_Option1");
	By saturatnMinusBtn=By.name("SensorSettingValueScreen_MinusButton_Type3_Option1");
	By saturtnOptionalSlider=By.name("SensorSettingScreen_Switch_Type3_Option1");
	By saturnTemSlider=By.name("SensorSettingValueScreen_Slider_Type3_Option1");
	
	
	By wiltingThresholdTitle=By.name("WILTING THRESHOLD");
	By wiltingBody=By.name("Wilting threshold sets the lower limit, indicating the onset of plant stress due to under watering.");
	By wiltingTemTxtBx=By.name("SensorSettingValueScreen_ValueField_Type3_Option2");
	By wiltingtOptionalSlider=By.name("SensorSettingScreen_Switch_Type3_Option2");
	By wiltingTemSlider=By.name("SensorSettingValueScreen_Slider_Type3_Option2");
	By wlitingPlusBtn=By.name("SensorSettingValueScreen_PlusButton_Type3_Option2");
	By wiltingMinus=By.name("SensorSettingValueScreen_MinusButton_Type3_Option2");
	
	By saturtnTesholdTemText=By.name("Saturation:");
	By earlyWarngThresholdOptionalSlider=By.name("SensorSettingScreen_Switch_Type3_Option3");
	By earlyWrngTitle=By.name("EARLY WARNING THRESHOLD");
	By earlyWrngBody=By.name("Early warning threshold is set to alert prior to when actual wilting threshold conditions are met.");
	By eralyWrngTxtBx=By.name("SensorSettingValueScreen_ValueField_Type3_Option3");
	By earlyWrngPlus=By.name("SensorSettingValueScreen_PlusButton_Type3_Option3");
	By ealryWrngMinus=By.name("SensorSettingValueScreen_MinusButton_Type3_Option3");
	By earlyWrngTemSlider=By.name("SensorSettingValueScreen_Slider_Type3_Option3");
	By earlyOptional=By.name("SensorSettingScreen_Switch_Type3_Option3");
			
	By lowSalinityOptional=By.name("SensorSettingScreen_Switch_Type3_Option4");
	By lowSalinityTitle=By.name("LOW SALINITY THRESHOLD");
	By lowSAlinityBody=By.name("Alert triggered if salinity is at or below threshold.");
	By lowSalinityTextTxtBx=By.name("SensorSettingValueScreen_ValueField_Type3_Option4");
	By lowSalinityTemSlider=By.name("SensorSettingValueScreen_Slider_Type3_Option4");
	By lowSalinityPlusBtn=By.name("SensorSettingValueScreen_PlusButton_Type3_Option4");
	By lowSalinityMinusBtn=By.name("SensorSettingValueScreen_MinusButton_Type3_Option4");
	
	By highSalinityTitle=By.name("HIGH SALINITY THRESHOLD");
	By highSalinityBody=By.name("Alert triggered if salinity is at or above threshold.");
	By highSalntyTemTxtBx=By.name("SensorSettingValueScreen_ValueField_Type3_Option5");
	By highSalinityOptional=By.name("SensorSettingScreen_Switch_Type3_Option5");
	By highSalntyPlus=By.name("SensorSettingValueScreen_PlusButton_Type3_Option5");
    By highSalntyMinus=By.name("SensorSettingValueScreen_MinusButton_Type3_Option5");
	By highSalntyTemSlider=By.name("SensorSettingValueScreen_Slider_Type3_Option5");
	
	By pressureSensorTitle=By.name("PRESSURE SENSOR/SWITCH");
	By pressureSensorBody=By.name("Select the appropriate device and sensor input for monitoring irrigation status.");
	By pressureOptional=By.name("SensorSettingScreen_Switch_Type3_Option6");
	By pressureSensorSensorsDropDown_item=By.name("Omega PX309-015G5V");
	
	By flowMetrTitle=By.name("FLOW METER SENSOR");
	By flowMtrBody=By.name("Select the appropriate device and sensor input for monitoring irrigation flow status.");
	By flowMtrOptionalSlider=By.name("SensorSettingScreen_Switch_Type3_Option7");
	By flowMtrSensorsDropDwn_item=By.name("SensorGateWayScreen_LogicalID");
	
	By etReadngOptional=By.name("SensorSettingScreen_Switch_Type3_Option8");
	By etReadngTitle=By.name("ET READING");
	By etRedngBody=By.name("Select the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).");
	By etReadngSensorsDrpDwnItem=By.name("Davis GroWeather, FARS");
	By save_nxtBtn=By.name("Save");
	By saveBtn=By.name("Save");	
	By bodytxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");    
	By titletxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	By togglebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
	By devicesdropdown = By.name("Devices");
	By sensordropdown = By.name("Sensors");
	
	By pageindicator  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]");
	By Editirrigtext = By.name("Edit Irrigation");
	By saturation_text = By.name("Saturation:");
	By text_fld  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By Sybltxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");    
	By Pageindicator = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]");
	By next_save_btn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	By error_title = By.name("Cancel Adding Irrigation?");
	By error_body = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	By gobacktxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
	By continuetxt =  By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
	By devicestxt_item = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	By sensortxt_item = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[4]");
	By saturationtxtfld = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	By pressuresensortxt_item = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[4]");
	By et_reading_item = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[4]");
	By complete_irrigation_titletxt = By.name("COMPLETE IRRIGATION SETUP");
	By complete_irrigation_body_txt = By.name("Save the setup to view the irrigation report. Go back to edit any irrigation setup setting.");
    By nextBtn=By.name("Next");//no method
   // wiltingtOptionalSlider---earlyOptional--lowSalinityOptional---highSalinityOptional,pressureOptional,flowMtrOptionalSlider
    
    //wiltingTemTxtBx
    
 
    
    public  MobileElement getwiltingTemTxtBx() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(wiltingTemTxtBx)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("wiltingTemTxtBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("wiltingTemTxtBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    
    public  MobileElement gethighSalntyTemSlider() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(highSalntyTemSlider)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("highSalntyTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("highSalntyTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    public  MobileElement getsaturnTemSlider() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(saturnTemSlider)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("saturnTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("saturnTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    public  MobileElement getetReadngOptional() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(etReadngOptional)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("etReadngOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("etReadngOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    public  MobileElement getflowMtrOptionalSlider() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(flowMtrOptionalSlider)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("flowMtrOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("flowMtrOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    public  MobileElement getpressureOptional() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pressureOptional)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("pressureOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("pressureOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    public  MobileElement gethighSalinityOptional() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(highSalinityOptional)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("highSalinityOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("highSalinityOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    
    public  MobileElement getlowSalinityOptional() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(lowSalinityOptional)));

		}catch(NoSuchElementException e){
			ATUReports.add("lowSalinityOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowSalinityOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getearlyOptional() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(earlyOptional)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getwiltingtOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(wiltingtOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("wiltingtOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("wiltingtOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    public  MobileElement gethighSalntyPlus() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(highSalntyPlus)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowSalinityPlusBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(lowSalinityPlusBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    public  MobileElement getearlyWrngPlus() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(wlitingPlusBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getwlitingPlusBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(wlitingPlusBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getsaturatnPlusBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(saturatnPlusBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowSalinityTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(lowSalinityTemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getearlyWrngTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(earlyWrngTemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getwiltingTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(wiltingTemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getsaturtnOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(saturtnOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Optional Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getIrrigationSensorDropDownText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(IrrigationSensorDropDownText)));

		}catch(NoSuchElementException e){
			ATUReports.add("Irrigation drop down text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Irrigation drop down text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
    public  MobileElement getetsoilMoistreOtionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(soilMoistreOtionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("ReadingItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("REadingItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
	public  MobileElement getsoilMoistureBody() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(soilMoistureBody);
		}
		catch(NoSuchElementException e){
			ATUReports.add("soilMoistureBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("soilMoistureBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getsoilMoistureTitle() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(soilMoistureTitle);
		}
		catch(NoSuchElementException e){
			ATUReports.add("soilMoistureTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("soilMoistureTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getsoilMoistureOptional() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(soilMoistureOptional);
		}
		catch(NoSuchElementException e){
			ATUReports.add("soilMoistureOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("soilMoistureOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getsensordropdown() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(sensordropdown);
		}
		catch(NoSuchElementException e){
			ATUReports.add("sensordropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("sensordropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getdevicesdropdown() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(devicesdropdown);
		}
		catch(NoSuchElementException e){
			ATUReports.add("devicesdropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("devicesdropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getcomplete_irrigation_titletxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(complete_irrigation_titletxt);
		}
		catch(NoSuchElementException e){
			ATUReports.add("IrrigationTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("IrrigationTitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcomplete_irrigation_body_txt() throws InterruptedException{
		try{

			element  = (MobileElement) driver.findElement(complete_irrigation_body_txt);

		}catch(NoSuchElementException e){
			ATUReports.add("IrrigationBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("IrrigationBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getet_reading_item() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(et_reading_item)));

		}catch(NoSuchElementException e){
			ATUReports.add("ReadingItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("REadingItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsensortxt_item() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(sensortxt_item)));

		}catch(NoSuchElementException e){
			ATUReports.add("SensorTextItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SensorTextItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getpressuresensortxt_item() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(pressuresensortxt_item)));

		}catch(NoSuchElementException e){
			ATUReports.add("PressureSensorText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PressureSensorText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getsaturationtxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(saturationtxtfld)));

		}catch(NoSuchElementException e){
			ATUReports.add("SaturationTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SaturationTextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getdevicestxt_item() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(devicestxt_item)));

		}catch(NoSuchElementException e){
			ATUReports.add("DevicesTextItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DevicesTextItem element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement geterror_title() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(error_title)));

		}catch(NoSuchElementException e){
			ATUReports.add("ErrorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ErrorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement geterror_body() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(error_body)));

		}catch(NoSuchElementException e){
			ATUReports.add("ErrorBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ErrorBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getgobacktxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(gobacktxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("GoBackText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GoBackText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcontinuetxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(continuetxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("ContinueText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ContinueText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getnext_nxt_save_btn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(next_save_btn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SaveButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SaevButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement editirrigationtxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(editirrigationtxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("Irrigation Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Irrigation Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement optionaltxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(optionaltxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("OptionalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("OptionalText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement bodytxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(bodytxt)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("Body Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Body Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement titletxt() throws InterruptedException{
		try{

			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(titletxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement togglebtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(togglebtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("ToggleButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ToggleButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement devicedropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(devicesdropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("DeviceDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("DeviceDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement sensordropdown() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(sensordropdown)));

		}catch(NoSuchElementException e){
			ATUReports.add("SensorDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SensorDropdown element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getbackbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(backbtn)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BackButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getskipbtn() throws InterruptedException{
		try{
			element  = (MobileElement)((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(skipbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("SkipButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SkipButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getEditirrigtext() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(Editirrigtext)));

		}
		catch(NoSuchElementException e){
			ATUReports.add("EditIrrigationText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditIrrigationText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement gettitletxt() throws InterruptedException{
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
	
	public  MobileElement getbodytxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(bodytxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("BodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement gettextfld() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(text_fld)));

		}catch(NoSuchElementException e){
			ATUReports.add("TextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TextField element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getsaturation_text() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(saturation_text);

		}catch(NoSuchElementException e){
			ATUReports.add("SaturationText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SaturationText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getSybltxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Sybltxt);

		}catch(NoSuchElementException e){
			ATUReports.add("SyblText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("SyblText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getPageindicator() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Pageindicator);

		}catch(NoSuchElementException e){
			ATUReports.add("PageIndicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("PageIndicator element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
