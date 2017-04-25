package utility;

import jxl.Sheet;

public class Read_Frost_Details extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public String device ,sensor, frost_threshold_temp, early_frost_warning,uniquefrostname;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Frost_Details");

			device = eu.getCellData(sh, 1, 1);
			System.out.println("device"+device);

			sensor = eu.getCellData(sh, 2, 1);
			System.out.println("sensor "+sensor);

			frost_threshold_temp = eu.getCellData(sh, 3, 2);
			System.out.println("frost_threshold_temp"+frost_threshold_temp);

			early_frost_warning = eu.getCellData(sh, 3, 3);
			System.out.println("early_frost_warning"+early_frost_warning);
			
			uniquefrostname = eu.getCellData(sh, 1, 4);
			System.out.println("uniquefrostname"+uniquefrostname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
