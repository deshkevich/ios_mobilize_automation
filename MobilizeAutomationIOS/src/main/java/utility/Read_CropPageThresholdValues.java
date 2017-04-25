package utility;

import jxl.Sheet;

public class Read_CropPageThresholdValues extends Thread {

	private Sheet sh;
	private ExcelUtils eu ;
	public String crop_Gdd_Min,crop_Gdd_OutOfRange,crop_Gdd_Max,low_TempF_Min,low_TempF_OutOfRange,low_TempF_Max,upper_TempF_Min,upper_TempF_OutOfRange,upper_Temp_MaxF,
	low_TempC_Min,low_TempC_OutOfRange,low_TempC_Max,upper_TempC_Min,upper_TempC_OutOfRange,upper_TempC_Max,chilling_Target_Min,chilling_Target_Max,chilling_Target_OutOfRange;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"CropPageThresholdValues");
			
			
			crop_Gdd_Min=eu.getCellData(sh, 1,1);			
			crop_Gdd_OutOfRange=eu.getCellData(sh, 1,2);		
			crop_Gdd_Max=eu.getCellData(sh, 1,3);
			
			low_TempF_Min=eu.getCellData(sh, 2,1);		
			low_TempF_OutOfRange=eu.getCellData(sh, 2,2);		
			low_TempF_Max=eu.getCellData(sh, 2,3);
			
			upper_TempF_Min=eu.getCellData(sh, 3,1);
			upper_TempF_OutOfRange=eu.getCellData(sh, 3,2);
			upper_Temp_MaxF=eu.getCellData(sh, 3,3);
			
			low_TempC_Min=eu.getCellData(sh, 2,5);
			low_TempC_OutOfRange=eu.getCellData(sh, 2,6);				
			low_TempC_Max=eu.getCellData(sh, 2,7);
			
			upper_TempC_Min=eu.getCellData(sh, 3,5);
			upper_TempC_OutOfRange=eu.getCellData(sh, 3,6);
			upper_TempC_Max=eu.getCellData(sh, 3,7);
			
			chilling_Target_Min=eu.getCellData(sh, 4,1);
			chilling_Target_OutOfRange=eu.getCellData(sh, 4,2);
			chilling_Target_Max=eu.getCellData(sh, 4,3);
			
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
