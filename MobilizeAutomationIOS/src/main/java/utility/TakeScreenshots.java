package utility;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class TakeScreenshots {

	//public static IOSDriver wd;

	public void takeScreenShotAsJPG(IOSDriver driver) throws IOException{
		//wd=p.getInstance();
		System.out.println("Driver "+driver);
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		String fileName = UUID.randomUUID().toString();
		File targetFile = new File("/Users/sasiswetha/Documents/workspace/MasterLink_Hon/Screenshots/" + fileName+".jpg");
		//FileUtils.copyFile(scrFile,targetFile);
		System.out.println("Screen shot done");
	}

}

