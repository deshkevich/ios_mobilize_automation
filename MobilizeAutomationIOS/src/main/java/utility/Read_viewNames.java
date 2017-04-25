package utility;

import jxl.Sheet;

public class Read_viewNames extends Thread{
	private Sheet sh;
	private ExcelUtils eu ;
	public String view_name;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Delete_ViewName");

			view_name = eu.getCellData(sh, 1, 1);
			System.out.println("view_name"+view_name);

			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
