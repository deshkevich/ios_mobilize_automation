package utility;

import java.io.IOException;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import jxl.Sheet;

public class Read_Crop_Details extends Thread {

	private Sheet sh;
	private ExcelUtils eu ;
	public String lower_threshold, upper_threshold, chilling_threshold,crop,variety,gddtarget;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Crop_Details");

			lower_threshold = eu.getCellData(sh, 1, 0);
			System.out.println("lower_threshold"+lower_threshold);

			upper_threshold = eu.getCellData(sh, 1, 1);
			System.out.println("upper_threshold "+upper_threshold);

			chilling_threshold = eu.getCellData(sh, 1, 2);
			System.out.println("chilling_threshold"+chilling_threshold);
			
			crop=eu.getCellData(sh, 1, 3);
			System.out.println("crop"+crop);
			
			variety=eu.getCellData(sh, 1, 4);
			System.out.println("variety"+variety);
			gddtarget=eu.getCellData(sh, 1, 5);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}