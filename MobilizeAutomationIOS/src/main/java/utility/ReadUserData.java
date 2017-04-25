package utility;

import jxl.Sheet;

public class ReadUserData extends Thread{

	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();
	public String sUserName ,sPassword, Firstname, emailid,username,searchData,existingEmail,InvalidEmail,usernmaeTwo;
	
	public void run() {

		try {

			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"UserData");
			System.out.println("sheett :"+ sh);
			sUserName = eu.getCellData(sh,3,1);
			sPassword = eu.getCellData(sh,3,2);
			searchData=eu.getCellData(sh, 12, 1);
			Firstname = eu.getCellData(sh, 11, 1);
			emailid = eu.getCellData(sh, 11, 2);
			username=eu.getCellData(sh, 11, 3);
			existingEmail=eu.getCellData(sh, 11, 5);
			InvalidEmail=eu.getCellData(sh, 11, 6);
			usernmaeTwo=eu.getCellData(sh,3,4);

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
