package utility;

import java.io.IOException;

import jxl.Sheet;

public class ReadViewName extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public static String viewName ;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile("/Users/shiva/Documents/Workspace/Mobilize/src/dependencies/TestData2.xls","ViewName");
			viewName = eu.getCellData(sh,1,1);
			System.out.println("view Name from the Readview Name :"+viewName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
