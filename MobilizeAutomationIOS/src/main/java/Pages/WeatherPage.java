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

public class WeatherPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public WeatherPage(AppiumDriver driver) {
		
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From WeatherPage Constructor "+ driver);
	}
	private static MobileElement element = null;
	By dailyRainAlertEditWaetherTxt=By.name("Weather");
	By weatherSensorTitle=By.name("WEATHER SENSOR INPUT");
	By weatherSensorBody=By.name("Select the appropriate device and weather station for monitoring weather data.");
	By weatherSensorsDrpDwnItemText=By.name("Davis GroWeather, FARS");
	By nextBtn=By.name("Next");
	By minuteavgOptinalSlider=By.name("SensorSettingScreen_Switch_Type2_Option1");
	By minuteavgTitle=By.name("10-MINUTE AVERAGE WIND ALERT");
	By minuteavgCation=By.name("Alert activated if wind speed average threshold is met for any 10-minute span.");
	By minuteavgTextBx=By.name("SensorSettingValueScreen_ValueField_Type2_Option1");
	By minuteAvgPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option1");
	By minuteAngMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option1");
	By minuteavgTemSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option1");//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIASlider[1]
	By avgWindSpeedTxt=By.name("Average wind speed");
	
	By highWindAlertOptional=By.name("SensorSettingScreen_Switch_Type2_Option2");
	By highWindAlertTitle=By.name("HIGH WIND ALERT");
	By highWindAlertCaption=By.name("Alert activated if wind speed threshold is met at any moment.");
	By highWindAlertTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//By.name("SensorSettingValueScreen_ValueField_Type2_Option2");
	By highWindAlertMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option2");
	By highWindAlertPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option2");
	By highWindAlertSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option2");
	By windSpeedTxt=By.name("Wind speed threshold:");
	By daliyRainOptionalSlider=By.name("SensorSettingScreen_Switch_Type2_Option3");
	By dailyRainTitle=By.name("DAILY RAIN ALERT");
	By dailyRainCaption=By.name("Alert activated if daily rain threshold is met from midnight to midnight.");
	By dailyRainAlertTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//By.name("SensorSettingValueScreen_ValueField_Type2_Option3");
	By dailyRainAlertPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option3");
	By dailyRainAlertMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option3");
	By dailyRainAlertThresholdText=By.name("Daily rain threshold:");
	By daliyRainAlerttemSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option3");
	By highRainAlertOptionalSlider=By.name("SensorSettingScreen_Switch_Type2_Option4");
	By highRainAlertTitle=By.name("HIGH RAIN RATE ALERT");
	By highRainAlertCaption=By.name("Alert activated if rain rate per hour threshold is met.");
	By highRainAlertThresholdTx=By.name("High rain rate threshold:");
	By highRainAlertTxtBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//By.name("SensorSettingValueScreen_ValueField_Type2_Option4");
	By highRainAlertPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option4");
	By highRainAlertMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option4");
	By highRainAlerttemSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option4");
	By highTemOptionalSlider=By.name("SensorSettingScreen_Switch_Type2_Option5");
	By highTemTitle=By.name("HIGH TEMPERATURE ALERT");
	//SensorSettingValueScreen_Slider_Type2_Option6-low
	
	By highTemCaption=By.name("Alert activated if current temperature meets or exceeds threshold.");
	By highTemTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//By.name("SensorSettingValueScreen_ValueField_Type2_Option5");
	By highTemPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option5");
	By highTemMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option5");
	By highTemTemSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option5");
	By highTemThresholdText=By.name("High temperature:");
	By lowTemOptional=By.name("SensorSettingScreen_Switch_Type2_Option6");
	By lowTemTitle=By.name("LOW TEMPERATURE ALERT");
	By lowTemCaption=By.name("Alert activated if current temperature meets or goes below threshold.");
	By lowTemTemTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");//By.name("SensorSettingValueScreen_ValueField_Type2_Option6");
	By lowTemPlusIcon=By.name("SensorSettingValueScreen_PlusButton_Type2_Option6");
	By lowTemMinusIcon=By.name("SensorSettingValueScreen_MinusButton_Type2_Option6");
	By lowTemTemSlider=By.name("SensorSettingValueScreen_Slider_Type2_Option6");
	By lowTemThresholdText=By.name("Low temperature:");
	By completeweatherTitle=By.name("COMPLETE WEATHER SETUP");
	By completeWaetherCaption=By.name("Save the setup to view the weather report. Go back to edit any weather setup setting.");
	By weatherSaveBtn=By.name("Save");
	By saveBtn=By.name("Save");
	//By nextBtn=By.name("Next");
	
	By backbtn = By.name("Back");//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]
	By next_nxt_save_btn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	By nextweather = By.name("Next");
	By editWeather = By.name("Weather");
	 //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]
	By requiretxt = By.name("Required");
	By bodytxt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");
	By titletxt = By.name("WEATHER SENSOR INPUT");
	By minutetitletext = By.name("10-MINUTE AVERAGE WIND ALERT");
			
	By togglebtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
	By devicestxt = By.name("xCube Gateway 1E");//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]
	By sensortxt = By.name("Davis GroWeather, FARS");
	By pageindicator  = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]");
	By devicedropdown = By.id("DISensorSelectionHeaderFooterView0");
	By sensordropdown = By.name("Sensors");
	By optionaltxt = By.name("Optional");
	By mph = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	By thresoldswipe = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAElement[1]");
	By Average_wind_speed  = By.name("Average wind speed threshold:");
	//SensorSettingValueScreen_ValueField_Type2_Option1
	By thresholdtxtfld =By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]"); //By.name("SensorSettingValueScreen_ValueField_Type2_Option1");
	By Wind_speed_threshold = By.name("Wind speed threshold:");
	By 	Daily_rain_threshold = By.name("Daily rain threshold:");
	By in = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	By f = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	By 	High_rain_rate_threshold = By.name("High rain rate threshold:");
	By 	High_temperature = By.name("High temperature:");
	By Low_temperature = By.name("Low temperature:");
	By savebtntxt  = By.name("Save");
	By complete_weather_titletxt = By.name("COMPLETE WEATHER SETUP");
	By complete_weather_body_txt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]");
    By earlyFrostOptionalSlider=By.name("SensorSettingScreen_Switch_Type2_Option1");
    By windalertOptionalSlider = By.name("SensorSettingScreen_Switch_Type2_Option2");
    By skipbtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");   
    By miuteTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
    
    
    
    
    public  MobileElement getlowTemOptional() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(lowTemOptional)));

		}catch(NoSuchElementException e){
			ATUReports.add("lowTemOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("lowTemOptional element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getnextweather() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(nextweather)));

		}catch(NoSuchElementException e){
			ATUReports.add("Next element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Next element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighRainAlertOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlertOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("highRainAlertOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("highRainAlertOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
  public  MobileElement getmiuteTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(miuteTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("miuteTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("miuteTextBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getavgWindSpeedTxt() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(avgWindSpeedTxt)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("avgWindSpeedTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("avgWindSpeedTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
    
    public  MobileElement getminuteavgTemSlider() throws InterruptedException{
  		try{
  			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteavgTemSlider)));

  		}catch(NoSuchElementException e){
  			ATUReports.add("minuteavgTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}catch(TimeoutException e){
  			ATUReports.add("minuteavgTemSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
      
    
   
    public  MobileElement getminuteAngMinusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteAngMinusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("minuteAngMinusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("minuteAngMinusIcon element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
   
    

    
    public  MobileElement getminuteavgTextBx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteavgTextBx)));

		}catch(NoSuchElementException e){
			ATUReports.add("minuteavgTextBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("minuteavgTextBx element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    
    
    public  MobileElement getminuteavgCation() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteavgCation)));

		}catch(NoSuchElementException e){
			ATUReports.add("minuteavgCation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("minuteavgCation element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getminuteavgTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteavgTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("minuteavgTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("minuteavgTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getminuteavgOptinalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteavgOptinalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("minuteavgOptinalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("minuteavgOptinalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getnextBtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(nextBtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("nextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("nextBtn element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getweatherSensorsDrpDwnItemText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(weatherSensorsDrpDwnItemText)));

		}catch(NoSuchElementException e){
			ATUReports.add("weatherSensorsDrpDwnItemText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("weatherSensorsDrpDwnItemText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getweatherSensorBody() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(weatherSensorBody)));

		}catch(NoSuchElementException e){
			ATUReports.add("weatherSensorBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("weatherSensorBody element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getweatherSensorTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(weatherSensorTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("weatherSensorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("weatherSensorTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    
    public  MobileElement getdailyRainAlertEditWaetherTxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainAlertEditWaetherTxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("dailyRainAlertEditWaetherTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("dailyRainAlertEditWaetherTxt element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    
    public  MobileElement gethighRainAlertPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlertPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement gethighTemPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowTemPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(lowTemPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighTemTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemTemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    public  MobileElement getdaliyRainAlerttemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(daliyRainAlerttemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getdailyRainAlertPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainAlertPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighWindAlertPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highWindAlertPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighWindAlertSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highWindAlertSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getminuteAvgPlusIcon() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minuteAvgPlusIcon)));

		}catch(NoSuchElementException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Increment element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
    public  MobileElement getskipbtn() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(skipbtn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Skip element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Skip element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowTemTemTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(lowTemTemTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("Low Temperature text box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Low Temperature text box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowTemTemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(lowTemTemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Low Temperature Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Low Temperature Slider Alert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighRainAlertTxtBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlertTxtBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Rain Alert Temperature Alert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert Temperature Alert element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement gethighRainAlerttemSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlerttemSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Rain Alert Temperature Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert Temperature Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowTemThresholdText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(lowTemThresholdText)));

		}catch(NoSuchElementException e){
			ATUReports.add("Low Temperature Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Low Temperature Threshold  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getlowTemTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(lowTemTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("Low Temperature Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Low Temperature Title  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighTemTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Temperature Text box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Temperature Text box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighTemThresholdText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemThresholdText)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Temperature Threshold text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Temperature Threshold text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighTemTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Temperature Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert  Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighTemOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highTemOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Temperature Optional Slider text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert Threshold text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighRainAlertThresholdTx() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlertThresholdTx)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Rain Alert Threshold text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert Threshold text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighRainAlertTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highRainAlertTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Rain Alert Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Alert Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getdailyRainAlertTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainAlertTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("Daily Rain Alert Text Box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Daily Rain Alert Text Box element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getdailyRainAlertThresholdText() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainAlertThresholdText)));

		}catch(NoSuchElementException e){
			ATUReports.add("Daily Rain threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Daily Rain threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    public  MobileElement getdailyRainCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("Daily Rain Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Daily Rain Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getdaliyRainOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(daliyRainOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Slider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    public  MobileElement getdailyRainTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(dailyRainTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("Daily Rain Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Daily Rain Title element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighWindAlertTextBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highWindAlertTextBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Wind Alert text box  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Wind Alert text box  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement gethighWindAlertCaption() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highWindAlertCaption)));

		}catch(NoSuchElementException e){
			ATUReports.add("High Wind Alert Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Wind Alert Caption element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    public  MobileElement getwindalertOptionalSlider() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(windalertOptionalSlider)));

		}catch(NoSuchElementException e){
			ATUReports.add("earlyFrostOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("earlyFrostOptionalSlider element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	public  MobileElement getftxt() throws InterruptedException{
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

	public  MobileElement getcomplete_weather_titletxt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(complete_weather_titletxt);

		}catch(NoSuchElementException e){
			ATUReports.add("CompleteWeatherTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("CompleteWeatherTitle element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getcomplete_weather_body_txt() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(complete_weather_body_txt);

		}catch(NoSuchElementException e){
			ATUReports.add("WeatherBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("WeatherBodyText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getBackButton() throws InterruptedException{
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
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(next_nxt_save_btn)));

		}catch(NoSuchElementException e){
			ATUReports.add("Save Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Save Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getEditweather() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(editWeather)));

		}catch(NoSuchElementException e){
			ATUReports.add("EditWeather element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("EditWeather element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

	public  MobileElement getminutetitletext() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(minutetitletext)));

		}catch(NoSuchElementException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getTitletxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(titletxt)));

		}catch(NoSuchElementException e){
			ATUReports.add("TitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TitleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement gethighWindAlertTitle() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(highWindAlertTitle)));

		}catch(NoSuchElementException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Title Text element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getTogglebtn() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(togglebtn);

		}catch(NoSuchElementException e){
			ATUReports.add("Toggle Button element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Toggle Buton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getDevicestxt() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(devicestxt)));

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
			element  = (MobileElement) driver.findElement(devicedropdown);

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
			element  = (MobileElement) driver.findElement(sensordropdown);

		}catch(NoSuchElementException e){
			ATUReports.add("Sensor Drop down element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Sensor Drop down element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getmph() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(mph);

		}catch(NoSuchElementException e){
			ATUReports.add("MPH element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("MPH element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getthresoldswipe() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(thresoldswipe);

		}
		catch(NoSuchElementException e){
			ATUReports.add("ThresholdSwipe element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("ThresholdSwipe element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getAverage_wind_speed() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Average_wind_speed);

		}catch(NoSuchElementException e){
			ATUReports.add("Average Wind Speed element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Average Wind Speed element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getthresholdtxtfld() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(thresholdtxtfld);

		}catch(NoSuchElementException e){
			ATUReports.add("Threshold Text Field element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Threshold Text Field element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getWind_speed_threshold() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Wind_speed_threshold);

		}catch(NoSuchElementException e){
			ATUReports.add("Wind Speed Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Wind Speed Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getDaily_rain_threshold() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Daily_rain_threshold);

		}catch(NoSuchElementException e){
			ATUReports.add("Daily Rain Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("Daily Rain Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getin() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(in);

		}catch(NoSuchElementException e){
			ATUReports.add("GetIN element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("GetIN element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getHigh_rain_rate_threshold() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(High_rain_rate_threshold);

		}catch(NoSuchElementException e){
			ATUReports.add("High Rain Rate Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("High Rain Rate Threshold element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement getHigh_temperature() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(High_temperature);

		}catch(NoSuchElementException e){
			ATUReports.add("HighTemperature element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("HighTemperature element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public  MobileElement getLow_temperature() throws InterruptedException{
		try{
			element  = (MobileElement) driver.findElement(Low_temperature);

		}catch(NoSuchElementException e){
			ATUReports.add("LowTemperature element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("LowTemperature element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
