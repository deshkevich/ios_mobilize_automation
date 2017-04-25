package utility;
import java.io.IOException;

import jxl.Sheet;


public class ReadDeviceConfiguration extends Thread{

	public static String PlatformName, platformVersion, DeviceName, bundleId, UDID;
	public String Applicationpath;
	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();

	public void run() {

		try {
			int row = Integer.parseInt(System.getProperty("Device","1"));
			sh =  eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Device_configuration");
			System.out.println("row No: "+row);
			PlatformName = eu.getCellData(sh,row,0);
			platformVersion = eu.getCellData(sh,row,1);
			DeviceName = eu.getCellData(sh,row,2);
			System.out.println("Device Name:"+DeviceName);
			Applicationpath = eu.getCellData(sh,row,4)	;
			System.out.println("Applicationpath:"+Applicationpath);
			UDID = eu.getCellData(sh,row, 5);
			bundleId = eu.getCellData(sh, row, 3);
			System.out.println("Bundle ID:"+bundleId);

			//	lmwidth = Integer.parseInt(eu.getCellData(sh,1,2));

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
