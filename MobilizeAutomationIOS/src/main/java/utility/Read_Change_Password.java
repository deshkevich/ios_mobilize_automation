package utility;

import java.io.IOException;

import jxl.Sheet;

public class Read_Change_Password extends Thread{


	private Sheet sh;
	private ExcelUtils eu ;
	public String currentpassword, newpassword ,confimpassword ,wrongcurpassword, wrongnewpassword ,wrongconfirmpassword,usernamec ,wrngusername;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile("/Users/swathi/Desktop/Mobilize-new-ioS/src/dependencies/TestData2.xls","ChangePassword");
			usernamec = eu.getCellData(sh, 1, 1);
			currentpassword = eu.getCellData(sh,1,2);
			newpassword = eu.getCellData(sh, 1, 3);
			confimpassword = eu.getCellData(sh, 1, 4);
			
			System.out.println("usernamec"+usernamec);
			System.out.println("Current Password"+currentpassword);
			System.out.println("New Password"+newpassword);
			System.out.println("confim password"+confimpassword);

			wrngusername = eu.getCellData(sh, 2, 1);
			wrongcurpassword = eu.getCellData(sh, 2, 2);
			wrongnewpassword = eu.getCellData(sh,2,3);
			wrongconfirmpassword = eu.getCellData(sh,2,4);
			
			System.out.println("wrngusername"+wrngusername);
			System.out.println("wrongcurpassword"+wrongcurpassword);
			System.out.println("wrongnewpassword"+wrongnewpassword);
			System.out.println("wrongconfirmpassword"+wrongconfirmpassword);

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
