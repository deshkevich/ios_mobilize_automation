package utility;

import jxl.Sheet;

public class Read_Delete_Viewname extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public String newviewname;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Delete_ViewName");

			newviewname = eu.getCellData(sh, 1, 1);
			System.out.println("newviewname"+newviewname);

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
