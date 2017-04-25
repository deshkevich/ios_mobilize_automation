package utility;

import jxl.Sheet;

public class Read_Irrigation_Details extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public String device ,sensor, saturation_threshold, wilting_threshold, early_waring_threshold, low_ec_threshold, high_ec_threshold,irrigationreportname;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Irrigation_Details");

			device = eu.getCellData(sh, 1, 1);
			//System.out.println("device"+device);

			sensor = eu.getCellData(sh, 2, 1);
			//System.out.println("sensor "+sensor);

			saturation_threshold = eu.getCellData(sh, 3, 2);
			//System.out.println("saturation_threshold"+saturation_threshold);

			wilting_threshold = eu.getCellData(sh, 3, 3);
			//System.out.println("wilting_threshold"+wilting_threshold);


			early_waring_threshold = eu.getCellData(sh, 3, 4);
			//System.out.println("early_waring_threshold"+early_waring_threshold);

			low_ec_threshold= eu.getCellData(sh, 3, 5);
			//System.out.println("low_ec_threshold"+low_ec_threshold);

			high_ec_threshold= eu.getCellData(sh, 3, 6);
			//System.out.println("high_ec_threshold"+high_ec_threshold);
			
			//Irrigation name
			irrigationreportname=eu.getCellData(sh, 3, 7);	
			System.out.println("irrigationreportname"+irrigationreportname);




		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





}
