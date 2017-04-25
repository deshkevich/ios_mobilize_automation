package utility;

import java.io.IOException;

import jxl.Sheet;

public class ReadNewUserDetails extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public String emaiID ,invalidusername ,username, Invalid_password, weak_password, good_password, Strong_password, Confirm_password;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"NewUserDetails");


			emaiID = eu.getCellData(sh, 3, 0);
			System.out.println("emai ID "+emaiID);

			invalidusername = eu.getCellData(sh, 3, 1);
			System.out.println("invalidusername"+invalidusername);

			username = eu.getCellData(sh, 3, 2);
			System.out.println("UserName "+username);

			Invalid_password = eu.getCellData(sh, 3, 3);
			System.out.println("Invalid_password"+Invalid_password);

			weak_password = eu.getCellData(sh, 3, 4);
			System.out.println("weak_password"+weak_password);

			good_password = eu.getCellData(sh, 3, 5);
			System.out.println("good_password"+good_password);


			Strong_password = eu.getCellData(sh, 3, 6);
			System.out.println("Strong_password"+Strong_password);


			Confirm_password  = eu.getCellData(sh, 3, 7);
			System.out.println("Confirm_password"+Confirm_password);


			//System.out.println(" From 1 and 1 "+eu.getCellData(sh, 1, 1));
			//System.out.println(" From 1 and 0 "+eu.getCellData(sh, 1, 0));
			/*username_good = eu.getCellData(sh, 2, 1);
			System.out.println("UserName "+username_good);

			password_good = eu.getCellData(sh, 2, 2);
			System.out.println(password_good);
			 */


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
