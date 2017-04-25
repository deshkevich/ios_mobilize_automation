package functional_testcases;

import functional_testcases.TestAppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FontSize {
	
	
	private IOSDriver driver;

	//MobileElement element = (MobileElement) loginPage.gettitle(); 
	//WebDriver element1 = element.getWrappedDriver();
	//String color = ((WebElement) element1).getCssValue(title);
	//System.out.println(color);
	//The size of the login button 
	//MobileElement login_button = (MobileElement) loginPage.getLogintxt();
	//System.out.println("Size of the login button : "+login_button.getSize());

	//The size of the login button 
	//MobileElement login_button = (MobileElement) loginPage.getLogintxt();
	//System.out.println("Size of the login button : "+login_button.getSize());
	//Reporter.log("<a href=\"#\">My Logs using TestNG Reporter</a>");
	//ATUReports.add("<a href=\"#\">My Logs using ATU Reporter</a>", true);
	//ATUReports.add("atu.reports.configurationreports",true );
	
	@Test
    public void testSize() {
		
		driver = (IOSDriver) TestAppiumDriver.getAppiumDriver(); 
		Dimension text1 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")).getSize();
        Dimension text2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]")).getSize();
        System.out.print("text1.width"+text1.width+"text1.width"+text2.width);
        System.out.print("text1.height"+text1.height+"text1.height"+text2.height);

       String value=  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")).getAttribute("value");
       System.out.print("value"+value);
       String enabled = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")).getAttribute("enabled");
       System.out.println("enabled"+enabled);
       String wer = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]")).getTagName();
       System.out.println("wer"+wer);
      String dfdg =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")).getAttribute("type");
      System.out.println("Type"+dfdg);

       String content1 = driver.getContext();
       System.out.println("content1"+content1);

       
      //  driver.findElementByIosUIAutomation(using)
       // Assert.assertEquals(text1.getWidth(), text2.getWidth());
      //  Assert.assertEquals(text1.getHeight(), text2.getHeight());
    }
	/*@Test
	private Point testfontsize(WebElement element) {

	      Point upperLeft = element.getLocation();
	      Dimension dimensions = element.getSize();
	      return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);
	    }*/
}
